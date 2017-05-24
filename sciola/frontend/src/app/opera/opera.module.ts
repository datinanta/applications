import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { CommonModule } from '@angular/common';
import { AgmCoreModule } from 'angular2-google-maps/core';
// components
import { OperasBaseComponent } from './opera-list/operas-base.component';
import { OperasListComponent } from './opera-list/operas-list.component';
import { OperasMapComponent } from './opera-list/operas-map.component';
import { OperaNewComponent } from './opera-detail/opera-new.component';
import { OperaDetailComponent } from './opera-detail/opera-detail.component';
import { OperaMediaComponent } from './media/opera-media.component';
// services
import { OperaService } from './shared/opera.service';
import { MediaService } from './shared/media.service';
// directives
import { FileUploadModule } from 'ng2-file-upload';

import { environment } from '../../environments/environment';


@NgModule({
  declarations: [
    OperaDetailComponent,
    OperaMediaComponent,
    OperaNewComponent,
    OperasBaseComponent,
    OperasListComponent,
    OperasMapComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    HttpModule,
    FileUploadModule,
    AgmCoreModule.forRoot(
      { apiKey: environment.googleMapsApiKey }
    )
  ],
  exports: [OperasListComponent, OperaNewComponent, OperaDetailComponent],
  providers: [OperaService, MediaService]
})
export class OperaModule { }
