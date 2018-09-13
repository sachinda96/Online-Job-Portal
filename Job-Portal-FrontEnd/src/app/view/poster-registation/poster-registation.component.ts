import {Component, ElementRef, OnInit} from '@angular/core';
import {JobPoster} from "../../dto/job-poster";
import {JObPosterService} from "../../service/job-poster.service";

@Component({
  selector: 'app-poster-registation',
  templateUrl: './poster-registation.component.html',
  styleUrls: ['./poster-registation.component.css']
})
export class PosterRegistationComponent implements OnInit {

  Cheakpassword:String="";
  jobposter:JobPoster=new JobPoster();
  constructor(private elem:ElementRef,private jobPosterService:JObPosterService) { }

  ngOnInit() {
  }

  RegisterJobPoster():void{

    let password = this.elem.nativeElement.querySelector('#password').value;
    let repassword = this.elem.nativeElement.querySelector('#repassword').value;
    if(password==repassword) {

          this.jobPosterService.registerJobPoster(this.jobposter).subscribe(
            (result)=>{
              if(result){
                alert("Registation successfully");
              }else{
                alert("Registation Failed");
              }
            }

          )
        }else{
          this.Cheakpassword="Doesn't match passwords ";
        }

    }

}
