

<!DOCTYPE html>
<html>
<head>
    <title>Edit Contact</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .container {
            margin-top: 50px;
        }
        form {
            max-width: 500px;
            margin: 0 auto;
        }
        input[type="submit"] {
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Edit Contact</h2>
        <form method="POST" action="update.php">
            <?php
            $conn = mysqli_connect('localhost', 'root', '', 'contact_db') or die('connection failed');
            
            if (isset($_GET['id'])) {
                $id = $_GET['id'];
                $query = "SELECT * FROM `contact_form` WHERE id = $id";
                $result = mysqli_query($conn, $query);
                
                if (mysqli_num_rows($result) == 1) {
                    $row = mysqli_fetch_assoc($result);
                    ?>
                    <input type="hidden" name="id" value="<?php echo $row['id']; ?>">
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" class="form-control" id="name" name="name" value="<?php echo $row['name']; ?>">
                    </div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" class="form-control" id="email" name="email" value="<?php echo $row['email']; ?>">
                    </div>
                    <div class="form-group">
                        <label for="number">Number:</label>
                        <input type="text" class="form-control" id="number" name="number" value="<?php echo $row['number']; ?>">
                    </div>
                    <div class="form-group">
                        <label for="date">Date:</label>
                        <input type="date" class="form-control" id="date" name="date" value="<?php echo $row['date']; ?>">
                    </div>
                    <input type="submit" value="Update" class="btn btn-primary">
            <?php } else {
                    echo "No record found with ID: $id";
                }
            } else {
                echo 'ID not provided';
            }
            mysqli_close($conn);
            ?>
        </form>
    </div>
</body>
</html>
