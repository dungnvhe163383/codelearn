<%-- 
    Document   : SignIn
    Created on : Mar 18, 2023, 12:34:44 PM
    Author     : okanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Sign In</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

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

        <!-- =======================================================
        * Template Name: Moderna - v4.11.0
        * Template URL: https://bootstrapmade.com/free-bootstrap-template-corporate-moderna/
        * Author: BootstrapMade.com
        * License: https://bootstrapmade.com/license/
        ======================================================== -->
    </head>
    <body>    
        <jsp:include page="guest/Header.jsp"></jsp:include>
        <main id="main">
         <section  class="vh-100 mt-5">
            <div class="container-fluid h-custom">
                <div class="row d-flex justify-content-start align-items-center h-100">
                     <!--Login part--> 
                    <div class="col-md-6 col-lg-6 col-xl-4 offset-xl-1">
                        
                        <h2 class="text-center text-primary fw-bold">Sign In</h2>
                        <p class="text-success my-4 fw-bold">
                            ${warning}
                        </p>
                        <form class="" action="SignIn" method="post">
                             <!--Username input--> 
                            <div class="mb-4">
                                <label class="form-label">Username</label>
                                <input name="username" type="text" class="form-control form-control-lg">   
                            </div>
                             <!--Password input--> 
                            <div class="mb-3">
                                <label class="form-label">Password</label>
                                <input name="password" type="password" class="form-control form-control-lg" >
                            </div>
                            <div class="d-flex justify-content-between align-items-center">
                                 <!--Checkbox--> 
                                <div class="form-check mb-0">
                                    <input name="remember" value="1" class="form-check-input me-2" type="checkbox">
                                    <label class="form-check-label">
                                        Remember me!
                                    </label>
                                </div>
                                <a href="ResetPass.jsp" class="text text-warning">Forgot password?</a>
                            </div>
                            <div class="text-center text-lg-start mt-4 pt-2 mb-4">
                                <button type="submit" class="btn btn-outline-primary btn-lg"style="padding-left: 2.5rem; padding-right: 2.5rem;">
                                    SIGN IN
                                </button>
                            </div>    
                            You don't have account ?<a href="SignUp.jsp" class="text text-primary">Register here!</a> 
                        </form>
                        <p class="text-danger my-4 fw-bold">
                            ${error}
                        </p>
                    </div>
                </div>
            </div>           
        </section>
        </main>
        <jsp:include page="guest/Footer.jsp"></jsp:include>

         <!--Vendor JS Files--> 
        <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
        <script src="assets/vendor/aos/aos.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
        <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
        <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
        <script src="assets/vendor/waypoints/noframework.waypoints.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>

         <!--Template Main JS File--> 
        <script src="assets/js/main.js"></script>
    </body>
</html>

