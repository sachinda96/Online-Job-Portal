import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../dto/user";
import {Observable} from "rxjs/index";
import {MAIN_URL} from "./user-service.service";
import {Router} from "@angular/router";
import {map} from "rxjs/internal/operators";

const URL="/api/v1/login"
@Injectable()
export class AuthService {

  constructor(private http:HttpClient,private router:Router) { }

  login(user: User): Observable<User> {
    return this.http.post<User>(MAIN_URL + URL, user)
      .pipe(
        map((result)=>{
          console.log(result)
          sessionStorage.setItem("token", JSON.stringify(result) );
          if (result){
            if(result.type === "SEEKER"){
              this.router.navigate(['/JobSeekerMain/dashboard']);
            }else{
              this.router.navigate(['/JobPosterMain/dashboard']);
            }

          }
          return result;
        })
      )
  }

  isAuthenticated(): boolean{
    if (sessionStorage.getItem("token")){
      return sessionStorage.getItem("token") == 'false' ? false: true;
    }
  }

  logout(): void{
    sessionStorage.removeItem("token");
  }

  getUser(){
   return JSON.parse(sessionStorage.getItem("token"));
  }

}
