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
        <form id="loginForm">
            <div class="mb-3">
                <label class="form-label">이메일</label>
                <input type="email" name="email" id="email"
                       class="form-control"
                       placeholder="이메일을 입력하세요" required>
            </div>

            <div id="에러창"></div>

            <div class="d-grid mt-4">
                <button type="button" id="loginBtn" onclick="로그인기능()" class="btn btn-dark">로그인</button>
            </div>
        </form>

        <script>
            async function 로그인기능() {
                const 이메일   = document.getElementById("email").value;
                const 에러창   = document.getElementById("에러창");
                const 로그인버튼 = document.getElementById("loginBtn");

                if (이메일.trim() === "") {
                    에러창.innerHTML = `<div class="alert alert-danger mt-2">이메일을 입력해주세요.</div>`;
                    return;
                }

                로그인버튼.disabled    = true;
                로그인버튼.textContent = "로그인 중...";

                try {
                    const 응답 = await fetch("/user/login", {
                        method:  "POST",
                        headers: { "Content-Type": "application/json" },
                        body:    JSON.stringify({ email: 이메일 })
                    });

                    if (!응답.ok) throw new Error(`서버 오류: ${응답.status}`);

                    const 결과 = await 응답.json();

                    if (결과.success) {
                        window.location.href = 결과.redirectUrl || "/";
                    } else {
                        에러창.innerHTML = `<div class="alert alert-danger mt-2">이메일 또는 정보가 올바르지 않습니다.</div>`;
                    }

                } catch (err) {
                    console.error("로그인 실패:", err);
                    에러창.innerHTML = `<div class="alert alert-danger mt-2">로그인 중 오류가 발생했습니다. 다시 시도해주세요.</div>`;

                } finally {
                    로그인버튼.disabled    = false;
                    로그인버튼.textContent = "로그인";
                }
            }
        </script>