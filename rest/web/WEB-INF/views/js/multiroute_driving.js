function init () {
    multiRoute = new ymaps.multiRouter.MultiRoute({
        referencePoints: rout,
        params: {
            results: 1
        }
    }, {
        editorMidPointsType: "via",
        editorDrawOver: false
    });

    buttonEditor = new ymaps.control.Button({
        data: { content: "Режим редактирования" }
    });

    buttonEditor.events.add("select", function () {
        multiRoute.editor.start({
            addWayPoints: true,
            removeWayPoints: true
        });
    });

    buttonEditor.events.add("deselect", function () {
        multiRoute.editor.stop();
        routMake(multiRoute);
    });

    myMap = new ymaps.Map('map', {
        center: rout[1],
        zoom: 7,
        controls: ['default', 'routeButtonControl', buttonEditor]
    }, {
        buttonMaxWidth: 300
    });
    myMap.geoObjects.add(multiRoute);

}
function routMake(multiRoute) {
    var JSONObject = multiRoute.model.getJson();
    var length = JSONObject.properties.waypoints.length;
    var routJson =[];
    for (var i = 0; i <length; i++) {
        var x = JSONObject.properties.waypoints[i].coordinates[0];
        var y = JSONObject.properties.waypoints[i].coordinates[1];
        routJson.push({"coordX": x*(1000000000000000), "coordY": y*(1000000000000000)});
    }
    routjson = routJson;

}
var routjson;
var rout = [[55.734876, 37.59308], [56.86584046233189, 35.909198046874444], [56.27758208348245, 34.29420781249997]];
console.log(rout);
ymaps.ready(init);

function upLoad() {
    var prerout = {"name": $('#name').val(),
        "owner": $('#username').val(),
        "description": $('#description').val(),
        "checkPointList": routjson};
    $.ajax({
        type: 'POST',
        url:  'rout/add',
        contentType: 'application/json;utf-8',
        data: JSON.stringify(prerout),
        dataType: 'json',
        async: false,
        success: function (result) {
            console.log("Success");
            $('#id').val(result.id);
            $('#name').val(result.name);
        },
        error: function (jqXHR, testStatus, errorThrown) {
            console.log("Error "+ errorThrown);
        }
    });
}
var deleteRout = function () {
    $.ajax({
        type: 'DELETE',
        url: 'rout/delete/' + $('#id').val(),
        dataType: 'json',
        async: false,
        success: function (result) {
            $('#id').val("ID");
            $('#name').val("DELETED");
            $('#description').val("");
        },
        error: function (jqXHR, testStatus, errorThrown) {
        }
    });
};

function getById() {
    myMap.geoObjects.removeAll();
    multiRoute = null;
    $.ajax({
        type: 'GET',
        url: 'rout/get/' + $('#getById').val(),
        dataType: 'json',
        async: false,
        success: function (result) {
            $('#id').val(result.id);
            $('#name').val(result.name);
            $('#description').val(result.description);
            rout = null;
            rout = [];
            for (var i = 0; i <result.checkPointList.length; i++) {
                var x = result.checkPointList[i].coordX/1000000000000000;
                var y = result.checkPointList[i].coordY/1000000000000000;
                rout.push([y,x]);
            }
            console.log(rout);
        },
        error: function (jqXHR, testStatus, errorThrown) {
        }

    });
    myMap.geoObjects.removeAll();
        multiRoute = new ymaps.multiRouter.MultiRoute({
                referencePoints: rout,
                params: {results: 1}},
            {editorMidPointsType: "via", editorDrawOver: false});
        myMap.geoObjects.add(multiRoute);
};
function update() {
    var prerout = {"id": $('#id').val(),
        "name": $('#name').val(),
        "owner": $('#username').val(),
        "description": $('#description').val(),
        "checkPointList": routjson};
    $.ajax({
        type: 'PUT',
        url:  'rout/update',
        contentType: 'application/json;utf-8',
        data: JSON.stringify(prerout),
        dataType: 'json',
        async: false,
        success: function (result) {
            console.log("Success");
        },
        error: function (jqXHR, testStatus, errorThrown) {
            console.log("Error "+ errorThrown);
        }
    });
};