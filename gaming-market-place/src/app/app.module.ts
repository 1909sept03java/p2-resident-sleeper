import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { CustomMaterialModule } from  './material.module';
import {FormsModule} from '@angular/forms';
import { RouterModule, Routes } from '@angular/router'

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { GameComponent } from './game/game.component';
//import { BestScoreManager } from './game/game.storage.service';

const appRoutes: Routes = [
  { path: '',      component: LoginComponent },
  { path: 'login',      component: LoginComponent },
  { path: 'game',      component: GameComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    GameComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    CustomMaterialModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
