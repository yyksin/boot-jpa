<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title><sitemesh:write property='title' /></title>
    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]\-->
    <style>
    </style>
    <sitemesh:write property='page.style' />
</head>

<body>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <ul class="nav navbar-nav">
                <li><a href="/">HOME</a></li>
                <li><a href="/new">UPDATE</a></li>
                <li><a href="/list">LIST</a></li>
            </ul>
        </div>
    </nav>
    <div class="container text-center">
        <sitemesh:write property='body' />
    </div>
</body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery.highlight.js"></script>

<script>
    $(document).ready(function () {
        $(function () {
                url = window.location;
                element = $('ul.nav a').filter(function () {
                    return url.href === this.href;
                });
                element.parent().addClass('active');
        });
    });
</script>
<sitemesh:write property='page.scripts' />

