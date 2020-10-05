import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Schedule } from '../model/schedule';
import { ScheduleService } from '../service/scheduleservice';

@Component({
  selector: 'app-add-schedule',
  templateUrl: './add-schedule.component.html',
  styleUrls: ['./add-schedule.component.css']
})
export class AddScheduleComponent {

  constructor(private scheduleService:ScheduleService) { }

  schedule:Schedule;

  addSchedule(form:any){
    let data =form.value;
    let scheduleId=data.scheduleId;
    let arrivaldateStr=data.arrivalTime;
    let arrivaldate=new Date(arrivaldateStr);
    let departureDateStr=data.departureTime;
    let departureDate=new Date(departureDateStr);
    let sourceAirport=data.sourceAirport;
    let destinationAirport=data.destinationAirport;
    let airportCode=data.airportCode;
    this.schedule=new Schedule(scheduleId,arrivaldate,departureDate,sourceAirport,destinationAirport,airportCode);
    let observable:Observable<Schedule>=this.scheduleService.addSchedule(this.schedule);
    observable.subscribe(response=>{
      this.schedule=response;
    });
  }

}
