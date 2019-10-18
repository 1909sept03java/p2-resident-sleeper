import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SignupserviceService {

  httpOptions = {
    headers: new HttpHeaders({ 
      "Content-Type": "application/json",
      'Access-Control-Allow-Origin':'*'
    })
  };

  endpoint = 'http://localhost:8082/GamingMarketplace/signup/';

  constructor(private httpClient: HttpClient) { }

  public signUp(email: string, firstname: string, lastname: string, username: string, password: string) {
    console.log(this.endpoint+'?email='+email+'&firstname='+firstname+'&lastname='+lastname+'&username='+username+'&password='+password);
    return this.httpClient.post(this.endpoint+'?email='+email+'&firstname='+firstname+'&lastname='+lastname+'&username='+username+'&password='+password, this.httpOptions);
  }
}
