import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CoinserviceService {

  httpOptions = {
    headers: new HttpHeaders({ 
      "Content-Type": "application/json",
      'Access-Control-Allow-Origin':'*'
    })
  };

  endpoint = 'http://localhost:8082/GamingMarketplace//player/balanceafterlogout';

  constructor(public httpClient: HttpClient) { }

  public addCoins(playerId: number, coins: number) {
    return this.httpClient.post(this.endpoint, {
      "playerId": playerId,
      "coins": coins
  }, this.httpOptions);
  }
  
}
