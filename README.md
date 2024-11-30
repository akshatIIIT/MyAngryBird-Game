
# MyAngryBird-Game
I have a created a well Known game known as Angry Bird in java using OOPS concept and various Libraries and FrameWorks. I have also attached a recording of demo video along with code,hope you likes it.

# Tech Stack
1. Frameworks and Libraries
LibGDX: Core framework for game development.

Box2D: Physics engine for realistic object simulation.

Scene2D: Used for UI elements and input handling.

# 3. Programming Language
Java: Main programming language for game logic and mechanics.

# 4. Tools
IntelliJ IDEA: Primary IDE for development.

Gradle: Build automation tool.

GIMP/Photoshop: Used for designing textures and sprites.

# 5. Testing Framework

JUnit: For unit testing game components.

# 6. Design Patterns

Object-Oriented Programming (OOP) principles such as inheritance, polymorphism, encapsulation, and abstraction.

Interface implementation for texture updates.

# 7. UI/UX

Custom textures and sprites for a visually appealing game.

Smooth transitions and animations.

# Game Components

# 1. Classes
Core Classes

Species: Parent class for game objects (Bird, Wood, Pigs, Stone).

Attributes: Texture, Sprite, Body.

Methods: Positioning, rendering, updating states.

Child Classes

Bird: Represents the bird launched by the player.

Implements: textureUpdate interface for dynamic texture updates.

Pigs: Represents the target objects.

Implements: textureUpdate interface for damage states.

Wood: Obstacle element.

Stone: Stronger obstacle element.

# Handlers
LevelHandler: Manages game levels, including loading and resetting.

ContactListener: Handles collision events (e.g., when birds hit pigs or obstacles).

Utility Classes

GameScreen: Core game loop and screen rendering.

ButtonHandler: Manages UI buttons like "Play," "Pause," "Restart."
