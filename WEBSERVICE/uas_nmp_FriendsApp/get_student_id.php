<?php
header("Content-Type: application/json");
include "./koneksi.php";

if ($conn->connect_error) {
    die(json_encode([
        "status" => false,
        "message" => "Connection failed"
    ]));
}

if (!isset($_GET['nrp'])) {
    echo json_encode([
        "status" => false,
        "message" => "nrp tidak ditemukan"
    ]);
    exit;
}

$nrp = $conn->real_escape_string($_GET['nrp']);

$sql = "SELECT * FROM student WHERE nrp = '$nrp'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    echo json_encode([
        "status" => true,
        "data" => $result->fetch_assoc()
    ]);
} else {
    echo json_encode([
        "status" => false,
        "message" => "Student tidak ditemukan"
    ]);
}
