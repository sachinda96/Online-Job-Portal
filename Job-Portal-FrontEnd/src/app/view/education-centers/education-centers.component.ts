import { Component, OnInit } from '@angular/core';
import { EducationCenter } from 'src/app/dto/education-center';
import { User } from 'src/app/dto/user';
import { EducationpartnerService } from 'src/app/service/educationpartner.service';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-education-centers',
  templateUrl: './education-centers.component.html',
  styleUrls: ['./education-centers.component.css']
})
export class EducationCentersComponent implements OnInit {

  educationCenter:EducationCenter = new EducationCenter();

  loading:boolean=false;

  userDto :User = new User();

  constructor(private educationPartner:EducationpartnerService,private routerActive:ActivatedRoute) { }

  ngOnInit() {
    this.routerActive.params.subscribe(params =>{

      if(params.id != null || params.id != undefined) {
        this.educationCenter.id = params.id;
        this.educationPartner.educationCenter(params.id).subscribe(
          res=>{
            this.educationCenter =res;
          }
        );
      }
    });

    this.userDto =JSON.parse(sessionStorage.getItem("token"));
  }

  save(){
    console.log("set")
    this.loading = true;
    this.educationCenter.userName=this.userDto.username;
    this.educationPartner.addEducationCenter(this.educationCenter).subscribe(
      res=>{
        console.log(res)
        this.loading =false
        alert(res)
      },error=>{
        console.log(error)
        this.loading=false;
        alert(error);
      });

  }

}
