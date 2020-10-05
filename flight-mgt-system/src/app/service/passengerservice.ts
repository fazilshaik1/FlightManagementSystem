import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Passenger } from '../model/passenger';
@Injectable()
export class PassengerService {

  constructor(private http:HttpClient) {
   }

    baseUrl="http://localhost:8687/passengers" 

  addPassenger(passenger:Passenger):Observable<Passenger>{
    let url=this.baseUrl+"/add";
    let observable:Observable<Passenger>= this.http.post<Passenger>(url,passenger);
    return observable;  
  }

  getPassengerByNumber(pnrNumber:number){
    let url=this.baseUrl+"/get/"+pnrNumber;
    let observable:Observable<Passenger>=this.http.get<Passenger>(url);
    return observable;
  }

  fetchAllPassengers(){
    let url=this.baseUrl+"/all";
    let observable:Observable<Passenger[]>=this.http.get<Passenger[]>(url);
    return observable;
  }

  deletePassenger(pnrNumber:number){
    let url=this.baseUrl+"/delete/"+pnrNumber;
        let observable:Observable<void>=this.http.delete<void>(url);
        return observable;
  }

  }

