import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Flight } from '../model/flight';
import { FlightService } from '../service/flightservice';

@Component({
  selector: 'update-flight',
  templateUrl: './update-flight.component.html',
  styleUrls: ['./update-flight.component.css']
})
export class UpdateFlightComponent  {

  constructor(private sevice:FlightService) { }

  flight:Flight;

  modifyFlight(form:any){
    let data=form .value;
    let flightNumber=data.flightNumber;
    let flightModel=data.flightModel;
    let carrierName=data.carrierName;
    let seatCapacity=data.seatCapacity;
    this.flight=new Flight(flightNumber,flightModel,carrierName,seatCapacity);
    let observable:Observable<Flight>=this.sevice.modifyFlight(this.flight);
    observable.subscribe(flightArg=>{this.flight=flightArg;
    });
  }
  

}
