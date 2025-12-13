<?php
header("Content-Type: application/json");
include "./koneksi.php";

if ($conn->connect_error) {
    die(json_encode([
        "status" => false,
        "message" => "Connection failed"
    ]));
}

if (!isset($_POST['nrp'])) {
    echo json_encode([
        "status" => false,
        "message" => "Parameter nrp tidak ditemukan"
    ]);
    exit;
}

$nrp = $conn->real_escape_string($_POST['nrp']);

$checkStudent = $conn->query("SELECT nrp FROM student WHERE nrp = '$nrp'");
if ($checkStudent->num_rows == 0) {
    echo json_encode([
        "status" => false,
        "message" => "Student tidak ditemukan"
    ]);
    exit;
}

$checkFriend = $conn->query("SELECT id FROM my_friends WHERE nrp = '$nrp'");
if ($checkFriend->num_rows > 0) {
    echo json_encode([
        "status" => false,
        "message" => "Student sudah ada di friends"
    ]);
    exit;
}

$sql = "INSERT INTO my_friends (nrp) VALUES ('$nrp')";
if ($conn->query($sql)) {
    echo json_encode([
        "status" => true,
        "message" => "Friend berhasil ditambahkan"
    ]);
} else {
    echo json_encode([
        "status" => false,
        "message" => "Gagal menambahkan friend"
    ]);
}
