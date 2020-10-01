import { Component, OnInit } from '@angular/core';
import { EducationCenter } from 'src/app/dto/education-center';
import {EducationalPartner} from "../../dto/educational-partner";
import {EducationpartnerService} from "../../service/educationpartner.service";
import {User} from "../../dto/user";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-all-education-centers',
  templateUrl: './all-education-centers.component.html',
  styleUrls: ['./all-education-centers.component.css']
})
export class AllEducationCentersComponent implements OnInit {


  educationalCenterArray:Array<EducationCenter>= new Array();
  userDto :User = new User();
  constructor(private educationPartnerService:EducationpartnerService,private route:Router,private routerActive:ActivatedRoute) { }

  ngOnInit() {
    this.userDto =JSON.parse(sessionStorage.getItem("token"));

    this.getAll();
  }

  getAll(){
    this.educationPartnerService.allEducationCenterByUser(this.userDto.username).subscribe(
      res=>{
        this.educationalCenterArray=res;
      },error => {
        alert(error);
      }
    );
  }

  delete(id: String) {
    this.educationPartnerService.deleteEducationCenter(id).subscribe(
      res=>{
        alert(res);
        this.getAll();
      },error => {
        alert(error);
      }
    );
  }

  edit(id: String) {
    this.route.navigate(['EPMAIN/educationcenters/'+id])

  }
}
