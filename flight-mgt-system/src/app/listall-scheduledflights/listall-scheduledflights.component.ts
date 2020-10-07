import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { ScheduledFlight } from '../model/scheduledflight';
import { ScheduledFlightService } from '../service/scheduledflightservice';

@Component({
  selector: 'app-listall-scheduledflights',
  templateUrl: './listall-scheduledflights.component.html',
  styleUrls: ['./listall-scheduledflights.component.css']
})
export class ListallScheduledflightsComponent {

  scheduledflights:ScheduledFlight[];

  constructor(private route:ActivatedRoute, private service:ScheduledFlightService) {
    let observable:Observable<ScheduledFlight[]>=service.findAllScheduledFlights();
    observable.subscribe(scheduledflightArg=>{
      this.scheduledflights=scheduledflightArg;
    });
   }

   removeScheduledflight(sfId:number){
    let observable=this.service.deleteSchedule(sfId);
    observable.subscribe(result=>{this.remove(sfId);
    });
   }

   remove(sfId:number):void{
    for(let i=0;i<this.scheduledflights.length;i++){
      let scheduledflight=this.scheduledflights[i];
      if(scheduledflight.sfId===sfId){
        this.scheduledflights.splice(i,1);
      }
    }
  }
  getDate (arrivalMillis:number ){
    let date = new Date(arrivalMillis);
    return date;
  }

 

}
