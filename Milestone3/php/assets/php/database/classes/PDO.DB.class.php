<?php
class DB {
    private $dbh;

    function __construct() {
        try {
            $this->dbh = new PDO("mysql:host={$_SERVER['DB_SERVER']};dbname={$_SERVER['DB']}", $_SERVER['DB_USER'], $_SERVER['DB_PASSWORD']);
        } 
        catch (PDOException $e) {
            die();
        }
    }

    function getAllUsers() {
        try {
            include "Users.class.php";
            $data = array();
            $stmt = $this->dbh->prepare("SELECT * FROM users");
            $stmt->execute();
            $stmt->setFetchMode(PDO::FETCH_CLASS, "Users");
            while ($person = $stmt->fetch()) {
                $data[] = $person;
            }
            return $data;
        } catch (PDOException $e) {
            echo $e->getMessage();
            die();
        }
    }

    // function getAttendeesParameterized($id) {
    //     try {
    //         $data = array();
    //         $stmt = $this->dbh->prepare("SELECT * FROM attendee WHERE idattendee = :id");
    //         $stmt->execute(array('id'=>$id));
    //         while ($row = $stmt->fetch()) {
    //             $data[] = $row;
    //         }
    //         return $data;
    //     } catch (PDOException $e) {
    //         echo $e->getMessage();
    //         die();
    //     }
    // }

    // function insertAttendee($name, $password, $role) {
    //     try {
    //         $stmt = $this->dbh->prepare("INSERT INTO attendee (Name, Password, Role) VALUES (:name, :password, :role)");
    //         $stmt->execute(array(
    //             "name"=>$name,
    //             "password"=>$password,
    //             "role"=>$role
    //         ));
    //         return $this->dbh->lastInsertAttendee();
    //     } catch (PDOException $e) {
    //         echo $e->getMessage();
    //         die();
    //     }
    // }

}
