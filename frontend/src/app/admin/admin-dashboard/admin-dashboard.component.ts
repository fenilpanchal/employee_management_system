import { Component } from '@angular/core';
import { AdminHeaderComponent } from '../common/admin-header/admin-header.component';
import { AdminSidebarComponent } from '../common/admin-sidebar/admin-sidebar.component';
import { AdminEmpComponent } from '../admin-emp/admin-emp.component';


@Component({
  selector: 'app-admin-dashboard',
  standalone: true,
  imports: [
    AdminHeaderComponent,
    AdminSidebarComponent,
    AdminEmpComponent
   
  ],
  templateUrl: './admin-dashboard.component.html',
  styleUrl: './admin-dashboard.component.scss'
})
export class AdminDashboardComponent {
}
