import { Component, OnInit } from '@angular/core';
import { LoginserviceService } from '../loginservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = '';
  password: string = '';
  pId: string = '-1';
  constructor(private loginService: LoginserviceService, public router: Router) {
  }


  public login(): void {
    let player: string = '';
    let pos: number = -1;
    let dLen: number = 0;
    this.loginService.fetchPlayer().subscribe((data)=>{
      dLen = Object.keys(data).length;
      for (let i = 0; i < dLen; i ++) {
        if(this.username == data[i].username && this.password == data[i].password) {
          player = data[i].username;
          this.loginService.changeMessage(data[i].credentialId);
        } 

        if (player == '') {
          this.router.navigate(['/login']);
        } else {
          this.router.navigate(['/profile']);
        }
      }
      

    });
}
  ngOnInit() {
  }

}
