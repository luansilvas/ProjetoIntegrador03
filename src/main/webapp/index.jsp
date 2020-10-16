<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title></title>

  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>




<nav>
    <div class="nav-wrapper grey lighten-1">
      <a href="#" data-activates="mobile-demo" class="button-collapse show-on-large"><i class="material-icons">code</i></a>
      <a href="#" class="brand-logo" target="_blank"><img src="icons\favicon.png" width="50px" height="50px" style="margin-top:5px"></a>
      <ul class="right hide">
        <li><a href="https://codepen.io/collection/nbBqgY/" target="_blank">Sass</a></li>
        <li><a href="https://codepen.io/collection/nbBqgY/" target="_blank">Components</a></li>
        <li><a href="https://codepen.io/collection/nbBqgY/" target="_blank">Javascript</a></li>
        <li><a href="https://codepen.io/collection/nbBqgY/" target="_blank">Mobile</a></li>
      </ul>
      
      <ul class="side-nav grey darken-2" id="mobile-demo">
        
        
        <li class="sidenav-header grey lighten-1">
          <div class="row">
            <div class="col s4">
                <img src="icons\profile.jpg" width="48px" height="48px" alt="" class="circle responsive-img valign profile-image">
            </div>



            <div>
                <a class="btn-flat dropdown-button waves-effect waves-light white-text" href="#" data-activates="profile-dropdown">Jay<i class="mdi-navigation-arrow-drop-down"></i></a>
                <ul id="profile-dropdown" class="dropdown-content">
                    <li><a href="#" ><i class="material-icons">person</i>Profile</a></li>
                    <li><a href="#" ><i class="material-icons">settings</i>Setting</a></li>
                    <li><a href="#" ><i class="material-icons">help</i>Help</a></li>
                    <li class="divider"></li>
                    <li><a href="#" ><i class="material-icons">lock</i>Lock</a></li>
                    <li><a href="#"><i class="material-icons">exit_to_app</i>Logout</a></li>
                </ul>
            </div>
          </div>
        </li>
        




       
  
        <li class="white"><a href="PaginaInicial.php"><i><img src="icons\store.png"></i>Loja</a> 
         
        <li class="white"><a href="#"><i><img src="icons\customer.png"></i>Clientes</a> 
        <li class="white"><a href="ListarProdutos"><i><img src="icons\product.png"></i>Produtos</a> 
        <li class="white"><a href="#"><i><img src="icons\employee.png"></i>Funcionários</a>
        <li class="white"><a href="#"><i><img src="icons\bar-chart.png"></i>Vendas</a> 
      <li class="white"><a href="#" ><i><img src="icons\bug.png"></i>Chamado<!--<span class="new badge right yellow darken-3" data-badge-caption="Em Breve"></span>--></a></li>    
      </ul>
      
    </div>
  </nav>


<div >
  



</div>




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

    $('.button-collapse').sideNav({
      menuWidth: 300, // Default is 300
      edge: 'left', // Choose the horizontal origin
      closeOnClick: false, // Closes side-nav on <a> clicks, useful for Angular/Meteor
      draggable: true // Choose whether you can drag to open on touch screens,
    }
  ); 
</script>

</body>
</html>