<?php

header('Access-Control-Allow-Origin: *');
header('Content-Type: application/x-www-form-urlencoded');
header('Content-Type: application/json');
header('Accept-Language: *');

// $servername = "localhost";
// $username = "root";
// $password = "";
// $dbname = "test_everything";
$servername = "192.168.1.9";
$username = "root";
$password = "";
$dbname = "saapplicationmanager";

$app = json_decode(file_get_contents("php://input"));

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
mysqli_set_charset($conn, "utf8");

// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

//application
$refnum = $app->refnum;
$date = !empty($app->date) ? "'$app->date'" : "NULL";
$position1 = !empty($app->position1) ? "'$app->position1'" : "NULL";
$position2 = !empty($app->position2) ? "'$app->position2'" : "NULL";
$workInShift = !empty($app->workInShift) ? "$app->workInShift" : "NULL";
$workerType = !empty($app->workerType) ? "'$app->workerType'" : "NULL";
$salary = !empty($app->salary) ? "$app->salary" : "NULL";
$startingDate = !empty($app->startingDate) ? "'$app->startingDate'" : "NULL";
$QH2 = !empty($app->QH2) ? "'$app->QH2'" : "NULL";
$QH3 = !empty($app->QH3) ? "'$app->QH3'" : "NULL";
$relativeWorkInHospital = !empty($app->relativeWorkInHospital) ? "'$app->relativeWorkInHospital'" : "NULL";
$additionalInformation = !empty($app->additionalInformation) ? "'$app->additionalInformation'" : "NULL";
$applicationStatus6 = !empty($app->applicationStatus6) ? "$app->applicationStatus6" : "NULL";

$query = "UPDATE `application` SET `date`=$date,`position1`=$position1,`position2`=$position2,`workInShift`=$workInShift,`workerType`=$workerType,`salary`=$salary,`startingDate`=$startingDate,`QH2`=$QH2,`QH3`=$QH3,`relativeWorkInHospital`=$relativeWorkInHospital,`additionalInformation`=$additionalInformation,`applicationStatus6`=$applicationStatus6 WHERE `refnum`=$app->refnum";
mysqli_query($conn, $query);
 
//hospital
$query = "DELETE FROM `hospital` WHERE refnum=".$refnum."";
mysqli_query($conn, $query);
$hospitals = $app->hospitals;
foreach ($hospitals as $key => $hospital) {
    $query = "INSERT INTO `hospital` (`refnum`, `hospitalName`) values ($refnum, '$hospital')";
    mysqli_query($conn, $query);
}

//qh1
$query = "DELETE FROM `qh1` WHERE refnum=".$refnum."";
mysqli_query($conn, $query);
$qh1s = $app->qh1;
foreach ($qh1s as $key => $qh1) {
    $query = "INSERT INTO `qh1` (`refnum`,  `type`, `detail`) values ($refnum, $qh1->type, '$qh1->detail')";
    mysqli_query($conn, $query);
}

//referenceperson
$query = "DELETE FROM `referenceperson` WHERE refnum=".$refnum."";
mysqli_query($conn, $query);
$referencePeople = $app->referencePeople;
foreach ($referencePeople as $key => $referenceperson) {
    $query = "INSERT INTO `referenceperson` (`refnum`,  `name`, `relationship`, `address`, `telephone`) values ($refnum, '$referenceperson->name', '$referenceperson->relationship', '$referenceperson->address', '$referenceperson->telephone')";
    mysqli_query($conn, $query);
}

mysqli_close($conn);
?>