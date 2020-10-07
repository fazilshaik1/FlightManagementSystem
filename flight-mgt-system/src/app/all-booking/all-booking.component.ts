import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from '../model/booking';
import { BookingService } from '../service/bookingservice';

@Component({
  selector: 'allbooking',
  templateUrl: './all-booking.component.html',
  styleUrls: ['./all-booking.component.css']
})
export class AllBookingComponent  {

  bookings:Booking[];

  constructor(private service:BookingService) { 
    let observable:Observable<Booking[]>=service.getAllBookings();
    observable.subscribe(bookingArg=>{this.bookings=bookingArg});
  }

  removeBooking(bookingId:number){
    let observable=this.service.deleteBooking(bookingId);
    observable.subscribe(result=>{this.removeById(bookingId);
    });
  }

  removeById(bookingId:number):void{
    for(let i=0;i<this.bookings.length;i++){
      let booking=this.bookings[i];
      if(booking.bookingId===bookingId){
        this.bookings.splice(i,1);
      }
    }
  }

  getDate (arrivalMillis:number ){
    let date = new Date(arrivalMillis);
    return date;
  }

}
