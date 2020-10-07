import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ScheduledFlight } from '../model/scheduledflight';

@Injectable()
export class ScheduledFlightService{

    baseUrl="http://localhost:8586/scheduledflights"

    constructor(private http:HttpClient){}

    addScheduledFlight(scheduledflight:ScheduledFlight):Observable<ScheduledFlight>{
        let url =this.baseUrl+"/add";
        let observable:Observable<ScheduledFlight> =this.http.post<ScheduledFlight>(url,scheduledflight);
        return observable;
    }

    findScheduledFlightById(sfId:number):Observable<ScheduledFlight>{
        let url =this.baseUrl+"/get/"+sfId;
        let observable:Observable<ScheduledFlight> =this.http.get<ScheduledFlight>(url);
        return observable;
    }

    findAllScheduledFlights():Observable<ScheduledFlight[]>{
        let url =this.baseUrl+"/all";
        let observable:Observable<ScheduledFlight[]> =this.http.get<ScheduledFlight[]>(url);
        return observable;
    }

    deleteSchedule(sfId:number):Observable<void>{
        let url =this.baseUrl+"/delete/"+sfId;
        let observable:Observable<void> =this.http.delete<void>(url);
        return observable;
    }
}