<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>목록페이지</title>
    <content tag="style">
        <style>
            .row{
                margin-bottom:20px;
            }
            .highlight {
                 background-color: #FFFF88;
             }
            .cnt-span{
                float:left;
                padding:0 10px 10px 5px;
                font-weight: bold;
            }
            td, th {
                text-align: center;
                width: 300px;
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
                    <input type="hidden" name="page" id="page"/>
                    <input type="text" class="form-control" placeholder="" name="searchTxt" value="${param.searchTxt}">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="submit">찾기</button>
                    </span>

                 </div><!-- /.col-lg-6 -->
            </form>
        </div>
    </div>

    <span class="cnt-span">총 ${totalCnt}건</span>

    <table class="table table-bordered table-striped table-responsive">
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>메모1</th>
            <th>메모2</th>
            <th>메모3</th>
            <th>등록일시</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="obj" items="${list}" varStatus="status">
            <tr>
                <td>${(currentPage-1)*10 + status.index+1}</td>
                <td>${obj.title}</td>
                <td>${obj.memo1}</td>
                <td>${obj.memo2}</td>
                <td>${fn:substring(obj.memo3,0,20)}</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${obj.rdate}"/></td>
                <td>
                    <a class="btn btn-info" href="update/${obj.id}" role="button">수정</a>
                    <a class="btn btn-danger" href="delete/${obj.id}" role="button">삭제</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
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
    <nav id="pagination">

    </nav>
</body>
</html>
<content tag="scripts">
    <script src="/js/jquery.bootpag.js"></script>
    <script>
    $(document).ready(function(){
        $("body td").highlight("${param.searchTxt}");


        // init bootpag
        $('#pagination').bootpag({
            total: ${totalPage},          // total pages
            page: ${currentPage},            // current page
            maxVisible: 10,     // visible pagination
            leaps: true         // next/prev leaps through maxVisible
        }).on("page", function(event, /* page number here */ pageNum){
            //$("body").html("Insert content"); // some ajax content loading...
            $('#page').val(pageNum);
            $('form').submit();
        });
    });
    </script>
</content>