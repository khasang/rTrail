<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!--
    if use :
    <script src="js/jquery.min.js" type="text/javascript"></script>
    then doesn't work (not action on try button click)
    -->
    <script src="js/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <title>Title</title>
</head>

<script>
    var service = 'http://localhost:8080/cat';
    var RestPost = function (name, description, colorID) {
        var JSONObject = {
            'name': name,
            'description': description,
            'colorID': colorID
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

    var RestGet = function (id) {
        $.ajax({
            type: 'GET',
            url: service + '/get/' + id,
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

    var RestGetAll = function () {
        $.ajax({
            type: 'GET',
            url: service + '/get/all',
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

    var RestDelete = function (id) {
        $.ajax({
            type: 'DELETE',
            url: service + '/delete/?id=' + id,
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

    var RestGetByName = function (name) {
        $.ajax({
            type: 'GET',
            url: service + '/get/name/' + name,
            contentType: 'application/json;utf-8',
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

    var RestUpdate = function (id, name, description, colorID) {
        id = parseInt(id) || 0;
        var JSONObject = {
            'id': id,
            'name': name,
            'description': description,
            'colorID': colorID
        };
        $.ajax({
            type: 'PUT',
            url: service + '/update',
            contentType: 'application/json',
            data: JSON.stringify(JSONObject),
            dateType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, testStatus, errorTrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };
</script>

<body>
<h1>Admin menu</h1>

<table class="table">
    <tr>
        <th>Request Type</th>
        <th>URL</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>
            Add cat <code><strong>POST</strong></code>
        </td>
        <td>/cat/add</td>
        <td>
            <form class="form-inline">
                name: <input type="text" id="postName" value="Cat's name">
                description: <input type="text" id="postDescription" value="Cat's description">
                colorID : <input type="text" id="postColorID" value="Cat's color ID">
                <button type="button" onclick="RestPost($('#postName').val(), $('#postDescription').val(),
                $('#postColorID').val())">try
                </button>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            Get cat by id <code><strong>GET</strong></code>
        </td>
        <td>/cat/get</td>
        <td>
            <form class="form-inline">
                id: <input type="text" id="getCatID" value=""/>
                <button type="button" onclick="RestGet($('#getCatID').val())">try</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            Get all cats <code><strong>GET</strong></code>
        </td>
        <td>/cat/get/all</td>
        <td>
            <form class="form-inline">
                <button type="button" onclick="RestGetAll()">try</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            Delete cat <code><strong>DELETE</strong></code>
        </td>
        <td>/cat/delete</td>
        <td>
            id: <input type="number" id="deleteId" value=""/>
            <button type="button" onclick="RestDelete($('#deleteId').val())">try
            </button>
        </td>
    </tr>
    <tr>
        <td>
            Get cat by name <code><strong>GET</strong></code>
        </td>
        <td>/cat/get/name</td>
        <td>
            name: <input type="text" id="getName" value="Cat's name">
            <button type="button" onclick="RestGetByName($('#getName').val())">try
            </button>
        </td>
    </tr>
    <tr>
        <td>Update cat <code><strong>PUT</strong></code></td>
        <td>/cat/update</td>
        <td>
            <form class="form-inline">
                id: <input type="text" id="updateId" value="">
                name: <input type="text" id="updateName" value="Cat name">
                description: <input type="text" id="updateDescription" value="Cat description">
                description: <input type="text" id="updateColorID" value="Cat color id">
                <button type="button"
                        onclick="RestUpdate($('#updateId').val(), $('#updateName').val(), $('#updateDescription').val(),
                        $('#updateColorID').val())">
                    try
                </button>
            </form>
        </td>
    </tr>
</table>

<div class="panel panel-default">
    <div class="panel-heading">
        <strong>RESPONSE</strong>
    </div>
    <div class="panel-body" id="response"></div>
</div>
</body>
</html>