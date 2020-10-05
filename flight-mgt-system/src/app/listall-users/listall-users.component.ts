import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { UserService } from '../service/userservice';

@Component({
  selector: 'listall-users',
  templateUrl: './listall-users.component.html',
  styleUrls: ['./listall-users.component.css']
})
export class ListallUsersComponent {
  users:User[];

  constructor(private service:UserService) { 
    let observable:Observable<User[]>=service.getAllUsers();
    observable.subscribe( userArg=>{
      this.users=userArg;
    });
  }

  deleteUser(userId:Number){
    let observable=this.service.deleteUser(userId);
    observable.subscribe(result=>{this.deleteId(userId);
    });
  }

  deleteId(userId:Number):void{
    for(let i=0;i<this.users.length;i++){
      let user=this.users[i];
      if(user.userId===userId){
        this.users.splice(i,1);
      }
    }
  }

}
