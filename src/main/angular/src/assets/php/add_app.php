<?php

header('Access-Control-Allow-Origin: *');
header('Content-Type: application/x-www-form-urlencoded');
header('Content-Type: application/json');

$servername = "localhost";
// $username = "root";
// $password = "";
// $dbname = "test_everything";
// $servername = "192.168.1.9";
$username = "root";
$password = "";
$dbname = "saapplicationmanager";

$cid = json_decode(file_get_contents("php://input"));

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
mysqli_set_charset($conn, "utf8");
// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

$createAppQuery = "INSERT INTO `application` (citizenID) values ('".$cid."')";
mysqli_query($conn, $createAppQuery);
echo "0";
mysqli_close($conn);
?>