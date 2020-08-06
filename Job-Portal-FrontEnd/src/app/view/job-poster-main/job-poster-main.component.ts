import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../service/auth.service";
import {JobPosterProfileService} from "../../service/job-poster-profile.service";
import {JObPosterService} from "../../service/job-poster.service";
import {JobPoster} from "../../dto/job-poster";
import {JobPosterProfile} from "../../dto/job-poster-profile";

@Component({
  selector: 'app-job-poster-main',
  templateUrl: './job-poster-main.component.html',
  styleUrls: ['./job-poster-main.component.css']
})
export class JobPosterMainComponent implements OnInit {

  jobposter:JobPoster=new JobPoster();
  jobPosterFrofile:JobPosterProfile=new JobPosterProfile();


  constructor(private authService:AuthService,private jobPosterProfileService:JobPosterProfileService,private jobposterService:JObPosterService ) { }

  ngOnInit() {
    //this.loadLoginedPoster();
    //this.setUserDeatils();
  }

  logout(): void{
    this.authService.logout();

  }

  loadLoginedPoster():void{
    console.log("set message");
    this.jobposterService.getLoginedPoster().subscribe(

      (result)=>{
        console.log("sucsess 1")
        console.log(result);
        this.jobposter=result;
        if(result){
          this.setUserDeatils();
        }
        }

    )
  }

  setUserDeatils():void{
    console.log("hello set"+this.jobposter.companyname)
    this.jobPosterProfileService.searchJobPoster(this.jobposter.companyname).subscribe(
      (result)=>{
        console.log(result)
        this.jobPosterFrofile=result;
      }
    )
  }



}
