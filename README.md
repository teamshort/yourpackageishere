# Project Name: Your Package Is Here
401 Final Java Project (Back end)

### Summary
This Java application is designed to be used by a building manager to scan received 
packages in the building for tenants' delieveries and send an email and text as a notification.


### Developers
   - [Kush Shrestha](https://github.com/kushshrestha01)
   - [Levi Porter](https://github.com/levibrooke)
   - [Chaitanya Narukulla](https://github.com/chaitanyanarukulla)
   - [John Winters](https://github.com/thatsjustjohn)
   
   
### Problem Domain
When you receive an email from usps that you package has been delivered, Tenants are unsure if the package has been delivered to the apartment office or not. 
So using our app, building managers can scan the qr code in the package which will automatic send the email and text to the tenant that their package is in the office for pickup. Tenants are assured that
their package has been delivered and is safe stored in office.  


### User Stories
- MVP User Stories As a Tenant, I want to receive emails about packages that have arrived so I know it has been received.
- As a Building manager, I want to be able to sign up and create an account so that I can make full use of this service.
- As a Building manager, I want to be able to log in and add tenants, so that I can send them emails when packages are received.
- As a Building manager, I want to be able to log in and edit tenants, if they happen to change apartments or emails.
- As a Building manager, I want to be able to log in and delete tenants, if they move or are no longer residing.
- As a Building manager, I want to be able to log in and edit the manager information, if I change building names or emails.
- As a Building manager, I want to be able to log in and scan packages, So an auto generated email will notify my tenants of packages.


### Stretch User Stories
As a Building manager, I want to scan shipping labels and send automatic email to tenants that their package has arrived.
As a developers, leveraging delivery APIs to scan QR code or bar code to get the tenants information. 


### Frameworks & Technologies Used
   - Spring Boot
   - Java
   - AWS Services 
   
### Starter Guide

- The Building manager will first visit the website and create an account for their building. 
- They will then add all the tenants information in their account.
- After a package arrives, the building manager can go to 'scan package' tab in 'building' which will open a webcam. If using mobile devices it will 
open the mobile camera.
- Scan the package which will auto populate the tenant's information in a form. 
- Click submit to send the email.
- After the submit button is clicked there will be a notification which will inform the user if the email has been sent. If there is no tenant by that name it will send an email to all of the tenants in that apartment. 
- If there are no matches it will give a message saying that there were no tenants found.

#### Deployed Link: 
- [www.yourpackageishere.com](https://www.yourpackageishere.com/)

### To run your backend locally:

1. Clone down the repository on your local machine with command:

           git clone https://github.com/your-package-is-here/yourpackageishere-backend.git

2. Make sure you have Postgres installed in your local machine. You must first create a database named 'yourpackageishere' in psql with command:
            
           CREATE DATABASE yourpackageishere;
           
3. Before adding anything, run the following command in your database
 
            INSERT INTO roles(name) VALUES('ROLE_USER');
            INSERT INTO roles(name) VALUES('ROLE_ADMIN');
           
4. On your application.properties, make sure postgres is set up on with your individual user environment variables

        spring.datasource.url=${DATABASE_URL}
        spring.datasource.username=${DATABASE_USERNAME}
        spring.datasource.password=${DATABASE_PASSWORD}
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
        server.port=5000

5. Run the application through your IDE or use the terminal command:
        
        ./gradlew bootrun

6. You will now be able to run the back end on your local machine with URL:

        http://localhost:5000

### Entities
- [Building](./src/main/java/com/teamshort/rocks/YourPackageIsHere/model/Building.java)
- [Tenant](./src/main/java/com/teamshort/rocks/YourPackageIsHere/model/Tenant.java)

### Controllers
- [Auth Controller](./src/main/java/com/teamshort/rocks/YourPackageIsHere/controller/AuthController.java)
- [Building Controller](./src/main/java/com/teamshort/rocks/YourPackageIsHere/controller/BuildingController.java)
- [Tenant Controller](./src/main/java/com/teamshort/rocks/YourPackageIsHere/controller/TenantController.java)

### CRUD Repositories
- [Building Repository](./src/main/java/com/teamshort/rocks/YourPackageIsHere/repository/BuildingRepository.java)
- [Tenant Repository](./src/main/java/com/teamshort/rocks/YourPackageIsHere/repository/TenantRepository.java)

### License - MIT

