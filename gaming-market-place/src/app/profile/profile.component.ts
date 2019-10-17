import { Component, OnInit } from '@angular/core';
import { LoginserviceService } from '../loginservice.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  pId: string;
  playerInfo: any;
  fName: string;
  lName: string;
  email: string;
  avatar: string;
  coins: string;
  minutes: string;
  ava: string = '/assets/images/';
  constructor(public loginService: LoginserviceService) { }

  ngOnInit() {
    this.loginService.currentMessage.subscribe(message => this.pId = message);
    this.loginService.fetchPlayerById().subscribe((data)=>{
      this.playerInfo = data;
      this.fName = this.playerInfo.firstname;
      this.lName = this.playerInfo.lastname;
      this.email = this.playerInfo.email;
      this.avatar = this.ava + this.playerInfo.avatarFilename;
      this.coins = this.playerInfo.coins;
      this.minutes = this.playerInfo.minutes;
    });
  }



}
