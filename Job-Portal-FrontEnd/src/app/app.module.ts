import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { DashboardComponent } from './view/dashboard/dashboard.component';
import {AppRoutingModule} from './app-routing/app-routing.module';
import { LoginComponent } from './view/login/login.component';
import { MainComponent } from './view/main/main.component';
import { RegistationComponent } from './view/registation/registation.component';
import { ApplyComponent } from './view/apply/apply.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {UserServiceService} from "./service/user-service.service";
import {AuthService} from "./service/auth.service";
import { PosterRegistationComponent } from './view/poster-registation/poster-registation.component';
import {JObPosterService} from "./service/job-poster.service";
import { SelectRegistationComponent } from './view/select-registation/select-registation.component';
import { JobPosterDashBoardComponent } from './view/job-poster-dash-board/job-poster-dash-board.component';
import { JobPosterMainComponent } from './view/job-poster-main/job-poster-main.component';
import { ManageprofileComponent } from './view/manageprofile/manageprofile.component';
import { PostjobComponent } from './view/postjob/postjob.component';
import { ViewpostedjobsComponent } from './view/viewpostedjobs/viewpostedjobs.component';
import {JobPosterProfileService} from "./service/job-poster-profile.service";
import {JobsService} from "./service/jobs.service";
import { PosterJobDetailsComponent } from './view/poster-job-details/poster-job-details.component';
import {QulificationService} from "./service/qulification.service";
import { ViewallPostedJobsComponent } from './view/viewall-posted-jobs/viewall-posted-jobs.component';
import { ApplyselectjobComponent } from './view/applyselectjob/applyselectjob.component';
import { JobseekerMainComponent } from './view/jobseeker-main/jobseeker-main.component';
import { JobseekerDashboardComponent } from './view/jobseeker-dashboard/jobseeker-dashboard.component';
import { JobseekerManageProfileComponent } from './view/jobseeker-manage-profile/jobseeker-manage-profile.component';
import {JobSeekerProfileService} from "./service/job-seeker-profile.service";
import {ApplyJobService} from "./service/apply-job.service";
import { ViewApplyedJobComponent } from './view/view-applyed-job/view-applyed-job.component';
import { NewEmployeeComponent } from './view/new-employee/new-employee.component';
import {CategoryService} from "./service/category.service";


@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    LoginComponent,
    MainComponent,
    RegistationComponent,
    ApplyComponent,
    PosterRegistationComponent,
    SelectRegistationComponent,
    JobPosterDashBoardComponent,
    JobPosterMainComponent,
    ManageprofileComponent,
    PostjobComponent,
    ViewpostedjobsComponent,
    PosterJobDetailsComponent,
    ViewallPostedJobsComponent,
    ApplyselectjobComponent,
    JobseekerMainComponent,
    JobseekerDashboardComponent,
    JobseekerManageProfileComponent,
    ViewApplyedJobComponent,
    NewEmployeeComponent,
  ],
  imports: [

    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    UserServiceService,
    JObPosterService,
    JobPosterProfileService,
    JobsService,
    CategoryService,
    JobSeekerProfileService,
    ApplyJobService,
    AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
