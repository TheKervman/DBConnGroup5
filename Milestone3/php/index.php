<?php $title = 'Home'; ?>
<?php $currentPage = 'index'; ?>

<?php include('assets/php/elements/head.php'); ?>
<?php include('assets/php/elements/navbar.php'); ?>



<html>
    <head>
        <link href="assets/css/login_style.css" type="text/css" rel="stylesheet"/>
        
        <script type="text/javascript" src="assets/js/do_login.js"></script>
    </head>
        
    <body>
        <div id="wrapper">

        <div id="login_form">
            <h1>ACCOUNT LOGIN</h1>
            <h3>Welcome to our database</h3>
            <p id="login_label">Username : Guest | Password : guest</p>
            <form method="post" action="do_login.php" onsubmit="return do_login();">
            <input type="text" name="username" id="username" placeholder="Enter Username">
            <br>
            <input type="password" name="password" id="password" placeholder="***********">
            <br>
            <input type="submit" name="login" value="LOGIN" id="login_button">
            </form>
        </div>

        </div>
    </body>
</html>

<?php include('assets/php/elements/footer.php'); ?>