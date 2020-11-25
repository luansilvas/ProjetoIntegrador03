<%-- 
    Document   : login
    Created on : 24/11/2020, 09:37:31
    Author     : luans
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <title>TADES Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 

        <link rel="stylesheet" type="text/css" href="style.css" />
        <script type="text/javascript" src="js/modernizr.custom.86080.js"></script>

    </head>
    <body id="page">
        <c:if test="${not empty param.erro}">
            <script>
                function erro() {
                    alert("Verifica a senha ou login de acesso!");
                }
                erro();
            </script>

        </c:if> 





        <div class="container">
            <header>
                <div class="container" style="margin-top: 10%;margin-right: -40%;">
                    <a class="links" id="paracadastro"></a>
                    <a class="links" id="paralogin"></a>

                    <div class="content">      
                        <!--FORMULÁRIO DE LOGIN-->
                        <div id="login">
                            <form method="post" action="LoginServlet"> 
                                <h1>Login</h1> 
                                <p> 
                                    <label for="nome_login">login</label>
                                    <input id="nome_login" name="login" required="required" type="text" placeholder=""/>
                                </p>

                                <p> 
                                    <label for="email_login">senha</label>
                                    <input id="email_login" name="senha" required="required" type="password" placeholder="" /> 
                                </p>



                                <p> 
                                    <input type="submit" value="Logar" /> 
                                </p>
                                <!--
                               <p class="link">
                     
                                 <a href="#paracadastro">Esqueci minha senha</a>
                               </p>
                             </form>
                           </div>
                      
                                <!--FORMULÁRIO DE CADASTRO-->
                                <!--
                                <div id="cadastro">
                                  <form method="post" action=""> 
                                    <h1>Recuperar senha</h1> 
                                     
                                    <p> 
                                      <label for="nome_cad">Sua credencial</label>
                                      <input id="nome_cad" name="nome_cad" required="required" type="text" placeholder="" />
                                    </p>
                                     
                                    <p> 
                                      <label for="email_cad">Seu e-mail</label>
                                      <input id="email_cad" name="email_cad" required="required" type="email" placeholder=""/> 
                                    </p>
                                     
                                    <p> 
                                      <label for="senha_cad">Seu telefone</label>
                                      <input id="senha_cad" name="senha_cad" required="required" type="password" placeholder=""/>
                                    </p>
                                     
                                    <p> 
                                      <input type="submit" value="Solicitar"/> 
                                    </p>
                                     
                                    <p class="link">  
                          
                                      <a href="#paralogin">Logar</a>
                                    </p>
                                  </form>
                                </div>-->
                        </div>
                    </div>  


            </header>
        </div>





        <style>
            body{
                background-image: url('1.png');
                background-repeat: no-repeat;
                background-size: 50%;
            }

            /* CSS reset */
            *, *:before, *:after { 
                margin:0;
                padding:0;
                font-family: Arial,sans-serif;
            }

            body{
                margin:10px;
            }

            a{
                text-decoration: none;
            }

            /* esconde as ancoras da tela */
            a.links{
                display: none;
            }

            /* content que contem os formulários */
            .content{
                width: 500px;
                margin: 0px auto;
                position: relative;   
            }

            /* formatando o cabeçalho dos formulários */
            h1{
                font-size: 48px;
                color: #066a75;
                padding: 10px 0;
                font-family: Arial,sans-serif;
                font-weight: bold;
                text-align: center;
                padding-bottom: 30px;
            }
            h1:after{
                content: ' ';
                display: block;
                width: 100%;
                height: 2px;
                margin-top: 10px;
                background: -webkit-linear-gradient(left, rgba(147,184,189,0) 0%,rgba(147,184,189,0.8) 20%,rgba(147,184,189,1) 53%,rgba(147,184,189,0.8) 79%,rgba(147,184,189,0) 100%); 
                background: linear-gradient(left, rgba(147,184,189,0) 0%,rgba(147,184,189,0.8) 20%,rgba(147,184,189,1) 53%,rgba(147,184,189,0.8) 79%,rgba(147,184,189,0) 100%); 
            }

            p{
                margin-bottom:15px;
            }
            p:first-child{
                margin: 0px;
            }
            label{
                color: #405c60;
                position: relative;
            }

            /**** advanced input styling ****/
            /* placeholder */
            ::-webkit-input-placeholder  {
                color: #bebcbc; 
                font-style: italic;
            }
            input:-moz-placeholder,
            textarea:-moz-placeholder{
                color: #bebcbc;
                font-style: italic;
            } 
            input {
                outline: none;
            }

            input:not([type="checkbox"]){
                width: 95%;
                margin-top: 4px;
                padding: 10px;    
                border: 1px solid #b2b2b2;

                -webkit-border-radius: 3px;
                border-radius: 3px;

                -webkit-box-shadow: 0px 1px 4px 0px rgba(168, 168, 168, 0.6) inset;
                box-shadow: 0px 1px 4px 0px rgba(168, 168, 168, 0.6) inset;

                -webkit-transition: all 0.2s linear;
                transition: all 0.2s linear;
            }

            /*estilo do botão submit */
            input[type="submit"]{
                width: 100%!important;
                cursor: pointer;  
                background: #3d9db3;
                padding: 8px 5px;
                color: #fff;
                font-size: 20px;  
                border: 1px solid #fff;   
                margin-bottom: 10px;  
                text-shadow: 0 1px 1px #333;

                -webkit-border-radius: 5px;
                border-radius: 5px;

                transition: all 0.2s linear;
            }
            input[type="submit"]:hover{
                background: #4ab3c6;
            }

            /*marcando os links para mudar de um formulário para outro */
            .link{
                position: absolute;
                background: #e1eaeb;
                color: #7f7c7c;
                left: 0px;
                height: 20px;
                width: 440px;
                padding: 17px 30px 20px 30px;
                font-size: 16px;
                text-align: right;
                border-top: 1px solid #dbe5e8;

                -webkit-border-radius: 0 0  5px 5px;
                border-radius: 0 0  5px 5px;
            }
            .link a {
                font-weight: bold;
                background: #f7f8f1;
                padding: 6px;
                color: rgb(29, 162, 193);
                margin-left: 10px;
                border: 1px solid #cbd518;

                -webkit-border-radius: 4px;
                border-radius: 4px;  

                -webkit-transition: all 0.4s linear;
                transition: all 0.4s  linear;
            }
            .link a:hover {
                color: #39bfd7;
                background: #f7f7f7;
                border: 1px solid #4ab3c6;
            }

            /* estilos para para ambos os formulários */
            #cadastro, 
            #login{
                position: absolute;
                top: 0px;
                width: 88%;   
                padding: 18px 6% 60px 6%;
                margin: 0 0 35px 0;
                background: rgb(247, 247, 247);
                border: 1px solid rgba(147, 184, 189,0.8);

                -webkit-box-shadow: 5px;
                border-radius: 5px;

                -webkit-animation-duration: 0.5s;
                -webkit-animation-timing-function: ease;
                -webkit-animation-fill-mode: both;

                animation-duration: 0.5s;
                animation-timing-function: ease;
                animation-fill-mode: both;
            }

            #paracadastro:target ~ .content #cadastro,
            #paralogin:target ~ .content #login{
                z-index: 2;
                -webkit-animation-name: fadeInLeft;
                animation-name: fadeInLeft;

                -webkit-animation-delay: .1s;
                animation-delay: .1s;
            }
            #registro:target ~ .content #login,
            #paralogin:target ~ .content #cadastro{
                -webkit-animation-name: fadeOutLeft;
                animation-name: fadeOutLeft;
            }

            /*fadeInLeft*/
            @-webkit-keyframes fadeInLeft {
                0% {
                    opacity: 0;
                    -webkit-transform: translateX(-20px);
                }
                100% {
                    opacity: 1;
                    -webkit-transform: translateX(0);
                }
            }

            @keyframes fadeInLeft {
                0% {
                    opacity: 0;
                    transform: translateX(-20px);
                }
                100% {
                    opacity: 1;
                    transform: translateX(0);
                }
            }

            /*fadeOutLeft*/
            @-webkit-keyframes fadeOutLeft {
                0% {
                    opacity: 1;
                    -webkit-transform: translateX(0);
                }
                100% {
                    opacity: 0;
                    -webkit-transform: translateX(-20px);
                }
            }

            @keyframes fadeOutLeft {
                0% {
                    opacity: 1;
                    transform: translateX(0);
                }
                100% {
                    opacity: 0;
                    transform: translateX(-20px);
                }
            }
        </style>
    </body>
</html>
