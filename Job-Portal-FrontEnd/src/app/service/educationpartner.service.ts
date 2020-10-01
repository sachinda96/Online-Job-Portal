import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {MAIN_URL} from "./user-service.service";
import {Injectable} from "@angular/core";
import {EducationalPartner} from "../dto/educational-partner";
import { EducationCenter } from "../dto/education-center";

const URL="/EducationalPartner";

@Injectable()
export class EducationpartnerService {


  constructor(private http: HttpClient) {
  }

  registor(educationalPratner:EducationalPartner): Observable<any> {
    return this.http.post<any>(MAIN_URL +URL,educationalPratner);
  }

  addEducationCenter(educationCenter:EducationCenter):Observable<any>{
    return this.http.post<any>(MAIN_URL+URL+"/addEducationCenter",educationCenter,{responseType: 'text' as 'json' });

  }

  allEducationCenterByUser(userName:String){
    return this.http.get<any>(MAIN_URL+URL+"/allEducationCenterByUser/"+userName);
  }

  educationCenter(id:String){
    return this.http.get<any>(MAIN_URL+URL+"/educationCenter/"+id);
  }

  deleteEducationCenter(id:String){
    return this.http.delete<any>(MAIN_URL+URL+"/"+id,{responseType: 'text' as 'json' });
  }
}
