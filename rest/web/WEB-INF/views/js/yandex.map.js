        ymaps.ready(init);
        var myMap, 
            myPlacemark;

        function init(){ 
            myMap = new ymaps.Map("yandexMap", {
                center: [55.76, 37.64],
                zoom: 7
            }); 
            
            myPlacemark = new ymaps.Placemark([55.76, 37.64], {
                hintContent: 'Moscow!',
                balloonContent: 'Capital of Russia'
            });
            
            myMap.geoObjects.add(myPlacemark);
        }