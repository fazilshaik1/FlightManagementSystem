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
    let arrivalMillis=arrivalTime.getTime();
    console.log("arrival time chosen is "+arrivalMillis+" local format is"+arrivalTime);
    let departureDateStr=data.departureTime;
    let departureTime=new Date(departureDateStr);
    let departureMillis=departureTime.getTime();
    console.log("departure time chosen is "+departureMillis+" local format is "+departureTime);
    let sourceAirport=data.sourceAirport;
    let destinationAirport=data.destinationAirport;
    let airportCode=data.airportCode;
    this.schedule=new Schedule(arrivalMillis,departureMillis,sourceAirport,destinationAirport,airportCode);
    let observable:Observable<Schedule>=this.scheduleService.addSchedule(this.schedule);
    observable.subscribe(response=>{
      this.schedule=response;
    });
  }

  getDate (arrivalMillis:number ){
    let date = new Date(arrivalMillis);
    return date;
  }

}
