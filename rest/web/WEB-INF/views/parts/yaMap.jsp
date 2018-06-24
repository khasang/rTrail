<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<div id="map"></div>
<div class="form-group">
    <div class="row">
        <div class="col-xs-2">
            <input name="getById" id="getById" type="text" class="form-control">
        </div>
        <div class="col-xs-3">
            <input type="button" class="btn btn-default" value="GET BY ID" onclick="getById()">
        </div>
    </div>
</div>
<form role="form">
    <div class="form-group">
        <div class="row">
            <div class="col-xs-3">
                <input name="id" type="text"  class="form-control" placeholder="ID" id="id" disabled/>
            </div>
            <div class="col-xs-6">
                <input name="name" type="text"  class="form-control" placeholder="NAME" id="name"/>
                <p class="help-block">TYPE NAME OF ROUT</p>
            </div>
            <div class="col-xs-3">
                <div class="input-group">
                    <span class="input-group-addon">@</span>
                    <input name="username" type="text" class="form-control" placeholder="Username" id="username" disabled/>
                </div>
        </div>
        </div>
    </div>
    <div class="form-group">
        <textarea name="comment" class="form-control" placeholder="Description" id="description"></textarea>
    </div>
    <div class="form-group">
        <input type="button" class="btn btn-success" value="SAVE" onclick="upLoad()"/>
        <input type="button" class="btn btn-danger" value="DELETE" onclick="deleteRout()"/>
        <input type="button" class="btn btn-default" value="UPDATE" onclick="update()"/>
    </div>
</form>
</body>
</html>
