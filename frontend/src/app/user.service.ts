import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './dto/user';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  baseUrl='http://localhost:9081';
  postUser: any;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
       
    withCredentials: true, 
    observe: 'response' as 'response'
  };  
  
  constructor(private http:HttpClient) { }

  login(user: User) {
    return this.http.post<User> (`${this.baseUrl}/login`, user, this.httpOptions);
  }

  logout() {
    return this.http.post<User> (`${this.baseUrl}/logout`, undefined, this.httpOptions);
  }

  getEmployees(param: any): Observable<Object> {
    return this.http.post(`${this.baseUrl}/admin/search`, param, this.httpOptions);
  }

  addEmployee(user: any) {
    console.log(user)
    return this.http.post<User> (`${this.baseUrl}/admin/employees/add`, user, this.httpOptions)
  }

  deleteEmployee(id: number) {
    return this.http.delete<any> (`${this.baseUrl}/admin/employee/delete/${id}`, this.httpOptions);
  }
}