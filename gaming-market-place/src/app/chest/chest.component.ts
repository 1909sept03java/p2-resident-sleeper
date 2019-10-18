import { Component, OnInit } from '@angular/core';
import { LoginserviceService } from '../loginservice.service';
import { myItems } from '../myItems.model';
import { Router } from '@angular/router';


@Component({
  selector: 'app-chest',
  templateUrl: './chest.component.html',
  styleUrls: ['./chest.component.css']
})
export class ChestComponent implements OnInit {
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

  sell(value) {
    console.log(value);
    this.loginService.seelUpdate(value).subscribe(
        (val) => {
            console.log("POST call successful value returned in body", 
                        val);
        },
        response => {
            console.log("POST call in error", response);
        },
        () => {
            console.log("The POST observable is now completed.");
            alert("Purchase Successful");
            this.router.navigateByUrl('/market', {skipLocationChange: true}).then(()=>
            this.router.navigate(['/chest']));

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

    this.loginService.fetchallplayeritem().subscribe((data)=>{
      let dLen: number = Object.keys(data).length;
      //console.log(this.pId);
      for (let i = 0; i < dLen; i ++) {
        console.log(data[i].player.playerId);
        if(data[i].player.playerId == this.pId){
          length = this.myItems.push(new myItems(data[i].playerItemId, data[i].item.name, this. ava + data[i].item.itemFilename));
        }
        
      }
    });
  }

}
