import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContractsComponent } from './pages/contracts/contracts.component';
import { NewHotelComponent } from './pages/new-hotel/new-hotel.component';
import {NewcontractComponent} from './pages/newcontract/newcontract.component';
import {SearchComponent} from './pages/search/search.component';


const routes: Routes = [
  {path: '', component: SearchComponent},
  {path: 'hotels', component: NewHotelComponent},
  {path: 'contracts', component: ContractsComponent},
  {path: 'addcontract', component: NewcontractComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
