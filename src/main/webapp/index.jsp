<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="menu.jsp" %>
    <head>
        <title></title>

        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    </head>
    <body>






        <!-- Gitter Chat Link -->
        <div class="fixed-action-btn"><a class="btn-floating btn-large red" href="#" target="_blank"><i class="large material-icons">chat</i></a></div>


        <!-- Sliders -->

        <div class="carousel carousel-slider center">
            <div class="carousel-fixed-item center">
                <a class="btn waves-effect white grey-text darken-text-2">button</a>
            </div>
            <div class="carousel-item red white-text" href="#one!">
                <h2>First Panel</h2>
                <p class="white-text">This is your first panel</p>
            </div>
            <div class="carousel-item amber white-text" href="#two!">
                <h2>Second Panel</h2>
                <p class="white-text">This is your second panel</p>
            </div>
            <div class="carousel-item green white-text" href="#three!">
                <h2>Third Panel</h2>
                <p class="white-text">This is your third panel</p>
            </div>
            <div class="carousel-item blue white-text" href="#four!">
                <h2>Fourth Panel</h2>
                <p class="white-text">This is your fourth panel</p>
            </div>
        </div>






        <style>
            .botao{
                padding: 0px;

            }

            img{
                width: 160%;

            }
            .side-nav li
            a {
                padding: 0 16px;

            }




            /*.sidenav-header {
            background: url("../images/user-bg.jpg") no-repeat center center;
            background-size: cover;
            padding: 15px 0 0 15px;
              
            }*/

            .row {
                margin-bottom: 0;

            }
            .social-icons {
            }
            a {
                opacity: 1;
                &:hover {
                    background-color:inherit;
                    opacity: 1;
                }
            }





        </style>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>


        <script>
            autoplay()
            function autoplay() {
                $('.carousel').carousel('next');
                setTimeout(autoplay, 4500);
            }

            $('.carousel.carousel-slider').carousel({
                dist: 0,
                padding: 0,
                fullWidth: true,
                indicators: true,
                duration: 100,
            });


        </script>

    </body>
</html>