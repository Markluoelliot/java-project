<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
   function importAll(){
	  $.get("/search/importAll","",function(data){
	   if(data.status == 200){
		   $.messager.alert('提示','新增内容成功');
		   alert("231")
		  
		   
	   }else{
		   $.messager.alert('提示',data.msg);
	   } 
	  }); 
   }    
</script>
<div>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="importAll()">导入数据到索引库</a>
</div>
