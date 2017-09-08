<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/bootstrap3-typeahead.min.js"></script>
</head>
<body>
<div class="sidebar">
    <h2>aaaa</h2>
    <ul>
        <li><a href="">A</a></li>
        <li><a href="">B</a></li>
        <li><a href="">C</a></li>
    </ul>

</div>


<div class="container"style="width:600px;" >
    <input type="text" name="searchBar" id="searchBar" class="form-control input-lg" autocomplete="off" placeholder="키워드"/>
</div>
</body>
</html>
<script>
    $(document).ready(function(){
       $('#searchBar').typeahead({
            source:function (query, result) {
                $.ajax({
                    url:'/search',
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