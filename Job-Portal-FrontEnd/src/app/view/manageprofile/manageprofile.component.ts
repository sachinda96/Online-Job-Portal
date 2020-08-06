import {Component, ElementRef, OnInit} from '@angular/core';
import {JobPoster} from "../../dto/job-poster";
import {JobPosterProfile} from "../../dto/job-poster-profile";
import {JObPosterService} from "../../service/job-poster.service";
import {JobPosterProfileService} from "../../service/job-poster-profile.service";
import {User} from "../../dto/user";

@Component({
  selector: 'app-manageprofile',
  templateUrl: './manageprofile.component.html',
  styleUrls: ['./manageprofile.component.css']
})
export class ManageprofileComponent implements OnInit {

  jobposter:JobPoster=new JobPoster();
  userDto :User = new User();
  JObPOsterProfile:JobPosterProfile=new JobPosterProfile();
  file:File ;
  setImageFileName:string;
  loading : boolean =false;

  constructor(private elem:ElementRef,private jobPosterService:JObPosterService,private jobPosterProfleService:JobPosterProfileService) { }

  ngOnInit() {
 // this.getLoginPoster();
     this.userDto =JSON.parse(sessionStorage.getItem("token"));
     this.JObPOsterProfile.email =this.userDto.email;
     this.getJobPoster(this.userDto.username);

  }

  getJobPoster(userName : String){

    this.jobPosterProfleService.getJobPoster(userName).subscribe(
      res => {

        this.JObPOsterProfile.id = res.id;
        this.JObPOsterProfile.companyBackground = res.companyBackground;
        this.JObPOsterProfile.imagePath = res.imagePath;
        this.JObPOsterProfile.contactnumber = res.contactnumber;
        this.JObPOsterProfile.address = res.address;
        this.JObPOsterProfile.city = res.city;
        this.JObPOsterProfile.comapanyname =res.comapanyname;
      }
    )

  }


    saveJobPOsterProfile():void{

     // this.saveFile();
      this.loading =true;
      this.JObPOsterProfile.email=this.userDto.email;
      this.jobposter = new JobPoster();
      this.jobposter.username = this.userDto.username;
      this.JObPOsterProfile.jobPosterDTO = this.jobposter;



      if(this.file == null){
        this.jobPosterProfleService.saveJobPosterProfile(this.JObPOsterProfile).subscribe(
          (result) => {
            this.loading =false;
            if (result) {
              alert("Profile Update successfully");
            } else {
              alert("Profile Update Failed");
            }
          }, error => {
            this.loading = false;
            alert(error.error);
          }
        )
      }else {

        const formData:FormData=new FormData();
        formData.append("file",this.file);
        this.jobPosterProfleService.saveFile(formData).subscribe(
          (result) => {
            this.JObPOsterProfile.imagePath = result.path;

            this.jobPosterProfleService.saveJobPosterProfile(this.JObPOsterProfile).subscribe(
              (result) => {
                this.loading =false;
                if (result) {
                  alert("Profile Update successfully");
                } else {
                  alert("Profile Update Failed");
                }
              }, error => {
                this.loading =false;
                alert(error.error);
              }
            )
          }, error => {
            this.loading =false;
            alert("File Upload Failed");
          }
        )
      }
    }

  setImages(event){
    const fil = event.target.files[0]
    this.file=fil;

  }



}
