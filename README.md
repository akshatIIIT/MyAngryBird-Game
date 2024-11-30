# Setting Up the game
## Angry  Bird Game
This angry birds game was created in Java using libgdx.

Getting the game started
There are a few procedures involved in setting up the game.

Navigate to this repository on github.
Get the zip file that is contained in this repository.
Open the folder in any IDE after extracting the files.
The "Lwjgl3Launcher" launcher file in libgdx java enables the execution of the files in the core folder, which is located at "lwjgl3\src\main\java\io\github\some_example_name\lwjgl3". Click this launcher's "run" button.

After clicking, let the gradle file a few seconds to compile.
The game will launch in a new window after it has been compiled.

Online sources referred to-
https://www.youtube.com/watch?v=W_Cyyu_qP60&t=2970s LibGDX Framework

 FULLCourse- https://www.youtube.com/watch?v=EJwXzmUQChg&list=PLXY8okVWv
 
A [libGDX](https://libgdx.com/) project generated with [gdx-liftoff](https://github.com/libgdx/gdx-liftoff).

This project was generated with a template including simple application launchers and an empty `ApplicationAdapter` extension.

# Links for Usecase and UML diagram
  usecaseLink- https://lucid.app/lucidchart/107893b8-caea-4b62-8c8f-3eae2cccb30f/edit?page=0_0&invitationId=inv_ea0ab4fb-e48e-4654-9f3f-7faec0b221f1#
   

## Gradle

This project uses [Gradle](https://gradle.org/) to manage dependencies.
The Gradle wrapper was included, so you can run Gradle tasks using `gradlew.bat` or `./gradlew` commands.
Useful Gradle tasks and flags:

- `--continue`: when using this flag, errors will not stop the tasks from running.
- `--daemon`: thanks to this flag, Gradle daemon will be used to run chosen tasks.
- `--offline`: when using this flag, cached dependency archives will be used.
- `--refresh-dependencies`: this flag forces validation of all dependencies. Useful for snapshot versions.
- `build`: builds sources and archives of every project.
- `cleanEclipse`: removes Eclipse project data.
- `cleanIdea`: removes IntelliJ project data.
- `clean`: removes `build` folders, which store compiled classes and built archives.
- `eclipse`: generates Eclipse project data.
- `idea`: generates IntelliJ project data.
- `lwjgl3:jar`: builds application's runnable jar, which can be found at `lwjgl3/build/libs`.
- `lwjgl3:run`: starts the application.
- `test`: runs unit tests (if any).

Note that most tasks that are not specific to a single project can be run with `name:` prefix, where the `name` should be replaced with the ID of a specific project.
For example, `core:clean` removes `build` folder only from the `core` project.
