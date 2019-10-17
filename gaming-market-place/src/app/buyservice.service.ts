import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BuyserviceService {

  endpoint = 'http://localhost:8082/GamingMarketplace/item/all';
  buypoint = 'http://localhost:8082/GamingMarketplace/player/deductbalace';
  constructor(public httpClient: HttpClient) { }

  public fetchItems() {
    return this.httpClient.get(this.endpoint);

  }

  public buyItem(playerId: number, itemId: number) {
    return this.httpClient.post(this.buypoint, {
      "playerId": playerId,
      "itemId": itemId
  });
  }
}
