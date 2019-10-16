# Resident Sleeper Team!

## Project Blurb

> Our team intends to build a marketplace platform where users can play various games and earn credits/currency while they play.
> The platform also lets users buy, sell, or trade items that should enhance their gaming experience.

## Members

* [Ambiorix Cruz Angeles](https://github.com/1909sept03java/ambiorix-cruzangeles "The Captain")
* [Gurvir Singh](https://github.com/1909sept03java/gurvir-singh "The Left Hand")
* [Sudipta Saha](https://github.com/1909sept03java/sudipta-saha "The Right Hand")
* [Tomi Adegbenro](https://github.com/1909sept03java/tomi-adegbenro "The Back")

## Angular Application Setup

* cd into p2-resident-sleeper/gaming-market-place/
* Use npm install --save @angular/material @angular/cdk @angular/animations to be able to use Angular Material 
* Run the command ng build 
* Download Allow CORS: extension for chrome
* https://chrome.google.com/webstore/detail/allow-cors-access-control/lhobafahddgcelffkeicbaginigeejlf?hl=en
* Turn it on by clicking it in the right corner. 
* Turn it off when you are done serving the application.
* Use ng serve to access it via the localhost

## Snake Eater Game
* Game coded by Samir Hodzic
* Link to his repository: github.com/SamirHodzic/ngx-snake

## Controllers
* Checking if the email is available in the database..
* will return true if it's in side the database
* It's a POST method, takes the email with variable name 'email'
* http://localhost:8082/GamingMarketplace/player/isemailunique

* Checking if the username is available in the database..
* Will return true if it's in side the database
* It's a POST method, takes the username with variable name 'username'
* http://localhost:8082/GamingMarketplace/credential/isuniqueusername

* Will update the profile picture filename in the database.. will return the player object too.
* It's a POST method which will take the player id as 'playerId' and filename as 'avatarFilename'
* http://localhost:8082/GamingMarketplace/player/updateavatar

* Will reduce the coins of the Player and update the PlayerItem Table and the Activity table..
* It's a POST method which will take the player id as 'playerId' and the item id as 'itemId'
* http://localhost:8082/GamingMarketplace/player/deductbalace

## Branching

* Check to see if you have the dev-rex branch  
$ git branch
* Get into the dev-rex branch  
$ git checkout dev-rex
* Create your own branch from the dev-rex branch  
$ git checkout -b branch-name-here
* check to see if you're in your new branch  
$ // do your work  
$ git add .  
$ git commit -m "I wRoTe CoDe ThAt DiDn't BrEaK tHe PrOjEcT"  
* check your terminal, you should be in (branch-name-here)
* now it's time to switch to dev-rex then pull then merge  
$ git checkout dev-rex  
$ git pull  
$ git merge branch-name here  
* you're done!
* if you want to delete a branch from being tracked    
$ git checkout -d branch-name-here
* if a branch has completed it's purpose, let rex know
* so he can delete it permanently from the repo

## Visit our Trello Page!

https://trello.com/b/dsmuobOF/residentsleeper

Our Scrum Lists includes:
* Product Backlog
* SPrint Planning
* Current Sprint
* In Progress
* Done (per Sprint)
