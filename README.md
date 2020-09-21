# Soundcloud-api
IT4045 Project Repository

## Introduction

Our app will utilize the soundcloud API and allow for a better way to organize previously accessed content / songs. Users can select their favorite songs, and references to those songs will be stored in the database. Users can interact with our API via postman (or other HTTP request software, or also through our front end interface. 

## Storyboard
Frontend with bootstrap and VUE.js for reactivity

![Storyboard 1](https://user-images.githubusercontent.com/55035232/93726478-50ea2b00-fb84-11ea-8f24-1465de54c8b0.png)
![Storyboard 2](https://user-images.githubusercontent.com/55035232/93726481-521b5800-fb84-11ea-9d73-ba484b4b5a52.png)
![Storyboard 3](https://user-images.githubusercontent.com/55035232/93726484-53e51b80-fb84-11ea-923f-aa2961ab83a6.png)




## Functional Requirement

**Given** user wants to register

**When** they enter their desired username and password 

**Then** user is added to the noSQL database



**Given** user wants to log in

**When** they enter their already registered credentials

**Then** user logs in 



**Given** a user wants to search by songs (by Genre, Labelname, user, release date)

**When** they enter their specifications into the search fields

**Then** the returned songs will be displayed in a table



**Given** a user wants to favorite / save a song

**When** they click “favorite” 

**Then** search parameters to retrieve the song are saved to database for future and displayed to user in a list



## Class Diagram
![ClassDiagram](https://user-images.githubusercontent.com/55035232/93726319-614dd600-fb83-11ea-8984-5c3740f2d723.PNG)

## JSON Schema

**Save song to database for users reference** 

*Endpoint: /savesongtofavorites/{currentUser} PUT*

{
  "id": 13158665,
  
  "created_at": "2011/04/06 15:37:43 +0000",
  
  "user_id": 3699101,
  
  "description": null,
  
  "genre": null,
  
  "release": null,
  
  "title": "Munching at Tiannas house",
  
  "release_year": null,
  
  "release_month": null,
  
  "release_day": null,
  
  "permalink_url": "https://soundcloud.com/user2835985/munching-at-tiannas-house",
  
  "artwork_url": null,
  
  "waveform_url": "https://w1.sndcdn.com/fxguEjG4ax6B_m.png",
  
  "user": 
  
  {
   "id": 3699101,
    
   "permalink": "user2835985",
    
   "username": "user2835985",
    
   "uri": "https://api.soundcloud.com/users/3699101",
    
   "permalink_url": "https://soundcloud.com/user2835985",
    
   "avatar_url": "https://a1.sndcdn.com/images/default_avatar_large.png?142a848"
    
  },
  
  "stream_url": "https://api.soundcloud.com/tracks/13158665/stream"
}

**Registers user to database**

*Endpoint: /register POST* 

{

  "username": string,
  
  "password": string  
}




**Login the user (checks against registered users)** 

*Endpoint: /login POST* 

{
  "username": string,
  
  "password": string  
}

**Get song with selected details (gets song with users search query from SoundCloud)** 

*Endpoint: /getSong POST* 

{
  "name": string,
  
  "genre": string,
  
  "releaseDate": datetime,
  
  “user”: string
}


## Scrum Roles 
 
**UI Specialist**: Matthew Dupont

**Business Logic and Persistence Expert**: Storm Hamilton

**Product Owner/Scrum Master/DevOps/GitHub Administrator**: David Moody
    
## Github Project Link
https://github.com/moodydi/SoundcloudApp

## JIRA board
https://it4045.atlassian.net/secure/RapidBoard.jspa?projectKey=IT&rapidView=1

## Link to Teams Group Standup on Sundays from 8:00 PM - 9:30 PM

https://teams.microsoft.com/l/meetup-join/19%3ameeting_ZjA4YjQwNmMtYzdhYy00NjU5LTg2OTEtMDQxZTViMGExYWY0%40thread.v2/0?context=%7b%22Tid%22%3a%22f5222e6c-5fc6-48eb-8f03-73db18203b63%22%2c%22Oid%22%3a%223fc867c0-9484-4ec5-a7a8-324b74a64e05%22%7d
