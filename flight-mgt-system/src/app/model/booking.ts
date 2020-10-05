export class Booking{
    bookingId:number;
	userId:number;
	bookingDate:Date;
	ticketCost:number;
	pnrNumber:number;
    sfId:number;
    
    constructor(bookingId:number,userId:number,bookingDate:Date,ticketCost:number,pnrNumber:number,sfId:number){
        this.bookingId=bookingId;
        this.userId=userId;
        this.bookingDate=bookingDate;
        this.ticketCost=ticketCost;
        this.pnrNumber=pnrNumber;
        this.sfId=sfId;
    }
}