import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { User } from './models/user';

@Injectable()
export class AuthService {

  headers: Headers = new Headers()
  constructor(private http:Http) { }

  login(user:User) {
    return this.http.post("http://192.168.1.9/login.php", JSON.stringify(user), {headers: this.headers})
  }

  logout() {
    localStorage.removeItem('user')
  }

}
