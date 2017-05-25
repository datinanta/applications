import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Opera, OperaPreview } from '../model/opera';
import { MediaService } from '../shared/media.service';
import { SebmGoogleMap } from 'angular2-google-maps/core';

@Component({
    moduleId: module.id,
    selector: 'operas-map',
    templateUrl: './operas-map.component.html',
    styleUrls: ['./operas-map.component.css']
})

export class OperasMapComponent implements OnInit {
    @Input()
    private operas: Opera[];
    private operaPreviews: OperaPreview[];
    @ViewChild(SebmGoogleMap) map: SebmGoogleMap;
    
    private lat: number = 39.3580605;
    private lng: number = 9.0002051;
    private initZoom: number = 15;
    private showUI: boolean = false;

    constructor(
        private router: Router,
        private mediaService: MediaService
    ) { }

    ngOnInit(): void {
        this.map.disableDefaultUI = true;        
    }

    getOperaRepresentativeImageUrl(opera: Opera): string {
        if(opera.medias && opera.medias.length > 0){
            let mediaId = opera.medias[0].id;
            return this.mediaService.getImageUrl(mediaId);
        }else{
            return this.mediaService.getImageUrl("f6c5b455-40ed-4ff6-a437-2967902f00c3");
        }
    }

    gotoDetail(id: number): void {
        console.log(`navigating to detail/${id}`);
        this.router.navigate(['detail', id]);
    }
}
