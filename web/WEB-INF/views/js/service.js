var service = 'http://localhost:8080/cat';
var RestPost = function (name, description) {
    var JSONObject = {
        'name': name,
        'description': description
    };

    $.ajax({
        type: 'POST',
        url: service + '/add',
        contentType: 'application/json;utf-8',
        data: JSON.stringify(JSONObject),
        dataType: 'json',
        async: false,
        success: function (result) {
            $('#response').html(JSON.stringify(result));
        },
        error: function (jqXHR, testStatus, errorThrown) {
            $('#response').html(JSON.stringify(jqXHR));
        }
    });
};
