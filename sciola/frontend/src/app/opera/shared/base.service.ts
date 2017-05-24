import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

@Injectable()
export class BaseService {

    protected headers = new Headers({ 'Content-Type': 'application/json' });

    constructor(protected http: Http) { }

    protected handleError(calledUrl: string, error: any): Promise<any> {
        console.error('An error occurred while calling' + calledUrl, error);
        return Promise.reject(error.message || error);
    }    
}