///<reference path="../../service/jobs.service.ts"/>
import {Component, ElementRef, OnInit} from '@angular/core';
import {Jobs} from "../../dto/jobs";
import {JobsService} from "../../service/jobs.service";
import {JobPoster} from "../../dto/job-poster";
import {JObPosterService} from "../../service/job-poster.service";
import {Qulification} from "../../dto/qulification";
import {PostJob} from "../../dto/post-job";

@Component({
  selector: 'app-postjob',
  templateUrl: './postjob.component.html',
  styleUrls: ['./postjob.component.css']
})
export class PostjobComponent implements OnInit {

  jobs:Jobs=new Jobs();
  qulifucation:Qulification=new Qulification();
  imageFile:File;
  setImageFileName:String="";
  jobPoster:JobPoster;
  requiredupdate:boolean=true;
  postJob:PostJob=new PostJob();




  constructor(private jobService:JobsService,private  jobposterService:JObPosterService,private elem:ElementRef) { }

  ngOnInit() {
    this.loadLoginedPoster();
  }



    addJOb():void{
    console.log("Sucsess")
    let industry=this.elem.nativeElement.querySelector('#industry').value;
    let category=this.elem.nativeElement.querySelector('#category').value;
    let bussinessfuntion=this.elem.nativeElement.querySelector('#bussinessfuntion').value;

    console.log(industry)
    this.jobs.industry=industry;
    this.jobs.category=category;
    this.jobs.bussinessfuntion=bussinessfuntion;

    let minimumqulification=this.elem.nativeElement.querySelector('#minimumqulification').value;
    let requiredexperience=this.elem.nativeElement.querySelector('#requiredexperience').value;
    let educationalspecialization=this.elem.nativeElement.querySelector('#educationalspecialization').value;
    let skill=this.elem.nativeElement.querySelector('#skill').value;
    let genderpreference=this.elem.nativeElement.querySelector('#genderpreference').value;
    let maimumage=this.elem.nativeElement.querySelector('#maimumage').value;

    console.log(minimumqulification)
    this.qulifucation.minimumqulification=minimumqulification;
    this.qulifucation.requiredexperience=requiredexperience;
    this.qulifucation.educationalspecialization=educationalspecialization;
    this.qulifucation.skill=skill;
    this.qulifucation.genderpreference=genderpreference;
    this.qulifucation.maximumage=maimumage;


    this.jobs.jobPosterDTO=this.jobPoster;
    this.postJob.jobsDTO=this.jobs;
    this.postJob.qulificationDTO=this.qulifucation;
    console.log(this.postJob)
      const formData:FormData=new FormData();
      formData.append("file",this.imageFile);
      console.log(this.imageFile)
      this.jobService.saveFile(formData).subscribe(
        (result)=>{
            if(result){
              this.jobService.addJob(this.postJob).subscribe(
                (result)=>{
                  if(result){
                    confirm("New Job Added successfully")
                  }else{
                    confirm("Fail to Add Re-Try")
                  }
                }
              )
            }
        }
      )


  }

  loadLoginedPoster():void{
    this.jobposterService.getLoginedPoster().subscribe(
      (result)=>{
        this.jobPoster=result;
      }
    )
  }

  saveFile():void {
    const formData:FormData=new FormData();
    formData.append("file",this.imageFile);
    console.log(this.imageFile)
    this.jobService.saveFile(formData).subscribe(
      (result)=>{

      }
    )
  }


  setIma(event) {
    console.log("fjjhjjh")
    const fil = event.target.files[0]

    this.imageFile = fil;

    console.log(this.imageFile)
  }

  // getSelectedJobDetails():void{
  //   console.log("set 2")
  //   this.updatePostJob=this.jobService.getJobDetails();
  //   this.jobs=this.jobService.getJobDetails().jobsDTO;
  //   console.log(this.jobs)
  // }

  // updateJobs():void{
  //   let industry=this.elem.nativeElement.querySelector('#industry').value;
  //   let category=this.elem.nativeElement.querySelector('#category').value;
  //   let bussinessfuntion=this.elem.nativeElement.querySelector('#bussinessfuntion').value;
  //
  //   console.log(industry)
  //   this.jobs.industry=industry;
  //   this.jobs.category=category;
  //   this.jobs.bussinessfuntion=bussinessfuntion;
  //
  //   let minimumqulification=this.elem.nativeElement.querySelector('#minimumqulification').value;
  //   let requiredexperience=this.elem.nativeElement.querySelector('#requiredexperience').value;
  //   let educationalspecialization=this.elem.nativeElement.querySelector('#educationalspecialization').value;
  //   let skill=this.elem.nativeElement.querySelector('#skill').value;
  //   let genderpreference=this.elem.nativeElement.querySelector('#genderpreference').value;
  //   let maimumage=this.elem.nativeElement.querySelector('#maimumage').value;
  //
  //   console.log(minimumqulification)
  //   this.qulifucation.minimumqulification=minimumqulification;
  //   this.qulifucation.requiredexperience=requiredexperience;
  //   this.qulifucation.educationalspecialization=educationalspecialization;
  //   this.qulifucation.skill=skill;
  //   this.qulifucation.genderpreference=genderpreference;
  //   this.qulifucation.maximumage=maimumage;
  //
  //
  //   this.jobs.jobPosterDTO=this.jobPoster;
  //   this.postJob.jobsDTO=this.jobs;
  //   this.postJob.jobsDTO.id=this.updatePostJob.jobsDTO.id;
  //   this.postJob.qulificationDTO=this.qulifucation;
  //   this.postJob.qulificationDTO.id=this.updatePostJob.qulificationDTO.id;
  //   console.log(this.postJob)
  //   this.jobService.updateJob(this.postJob).subscribe(
  //     (result)=>{
  //       if(result){
  //         alert(" Update Sucsess ")
  //       }else{
  //         alert("update failed")
  //       }
  //     }
  //   )
  // }

}
