# Java RPG Game Project

This project was created as part of the first programming practice assignment using Java language.

## Project Description

A simple 2D console-based RPG game where:

- A random map is generated.
- The player can move across the map.
- Battles are triggered when encountering enemies.
- Loot is collected and stored in the inventory.
- The player can sell items in the store.
- XP and LevelUp system with Achievements is implemented.
- Game results are saved into a CSV file and displayed in the Top Players leaderboard.

---

1. Map Generation

- Randomly generated `char[][]` map with:
  - `.` - empty tiles
  - `E` - enemies
  - `L` - loot
  - `P` - player position

- Map size: 10x5.

2. Player Movement

- Supported commands:
  - `up`, `down`, `left`, `right` — movement
  - `store` — enter the store
  - `inventory` — show inventory
  - `exit` — exit the game

3. Combat System

- Battles are initiated upon encountering an enemy.
- Each enemy has:
  - HP
  - Attack
  - Defense
  - XP reward
- Player receives XP after winning.

4. XP and LevelUp System

- XP system with automatic LevelUp.
- Each LevelUp increases:
  - HP
  - Attack
  - Defense
- Achievements are unlocked upon reaching certain levels.

5. Loot and Inventory

- Loot items are collected after battles or found randomly on the map (`L`).
- Loot items are stored in the player's inventory.
- Player can view inventory at any time.

6. Store System

- The player can sell inventory items.
- Each sold item gives gold (value).

7. ScoreBoard (Top Players)

- At the end of the game, the player can enter their name.
- Scores are saved to a CSV file (`resources/scores.csv`).
- The Top Players leaderboard displays sorted results based on Level and XP.

---
