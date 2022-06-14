import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../registration.service';
import { User } from '../user';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

   user=new User();

  constructor(private _service:RegistrationService) { }

  ngOnInit(): void {
  }

  loginUser()
  {
    this._service.loginUserFromRemote(this.user).subscribe(

      data =>console.log("response received"),
      error =>console.log("exception occured")
    )
  }
}
