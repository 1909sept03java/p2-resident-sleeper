import { Component, OnInit } from '@angular/core';
import { LoginserviceService } from '../loginservice.service';
import { myItems } from '../myItems.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  myItems: myItems[] = [];
  pId: string;
  playerInfo: any;
  fName: string;
  lName: string;
  email: string;
  avatar: string;
  coins: string;
  minutes: string;
  ava: string = '/assets/images/';
  itId: number;
  constructor(public loginService: LoginserviceService, public router: Router) { }

  changeAvatar() {
    let itemId = this.itId - 1;
    let itemFilename = this.myItems[itemId].itemFilename;
    var splitted = itemFilename.split("/", 4);
    this.loginService.changeAva(parseInt(this.pId), splitted[3]).subscribe(
        (val) => {
            console.log("POST call successful value returned in body", 
                        val);
        },
        response => {
            console.log("POST call in error", response);
        },
        () => {
            console.log("The POST observable is now completed.");
            this.router.navigateByUrl('/market', {skipLocationChange: true}).then(()=>
            this.router.navigate(['/profile']));
        });
  }

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
    this.loginService.fetchAllItems().subscribe((data)=>{
      let dLen: number = Object.keys(data).length;
      for (let i = 0; i < dLen; i ++) {
        length = this.myItems.push(new myItems(data[i].item.itemId, data[i].item.name, this. ava + data[i].item.itemFilename));
      }
    });
  }



}
