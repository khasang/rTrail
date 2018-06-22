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