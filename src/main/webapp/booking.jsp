<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <title>Bookings</title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="shortcut icon" type="image/jpg" href="images/favicon_img.jpg">
      <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,700,900|Display+Playfair:200,300,400,700">
      <link rel="stylesheet" href="fonts/icomoon/style.css">
      <link rel="stylesheet" href="css/bootstrap.min.css">
      <link rel="stylesheet" href="css/my.css">
      <link rel="stylesheet" href="css/magnific-popup.css">
      <link rel="stylesheet" href="css/jquery-ui.css">
      <link rel="stylesheet" href="css/owl.carousel.min.css">
      <link rel="stylesheet" href="css/owl.theme.default.min.css">
      <link rel="stylesheet" href="css/bootstrap-datepicker.css">
      <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mediaelement@4.2.7/build/mediaelementplayer.min.css">
      <link rel="stylesheet" href="css/aos.css">
      <link rel="stylesheet" href="css/style.css">
      <style>
         @media (max-width: 767px) {
         .logo_img{
         margin-left: 0!important;
         }
         .message-container{
         padding:unset;
         }
         }
         iframe {
         width:100%!important;
         }
         @media (min-width: 768px){
         .message-container{
         padding:0px 20px;
         margin-top:20px;
         }
         }
      </style>
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
         </div>
         <header class="site-navbar py-1" role="banner">
            <div class="navstick container-fluid">
               <div class="row align-items-center">
                  <div class="col-6 col-xl-2" data-aos="fade-down">
                     <h1 class="mb-0"><a href="index.html" class="text-black h2 mb-0"><img class="logo_img" height="42px" width="262px" src="images/imageedit_13_3337259586.png" alt=""></a></h1>
                  </div>
                  <div class="col-10 col-md-8 d-none d-xl-block" data-aos="fade-down">
                     <nav class="site-navigation position-relative text-right text-lg-center" role="navigation">
                        <ul class="site-menu js-clone-nav mx-auto d-none d-lg-block">
                           <li>
                              <a href="index.html">Home</a>
                           </li>
                           <li><a href="#">Book Online</a></li>
                           <li><a href="services">Services</a></li>
                           <li><a href="services">Reviews</a></li>
                        </ul>
                     </nav>
                  </div>
                  <div class="col-6 col-xl-2 text-right" data-aos="fade-down">
                     <div class="d-none d-xl-inline-block">
                        <ul class="site-menu js-clone-nav ml-auto list-unstyled d-flex text-right mb-0" data-class="social">
                           <li>
                              <a href="https://www.facebook.com/DesignerNailMedford" class="pl-0 pr-3 text-black"><span class="icon-facebook"></span></a>
                           </li>
                           <li>
                              <a href="https://www.yelp.com/biz/designer-nail-salon-medford-2" class="pl-3 pr-3 text-black"><span class="icon-yelp"></span></a>
                           </li>
                           <li>
                              <a href="#" class="pl-3 pr-3 text-black"><span class="icon-instagram"></span></a>
                           </li>
                        </ul>
                     </div>
                     <div class="d-inline-block d-xl-none ml-md-0 mr-auto py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle text-black"><span class="icon-menu h3"></span></a></div>
                  </div>
               </div>
            </div>
         </header>
      <%-- <div style="height:100vh; margin-top:20px;padding:10px;">
     		<iframe style="height:100%;" src="https://dns-booking-a546b019e183.herokuapp.com"></iframe>
       	</div> --%> 
      </div>
      <script src="js/jquery-3.3.1.min.js"></script>
      <script src="js/jquery-migrate-3.0.1.min.js"></script>
      <script src="js/jquery-ui.js"></script>
      <script src="js/popper.min.js"></script>
      <script src="js/bootstrap.min.js"></script>
      <script src="js/owl.carousel.min.js"></script>
      <script src="js/jquery.stellar.min.js"></script>
      <script src="js/jquery.countdown.min.js"></script>
      <script src="js/jquery.magnific-popup.min.js"></script>
      <script src="js/bootstrap-datepicker.min.js"></script>
      <script src="js/aos.js"></script>
      <script src="js/main.js"></script>
      <script type="application/javascript">
         console.log('yooooo');
         var confirmElemenet = document.getElementById('confirmMessage');
         var topPos = confirmElemenet.offsetTop;
      </script>
   </body>
</html>