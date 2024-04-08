import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs/internal/Observable';
import { User } from './dto/user';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  signupuser(user: User) {
      throw new Error('Method not implemented.');
  }
  
  baseUrl='http://localhost:9081';
  postUser: any;
  
  constructor(private http:HttpClient) { }
  
  addUser(user: User)
   : Observable <User>
  {
    console.log(user)
     return this.http.post<User> (`${this.baseUrl}/login`, user)
  }
}
  
  
  