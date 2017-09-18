<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>yyk | 메인페이지</title>
</head>
<body>
<div class="container text-center">
    <input type="text" name="searchBar" id="searchBar" class="form-control input-lg" autocomplete="off" placeholder="키워드"/>
</div>
</body>
</html>
<content tag="scripts">
    <script src="/js/bootstrap3-typeahead.min.js"></script>
    <script>
        $(document).ready(function(){
            $('#searchBar').typeahead({
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
        });
    </script>
</content>