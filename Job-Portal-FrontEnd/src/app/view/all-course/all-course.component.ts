import { Component, OnInit } from '@angular/core';
import {Course} from "../../dto/course";
import {User} from "../../dto/user";
import {CourseService} from "../../service/course.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-all-course',
  templateUrl: './all-course.component.html',
  styleUrls: ['./all-course.component.css']
})
export class AllCourseComponent implements OnInit {
  allCourseArray: Array<Course> = new Array<Course>();

  userDto :User = new User();

  constructor(private courseService:CourseService,private route:Router) { }

  ngOnInit() {
    this.userDto =JSON.parse(sessionStorage.getItem("token"));
    this.getAllCourses();
  }

  delete(id: any) {
      this.courseService.delete(id).subscribe(res=>{
        alert(res);
        this.ngOnInit();
      },error => {
        alert(error)
      })
  }

  edit(id: any) {
    this.route.navigate(['EPMAIN/newcourse/'+id])
  }

   getAllCourses() {
    this.courseService.getAllByUser(this.userDto.username).subscribe(
      res=>{
        this.allCourseArray=res;
      }
    );

  }
}
