import { Component, OnInit } from '@angular/core';
import { LoginserviceService } from '../loginservice.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  pId: string;
  constructor(public loginService: LoginserviceService) { }

  ngOnInit() {
    this.loginService.currentMessage.subscribe(message => this.pId = message);
  }

}
