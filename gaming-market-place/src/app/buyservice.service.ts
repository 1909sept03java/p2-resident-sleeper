import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BuyserviceService {

  httpOptions = {
    headers: new HttpHeaders({ 
      "Content-Type": "application/json",
      'Access-Control-Allow-Origin':'*'
    })
  };

  endpoint = 'http://localhost:8082/GamingMarketplace/item/all';
  buypoint = 'http://localhost:8082/GamingMarketplace/player/deductbalance';
  constructor(public httpClient: HttpClient) { }

  public fetchItems() {
    return this.httpClient.get(this.endpoint);

  }

  public buyItem(playerId: number, itemId: number) {
    return this.httpClient.post(this.buypoint, {
      "playerId": playerId,
      "itemId": itemId
  }, this.httpOptions);
  }
}
