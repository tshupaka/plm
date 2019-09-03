import { Component, OnInit } from '@angular/core';
import { Awareness } from 'src/app/model/awareness.model';
import { AwarenessService } from 'src/app/service/awareness.service';
import { Router } from '@angular/router';
import { Young } from 'src/app/model/young.model';

@Component({
  selector: 'plm-search-awareness',
  templateUrl: './search-awareness.component.html',
  styleUrls: ['./search-awareness.component.css']
})
export class SearchAwarenessComponent implements OnInit {



  public awarenesses: Awareness[];
  public awarenessSearch: string;
  public currentPage = 0;
  public ITEM_PER_PAGE = 10;
  public nbPage = 0;

  constructor(private awarenessService: AwarenessService, private router: Router) { }

  ngOnInit() {
    this.awarenessService.getAllAwarenesses().subscribe((awarenesses: Awareness[]) => this.awarenesses = awarenesses);


  }


  displayAwareness(awarenessId: number) {
    this.router.navigate(['/dashboard/awareness', awarenessId]);
  }

  addAwareness() {
    this.router.navigate(['/dashboard/awareness']);
  }


  getAwarenesses() {
    if (this.awarenesses) {
      const filteredAwarenesses = this.awarenesses.filter((awareness: Awareness, index) =>
        (!this.awarenessSearch || awareness.name.toLowerCase().includes(this.awarenessSearch)));
      console.log(filteredAwarenesses);
      const pagingAwarenesses = filteredAwarenesses.filter((awareness: Awareness, index) =>
        (index >= this.currentPage * this.ITEM_PER_PAGE && index < (this.currentPage + 1) * this.ITEM_PER_PAGE));

      return pagingAwarenesses;
    }
    return [];

  }


  getPageRange() {
    if (this.awarenesses) {
      const pageArray = new Array();
      const awarenessesFiltered = this.awarenesses.filter((awareness: Awareness, index) =>
        (!this.awarenessSearch) || awareness.name.toLowerCase().includes(this.awarenessSearch));
      if (awarenessesFiltered) {
        this.nbPage = Math.ceil(awarenessesFiltered.length / this.ITEM_PER_PAGE);

        for (let i = 0; i < this.nbPage; i++) {
          pageArray[i] = i + 1;
        }

      }
      return pageArray;
    }
    return [];
  }

  changePage(index: number) {
    this.currentPage = index;
  }
}
