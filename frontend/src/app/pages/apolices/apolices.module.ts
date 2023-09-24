import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ApolicesRoutingModule } from './apolices-routing.module';
import { ApolicesComponent } from './apolices.component';


@NgModule({
  declarations: [
    ApolicesComponent
  ],
  imports: [
    CommonModule,
    ApolicesRoutingModule
  ]
})
export class ApolicesModule { }
