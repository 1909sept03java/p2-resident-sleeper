import { Component, OnInit } from '@angular/core';
import { Item } from '../item.model';
import { BuyserviceService } from '../buyservice.service';
import { LoginserviceService } from '../loginservice.service';

@Component({
  selector: 'app-market',
  templateUrl: './market.component.html',
  styleUrls: ['./market.component.css']
})
export class MarketComponent implements OnInit {

  items: Item[] = [];
  length: number = 0;
  ava: string = '/assets/images/';
  playerInfo: any;
  playerId: number;
  coins: number;
  itId: number;
  //x = this.items.push(new Item(10, 'Cat'));
  //x = this.items.push(new Item(11, 'Matt')) 
  //x: {id: number, name: string }[];
  //x = new Array(1, 4, 9);
  //length = this.x.push([{10: number,'cat': string}]);
  //t = this.items[1].name;
  
  constructor(public buyservice: BuyserviceService, public loginService: LoginserviceService) { }

  buy() {
    let itemId = this.itId - 1;
    console.log(this.playerId)
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
        });
  }

  ngOnInit() {
    this.buyservice.fetchItems().subscribe((data)=>{
      let dLen: number = Object.keys(data).length;
      for (let i = 0; i < dLen; i ++) {
        length = this.items.push(new Item(data[i].itemId, data[i].name, data[i].value, this.ava + data[i].itemFilename))
        }
    });
    this.loginService.currentMessage.subscribe(message => this.playerId = parseInt(message));
  }

}
