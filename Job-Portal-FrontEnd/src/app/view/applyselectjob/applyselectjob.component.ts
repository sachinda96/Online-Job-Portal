import { Component, OnInit } from '@angular/core';
import {JobsService} from "../../service/jobs.service";
import {PostJob} from "../../dto/post-job";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../service/auth.service";
import {User} from "../../dto/user";

@Component({
  selector: 'app-applyselectjob',
  templateUrl: './applyselectjob.component.html',
  styleUrls: ['./applyselectjob.component.css']
})
export class ApplyselectjobComponent implements OnInit {

  postjob:PostJob=new PostJob();
  isselected: boolean = true;
  user:User = new User();
  constructor(private jobService:JobsService,private router:Router,private  routerActive :ActivatedRoute,private authService:AuthService) { }

  ngOnInit() {

    this.routerActive.params.subscribe(params =>{
      this.getSelectedJobDetails(params.id)
    })
    this.user = this.authService.getUser();

    if(this.user == null && this.user == undefined){
      this.isselected =false;
    }else if(this.user.type == "POSTER"){
      this.isselected =false;
    }

  }

  getSelectedJobDetails(id:any){

    this.jobService.getSelectedJobDetails(id).subscribe(
      (result)=>{
        if(result){
          this.postjob=result;
        }
      }
    )
  }

  setPostJob(id:any):void{
    this.jobService.setJobDetails(this.postjob);
    this.router.navigate(['/Main/ApplyJob',id]);
  }

}
