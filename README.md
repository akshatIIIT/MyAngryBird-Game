# 🐦 MyAngryBird Game (Java + LibGDX)

A clone of the popular **Angry Birds** game, created in **Java** using **LibGDX**, **Box2D**, and core **OOP design principles**. This project demonstrates a complete 2D game development workflow — from game physics and collision logic to rendering and UI.

🎮 [Watch Gameplay Demo](https://go.screenpal.com/watch/cT1ZqCnXMk5)

---

## 📽️ Demo

You can view the demo in either of the following ways:
- Click the link above ☝️
- Or check the Recording included in the project files

---

## 🧩 Game Components

### 🎮 Core Classes

- **Species** – Parent class for all game objects (Bird, Pigs, Wood, Stone)  
  - Attributes: Texture, Sprite, Physics Body  
  - Methods: Positioning, Rendering, State Updates

- **Bird** – The projectile launched by the player  
  - Implements `textureUpdate` interface for real-time texture changes  

- **Pigs** – Target objects  
  - Implements `textureUpdate` for damage state visuals  

- **Wood** – Medium-strength obstacle  

- **Stone** – High-strength obstacle

### 🧠 Handlers

- **LevelHandler** – Loads, resets, and manages game levels  
- **ContactListener** – Handles collisions and physics events (e.g., bird hits pig or wall)  

### 🧰 Utility

- **GameScreen** – Core game loop and screen rendering  
- **ButtonHandler** – Manages UI buttons (Play, Pause, Restart, etc.)

---

## 💻 Tech Stack

### 🧱 Frameworks & Libraries
- **LibGDX** – Game framework (cross-platform)
- **Box2D** – Physics engine for realistic simulation
- **Scene2D** – For UI and input handling

### 🧑‍💻 Programming Language
- **Java** – Main language for game logic and mechanics

### 🛠️ Tools
- **IntelliJ IDEA** – Development environment  
- **Gradle** – Build automation  
- **GIMP/Photoshop** – For custom textures and sprite design

### ✅ Testing Framework
- **JUnit** – Unit testing game components

---

## 🧪 Design & Architecture

- Follows **OOP Principles**: Inheritance, Polymorphism, Encapsulation, Abstraction  
- Interface-driven texture updates for flexible rendering  
- Modular class structure for easy level extension and debugging

---

## 🎨 UI/UX Highlights

- Smooth transitions and interactive animations  
- Custom-designed sprites for birds, pigs, wood, and stone  
- User-friendly menu system and restart logic  

---

## 👨‍🏫 Project Context
This project was built as part of coursework under Dr. Arun Balaji Buduru at IIIT-Delhi, demonstrating proficiency in game development, object-oriented programming, and real-time simulation.

## 🧾 How to Run

> Make sure you have Java and Gradle installed.

```bash
git clone https://github.com/yourusername/MyAngryBird-Game.git
cd MyAngryBird-Game
./gradlew desktop:run


