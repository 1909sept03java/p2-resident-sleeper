import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  endpoint = 'http://localhost:8082/GamingMarketplace/login';

  constructor(private httpClient: HttpClient) { }

  public fetchPlayer() {
    return this.httpClient.get(this.endpoint);

  }

}
