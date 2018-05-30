var service = 'http://localhost:8080/cat';
var RestPost = function (name, description) {
    var JSONObject = {
        'name': name,
        'description': description
    };
    alert("json");
    $.ajax({
        type: 'POST',
        url: service + '/add',
        contentType: 'application/json',
        data: JSON.stringify(JSONObject),
        dataType: 'json',
        async: false,
        success: function (result) {
            alert("some");
            $('#response').html(JSON.stringify(result));
        },
        error: function (jqXHR, testStatus, errorThrown) {
            alert("error");
            $('#response').html(JSON.stringify(jqXHR));
        }
    });
};