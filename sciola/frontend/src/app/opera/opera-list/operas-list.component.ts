import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Opera } from '../model/opera';

@Component({
  moduleId: module.id,
  selector: 'operas-list',
  templateUrl: './operas-list.component.html'
})

export class OperasListComponent {
  @Input()
  private operas: Opera[];

  constructor(
    private router: Router
  ){}  

  gotoDetail(id: number): void{
    console.log(`navigating to detail/${id}`);
    this.router.navigate(['detail', id]);
  }  
}
