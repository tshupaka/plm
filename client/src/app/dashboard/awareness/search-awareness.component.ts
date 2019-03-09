import { Component, OnInit } from '@angular/core';
import { Awareness } from 'src/app/model/awareness.model';
import { AwarenessService } from 'src/app/service/awareness.service';
import { Router } from '@angular/router';

@Component({
  selector: 'plm-search-awareness',
  templateUrl: './search-awareness.component.html',
  styleUrls: ['./search-awareness.component.css']
})
export class SearchAwarenessComponent implements OnInit {



  private awarenesses: Awareness[];
  private awarenessSearch: string;

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

}
