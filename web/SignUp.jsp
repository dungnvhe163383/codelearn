<%-- 
    Document   : HomePage
    Created on : Jan 28, 2023, 5:25:10 PM
    Author     : okanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <title>HomePage</title>

        <!-- Favicons -->
        <link href="assets/img/favicon.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
        
        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Roboto:300,300i,400,400i,500,500i,700,700i&display=swap" rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
        <link href="assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">
    </head>
    <body>    
        <jsp:include page="guest/Header.jsp"></jsp:include>
            <!-- ======= Hero Section ======= -->
            <section class="vh-100 mt-5">
                <div class="container-fluid h-custom">
                    <div class="row d-flex justify-content-start align-items-center h-100">
                        <!-- Login part -->
                        <div class="col-md-6 col-lg-6 col-xl-4 offset-xl-1" style="height: 600px">
                            <h2 class="text-center text-primary fw-bold">Sign Up</h2> 
                        <c:if test="${done !=null}">
                            <p class="text-success">
                            ${done}
                        </p>
                        </c:if>
                            <c:if test="${error !=null}">
                        <p class="text-danger">
                            ${error}
                        </p>
                        </c:if>
                        <form class="" action="SignUp" method="post">
                            <!-- Username input -->
                            <div class="form-outline mb-4">
                                <label class="form-label">Username</label>
                                <input name="username" type="text" class="form-control form-control-lg">   
                            </div>
                            <!-- Password input -->
                            <div class="form-outline mb-3">
                                <label class="form-label">Password</label>
                                <input name="password" type="password" class="form-control form-control-lg">
                            </div>

                            <div class="form-outline mb-3">
                                <label class="form-label">Confirm Password</label>
                                <input name="confirmpassword" type="password" class="form-control form-control-lg">
                            </div>

                            <div class="form-outline mb-3">
                                <label class="form-label">Email</label>
                                <input name="email" type="text" class="form-control form-control-lg" >
                            </div>
                            <div class="form-outline mb-3">
                                <label class="form-label">Role:</label>
                                <select name="role">
                                    <c:forEach items="${sessionScope.listrole}" var="o">
                                        <option value="${o.id}">${o.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="text-center text-lg-start mt-4 pt-2 mb-4">
                                <button type="submit" class="btn btn-outline-primary btn-lg"style="padding-left: 2.5rem; padding-right: 2.5rem;">
                                    Sign Up
                                </button>
                            </div>    
                        </form>
                    </div>
                </div>
            </div>           
        </section>
        <jsp:include page="guest/Footer.jsp"></jsp:include>


        <!-- Vendor JS Files -->
        <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
        <script src="assets/vendor/aos/aos.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
        <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
        <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
        <script src="assets/vendor/waypoints/noframework.waypoints.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>
    </body>
</html>
