import { Component, OnInit } from '@angular/core';
import {JobsService} from "../../service/jobs.service";
import {AuthService} from "../../service/auth.service";
import {ApplyJobService} from "../../service/apply-job.service";
import {User} from "../../dto/user";

@Component({
  selector: 'app-job-poster-dash-board',
  templateUrl: './job-poster-dash-board.component.html',
  styleUrls: ['./job-poster-dash-board.component.css']
})
export class JobPosterDashBoardComponent implements OnInit {

  totAvailableJobs: any =0;
  totalPostedJobs: any = 0;
  totSelectedJobs: any= 0;
  totalJobSeekers: any= 0;
  user:User = new User();

  constructor(private jobService:JobsService,private authService:AuthService,private applyJobService:ApplyJobService) { }

  ngOnInit() {
    this.user =this.authService.getUser();
    this.getTotalJobs(this.user.username);

  }

  getTotalJobs(userName:String):void{
    this.jobService.getTotalJobs().subscribe(
      (result)=>{
        this.totAvailableJobs=result;
      }
    )

    this.jobService.getAllJobsByUser(userName).subscribe(
      res=>{
        this.totalPostedJobs = res;
      }
    );

    this.applyJobService.getAllAppliedEmployeeByUser(userName).subscribe(
      res =>{
        let list = new Array();
        if(res !=null){
          list = res;
          this.totalJobSeekers = list.length;
        }
      }
    );
  }

}
