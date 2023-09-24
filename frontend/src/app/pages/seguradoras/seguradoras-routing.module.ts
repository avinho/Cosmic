import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SeguradorasComponent } from './seguradoras.component';

const routes: Routes = [{ path: '', component: SeguradorasComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SeguradorasRoutingModule { }
