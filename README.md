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
  
#### Local development
when installing the project for the first time, enter the following command in the root of your project:
```bash
make && make git
```

#### Plantmood Health Algorithm
To calculate if your plant needs extra water, is healthy or has too much water, an alogirtm is created to determine the status. 
In the PlantmoodService the function GetPlantmoodStatus, checks the last 5 results from the Plantmood and checks the database for what kind of plantspecies is linked.
The algoritm works as follows:

1. All PlantmoodHistories are requested and ordered by date.
2. A sublist is created with the last 5 measured results for a specific Plantmood SN
3. All the measurements from the sublist are weighted. The latest measurement is multiplied by 1. Foreach extra measurement the weight is lowered by 0.2.
4. All weigthed measures are summed and divided by the sum of the weight to get a weighted average.
5. 
	- If the weighted average is lower than the minimum humidity of the Plantspecies, the returned mood will be "Plant needs water"
	- If the weighted average is higher than the maximum humidity of the Plantspecies, the returned mood will be "Plant has too much water"
	- If the weighted average is between the minimum and maximum humidity of the Plantspecies, the returned mood will be "Water level is good"

This algorithm is chosen, because it is less dependent of outliers when multiple points are being used. 
We believe that the latest measurement is the most valuable, so that is where the weigthed values come in. 
The more recent measurements are counted more heavily.