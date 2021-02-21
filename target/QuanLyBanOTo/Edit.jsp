<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 20/2/2021
  Time: 8:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Edit product</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/manager.css" rel="stylesheet" type="text/css"/>
<body>
<div class="">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="save">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Product</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>ID</label>
                        <input name="id" type="text" value="${detail.id}" class="form-control" readonly required>
                    </div> <div class="form-group">
                        <label>Name</label>
                        <input name="name" type="text" value="${detail.name}" class="form-control"  required>
                    </div>
                    <div class="form-group">
                        <label>Image</label>
                        <input name="image" type="text"  value="${detail.image}" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Price</label>
                        <input name="price" type="text" value="${detail.price}" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Ratio</label>
                        <%--                        <textarea name="title" class="form-control" required></textarea>--%>
                        <select name="ratio" class="form-select" aria-label="Default select example" >
                            <option value="1:18">1:18</option>
                            <option value="1:24">1:24</option>
                            <option value="1:18">1:64</option>
                            <option value="1:32">1:32</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea name="description" class="form-control" required>${detail.description}</textarea>
                    </div>
                    <div class="form-group">
                        <label>Category</label>
                        <select name="category" class="form-select" aria-label="Default select example">
                            <c:forEach items="${listCategory}" var="o">
                                <option value="${o.id}">${o.name}</option>
                            </c:forEach>
                        </select>
                    </div>

                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-info" value="Save">
                </div>
            </form>
        </div>
    </div>
</div>
<script src="js/manager.js" type="text/javascript"></script>
</body>
</html>
