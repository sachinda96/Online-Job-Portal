import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Course} from "../dto/course";
import {MAIN_URL} from "./user-service.service";

const URL="/course";

@Injectable()
export class CourseService {

  constructor(private http:HttpClient) { }

  save(course:Course){
   return this.http.post<any>(MAIN_URL+URL,course,{responseType: 'text' as 'json' });
  }

  getAllByUser(user:String){
    return this.http.get<any>(MAIN_URL+URL+"/getAllByUser/"+user);
  }

  searchCourses(id:String){
    return this.http.get<any>(MAIN_URL+URL+"/searchCourses/"+id);
  }

  delete(id:String){
    return this.http.delete<any>(MAIN_URL+URL+"/"+id,{responseType: 'text' as 'json' });
  }

  getAll() {
    return this.http.get<any>(MAIN_URL+URL);
  }

  countAllActive() {
    return this.http.get<any>(MAIN_URL+URL+"/countAllByActive");
  }

  countAllInActive() {
    return this.http.get<any>(MAIN_URL+URL+"/countAllByInActive");
  }
}
