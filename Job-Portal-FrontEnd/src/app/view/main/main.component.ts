import { Component, OnInit } from '@angular/core';
import {User} from "../../dto/user";
import {AuthService} from "../../service/auth.service";
import {Router} from "@angular/router";
import {JobSeekerProfileService} from "../../service/job-seeker-profile.service";
import {JobSeekerProfile} from "../../dto/job-seeker-profile";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  user:User=null;
  isNotLogin:boolean =true;
  jobSeeker:JobSeekerProfile=new JobSeekerProfile();
  constructor(private authService:AuthService,private route:Router,private jobSeekerService:JobSeekerProfileService) { }

  ngOnInit() {
    this.getLoginedSeeker();
    this.getJobSeeker();
  }

  getLoginedSeeker(){
    this.user=new User();
    this.user=this.authService.getUser();
    if(this.user == null){
      this.isNotLogin =false;
    }
  }

  getJobSeeker():void{
    this.jobSeekerService.searchJobSeeker(this.user.username).subscribe(
      (result)=>{
        this.jobSeeker=result;
      }
    )
  }

 logout(){
    this.authService.logout();
   this.route.navigate(['Main/Dashboard']);
   this.user=null;
 }

  routeDashBoard():void{
    this.route.navigate(['/JobSeekerMain/dashboard'])
  }
}
