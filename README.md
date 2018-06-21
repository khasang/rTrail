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
**Пепеключить навигацию** меню появляется.

![Настольный компьютер и ноутбук](https://image.prntscr.com/image/1vDO9L1ZSwikCTqvV4wb3g.png)