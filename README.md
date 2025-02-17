## How do I build this client?

### Steps:

1. **Download and Install Java SDK version 8**:
   - Download from [Java SDK version 8](https://adoptium.net/en-GB/temurin/releases/?version=8).
   - Install it and set the `JAVA_HOME` environment variable to the installation directory.

2. **Verify Java Installation**:
   - Open a terminal or command prompt.
   - Run `java -version`.
   - Ensure the output contains `openjdk version "1.8.0_{...}"`.

3. **Install Gradle 4.7**:
   - Download from [Gradle 4.7](https://gradle.org/next-steps/?version=4.7&format=bin).
   - Follow the "Installing manually" guide on the [Gradle wiki](https://gradle.org/install).

4. **Clone the Repository**:
   - Run the following commands in the terminal or command prompt:
     ```bash
     git clone --recursive https://github.com/xia-mc/Raven-XD.git
     cd Raven-XD
     ```

5. **Set Up the Project**:
   - Run the following commands to set up the Gradle wrapper and the development environment:
     ```bash
     gradlew.bat
     gradle wrapper
     gradlew build
     ```

6. **Build Success**:
   - If all steps complete without errors, the project is successfully built.


