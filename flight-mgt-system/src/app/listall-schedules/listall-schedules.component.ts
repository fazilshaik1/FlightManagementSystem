import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Schedule } from '../model/schedule';
import { ScheduleService } from '../service/scheduleservice';

@Component({
  selector: 'app-listall-schedules',
  templateUrl: './listall-schedules.component.html',
  styleUrls: ['./listall-schedules.component.css']
})
export class ListallSchedulesComponent {

  schedules:Schedule[];

  constructor(private route:ActivatedRoute,private scheduleService:ScheduleService) { 
    let observable:Observable<Schedule[]>=scheduleService.findAllSchedules();
    observable.subscribe(scheduleArg=>{this.schedules=scheduleArg});
  }

  removeSchedule(scheduleId:number){
    let observable=this.scheduleService.deleteSchedule(scheduleId);
    observable.subscribe(result=>{this.remove(scheduleId)});
  }

  remove(scheduleId:number):void{
    for(let i=0;i<this.schedules.length;i++){
      let schedule=this.schedules[i];
      if(schedule.scheduleId===scheduleId){
        this.schedules.splice(i,1);
      }
    }
  }
  getDate (arrivalMillis:number ){
    let date = new Date(arrivalMillis);
    return date;
  }

  

}
