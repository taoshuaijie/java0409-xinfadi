<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/echarts.common.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div id="main" style="width:900px;height:700px"></div>

<script type="text/javascript">
var mychart=echarts.init(document.getElementById('main'));

var option={
   title:{
     text:'猪板油价格走势图'
   },
   xAxis:{
      data:[]
   },
   yAxis:{},
   series:[{
      name:'最低价格',
      type:'line',
      data:[]
   },{
      name:'平均价格',
      type:'line',
      data:[]
   },{
      name:'最高价格',
      type:'line',
      data:[]
   }]
};

mychart.setOption(option);

//显示加载动画
mychart.showLoading();
var lowprices=[];
var avgprices=[];
var hprices=[];
var dates=[];
//发出ajax请求
$.ajax({
   type:'post',
   url:'getlist',
   data:{beginDate:'2018-07-29',endDate:'2018-08-14'},
   dataType:'json',
   success:function(result){
     if(result){
        for(var i=0;i<result.length;i++){
          lowprices.push(result[i].minPrice);
          avgprices.push(result[i].avgPrice);
          hprices.push(result[i].maxPrice);
          var time=new Date(result[i].pubDate);
          var y=time.getFullYear();
          var m=time.getMonth()+1;
          var d=time.getDate();
          dates.push(y+'-'+m+'-'+d);
        }
        //隐藏加载动画
        mychart.hideLoading();
        //配置echarts图表，数据
        mychart.setOption({
          xAxis:{
            data:dates
          },
          series:[{
              name:'最低价格',
            type:'line',
            data:lowprices          
          },{
      name:'平均价格',
      type:'line',
      data:avgprices
   },{
      name:'最高价格',
      type:'line',
      data:hprices
   }]
        
        });
     }
   }
})

</script>
</body>
</html>