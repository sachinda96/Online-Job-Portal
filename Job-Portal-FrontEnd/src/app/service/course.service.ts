import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Course} from "../dto/course";
import {MAIN_URL} from "./user-service.service";
import {Observable} from "rxjs";

const URL="/course";

@Injectable()
export class CourseService {

  constructor(private http:HttpClient) { }

  save(course:Course){
   return this.http.post<any>(MAIN_URL+URL,course,{responseType: 'text' as 'json' });
  }
}
