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

//assume hasing algorithum password_hash("aaaaa", PASSWORD_DEFAULT)
$playerID = $_GET["id"];
$hash = $_GET["hash"];
$coinsWon = $_GET["won"];
$coinsBet= $_GET["bet"];
echo playerSpin($playerID, $coinsWon, $coinsBet, $hash, $conn)."<br>";

function playerSpin($playerID, $coinsWon, $coinsBet, $hash, $conn)
{
    if(validateHash($playerID, $hash, $conn))
    {
        $changeInBalance = $coinsWon - $coinsBet;
        if(updatePlayerAccount($playerID,  $changeInBalance, $conn))
        {
            return getPlayerJSON($playerID, $coinsWon, $coinsBet, $conn); 
        }
    }
 else {
     echo "Supplied credentials are invalid";
    }
}

function validateHash($playerID, $hash, $conn)
{
    $sql = "Select saltValue from players where playerID = ".$playerID.";";
    if($results = $conn->query($sql))
    {
        $row = $results->fetch_assoc();
        return password_verify( $row["saltValue"] , $hash );
    }
    else
    {
        echo "An error has occured ".$sql;
    }
    
    return false;
}

function getPlayerJSON($playerID, $coinsWon, $coinsBet, $conn)
{
    $sql = "Select playerID, Name, Credits, LifetimeSpins, "
            . "(credits / LifetimeSpins) as "
            . "LifetimeAverageReturn from players where playerID = "
            . $playerID.";";
    
    if($result = $conn->query($sql))
    {
        $userData = $result->fetch_assoc();
        return json_encode($userData);
    }
    else
    {
        return "An error has occured ".$sql;
    }
}    

function updatePlayerAccount($playerID, $changeInBalance, $conn)
{
    $sql = "Update players Set "
            . "credits = (credits + ".$changeInBalance."), "
            . "lifetimeSpins = (lifetimeSpins + 1) "
            . "where playerID = ".$playerID.";";
    if($conn->query($sql))  
    {
        return true;
    }
    else
    {
        echo "Error ".$sql."<br>";
    }
}    
