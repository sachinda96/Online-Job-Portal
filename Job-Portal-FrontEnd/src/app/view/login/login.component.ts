import { Component, OnInit } from '@angular/core';
import {User} from "../../dto/user";
import {AuthService} from "../../service/auth.service";
import {JobPosterProfileService} from "../../service/job-poster-profile.service";
import {JObPosterService} from "../../service/job-poster.service";
import {JobPoster} from "../../dto/job-poster";
import {JobPosterProfile} from "../../dto/job-poster-profile";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user:User=new User();
  failed: boolean;


  constructor(private authService:AuthService) { }

  ngOnInit() {
  }



  logIn():void{
    this.authService.login(this.user).subscribe(
      (result)=>{
        this.failed = !result;
      }
    );
  }
}



