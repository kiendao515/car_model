<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 16/2/2021
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="home">Car model</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault" >
            <ul class="navbar-nav m-auto">
                <c:if test="${sessionScope.acc.isAdmin==1}">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Manager Account</a>
                    </li>
                </c:if>
                 <c:if test="${sessionScope.acc.isSeller==1}">
                     <li class="nav-item">
                         <a class="nav-link" href="manager">Manager Product</a>
                     </li>
                 </c:if>

                 <c:if test="${sessionScope.acc!=null}">
                     <li class="nav-item">
                         <a class="nav-link" href="">Hello ${sessionScope.acc.username}</a>
                     </li>

                     <li class="nav-item" >
                         <a class="nav-link" href="logout">Logout</a>
                     </li>
                 </c:if>
                 <c:if test="${sessionScope.acc==null}">
                     <li class="nav-item">
                         <a class="nav-link" href="Loginn.jsp">Login</a>
                     </li>
                 </c:if>
            </ul>

            <form action="search" method="get" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input name="txt" value="${abc}" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <a class="btn btn-success btn-sm ml-3" href="cart">
                    <i class="fa fa-shopping-cart"></i> Cart
                    <span class="badge badge-light">1</span>
                </a>
            </form>
        </div>
    </div>
</nav>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">SUPER CAR DEALER</h1>
        <p class="lead text-muted mb-0">Sieu xe trong tam tay</p>
    </div>
</section>
<!--end of menu-->
