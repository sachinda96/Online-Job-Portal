import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";
import {MAIN_URL} from "./user-service.service";
import {JobSeekerProfile} from "../dto/job-seeker-profile";
import {log} from "util";

const URLS="/api/v1/JobSeekerProfile"

@Injectable()
export class JobSeekerProfileService {

  constructor(private http:HttpClient) { }

  uploadImage(formdata:FormData):Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL+URLS+"/imageFile",formdata);
  }

  uploadCV(formdata:FormData):Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL+URLS+"/CVFile",formdata);
  }

  saveProfile(jobSeekerProfile:JobSeekerProfile):Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL+URLS,jobSeekerProfile);
  }

  searchJobSeeker(username:string):Observable<JobSeekerProfile>{
    return this.http.get<JobSeekerProfile>(MAIN_URL+URLS+"/"+username);
  }
}



