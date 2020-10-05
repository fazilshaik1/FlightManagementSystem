export class Airport{
    airportCode:string;
    airportName:string;
    airportLocation:string;
    

    constructor(airportCode:string, airportName:string,airportLocation:string){
        this.airportCode=airportCode;
        this.airportName=airportName;
        this.airportLocation=airportLocation;
    }
    
    getAirportCode():string{
        return this.airportCode;
    }

    getAirportName():string{
        return this.airportName;
    }

    getAirportLocation():string{
        return this.airportLocation
    }
}