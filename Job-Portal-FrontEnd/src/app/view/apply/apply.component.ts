import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../service/auth.service";
import {JobsService} from "../../service/jobs.service";
import {JobPosterProfileService} from "../../service/job-poster-profile.service";
import {User} from "../../dto/user";
import {JobSeekerProfile} from "../../dto/job-seeker-profile";
import {JobSeekerProfileService} from "../../service/job-seeker-profile.service";
import {Jobs} from "../../dto/jobs";
import {PostJob} from "../../dto/post-job";
import {ApplyJobMain} from "../../dto/apply-job-main";
import {ApllyJob} from "../../dto/aplly-job";
import {ApllyJobDetails} from "../../dto/aplly-job-details";
import {ApplyJobService} from "../../service/apply-job.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-apply',
  templateUrl: './apply.component.html',
  styleUrls: ['./apply.component.css']
})
export class ApplyComponent implements OnInit {

  lastApplyJob:ApllyJob=new ApllyJob();
  user:User=new User();
  jobseker:JobSeekerProfile=new JobSeekerProfile();
  date:Date;
  loading : boolean =false;
  job:PostJob=new PostJob();
  applyJobs:ApllyJob=new ApllyJob();
  applyJobsDetails:ApllyJobDetails=new ApllyJobDetails();
  applyJobMain:ApplyJobMain=new ApplyJobMain();
  id:number=1;
  constructor(private authService:AuthService,private jobService:JobsService,private routerActive :ActivatedRoute,private jobSeekerService:JobSeekerProfileService,private applyJobService:ApplyJobService) { }

  ngOnInit() {

    this.routerActive.params.subscribe(params =>{
      this.getSelectedJob(params.id)

    })
    this.getUser();
    this.getJobSeeker();
    this.getCurrentDate();


  }

  getUser():void{
    this.user=this.authService.getUser();

  }

  getJobSeeker():void{
    this.jobSeekerService.searchJobSeeker(this.user.username).subscribe(
      (result)=>{
        this.jobseker=result;
      }
    )
  }

  getSelectedJob(id:any):void{
    this.jobService.getSelectedJobDetails(id).subscribe(
      (result)=>{
        if(result){
          console.log(result)
          this.job=result;
        }
      },error => {
        console.log("Failed To Load JOb Details")
      }
    )
  }


  getCurrentDate():void{
    this.date=new Date();
  }

  applyNewJob():void{

    this.loading =true;
    this.applyJobMain = new ApplyJobMain();
    this.applyJobMain.userName = this.user.username;
    this.applyJobMain.jobId = this.job.jobsDTO.id.toString();

    this.applyJobService.saveApplyJob(this.applyJobMain).subscribe(
      (result)=>{
        this.loading=false;
        if(result == 200){
          alert("Successfully Applied Job");
        }else{
          alert("Failed Applied Job");
        }
      },error => {
        this.loading = false;
        alert("Failed to Apply to Job")
      }
    )
  }

  getLastJob():void{
    this.applyJobService.getLastJob().subscribe(
      (result)=>{
        this.lastApplyJob=result;
        this.id+=this.lastApplyJob.aid;
        console.log(this.id)
      }
    )
  }
}
