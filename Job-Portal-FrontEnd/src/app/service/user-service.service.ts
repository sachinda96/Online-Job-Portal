import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../dto/user";
import {Observable} from "rxjs/index";


export const MAIN_URL= "http://localhost:8080";
const URL="/api/v1/user";

@Injectable()
export class UserServiceService {

  constructor(private http:HttpClient) { }

  addUser(user: User): Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL + URL,user);
  }
}



