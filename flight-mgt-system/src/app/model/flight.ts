export class Flight{
    flightNumber:number;
    flightModel:string;
    carrierName:string;
    seatCapacity:number;

    constructor(flightNumber:number,flightModel:string,carrierName:string,seatCapacity:number){
        this.flightNumber=flightNumber;
        this.flightModel=flightModel;
        this.carrierName=carrierName;
        this.seatCapacity=seatCapacity;
    }

    getFlightNumber():number{
        return this.flightNumber;
    }

    getFlightModel():string{
        return this.flightModel;
    }

    getCarrierName():string{
        return this.carrierName;
    }

    getSeatCapacity():number{
        return this.seatCapacity;
    }

}