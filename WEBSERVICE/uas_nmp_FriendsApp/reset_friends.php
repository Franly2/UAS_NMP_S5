<?php
header("Content-Type: application/json");
include "./koneksi.php";

if ($conn->connect_error) {
    echo json_encode(["status" => "error", "message" => "Connection failed"]);
    exit();
}

$sql = "DELETE FROM my_friends";

if ($conn->query($sql) === TRUE) {
    echo json_encode(["status" => "success", "message" => "Friends reset successfully"]);
} else {
    echo json_encode(["status" => "error", "message" => "Failed to reset"]);
}

$conn->close();
