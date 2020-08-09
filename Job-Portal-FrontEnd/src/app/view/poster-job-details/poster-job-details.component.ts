import { Component, OnInit } from '@angular/core';
import {ViewpostedjobsComponent} from "../viewpostedjobs/viewpostedjobs.component";
import {JobsService} from "../../service/jobs.service";
import {PostJob} from "../../dto/post-job";
import {Router} from "@angular/router";
import {QulificationService} from "../../service/qulification.service";

@Component({
  selector: 'app-poster-job-details',
  templateUrl: './poster-job-details.component.html',
  styleUrls: ['./poster-job-details.component.css']
})
export class PosterJobDetailsComponent implements OnInit {

  postjob:PostJob=new PostJob();
  constructor(private jobService:JobsService,private router:Router) { }

  ngOnInit() {
  this.getSelectedJobDetails();
  }

  getSelectedJobDetails(){

    var id=this.jobService.getId();

    this.jobService.getSelectedJobDetails(id).subscribe(
      (result)=>{
        if(result){
          this.postjob=result;
        }
      }
    )
  }

  deletePost(){
     var id=this.postjob.jobsDTO.id;

    // this.qulificationService.deleteQulification(id).subscribe(
    //   (result)=>{
    //     if (result){
    //       alert("Delete Sucsess")
    //       this.router.navigate(['/JobPosterMain/ViewPostJobs'])
    //     }else{
    //       alert("Failed")
    //     }
    //   }
    // )
  }

  setPostJob(id:String){
    this.jobService.setJobDetails(this.postjob);
      // @ts-ignore
    this.router.navigate(['/JobPosterMain/PostJob',id],);

  }
}
