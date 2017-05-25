import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OperasBaseComponent } from './opera/opera-list/operas-base.component';
import { OperaDetailComponent } from './opera/opera-detail/opera-detail.component';
import { OperaNewComponent } from './opera/opera-detail/opera-new.component';
import { NavBarComponent } from './shared/nav-bar.component';
import { OperaDetailResolver } from './opera/shared/opera-resolver.service';

const routes: Routes = [
  { path: 'operas', component: OperasBaseComponent },
  { path: 'operas/new', component: OperaNewComponent },
  { path: 'detail/:id', component: OperaDetailComponent, resolve: { opera: OperaDetailResolver } },  
  { path: '', redirectTo: '/operas', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [OperaDetailResolver]
})

export class AppRoutingModule { }
