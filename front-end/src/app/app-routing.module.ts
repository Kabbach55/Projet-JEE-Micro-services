import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {FactureComponent} from "./components/facture/facture.component";

const routes: Routes = [

  {path : "facture" , component : FactureComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
