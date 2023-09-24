import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ApolicesComponent } from './apolices.component';

const routes: Routes = [{ path: '', component: ApolicesComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ApolicesRoutingModule { }
