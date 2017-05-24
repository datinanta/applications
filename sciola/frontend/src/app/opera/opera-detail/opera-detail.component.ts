import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { Opera } from '../model/opera';
import { OperaCategory } from '../model/opera-category'
import { OperaMaterial } from '../model/opera-material'
import { OperaService } from '../shared/opera.service';
import { OperaDetailResolver } from '../shared/opera-resolver.service';
import { OperaSizes } from '../model/opera-sizes';
import { GpsPoint } from '../model/gps-point';
import { environment } from '../../../environments/environment';

import '../shared/autocomplete-suggestions';


import 'rxjs/add/operator/switchMap';

declare var Materialize: any;

@Component({
  moduleId: module.id,
  selector: 'opera-detail',
  templateUrl: './opera-detail.component.html'
})

export class OperaDetailComponent implements OnInit {
  @Input()
  protected opera: Opera = Opera.empty();
  protected canEdit: boolean = false;
  protected canShowPosition: boolean = true;

  constructor(
    protected route: ActivatedRoute,
    protected location: Location,
    protected operaService: OperaService
  ) { }

  isLocked(): any {
    return this.canEdit ? null : true;
  }

  onSave(): void {
    this.operaService
      .updateOpera(this.opera)
      .then(result => this.handleSuccessfulServiceCall(this))
      .catch(error => this.handleFailedServiceCall(this, error));
  }

  protected handleSuccessfulServiceCall(self: OperaDetailComponent) {
    self.showToastNotification("I dettagli dell'opera sono stati salvati")
    self.location.back();
  }

  protected handleFailedServiceCall(self: OperaDetailComponent, error: any) {
    self.showToastNotification(`error. ${error}`);
  }

  ngOnInit(): void {
    this.route.data
      .subscribe((data: { opera: Opera }) => {
        console.log(`wow, the opera is here. ${data.opera.material}`)
        this.opera = data.opera;
      });

    this.initializeMaterialList();
    this.initializeCategoryList();
    $(document).ready(function () {
      Materialize.updateTextFields();
    });

  }

  protected getCurrentPosition() {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(
        position => this.setPosition(this, position),
        error => this.geoLocalizationErrorHandler(this, error),
        { enableHighAccuracy: true } as PositionOptions)
    } else {
      this.showToastNotification("Impossibile trovare la posizione. Prova un altro browser.")
    }
  }

  protected setPosition(self: OperaDetailComponent, position: Position): void {
    self.opera.position = { lat: position.coords.latitude, lon: position.coords.longitude } as GpsPoint;
    self.canShowPosition = true;
    Materialize.updateTextFields();
  }

  protected updatePosition(): void {
    if (this.canEdit) { this.getCurrentPosition(); }
  }

  protected geoLocalizationErrorHandler(self: OperaDetailComponent, error: PositionError): void {
    switch (error.code) {
      case error.PERMISSION_DENIED:
        self.showToastNotification("Autorizza la geolocalizzazione indicare la posizione dell'opera");
        break;
      case error.POSITION_UNAVAILABLE:
      case error.TIMEOUT:
        self.showToastNotification("Non è stato possibile recuperare la tua posizione, riprova");
        break;
    }
  }

  protected showToastNotification(text: string): void {
    Materialize.toast(text, 4000);
  }

  protected initializeMaterialList() {
    (<any>$("input[id='ac-material']")).autocomplete({
      data: {
        "Legno": null,
        "Ferro": null,
        "Basalto": null,
        "Granito": null,
        "Calcare": null,
        "Roccia": null,
        "Tela": null
      },
      limit: 3, // The max amount of results that can be shown at once. Default: Infinity.      
    });
  }
  protected initializeCategoryList() {
    (<any>$("input[id='ac-category']")).autocomplete({
      data: {
        "PietraSonora": null,
        "Murales": null,
        "Quadro": null,
        "Intaglio": null,
        "Bassorilievo": null,
        "Scultura": null,
        "Murale": null
      },
      limit: 3, // The max amount of results that can be shown at once. Default: Infinity.
    });
  }
}
