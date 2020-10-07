import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { ScheduledFlight } from '../model/scheduledflight';
import { ScheduledFlightService } from '../service/scheduledflightservice';

@Component({
  selector: 'app-get-scheduledflight',
  templateUrl: './get-scheduledflight.component.html',
  styleUrls: ['./get-scheduledflight.component.css']
})
export class GetScheduledflightComponent {

  constructor(private route:ActivatedRoute, private service:ScheduledFlightService) { 
    let observable=route.paramMap;
    observable.subscribe((params:ParamMap)=>{
      let val:String =params.get("sfId");
      let id:number=Number(val);
      this.getScheduledFlightBySfId(id);
    })
  }

  scheduledflight:ScheduledFlight;

  getScheduledFlightBySfId(sfId:number){
    let observable:Observable<ScheduledFlight>=this.service.findScheduledFlightById(sfId);
    observable.subscribe( scheduledflightArg=>{this.scheduledflight=scheduledflightArg});
  }

  findScheduledFlight(form:any){
    let data=form.value;
    let sfId=data.sfId;
    this.getScheduledFlightBySfId(sfId);
  }
  getDate (arrivalMillis:number ){
    let date = new Date(arrivalMillis);
    return date;
  }

}
