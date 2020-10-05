import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { UserService } from '../service/userservice';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent {

  constructor(private service:UserService) { }

  user:User;


  addUser(form:any){
    let data=form.value;
    let userType=data.userType;
    let userName=data.userName;
    let email=data.email;
    let userPhone=data.userPhone;
    let password=data.password;
    this.user=new User(-1,userType,userName,email,userPhone,password);
    let successFun = (userArg: User) => {
      this.user = userArg;
    };

    let errFun = err => {
      console.log("err in addusercomponent " + err.message);
    }

    let observable: Observable<User> = this.service.addUser(this.user);
    observable.subscribe(successFun, errFun);
  }

}
