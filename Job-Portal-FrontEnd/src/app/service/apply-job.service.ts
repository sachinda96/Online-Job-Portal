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

  saveApplyJob(applyJob:ApplyJobMain):Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL+URLS,applyJob);
  }

  getLastJob():Observable<ApllyJob>{
    return this.http.get<ApllyJob>(MAIN_URL+URLS+"/Last")
  }
}
