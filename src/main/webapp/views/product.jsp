<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 29/04/2023
  Time: 10:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
    <link href="css/style.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <!-- TITLE : START -->
    <div class="page-header">
        <h1>Project 04 - Shopping Cart <small>ReactJS</small></h1>
    </div>
    <!-- TITLE : END -->

    <div class="row">
        <!-- LIST PRODUCT : START -->
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h1 class="panel-title">List Products</h1>
                </div>
                <div class="panel-body" id="list-product">
                    <!-- PRODUCT : START -->
                    <c:forEach items="${requestScope['list']}" var="list">
                        <div class="media product">
                            <div class="media-left">
                                <a href="#">
                                    <img class="media-object" src="${list.getImage()}"/>
                                </a>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading" name="productName">${list.getProductName()}</h4>
                                <p>${list.getTitle()}</p>
                                <input name="quantity" type="number" value="${list.getQuantity()}"/>
                                <a data-product="1"  name="action" value="CREATE"  href="<%=request.getContextPath()%>/product-servlet?action=CREATE&id=${list.getProductId()}" class="price" type="submit">
                                   <button  name="price">${list.getPrice()} USD</button>
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                    <!-- PRODUCT : END -->
                </div>
            </div>
        </div>
        <!-- LIST PRODUCT : END -->

        <!-- CART : START -->
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
            <div class="panel panel-danger">
                <div class="panel-heading">
                    <h1 class="panel-title">Your Cart</h1>
                </div>
                <div class="panel-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th width="4%">#</th>
                            <th>Pokemon</th>
                            <th width="15%">Price</th>
                            <th width="4%">Quantity</th>
                            <th width="20%">Subtotal</th>
                            <th width="25%">Action</th>
                        </tr>
                        </thead>
                        <tbody id="my-cart-body">
                        <!-- CART BODY -->
                        <c:forEach items="${requestScope['productCreate']}" var="lis" varStatus="status">
                            <tr>
                                <th scope="row">${status.count}</th>
                                <td name="cartName">${lis.getProductName()}</td>
                                <td name="cartPrice">${lis.getPrice()} USD</td>
                                <td><input name="cart-item-quantity-1" type="number" value="1" min="1">${lis.getQuantity()}</td>
                                <td><strong>${(lis.getQuantity()*lis.getPrice())} USD</strong></td>
                                <td>
                                    <a class="label label-info update-cart-item" href="#" data-product="">Update</a>
                                    <a class="label label-danger delete-cart-item" href="#"
                                       data-product="">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                        <tfoot id="my-cart-footer">
                        <!-- CART FOOTER -->
                        <tr>
                            <th colspan="6">Empty product in your cart</th>
                        </tr>
                        <tr>
                            <td colspan="4">There are <b>1</b> items in your shopping cart.</td>
                            <td colspan="2" class="total-price text-left">12 USD</td>
                        </tr>
                        </tfoot>
                    </table>

                </div>
            </div>
            <div class="alert alert-success" role="alert" id="mnotification">Updated <b>successfull</b></div>
        </div>
        <!-- CART : END -->
    </div>
</div>
<script src="js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
