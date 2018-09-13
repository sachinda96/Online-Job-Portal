import {User} from "./user";

export class JobSeekerProfile {
  id:number;
  firstName:string;
  lastName:string;
  interstIn:string;
  emailAddress:string;
  address:string;
  province:string;
  city:string;
  birthDay:string;
  phoneNumber:string;
  highestEducation:string;
  stream:string;
  imagePath:string;
  cvPath:string;
  userDTO:User;
}
