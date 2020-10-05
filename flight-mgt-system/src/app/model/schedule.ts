export class Schedule{
    scheduleId:number;
    arrivalTime;
    departureTime;
    sourceAirport:String;
    destinationAirport:String;
    airportCode:String;

    constructor(scheduleId:number,arrivalTime,departureTime,sourceAirport:String,destinationAirport:String,airportCode:String){
        this.scheduleId=scheduleId;
        this.arrivalTime=arrivalTime;
        this.departureTime=departureTime;
        this.sourceAirport=sourceAirport;
        this.destinationAirport=destinationAirport;
        this.airportCode=airportCode;
    }
}