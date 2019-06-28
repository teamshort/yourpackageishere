# Project Name: Your Package Is Here
401 Mid-Course Java Project

![image](https://i.imgur.com/dcCzcSG.jpg)

### Summary
This Java application is designed to be used by a building manager to scan received 
packages in the building for tenants' delieveries and send an email as a notification.


### Developers
   - [Kush Shrestha](https://github.com/kushshrestha01)
   - [Reina Vencer](https://github.com/river-ceanne)
   - [Devon Hackley](https://github.com/devonhackley)
   - [John Winters](https://github.com/thatsjustjohn)
   
   
### Problem Domain
When you receive an email from usps that you package has been delivered, Tenants are unsure if the package has been delivered to the apartment office or not. 
So using our app, building managers can scan the qr code in the package which will automatic send the email to the tenant that their package is in the office for pickup. Tenants are assured that
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
   - Spring Boot (MVC)
   - Bootstrap
   - Java
   
   
### API and Library
   - [Sendgrid API](https://sendgrid.com)
   - [nimiq/qr-scanner Library](https://github.com/nimiq/qr-scanner)
   
   
### Starter Guide

- The Building manager will first visit the website and create an account for their building. 
- They will then add all the tenants information in their account.
- After a package arrives, the building manager can go to 'scan package' tab in 'building' which will open a webcam. If using mobile devices it will 
open the mobile camera.
- Scan the package which will auto populate the tenant's information in a form. 
- Click submit to send the email.
- After the submit button is clicked there will be a notification which will inform the user if the email has been sent. If there is no tenant by that name it will send an email to all of the tenants in that apartment. 
- If there are no matches it will give a message saying that there were no tenants found.

#### Deployed Link: [yourpackageishere.com]()

### To run locally:

1. Clone down the repository on your local machine with command:

           git clone https://github.com/teamshort/yourpackageishere.git

2. Make sure you have Postgres installed in your local machine. You must first create a database named 'yourpackageishere' in psql with command:
            
           CREATE DATABASE yourpackageishere;
           
3. On your application.properties, make sure postgres is set up on with your individual user environment variables

        spring.datasource.url=${DATABASE_URL}
        spring.datasource.username=${DATABASE_USERNAME}
        spring.datasource.password=${DATABASE_PASSWORD}
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
        server.port=5000
    
    Also, include a SendGrid API Key on your environment variables with variable name:
     
        SENDGRID_API_KEY

4. Run the application through your IDE or use the terminal command:
        
        ./gradlew bootrun

5. You will now be able to run the application on your local machine with URL:

        http://localhost:5000

### Entities
- [Building](./src/main/java/com/teamshort/rocks/YourPackageIsHere/Building.java)
- [Tenant](./src/main/java/com/teamshort/rocks/YourPackageIsHere/Tenant.java)


### Controllers
- [BuildingController](./src/main/java/com/teamshort/rocks/YourPackageIsHere/BuildingController.java)
- [TenantController](./src/main/java/com/teamshort/rocks/YourPackageIsHere/TenantController.java)


### CRUD Repositories
- [BuildingRepository](./src/main/java/com/teamshort/rocks/YourPackageIsHere/BuildingRepository.java)
- [TenantRepository](./src/main/java/com/teamshort/rocks/YourPackageIsHere/TenantRepository.java)


### Routes
    @GetMapping("/")
        public String getHomePage(Principal principal, Model model)
    
    @GetMapping("/login")
        public String getLoginPage(Principal principal, Model model)
        
    @GetMapping("/register")
        public String getRegisterPage(Principal principal, Model model)
    
    @GetMapping("/aboutus")
        public String getSignUpPage(Principal principal, Model model)
        
    @PostMapping("/buildingcreate")
        public RedirectView createUser(String username, String name, String streetaddress, String city, String state, String zip, String email, String password) throws ParseException
    
    @GetMapping("/tenant/all")
        public String getAllTenants(Principal principal, Model model)
    
    @GetMapping("/tenant/{id}")
        public String getTenantPage(@PathVariable String id, Model m)
    
    @GetMapping("/tenant/add")
        public String getTenantAddPage()
        
    @PostMapping("/tenantcreate")
        public RedirectView createTenant(Principal p, String firstname, String lastname, String email, String aptnum, String phonenum)    
    
    @PostMapping("/tenantedit")
        public RedirectView editTenant(Principal p, String id, String firstname, String lastname, String email, String aptnum, String phonenum)     


### License - MIT

