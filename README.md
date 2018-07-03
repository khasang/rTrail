# rTrail

- Element1
- Element2
    - SubElement1
- Element3

1. Element1
2. ELement2
    1. ELement2
    2. Element2
        1. El1
        2. El2
        
```html
<h1>Text</h1>
<p>afafafaf</p>

```

[yandex.ru](http://yandex.ru)
![text](http://topkin.ru/wp-content/uploads/2017/10/tomswallpapers.com-15649.jpg)

| Column1 | Column2 |
| ----- | ------ |
| Text1 | Text2 |
| Text1 | Text2 |
| Text1 | Text2 |

## User API
This API allows to made CRUD operations with rout entity.
It realizes with:
1. Entity
2. DAO
3. Service
4. Controller
5. DTO

### User Entity
User entity contains such field as:
1. ID - unique number in Data Base.
2. username - name of User
3. login - use for authentication of users, must be unique
3. password - user's password
4. passwordConfirm - transient password for confirm registration form password
5. email - email of user

### User DAO
User dao interface implements BasicDao with CRUD methods and contains one method for getting users by name

### User service
User service is layer between controller and DAO. This layer take request from controller, receive response from DAO, 
turn it to DTO and transfer to controller

### User controller
User controller is the layer for communication between client and server.
Communication uses json format.
1. /add - add new user to DataBase. Method POST, user transfer in json format in request body. Returns UserDTO.
2. /get/{id} - return user with id. Method GET. Returns UserDTO.
3. /delete/{id} - delete user with id. Method DELETE. Returns deleted userDTO. 
4. /update - update user. Method PUT. Returns updated UserDTO.
5. /get/all - return all users. Method GET. Returns list of UserDTO.
6. /get/name/{username} - return user list with the same name. Method GET. Returns list of UserDTO.

### UserDTO
User Data Transfer Object for represents data to client for CRUD requests

## Rout API
This API allow to made CRUD operations with rout entity.
It realize with:
1. Entity
2. DAO
3. Service
4. Controller

### Rout Entity
Rout entity contains such field as:
1. ID - unique number in Data Base.
2. Name - name of rout
3. Description - rout's description
4. Owner - user how create rout
5. Checkpoints list - list of checkpoints belongs rout

### Rout DAO
Rout dao was created for realize CRUD operations with rout

### Rout service
Rout service is layer between controller and DAO. This layer take request from controller, receive response from DAO, 
turn it to DTO and transfer to controller

### Rout controller
Rout controller is the layer for communication between client and server.
Communication uses json format.
1. /add - add new rout to DataBase. Method POST, rout transfer in json format in request body. Returns added rout.
2. /get/{id} - return rout with id. Method GET. Returns rout.
3. /delete/{id} - delete rout with id. Method DELETE. Returns deleted rout. 
4. /update - update rout. Method PUT. Returns updated rout.
5. /get/all - return all routs. Method GET. Returns list of routs.
6. /get/name/{name} - return routs list with same name. Method GET. Returns list of routs.
7. /get/routByOwner/{owner} - return routs list belongs owner. Method GET. Returns list of routs.

 _______
 
 ## Hello page
Link location: http://localhost:8080/hellopage
 
Bootstrap template with adaptive layout, which allows to look good and
correctly displayed on different devices with different sizes and
screen resolution:
 * On your <a href="#onMobile">mobile device</a>
 * On the <a href="#onComputer">computer</a> and <a href="#onComputer">laptop</a>
 
 Structure of this template (helloPage.jsp):
 - Header (header.jsp)
     - Top menu (topMenu.jsp)
     - Authorization form (auth.jsp)
 - Main content (body.jsp)
     - <a href="#onMobileLeftMenu">Left menu</a> (leftMenu.jsp)
     - Bread crumbs (breadcrumbs.jsp)
 - Footer (footer.jsp)
 
 The horizontal adaptive menu for the site has 2 display modes:
 - desktop (normal) - all menu items are displayed;
 - mobile (minimized) - by default, the brand and the button "Hamburger" 
 (to <a href="#onMobileTopMenu">open</a> the main menu content).
 
 ### <a name="onComputer"></a> Desktop computer and laptop
 Display a template on a desktop computer and laptop.
 
 ![Desktop computer and laptop](https://image.prntscr.com/image/RZR3lKd7QOmUcN8lJaak3Q.png)
 
 ### <a name="onMobile"></a> Mobile device
 Display a template on the mobile device.
 
 ![Mobile device](https://image.prntscr.com/image/zocu98pWRgmqj1xpJw-7ig.png)
 
 ### <a name="onMobileTopMenu"></a> Mobile version of the top menu
 Deployed the top menu on the mobile device.
 
 ![Mobile version of the top menu](https://image.prntscr.com/image/L-H2MHrTRNKah2KK5VvGOg.png)
 
 ### <a name="onMobileLeftMenu"></a> Mobile version of the left menu
 In the mobile device, the left menu is hidden by default. 
 When you click the **Toggle nav** button, the menu appears.
 
 ![Mobile version of the left menu](https://image.prntscr.com/image/tnOIHdtTQPWtuhuHcyO0pg.png)
 
  _______
  
 ## Registration page
 <a href="registratinPage">Link</a> location: http://localhost:8080/registration
 ### <a name="registrationPage"></a> Registration Page
 
 ![Registration Form](https://cdn1.savepice.ru/uploads/2018/6/27/864b23840bd8edfee4a31032ec46f28a-full.png)
 
 Contains registration fields for new users:
 1. Username - not null
 2. Login - must be between 6 to 32 characters and unique
 3. Email - should be a valid email
 4. Password - length at least 8 characters
 5. ConfirmPassword - confirm input password
 
 <a href="validationController">Validation controller</a> return <a href="incorrectForm">messages</a> for incorrect fields.
 ### <a name="incorrectForm"></a> Incorrect input
 
 ![Incorrect Fields](https://cdn1.savepice.ru/uploads/2018/6/27/9ab15b70b94d39b75471b391362b4b3b-full.png)
 
 Form has a link to <a href="#login">login form</a>
 ### <a name="login"></a> Login form
 
 ![Login Form](https://cdn1.savepice.ru/uploads/2018/6/27/9b77c06fab15a2a0175236a9cc8bee58-full.png)
 
 Correct data send to the DataBase and the new user may be log in into the application
 
 ### <a name="validationController"></a> User Validation Controller
 Validate user's input fields from <a href="registrationPage">registration page</a>
 Controller uses validation.properties and messages_ru.properties files for showing <a href="incorrectForm">error messages</a>.
1. NotEmpty validate if the fields not empty.
2. Size.userForm.login validate login should be between 6 to 32 characters.
3. Duplicate.userForm.login verify if this login already uses via #UserAPI.
4. Incorrect.userForm.email uses method validateEmail (String email) to verify correct email.
5. Size.userForm.password verify input password must be at least 8 characters.
6. Diff.userForm.passwordConfirm check if the input password and confirm password are the same.
 
 _______
 
 ## Admin controller
This controller allows the administrator to get online users in json format.
1. /admin/users/get/current - return the current authorized user.
2. /admin/users/get/all - return all authorized users.
3. /admin/users/get/role/{role} - return all authorized users with role.
4. /admin/users/get/name/{name} - return authorized users with name. 
5. /admin/users/get/online - return <a href="#onlineUsers">number of online users</a>

### <a name="onlineUsers"></a> Number of online users
 
![Number of online users on desktop computer](https://image.ibb.co/mgnWPy/pc_offline.png)

![Number of online users in mobile](https://image.ibb.co/kmZHxJ/mobile.png)