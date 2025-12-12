<?php
header("Content-Type: application/json");
$conn = new mysqli("localhost", "root", "ganairsm", "uas_nmp_FriendsApp");

if ($conn->connect_error) {
    die(json_encode(["error" => "Connection failed"]));
}

$result = $conn->query("SELECT * FROM student");
$data = [];

while ($row = $result->fetch_assoc()) {
    $data[] = $row;
}

echo json_encode($data);
