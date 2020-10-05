import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from '../model/booking';
import { BookingService } from '../service/bookingservice';

@Component({
  selector: 'add-booking',
  templateUrl: './add-booking.component.html',
  styleUrls: ['./add-booking.component.css']
})
export class AddBookingComponent {

  constructor(private service:BookingService) {

   }

   booking:Booking;

   addBooking(form:any){
     let data=form.value;
     let userId=data.userId;
     let bookingDate=data.bookingDate;
     let ticketCost=data.ticketCost;
     let pnrNumber=data.pnrNumber;
     let sfId=data.sfId;
     this.booking=new Booking(1,userId,bookingDate,ticketCost,pnrNumber,sfId);
     let observable:Observable<Booking>=this.service.addBooking(this.booking);
     observable.subscribe(bookingArg=>{
       this.booking=bookingArg;
     });
   }
   

}
