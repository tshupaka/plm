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

  private youngs: Young[];
  private youngSearch: FormControl = new FormControl();

  constructor(private youngService: YoungService, private router: Router) { }

  ngOnInit() {
    this.youngSearch.valueChanges.pipe(debounceTime(200))
    .subscribe((search: string) => this.searchYoung(search));

  }



  searchYoung(search: string) {
    console.log(this);
    if (search.length > 2) {
      this.youngService.searchYoung(search).subscribe(youngs => this.youngs = youngs);
    }
  }

  displayYoung(youngId: number) {
    this.router.navigate(['/dashboard/young', youngId]);
  }


  addYoung() {
    this.router.navigate(['/dashboard/young']);
  }

}
