import { Routes } from '@angular/router';

export const routes: Routes =  [ 
  { path: '', loadChildren: () => import('./auth/login/login.module').then(mod => mod.LoginModule), },
  
  { path: 'admin-dashboard', loadChildren: () => import('./admin/admin-dashboard/admin-dashboard-routing.module').then(mod => mod.AdminDashboardRoutingModule), },
  { path: 'admin-emp', loadChildren: () => import('./admin/admin-emp/admin-emp-routing.module').then(mod => mod.AdminEmpRoutingModule), },
  { path: 'admin-salary', loadChildren: () => import('./admin/admin-salary/admin-salary-routing.module').then(mod => mod.AdminSalaryRoutingModule), },
  { path: 'admin-notifications', loadChildren: () => import('./admin/admin-notifications/admin-notifications-routing.module').then(mod => mod.AdminNotificationsRoutingModule), },
  { path: 'employee', loadChildren: () => import('./employee/employee.module').then(mod => mod.EmployeeModule) }
]  