import { Component } from '@angular/core';
import { AdminHeaderComponent } from '../common/admin-header/admin-header.component';
import { AdminSidebarComponent } from '../common/admin-sidebar/admin-sidebar.component';
import { AdminEmpComponent } from '../admin-emp/admin-emp.component';
import { UserService } from '../../user.service';
import { Router } from '@angular/router';
import { JsUtils } from '../../js-utils';
import { HttpClientModule } from '@angular/common/http';


@Component({
  selector: 'app-admin-dashboard',
  standalone: true,
  imports: [
    AdminHeaderComponent,
    AdminSidebarComponent,
    AdminEmpComponent,
    HttpClientModule
  ],
  providers: [HttpClientModule, UserService, JsUtils],
  templateUrl: './admin-dashboard.component.html',
  styleUrl: './admin-dashboard.component.scss'
})
export class AdminDashboardComponent {
  
  constructor(private route :Router,
    private userService: UserService
  ) {}
  
  ngOnInit(): void {
    
  }
  logout(){
    console.log ('leave')
    this.userService.logout().subscribe((data:any)=>{
      console.info(data);
      this.route.navigate(['/'])
    })
    
  }
  user(user: any) {
    
  }
  
}
