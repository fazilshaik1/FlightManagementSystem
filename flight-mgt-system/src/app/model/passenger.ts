export class Passenger{

    private pnrNumber:number;
    private passengerName:string;
    private passengerAge:number;
    private passengerUIN:number;
    private gender:CharacterData;
    

    constructor( passengerName:string, passengerAge:number,passengerUIN:number,gender:CharacterData){
        this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerUIN = passengerUIN;
		this.gender=gender;

    }

}