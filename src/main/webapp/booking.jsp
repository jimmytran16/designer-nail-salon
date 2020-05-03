<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Bookings</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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


  

   

    <div class="slide-one-item home-slider owl-carousel">
   
      <div class="site-blocks-cover inner-page-cover" style="background-image: url(https://wallpaperplay.com/walls/full/d/a/7/188306.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
        <div class="container">
          <div class="row align-items-center justify-content-center text-center">

            <div class="col-md-8" data-aos="fade-up" data-aos-delay="400">
              <h2 class="text-white font-weight-light mb-2 display-1">Online Booking</h2>

              
            </div>
          </div>
        </div>
      </div>  

    </div>



    <div class="site-section bg-light">
      <div class="container">
        <div class="row">
          <div class="col-md-7 mb-5">

            

            <form method="POST" action="email" class="p-5 bg-white">
              <h2 class="mb-4 site-section-heading">Book Now</h2>

              <div class="row form-group">
                <div class="col-md-6 mb-3 mb-md-0">
                  <label class="text-black" for="fname">Name </label>
                  <input type="text" name="fname" id="fname" class="form-control" required="required" placeholder="Your Name" >
                </div>
                <div class="col-md-6">
                  <label class="text-black" for="lname">Phone</label>
                  <input type="tel" name="lname" id="lname" class="form-control" required="required" pattern="{1,20}" placeholder="xxx-xxx-xxxx" required>
                </div>
              </div>

              <div class="row form-group">
                <div class="col-md-6 mb-3 mb-md-0">
                  <label class="text-black" for="date">Date</label> 
                  <input type="text" name="date" id="date" class="form-control datepicker px-2" placeholder="Date of visit">
                </div>
                <div class="col-md-6">
                  <label class="text-black" for="email">Email</label> 
                  <input type="email" name="email" id="email" class="form-control" placeholder="Email" required>
                </div>
              </div>

              <div class="row form-group">
                <div class="col-md-12">
                  <label class="text-black" for="treatment">Service You Want</label> 
                  <select name="treatment" id="treatment" class="form-control">
                    <option value="Manicure">Manicure</option>
                    <option value="Pedicure">Pedicure</option>
                  </select>
                </div>
              </div>
				
              <div class="row form-group">
                <div class="col-md-12">
                  <label class="text-black" for="note">Notes</label> 
                  <textarea name="note" id="note" cols="30" rows="5" class="form-control" required placeholder="Service specificications.."></textarea>
                </div>
              </div>

              <div class="row form-group">
                <div class="col-md-12">
                  <input type="submit" value="Send" class="btn btn-primary py-2 px-4 text-white">
                </div>
                <%if(session.getAttribute("message")!=null){
                	session.getAttribute("message_color");
                	%>
                <b><span style="color:${message_color};padding-left:10px">${message}</span></b>
               
                <% session.setAttribute("message",null);
                session.setAttribute("message_color",null); }%>
              </div>

  
            </form>
          </div>
          <div class="col-md-5">
            
            <div class="p-4 mb-3 bg-white">
              <p class="mb-0 font-weight-bold">Address</p>
              <p class="mb-4"3>365A Main Street, Medford, Massachusetts, USA</p>

              <p class="mb-0 font-weight-bold">Phone</p>
              <p class="mb-4"><a href="#">+1 (339) 221-5234</a></p>

              <p class="mb-0 font-weight-bold">Email Address</p>
              <p class="mb-0"><a href="#">designersnailsalon@gmail.com</a></p>

            </div>
            
            <div class="p-4 mb-3 bg-white">
              <h3 class="h5 text-black mb-3"><strong>Maps and Location</strong></h3>
              <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d23561.781049562513!2d-71.12215832234246!3d42.42299584732971!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xb94ea7c3959a5e0!2sDesigner%20Nail%20Salon!5e0!3m2!1sen!2sus!4v1575167392317!5m2!1sen!2sus" width="400" height="250" frameborder="0" style="border:0;" allowfullscreen=""></iframe>
            </div>

          </div>
        </div>
      </div>
    </div>

    <footer class="site-footer">
      <div class="container">
        <div class="row">
          <div class="col-lg-4">
            <div class="mb-5">
              <h3 class="footer-heading mb-12">About <strong>Designer Nail Salon</strong></h3>
              <p>"Our mission at Designer Nail Salon is to provide a friendly, personalized service through a 
                team of highly skilled and creative professionals. Teamwork is our most valuable asset which ensures our
                 clients are always number one, and we strive to exceed your expectations."</p>
              </div>
          </div>
        </div>
        <div class="row pt-5 mt-5 text-center">
          <div class="col-md-12">
            <div class="mb-5">
              <a href="https://www.facebook.com/DesignerNailMedford" target="_blank" class="pl-0 pr-3"><span class="icon-facebook"></span></a>
              <a href="#" class="pl-3 pr-3"><span class="icon-instagram"></span></a>
              <a href="https://www.yelp.com/biz/designer-nail-salon-medford-2" target="_blank" class="pl-3 pr-3"><span class="icon-yelp"></span></a>
            </div>

            <p>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->

            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            </p>
          </div>
          
        </div>
      </div>
    </footer>
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
    
  </body>
</html>