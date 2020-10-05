import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Flight } from '../model/flight';
import { FlightService } from '../service/flightservice';

@Component({
  selector: 'listall-flights',
  templateUrl: './listall-flights.component.html',
  styleUrls: ['./listall-flights.component.css']
})
export class ListallFlightsComponent {

  flights:Flight[];
  
  constructor(private service:FlightService) {
    let observable:Observable<Flight[]>=service.getAllFlights();
    observable.subscribe(flightArg=>{
      this.flights=flightArg;
    });
   }

   removeFlight(flightNumber:number){
     let observable=this.service.removeFlight(flightNumber);
     observable.subscribe(result=>{this.removeNumber(flightNumber);
    });
   }

   removeNumber(flightNumber:number):void{
     for(let i=0;i<this.flights.length;i++){
       let flight=this.flights[i];
       if(flight.flightNumber===flightNumber){
         this.flights.splice(i,1);
       }
     }
   }
  
}
