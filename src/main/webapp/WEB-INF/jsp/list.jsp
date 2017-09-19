<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>yyk | 목록페이지</title>
    <content tag="style">
        <style>
            .row{
                margin-bottom:20px;
            }
            .highlight {
                 background-color: #FFFF88;
             }
        </style>
    </content>
</head>
<body>
    <h3>목록</h3>
    <hr>
    <div class="row">
        <div class="col-lg-6">
            <form>
                <div class="input-group">

                    <input type="text" class="form-control" placeholder="" name="searchTxt" value="${param.searchTxt}">
                    <span class="input-group-btn">

                <button class="btn btn-default" type="submit">찾기</button>
            </form>
          </span>
            </div><!-- /input-group -->
        </div><!-- /.col-lg-6 -->
    </div>
    <div class="table-responsive">
        <table class="table table-striped table-bordered text-left">
            <thead>
            <tr>
                <th>순번</th>
                <th>제목</th>
                <th>메모</th>
                <th>등록일시</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="obj" items="${list}" varStatus="status">
                <tr>
                    <td>${status.index+1}</td>
                    <td>${obj.subject}</td>
                    <td>${obj.memo}</td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${obj.rdate}"/></td>
                    <td>
                        <a class="btn btn-info" href="update/${obj.id}" role="button">수정</a>
                        <a class="btn btn-danger" href="delete/${obj.id}" role="button">삭제</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <%--<nav>--%>
        <%--<ul class="pagination">--%>
            <%--<li>--%>
                <%--<a href="#" aria-label="Previous">--%>
                    <%--<span aria-hidden="true">&laquo;</span>--%>
                <%--</a>--%>
            <%--</li>--%>
            <%--<li><a href="#">1</a></li>--%>
            <%--<li><a href="#">2</a></li>--%>
            <%--<li><a href="#">3</a></li>--%>
            <%--<li><a href="#">4</a></li>--%>
            <%--<li><a href="#">5</a></li>--%>
            <%--<li>--%>
                <%--<a href="#" aria-label="Next">--%>
                    <%--<span aria-hidden="true">&raquo;</span>--%>
                <%--</a>--%>
            <%--</li>--%>
        <%--</ul>--%>
    <%--</nav>--%>
    <nav id="page-selection">

    </nav>
    <script>
        // init bootpag
        $('#page-selection').bootpag({
            total: 10
        }).on("page", function(event, /* page number here */ num){
            $("#content").html("Insert content"); // some ajax content loading...
        });
    </script>
</body>
</html>
<content tag="scripts">
    <script src="/js/jquery.bootpag.js"></script>
    <script>
    $(document).ready(function(){
        $("body td").highlight("${param.searchTxt}");

        // init bootpag
        $('#page-selection').bootpag({
            total: 10
        }).on("page", function(event, /* page number here */ num){
            $("body").html("Insert content"); // some ajax content loading...
        });
    });
    </script>
</content>