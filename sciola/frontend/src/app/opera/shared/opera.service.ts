import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import { OperaCategory } from '../model/opera-category'
import { OperaMaterial } from '../model/opera-material'
import { OperaSizes } from '../model/opera-sizes';
import { GpsPoint } from '../model/gps-point';
import { Opera } from '../model/opera';
import { BaseService } from './base.service';

import { environment } from '../../../environments/environment';

import 'rxjs/add/operator/toPromise';


@Injectable()
export class OperaService extends BaseService{

    private getOperaUrl(id: string = null): string {
        let path = environment.apiBasePath + `operas`;

        if (id) { path += `/${id}`; }
        return path;
    }    

    getOperas(): Promise<Opera[]> {
        let path = this.getOperaUrl();
        let headers = new Headers({ "Content-Type": "application/json" });

        return this.http
            .get(path)
            .toPromise()
            .then(response => response.json() as Opera[])
            .catch(error => this.handleError(path, error));
    }

    getOpera(id: string): Promise<Opera> {
        let path = this.getOperaUrl(id);

        return this.http
            .get(path)
            .toPromise()
            .then(response => response.json() as Opera)
            .catch(error => this.handleError(path, error));
    }

    addOpera(opera: Opera): Promise<String> {
        let path = this.getOperaUrl();
        return this.http
            .post(path, JSON.stringify(opera), { headers: this.headers })
            .toPromise()
            .then(response => response.headers.get("Location"))
            .catch(error => this.handleError(path, error));
    }

    updateOpera(opera: Opera): Promise<Opera> {
        let path = this.getOperaUrl(opera.id);
        return this.http
            .put(path, JSON.stringify(opera), { headers: this.headers })
            .toPromise()
            .then(response => opera)
            .catch(error => this.handleError(path, error));
    }
}