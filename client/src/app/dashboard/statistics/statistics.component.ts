import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/service/authentication.service';

@Component({
  selector: 'plm-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {

  constructor(private authenticationService:AuthenticationService) { }

  ngOnInit() {
  }

  downloadYoungAccompanyingStatistics(){
    var token:string= this.authenticationService.getToken();
    window.open("/api/export/csv/young/accompanying?token="+token);
  }



  downloadYoungAwarenessStatistics(){
    var token:string= this.authenticationService.getToken();
    window.open("/api/export/csv/young/awareness?token="+token);
  }

  downloadAwarenessStatistics(){
    var token:string= this.authenticationService.getToken();
    window.open("/api/export/csv/awareness?token="+token);
  }
}
