import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminEmpComponent } from './admin-emp.component';

const routes: Routes = [
  { path: '', component: AdminEmpComponent}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminEmpRoutingModule { }
