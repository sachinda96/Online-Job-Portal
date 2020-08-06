import { Component, OnInit } from '@angular/core';
import {JobsService} from "../../service/jobs.service";
import {PostJob} from "../../dto/post-job";
import {Router} from "@angular/router";

@Component({
  selector: 'app-viewall-posted-jobs',
  templateUrl: './viewall-posted-jobs.component.html',
  styleUrls: ['./viewall-posted-jobs.component.css']
})
export class ViewallPostedJobsComponent implements OnInit {

  id:string;
  allPostedJobs:Array<PostJob>=[];
  constructor(private jobService:JobsService,private router:Router) { }

  ngOnInit() {
    this.getAllJobs();
  }

  getAllJobs():void{
    this.jobService.getAllJobs().subscribe(
      (result)=>{
        console.log(result)
        this.allPostedJobs=result
      }
    )
  }

  setSelectedJob(id:string):void {
    this.jobService.setId(id) ;
    this.router.navigate(['/Main/SelectedJob/'+id]);

  }
}
