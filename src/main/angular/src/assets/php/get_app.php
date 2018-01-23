<?php

header('Access-Control-Allow-Origin: *');
header('Content-Type: application/x-www-form-urlencoded');
header('Content-Type: application/json');
header('Accept-Language: *');

// $servername = "localhost";
// $username = "root";
// $password = "";
// $dbname = "test_everything";
$servername = "10.2.30.137";
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

//application
$query = "SELECT `refnum`,`date`,`position1`,`position2`,`workInShift`,`workerType`,`salary`,`startingDate`,`QH2`,`QH3`,`relativeWorkInHospital`,`additionalInformation`,`applicationStatus6` FROM `application`  WHERE citizenID='$cid'";

$result = mysqli_query($conn, $query);

if (mysqli_num_rows($result) > 0) {
    while($row = mysqli_fetch_assoc($result)) {
        $row['refnum'] = $row['refnum']+0;
        $row['salary'] = $row['salary']+0;
        $row['applicationStatus6'] = $row['applicationStatus6']+0;
        $app = $row;
    }
}

$refnum = $app['refnum'];
//hospital
$query = "SELECT `hospitalName` FROM `hospital` WHERE refnum=".$refnum."";
$hospitals = array();
$result = mysqli_query($conn, $query);

while($row = mysqli_fetch_assoc($result)) {
    $hospitals[] = $row;
}
$app['hospitals'] = $hospitals;

//qh1
$query = "SELECT `type`, `detail` FROM `qh1` WHERE refnum=".$refnum."";
$qh1 = array();
$result = mysqli_query($conn, $query);

while($row = mysqli_fetch_assoc($result)) {
    $row['type'] = $row['type']+0;
    $qh1[] = $row;
}
$app['qh1'] = $qh1;

//referenceperson
$query = "SELECT `name`, `relationship`, `address`, `telephone` FROM `referenceperson` WHERE refnum=".$refnum."";
$referencePeople = array();
$result = mysqli_query($conn, $query);

while($row = mysqli_fetch_assoc($result)) {
    $referencePeople[] = $row;
}
$app['referencePeople'] = $referencePeople;

echo json_encode($app);

mysqli_close($conn);
?>