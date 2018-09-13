import {Component, ElementRef, OnInit} from '@angular/core';
import {JobPoster} from "../../dto/job-poster";
import {JobPosterProfile} from "../../dto/job-poster-profile";
import {JObPosterService} from "../../service/job-poster.service";
import {JobPosterProfileService} from "../../service/job-poster-profile.service";

@Component({
  selector: 'app-manageprofile',
  templateUrl: './manageprofile.component.html',
  styleUrls: ['./manageprofile.component.css']
})
export class ManageprofileComponent implements OnInit {

  jobposter:JobPoster=new JobPoster();
  JObPOsterProfile:JobPosterProfile=new JobPosterProfile();
  file:File;
  setImageFileName:string;

  constructor(private elem:ElementRef,private jobPosterService:JObPosterService,private jobPosterProfleService:JobPosterProfileService) { }

  ngOnInit() {
  this.getLoginPoster();
  }

  getLoginPoster():void {
    this.jobPosterService.getLoginedPoster().subscribe(
      (result) => {
        this.jobposter = result;
        console.log(this.jobposter)
      }
    )
  }

  saveFile():void {
    this.JObPOsterProfile.comapanyname=this.jobposter.companyname
    this.JObPOsterProfile.email=this.jobposter.email;
    this.JObPOsterProfile.jobPosterDTO = this.jobposter;

    const formData:FormData=new FormData();
   formData.append("file",this.file);
   console.log(this.file)
      this.jobPosterProfleService.saveFile(formData).subscribe(
        (result)=>{
          if(result){
            this.jobPosterProfleService.saveJobPosterProfile(this.JObPOsterProfile).subscribe(
              (result)=>{
                if(result){
                  alert("Profile Update successfully");
                }else{
                  alert("Profile Update Failed");
                }
              }
            )
          }
        }
      )
    }

    saveJobPOsterProfile():void{

      this.saveFile();
      this.JObPOsterProfile.comapanyname=this.jobposter.companyname
      this.JObPOsterProfile.email=this.jobposter.email;
      this.JObPOsterProfile.jobPosterDTO = this.jobposter;

      this.jobPosterProfleService.saveJobPosterProfile(this.JObPOsterProfile).subscribe(
        (result)=>{
          if(result){
            alert("Profile Update successfully");
          }else{
            alert("Profile Update Failed");
          }
        }
      )
    }

  setImages(event){
    const fil = event.target.files[0]

    this.file=fil;

    console.log(this.file)

  }



}
