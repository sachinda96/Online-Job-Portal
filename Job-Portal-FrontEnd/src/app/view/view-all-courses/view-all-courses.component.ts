import { Component, OnInit } from '@angular/core';
import {Course} from "../../dto/course";
import {CourseService} from "../../service/course.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-view-all-courses',
  templateUrl: './view-all-courses.component.html',
  styleUrls: ['./view-all-courses.component.css']
})
export class ViewAllCoursesComponent implements OnInit {
  allCourses: Array<Course> = new Array<Course>();

  constructor(private courseService:CourseService,private router:Router) { }

  ngOnInit() {

    this.getAllCourse();
  }

  setSelected(id: String) {
    this.router.navigate(['/Main/viewSelectedCourse/'+id]);
  }

  getAllCourse() {
    this.courseService.getAll().subscribe(res=>{
      this.allCourses=res;
    })
  }
}
