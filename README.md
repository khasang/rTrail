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
 