This application is written By Nagayya as assignment using Java 1.8, SpringBoot, OpenCSV API

To run this code:
1) Please unzip to folder
2) run below command:
mvn spring-boot:run 

As of now i am reading first 16 columns, but this can be changed easly by changing the number in file "ChargingPoints.NOOFCOLUMNS_READ"

I have tested this app with POSTMAN (Chrome) with below requests
1) POST request with Content-Type as multipart/form-data
http://localhost:8080/upload

2) DELETE:
http://localhost:8080/remove?chargeDeviceID=e2f964e176efb40969652e3249023645

3) POST request
http://localhost:8080/add
with Body as below:
ddecc260427b448f88f296b1ef62b8a8,SRC_LDN60203,Asda Leyton,51.555913,-0.009736,,Asda Leyton Mills Superstore,,Marshall Road,,,,Leyton,Greater London,E10 5NH,gb,,,,,,,Source London,https://www.sourcelondon.net,020 3056 8989,,Source London,https://www.sourcelondon.net,020 3056 8989,,Source London,In service,Published,0,2014-08-19 05:15:13,2015-08-26 11:37:26,Y,2015-08-26 11:37:26,NCR Admin,Source London,n/a,0,,1,£5 per annum for RFiD card,0,,,0,,0,,,Retail car park,,0,,,,,,,,,,,,,,,118733,Type 2 Mennekes (IEC62196),7.0,32,230,Single Phase AC,3,0,In service,"  x 7-pin 'Smart' eg Mennekes (IEC 62196) - Fast (7kW, 32A)",0,118734,Type 2 Mennekes (IEC62196),7.0,32,230,Single Phase AC,3,0,In service,"  x 7-pin 'Smart' eg Mennekes (IEC 62196) - Fast (7kW, 32A)",0,118735,Type 2 Mennekes (IEC62196),7.0,32,230,Single Phase AC,3,0,In service,"  x 7-pin 'Smart' eg Mennekes (IEC 62196) - Fast (7kW, 32A)",0,118736,Type 2 Mennekes (IEC62196),7.0,32,230,Single Phase AC,3,0,In service,"  x 7-pin 'Smart' eg Mennekes (IEC 62196) - Fast (7kW, 32A)",0,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,

4) GET:
http://localhost:8080/findnearest?latitude=51.555913&longitude=-0.009736


I have not written test cases because of time constraint but i will try to write before coming to interval


Please note this application can be developed in many other ways like:
1) We can introduce database (in-memory DB) so that we can store data for later use
2) we can read only few important columns (like ID, Lattitude, Longitude) instead of reading all attributes from file
So that it will be faster to process file/requests
3) While finding nearest station, i can return nearest charging points (more than one)


This code is not production ready because of following reasons:
1) Error/exception handling needs to be done
2) Logging is not present
3) Test cases coverage is low (performance/load testing is done)
4) code can be imporoved after code review