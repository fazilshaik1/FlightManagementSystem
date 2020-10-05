import { Injectable } from '@angular/core';
import { Airport } from '../model/airport';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable()
export class AirportService{

  baseUrl="http://localhost:8688/airports";

   constructor(private http:HttpClient){

   }
    addAirport(airport:Airport):Observable<Airport>{
        let url=this.baseUrl+"/add";
        let observable:Observable<Airport>=this.http.post<Airport>(url,airport);
        return observable;
        
    }

    getAirport(airportCode:string):Observable<Airport>{
        let url=this.baseUrl+"/get/"+airportCode;
        let observable:Observable<Airport>=this.http.get<Airport>(url);
        return observable;
    }

    getAllAirports():Observable<Airport[]>{
        let url=this.baseUrl+"/get/all";
        let observable:Observable<Airport[]>=this.http.get<Airport[]>(url);
        return observable;
    }

    removeAirport(airportCode:string):Observable<void>{
        let url=this.baseUrl+"/delete/"+airportCode;
        let observable:Observable<void>=this.http.delete<void>(url);
        return observable;
    }
    
}