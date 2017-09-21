<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>메인페이지</title>
    <content tag="style">
        <style>

        </style>
    </content>
</head>
<body>
<div class="container text-center" style="margin-top: 50px;">
    <input type="text" name="searchBar" id="searchBar" class="form-control input-lg" autocomplete="off" placeholder="키워드"/>
</div>

<form class="form-horizontal" style="margin-top: 100px;">
    <div class="form-group">
        <label for="title" class="col-sm-2 control-label">title</label>
        <div class="col-xs-5">
            <input type="text" class="form-control" id="title">
        </div>
    </div>
    <div class="form-group">
        <label for="memo1" class="col-sm-2 control-label">memo1</label>
        <div class="col-xs-5">
            <input type="text" class="form-control" id="memo1">
        </div>
    </div>
    <div class="form-group">
        <label for="memo2" class="col-sm-2 control-label">memo2</label>
        <div class="col-xs-5">
            <input type="text" class="form-control" id="memo2">
        </div>
    </div>
</form>
</body>
</html>
<content tag="scripts">
    <script src="/js/bootstrap3-typeahead.min.js"></script>
    <script>
        $(document).ready(function(){
            var $input = $("#searchBar");
            $input.typeahead({
                source:function (query, result) {
                    $.ajax({
                        url:'/barAjax',
                        method:'GET',
                        dataType:'json',
                        success:function (data) {
                            result($.map(data, function (item) {
                                return item;
                            }));
                        }
                    })
                }
            });
            $input.change(function(){
                var current = $input.typeahead("getActive");
                $('#title').val(current.title);
                $('#memo1').val(current.memo1);
                $('#memo2').val(current.memo2);
            });
        });
    </script>
</content>