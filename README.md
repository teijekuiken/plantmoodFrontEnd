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
5. You can now run the application in your preffered IDE

#### Access local database
For now the application is connected to a local database. To acces the database go to: [localhost:8081](localhost:8081)     
  The database is only accessible after the docker command is executed