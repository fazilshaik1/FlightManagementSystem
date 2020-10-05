export class Booking{
    bookingId:number;
	userId:number;
	bookingDate;
	ticketCost:number;
	pnrNumber:number;
    sfId:number;
    
    constructor(userId:number,bookingDate,ticketCost:number,pnrNumber:number,sfId:number){
        this.userId=userId;
        this.bookingDate=bookingDate;
        this.ticketCost=ticketCost;
        this.pnrNumber=pnrNumber;
        this.sfId=sfId;
    }
}