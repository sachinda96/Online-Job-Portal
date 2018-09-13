import { Component, OnInit } from '@angular/core';
import {JobsService} from "../../service/jobs.service";
import {PostJob} from "../../dto/post-job";
import {Router} from "@angular/router";

@Component({
  selector: 'app-applyselectjob',
  templateUrl: './applyselectjob.component.html',
  styleUrls: ['./applyselectjob.component.css']
})
export class ApplyselectjobComponent implements OnInit {

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

  setPostJob():void{
    this.jobService.setJobDetails(this.postjob);
    this.router.navigate(['/Main/ApplyJob']);
  }

}
