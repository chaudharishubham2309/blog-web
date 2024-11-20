<?php
$conn = mysqli_connect('localhost', 'root', '', 'contact_db') or die('connection failed');

// Function to sanitize input (to prevent SQL injection)
function sanitizeInput($conn, $data) {
    return mysqli_real_escape_string($conn, $data);
}

// Fetch data from the database
$query = "SELECT * FROM `contact_form`";
$result = mysqli_query($conn, $query);

// Check if there's any data
if (mysqli_num_rows($result) > 0) {
    echo '<!DOCTYPE html>
    <html>
    <head>
        <title>Contact Form Data</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style>
            body {
                padding: 20px;
            }
            table {
                border-collapse: collapse;
                width: 100%;
            }
            th, td {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }
            th {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>
        <h1>Contact Form Data</h1>
        <div class="container">
            <table class="table table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Number</th>
                        <th>Date</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>';

    while ($row = mysqli_fetch_assoc($result)) {
        echo '<tr>
                <td>' . $row['name'] . '</td>
                <td>' . $row['email'] . '</td>
                <td>' . $row['number'] . '</td>
                <td>' . $row['date'] . '</td>
                <td>
                    <a href="edit.php?id=' . $row['id'] . '" class="btn btn-primary btn-sm">Edit</a>
                    <a href="delete.php?id=' . $row['id'] . '" class="btn btn-danger btn-sm">Delete</a>
                </td>
              </tr>';
    }

    echo '</tbody></table></div></body></html>';
} else {
    echo 'No data found in the contact form.';
}

mysqli_close($conn);
?>
