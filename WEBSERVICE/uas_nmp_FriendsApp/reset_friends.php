<?php
header("Content-Type: application/json");

$conn = new mysqli("localhost", "root", "ganairsm", "uas_nmp_FriendsApp");

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
