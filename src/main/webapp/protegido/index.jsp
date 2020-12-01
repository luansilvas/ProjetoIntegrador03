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






        <!-- Sliders -->

        <div class="carousel carousel-slider center">

            <div class="carousel-item white-text" href="#one!" style="background-image: url('icons/tades_capa.png');background-position: center center;background-repeat: no-repeat;background-size: cover;">
                <h2><b>Seja bem-vindo a TADES!</b></h2>
                <h5 class="white-text">A maior loja de móveis corporativos do país!</h5>
            </div>
            <div class="carousel-item black-text" href="#two!"  style="background-image: url('icons/cadeiras.gif');background-position: center center;background-repeat: no-repeat;background-size: cover;">
                <h2><b>A melhor opção com as melhores opções</b></h2>
                <p class="black-text">Teste produtos de qualidade inigualável</p>
            </div>
            <div class="carousel-item white-text" href="#three!" style="background-image: url('icons/estante.gif');background-position: center center;background-repeat: no-repeat;background-size: cover;">
                <h2><b>A sua melhor escolha para fazer o homeoffice</b></h2>
                <h5 class="white-text">Propostas inteligentes sem perder o conforto</h5>
            </div>
            <div class="carousel-item white-text" href="#four!" style="background-image: url('icons/promo.gif');background-position: center center;background-repeat: no-repeat;background-size: cover;">
                <h2>Os valores não são baixos e a qualidade também não</h2>
                <h5 class="white-text">Aceitamos negociações e parcelamentos!</h5>
            </div>
        </div>
        <article style="margin:5%;">
            <h2>TADES</h2>
            <p>A TADES ltda. atua há bastante tempo no ramo de móveis planejados e modulares para escritórios. Com o crescimento das vendas na época de pandemia, devido ao home office, nos tornamos a maior loja de móveis home corp do país.</p>

            <h5>Onde estamos em 2020</h5>
            <img src="icons\locais.jpg" style="width:70%;margin-left: 10%">


            </div>


        </article>
        <footer>
            <p style="font-size:8px;margin-left: 5%">®MoovOffice <br> Gifs disponíveis em giphy.com</p>
        </footer>

                
            





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
            p{
                font-size: 17px;    

            }
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