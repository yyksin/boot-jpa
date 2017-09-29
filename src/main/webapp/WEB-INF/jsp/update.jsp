<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>yyk | 등록/수정</title>
</head>
<body>
    <h3>등록/수정</h3>
    <hr>
    <form class="form-horizontal" method="post" action="/save">
        <input type="hidden" name="id" value="${obj.id}"/>
        <div class="form-group">
            <label class="control-label col-md-3">제목</label>
            <div class="col-md-7">
                <input type="text" class="form-control" name="title" value="${obj.title}"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-3">메모1</label>
            <div class="col-md-7">
                <textarea class="form-control" name="memo1" rows="2">${obj.memo1}</textarea>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-3">메모2</label>
            <div class="col-md-7">
                <textarea class="form-control" name="memo2" rows="2">${obj.memo2}</textarea>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-3">메모2</label>
            <div class="col-md-7">
                <textarea class="form-control" name="memo3" rows="20">${obj.memo3}</textarea>
            </div>
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-primary" value="Save"/>
        </div>
    </form>
</body>
</html>