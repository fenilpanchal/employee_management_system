import { Component, OnInit } from '@angular/core';

import { User } from '../../dto/user';
import { UserService } from '../../user.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  standalone: true,
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
  imports: [
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [HttpClientModule, UserService],
})

export class LoginComponent implements OnInit{
  
  user:User=new User();
  
  constructor (private userservice:UserService,private route:Router ) {}
  
  ngOnInit(): void {}
  
  login() {
    console.log("user is login")
    this.userservice.addUser(this.user)
    .subscribe((data: any) => {
      console.info(data);
      // Condition: isAdmin
      if (data && data.admin) {
        this.route.navigate(['/admin-emp']);
      } else {
        this.route.navigate(['/employee']);
      }

    }, (error) => {
      console.error(error);
    });
    
  }
}