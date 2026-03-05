<%-- TODO 11. header.jsp 를 include 하시오 --%>
???

<div class="container mt-5" style="max-width: 500px;">
    <div class="card p-4 shadow-sm">
        <h2 class="mb-4 text-center fw-bold">✏️ 제품 수정</h2>
        <form action="/product/edit" method="post">
            <input type="hidden" name="id" value="${product.id}">
            <div class="mb-3">
                <label class="form-label">제품명</label>
                <input type="text" name="name" value="${product.name}" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">가격</label>
                <input type="number" name="price" value="${product.price}" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">재고</label>
                <input type="number" name="stock" value="${product.stock}" class="form-control" required>
            </div>
            <div class="d-grid gap-2">
                <button type="submit" class="btn btn-warning">수정 완료</button>
                <a href="/product/list" class="btn btn-outline-secondary">취소</a>
            </div>
        </form>
    </div>
</div>

<%-- TODO 12. footer.jsp 를 include 하시오 --%>
???