<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 16/2/2021
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">
            <c:forEach var="o" items="${listCategory}">
                <li class="list-group-item text-white ${tag==o.id?"active":""}"><a href="brand?id=${o.id}"><c:out value="${o.name}"></c:out></a></li>
            </c:forEach>

        </ul>
    </div>
    <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase">Newest product</div>
        <div class="card-body">
            <img class="img-fluid" src="${newestProduct.image}" />
<%--            <h5 class="card-title">${newestProduct.des}</h5>--%>
            <p class="card-text" ><a href="detail?id=${newestProduct.id}">${newestProduct.name}</a></p>
            <p class="bloc_left_price">${newestProduct.price} VND</p>
        </div>
    </div>
</div>