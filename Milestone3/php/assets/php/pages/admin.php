<?php $title = 'Admin'; ?>
<?php $currentPage = 'admin'; ?>

<?php include('../elements/head.php'); ?>
<?php include('../elements/navbar.php'); ?>


<html>
    <body>
        <form>
            <h1>Users</h1>

            <?php
                require_once "../database/classes/PDO.DB.class.php";

                $db = new DB();

                $data = $db->getAllUsers();
                foreach($data as $person) {
                    echo "<h2>{$person->whoAmI()}</h2>";
                }
            ?>
        </form>

    </body>
</html>