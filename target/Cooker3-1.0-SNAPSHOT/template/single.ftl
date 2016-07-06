<!doctype html>
<html>
<head>
    <meta charset="utf-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <title>Cooker</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="shortcut icon" href="/favicon.ico">
    <link rel="stylesheet" href="../css/style.css?v=2">
    <link rel="stylesheet" href="../css/jcarousel.css">

    <!-- All JavaScript at the bottom, except for Modernizr which enables HTML5 elements & feature detects -->
    <script src="../js/libs/modernizr-1.7.min.js"></script>
</head>

<body>


<div class='wrapper'>
    <header>
        <div class="top-nav">
            <nav>
                <ul>
                <#if user == "anonymousUser">
                <#else >
                    <li><a href="/default">Мой профиль</a></li>
                    <li><a href="/logout">Выйти</a></li>
                </#if>
                </ul>
            </nav>



        </div>
        <a href="/index" class="logo"><img src="../images/logo.png" alt="your logo" /></a>
        <nav class="main-menu">
            <ul>
                <li id="lava-elm"></li>
                <li class="current"><form action="/listing" >
                    <button type="submit" value="KOMBO" name="type">Наборы</button>
                </form></li>
                <li>
                    <form action="/listing" >
                        <button type="submit" value="PIZZA" name="type">Пицца</button>
                    </form></li>
                <li><form action="/listing" >
                    <button type="submit" value="ROLL" name="type">Роллы</button>
                </form></li>
                <li><form action="/listing" >
                    <button type="submit" value="DRINK" name="type">Напитки</button>
                </form></li>
                <li><form action="/listing" >
                    <button type="submit" value="DESERT" name="type">Десерты</button>
                </form></li>
                <li><form action="/listing" >
                    <button type="submit" value="WOK" name="type">Вок</button>
                </form></li>
                <li><form action="/listing" >
                    <button type="submit" value="ANOTHER" name="type">Дополнительно</button>
                </form></li>
            </ul>
        </nav>
    </header>
    <div class="content clearfix">
        <div class="breadcrumbs">
            <ul>
                <li><a href="/index">Главная</a></li>
                <li>Товар</li>
            </ul>
        </div>
        <div class="left-content">
            <div class="meal-details single">
                <h1>${p.getName()}</h1>

                <div class="image"><img src="${p.getPhoto()}" alt=""></div>
                <p class="descr">${p.getDescription()} </p>

                <hr/>

                <span class="price">${p.getPrice()}</span>
                <form action="/cart" method="post">
                    <button type="submit" name="productname" class="add-to-cart-button" value=${p.getName()}>В корзину</button>
                </form>

                <hr/>


            </div>
        </div>
        <div class="right-content">
            <div class="call-us">
                <span class="label">Только сейчас!</span>
                <span class="pop phone">100 бонусов</span>
                <span class="label">При заказе от</span>
                <span class="pop">1000 рублей</span>
            </div>

            <div class="cart-box">
                <div class="top">Корзина</div>
                <div class="body">
                    <ul>
                        <li class="info">
                    </ul>
                    <a class="submit-button" href="/cart">Посмотреть</a>
                    <div class="graphic"></div>
                </div>
            </div>

            <hr />

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
<script type="text/javascript" src="../js/libs/jquery-1.7.1.min.js"></script>
<script src="../js/libs/jquery.easing.1.3.js"></script>
<script src="../js/script.js"></script>
<script src="../js/libs/jquery.jcarousel.min.js"></script>
</body>
</html>