import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from '../model/booking';

@Injectable()
export class BookingService{

    baseUrl="http://localhost:8989/bookings";

    constructor(private http:HttpClient){}

    addBooking(booking:Booking):Observable<Booking>{
        let url=this.baseUrl+"/add";
        let observable:Observable<Booking>=this.http.post<Booking>(url,booking);
        return observable;
    }

    getBooking(bookingId:number):Observable<Booking>{
        let url=this.baseUrl+"/get/"+bookingId;
        let observable:Observable<Booking>=this.http.get<Booking>(url);
        return observable;
    }

    getAllBookings():Observable<Booking[]>{
        let url=this.baseUrl+"/all";
        let observable:Observable<Booking[]>=this.http.get<Booking[]>(url);
        return observable;
    }

    deleteBooking(bookingId:number):Observable<void>{
        let url=this.baseUrl+"/delete/"+bookingId;
        let observable:Observable<void>=this.http.delete<void>(url);
        return observable;
    }

}