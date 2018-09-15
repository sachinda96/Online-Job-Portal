import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../../service/auth.service";

@Component({
  selector: 'app-jobseeker-main',
  templateUrl: './jobseeker-main.component.html',
  styleUrls: ['./jobseeker-main.component.css']
})
export class JobseekerMainComponent implements OnInit {

  constructor(private route:Router,private authService:AuthService) { }

  ngOnInit() {
  }

  routeHome():void{
    this.route.navigate(['/Main/Dashboard']);

  }

  logOut():void{
    this.authService.logout();
    this.route.navigate(['/Main/Dashboard']);
  }
}
