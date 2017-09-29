<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>MY 정보</title>
</head>
<body>
<h3>MY 정보</h3>
<hr>
<form class="form-horizontal" method="post" action="/user/update">
    <div class="form-group">
        <label class="control-label col-md-3">ID</label>
        <div class="col-md-7">
            <input type="hidden" name="idx" value="${user.idx}">
            <input type="hidden" name="uid" value="${user.uid}">
            ${user.uid}
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-md-3">NAME</label>
        <div class="col-md-7">
            <input type="text" class="form-control" name="uname" value="${user.uname}"/>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-md-3">PASSWORD</label>
        <div class="col-md-7">
            <input type="text" class="form-control" name="upassword" id="password1" required/>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-md-3">PASSWORD 확인</label>
        <div class="col-md-7">
            <input type="text" class="form-control" id="password2"/>
        </div>
    </div>
    <div class="form-group">
        <input type="buttion" class="btn btn-primary" value="Save" id="btn"/>
    </div>
</form>
</body>
</html>
<content tag="scripts">
    <script>
        $(function () {
            $('#btn').click(function(){
               if($('#password1').val() == ""){
                   alert("비밀번호를 입력해주세요");
                   return false;
               }
               if($('#password1').val() != $('#password2').val()){
                   alert('비밀번호가 서로 일치하지 않습니다.');
                   return false;
               }
               $('form').submit();
            });
        });
    </script>
</content>