import { Component, OnInit } from '@angular/core';
import {EducationpartnerService} from "../../service/educationpartner.service";
import {CourseService} from "../../service/course.service";

@Component({
  selector: 'app-educational-partner-dash-board',
  templateUrl: './educational-partner-dash-board.component.html',
  styleUrls: ['./educational-partner-dash-board.component.css']
})
export class EducationalPartnerDashBoardComponent implements OnInit {
  totalRemovedCourses: number = 0;
  totalActiveCourses: number=0;
  totalEducationalCenters: number =0;


  constructor(private educationpartnerService:EducationpartnerService,private courseService:CourseService) { }

  ngOnInit() {
    this.educationpartnerService.countAll().subscribe(
      res=>{
        this.totalEducationalCenters=res;
      }
    );

    this.courseService.countAllActive().subscribe(
      res=>{
        this.totalActiveCourses=res;
      }
    );

    this.courseService.countAllInActive().subscribe(
      res=>{
        this.totalRemovedCourses=res;
      }
    );


  }

}
