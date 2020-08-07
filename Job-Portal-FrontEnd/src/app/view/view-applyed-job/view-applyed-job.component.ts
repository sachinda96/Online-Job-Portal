import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../service/auth.service";
import {ApplyJobService} from "../../service/apply-job.service";
import {User} from "../../dto/user";
import {Router} from "@angular/router";

@Component({
  selector: 'app-view-applyed-job',
  templateUrl: './view-applyed-job.component.html',
  styleUrls: ['./view-applyed-job.component.css']
})
export class ViewApplyedJobComponent implements OnInit {


  jobDetailsList:Array<any> = new Array<any>();
  user:User = new User();
  constructor(private authService:AuthService,private applyJobService:ApplyJobService,private router:Router) { }

  ngOnInit() {
    this.user= this.authService.getUser();
    this.getAllAppliedJobsByUser(this.user.username);

  }

  getAllAppliedJobsByUser(user:String){
      this.applyJobService.getAllAppliedJobsByUser(user).subscribe(res=>{
        this.jobDetailsList= res;
      });
  }

  view(jobId: any) {

    this.router.navigate(['/Main/SelectedJob/'+jobId]);
  }
}
