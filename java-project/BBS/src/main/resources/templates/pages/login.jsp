<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 添加设备支持 -->
<meta name="viewport" content="width=device-width,initial-scale=1">
<!-- bootStrap核心css -->
<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/mycss/signin.css">
<!-- jquery文件在bootstrap.min.js之前引入 -->
<script src ="/jquery/jquery-3.3.1.js" type="text/javascript"></script>
<!-- bootstrap核心javascript文件 -->
<script src="/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
    
</script>
<title>Insert title here</title>
</head>
<body>
    <div class="container">
      <form class="form-signin" action="/doList" method="post">
        <input type="hidden" name="md" value="doLogin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="username" id="inputEmail" class="form-control" name ="account" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" name ="password" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <button class="btn btn-lg btn-primary btn-block" onclick="window.location.href='/toRegister'">register </button>
    </form>

    </div> 
    <!-- /container -->   
    </div>
</body>
</html>