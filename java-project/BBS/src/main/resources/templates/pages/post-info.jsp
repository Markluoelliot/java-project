
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 添加设备支持 -->
<meta name="viewport" content="width=device-width,initial-scale=1">
<!-- bootStrap核心css -->
<link rel="stylesheet" href="../static/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../static/mycss/signin.css">
<!-- jquery文件在bootstrap.min.js之前引入 -->
<script src ="../static/jquery/jquery-3.3.1.js" type="text/javascript"></script>
<!-- bootstrap核心javascript文件 -->

<title>Insert title here</title>
</head>

<body>
  <h1>你好,${USER.nickname}</h1>
    <div class="container">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th width="20%" height="100">用户</th>
                    <th>内容</th>
                </tr>
                <tr>
                    <th width="20%" height="100">${post.id}</th>
                    <th>${post.content}</th>
                </tr>
            </thead>
            <tbody>
            <#if post?exists>
                <#list post.children as ps>
                    <tr>
                        <td width="20%" height="100">${ps.authorId}</td>
                        <td width="80%" height="100">${ps.content}</td>
                    </tr>
                </#list>
                
           </#if>
            </tbody>
        </table>
         <form action="/doReply" method="post" >
    <input type="hidden" name="md" value="doReply"/>
    <input type="hidden" name="pid" value="${post.id}">
    <div class="form-group">
        <textarea  class="form-control" name="content" rows="3" placeholder="内容" required></textarea>
    </div>
    <button type="submit" class="btn btn-default" >回帖</button>
    
    </form>
    
    </div>
  
     
  
</body>
</html>