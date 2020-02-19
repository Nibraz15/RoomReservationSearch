import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ContractsComponent } from './pages/contracts/contracts.component';

import { HttpClientModule } from '@angular/common/http';

import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { NewHotelComponent } from './pages/new-hotel/new-hotel.component';
import {MatTableModule} from "@angular/material/table";
import { NewcontractComponent } from './pages/newcontract/newcontract.component';
import { SearchComponent } from './pages/search/search.component';


@NgModule({
  declarations: [
    AppComponent,
    ContractsComponent,
    NewHotelComponent,
    NewcontractComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    MatTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
