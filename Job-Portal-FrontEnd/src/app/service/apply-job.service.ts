import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";
import {ApplyJobMain} from "../dto/apply-job-main";
import {MAIN_URL} from "./user-service.service";
import {ApllyJob} from "../dto/aplly-job";

const URLS="/api/v1/applyJob"
@Injectable()
export class ApplyJobService {

  constructor(private http:HttpClient) { }

  saveApplyJob(applyJob:ApplyJobMain):Observable<any>{
    return this.http.post<any>(MAIN_URL+URLS,applyJob);
  }

  getAllAppliedJobsByUser(user:String){
    return this.http.get<any>(MAIN_URL+URLS+"/getAllAppliedJobsByUser/"+user)
  }

  getLastJob():Observable<ApllyJob>{
    return this.http.get<ApllyJob>(MAIN_URL+URLS+"/Last")
  }
}
