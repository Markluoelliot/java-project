
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
<script type="text/javascript">
    $(document).ready(function(){
    $("#tb tr").click(function(){
        var id =$(this).next("input").val();
        window.location.href="/toShow/"+id;
    })
    })
    function toEdit(id){
        alert(id);
    }
</script>
<body>
  <h1>你好,${USER.nickname}</h1>
</table>
    
    <form action="/doEdit/${post.id}" method="post" >
    
    <input type="hidden" name="postId" value="${post.id}">
    <div class="form-group">
        <input type="text" name="title" class="form-control" value =" ${post.title}" placeholder="标题" required="required">
    </div>
    <div class="form-group">
        <textarea  class="form-control" name="content" rows="3" placeholder="内容">${post.content}</textarea>
    </div>
    <button type="submit" class="btn btn-default" >发帖</button>
    
    </form>
  </div>
</body>
</html>