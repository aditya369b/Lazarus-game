# Lazarus Game


## Version of Java used: Java 10.0.2
## IDE used: IntelliJ IDEA 2018.2.2(Community Edition)
## GitHub repo: https://github.com/csc413-01-fa18/csc413-secondgame-aditya369b.git
## Run Game: Double-Click on 'LazarusGame.jar' file present in 'jar' folder of the repo and open with Java application
## Run Game: Run the jar file with this command : java -jar LazarusGame.jar in the command prompt (from the folder path where the file is present)

###	Player Controls:

###	Right arrow key: To move towards right
###	Left arrow key: To move towards left

##   Game Description:

#### Lazarus game is a single player game where the player has to reach an endpoint in a level to
#### go to the next level.
#### • The endpoint will be a ‘stop button’ box.
#### • The level will be stacked up with few solid boxes at the beginning and the player will be on
#### top of one of these boxes.
#### 
#### • These solid boxes form the initial map of a level.
#### • Random boxes keep falling from the top of the character’s position until they land on a box.
#### • There are four random boxes which are: stone, metal, cardboard and wood. These vary in
#### strength in the same given order with the stone box having the highest strength.
#### • No new random box will be falling until the current falling box is settled on top of a box
#### • The boxes which have more strength will replace the boxes with less strength.
#### • The player should use this logic to create a staircase like a thing and create a possible path
#### to reach the endpoint.
#### • The player can move only left or right. While moving, the character will jump automatically
#### on a box if there is only one box above the character’s level of height.
#### • The player will lose a life if the falling box falls on top of the character.
#### • The levels get tougher and more complex and the speed of the falling boxes increases as the
#### player progresses to a new level.
#### • The game ends if the player completes all the levels or loses all the lives.