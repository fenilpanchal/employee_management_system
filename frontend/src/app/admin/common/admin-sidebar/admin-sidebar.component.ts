import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { UserService } from '../../../user.service';

@Component({
  selector: 'app-admin-sidebar',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './admin-sidebar.component.html',
  styleUrl: './admin-sidebar.component.scss'
})
export class AdminSidebarComponent {

  constructor(private userservice:UserService,
    private router:Router){

  }

  logout() {
    console.log("user is logout")
    this.userservice.logout()
    .subscribe((data: any) => {
      console.info(data.body);
      // Condition: isAdmin
        localStorage.clear();
        this.router.navigate(['/']);
      
    }, (error) => {
      console.error(error);
    });
  }
}
