import { Component, OnInit } from '@angular/core';
import {JobsService} from "../../service/jobs.service";
import {PostJob} from "../../dto/post-job";
import {ActivatedRoute, Router} from "@angular/router";
import {ApplyJobService} from "../../service/apply-job.service";

@Component({
  selector: 'app-viewall-posted-jobs',
  templateUrl: './viewall-posted-jobs.component.html',
  styleUrls: ['./viewall-posted-jobs.component.css']
})
export class ViewallPostedJobsComponent implements OnInit {

  id:string;
  allPostedJobs:Array<PostJob>=[];
  constructor(private jobService:JobsService,private router:Router,private applyJobService:ApplyJobService,private routerActive :ActivatedRoute) { }

  ngOnInit() {

    this.routerActive.params.subscribe(params =>{


      if(params.name == null || params.name == undefined){
        this.getAllJobs();
      }else{
        this.getAllJobsByName(params.name);
      }
      //this.getSelectedJob(params.id)

    })


  }

  getAllJobs():void{
    this.jobService.getAllJobs().subscribe(
      (result)=>{
        this.allPostedJobs=result
      }
    )
  }

  setSelectedJob(id:string):void {
    this.router.navigate(['/Main/SelectedJob/'+id]);
  }

  setImage(iamgePath: string):any {

    // this.applyJobService.getFile(iamgePath).subscribe(res=>{
    //   console.log(res)
    //   return res;
    // })

  }

  private getAllJobsByName(name: any) {
    this.jobService.getAllJobsByName(name).subscribe(res=>{
      this.allPostedJobs=res
    })
  }
}
