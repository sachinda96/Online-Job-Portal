import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {DashboardComponent} from '../view/dashboard/dashboard.component';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from '../view/login/login.component';
import {MainComponent} from '../view/main/main.component';
import {RegistationComponent} from '../view/registation/registation.component';
import {SelectRegistationComponent} from "../view/select-registation/select-registation.component";
import {PosterRegistationComponent} from "../view/poster-registation/poster-registation.component";
import {JobPosterDashBoardComponent} from "../view/job-poster-dash-board/job-poster-dash-board.component";
import {JobPosterMainComponent} from "../view/job-poster-main/job-poster-main.component";
import {ManageprofileComponent} from "../view/manageprofile/manageprofile.component";
import {PostjobComponent} from "../view/postjob/postjob.component";
import {ViewpostedjobsComponent} from "../view/viewpostedjobs/viewpostedjobs.component";
import {PosterJobDetailsComponent} from "../view/poster-job-details/poster-job-details.component";
import {ViewallPostedJobsComponent} from "../view/viewall-posted-jobs/viewall-posted-jobs.component";
import {ApplyselectjobComponent} from "../view/applyselectjob/applyselectjob.component";
import {JobseekerDashboardComponent} from "../view/jobseeker-dashboard/jobseeker-dashboard.component";
import {JobseekerMainComponent} from "../view/jobseeker-main/jobseeker-main.component";
import {JobseekerManageProfileComponent} from "../view/jobseeker-manage-profile/jobseeker-manage-profile.component";
import {ApplyComponent} from "../view/apply/apply.component";
import {ViewApplyedJobComponent} from "../view/view-applyed-job/view-applyed-job.component";
import {NewEmployeeComponent} from "../view/new-employee/new-employee.component";

const routes: Routes = [
  {path : 'Main', component: MainComponent,
    children: [
      {path: 'Dashboard', component: DashboardComponent,
      children:[
        {
          path: 'ViewAllJobs',
          pathMatch : 'full',
          redirectTo: '/Main/ViewAllJobs'
        },
        {
          path: 'ViewAllJobs/:name',
          pathMatch : 'full',
          redirectTo: '/Main/ViewAllJobs/:name'
        },
      ]},
      {
        path: 'SelectRegistation',
        component: SelectRegistationComponent,
        children: [
          {
            path: 'LoginRegister',
            pathMatch : 'full',
            redirectTo: '/Main/registation'
          },
          {
            path: 'JobPosterRegister',
            pathMatch : 'full',
            redirectTo: '/Main/JobPosterRegistation'
          },
        ]},


      {
        path: 'login',
        component: LoginComponent,
      children: [
        {
          path: 'LoginRegister',
          pathMatch : 'full',
          redirectTo: '/Main/SelectRegistation'
        },




      ]},



      {
        path: 'registation',
        component: RegistationComponent},

      {
        path: 'ViewAllJobs',
        component: ViewallPostedJobsComponent,
        children:[
          {
            path: 'SelectedJob',
            pathMatch: 'full',
            redirectTo: '/Main/SelectedJob'
          },
      ]},

      {
        path: 'ViewAllJobs/:name',
        component: ViewallPostedJobsComponent,
        children:[
          {
            path: 'SelectedJob',
            pathMatch: 'full',
            redirectTo: '/Main/SelectedJob'
          },
        ]},

      {
        path: 'JobPosterRegistation',
        component: PosterRegistationComponent},

      {
        path: 'SelectedJob/:id',
        component: ApplyselectjobComponent,
        children:[
          {
            path: 'ApplyJob',
            pathMatch: 'full',
            redirectTo: '/Main/ApplyJob'
          },
        ]},

      {
        path: 'ApplyJob',
        component: ApplyComponent},
      {
        path: 'ApplyJob/:id',
        component: ApplyComponent},
      {
        path: '',
        pathMatch : 'full',
        redirectTo: '/Main/Dashboard'
      }
    ]
  },
  {path : '', redirectTo:  '/Main/Dashboard', pathMatch : 'full' },

  {
    path: "JobPosterMain",
    component: JobPosterMainComponent,
    children: [
      {path: "dashboard", component: JobPosterDashBoardComponent},

      {
        path: "ManagePosterProfile",
        component: ManageprofileComponent
      },

      {
        path: "NewEmployee",
        component: NewEmployeeComponent
      },

      {
        path: "jobDetails",
        component: PosterJobDetailsComponent
      },

      {
        path: "ViewPostJobs",
        component: ViewpostedjobsComponent,
        children: [
          {
            path: "posterJobDetails",
            pathMatch : "full",
            redirectTo: "/JobPosterMain/jobDetails"
          }
          ]},

      {
        path: "PostJob",
        component: PostjobComponent
      },
      {
      path: "PostJob/:id",
      component: PostjobComponent
      },




      {
        path: "jobDetails",
        component: PosterJobDetailsComponent
      },

      {
        path: "",
        pathMatch : "full",
        redirectTo: "/JobPosterMain/dashboard"
      },

    ]
  },

  {path: "", pathMatch: "full", redirectTo: "/JobPosterMain/dashboard"},

  {
    path: "JobSeekerMain",
    component: JobseekerMainComponent,
    children: [
      {path: "dashboard", component: JobseekerDashboardComponent},
      {path: "ManageProfile", component: JobseekerManageProfileComponent},
      {
        path: "ApplyedJob",
        component: ViewApplyedJobComponent
      },
      {
        path: "",
        pathMatch : "full",
        redirectTo: "/JobSeekerMain/dashboard"
      },

    ]
  },

  {path: "", pathMatch: "full", redirectTo: "/JobPosterMain/dashboard"}

];
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
