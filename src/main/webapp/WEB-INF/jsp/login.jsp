<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ page isErrorPage="true"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
</head>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<body style="background-image: url('s'); background-repeat:no-repeat; background-size:cover;" >

   <div class="container" style="width:50%;">
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <img id="profile-img" alt="Image not loaded" style="margin-left:30%;" class="profile-img-card" src="src/main/webapp/resources/Nucleus_Logo.png"/>
            <p id="profile-name" class="profile-name-card"></p>
            <form action ="j_spring_security_check" class="form-signin" method="post">
            <p style="color:red; font-size:20px;">${ value }</p>
                <span id="reauth-email" class="reauth-email"></span>
                <input type="text" name="j_username" id="inputEmail" class="form-control" placeholder="Email address" name="email" value="${cookie.email.value}" required autofocus>
             
                <input type="text" name="j_password" id="inputPassword" class="form-control" placeholder="Password" name="password"  value="${cookie.password.value}" required autofocus>
                <div id="remember" class="checkbox">
                    <label>
                        <input type="checkbox" name="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>
              
            </form><!-- /form -->
            
            <a href="#" class="forgot-password">
                Forgot the password?
            </a>
        </div><!-- /card-container -->
    </div><!-- /container -->

</body>
</html>

