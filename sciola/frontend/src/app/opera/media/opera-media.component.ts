import { Component, Input, OnInit, AfterViewInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { Opera } from '../model/opera';
import { FileUploader, FileItem } from 'ng2-file-upload';
import { MediaService } from '../shared/media.service';
import { MultimediaStream } from '../model/media';
import { environment } from '../../../environments/environment';

import 'rxjs/add/operator/switchMap';

declare var Materialize: any;

@Component({
  moduleId: module.id,
  selector: 'opera-media',
  templateUrl: './opera-media.component.html'
})

export class OperaMediaComponent implements OnInit, AfterViewInit {
  @Input()
  protected opera: Opera = <Opera>{};
  protected images: MultimediaStream[] = [];

  protected uploader: FileUploader;
  protected pendingUploads: { [index: string]: boolean; } = {};

  constructor(
    protected route: ActivatedRoute,
    protected location: Location,
    protected mediaService: MediaService
  ) { }

  removeFile(file: FileItem): void {
    this.uploader.removeFromQueue(file);
  }

  uploadPhotos(): void {

    for (var _i = 0; _i < this.uploader.queue.length; _i++) {
      let fileItem: FileItem = this.uploader.queue[_i];
      let image = fileItem.alias;
      fileItem.isUploading = true;
      this.mediaService
        .addMedia(this.opera.id, "image", image)
        .then(addedMedia => {
          this.opera.medias.push(addedMedia);
          fileItem.isUploading = false;
          fileItem.isUploaded = true;
          console.log(`save with id: ${JSON.stringify(addedMedia)}`);
        })
        .catch(error => this.handleFailedServiceCall(this, error));
    }
  }

  protected handleSuccessfulServiceCall(self: OperaMediaComponent) {
    self.showToastNotification("I dettagli dell'opera sono stati salvati")
    self.location.back();
  }

  protected handleFailedServiceCall(self: OperaMediaComponent, error: any) {
    self.showToastNotification(`error. ${error}`);
  }

  ngAfterViewInit(): void{
    (<any>$('.slider')).slider();
  }

  ngOnInit(): void {

    console.log(`wow, the opera is here. ${JSON.stringify(this.opera)}`)
    let mediaUploadApiPath = `${environment.apiBasePath}/opera/${this.opera.id}/multimedia`;
    this.uploader = new FileUploader({ url: mediaUploadApiPath });

    this.setupPreviewer();

    $(document).ready(function () {      
      (<any>$('.collapsible')).collapsible();      
      $('#fakefileUpload').click(() => {
        $('#fileUpload').click();
      });      
    });    
  }

  private getImageSource(mediaId: string): string{
    //(<any>$('.slider')).slider();
    return this.mediaService.getImageUrl(mediaId);    
  }

  private setupPreviewer(): void {
    console.log(`setting up previewer`);
    this.uploader.onAfterAddingFile = (fileItem: FileItem) => {
      let file: File = fileItem._file;
      console.log(`loading preview`);
      let fileReader: FileReader = new FileReader();
      fileReader.onloadend = (e) => {
        let image = fileReader.result;
        fileItem.alias = image;
      }
      fileReader.readAsDataURL(file);
    }
  }

  protected showToastNotification(text: string): void {
    Materialize.toast(text, 4000);
  }
}
