import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { Schedule } from '../model/schedule';
import { ScheduleService } from '../service/scheduleservice';

@Component({
  selector: 'app-get-schedule',
  templateUrl: './get-schedule.component.html',
  styleUrls: ['./get-schedule.component.css']
})
export class GetScheduleComponent {

  constructor(private route:ActivatedRoute,private service:ScheduleService) { 
    let observable=route.paramMap;
    observable.subscribe((params:ParamMap)=>{
      let codeVal:string=params.get("scheduleId");
      let id:number=Number(codeVal);
       console.log("scheduleId is "+id);
  })
}

  schedule:Schedule;

  getScheduleById(scheduleId:number){
    let  observable:Observable<Schedule>=this.service.findScheduleById(scheduleId);
    observable.subscribe(scheduleArg=>{this.schedule=scheduleArg});
  }

  findSchedule(form:any){
    let data=form.value;
    let scheduleId=data.scheduleId;
    this.getScheduleById(scheduleId);
  }

  getDate(millis:number){
    let date=new Date(millis);
    return date;
  }



  

}
