import { Component, OnInit } from '@angular/core';
import { DropDownService } from 'src/app/service/drop-down.service';
import { StatisticsService } from 'src/app/service/statistics.service';

@Component({
  selector: 'plm-statistics-dashboard',
  templateUrl: './statistics-dashboard.component.html',
  styleUrls: ['./statistics-dashboard.component.css']
})
export class StatisticsDashboardComponent implements OnInit {

  public dropDownValues: Object;
  public geographicFocusStatusValues: any;
  public foundingStatusValues: any;
  public yearsStatusValues = [];
  public geographicFocusValues = {}
  public foundingValues = {}
  public yearsValues = {};
  public selectAllGeofocus: boolean;
  public selectAllFounding: boolean;
  public selectAllYears: boolean;


  public genderGraphAccompanying: any;
  public qpvGraphAccompanying: any;
  public educationLevelGraphAccompanying: any;

  public genderGraphAwareness: any;
  public qpvGraphAwareness: any;

  public nbAccompanying = 0;
  public nbAwarenesses = 0;

  constructor(private dropDownService: DropDownService, private statisticsService: StatisticsService) { }

  ngOnInit() {
    this.initDropDownValue();
  }

  initDropDownValue() {
    this.dropDownService.getDropDownValues().subscribe((dropDownValues: any) => {
      this.dropDownValues = dropDownValues.reduce(
        (map, dropDownValue) => { map[dropDownValue['key']] = dropDownValue['values']; return map; }, {});

      this.geographicFocusStatusValues = this.getDropDownValues('geographicFocus');

      this.geographicFocusStatusValues.unshift({ 'id': -1, 'value': '(vide)' });
      this.geographicFocusStatusValues.forEach(geoFocus => {
        this.geographicFocusValues[geoFocus.id] = false;
      });
      this.foundingStatusValues = this.getDropDownValues('founding');
      this.foundingStatusValues.unshift({ 'id': -1, 'value': '(vide)' });
      this.foundingStatusValues.forEach(founding => {
        this.foundingValues[founding.id] = false;
      });

      const currentDate = new Date();
      const currentYear = currentDate.getFullYear();
      this.yearsStatusValues.push({ 'id': -1, 'value': '(vide)' });
      for (let year = 2018; year <= currentYear; year++) {

        this.yearsStatusValues.push({ 'id': year, 'value': year });

        this.yearsValues[year] = false;
      };
    }


    );
    this.genderGraphAccompanying = this.createPieGraph('genderGraphAccompanying');
    this.educationLevelGraphAccompanying = this.createHistoGraph('educationLevelGraphAccompanying');
    this.qpvGraphAccompanying = this.createHistoGraph('qpvGraphAccompanying');

    this.genderGraphAwareness = this.createPieGraph('genderGraphAwareness');
    this.qpvGraphAwareness = this.createHistoGraph('qpvGraphAwareness');
  }
  getDropDownValues(key: string) {
    if (this.dropDownValues) {
      let values = this.dropDownValues[key];
      if (!values) {
        values = [];
      }
      return values;
    }
  }

  onFilterChange(event: any) {
    this.statisticsService
      .getAccompanyingStatistics(this.yearsValues, this.geographicFocusValues, this.foundingValues)
      .subscribe((result: any) => {
        console.log(this.yearsValues);
        let sexList = [];
        let educationLevelList = [];
        let qpvList = [];
        this.nbAccompanying = 0;
        Object.entries(result.sex).forEach(([key, value]) => {
          sexList.push({ "id": key, "value": value });
          this.nbAccompanying += (value as number);

        });
        Object.entries(result.educationLevel).forEach(([key, value]) => educationLevelList.push({ "id": "" + key, "value": "" + value, "percent" : ((value as number)*100/this.nbAccompanying).toFixed(2) }));
        Object.entries(result.qpv).forEach(([key, value]) => qpvList.push({ "id": key, "value": value, "percent" : ((value as number)*100/this.nbAccompanying).toFixed(2) }));

        this.genderGraphAccompanying.dataProvider = sexList;
        this.genderGraphAccompanying.validateData();

        this.educationLevelGraphAccompanying.dataProvider = educationLevelList;
        this.educationLevelGraphAccompanying.validateData();

        this.qpvGraphAccompanying.dataProvider = qpvList;
        this.qpvGraphAccompanying.validateData();

      });
    this.statisticsService.getAwarenessStatistics(this.yearsValues, this.geographicFocusValues)
      .subscribe((result: any) => {
        let sexList = [];
        let qpvList = [];
        this.nbAwarenesses = 0;
        Object.entries(result.sex).forEach(([key, value]) => {
          sexList.push({ "id": key, "value": value });
          this.nbAwarenesses += (value as number);
        });
        Object.entries(result.qpv).forEach(([key, value]) => qpvList.push({ "id": key, "value": value, "percent" : ((value as number)*100/this.nbAwarenesses).toFixed(2) }));

        this.genderGraphAwareness.dataProvider = sexList;
        this.genderGraphAwareness.validateData();


        this.qpvGraphAwareness.dataProvider = qpvList;
        this.qpvGraphAwareness.validateData();
      }
      );

  }

  onSelectAllFocus(event: any) {
    this.geographicFocusStatusValues.forEach(geoFocus => {
      this.geographicFocusValues[geoFocus.id] = this.selectAllGeofocus;
    });
    this.onFilterChange(event);
  }

  onSelectAllFouding(event: any) {
    this.foundingStatusValues.forEach(founding => {
      this.foundingValues[founding.id] = this.selectAllFounding;
    });
    this.onFilterChange(event);
  }

  onSelectAllYears(event: any) {
    this.yearsStatusValues.forEach(years => {
      this.yearsValues[years.id] = this.selectAllYears;
    });
    this.onFilterChange(event);
  }


  createPieGraph(divName: string) {

    return AmCharts.makeChart(divName, {
      "type": 'pie',

      "theme": "light",
      "labelsEnabled": true,
      "valueAxes": [{

      }],
      "valueField": "value",
      "titleField": "id",
      "balloon": {
        "fixedPosition": true
      },
      "labelRadius": -20,
    });

  }


  createHistoGraph(divName: string) {

    return AmCharts.makeChart(divName, {
      'type': 'serial',

      'categoryField': 'id',

      "theme": "light",
      "calculatePercent" : true,

      "valueAxis": {
        "baseValue": 0,
        "autoGridCount": false,
        "axisAlpha": 0,
        "position": "left",

      },
      "valueAxes": [{
        "minimum": 0
      }],
      "categoryAxis": {
        "gridPosition": "start",
        "labelRotation": 45
      },
      "graphs": [{
        "balloonText": "<b>[[category]]: [[value]]([[percent]]%)</b>",
        "fillAlphas": 0.9,
        //"lineAlpha": 0.2,
        "type": "column",
        "valueField": "value"
      }]
    });

  }

}
