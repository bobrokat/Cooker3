<!doctype html>
<html>
<head>
    <meta charset="utf-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <title>Cooker</title>
    <meta name="description" content="">
    <meta name="author" content="">

<#--<link rel="stylesheet" href="../css/superfish.css">-->

    <link rel="stylesheet" href="../css/style.css?v=2">


    <!-- All JavaScript at the bottom, except for Modernizr which enables HTML5 elements & feature detects -->
    <script src="../js/libs/modernizr-1.7.min.js"></script>


</head>

<body>


<div class='wrapper'>
    <header>
        <div class="top-nav">
            <nav>
                <ul>
                    <li><a href="/default">Мой профиль</a></li>
                    <li><a href="/logout">Выйти</a></li>
                </ul>
            </nav>



        </div>
        <a href="/index" class="logo"><img src="../images/logo.png" alt="your logo"/></a>

    </header>
    <div class="content full-content clearfix">

        <div class="breadcrumbs">
            <ul>
                <li><a href="/index">Главная</a></li>
                <li>Заказы</li>
            </ul>
        </div>

        <div class="product-menu-header">
            <h2>
                <div class="text-center">Заказы</div>
            </h2>
        </div>

        <div class="product-menu-holder">


            <div class="text-center">
                <div class="left-part">
                    <h3>Заказы в очереди</h3>


                    <div class="text-center">
                    <div class="ajaxnav">
                        <a onclick="change('all')">Все</a>
                        <a onclick="change('ready')">Отправленные</a>
                        <a onclick="change('notready')">Не отправленные</a>
                    </div>

                    <input id="select" type="hidden" value="notready">
                    </div>

                    <ul>
                        <div id="res"></div>



                    </ul>

                </div>
            </div>


        </div>
    </div>
</div>
<footer>
    <div class="footer-holder">
        <a href="" class="logo">Cooker Logo</a>


        <div class="links first">
            <h6>Подписывайтесь</h6>
            <ul>
                <li class="facebook"><a href="https://www.facebook.com/profile.php?id=100009318339260">Facebook</a></li>
                <li class="twitter"><a href="https://twitter.com/bobrkate">Twitter</a></li>
                <li class="rss"><a href="https://vk.com/id22146520">Vk</a></li>
            </ul>
        </div>

        <div class="credits clearfix">
            Copyright &copy; 2011 Cooker. All rights reserved
        </div>
    </div>
</footer>
<script type="text/javascript" src="/js/libs/jquery-1.7.1.min.js"></script>
<script src="../js/libs/jquery.easing.1.3.js"></script>
<script src="../js/script.js"></script>
<script src="../js/ajax.js"></script>
<script src="../js/libs/jquery.jcarousel.min.js"></script>


</body>
</html>