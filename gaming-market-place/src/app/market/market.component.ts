import { Component, OnInit } from '@angular/core';
import { Item } from '../item.model';
import { BuyserviceService } from '../buyservice.service';
import { LoginserviceService } from '../loginservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-market',
  templateUrl: './market.component.html',
  styleUrls: ['./market.component.css']
})
export class MarketComponent implements OnInit {

  items: Item[] = [];
  num: number[] = [];
  length: number = 0;
  ava: string = '/assets/images/';
  playerInfo: any;
  playerId: number;
  coins: number;
  itId: number;
  
  constructor(public buyservice: BuyserviceService, public loginService: LoginserviceService, public router: Router) { }

  buy(temp : number) {
    let itemId = temp+1;
    console.log(itemId);
    if(this.coins > this.items[itemId].value) {
      this.buyservice.buyItem(this.playerId, itemId).subscribe(
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
            this.router.navigateByUrl('/chest', {skipLocationChange: true}).then(()=>
            this.router.navigate(['/market']));

        });
      } else {
          alert("Not enough funds");
      }
  }

  ngOnInit() {
    this.buyservice.fetchItems().subscribe((data)=>{
      let dLen: number = Object.keys(data).length;
      for (let i = 0; i < dLen; i ++) {
        length = this.items.push(new Item(data[i].itemId, data[i].name, data[i].value, this.ava + data[i].itemFilename, i));
        }
    });
    console.log(this.items);
    this.loginService.fetchPlayerById().subscribe((data)=>{
      this.playerInfo = data;
      this.coins = this.playerInfo.coins;
    });
    this.loginService.currentMessage.subscribe(message => this.playerId = parseInt(message));
  }

}
