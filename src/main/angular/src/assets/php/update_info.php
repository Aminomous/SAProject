<?php

header('Access-Control-Allow-Origin: *');
header('Content-Type: application/x-www-form-urlencoded');
header('Content-Type: application/json');
header('Accept-Language: *');

$servername = "localhost";
// $username = "root";
// $password = "";
// $dbname = "test_everything";
// $servername = "192.168.1.9";
$username = "root";
$password = "";
$dbname = "saapplicationmanager2";

$pi = json_decode(file_get_contents("php://input"));

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
mysqli_set_charset($conn, "utf8");
// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

//pi

$citizenID = !empty($pi->citizenID) ? "'$pi->citizenID'" : "NULL";
$titleTH = !empty($pi->titleTH) ? "'$pi->titleTH'" : "NULL";
$fNameTH = !empty($pi->fNameTH) ? "'$pi->fNameTH'" : "NULL";
$lNameTH = !empty($pi->lNameTH) ? "'$pi->lNameTH'" : "NULL";
$fNameEN = !empty($pi->fNameEN) ? "'$pi->fNameEN'" : "NULL";
$lNameEN = !empty($pi->lNameEN) ? "'$pi->lNameEN'" : "NULL";
$address = !empty($pi->address) ? "'$pi->address'" : "NULL";
$email = !empty($pi->email) ? "'$pi->email'" : "NULL";
$telephone = !empty($pi->telephone) ? "'$pi->telephone'" : "NULL";
$dateOfBirth = !empty($pi->dateOfBirth) ? "'$pi->dateOfBirth'" : "NULL";
$placeOfBirth = !empty($pi->placeOfBirth) ? "'$pi->placeOfBirth'" : "NULL";
$weight = !empty($pi->weight) ? "$pi->weight" : "NULL";
$height = !empty($pi->height) ? "$pi->height" : "NULL";
$nationality = !empty($pi->nationality) ? "'$pi->nationality'" : "NULL";
$race = !empty($pi->race) ? "'$pi->race'" : "NULL";
$religion = !empty($pi->religion) ? "'$pi->religion'" : "NULL";
$profNo = !empty($pi->profNo) ? "$pi->profNo" : "NULL";
$militaryStatus = !empty($pi->militaryStatus) ? "'$pi->militaryStatus'" : "NULL";
$maritalStatus = !empty($pi->maritalStatus) ? "'$pi->maritalStatus'" : "NULL";
$emergencyContact = !empty($pi->emergencyContact) ? "'$pi->emergencyContact'" : "NULL";
$toeicScore = !empty($pi->toeicScore) ? "$pi->toeicScore" : "NULL";
$toeicYear = !empty($pi->toeicYear) ? "$pi->toeicYear" : "NULL";
$toefl = !empty($pi->toefl) ? "$pi->toefl" : "NULL";
$toeflYear = !empty($pi->toeflYear) ? "$pi->toeflYear" : "NULL";
$word = !empty($pi->word) ? "$pi->word" : "NULL";
$excel = !empty($pi->excel) ? "$pi->excel" : "NULL";
$powerPoint = !empty($pi->powerPoint) ? "$pi->powerPoint" : "NULL";
$driveCar = !empty($pi->driveCar) ? "$pi->driveCar" : "NULL";
$ownCar = !empty($pi->ownCar) ? "$pi->ownCar" : "NULL";
$driveLicenseCar = !empty($pi->driveLicenseCar) ? "'$pi->driveLicenseCar'" : "NULL";
$rideMotocycle = !empty($pi->rideMotocycle) ? "$pi->rideMotocycle" : "NULL";
$ownMotocycle = !empty($pi->ownMotocycle) ? "$pi->ownMotocycle" : "NULL";
$driveLicenseMotocycle = !empty($pi->driveLicenseMotocycle) ? "'$pi->driveLicenseMotocycle'" : "NULL";
$hobby = !empty($pi->hobby) ? "'$pi->hobby'" : "NULL";
$q1 = !empty($pi->q1) ? "$pi->q1" : "NULL";
$q2 = !empty($pi->q2) ? "$pi->q2" : "NULL";
$q3 = !empty($pi->q3) ? "$pi->q3" : "NULL";
$q4 = !empty($pi->q4) ? "$pi->q4" : "NULL";
$q5 = !empty($pi->q5) ? "'$pi->q5'" : "NULL";


$query = "UPDATE personalinformation SET `titleTH`=$titleTH,`fNameTH`=$fNameTH,`lNameTH`=$lNameTH,`fNameEN`=$fNameEN,`lNameEN`=$lNameEN,`address`=$address,`email`=$email,`telephone`=$telephone,`dateOfBirth`=$dateOfBirth,`placeOfBirth`=$placeOfBirth,`weight`=$weight,`height`=$height,`nationality`=$nationality,`race`=$race,`religion`=$religion,`profNo`=$profNo,`militaryStatus`=$militaryStatus,`maritalStatus`=$maritalStatus,`emergencyContact`=$emergencyContact,`toeicScore`=$toeicScore,`toeicYear`=$toeicYear,`toefl`=$toefl,`toeflYear`=$toeflYear,`word`=$word,`excel`=$excel,`powerPoint`=$powerPoint,`driveCar`=$driveCar,`ownCar`=$ownCar,`driveLicenseCar`=$driveLicenseCar,`rideMotocycle`=$rideMotocycle,`ownMotocycle`=$ownMotocycle,`driveLicenseMotocycle`=$driveLicenseMotocycle,`hobby`=$hobby,`q1`=$q1,`q2`=$q2,`q3`=$q3,`q4`=$q4,`q5`=$q5  WHERE CITIZENID='$pi->citizenID'";

// if (mysqli_query($conn, $query)) {
//     echo "Record updated successfully";
// } else {
//     echo "Error updating record: " . mysqli_error($conn);
// }

$result = mysqli_query($conn, $query);

//apprenticeship


$query = "DELETE FROM `apprenticeship` WHERE citizenID='$pi->citizenID'";
mysqli_query($conn, $query);
$apprenticeships = $pi->apprenticeships;
foreach ($apprenticeships as $key => $apprenticeship) {
    $apprenticeshipcourse = !empty($apprenticeship->course) ? "'$apprenticeship->course'" : "NULL";
    $apprenticeshipinstituteName = !empty($apprenticeship->instituteName) ? "'$apprenticeship->instituteName'" : "NULL";
    $apprenticeshipcertificate = !empty($apprenticeship->certificate) ? "'$apprenticeship->certificate'" : "NULL";
    $apprenticeshipperiod = !empty($apprenticeship->period) ? "'$apprenticeship->period'" : "NULL";
    $query = "INSERT INTO `apprenticeship` (`citizenID`, `course`, `instituteName`, `certificate`, `period`) values ('$pi->citizenID', $apprenticeshipcourse, $apprenticeshipinstituteName, $apprenticeshipcertificate, $apprenticeshipperiod)";
    mysqli_query($conn, $query);
}

// education

$query = "DELETE FROM `education` WHERE citizenID='$pi->citizenID'";
mysqli_query($conn, $query);
$educations = $pi->educations;
foreach ($educations as $key => $education) {
    $educationlevel = !empty($education->level) ? "'$education->level'" : "NULL";
    $educationinstituteName = !empty($education->instituteName) ? "'$education->instituteName'" : "NULL";
    $educationdegreeOrCertificate = !empty($education->degreeOrCertificate) ? "'$education->degreeOrCertificate'" : "NULL";
    $educationmajor = !empty($education->major) ? "'$education->major'" : "NULL";
    $educationstudyFrom = !empty($education->studyFrom) ? "'$education->studyFrom'" : "NULL";
    $educationstudyTo = !empty($education->studyTo) ? "'$education->studyTo'" : "NULL";
    $educationgpa = !empty($education->gpa) ? $education->gpa : "NULL";
    $query = "INSERT INTO `education` (`citizenID`, `level`, `instituteName`, `degreeOrCertificate`, `major`, `studyFrom`, `studyTo`, `gpa`) values ('$pi->citizenID', $educationlevel, $educationinstituteName, $educationdegreeOrCertificate, $educationmajor, $educationstudyFrom, $educationstudyTo, $educationgpa)";
    mysqli_query($conn, $query);
}

//employmentRecord


$query = "DELETE FROM `employmentrecord` WHERE citizenID='$pi->citizenID'";
mysqli_query($conn, $query);
$employmentRecords = $pi->employmentRecords;
foreach ($employmentRecords as $key => $employmentRecord) {
    $employmentRecordfromM = !empty($employmentRecord->fromM) ? "'$employmentRecord->fromM'" : "NULL";
    $employmentRecordfromY = !empty($employmentRecord->fromY) ? "'$employmentRecord->fromY'" : "NULL";
    $employmentRecordtoM = !empty($employmentRecord->toM) ? "'$employmentRecord->toM'" : "NULL";
    $employmentRecordtoY = !empty($employmentRecord->toY) ? "'$employmentRecord->toY'" : "NULL";
    $employmentRecordcompany = !empty($employmentRecord->company) ? "'$employmentRecord->company'" : "NULL";
    $employmentRecordposition = !empty($employmentRecord->position) ? "'$employmentRecord->position'" : "NULL";
    $employmentRecordsalary = !empty($employmentRecord->salary) ? $employmentRecord->salary : "NULL";
    $employmentRecordreasonForLeaving = !empty($employmentRecord->reasonForLeaving) ? "'$employmentRecord->reasonForLeaving'" : "NULL";
    $query = "INSERT INTO `employmentrecord` (`citizenID`, `fromM`, `fromY`, `toM`, `toY`, `company`, `position`, `salary`,`reasonForLeaving`) values ('$pi->citizenID', $employmentRecordfromM, $employmentRecordfromY, $employmentRecordtoM, $employmentRecordtoY, $employmentRecordcompany, $employmentRecordposition, $employmentRecordsalary, $employmentRecordreasonForLeaving)";
    mysqli_query($conn, $query);
}

//familyDetail

$query = "DELETE FROM `familydetail` WHERE citizenID='$pi->citizenID'";
mysqli_query($conn, $query);
$familyDetails = $pi->familyDetails;
foreach ($familyDetails as $key => $familyDetail) {
    $familyDetailstatus = !empty($familyDetail->status) ? "'$familyDetail->status'" : "NULL";
    $familyDetailfirstName = !empty($familyDetail->firstName) ? "'$familyDetail->firstName'" : "NULL";
    $familyDetaillastName = !empty($familyDetail->lastName) ? "'$familyDetail->lastName'" : "NULL";
    $familyDetailage = !empty($familyDetail->age) ? $familyDetail->age : "NULL";
    $familyDetailoccupation = !empty($familyDetail->occupation) ? "'$familyDetail->occupation'" : "NULL";
    $familyDetailaddress = !empty($familyDetail->address) ? "'$familyDetail->address'" : "NULL";
    $familyDetailphoneNumber = !empty($familyDetail->phoneNumber) ? "'$familyDetail->phoneNumber'" : "NULL";
    $query = "INSERT INTO `familydetail` (`citizenID`, `status`, `firstName`, `lastName`, `age`, `occupation`, `address`, `phoneNumber`) values ($pi->citizenID, $familyDetailstatus, $familyDetailfirstName, $familyDetaillastName, $familyDetailage, $familyDetailoccupation, $familyDetailaddress, $familyDetailphoneNumber)";
    mysqli_query($conn, $query);
}

//language ability

$query = "DELETE FROM `languageability` WHERE citizenID='$pi->citizenID'";
mysqli_query($conn, $query);
$languageAbilities = $pi->languageAbilities;
foreach ($languageAbilities as $key => $languageAbility) {
    $languageAbilitylanguage = !empty($languageAbility->language) ? "'$languageAbility->language'" : "NULL";
    $languageAbilityspeaking = !empty($languageAbility->speaking) ? $languageAbility->speaking : "NULL";
    $languageAbilityreading = !empty($languageAbility->reading) ? $languageAbility->reading : "NULL";
    $languageAbilitywriting = !empty($languageAbility->writing) ? $languageAbility->writing : "NULL";
    $query = "INSERT INTO `languageability` (`citizenID`, `language`, `speaking`, `reading`, `writing`) values ('$pi->citizenID', $languageAbilitylanguage, $languageAbilityspeaking, $languageAbilityreading, $languageAbilitywriting)";
    mysqli_query($conn, $query);
}

//q6

$query = "DELETE FROM `q6` WHERE citizenID='$pi->citizenID'";
mysqli_query($conn, $query);
$q6s = $pi->q6;
foreach ($q6s as $key => $q6) {
    $q6mediaType = !empty($q6->mediaType) ? "'$q6->mediaType'" : "NULL";
    $q6detail = !empty($q6->detail) ? "'$q6->detail'" : "NULL";
    $query = "INSERT INTO `q6` (`citizenID`, `mediaType`, `detail`) values ('$pi->citizenID', $q6mediaType, $q6detail)";
    mysqli_query($conn, $query);
}


mysqli_close($conn);
?>