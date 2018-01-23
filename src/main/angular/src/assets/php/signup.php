<?php

header('Access-Control-Allow-Origin: *');
header('Content-Type: application/x-www-form-urlencoded');
header('Content-Type: application/json');

// $servername = "localhost";
// $username = "root";
// $password = "";
// $dbname = "test_everything";
$servername = "192.168.1.9";
$username = "root";
$password = "";
$dbname = "saapplicationmanager";

$data = json_decode(file_get_contents("php://input"));

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
mysqli_set_charset($conn, "utf8");
// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
$pi = $data->pi;
$user = $data->user;

$query = "SELECT * FROM personalinformation WHERE CITIZENID='$pi->c_ID'";

$result = $conn->query($query);

if($result->num_rows > 0){
    die( "1" ) ;
}

$query = "SELECT * FROM personalinformation WHERE EMAIL='$pi->email'";

$result = $conn->query($query);

if($result->num_rows > 0){
    die( "2" ) ;
}

$query = "INSERT INTO accounts values ('$user->email', '$user->password')";
if (mysqli_query($conn, $query)) {
    $query = "INSERT INTO personalinformation (`citizenID`, `fNameTH`, `lNameTH`, `email`) values ('$pi->c_ID', '$pi->firstName', '$pi->lastName', '$pi->email')";
    if (mysqli_query($conn, $query)) {
        $createAppQuery = "INSERT INTO `application` (citizenID) values ('".$cid."')";
        mysqli_query($conn, $createAppQuery);
        echo "0";
    } else {
        $query = "DELETE FROM accounts WHERE EMAIL='$user->email'";
        mysqli_query($conn, $query);
        die("3");
    }
} else {
    die( "3" ) ;
}

mysqli_close($conn);
?>