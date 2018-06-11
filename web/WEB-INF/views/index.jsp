<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <script type="text/javascript">
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
                dateType: 'json',
                async: false,
                success: function (result) {
                    $('#response').html(JSON.stringify(result));
                },
                error: function (jqXHR, testStatus, errorTrown) {
                    $('#response').html(JSON.stringify(jqXHR));
                }
            })
        };

        var RestUpdate = function (id, name, description) {
            id = parseInt(id) || 0;

            var JSONObject = {
                'id': id,
                'name': name,
                'description': description
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

        var RestGet = function (id) {

            id = parseInt(id) || 0;

            $.ajax({
                type: 'GET',
                url: service + /get/ + id,
                contentType: 'application/json',
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

        var RestDelete = function (id) {

            id = parseInt(id) || 0;

            $.ajax({
                type: 'DELETE',
                url: service + '/delete/?id=' + id,
                contentType: 'application/json',
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

</head>
<body>
<h1>Admin menu</h1>

<table class="table">
    <tr>
        <th>Request Type</th>
        <th>URL</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>Add cat <code><strong>POST</strong></code></td>
        <td>/cat/add</td>
        <td>
            <form class="form-inline">
                name: <input type="text" id="postName" value="Cat name">
                description: <input type="text" id="postDescription" value="Cat description">
                <button type="button" onclick="RestPost($('#postName').val(), $('#postDescription').val())">try</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>Get cat <code><strong>GET</strong></code></td>
        <td>/cat/get</td>
        <td>
            <form class="form-inline">
                id: <input type="text" id="getId" value="">
                <button type="button" onclick="RestGet($('#getId').val())">try</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>Delete cat <code><strong>DELETE</strong></code></td>
        <td>/cat/delete</td>
        <td>
            <form class="form-inline">
                id: <input type="text" id="deleteId" value="">
                <button type="button" onclick="RestDelete($('#deleteId').val())">try</button>
            </form>
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
                <button type="button"
                        onclick="RestUpdate($('#updateId').val(), $('#updateName').val(), $('#updateDescription').val())">
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


<h2>Каталог товаров</h2>
<ul>
    <li><a href="/catalog/">Каталог товаров</a></li>
</ul>
</body>
</html>
