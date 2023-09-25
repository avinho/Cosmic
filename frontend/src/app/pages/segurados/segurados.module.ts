import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { SeguradosRoutingModule } from './segurados-routing.module';
import { SeguradosComponent } from './segurados.component';


@NgModule({
  declarations: [
    SeguradosComponent
  ],
  imports: [
    CommonModule,
    SeguradosRoutingModule,
    HttpClientModule
  ]
})
export class SeguradosModule { }
