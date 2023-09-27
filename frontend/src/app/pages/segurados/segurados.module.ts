import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import { SeguradosRoutingModule } from './segurados-routing.module';
import { SeguradosComponent } from './segurados.component';


@NgModule({
  declarations: [
    SeguradosComponent
  ],
  imports: [
    CommonModule,
    SeguradosRoutingModule
  ]
})
export class SeguradosModule { }
