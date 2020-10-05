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

  addSchedule(myform:any){
    let data =myform.value;
    let arrivaldateStr=data.arrivalTime;
    let arrivalTime=new Date(arrivaldateStr);
    let arrivalMillis=arrivalTime.getMilliseconds;
    console.log("arrival time chosen is "+arrivalTime);
    let departureDateStr=data.departureTime;
    let departureTime=new Date(departureDateStr);
    let departureMillis=departureTime.getMilliseconds;
    console.log("departure time chosen is "+departureTime);
    let sourceAirport=data.sourceAirport;
    let destinationAirport=data.destinationAirport;
    let airportCode=data.airportCode;
    this.schedule=new Schedule(arrivalMillis,departureMillis,sourceAirport,destinationAirport,airportCode);
    let observable:Observable<Schedule>=this.scheduleService.addSchedule(this.schedule);
    observable.subscribe(response=>{
      this.schedule=response;
    });
  }

}
