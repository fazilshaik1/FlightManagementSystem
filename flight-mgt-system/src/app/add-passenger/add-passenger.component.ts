import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Passenger } from '../model/passenger';
import { PassengerService } from '../service/passengerservice';

@Component({
  selector: 'app-add-passenger',
  templateUrl: './add-passenger.component.html',
  styleUrls: ['./add-passenger.component.css']
})
export class AddPassengerComponent  {

  constructor(private passengerservice:PassengerService) { }
  passenger:Passenger;

  addPassenger(form: any) {
    let data = form.value;
   
      let passengerName=data.passengerName;
      let passengerAge=data.passengerAge;
      let passengerUIN=data.passengerUIN;
      let gender=data.gender;
      
      console.log("add passenger constructor")
      console.log("passengerName"+passengerName)
      console.log("passengerAge"+passengerAge)
      console.log("passengerUIN"+passengerUIN)
      console.log("gender"+gender)
      

    this.passenger = new Passenger(passengerName,passengerAge,passengerUIN,gender);
    let successFun = (passengerArg: Passenger) => {
      this.passenger = passengerArg;
    };

    let errFun = err => {
      console.log("err in addtestcomponent " + err.message);
    }

    let observable: Observable<Passenger> = this.passengerservice.addPassenger(this.passenger);
    observable.subscribe(successFun, errFun);
  }
}



