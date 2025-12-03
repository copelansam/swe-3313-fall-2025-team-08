[< Back to Project Overview](../README.md)

# Implementation
***

Here you will find instructions for how to get the application up and running

## Environment Setup
You will need the following items to run the application:
- Git
  - Ensure you have git installed by running `git version` in the Command Line Interface (CLI)
    - If nothing is returned, then you must install git. How to do this varies by OS. The official documentation for how
    to install git can be found [**here**](https://git-scm.com/install/)
    - If git is installed, then running `git version` will display the current version of git in the (CLI).
- Java 23 or Higher
  - Ensure you have version 23 or higher of Java installed by running the command `java -version` in the  CLI
    - If the result says that your version of Java is 23 or higher, then you do not need to update your Java.
    - If the result says that your version of Java is below 23 or that you do not have Java installed, then you will 
    need to download the latest version. The steps to do this vary by operating system. 
      - A link to the download for each operating system can be found [**here**](https://www.oracle.com/java/technologies/downloads/). 
      - Instructions for how to install Java for each operating system can be found [**here**](https://www.java.com/en/download/help/download_options.html)
- Maven
    - Ensure that you have maven installed by running `mvn -v` in the CLI
      - If the result says which version of maven you are running, then you have maven installed and need no further action.
      - If the result says that you do not have maven installed, then you will need to install maven. The steps to do this
      vary by operating system.
        - A link to the official instructions on how to install maven for each operating system can be found [**here**](https://maven.apache.org/install.html)
## Database Setup
No additional work is necessary to initialize the database. The database will be automatically setup when you run the application.

## How to Start and Login
In order to start this application, you will need to follow the following steps: <br>
1. Clone the Repository:
    - Find a location in your file manager that you would like to clone the project to, and navigate to it using your CLI.
    - To clone the repository, run the command `git clone https://github.com/copelansam/swe-3313-fall-2025-team-08`.
      This will create a local copy of the application that you can run on your machine.
2. Build the Application:
   - You must build the application before you can try executing it. you can do this by running `mvn clean install` in your CLI.
   - This will handle all of your dependencies and gets the application into a state where all resources are ready to run the application.
3. Execute the Application:
   - You will now want to navigate to the applications source folder (swe-3313-fall-2025-team-08) in the CLI.
   - Execute the application by running `mvn spring-boot:run` in the CLI. This will start the application on local port 8080
   - In order to access the application, you will open your web browser of choice and enter `http://localhost:8080` into the search bar.
     - This will take you to the sign in screen of the application.
4. Logging In:
    - This application will come with a few accounts preinserted into the database. You can log in with the following credentials:

      | Username | Password | Role  |
      |:--------|:---------|:-----:|
      | Admin   | PGAdmin  | Admin |
      | c00lm4n| 123456   | Regular User|
       | learning| m4th1sfun| Regular User|

<br>\* The admin accounts will be able to perform actions that regular users cannot such as adding inventory, 
   promoting users, and running sales reports.

## Troubleshooting

If maven fails to properly load the applications dependencies, you can fix this by running `mvn clean install -U` in the CLI.