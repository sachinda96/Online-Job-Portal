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
  job:PostJob=new PostJob();
  applyJobs:ApllyJob=new ApllyJob();
  applyJobsDetails:ApllyJobDetails=new ApllyJobDetails();
  applyJobMain:ApplyJobMain=new ApplyJobMain();
  id:number=1;
  constructor(private authService:AuthService,private jobService:JobsService,private jobSeekerService:JobSeekerProfileService,private applyJobService:ApplyJobService) { }

  ngOnInit() {
    this.getUser();
    this.getJobSeeker();
    this.getCurrentDate();
    this.getSelectedJob();
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

  getSelectedJob():void{
   this.job=this.jobService.getJobDetails();
  }
  getCurrentDate():void{
    this.date=new Date();
  }

  applyNewJob():void{
    console.log("Sucsess")
    this.getLastJob();
    this.applyJobs.aid=this.id;
    this.applyJobs.data=String(this.date);
    this.applyJobs.jobSeeker=this.jobseker;

    this.applyJobsDetails.applyData=this.applyJobs.data;
    this.applyJobsDetails.jobs=this.job.jobsDTO;
    this.applyJobsDetails.applyJob=this.applyJobs;

    this.applyJobMain.applyJobDetails=this.applyJobsDetails;
    this.applyJobMain.applyJobDTO=this.applyJobs;
    this.applyJobMain.jobsDTO=this.job.jobsDTO;

    this.applyJobService.saveApplyJob(this.applyJobMain).subscribe(
      (result)=>{
        if(result){
          alert("Sucses");
        }else{
          alert("Failed");
        }
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
