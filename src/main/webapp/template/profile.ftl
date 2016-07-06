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

<!-- LOGIN POP UPS -->
<div id="popup-overlay"></div>
<div class="popup" id="popup-register">
    <h2>Редактирование профиля</h2>
    <hr class="separator">
    <form method="post" action="/profile/edit" class="form clearfix">
        <fieldset>
            <label for="login-username">Логин:</label>
            <input type="text" name="login" id="login-username" class="input text">
            <label for="login-email">Телефон:</label>
            <input type="text" name="phone" id="login-email" class="input text" >
            <label for="login-password">Пароль:</label>
            <input type="password" name="password" id="login-password" class="input text">
            <label for="login-confirm-password">Повторите пароль:</label>
            <input type="password" name="repassword" id="login-confirm-password" class="input text">
        <hr class="separator">


        <button class="button submit">Сохранить</button>
    </form>
    <a class="close" href="#"></a>
</div>
<!-- END LOGIN POP UPS -->
<div class='wrapper'>
    <header>
        <div class="top-nav">
            <nav>
                <ul>
                    <li><a href="/default">Мой профиль</a></li>
                    <li><a href="#" class="register-btn">Редактировать</a></li>
                    <li><a href="/logout">Выйти</a></li>
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
    <div class="content full-content clearfix">
        <div class="breadcrumbs">
            <ul>
                <li><a href="/index">Главная</a></li>
                <li>Мой Профиль</li>
            </ul>
        </div>

        <div class="menu-info">
        <h1>${user.getLogin()}</h1>

            <h2>${user.getPhone()}</h2>

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
        <hr>
        </div>
                <h3>Мои бонусы:</h3>
                    <p>${user.getBonus()}</p>

                    <hr>

                    <blockquote>
                        <strong>Мои заказы:</strong>
                        <ul>
                        <#if user.getOrders()?has_content>

                            <#list user.getOrders() as o>
                                <li>${o.getDate()}
                                    <br>
                                    Стоимость: ${o.getPrice()}
                                    <br>
                                    <#list o.getProductinorderList() as product>
                                    ${product.getProduct().getName()},
                                    </#list>
                                    <br>
                                    <#if o.getStatus() = true>
                                    <b>Доставлено</b>
                                        <#else >
                                    <b>Не доставлено</b>
                                    </#if>
                                    <br>
                                    <br>
                                </li>
                            </#list>

                        <#else >
                        У вас пока нет заказов...
                        </#if>
                    </ul>
                    </blockquote>


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