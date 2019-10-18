import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';
import { identifierModuleUrl } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  httpOptions = {
    headers: new HttpHeaders({ 
      "Content-Type": "application/json",
      'Access-Control-Allow-Origin':'*'
    })
  };

  endpoint = 'http://localhost:8082/GamingMarketplace/credential/all';
  allpoint = 'http://localhost:8082/GamingMarketplace//playerItem/getspecific?playerId=';
  updatepoint = 'http://localhost:8082/GamingMarketplace/player/updateavatar';

  private messageSource = new BehaviorSubject('-1');
  currentMessage = this.messageSource.asObservable();

  constructor(private httpClient: HttpClient) { }

  changeMessage(message: string) {
    this.messageSource.next(message)
  }

  public fetchPlayer() {
    return this.httpClient.get(this.endpoint);

  }

  public fetchPlayerById() {
    let id: string;
    this.currentMessage.subscribe(message => id = message);
    let playUrl = 'http://localhost:8082/GamingMarketplace/player/' + id;
    return this.httpClient.get(playUrl);
  }

  public fetchAllItems() {
    let id: string;
    this.currentMessage.subscribe(message => id = message);
    let itemUrl = this.allpoint + id;
    return this.httpClient.get(itemUrl);
  }

  public changeAva(playerId: number, itemFilename: string) {
    return this.httpClient.post(this.updatepoint, {
      "playerId": playerId,
      "itemFilename": itemFilename
  }, this.httpOptions);
  }

}
