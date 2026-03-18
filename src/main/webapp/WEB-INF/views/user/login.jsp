<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body class="bg-light">

<div class="container mt-5" style="max-width: 500px;">
    <div class="card p-4 shadow-sm">

        <h2 class="mb-4 text-center fw-bold">로그인</h2>

        <c:if test="${param.success == 'join'}">
            <div class="alert alert-success">🎉 회원가입이 완료되었습니다. 로그인해주세요.</div>
        </c:if>

        <%-- Login은 회사에서 요구하는 로직에 따라
             Post 도 가능하고 Get 가능
         --%>

        <input type="email" id="email">
        <input type="password" id="password">
        <button onclick="로그인()">로그인</button>

            <div id="에러창"></div>

        <script>
            async function 로그인() {
                const email    = document.getElementById("email").value.trim();
                const password = document.getElementById("password").value.trim();

                const res = await fetch("user/login", {
                    method: "post",
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify({email,password })  // ← JSON 으로 변환해서 전송
                });

                const data = await res.json();

                if (res.ok) {
                    window.location.href = "/"
                } else {
                    alert("이메일 또는 비밀번호가 틀렸습니다");
                }
            }

        </script>