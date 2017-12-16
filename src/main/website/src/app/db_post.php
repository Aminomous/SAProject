<?php
$servername = "10.2.60.249";
$username = "root";
$password = "";
$dbname = "SAAPPLICATIONMANAGER";

$data = json_decode(file_get_contents("php://input"), true);

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
$query = "INSERT INTO `application` (null, '".$data['date']."', '".$data['position1']."', '".$data['position2']."', ".$data['workInShift'].", '".$data['workerType']."', ".$data['salary'].", '".$data['startingDate']."', '".$data['personalInformation']['ID']."', '".$data['QH2']."', '".$data['QH3']."', '".$data['relativeWorkInHospital']."', '".$data['additionalInformation']."', ".$data['applicationStatus1'].", ".$data['applicationStatus2'].", ".$data['applicationStatus3'].", ".$data['applicationStatus4'].", ".$data['applicationStatus5'].")";

if ($conn->query($query) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $query . "<br>" . $conn->error;
}
// $query = "SELECT * FROM APPLICATION";
// $result = $conn->query($query);

// if ($result->num_rows > 0) {
//     // output data of each row
//     while($row = $result->fetch_assoc()) {
//         echo "id: " . $row["refnum"]. " - Name: " . $row["date"];
//     }
// } else {
//     echo "0 results";
// }
$conn->close();
?>