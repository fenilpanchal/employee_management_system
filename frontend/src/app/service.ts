import { Injectable } from '@angular/core';
import { User } from './dto/user';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class Service {

  baseUrl='http://localhost:9081';
  
  constructor(private http : HttpClient) { }
  
  signupuser(user:User): Observable <User> {
    console.log(user);
    return this.http.post<User> (`${this.baseUrl}/signup`, user);
  }
  
}
