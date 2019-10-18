import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { CustomMaterialModule } from  './material.module';
import {FormsModule} from '@angular/forms';
import { RouterModule, Routes } from '@angular/router'

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { GameComponent } from './game/game.component';
import { ProfileComponent } from './profile/profile.component';
import { LoginserviceService } from './loginservice.service';
import { HttpClientModule } from '@angular/common/http';
import { MarketComponent } from './market/market.component';
import { ChestComponent } from './chest/chest.component';
import { BuyserviceService } from './buyservice.service';
import { SignUpComponent } from './sign-up/sign-up.component';
import { SignupserviceService } from './signupservice.service';
//import { BestScoreManager } from './game/game.storage.service';

const appRoutes: Routes = [
  { path: '',      component: LoginComponent },
  { path: 'login',      component: LoginComponent },
  { path: 'game',      component: GameComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'market', component: MarketComponent },
  { path: 'chest', component: ChestComponent },
  { path: 'signup', component: SignUpComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    GameComponent,
    ProfileComponent,
    MarketComponent,
    ChestComponent,
    SignUpComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    CustomMaterialModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes, {
      onSameUrlNavigation: 'reload'
    })
  ],
  providers: [LoginserviceService, LoginComponent, BuyserviceService, SignupserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
