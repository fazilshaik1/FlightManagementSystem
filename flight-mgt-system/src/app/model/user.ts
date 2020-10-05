export class User{
    userId:number;
    userType:string;
    userName:string;
    email:string;
    userPhone:number;
    password:string;
    

    constructor( userId:number,userType:string, userName:string,email:string, userPhone:number, password:string){
        this.userType = userType;
		this.userName = userName;
		this.email = email;
		this.userPhone = userPhone;
		this.password = password;
    }
    
    getuserId():number{
        return this.userId;
    }
    getUserType():string{
        return this.userType;
    }

    getUserName():string{
        return this.userName;
    }
    getEmail():string{
        return this.email;
    }
    getUserPhone():Number{
        return this.userPhone;
    }
    getPassword():string{
        return this.password;
    }

   
}