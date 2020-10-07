import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { Booking } from '../model/booking';
import { BookingService } from '../service/bookingservice';

@Component({
  selector: 'getbooking',
  templateUrl: './get-booking.component.html',
  styleUrls: ['./get-booking.component.css']
})
export class GetBookingComponent {

  constructor(private route:ActivatedRoute, private service:BookingService) {
    let observable=route.paramMap;
    observable.subscribe((params:ParamMap)=>{
      let idVal:string=params.get("bookingId");
      let idNum:number=Number(idVal);
      console.log("id is "+idNum);
      this.findBookingById(idNum);
    })
   }

   booking:Booking;

   findBookingById(bookingId:number){
     let observable:Observable<Booking>=this.service.getBooking(bookingId);
     observable.subscribe(bookingArg=>{this.booking=bookingArg;
    });
   }

   findBooking(form:any){
     let data=form.value;
     let bookingId=data.bookingId;
     this.findBookingById(bookingId);
   }

   getDate (arrivalMillis:number ){
    let date = new Date(arrivalMillis);
    return date;
  }
  

}
