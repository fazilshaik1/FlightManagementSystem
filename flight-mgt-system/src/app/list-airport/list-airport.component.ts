import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { Airport } from '../model/airport';
import { AirportService } from '../service/airportservice';

@Component({
  selector: 'list-airport',
  templateUrl: './list-airport.component.html',
  styleUrls: ['./list-airport.component.css']
})
export class ListAirportComponent implements OnInit {
  
  constructor(private route:ActivatedRoute,private service:AirportService) {
let observable=route.paramMap;
observable.subscribe((params:ParamMap)=>{
  let codeVal:string=params.get("airportCode");
  console.log("code is "+codeVal);
  this.getAirportByCode(codeVal);
  
})
  }

  airport:Airport;

getAirportByCode(airportCode:string){
  let observable:Observable<Airport>=this.service.getAirport(airportCode);
  observable.subscribe( airportArg=>{this.airport=airportArg});
}

findAirport(form:any){
  let data=form.value;
  let airportCode=data.airportCode;
  this.getAirportByCode(airportCode);
}
  ngOnInit(): void {
  }

}
