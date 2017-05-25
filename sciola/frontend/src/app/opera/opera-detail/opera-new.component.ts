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
import { FileUploader, FileItem } from 'ng2-file-upload';
import { environment } from '../../../environments/environment';

import { OperaDetailComponent } from './opera-detail.component';


import 'rxjs/add/operator/switchMap';

declare var Materialize: any;

@Component({
    moduleId: module.id,
    selector: 'opera-detail',
    templateUrl: './opera-detail.component.html'
})

export class OperaNewComponent extends OperaDetailComponent implements OnInit {
    isLocked(): any {
        return this.canEdit ? null : true;
    }

    onSave(): void {
        console.log("Opera-Service: Sono nella onSave")
        this.operaService
            .addOpera(this.opera)
            .then(opera => this.handleSuccessfulServiceCall(this))
            .catch(error => this.handleFailedServiceCall(this, error));
    }


    ngOnInit(): void {
        this.canEdit = true;
        this.opera = Opera.empty();

        let mediaUploadApiPath = `${environment.apiBasePath}/opera/${this.opera.id}/multimedia`;        

        this.initializeMaterialList();
        this.initializeCategoryList();
        this.getCurrentPosition();

        $(document).ready(function () {
            Materialize.updateTextFields();
        });
    }
}
