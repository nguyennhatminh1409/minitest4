<%--
  Created by IntelliJ IDEA.
  User: THINKPAD
  Date: 03/05/2024
  Time: 3:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Present Management Web</title>
    <!--  Ap dug Bootstrap de CSS  -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="text-center">
        <h1>Present Management</h1>
        <c:if test='${not empty requestScope["message"]}'>
            <div class="alert alert-info" role="alert">${requestScope["message"]}</div>
        </c:if>
        <h2><a href="present?action=present" class="btn btn-primary">List All Present</a></h2>
    </div>
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form method="post">
                <div class="card">
                    <div class="card-header">
                        <h2 class="text-center">Add New Present</h2>
                    </div>
                    <div class="card-body">
                        <div class="form-group row">
                            <label for="code" class="col-sm-3 col-form-label">Code:</label>
                            <div class="col-sm-9">
                                <input type="text" name="code" id="code" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="name" class="col-sm-3 col-form-label">Name:</label>
                            <div class="col-sm-9">
                                <input type="text" name="name" id="name" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="price" class="col-sm-3 col-form-label">Price:</label>
                            <div class="col-sm-9">
                                <input type="text" name="price" id="price" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="ship" class="col-sm-3 col-form-label">Ship:</label>
                            <div class="col-sm-9">
                                <input type="text" name="ship" id="ship" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="img" class="col-sm-3 col-form-label">Img:</label>
                            <div class="col-sm-9">
                                <input type="text" name="img" id="img" class="form-control" />
                            </div>
                        </div>
                    </div>
                    <div class="card-footer text-center">
                        <button type="submit" class="btn btn-primary">Save</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
        integrity="sha384-D6zGgvlR4LkV4MgO9K3FHAia5/ThCgNfldFfbdRv5GAqQ5gy2CxWQV84Iw3DfocD"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shCv+aL2rGfFX5Sx6x/Z3+76al1pwFt+F5Jqh"
        crossorigin="anonymous"></script>
</body>
</html>
