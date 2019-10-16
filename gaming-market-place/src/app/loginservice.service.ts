import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  endpoint = 'http://localhost:8082/GamingMarketplace/credential/all';

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

}
