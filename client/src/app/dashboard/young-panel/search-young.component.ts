import { Component, OnInit } from '@angular/core';

import { debounceTime } from 'rxjs/operators';
import { Young } from 'src/app/model/young.model';
import { FormControl } from '@angular/forms';
import { YoungService } from 'src/app/service/young.service';
import { Router } from '@angular/router';

@Component({
  selector: 'plm-search-young',
  templateUrl: './search-young.component.html',
  styleUrls: ['./search-young.component.css']
})
export class SearchYoungComponent implements OnInit {

  public youngs: Young[];

  constructor(private youngService: YoungService, private router: Router) {
  }

  ngOnInit() {
    this.youngService.getAllYoungs().subscribe(youngs => this.youngs = youngs);
  }

  addYoung() {
    this.router.navigate(['/dashboard/young']);
  }


}
