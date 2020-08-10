import { Component, OnInit } from '@angular/core';
import {ApplyJobService} from "../../service/apply-job.service";
import {User} from "../../dto/user";
import {AuthService} from "../../service/auth.service";
import {JobsService} from "../../service/jobs.service";

@Component({
  selector: 'app-jobseeker-dashboard',
  templateUrl: './jobseeker-dashboard.component.html',
  styleUrls: ['./jobseeker-dashboard.component.css']
})
export class JobseekerDashboardComponent implements OnInit {
  totalAppliedJobs: any = 0;
  user:User = new User();
  totalJobs: any= 0;
  totalComplains: any = 0;
  constructor(private applyJobService:ApplyJobService,private authService:AuthService,private jobService : JobsService) { }

  ngOnInit() {
    this.user =this.authService.getUser();
    this.countByAllAppliedJobs(this.user.username);
    this.countAllJobs();
  }

  countAllJobs(){
    this.jobService.getTotalJobs().subscribe(
      res=>{
        this.totalJobs =res;
      }
    );
  }

  countByAllAppliedJobs(username:String){
    this.applyJobService.countByAllAppliedJobs(username).subscribe(
      res=>{
        this.totalAppliedJobs = res;
      }
    );
  }

}
