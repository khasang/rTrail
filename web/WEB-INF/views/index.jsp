<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
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
                    name: <input type="text" id="postName" value="Cat name">
                    description: <input type="text" id="postDescription" value="Cat description">
                    <button type="button" onclick="RestPost($('#postName').val(), $('#postDescription').val())">try</button>
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
