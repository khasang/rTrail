var service = 'http://localhost:8080/cat';

var RestPost = function (name, description) {
    var JSONObject = {
        'name': name,
        'description': description
    };
    $.ajax({
        type: 'POST',
        url: service + '/add',
        contentType: 'application/json',
        data: JSON.stringify(JSONObject),
        dataType: 'json',
        async: false,
        success: function (result) {
            $('#response').html(JSON.stringify(result));
        },
        error: function (jqXHR, testStatus, errorThrown) {
            alert("error");
            $('#response').html(JSON.stringify(jqXHR));
        }
    });
    FillCatTable();
};

var FillCatTable = function () {
    $.ajax({
        type: 'GET',
        url: service + '/get/all',
        contentType: 'application/json',
        async: false,
        success: function (result) {
            var $table = $('#catTable');
            $table.find("td").remove();
            $.each(result, function (index, cat) {
                var $tableRaw = $('<tr>').appendTo($table);
                $('<td>').attr("class", "id").text(cat.id).appendTo($tableRaw);
                $('<td>').text(cat.name).appendTo($tableRaw);
                $('<td>').text(cat.description).appendTo($tableRaw);
                var $td = $('<td>');
                $('<button>').attr("class", "delete").text("delete").appendTo($td);
                $td.appendTo($tableRaw);
            });
            $table.find('.delete').click(function () {
                var id = $(this).closest("tr").find(".id").text();
                $.ajax({
                    type: 'DELETE',
                    url: service + '/delete/' + id,
                    contentType: 'application/json',
                    async: false,
                    success: function () {
                        FillCatTable();
                    },
                    error: function () {
                        alert("error receive data");
                    }
                });
            });
        },
        error: function () {
            alert("error receive data");
        }
    });
};

$(document).ready(function () {
    FillCatTable();

});

