import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminSalaryComponent } from './admin-salary.component';

const routes: Routes = [
  { path: '', component: AdminSalaryComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminSalaryRoutingModule { }
