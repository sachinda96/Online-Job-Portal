import { Component, OnInit } from '@angular/core';
import {Course} from "../../dto/course";
import {ActivatedRoute} from "@angular/router";
import {CourseService} from "../../service/course.service";

@Component({
  selector: 'app-view-selected-course',
  templateUrl: './view-selected-course.component.html',
  styleUrls: ['./view-selected-course.component.css']
})
export class ViewSelectedCourseComponent implements OnInit {

  course:Course = new Course();

  constructor(private  routerActive :ActivatedRoute,private courseService:CourseService) { }

  ngOnInit() {

    this.routerActive.params.subscribe(params =>{
      this.getSelectedCourse(params.id)
    })
  }

  getSelectedCourse(id: String) {
    this.courseService.searchCourses(id).subscribe(
      res=>{
        this.course =res;
      }
    );
  }
}
