import { Component, OnInit } from '@angular/core';
import {JobsService} from "../../service/jobs.service";

@Component({
  selector: 'app-job-poster-dash-board',
  templateUrl: './job-poster-dash-board.component.html',
  styleUrls: ['./job-poster-dash-board.component.css']
})
export class JobPosterDashBoardComponent implements OnInit {

  totalJobs:string;

  constructor(private jobService:JobsService) { }

  ngOnInit() {
    this.getTotalJobs();
  }

  getTotalJobs():void{
    console.log("hello helloo hello")
    this.jobService.getTotalJobs().subscribe(
      (result)=>{
        this.totalJobs=result;
        console.log("job Total"+this.totalJobs)
      }
    )
  }

}
