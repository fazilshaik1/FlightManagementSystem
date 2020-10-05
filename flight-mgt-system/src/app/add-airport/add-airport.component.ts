import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { Airport } from '../model/airport';
import { AirportService } from '../service/airportservice';

@Component({
  selector: 'add-airport',
  templateUrl: './add-airport.component.html',
  styleUrls: ['./add-airport.component.css']
})
export class AddAirportComponent {

  

  constructor(private service:AirportService) {
  }
  
  airport:Airport;


  addAirport(form:any){
    let data=form.value;
    let airportName=data.airportName;
    let airportLocation=data.airportLocation;
    this.airport=new Airport(" ",airportName,airportLocation);
    let observable:Observable<Airport>=this.service.addAirport(this.airport);
    observable.subscribe(airportArg=>{
      this.airport=airportArg;
    }
    );
    
  }


}
