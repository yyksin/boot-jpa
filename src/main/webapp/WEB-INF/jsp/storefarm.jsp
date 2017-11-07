<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>스토어팜</title>
</head>
<body>
<h3>스토어팜</h3>
<hr>
<form class="form-horizontal">
    <div class="form-group">
        <label class="control-label col-md-3">판매가격</label>
        <div class="col-md-3">
            <input type="text" class="form-control" id="price"/>
        </div>
        <input type="button" class="btn btn-primary" style="float: left;" value="확인" id="btn"/>
    </div>
    <div class="form-group">
        <label class="control-label col-md-3">결과</label>
        <div class="col-md-3" id="result">
        </div>
    </div>
</form>
</body>
</html>
<content tag="scripts">
    <script>
        $(function () {
            $('#btn').click(function(){
                var price = $('#price').val();
                var card = price * 0.0374;
                var sendMoney = price * 0.0165;
                var onlyMoney = price * 0.01;
                var phone = price * 0.0385;
                var usePoint = price * 0.0374;

                var naver = price * 0.02;
                var delivery = 3000;

                var minus = naver+delivery;


                var write = 300;
                var premium = 500;
                var zzim = 500;

                var result = "price : "+price + ", 2% : "+naver+", 택배 : "+delivery+"<br>";
                result += "신용카드 : "+ (price - card-minus)+"<br>";
                result += "계좌이체 : "+ (price - sendMoney-minus)+"<br>";
                result += "무통장입금 : "+(price - onlyMoney-minus)+"<br>";
                result += "휴대폰결제 : "+(price - phone-minus)+"<br>";
                result += "포인트결제 : "+(price - usePoint-minus)+"<br>";
                $('#result').text('');
                 $('#result').append(result);
            });
        });
    </script>
</content>