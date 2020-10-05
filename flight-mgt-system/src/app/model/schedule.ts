export class Schedule{
    scheduleId:number;
    arrivalTime;
    departureTime;
    sourceAirport:String;
    destinationAirport:String;
    airportCode:String;

    constructor(arrivalTime,departureTime,sourceAirport:String,destinationAirport:String,airportCode:String){
        this.arrivalTime=arrivalTime;
        this.departureTime=departureTime;
        this.sourceAirport=sourceAirport;
        this.destinationAirport=destinationAirport;
        this.airportCode=airportCode;
    }
}