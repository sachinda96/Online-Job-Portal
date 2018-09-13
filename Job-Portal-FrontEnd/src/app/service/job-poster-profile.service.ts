import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MAIN_URL} from "./user-service.service";
import {Observable} from "rxjs/index";
import {JobPosterProfile} from "../dto/job-poster-profile";
import {JObPosterService} from "./job-poster.service";
import {JobPoster} from "../dto/job-poster";
import {ImageFile} from "../dto/image-file";

const URL="/api/v1/profile"
const URLS="/api/v1/profile/saveprofile"
const ImageURLS="/api/v1/profile/file"
@Injectable()
export class JobPosterProfileService {


  constructor(private http:HttpClient) { }

  saveFile(file:FormData): Observable<boolean> {
    console.log(file)
    return this.http.post<boolean>(MAIN_URL + ImageURLS,file);
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
