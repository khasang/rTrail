<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/resources/js/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
    <script type="text/javascript">
        var service = 'http://localhost:8080/cat';
        var RestPost = function (name, description){
            var JSONObject = {
                'name': name,
                'description': description
            };

            $.ajax({
                type: 'POST',
                url: service + '/add',
                contentType: 'application/json;utf-8',
                data: JSON.stringify(JSONObject),
                dateType: 'json',
                async: false,
                success: function(result){
                    $('#response').html(JSON.stringify(result));
                },
                error: function (jqXHR, testStatus, errorTrown) {
                    $('#response').html(JSON.stringify(jqXHR));
                }
            })
        }

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


    <h2>Каталог товаров</h2>
<ul>
    <li><a href="/catalog/">Каталог товаров</a></li>
</ul>
</body>
</html>
