import {JobPoster} from "./job-poster";

export class Jobs {

  id:number;
  jobtitle:string;
  discription:string;
  category:string;
  industry:string;
  bussinessfuntion:string;
  role:string;
  minsalary:number;
  maxsalary:number;
  totalvacncis:number;
  dedlinedate:string;
  iamgePath:string;
  jobPosterDTO:JobPoster;
}
