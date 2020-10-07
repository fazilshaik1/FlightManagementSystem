export class ScheduledFlight{
     sfId:number;
	 availableSeats:number;
	 scheduleId:number;
     flightNumber:number;
     
     constructor(availableSeats:number,scheduleId:number, flightNumber:number){
         this.availableSeats=availableSeats;
         this.scheduleId=scheduleId;
         this.flightNumber=flightNumber;
     }
}