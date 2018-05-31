<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        <%@ include file="js/myScript.js" %>
    </script>
    <title>Start Page</title>
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

<button type="button" onclick="FillCatTable()">fill table</button>

<div class="panel panel-default">
    <div class="panel-heading">
        <strong>RESPONSE</strong>
    </div>
    <div class="panel-body" id="response"></div>
</div>
<div id="cats">
    <table class="table" id="catTable">
        <tr>
            <th>Cat ID</th>
            <th>Cat name</th>
            <th>Description</th>
            <th>Action</th>
        </tr>
    </table>
</div>
</body>
</html>
