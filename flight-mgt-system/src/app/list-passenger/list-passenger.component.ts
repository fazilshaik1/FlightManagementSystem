import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { Passenger } from '../model/passenger';
import { PassengerService } from '../service/passengerservice';

@Component({
  selector: 'app-list-passenger',
  templateUrl: './list-passenger.component.html',
  styleUrls: ['./list-passenger.component.css']
})
export class ListPassengerComponent implements OnInit {

  constructor(private route:ActivatedRoute,private service:PassengerService) { 
    let observable=route.paramMap;
    observable.subscribe((params:ParamMap)=>{
      let codeVal:string=params.get("pnrNumber");
      let idNum:number=Number(codeVal);
        console.log("id available is "+idNum);
        this.getPassengerByNumber(idNum);
      
    })
  }
  
  passenger:Passenger;
  getPassengerByNumber(pnrNumber:number){
    let observable:Observable<Passenger>=this.service.getPassengerByNumber(pnrNumber);
    observable.subscribe( passengerArg=>{this.passenger=passengerArg});
  }
  findPassenger(form:any){
    let data=form.value;
    let pnrNumber=data.pnrNumber;
    this.getPassengerByNumber(pnrNumber);
  }

  ngOnInit(): void {
  }

}

