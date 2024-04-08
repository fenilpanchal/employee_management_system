import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login.component';
// import { HttpClientModule } from '@angular/common/http';

const routes: Routes = [ 
  { path: '', component: LoginComponent }];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    // HttpClientModule
  ],
  // providers: [HttpClientModule],
  exports: [RouterModule]
})

export class LoginModule { }
 