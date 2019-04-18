<?php
session_start();
if(isset($_POST['do_login'])) {

    $host="localhost";
    $loginname="kg8128";
    $password="smallcorner";
    $databasename="kg8128";

    $connect=mysql_connect($host,$loginname,$password);
    $db=mysql_select_db($databasename);

    $uname=$_POST['username'];
    $pass=$_POST['password'];
    $select_data=mysql_query("SELECT * FROM attendee WHERE name='$username' AND password='$pass'");

    if($row=mysql_fetch_array($select_data)) {
        $_SESSION['username']=$row['username'];
        echo "success";
    } else {
        echo "fail";
    }
 exit();
}
?>