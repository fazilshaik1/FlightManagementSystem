import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Passenger } from '../model/passenger';
import { PassengerService } from '../service/passengerservice';

@Component({
  selector: 'app-listall-passengers',
  templateUrl: './listall-passengers.component.html',
  styleUrls: ['./listall-passengers.component.css']
})
export class ListallPassengersComponent  {

  passengers:Passenger[];

  constructor(private service:PassengerService) { 
    let observable:Observable<Passenger[]>=service.fetchAllPassengers();
    observable.subscribe( userArg=>{
      this.passengers=userArg;
    });
  }

  

}

