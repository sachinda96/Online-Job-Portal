import { Component, OnInit } from '@angular/core';
import {JobSeekerProfile} from "../../dto/job-seeker-profile";
import {User} from "../../dto/user";
import {AuthService} from "../../service/auth.service";
import {JobPosterProfileService} from "../../service/job-poster-profile.service";
import {JobSeekerProfileService} from "../../service/job-seeker-profile.service";

@Component({
  selector: 'app-jobseeker-manage-profile',
  templateUrl: './jobseeker-manage-profile.component.html',
  styleUrls: ['./jobseeker-manage-profile.component.css']
})
export class JobseekerManageProfileComponent implements OnInit {

  jobSeekerProfile:JobSeekerProfile=new JobSeekerProfile();
  imagefile:File;
  CvFile:File;
  user:User;
  MainUser:User=new User();
  constructor(private authService:AuthService,private jobSeekerProfileService:JobSeekerProfileService) { }

  ngOnInit() {
    this.getJobSeeker();
  }

  getJobSeeker():void{
    this.user=this.authService.getUser();
    this.MainUser.username=this.user.username;
    this.MainUser.email=this.user.email;
    this.MainUser.password=this.user.password;
    console.log(this.MainUser)
  }

  setImages(event){
    const fil = event.target.files[0]

    this.imagefile=fil;

    console.log(this.imagefile)

  }

  setCV(event){
    const fil = event.target.files[0]

    this.CvFile=fil;

    console.log(this.CvFile)

  }

  saveProfile():void{

    const formdata:FormData=new FormData();
    formdata.append("imageFile",this.imagefile)
    this.jobSeekerProfileService.uploadImage(formdata).subscribe(
      (result)=>{
        if(result){
          const  formdataCv:FormData=new FormData();
          formdataCv.append("CVFile",this.CvFile)
          this.jobSeekerProfileService.uploadCV(formdataCv).subscribe(
            (result)=>{
              if(result){
                this.user=this.authService.getUser();
                this.jobSeekerProfile.userDTO=this.MainUser;
                this.jobSeekerProfileService.saveProfile(this.jobSeekerProfile).subscribe(
                  (result)=>{
                    if(result){
                      alert("Sucsess")
                    }else{
                      alert("fail")
                    }
                  }
                )
              }
            }
          )
        }
      }
    )
   }
}
