import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SeguradosComponent } from './segurados.component';

const routes: Routes = [{ path: '', component: SeguradosComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SeguradosRoutingModule { }
