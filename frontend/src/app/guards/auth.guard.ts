// import { Injectable } from '@angular/core';
// import { CanActivate, CanActivateChild, CanDeactivate, CanLoad, Router } from '@angular/router';
// import { AdminDashboardComponent } from '../admin/admin-dashboard/admin-dashboard.component';

import { Injectable, inject } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivateFn, RouterStateSnapshot } from "@angular/router";

// @Injectable({
//   providedIn: 'root'
// })
// export class AuthGuard implements CanActivate, CanActivateChild, CanLoad  {
//   constructor(private router: Router) {}

//   canActivate(): boolean {
//     return this.checkAuth();
//   }

//   canActivateChild(): boolean {
//     return this.checkAuth();
//   }

//   canLoad(): boolean {
//     return this.checkAuth();
//   }

//   private checkAuth(): boolean {
//     const strUser = localStorage.getItem("user");
//     if (strUser != undefined) {
//       const user = JSON.parse(strUser);
//       if (user == undefined) {
//         return this.redirectToLogin();
//       } else {
//         if (user.admin) {
//           this.router.navigate(['/admin-dashboard']);
//           return true;
//         } else {
//           this.router.navigate(['/employee-dashboard']);
//           return true;
//         }
//       }
//     } else {
//       return this.redirectToLogin();
//     }
//   }

//   private redirectToLogin() {
//     this.router.navigate(['/login']);
//     return false;
//   }

// }

@Injectable()
class UserToken {}

@Injectable()
class PermissionsService {
  canActivate(currentUser: UserToken, userId: string): boolean {
    return true;
  }
  canMatch(currentUser: UserToken): boolean {
    return true;
  }
}

const canActivateTeam: CanActivateFn = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot,
) => {
  return inject(PermissionsService).canActivate(inject(UserToken), route.params['id']);
};