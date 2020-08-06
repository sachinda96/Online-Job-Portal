import {Component, ElementRef, OnInit} from '@angular/core';
import {JObPosterService} from "../../service/job-poster.service";
import {JobsService} from "../../service/jobs.service";
import {JobPoster} from "../../dto/job-poster";
import {PostJob} from "../../dto/post-job";
import {Router} from "@angular/router";

@Component({
  selector: 'app-viewpostedjobs',
  templateUrl: './viewpostedjobs.component.html',
  styleUrls: ['./viewpostedjobs.component.css']
})
export class ViewpostedjobsComponent implements OnInit {

  jobPoster:JobPoster=new JobPoster();
  username:string="";
  jobsList:Array<PostJob>=[];
  posteJob:PostJob=new PostJob()
  url:any="../assets/images/5.jpg";
  public save:string;


  constructor(private jobPosterService:JObPosterService,private jobService:JobsService,private elem:ElementRef,private router:Router) { }

  ngOnInit() {
    //this.getLoginedPoster();
    this.getPostedJobs();
  }

  getLoginedPoster():void{
    this.jobPosterService.getLoginedPoster().subscribe(
      (result)=>{
        this.jobPoster=result;
        this.username=this.jobPoster.username;
        console.log(this.username);
      }
    )
  }

  getPostedJobs():void{
    this.jobService.getPosterPostedJobs(this.username).subscribe(
      (result)=>{
        this.jobsList=result;

        console.log(this.jobsList);
      }

    )
    this.getFile();
  }


  getFile():void{
    for (let jobs of this.jobsList){

      console.log(jobs.jobsDTO.iamgePath)
    }
  }

  getJobDetails(id:string):void {
    this.save = id;
    console.log(this.save)
    this.jobService.setId(id) ;
    this.router.navigate(['/JobPosterMain/jobDetails']);

  }
}
