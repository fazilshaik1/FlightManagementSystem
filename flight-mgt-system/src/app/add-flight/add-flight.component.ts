import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Flight } from '../model/flight';
import { FlightService } from '../service/flightservice';

@Component({
  selector: 'add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent {

  constructor(private service:FlightService) {

   }

   flight:Flight;

   addFlight(form:any){
     let data=form.value;
     let flightModel=data.flightModel;
     let carrierName=data.carrierName;
     let seatCapacity=data.seatCapacity;
     this.flight=new Flight(-1,flightModel,carrierName,seatCapacity);
     let observable:Observable<Flight>=this.service.addFlight(this.flight);
     observable.subscribe(flightArg=>{
       this.flight=flightArg;
     });
   }

}
