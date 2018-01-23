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

$email = json_decode(file_get_contents("php://input"));

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
mysqli_set_charset($conn, "utf8");
// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

//pi
$query = "SELECT `citizenID`,`titleTH`,`fNameTH`,`lNameTH`,`fNameEN`,`lNameEN`,`address`,`email`,`telephone`,`dateOfBirth`,`placeOfBirth`,`weight`,`height`,`nationality`,`race`,`religion`,`profNo`,`militaryStatus`,`maritalStatus`,`emergencyContact`,`toeicScore`,`toeicYear`,`toefl`,`toeflYear`,`word`,`excel`,`powerPoint`,`driveCar`,`ownCar`,`driveLicenseCar`,`rideMotocycle`,`ownMotocycle`,`driveLicenseMotocycle`,`hobby`,`q1`,`q2`,`q3`,`q4`,`q5` FROM personalinformation  WHERE EMAIL='$email'";

$result = mysqli_query($conn, $query);

while($row = mysqli_fetch_assoc($result)) {
    $row['weight'] = $row['weight']+0;
    $row['height'] = $row['height']+0;
    $row['profNo'] = $row['profNo']+0;
    $row['toeicScore'] = $row['toeicScore']+0;
    $row['toeicYear'] = $row['toeicYear']+0;
    $row['toefl'] = $row['toefl']+0;
    $row['toeflYear'] = $row['toeflYear']+0;
    $row['word'] = $row['word']+0;
    $row['excel'] = $row['excel']+0;
    $row['powerPoint'] = $row['powerPoint']+0;
    $row['driveCar'] = $row['driveCar']+0;
    $row['ownCar'] = $row['ownCar']+0;
    $row['rideMotocycle'] = $row['rideMotocycle']+0;
    $row['ownMotocycle'] = $row['ownMotocycle']+0;
    $row['q1'] = $row['q1']+0;
    $row['q2'] = $row['q2']+0;
    $row['q3'] = $row['q3']+0;
    $row['q4'] = $row['q4']+0;
    $row['q5'] = $row['q5']+0;
    $pi = $row;
}

//apprenticeship
$query = "SELECT `course`, `instituteName`, `certificate`, `period` FROM `apprenticeship` WHERE citizenID='".$pi['citizenID']."'";
$apprenticeships = array();
$result = mysqli_query($conn, $query);

while($row = mysqli_fetch_assoc($result)) {
    $apprenticeships[] = $row;
}
$pi['apprenticeships'] = $apprenticeships;

//education
$query = "SELECT `level`, `instituteName`, `degreeOrCertificate`, `major`, `studyFrom`, `studyTo`, `gpa` FROM `education` WHERE citizenID='".$pi['citizenID']."'";
$educations = array();
$result = mysqli_query($conn, $query);

while($row = mysqli_fetch_assoc($result)) {
    $row['gpa'] = $row['gpa']+0;
    $educations[] = $row;
}
$pi['educations'] = $educations;

//employmentRecord
$query = "SELECT `fromM`, `fromY`, `toM`, `toY`, `company`, `position`, `salary`,`reasonForLeaving` FROM `employmentrecord` WHERE citizenID='".$pi['citizenID']."'";
$employmentRecords = array();
$result = mysqli_query($conn, $query);

while($row = mysqli_fetch_assoc($result)) {
    $row['salary'] = $row['salary']+0;
    $employmentRecords[] = $row;
}
$pi['employmentRecords'] = $employmentRecords;

//familyDetail
$query = "SELECT `status`, `firstName`, `lastName`, `age`, `occupation`, `address`, `phoneNumber` FROM `familydetail` WHERE citizenID='".$pi['citizenID']."'";
$familyDetails = array();
$result = mysqli_query($conn, $query);

while($row = mysqli_fetch_assoc($result)) {
    $row['age'] = $row['age']+0;
    $familyDetails[] = $row;
}
$pi['familyDetails'] = $familyDetails;

//language ability
$query = "SELECT `language`, `speaking`, `reading`, `writing` FROM `languageability` WHERE citizenID='".$pi['citizenID']."'";
$languageAbilities = array();
$result = mysqli_query($conn, $query);

while($row = mysqli_fetch_assoc($result)) {
    $row['speaking'] = $row['speaking']+0;
    $row['reading'] = $row['reading']+0;
    $row['writing'] = $row['writing']+0;
    $languageAbilities[] = $row;
}
$pi['languageAbilities'] = $languageAbilities;

//q6
$query = "SELECT `mediaType`,`detail` FROM `q6` WHERE citizenID='".$pi['citizenID']."'";
$q6 = array();
$result = mysqli_query($conn, $query);

while($row = mysqli_fetch_assoc($result)) {
    $q6[] = $row;
}
$pi['q6'] = $q6;


echo json_encode($pi);

mysqli_close($conn);
?>