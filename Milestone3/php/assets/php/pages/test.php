<?php $title = 'Test'; ?>
<?php $currentPage = 'test'; ?>

<?php include('../elements/head.php'); ?>
<?php include('../elements/navbar.php'); ?>


<html>
    <body>
        <form>
            <h1>Users Table</h1>

            <?php
                require_once "../database/classes/PDO.DB.class.php";

                $db = new DB();

                $data = $db->getAllUsers();
                foreach($data as $person) {
                    echo "<h3>{$person->whoAmI()}</h3>";
                }
            ?>
        </form>

        <form>
            <h1>Faculty</h1>
            <p>placeholder text</p>
        </form>

        <form>
            <h1>Students</h1>
            <p>placeholder text</p>

        </form>

        <form>
            <h1>Topics</h1>
            <p>placeholder text</p>

        </form>

        <form>
            <h1>Departments</h1>
            <p>placeholder text</p>

        </form>
    </body>
</html>