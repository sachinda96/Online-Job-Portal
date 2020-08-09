import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {MAIN_URL} from "./user-service.service";

@Injectable()
export class CategoryService {

  constructor(private http:HttpClient) { }

  getAll():Observable<any>{
    return this.http.get<any>(MAIN_URL+"/category");
  }
}
