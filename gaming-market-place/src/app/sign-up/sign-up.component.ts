import { Component, OnInit } from '@angular/core';
import { SignupserviceService } from '../signupservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  email: string = '';
  firstname: string = '';
  lastname: string = '';
  username: string = '';
  password: string = '';

  public signup(): void {
    this.Signupservice.signUp(this.email, this.firstname, this.lastname, this.username, this.password).subscribe(()=>{this.router.navigate(['/login']);});
    console.log("inside component");
  }

  constructor(public Signupservice: SignupserviceService, public router: Router) { }

  ngOnInit() {
  }

}
