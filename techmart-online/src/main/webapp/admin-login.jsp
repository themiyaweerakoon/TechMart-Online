<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
<title>TechMart Online</title>
</head>
<body>

<a href="http://localhost:8080/techmart-online/welcome-techmart.jsp">TechMart Home</a>

<form class="container" name="login">
<section class="vh-100">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card shadow-2-strong" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center" style="background-color: #FFE87C;">

            <h3 class="mb-5">ADMIN LOGIN</h3>
		
            <div class="form-outline mb-4">
              <input type="text" id="adminId" name="adminId" class="form-control form-control-lg" />
              <label class="form-label" for="adminId">Username</label>
            </div>

            <div class="form-outline mb-4">
              <input type="password" id="adminPassword" name="adminPassword" class="form-control form-control-lg" />
              <label class="form-label" for="adminPassword">Password</label>
            </div>

            <button class="btn btn-info btn-lg btn-block" onclick="check(this.form)" value="Login">LOGIN</button>
		
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</form>

<script lang="javascript">
function check(form)
{

 if(form.adminId.value == "admin" && form.adminPassword.value == "12345")
  {
    window.open('admin-techmart.jsp')
  }
 else
 {
   alert("Error Password or Username")
  }
}
</script>

</body>
</html>