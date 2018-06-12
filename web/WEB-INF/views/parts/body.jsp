<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row row-offcanvas row-offcanvas-left">

    <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
        <jsp:include page="leftMenu.jsp"/>
    </div><!--/.sidebar-offcanvas-->

    <div class="col-xs-12 col-sm-9">
        <p class="pull-left visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Переключить навигацию</button>
        </p>

        <div class="jumbotron jumbotron-small-padding">
            <h1>Яндекс Карта</h1>
        </div>


        <div id="breadcrumbs">
            <jsp:include page="breadcrumbs.jsp"/>
        </div>

        <div class="row">
            <%--${textBody}--%>
            <p>На многих коммерческих сайтах есть контактная информация с местом расположения их офиса. Иногда,
                это просто изображение со схемой проезда, но очень часто встречается использование Яндекс.Карт</p>
                <div id="map" style="width: 100%; height: 400px"></div>
        </div>

    </div><!--/.col-xs-12.col-sm-9-->

</div>
<!--/row-->