Bank Account App Installation Guide

Requirements
1.Install Spring Tool Suite from https://spring.io/tools/sts/all/
2.Install Mysql workbench 6.3 CE for the database

Deployment Guide
1. Assuming that you have successfully installed STS.

Launch Spring Tool Suite(STS) on your PC
  
Steps to follow.
i). Import folder named BankAccountAPI from the shared ZIP file into Spring Tool Suite(sts) this is our application API.
ii). Import folder named BankAccountApp from the shared ZIP file into into Spring Tool Suite(sts) this is our bankAccount application.

   Upto here we have imported the application and api.Now let us shift back to the database.

2.Assuming that you have successfully installed mysqlworkbench on your pc.
Double click the workbench icon to launch it.
Steps to follow
- Import the bank_account dump shared in zip file

NOTE:
If your mysql workbench connection has password or different username other than 'root'.

Editing DB connection String.
go to Spring Tool Suite.
- Expand directory BankAccountAPI>>src/main/resources.
- Double click application.properties file.
- Edit connection credentials username and password to your preference.
  Current credentials are username 'root' no password.

  upto here we are done deploying the database and connection properties are set.


3.Running APP and API
  Go to Spring Tool Suite(STS)

 i) - Under dir BankAccountAPI>>src/main/java>>packages>>
    - right click BankAccountApiApplication.java on the pop up select Run As >> Spring Boot App
    - this runs the api on port 8888
 i) - Under dir BankAccountApp>>src/main/java>>packages>>
    - right click BankAccountAppApplication.java on the pop up select Run As >> Spring Boot App
    - this runs the app 8999

to do deposit | withdrawal | balance check operations use account number '1' or '2'

4.You can now access the application on your browser
  url http://localhost:8999/

5.to view transactions history
use url http://localhost:8999/viewtransactions









