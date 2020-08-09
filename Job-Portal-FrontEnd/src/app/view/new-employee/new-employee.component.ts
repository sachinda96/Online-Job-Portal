import { Component, OnInit } from '@angular/core';
import {ApplyJobService} from "../../service/apply-job.service";
import {AuthService} from "../../service/auth.service";
import {User} from "../../dto/user";

@Component({
  selector: 'app-new-employee',
  templateUrl: './new-employee.component.html',
  styleUrls: ['./new-employee.component.css']
})
export class NewEmployeeComponent implements OnInit {

  jobDetailsList:Array<any> = new Array<any>();
  user:User = new User();

  constructor(private authService:AuthService,private applyJobService:ApplyJobService) { }

  ngOnInit() {
    this.user=this.authService.getUser();
    this.getAllAppliedEmployeeByUser();
  }

  getAllAppliedEmployeeByUser(){
    this.applyJobService.getAllAppliedEmployeeByUser(this.user.username).subscribe(
      res=>{
        this.jobDetailsList = res;
      }
    )
  }

  downloadCV() {


  }
}
