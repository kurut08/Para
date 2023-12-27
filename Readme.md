# What is Para?
Para is a web app which contains "store pages" of games, with a button to launch them from Steam platfrom if they are owned by you on an account you are currently logged into on your Steam client.

## How to launch Para?

### Prerequisited
- Docker Desktop;
- Node.js;
- IntelliJ.

### Preparing application for work
- Clone the repository using 
```
- git clone https://github.com/kurut08/Para.git
```
 - Open project in IntelliJ;
 - If you don't see a folder in your Project tab, go to Maven tab and press refresh;
 - Open para-front folder in terminal and execute
```
    npm install
```
 - After it's done, launch Docker/docker-compose.yml and wait until docker container is up and running;
 - Start spring/src/main/java/ParaApplication to launch backend;
 - Go to localhost:3000 to visit the page.

## Docker container after build is finished should consist of:
 - MailDev;
 - pgAdmin;
 - PostgreSQL;
 - React.