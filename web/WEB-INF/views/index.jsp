<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous">
    </script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <title>Title</title>


</head>

<script>
    var service = 'http://localhost:8080/cat';
    var RestPost = function (name, description) {
        var JSONObject = {
            'name': name,
            'description': description
        };
        $.ajax({
            type: 'POST',
            url: service + '/add',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: [function (result) {
                $('#response').html(JSON.stringify(result));
            }],
            error: [function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }]
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
    //UPDATE  Cat function
    var RestUpdate = function (id, name, description) {
        var JSONObject = {
            'id' : id,
            'name': name,
            'description': description
        };
        $.ajax({
            type: 'PUT',
            url: service + '/update',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
                $('#response').html("ERROR: Cat with Id:"+id+" not exist");
            }
        });
    };
    //Delete Cat Function
    var RestDelete = function (id) {
        $.ajax({
            type: 'DELETE',
            url: service + '/delete/' + id,
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, testStatus, errorThrown) {
                //$('#response').html(JSON.stringify(jqXHR));
                $('#response').html(JSON.stringify("CAT with id "+id+" not exist"));
            }
        });
    };
</script>
<body>

<h1>Hello ${name}</h1>
<ul>
    <li><a href="/get/Penelope">RequestByName /get/Penelope</a></li>
    <li><a href="">Пункт меню</a></li>
</ul>

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
                name: <input type="text" id="postName" value="Cat Name">
                description: <input type="text" id="postDescription" value="Cat description">
                <button type="button" onclick="RestPost($('#postName').val(), $('#postDescription').val())">try</button>
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
            Update Cat by ID  <code><strong>UPDATE</strong></code>
        </td>
        <td>/cat/Update</td>
        <td>
            <form class="form-inline">
                id: <input type="text" id="2getCatID" value=""/>
                name: <input type="text" id="2postName" value="Cat Name">
                description: <input type="text" id="2postDescription" value="Cat description">
                <button type="button" onclick="RestUpdate($('#2getCatID').val(), $('#2postName').val(), $('#2postDescription').val())">try</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            Delete Cat By Id <code><strong>DELETE</strong></code>
        </td>
        <td>/cat/delete</td>
        <td>
            <form class="form-inline">
                id: <input type="text" id="deleteCatID" value=""/>
                <button type="button" onclick="RestDelete($('#deleteCatID').val())">try</button>
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