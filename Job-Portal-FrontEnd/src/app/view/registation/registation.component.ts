import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {User} from "../../dto/user";
import {NgForm} from "@angular/forms";
import {UserServiceService} from "../../service/user-service.service";
import {JobPoster} from "../../dto/job-poster";
import {JObPosterService} from "../../service/job-poster.service";
import { EducationalPartner } from 'src/app/dto/educational-partner';
import { EducationpartnerService } from 'src/app/service/educationpartner.service';

@Component({
  selector: 'app-registation',
  templateUrl: './registation.component.html',
  styleUrls: ['./registation.component.css']
})
export class RegistationComponent implements OnInit {
  @ViewChild("frmRegistation") frmRegistation: NgForm;
  Cheakpassword:string="";
  user:User=new User();
  isSeeker : boolean =false;
  isPoster: boolean =false;
  jobposter:JobPoster=new JobPoster();
  educationPartner:EducationalPartner ;

  constructor(private elem: ElementRef,private userService:UserServiceService,private jobPosterService:JObPosterService,
    private educationPartnerService:EducationpartnerService) { }

  ngOnInit() {
  }

  RegisterUser():void{
    this.Cheakpassword = "";
    let username = this.elem.nativeElement.querySelector('#username').value;
    let email = this.elem.nativeElement.querySelector('#email').value;
    let password = this.elem.nativeElement.querySelector('#password').value;
    let repassword = this.elem.nativeElement.querySelector('#repassword').value;
    let userSection = this.elem.nativeElement.querySelector('#usersection').value;
      if(password==repassword){
        if(userSection == "SEEKER"){
          this.user.username=username;
          this.user.email=email;
          this.user.password=password;
          this.userService.addUser(this.user).subscribe(
            (result)=>{
              if(result){
                alert("Registation successfully");
              }else{
                alert("Registation Failed");
              }
            }

          )
        }else if(userSection == "POSTER"){
          this.jobposter.username = username;
          this.jobposter.companyname ="";
          this.jobposter.email =email;
          this.jobposter.password =password;
          this.jobPosterService.registerJobPoster(this.jobposter).subscribe(
            (result)=>{
              if(result){
                alert("Registation successfully");
              }else{
                alert("Registation Failed");
              }
            }

          )

        }else{
            this.educationPartner = new EducationalPartner();
            this.educationPartner.email = email;
            this.educationPartner.password=password;
            this.educationPartner.username =username;

            this.educationPartnerService.registor(this.educationPartner).subscribe(
              res=>{
                if(res){
                  alert("Registation successfully");
                }else{
                  alert("Registation Failed");
                }
              }
            );
        }


    }else{
      this.Cheakpassword="Doesn't match passwords ";
    }
  }

  selectJobSeeker() {
    if(this.isSeeker == true){
      this.isSeeker =false;
    }else{
      this.isSeeker =true;
      this.isPoster = false;

    }
  }

  selectJobPoster() {
    if(this.isPoster == true){
      this.isPoster =false;
    }else{
      this.isPoster =true;
      this.isSeeker = false;

    }
  }
}
