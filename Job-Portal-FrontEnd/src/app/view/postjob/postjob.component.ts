///<reference path="../../service/jobs.service.ts"/>
import {Component, ElementRef, OnInit} from '@angular/core';
import {Jobs} from "../../dto/jobs";
import {JobsService} from "../../service/jobs.service";
import {JobPoster} from "../../dto/job-poster";
import {JObPosterService} from "../../service/job-poster.service";
import {Qulification} from "../../dto/qulification";
import {PostJob} from "../../dto/post-job";
import {User} from "../../dto/user";
import {JobPosterProfileService} from "../../service/job-poster-profile.service";
import {ActivatedRoute} from "@angular/router";
import {CategoryService} from "../../service/category.service";

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
  loading : boolean =false ;
  userDto :User = new User();
  categoryArray:Array<any> = new Array<any>();



  constructor(private jobService:JobsService,private  jobposterService:JObPosterService,private elem:ElementRef,private  jobPosterProfileService: JobPosterProfileService,
              private routerActive:ActivatedRoute,private categoryService:CategoryService) { }

  ngOnInit() {
    this.jobs.jobtitle ="";
    this.getAllCategory();
    this.routerActive.params.subscribe(params =>{
      if(params.id != null || params.id != undefined) {


        this.jobService.getSelectedJobDetails(params.id).subscribe(res => {
            this.postJob = res;
            this.jobs = this.postJob.jobsDTO;
            this.elem.nativeElement.querySelector('#industry').value = this.postJob.jobsDTO.industry;
            this.elem.nativeElement.querySelector('#category').value = this.postJob.jobsDTO.category;
            this.elem.nativeElement.querySelector('#deddat').value = this.postJob.jobsDTO.dedlinedate;
            this.elem.nativeElement.querySelector('#totvac').value = this.postJob.jobsDTO.totalvacncies;
            this.elem.nativeElement.querySelector('#discription').value = this.postJob.jobsDTO.discription;

            this.qulifucation = this.postJob.qulificationDTO;

            this.elem.nativeElement.querySelector('#minimumqulification').value = this.qulifucation.minimumqulification;
            this.elem.nativeElement.querySelector('#reqexp').value = this.qulifucation.requiredexperience;
            this.elem.nativeElement.querySelector('#educationalspecialization').value = this.qulifucation.educationalspecialization;
            this.elem.nativeElement.querySelector('#skill').value = this.qulifucation.skill;
            this.elem.nativeElement.querySelector('#genderpreference').value = this.qulifucation.genderpreference;
            this.elem.nativeElement.querySelector('#maimumage').value = this.qulifucation.maximumage;
            this.elem.nativeElement.querySelector('#minage').value = this.qulifucation.minimumage;

          }
        )
      }
    })
    this.userDto =JSON.parse(sessionStorage.getItem("token"));


  }



    addJOb():void{

    try{


    this.loading =true;
    let industry=this.elem.nativeElement.querySelector('#industry').value;
    let category=this.elem.nativeElement.querySelector('#category').value;
    let dedlineDate=this.elem.nativeElement.querySelector('#deddat').value;
    var totalvac: number =this.elem.nativeElement.querySelector('#totvac').value;
    let discription =this.elem.nativeElement.querySelector('#discription').value;

    this.jobs.industry=industry;
    this.jobs.category=category;
    this.jobs.dedlinedate = dedlineDate;
    this.jobs.totalvacncies = totalvac;
    this.jobs.discription = discription;
    let minimumqulification=this.elem.nativeElement.querySelector('#minimumqulification').value;
    let requiredexperience=this.elem.nativeElement.querySelector('#reqexp').value;
    let educationalspecialization=this.elem.nativeElement.querySelector('#educationalspecialization').value;
    let skill=this.elem.nativeElement.querySelector('#skill').value;
    let genderpreference=this.elem.nativeElement.querySelector('#genderpreference').value;
    let maimumage=this.elem.nativeElement.querySelector('#maimumage').value;
    let minAge:number =this.elem.nativeElement.querySelector('#minage').value;



    this.qulifucation.minimumqulification=minimumqulification;
    this.qulifucation.requiredexperience=requiredexperience;
    this.qulifucation.educationalspecialization=educationalspecialization;
    this.qulifucation.skill=skill;
    this.qulifucation.genderpreference=genderpreference;
    this.qulifucation.maximumage=maimumage;
    this.qulifucation.minimumage = minAge;


    this.jobPoster = new JobPoster();
    this,this.jobPoster.username = this.userDto.username;
    this.jobs.jobPosterDTO=this.jobPoster;

    this.postJob.qulificationDTO=this.qulifucation;
      const formData:FormData=new FormData();
      formData.append("file",this.imageFile);

      if(this.jobs.jobtitle == "" || this.jobs.category == "" || this.qulifucation.minimumqulification == ""){

        alert("Validate your form some fields are empty")
      }else {


        this.jobPosterProfileService.saveFile(formData).subscribe(
          (result) => {
            if (result) {
              this.jobs.iamgePath = result.path;
              this.postJob.jobsDTO = this.jobs;
              console.log(this.postJob)
              this.jobService.addJob(this.postJob).subscribe(
                (result) => {
                  this.loading = false;
                  if (result) {
                    confirm("New Job Added successfully")
                  } else {
                    confirm("Fail to Add Re-Try")
                  }
                }, error => {
                  this.loading = false;
                  confirm("Failed Save")
                }
              )
            }
          }, error => {
            this.loading = false;
            confirm("Failed Save")
          }
        )
      }
    }catch (e) {
      this.loading =false;
      alert("Validate your form some fields are empty")
    }
  }

  loadLoginedPoster():void{
    let user =sessionStorage.getItem("token");

    console.log(user)
    // @ts-ignore
    this.jobPoster.username - user.username;
    // this.jobposterService.getLoginedPoster().subscribe(
    //   (result)=>{
    //     this.jobPoster.username=result.username;
    //   }
    // )
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

  private getAllCategory() {
    this.categoryService.getAll().subscribe(res=>{
      this.categoryArray = res;
    })
  }
}
