import {Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Flight } from '../model/flight';
import { Observable } from 'rxjs';

@Injectable()
export class FlightService{

    baseUrl="http://localhost:8787/flights";

    constructor(private http:HttpClient){

    }

    addFlight(flight:Flight):Observable<Flight>{
        let url=this.baseUrl+"/add";
        let observable:Observable<Flight>=this.http.post<Flight>(url,flight);
        return observable;
    }

    getFlight(flightNumber:number):Observable<Flight>{
        let url=this.baseUrl+"/get/"+flightNumber;
        let observable:Observable<Flight>=this.http.get<Flight>(url);
        return observable;
    }

    getAllFlights():Observable<Flight[]>{
        let url=this.baseUrl+"/get/all";
        let observable:Observable<Flight[]>=this.http.get<Flight[]>(url);
        return observable;
    }

    removeFlight(flightNumber:number):Observable<void>{
        let url=this.baseUrl+"/delete/"+flightNumber;
        let observable:Observable<void>=this.http.delete<void>(url);
        return observable;
    }

    modifyFlight(flight:Flight):Observable<Flight>{
        let url=this.baseUrl+"/update";
        let observable:Observable<Flight>=this.http.put<Flight>(url,flight);
        return observable;
    }
}