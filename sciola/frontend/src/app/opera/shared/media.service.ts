import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import { Media, MultimediaStream } from '../model/media';
import { BaseService } from './base.service';

import { environment } from '../../../environments/environment';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class MediaService extends BaseService{    

    private getMediaUrl(operaId: string, mediaId: string = null): string {
        let path = environment.apiBasePath + `opera/${operaId}/multimedia`;

        if (mediaId) { path += `/${mediaId}`; }
        return path;
    }    

    getMEdia(operaId: string, mediaId: string): Promise<MultimediaStream> {
        let path = this.getMediaUrl(operaId, mediaId);
        return this.http
            .get(path)
            .toPromise()
            .then(response => response.json() as MultimediaStream)
            .catch(error => this.handleError(path, error));
    }

    addMedia(operaId: string, mediaType: string, contentBase64: string): Promise<Media> {
        let path = this.getMediaUrl(operaId);
        let media = {
            id: "",
            stream: contentBase64,
            item: {
                id: "",
                type: "photo"
            } as Media
        } as MultimediaStream;

        return this.http
            .post(path, JSON.stringify(media), { headers: this.headers })
            .toPromise()
            .then(response => {
                let location = response.headers.get("Location");
                console.log(`backend gave back: ${location}`);
                let chunks = location.split('/');
                let mediaId = chunks[chunks.length - 1];
                return {
                    id: mediaId,
                    type: "photo"
                } as Media;
            })
            .catch(error => this.handleError(path, error));
    }

    deleteMedia(operaId: string, mediaId: string): Promise<string> {
        let path = this.getMediaUrl(operaId, mediaId);
        return this.http
            .delete(path)
            .toPromise()
            .then(response => mediaId)
            .catch(error => this.handleError(path, error));
    }

    getImageUrl(mediaId: string): string {
        return `http://sciola.datinanta.org:8086/images/${mediaId}`;        
    }
}