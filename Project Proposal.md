Connor Hairfield, Ty Fritcher, Mike Billeaud

CPSC 240 Spring 2023

3/30/23

Final Project Proposal


Our final project will be named RPG Simulator for now but will likely be given a more creative name later in 
development. The goal of this project is to incorporate the inventory system into an actual RPG game that will 
randomly prompt events to the player one at a time and alter different variables based on the outcome of those 
events. These events will be categorized into three groups consisting of battles, quests, and stories.

Battles will not be optional, will place the player in a conflict with one of the varying enemy types, and will 
follow a turn-based system. If the player loses their health points before they eliminate the enemy’s health points, 
then the game is over. Otherwise, the player will advance to the next event. Health will replenish with each event 
and the player will either be able to change their selected armor and weapon between events or before the start of a 
battle.

Quest events will work like side quests that will be optional and reward the player with new items if they complete 
it successfully. If the player chooses to participate in the quest, then the event will give the player a prompt and 
ask for action or an answer. If the player selects the right action, then they will successfully complete the quest 
and earn the specified item which will be placed in the player’s inventory. Otherwise, a notification will let them 
know that they failed the quest, and they will continue to the next event. Although the player will be able to skip 
these quests, they are highly encouraged not to so that they can improve their inventory.

Story quests will be few but will track the player’s completion of the game. As the player completes the first story 
event, they can be shown the second one, and so on. The story events will likely combine both the battle events and 
the quest events where the player will have to complete some action or duel some enemy. If the player successfully 
completes the final story event, then they win the game.

Players will be able to save and quit the game at any time and the contents of the game are written to a specific 
file. When the player runs the game again, it will read that same file to initialize the objects and continue where 
they left off. The GUI for this will show the player's name, their health points, their equipped gear (hopefully 
with icons), a text area to show the event prompts, a Jtext field to read inputs, and a button to submit inputs. If 
the player enters a battle, there will be a separate window showcasing the enemy’s name, health, and icon(hopefully).
Additionally, there will be a separate window showcasing the player’s inventory.

