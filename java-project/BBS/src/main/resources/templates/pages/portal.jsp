
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

<title>Insert title here</title>
</head>
<script type="text/javascript">
    
    function toshowthetitle(id){
    	alert(id)
    	window.location.href="/toShow/"+id;
    }
    function toEdit(id){
    	
    	window.location.href="/toEdit/"+id;
    }
    function doDel(id){
    
    	var flag = confirm('确认删除？')
    	if(!flag){
    		return false;
    	}
    	window.location.href="/doDel/"+id;
    }
</script>
<body>
  <h1>你好,${USER.nickname}</h1>

  <div class="bs-example" data-example-id="simple-table">
    <table class="table">
      
      <thead>
        <tr>
          <th>编号</th>
          <th>标题</th>
          <th>内容</th>
          <th>发帖人</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody id="tb">
        <!-- items是request中取得的量 -->
         <#if list?exists>
         <#list list as value>
            
                 <tr class="info">
                <td>${value.id}</td>
                
                <td>
                    <input type="hidden" name="pid" value="${value.id}">
                    <a href="#" onclick="toshowthetitle(${value.id})">${value.title}</a>
                </td>
               
                
                <td>${value.content}</td>
                
               <!-- -->
                <td>${value.authorId}</td>
                <td><button type="button" class="btn btn-default btn-sm" onclick="toEdit(${value.id})">修改</button>
                    <button type="button" class="btn btn-default btn-sm" name="del" onclick="doDel(${value.id})">删除</button>
                </td>
             </tr>
         
        </#list>
        </#if>
      </tbody>
    </table>
    
    <form action="/doPublish" method="post" >
    
    <div class="form-group">
        <input type="text" name="title" class="form-control" placeholder="标题" required="required">
    </div>
 
    <div class="form-group">
        <textarea  class="form-control" name="content" rows="3" placeholder="内容"></textarea>
    </div>
    <button type="submit" class="btn btn-default" >发帖</button>
    
    </form>
  </div>

</body>
</html>