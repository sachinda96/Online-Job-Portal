import { Injectable } from '@angular/core';
import {HttpModule} from "@angular/http";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";
import {MAIN_URL} from "./user-service.service";

const URlS="/api/v1/qulification"
@Injectable()
export class QulificationService {

  constructor(private http:HttpClient) { }


  deleteQulification(id:number):Observable<boolean>{
   return this.http.delete<boolean>(MAIN_URL+URlS+"/"+id);
  }
}
