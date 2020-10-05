import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Schedule } from '../model/schedule';

@Injectable()
export class ScheduleService{

    baseUrl="http://localhost:8585/schedules";

    constructor(private http:HttpClient){}

    addSchedule(schedule:Schedule):Observable<Schedule>{
        let url =this.baseUrl+"/add";
        let observable:Observable<Schedule> =this.http.post<Schedule>(url,schedule);
        return observable;
    }

    findScheduleById(scheduleId:number):Observable<Schedule>{
        let url =this.baseUrl+"/get/"+scheduleId;
        let observable:Observable<Schedule> =this.http.get<Schedule>(url);
        return observable;
    }

    findAllSchedules():Observable<Schedule[]>{
        let url =this.baseUrl+"/all";
        let observable:Observable<Schedule[]> =this.http.get<Schedule[]>(url);
        return observable;
    }

    deleteSchedule(scheduleId:number):Observable<void>{
        let url =this.baseUrl+"/delete/"+scheduleId;
        let observable:Observable<void> =this.http.delete<void>(url);
        return observable;
    }

}