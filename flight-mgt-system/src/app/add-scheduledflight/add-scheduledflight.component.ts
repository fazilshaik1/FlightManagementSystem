import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ScheduledFlight } from '../model/scheduledflight';
import { ScheduledFlightService } from '../service/scheduledflightservice';

@Component({
  selector: 'app-add-scheduledflight',
  templateUrl: './add-scheduledflight.component.html',
  styleUrls: ['./add-scheduledflight.component.css']
})
export class AddScheduledflightComponent {

  constructor(private service:ScheduledFlightService) { }

  scheduledflight:ScheduledFlight;

  addScheduledFlight(form:any){
    let data = form.value;
    let availableSeats=data.availableSeats;
    let scheduleId=data.scheduleId;
    let flightNumber=data.flightNumber;
    this.scheduledflight= new ScheduledFlight(availableSeats,scheduleId,flightNumber);
    let observable:Observable<ScheduledFlight>=this.service.addScheduledFlight(this.scheduledflight)
    observable.subscribe(response=>{
      this.scheduledflight=response;
    });
  }



}
