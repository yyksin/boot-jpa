<%--
  Created by IntelliJ IDEA.
  User: IMC021
  Date: 2017. 9. 21.
  Time: AM 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>login</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/css/login.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script>
    $(function() {
        $('#login-form-link').click(function(e) {
            $("#login-form").delay(100).fadeIn(100);
            $("#register-form").fadeOut(100);
            $('#register-form-link').removeClass('active');
            $(this).addClass('active');
            e.preventDefault();
        });
        $('#register-form-link').click(function(e) {
            $("#register-form").delay(100).fadeIn(100);
            $("#login-form").fadeOut(100);
            $('#login-form-link').removeClass('active');
            $(this).addClass('active');
            e.preventDefault();
        });
        $('#btn').click(function(){
            if($('#uid').val() == ""){
                alert("아이디를 입력해주세요");
                return false;
            }
            if($('#password1').val() == ""){
                alert("비밀번호를 입력해주세요");
                return false;
            }
            if($('#password1').val() != $('#password2').val()){
                alert('비밀번호가 서로 일치하지 않습니다.');
                return false;
            }
            $('#register-form').submit();
        });
    });
</script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-login">
                <div class="panel-heading">
                    <ul class="tab_frm">
                        <li><a href="#" class="active" id="login-form-link">Login</a></li>
                        <li>	<a href="#" id="register-form-link">Register</a></li>
                    </ul>
                    <hr>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form id="login-form" action="/login_process" method="post" role="form" style="display: block;">
                                <div class="form-group">
                                    <input type="text" name="uid" id="username" tabindex="1" class="form-control" placeholder="Username" value="">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="upassword" id="password" tabindex="2" class="form-control" placeholder="Password">
                                </div>
                                <div class="form-group text-center">
                                    <input type="checkbox" tabindex="3" class="" name="remember" id="remember">
                                    <label for="remember"> Remember Me</label>
                                </div>
                                <c:if test="${param.error eq ''}">
                                <div class="form-group text-center text-danger">
                                    <label for="remember">유저 정보가 없습니다.</label>
                                </div>
                                </c:if>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="text-center">
                                                <a href="http://phpoll.com/recover" tabindex="5" class="forgot-password">Forgot Password?</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <form id="register-form" action="/user/create" method="post" role="form" style="display: none;">
                                <div class="form-group">
                                    <input type="text" name="uid" id="uid" tabindex="1" class="form-control" placeholder="ID" value="">
                                </div>
                                <div class="form-group">
                                    <input type="text" name="uname" id="email" tabindex="1" class="form-control" placeholder="NAME" value="">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="upassword" id="password1" tabindex="2" class="form-control" placeholder="Password">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="confirm-password" id="password2" tabindex="2" class="form-control" placeholder="Confirm Password">
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <input type="button" id="btn" name="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
