import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Opera } from '../model/opera';
import { OperaService } from '../shared/opera.service';


@Component({
  moduleId: module.id,
  selector: 'operas-base',
  templateUrl: './operas-base.component.html'
})

export class OperasBaseComponent implements OnInit {
  private operas: Opera[];
  private showMap: boolean = false;

  constructor(
    private router: Router,
    private operaService: OperaService
  ){}  

  ngOnInit(): void{
      this.operaService
            .getOperas()
            .then(operas => {
              console.log(operas);
              this.operas = operas;
              console.log(this.operas);
            });
  }

  private switchView(): void{
      this.showMap = !this.showMap;
  }

  private switchViewIcon(): string {
    return this.showMap ? "list" : "map";
  }

  gotoNew(): void{
    console.log("navigating to new Opera");
    this.router.navigate(['operas/new']);
  }
}
