import { Component, OnInit } from '@angular/core';
import { AdminSidebarComponent } from '../common/admin-sidebar/admin-sidebar.component';
import { JsUtils } from '../../js-utils';
import { Router } from '@angular/router';

@Component({
  // host: {ngSkipHydration: 'true'},
  selector: 'app-admin-emp',
  standalone: true,
  imports: [AdminSidebarComponent],
  templateUrl: './admin-emp.component.html',
  styleUrl: './admin-emp.component.scss',
  providers: [JsUtils]
})
export class AdminEmpComponent implements OnInit {
  userservice: any;
  jsUtils: any;

  constructor(private route :Router ) {}

  ngOnInit(): void {
   
  }
  logout(){
    console.log ('leave')
    this.userservice.logout(this.user).subscribe((data:any)=>{
      console.info(data);
      this.route.navigate(['/'])
    })
    
  }
  user(user: any) {
    
  }

}
