<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sujal Property</title>
 <link rel="shortcut icon" href="favicon.png" />
</head>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.2/css/bootstrap.min.css"
    integrity="sha512-b2QcS5SsA8tZodcDtGRELiGv5SaKSk1vDHDaQRda0htPYWZ6046lr3kJ5bAAQdpV2mmA/4v0wQF9MyU6/pDIAg=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
    integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
    crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.2/js/bootstrap.bundle.min.js"
    integrity="sha512-X/YkDZyjTf4wyc2Vy16YGCPHwAY8rZJY+POgokZjQB2mhIRFJCckEGc6YyX9eNsPfn0PzThEuNs+uaomE5CO6A=="
    crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<style>
	.row {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
  .btn{
    background-color: #005555;
}
</style>
<body>
   
 <input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
	<section class="row shadow-lg p-3 mb-5 bg-body-tertiary rounded border border-5">
	<div class="">
			<nav class="navbar  bg-body-tertiary" >
			  <div class="container-fluid">
			    <h2>Sign Up</h2> 
				 <a class="btn  shadow-lg  mx-5 btn-success text-white" href="index.html" >Home</a>
			  </div>
			</nav>
      </div><hr>
	    <div class="col ">
                <form action="ResgistrationServlet" method="post">
                    <div class="mb-3">
                      <label for="exampleInputEmail1" class="form-label">Name</label>
                      <input type="text" name="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="required">
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Email address</label>
                        <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="required">
                        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                      </div>
                    <div class="mb-3">
                      <label for="exampleInputPassword1" class="form-label">Password</label >
                      <input type="password" name="pass" class="form-control" id="exampleInputPassword1" required="required">
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Contant Number</label>
                        <input type="text" name="contact" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="required">
                        <div id="emailHelp" class="form-text">We'll never share your Number with anyone else.</div>
                      </div> <br>
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <a class="btn btn-primary  shadow-lg  mx-5 " href="login.jsp" >Log In</a>
            </form>
        </div>
        <div class="col">
            <img src="images/login.png" alt="" height="480px" width="400px">
        </div>
    </section>
	
	<script type="text/javascript">
		
	var status = document.getElementById("status").value;
	if(status=="success"){
		 
	}
	</script>
</body>
</html>