import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {MAIN_URL} from "./user-service.service";
import {Observable, throwError} from "rxjs/index";
import {JobPosterProfile} from "../dto/job-poster-profile";
import {JObPosterService} from "./job-poster.service";
import {JobPoster} from "../dto/job-poster";
import {ImageFile} from "../dto/image-file";
import {catchError} from "rxjs/operators";

const URL="/api/v1/profile"
const URLS="/api/v1/profile/saveprofile"
const ImageURLS="/api/v1/profile/file"
@Injectable()
export class JobPosterProfileService {


  constructor(private http:HttpClient) { }

  saveFile(file:FormData): Observable<any> {
    const reqHeader = new  HttpHeaders().set('Accept','application/json')
    return this.http.post<any>(MAIN_URL + ImageURLS,file,{headers:reqHeader});
    }


  getJobPoster(userName : String) : Observable<any>{
    return this.http.get<any>(MAIN_URL+ URL+ "/getJobPoster/"+userName);

  }


  saveJobPosterProfile(posterProfile:JobPosterProfile): Observable<boolean> {
    return this.http.post<boolean>(MAIN_URL +URLS,posterProfile);
  }

  searchJobPoster(name:string): Observable<JobPosterProfile>{
    return this.http.get<JobPosterProfile>(MAIN_URL+URL+"/"+name);
  }

  getFile(path : String): Observable<JobPosterProfile>{

    return this.http.get<JobPosterProfile>(MAIN_URL+URLS+"/file"+path);
  }
}
