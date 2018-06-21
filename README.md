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
 Шаблон Bootstrap с адаптивной версткой, которая позволяет хорошо смотреться и 
 правильно отображаться на различных устройствах с разным размером и 
 разрешением экрана:
 * На <a href="#onMobile">мобильном</a> устройстве
 * На <a href="#onComputer">настольном компьютере</a> и <a href="#onComputer">ноутбуке</a>
 
 Структура данного шаблона (helloPage.jsp) следующая:
 - шапка (header.jsp)
     - верхнее меню (topMenu.jsp)
     - форма авторизации (auth.jsp)
 - основное содержимое (body.jsp)
     - <a href="#onMobileLeftMenu">левое меню</a> (leftMenu.jsp)
     - хлебные крошки (breadcrumbs.jsp)
 - футер (footer.jsp)
 
 **Горизонтальное адаптивное меню** для сайта имеет 2 режима отображения:
 - десктопный (обычный) – выводятся все элементы меню;
 - мобильный (свёрнутый) – по умолчанию отображается бренд и кнопка «Гамбургер» 
 (для <a href="#onMobileTopMenu">открытия</a> основного содержимого меню).
 
 ### <a name="onComputer"></a> Настольный компьютер
 Отображение шаблона на настольном компьютере и ноутбуке.
 
 ![Настольный компьютер и ноутбук](https://image.prntscr.com/image/U-88-ykmT06DsL-ubVzlSQ.jpg)
 
 ### <a name="onMobile"></a> Мобильное устройство
 Отображение шаблона на мобильном устройстве.
 
 ![Настольный компьютер и ноутбук](https://image.prntscr.com/image/LqTd1gfTQiSRBRFL3ufUEw.png)
 
 
 ### <a name="onMobileTopMenu"></a> Мобильная версия верхнего меню
 Развернутое верхнее меню на мобильном устройстве.
 
 ![Настольный компьютер и ноутбук](https://image.prntscr.com/image/JSj3lMVtRgutU7STCAx1aQ.png)
 
 
 ### <a name="onMobileLeftMenu"></a> Мобильная версия левого меню
 В мобильном устройстве по умолчанию левое меню скрыто. При клике по кнопке 
 **Переключить навигацию** меню появляется.
 
 ![Настольный компьютер и ноутбук](https://image.prntscr.com/image/1vDO9L1ZSwikCTqvV4wb3g.png)