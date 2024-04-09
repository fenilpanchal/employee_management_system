import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs/internal/Observable';
import { User } from './dto/user';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  baseUrl='http://localhost:9081';
  postUser: any;
  
  constructor(private http:HttpClient) { }
  
  signupuser(user: User) {
    console.log("User...");
  }

  addUser(user: User): Observable <User> {
    console.log(user)
    return this.http.post<User> (`${this.baseUrl}/login`, user)
  }

  logout() {
    return this.http.post<User> (`${this.baseUrl}/logout`, undefined)
  }
  getEmployees(page: number, pageSize: number): Observable<any> {
    const params = {
      page: page.toString(),
      pageSize: pageSize.toString()
    };
    return this.http.get(`${this.baseUrl}/employees`, { params });
  }
}


