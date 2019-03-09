import { Component, OnInit } from '@angular/core';
import { DropDownService } from 'src/app/service/drop-down.service';

@Component({
  selector: 'plm-dropdown-parameter',
  templateUrl: './dropdown-parameter.component.html',
  styleUrls: ['./dropdown-parameter.component.css']
})
export class DropdownParameterComponent implements OnInit {

  public dropdownValues: any;

  public newValues = {};

  constructor(private dropDownService: DropDownService) { }

  ngOnInit() {
    this.reloadDropDownValue();
  }

  reloadDropDownValue() {
    this.dropDownService.getDropDownValues().subscribe(dropDownValues => this.dropdownValues = dropDownValues);
  }

  addValue(key: string, values: any[]) {
    const newValue = this.newValues[key];
    if (newValue) {
      console.log(values);
      const maxOrder = values.reduce((value1, value2) => ({ 'order': Math.max(value1.order, value2.order) }), { 'order': 0 });
      console.log(maxOrder);
      const value = this.newValues[key];
      this.dropDownService.addDropdownValue(key, value, maxOrder.order + 1)
        .subscribe((dropdownValue) => { values.push(dropdownValue); this.newValues[key] = undefined; });
    }
  }

  deleteValue(id: number) {
    this.dropDownService.deleteValue(id).subscribe(res => this.reloadDropDownValue());
  }
}
