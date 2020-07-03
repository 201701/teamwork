		function startTime()   
            {   
                var today=new Date();//定义日期对象   
                var yyyy = today.getFullYear();//通过日期对象的getFullYear()方法返回年    
                var MM = today.getMonth()+1;//通过日期对象的getMonth()方法返回年    
                var dd = today.getDate();//通过日期对象的getDate()方法返回年     
                var hh=today.getHours();//通过日期对象的getHours方法返回小时   
                var mm=today.getMinutes();//通过日期对象的getMinutes方法返回分钟   
                var ss=today.getSeconds();//通过日期对象的getSeconds方法返回秒   
                // 如果分钟或小时的值小于10，则在其值前加0，比如如果时间是下午3点20分9秒的话，则显示15：20：09   
                MM=checkTime(MM);
                dd=checkTime(dd);
                mm=checkTime(mm);   
                ss=checkTime(ss);    
                var day; //用于保存星期（getDay()方法得到星期编号）
                if(today.getDay()==0)   day   =   "星期日 " 
                if(today.getDay()==1)   day   =   "星期一 " 
                if(today.getDay()==2)   day   =   "星期二 " 
                if(today.getDay()==3)   day   =   "星期三 " 
                if(today.getDay()==4)   day   =   "星期四 " 
                if(today.getDay()==5)   day   =   "星期五 " 
                if(today.getDay()==6)   day   =   "星期六 " 
                document.getElementById('nowDateTimeSpan').innerHTML=yyyy+"-"+MM +"-"+ dd + " " +hh+":"+mm+":"+ss+"   " + day;
                
                setTimeout('startTime()',1000);//每一秒中重新加载startTime()方法 
            }   
             
         function checkTime(i)   
            {   
                if (i<10){
                    i="0" + i;
                }   
                  return i;
            }  
        
        	 function disp_prompt()
				{
//					var str=prompt("请填写请假原因：");
//					if (str!=null)
//						{
//						document.form1.str.value=str;
//						document.form1.submit();
//						}
        		 	var reason = prompt("请填写请假原因：","");

//        		    $("input[type=text]").val(reason);
//        		    return reason;
        		 	
        		    location.href = '${pageContext.request.contextPath}/LeaveServlet?method=doLeave&beginTime=${s.beginTime}&endTime=${s.endTime}&reason='+reason;
				}
			
        	
        function suc()
        	{
//  			var str=prompt("请填写请假原因：");
//  			if(str){
        			alert("签到成功");
//  			}
			}
        
//      apiready = function(){
//  		var pageParam = api.pageParam;
//  		var id = pageParam.account_id;
//  		var username = pageParam.account_username;
//  		var nusername = document.getElementById("nusername");
//  		nusername.innerText = username;    //lable赋值不能用nusername.value，只能用innerText
//			var nid = document.getElementById("nid");
//  		nid.innerText = id;
//      }
        
//		$(function(){	//签到
//			$("#signin").click(function(){
//				//发送ajax请求
//		 		$.ajax({
//					url:"servlet/SignInOut?method=signIn",
//					type:"POST",
//					dataType:"text",
//					success:function(data){ //0 1 2
//						//显示签到的结果
//						if(data==0){
//							$("#result").html("签到失败");
//						}else if(data ==1){
//							$("#result").html("签到成功");
//						}else {
//							$("#result").html("已经签到，不能重复签到");
//						}
//					}
//				}); 
//			});
//		});
		
//		$(function(){
//			$("#signin").click(function(){
//			)};
//		});
//		
//		var TT = TAOTAO = {
//  		checkLogin : function(){
//      		var _ticket = $.cookie("TT_TOKEN");
//      		if(!_ticket){
//          		return ;
//      		}
//      	$.ajax({
//          	url : "http://localhost:8084/user/token/" + _ticket,
//          	dataType : "jsonp",
//          	type : "GET",
//          	success : function(data){
//              	if(data.status == 200){
//                  	var username = data.data.username;
//                  	var html = username + "，欢迎使用";
//                  	$("#loginbar").html(html);
//              	}
//          	}
//      	});
//  		}
//		}
//
//		$(function(){
//  		// 查看是否已经登录，如果已经登录查询登录信息
//  		TT.checkLogin();
//		});
		
        function popBox() {
	        var popBox = document.getElementById("popBox");
	        var popLayer = document.getElementById("popLayer");
	        popBox.style.display = "block";
	        popLayer.style.display = "block";
	    };
	 
	    /*点击关闭按钮*/
	    function closeBox() {
	        var popBox = document.getElementById("popBox");
	        var popLayer = document.getElementById("popLayer");
	        popBox.style.display = "none";
	        popLayer.style.display = "none";
	    }
