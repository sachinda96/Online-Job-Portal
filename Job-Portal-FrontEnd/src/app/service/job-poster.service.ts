import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {JobPoster} from "../dto/job-poster";
import {Observable} from "rxjs/index";
import {MAIN_URL} from "./user-service.service";

const URL="/api/v1/jobposter"
@Injectable()
export class JObPosterService {

  constructor(private http:HttpClient) { }

  registerJobPoster(jobPoster:JobPoster): Observable<boolean> {
    return this.http.post<boolean>(MAIN_URL + URL,jobPoster);

  }

  getLoginedPoster():Observable<JobPoster>{
    return this.http.get<JobPoster>(MAIN_URL+URL+"/Logined")
  }
}
