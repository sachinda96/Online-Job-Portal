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
  loading :boolean =false;
  constructor(private authService:AuthService,private jobSeekerProfileService:JobSeekerProfileService,private jobPosterProfileService:JobPosterProfileService) { }

  ngOnInit() {
    this.MainUser =JSON.parse(sessionStorage.getItem("token"));
    this.jobSeekerProfile.emailAddress =this.MainUser.email;
    this.getJobSeeker();
  }

  getJobSeeker():void{
  this.jobSeekerProfileService.searchJobSeeker(this.MainUser.username).subscribe(res=>{
    this.jobSeekerProfile = res;
  })
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

    this.loading = true;
    const formdata:FormData=new FormData();
    formdata.append("file",this.imagefile)
    this.jobPosterProfileService.saveFile(formdata).subscribe(
      (result)=>{
        if(result){
          this.jobSeekerProfile.imagePath = result.path
          const  formdataCv:FormData=new FormData();
          formdataCv.append("file",this.CvFile)
          this.jobPosterProfileService.saveFile(formdataCv).subscribe(
            (result)=>{
              if(result){
                this.jobSeekerProfile.cvPath = result.path;
                this.jobSeekerProfile.userDTO=this.MainUser;
                console.log(this.jobSeekerProfile)
                this.jobSeekerProfileService.saveProfile(this.jobSeekerProfile).subscribe(
                  (result)=>{
                    this.loading =false;
                    if(result == 200){
                      alert("Successfully saved")
                    }else{
                      alert("Fail to save")
                    }
                  },error => {
                    this.loading =false;
                    alert("Fail to save")
                  }
                )
              }
            },error => {
              this.loading = false;
              alert("Fail to save")
            }
          )
        }
      },error => {
        this.loading =true;
        alert("Fail to save")
      }
    )
   }
}
