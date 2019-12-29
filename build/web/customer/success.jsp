<%-- 
    Document   : success
    Created on : 23-Aug-2019, 21:39:24
    Author     : hieu
--%>

<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Suite &mdash; Colorlib Website Template</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700|Work+Sans:300,400,700" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/icomoon/style.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/magnific-popup.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.carousel.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mediaelement@4.2.7/build/mediaelementplayer.min.css">



        <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/flaticon/font/flaticon.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/aos.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

    </head>
    <body>

        <div class="site-wrap">

            <div class="site-mobile-menu">
                <div class="site-mobile-menu-header">
                    <div class="site-mobile-menu-close mt-3">
                        <span class="icon-close2 js-menu-toggle"></span>
                    </div>
                </div>
                <div class="site-mobile-menu-body"></div>
            </div> <!-- .site-mobile-menu -->


            <div class="site-navbar-wrap js-site-navbar bg-white">

                <div class="container">
                    <div class="site-navbar bg-light">
                        <div class="py-1">
                            <div class="row align-items-center">
                                <div class="col-2">
                                    <h2 class="mb-0 site-logo"><a href="/HieuHomeStay/customer/index.jsp">HieuOtera</a></h2>
                                </div>
                                <div class="col-10">
                                    <nav class="site-navigation text-right" role="navigation">
                                        <div class="container">

                                            <div class="d-inline-block d-lg-none  ml-md-0 mr-auto py-3"><a href="#" class="site-menu-toggle js-menu-toggle"><span class="icon-menu h3"></span></a></div>
                                            <ul class="site-menu js-clone-nav d-none d-lg-block">
                                                <li>
                                                    <a href="/HieuHomeStay/customer/index.jsp">Home</a>
                                                </li>
                                                <li>
                                                    <a href="/HieuHomeStay/CustomerLoadRoomController">Rooms</a>
                                                </li>
                                                <li><a href="/HieuHomeStay/CustomerLoadServiceController">Service</a></li>
                                                <li><a href="/HieuHomeStay/CustomerLoadProductController">Product</a></li>
                                                <li class="active"><a href="/HieuHomeStay/CustomerLoadInfoController">Information</a></li>
                                            </ul>
                                        </div>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="site-blocks-cover overlay" style="background-image: url(${pageContext.request.contextPath}/haha/nhanpham/chutieu1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
                <div class="container">
                    <div class="row align-items-center justify-content-center">
                        <div class="col-md-7 text-center" data-aos="fade">
                            <span class="caption mb-3">Your Information</span>
                            <h1 class="mb-4">Member</h1>
                        </div>
                    </div>
                </div>
            </div>  


            <div class="site-section site-section-sm">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="p-4 mb-3 bg-white">
                                <h3 class="h5 text-black mb-3">All Information</h3>
                                <p class="mb-0 font-weight-bold">Information</p>
                                <p class="mb-4"><a href="/HieuHomeStay/CustomerLoadInfoController">My Info</a></p>

                                <p class="mb-0 font-weight-bold">Cart</p>
                                <p class="mb-4"><a href="/HieuHomeStay/CustomerMyCartController">My Cart(Room & Otera)</a></p>

                                <p class="mb-0 font-weight-bold">Bill</p>
                                <p class="mb-4"><a href="/HieuHomeStay/CustomerMyBillController">My bill</a></p>

                                <p class="mb-0 font-weight-bold">Bill (Coin)</p>
                                <p class="mb-4"><a href="/HieuHomeStay/CustomerMyBillController">My bill (Coin)</a></p>

                                <p class="mb-0 font-weight-bold">Level & Coin</p>
                                <p class="mb-0"><a href="/HieuHomeStay/CustomerMyLevelController">My Level & Coin</a></p>

                                <p class="mb-0 font-weight-bold">Log Out</p>
                                <p class="mb-0"><a href="/HieuHomeStay/LogoutController">Log Out</a></p>

                            </div>


                        </div>
                        <div class="col-md-12 col-lg-8 mb-5">
                            <h3 class="h5 text-black mb-3">Notification</h3>
                                <div class="row form-group">
                                    <div class="col-md-12 mb-3 mb-md-0">
                                        <label class="font-weight-bold">Check Out Success</label></br>
                                        <label class="font-weight-bold">Please Xuong le tan tra tien</label></br>                                       
                                    </div>
                                </div>
                        </div>
                    </div>
                </div>




                <footer class="site-footer">
                    <div class="container">


                        <div class="row">
                            <div class="col-md-4">
                                <h3 class="footer-heading mb-4 text-white">About</h3>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellat quos rem ullam, placeat amet.</p>
                                <p><a href="#" class="btn btn-primary pill text-white px-4">Read More</a></p>
                            </div>
                            <div class="col-md-6">
                                <div class="row">
                                    <div class="col-md-6">
                                        <h3 class="footer-heading mb-4 text-white">Quick Menu</h3>
                                        <ul class="list-unstyled">
                                            <li><a href="#">About</a></li>
                                            <li><a href="#">Services</a></li>
                                            <li><a href="#">Approach</a></li>
                                            <li><a href="#">Sustainability</a></li>
                                            <li><a href="#">News</a></li>
                                            <li><a href="#">Careers</a></li>
                                        </ul>
                                    </div>
                                    <div class="col-md-6">
                                        <h3 class="footer-heading mb-4 text-white">Ministries</h3>
                                        <ul class="list-unstyled">
                                            <li><a href="#">Children</a></li>
                                            <li><a href="#">Women</a></li>
                                            <li><a href="#">Bible Study</a></li>
                                            <li><a href="#">Church</a></li>
                                            <li><a href="#">Missionaries</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>


                            <div class="col-md-2">
                                <div class="col-md-12"><h3 class="footer-heading mb-4 text-white">Social Icons</h3></div>
                                <div class="col-md-12">
                                    <p>
                                        <a href="#" class="pb-2 pr-2 pl-0"><span class="icon-facebook"></span></a>
                                        <a href="#" class="p-2"><span class="icon-twitter"></span></a>
                                        <a href="#" class="p-2"><span class="icon-instagram"></span></a>
                                        <a href="#" class="p-2"><span class="icon-vimeo"></span></a>

                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="row pt-5 mt-5 text-center">
                            <div class="col-md-12">
                                <p>
                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                    Copyright &copy; <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script>document.write(new Date().getFullYear());</script> All Rights Reserved | This template is made with <i class="icon-heart text-primary" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" >Colorlib</a>
                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                </p>
                            </div>

                        </div>
                    </div>
                </footer>
            </div>

            <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/jquery-migrate-3.0.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
            <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/jquery.stellar.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/jquery.countdown.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/jquery.magnific-popup.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/aos.js"></script>


            <script src="${pageContext.request.contextPath}/js/mediaelement-and-player.min.js"></script>

            <script src="${pageContext.request.contextPath}/js/main.js"></script>


            <script>
                                        document.addEventListener('DOMContentLoaded', function () {
                                            var mediaElements = document.querySelectorAll('video, audio'), total = mediaElements.length;

                                            for (var i = 0; i < total; i++) {
                                                new MediaElementPlayer(mediaElements[i], {
                                                    pluginPath: 'https://cdn.jsdelivr.net/npm/mediaelement@4.2.7/build/',
                                                    shimScriptAccess: 'always',
                                                    success: function () {
                                                        var target = document.body.querySelectorAll('.player'), targetTotal = target.length;
                                                        for (var j = 0; j < targetTotal; j++) {
                                                            target[j].style.visibility = 'visible';
                                                        }
                                                    }
                                                });
                                            }
                                        });
            </script>

    </body>
</html>