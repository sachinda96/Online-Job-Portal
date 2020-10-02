import {Component, ElementRef, OnInit} from '@angular/core';
import {EducationpartnerService} from "../../service/educationpartner.service";
import {User} from "../../dto/user";
import {EducationCenter} from "../../dto/education-center";
import {Course} from "../../dto/course";
import {CourseService} from "../../service/course.service";
import {error} from "util";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-new-course',
  templateUrl: './new-course.component.html',
  styleUrls: ['./new-course.component.css']
})
export class NewCourseComponent implements OnInit {

  loading: any;
  userDto :User = new User();
  educationalCenterArray:Array<EducationCenter> = new Array<EducationCenter>();
  tempEducationalCenterArray:Array<EducationCenter> = new Array<EducationCenter>();
  tempEducationCenter:EducationCenter = new EducationCenter();
  course:Course =new Course();


  constructor(private elem: ElementRef,private educationpartnerService:EducationpartnerService,private courseService:CourseService,private routerActive:ActivatedRoute) { }

  ngOnInit() {
    this.userDto =JSON.parse(sessionStorage.getItem("token"));

    this.routerActive.params.subscribe(params =>{

      if(params.id != null || params.id != undefined) {
        this.courseService.searchCourses(params.id).subscribe(
          res=>{
            this.course =res;
            this.tempEducationalCenterArray=this.course.educationCenterDTOList;
          }
        );
      }
    });

    this.getAllEducationCenter();
  }

  getAllEducationCenter(){
    this.educationpartnerService.allEducationCenterByUser(this.userDto.username).subscribe(
      res=>{
        this.educationalCenterArray=res;
      }
    );
  }

  setEducationCenter(data){
    let value = data.value;
    this.tempEducationCenter=this.educationalCenterArray.find(e=> e.id === value);
  }

  save() {
    this.loading=true;
    this.course.userName=this.userDto.username;
    this.course.educationCenterDTOList=this.tempEducationalCenterArray;
    this.courseService.save(this.course).subscribe(res=>{
      this.loading=false;
      alert(res);
    },error=>{
      console.log(error)
      this.loading=false;
      alert(error);
    })
  }

  delete(data: EducationCenter) {
    this.tempEducationalCenterArray.splice(this.tempEducationalCenterArray.indexOf(data),1)
  }

  add() {
    this.tempEducationalCenterArray.push(this.tempEducationCenter)
  }
}
