import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Airport } from '../model/airport';
import { AirportService } from '../service/airportservice';

@Component({
  selector: 'listall-airports',
  templateUrl: './listall-airports.component.html',
  styleUrls: ['./listall-airports.component.css']
})
export class ListallAirportsComponent  {

  airports:Airport[];

  constructor(private service:AirportService) {
    let observable:Observable<Airport[]>=service.getAllAirports();
    observable.subscribe( airportArg=>{
      this.airports=airportArg;
    });
   }

   removeAirport(airportCode:string){
     let observable=this.service.removeAirport(airportCode);
     observable.subscribe(result=>{this.removeCode(airportCode);
     });
   }
 
   removeCode(airportCode:string):void{
     for(let i=0;i<this.airports.length;i++){
       let airport=this.airports[i];
       if(airport.airportCode===airportCode){
         this.airports.splice(i,1);
       }
     }
   }

}
