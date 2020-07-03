		function checkId(){
			var tid = document.getElementById("tid").value;
			var idspan = document.getElementById("idspan");
			var reg = /^[0-9]{2,11}$/i;
		
			var flag ;
			if(tid == ""){
				idspan.innerHTML = "  * 工号不能为空".fontcolor("red").fontsize("2px");
				flag = false;
			}else if(!reg.test(tid)){
				idspan.innerHTML = "  * 工只能是数字".fontcolor("red").fontsize("2px");
				flag = false;
			}else{
				idspan.innerHTML = "";
				flag = true;
			}
			return flag;
			
		}
		function checkNM(){
			var username = document.getElementById("username").value;
			var nmspan = document.getElementById("nmspan");
			var flag = false;
			if(username == ""){
				nmspan.innerHTML = "* 姓名不能为空".fontcolor("red").fontsize("2px");
				flag = false;
			}else{
				nmspan.innerHTML = "";
				flag = true;
			}
			return flag;
		}
		function checkForm(){
			if(checkId() && checkNM()){
				return true;
			}else{
				return false;
			}
		}
		
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
                document.getElementById('nowDateTimeSpan').innerHTML=yyyy+"-"+MM +"-"+ dd + " " +hh+":"+mm+":"+ss;
                
                setTimeout('startTime()',1000);//每一秒中重新加载startTime()方法 
            }   
             
            function checkTime(i)   
            {   
                if (i<10){
                    i="0" + i;
                }   
                  return i;
            }  
        
		