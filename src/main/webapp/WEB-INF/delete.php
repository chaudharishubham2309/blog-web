<?php
$conn = mysqli_connect('localhost', 'root', '', 'contact_db') or die('connection failed');

if(isset($_GET['id'])) {
    $id = $_GET['id'];

    // Delete the record
    $query = "DELETE FROM `contact_form` WHERE id = $id";
    $result = mysqli_query($conn, $query);

    if($result) {
        echo "Record with ID: $id has been deleted successfully.";
    } else {
        echo "Error deleting record with ID: $id";
    }
} else {
    echo 'ID not provided';
}

mysqli_close($conn);
?>
