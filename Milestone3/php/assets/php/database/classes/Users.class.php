<?php
class Users {
    private $userID;
    private $userName;
    private $password;
    private $role;

    public function whoAmI() {
        return "ID {$this->userID} registered as {$this->userName}, has a role of {$this->role}";
    }
}