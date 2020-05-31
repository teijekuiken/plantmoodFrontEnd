### PlantMood Central System

#### Steps to run the application

1.  [Install](https://hub.docker.com/editions/community/docker-ce-desktop-windows/) docker if its not already installed. 
2.  Make sure port 3306 is available. Usually this port is used for MySQL. If the port is in use you need to stop MySQL from usign the port manually before continuing:
- ##### *For windows*
  - Open taskmanager
  - Go to service tab
  - Find MySQL80
  - Right click on the name and click stop
- ##### *For Mac*
  - ?
3. Open a new terminal in the folder where the project is located
4. Run the following command: docker-compose up -d  ***(This step only needs to be done one time, after that the docker container will be running at all times)***
5. [Install](https://mosquitto.org/download/) Mosquitto if its not already installed
6. Run mosquitto.exe from the location where you have installed Mosquitto
7. Create a new file in presentation/src/main/resources named __application.properties__.
8. Find the application.properties.dist and copy the content in your application.properties file.
9. Update the oopa.mqtt.client IP adress in the application.properties file to the IP adress where your local Mosquitto broker is running, 
update the client id to : __Plantmood-CentralSystem__ and the topic to : __Plantmood/AllPlantMoods/Data__
10. You can now run the application in your preffered IDE

#### Access local database
For now the application is connected to a local database. To acces the database go to: [localhost:8081](localhost:8081)     
  The database is only accessible after the docker command is executed
  
### Local development
when installing the project for the first time, enter the following command in the root of your project:
```bash
make && make git
```