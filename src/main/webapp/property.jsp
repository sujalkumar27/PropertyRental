<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> sujal Propery</title>
<link rel="shortcut icon" href="favicon.png" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
    body {
      /* Specify the URL of your background image */
      background-image: url('https://source.unsplash.com/1600x900/?nature,water');
      background-size: cover;
      background-position: center;
      background-repeat: no-repeat;
    }
    .card {
      border-radius: 15px;
      border: 1px solid rgba(255,255,255,0.3);
      background-color: rgba(255, 255, 255, 0.8);
      box-shadow: 0 4px 6px rgba(0,0,0,0.1);
    }
 </style>
</head>
<body>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title text-center"><b>Add Property Details</b></h5>
            <form action="AddProperty" method="POST">
              <div class="form-group">
                <label for="name">Property Name</label>
                <input type="text" class="form-control" id="name" name="name" required>
              </div>
              <div class="form-group">
                <label for="price">Price</label>
                <input type="number" step="0.01" class="form-control" id="price" name="price" required>
              </div>
              <div class="form-group">
                <label for="bedrooms">Bedrooms</label>
                <input type="number" class="form-control" id="bedrooms" name="bedrooms" required>
              </div>
              <div class="form-group">
                <label for="bathrooms">Bathrooms</label>
                <input type="number" class="form-control" id="bathrooms" name="bathrooms" required>
              </div>
              <div class="form-group">
                <label for="description">Description</label>
                <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
              </div>
              <button type="submit" class="btn btn-primary btn-block">Submit</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>