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
<div class="popup" id="popup-login">
    <h2>Login form</h2>
    <hr class="separator">
    <form method="post" action="" class="form clearfix">
        <fieldset>
            <label for="login-username">Username:</label>
            <input type="text" name="" id="login-username" class="input text">
            <label for="login-password">Password:</label>
            <input type="password" name="" id="login-password" class="input text">
        </fieldset>
    </form>
    <hr class="separator">
    <button class="button submit">Login</button>
    <div class="links"><a href="#">Forgotten password </a> | <a href="#" class="register-btn"> New account</a></div>
    <a class="close" href="#"></a>
</div>
<div class="popup" id="popup-register">
    <h2>Registration form</h2>
    <hr class="separator">
    <form method="post" action="" class="form clearfix">
        <fieldset>
            <label for="login-username">Username:</label>
            <input type="text" name="" id="login-username" class="input text">
            <label for="login-email">Email:</label>
            <input type="text" name="" id="login-email" class="input text error" value="Error">
            <label for="login-password">Password:</label>
            <input type="password" name="" id="login-password" class="input text">
            <label for="login-confirm-password">Confirm password:</label>
            <input type="password" name="" id="login-confirm-password" class="input text">
        </fieldset>

        <hr class="separator">

        <div class="checks">
            <div class="check-row">
                <label><input type="checkbox" class="input checkbox">I have read and agree to the <a href="#">Terms &amp; Conditions</a></label>
            </div>
            <div class="check-row">
                <label><input type="checkbox" class="input checkbox">I agree to recieve promotional mails</label>
            </div>
        </div>

        <button class="button submit">Register now</button>
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
                    <li><a href="/contentadmin/">Контент</a></li>
                    <li><a href="/cookadmin">Кухня и дост       авка</a></li>
                    <li><a href="/logout">Выйти</a></li>
                </ul>
            </nav>



        </div>
        <a href="/index" class="logo"><img src="../images/logo.png" alt="your logo" /></a>
        <nav class="main-menu">
            <ul><li id="lava-elm"></li>
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
                <li>Системный Администратор</li>
            </ul>
        </div>
        <div class="left-content">



            <h2 class="heading">Добавление нового администратора</h2>
            <form method="post" action="/sysadmin/addNewAdmin" class="form contact-form">
                <fieldset>
                    <label for="loginreg">Логин:</label>
                    <input type="text" name="login" id="loginreg" class="input text" oninput="responseLogin()">
                    <br>
                    <p class="login_msg" id="infologin"></p>
                    <label for="phone">Телефон:</label>
                    <input type="text" name="phone" id="phone" class="input text" oninput="responsePhone()" >
                    <br>
                    <p class="phone_msg" id="infophone"></p>
                    <label for="password">Пароль:</label>
                    <input type="password" name="password" id="password" class="input text">
                    <label for="repassword">Повторите пароль:</label>
                    <input type="password" name="repassword" id="repassword" class="input text">
                    <br>
                    <p class="pass_msg" id="info"></p>
                    <label for="type-subject">Роль:</label>
                    <select class="select-dropdown" id="type-subject" name="role" >
                        <option value="ROLE_CONTENT_ADMIN">Администратор Контента</option>
                        <option value="ROLE_COOK_ADMIN">Администратор кухни и доставки</option>
                    </select>

                    <span class="required-desr"></span>
                    <button class="button" type="submit">Добавить</button>
                </fieldset>
            </form>



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
</body>
<script src="../js/libs/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="../js/libs/jquery.easing.1.3.js"></script>
<script src="../js/script.js"></script>
<script src="../js/validator.js"></script>
<script src="../js/libs/jquery.jcarousel.min.js"></script>
</html>