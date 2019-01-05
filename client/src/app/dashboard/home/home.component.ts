import { Component, OnInit } from '@angular/core';
import { Young } from 'src/app/model/young.model';
import { YoungService } from 'src/app/service/young.service';
import { Router } from '@angular/router';
import { FormControl } from '@angular/forms';

import { debounceTime } from 'rxjs/operators';
import { Awareness } from 'src/app/model/awareness.model';
import { AwarenessService } from 'src/app/service/awareness.service';

@Component({
  selector: 'plm-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  private youngs: Young[];
  private awarenesses: Awareness[];
  private youngSearch: FormControl = new FormControl();
  private awarenessSearch: string;

  constructor(private youngService: YoungService, private awarenessService: AwarenessService, private router: Router) { }

  ngOnInit() {
    this.youngSearch.valueChanges.pipe(debounceTime(200))
      .subscribe((search: string) => this.searchYoung(search));
    this.awarenessService.getAllAwarenesses().subscribe((awarenesses: Awareness[]) => this.awarenesses = awarenesses);

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

  displayAwareness(awarenessId: number) {
    this.router.navigate(['/dashboard/awareness', awarenessId]);
  }

  addYoung() {
    this.router.navigate(['/dashboard/young']);
  }

}
