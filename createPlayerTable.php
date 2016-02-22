<?php

$servername = "localhost";
$username = "root";
$password = "";
$database = "DetailDeputy";

// Create connection
$conn = new mysqli($servername, $username, $password, $database);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "Create table players ("
        . "playerID int, "
        . "name VARCHAR(200), "
        . "credits int, "
        . "lifetimeSpins int, "
        . "saltValue VARCHAR(200),"
        . "Primary Key(playerID))";

if($conn->query($sql))
{
    echo "tableCreatedSucessfully";
}
else
{
    echo $sql; 
}

?>
