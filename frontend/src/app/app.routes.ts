import { Routes } from '@angular/router';
// import { AuthGuard } from './guards/auth.guard';

export const routes: Routes =  [ 
  { path: '', loadChildren: () => import('./auth/login/login.module').then(mod => mod.LoginModule)
  // , 
  //   canActivate: [AuthGuard]
  },
  { 
    path: 'admin-dashboard', 
    loadChildren: () => import('./admin/admin-dashboard/admin-dashboard-routing.module').then(mod => mod.AdminDashboardRoutingModule)
    // , 
    // canActivate: [AuthGuard] 
  },
  { 
    path: 'admin-emp',
    loadChildren: () => import('./admin/admin-emp/admin-emp-routing.module').then(mod => mod.AdminEmpRoutingModule)
    // , 
    // canActivate: [AuthGuard] 
  },
  { 
    path: 'admin-salary',
    loadChildren: () => import('./admin/admin-salary/admin-salary-routing.module').then(mod => mod.AdminSalaryRoutingModule)
    // , 
    // canActivate: [AuthGuard] 
  },
  { 
    path: 'admin-notifications',
    loadChildren: () => import('./admin/admin-notifications/admin-notifications-routing.module').then(mod => mod.AdminNotificationsRoutingModule)
    // , 
    // canActivate: [AuthGuard] 
  },
  { 
    path: 'employee',
    loadChildren: () => import('./employee/employee.module').then(mod => mod.EmployeeModule)
    // , 
    // canActivate: [AuthGuard] 
  }
]  