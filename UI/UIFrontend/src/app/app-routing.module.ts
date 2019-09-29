import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerSearchComponent } from './customer-search/customer-search.component';
import { CustomerUpdateComponent } from './customer-update/customer-update.component';
import { CustomerDeleteComponent } from './customer-delete/customer-delete.component';
import { CustomerAddComponent } from './customer-add/customer-add.component';

const routes: Routes = [
  {path: 'add', component:CustomerAddComponent},
  {path: 'all', component:CustomerListComponent},
  {path: 'search', component:CustomerSearchComponent},
  {path: 'update/:id', component:CustomerUpdateComponent},
  {path: 'delete/:id', component:CustomerDeleteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
