import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { UserService } from '../service/userservice';

@Component({
  selector: 'list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.css']
})
export class ListUserComponent implements OnInit {

  constructor(private route:ActivatedRoute,private service:UserService) { 
  let observable=route.paramMap;
observable.subscribe((params:ParamMap)=>{
  let codeVal:string=params.get("userid");
  let idNum:number=Number(codeVal);
    console.log("id available is "+idNum);
    this.getUserById(idNum);
  
})
  }

  user:User;

getUserById(userId:Number){
  let observable:Observable<User>=this.service.getUser(userId);
  observable.subscribe( userArg=>{this.user=userArg});
}

findUser(form:any){
  let data=form.value;
  let userId=data.userId;
  this.getUserById(userId);
}


  ngOnInit(): void {
  }

}

