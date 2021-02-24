
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <style>

        li {
            padding: 0px 0px 10px 10px;
        }
    </style>
</head>
<body>
<jsp:include page="Menu.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="Home.jsp">Home</a></li>
                    <li class="breadcrumb-item"><a href="#">Category</a></li>
                    <li class="breadcrumb-item active" aria-current="#">Sub-category</li>
                </ol>
            </nav>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <jsp:include page="Left.jsp"></jsp:include>

        <div class="col-sm-9">
            <div class="row">
                <c:forEach items="${listProduct}" var="listProduct">
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="card">
                            <img class="card-img-top" src="${listProduct.image}" alt="Card image cap">
                            <div class="card-body">
                                <h4 class="card-title show_txt"><a href="detail?id=${listProduct.id}" title="View Product">${listProduct.name}</a></h4>
                                <p class="card-text show_txt"><c:out value="Tỉ lệ: ${listProduct.category}"></c:out></p>
                                <div class="row">
                                    <div class="col">
                                        <p class="btn btn-danger btn-block">${listProduct.price} VND</p>
                                    </div>
                                    <div class="col">
                                        <a href="addtocart?id=${listProduct.id}" class="btn btn-success btn-block">Add to cart</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

    </div>
        <div class="row">
           <div class="col-sm-9"></div>
            <div class="col-sm-3">
                <nav>
                    <ul class="pagination">
                        <c:forEach begin="1" end="${count}" var="i">
                            <li class="page-item"><a href="home?id=${i}" class="page-link">${i}</a></li>
                        </c:forEach>
                    </ul>
                </nav>
            </div>
        </div>
</div>

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>

