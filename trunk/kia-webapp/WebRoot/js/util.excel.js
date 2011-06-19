Class.forName("Kia.util.excel");

Kia.util.excel.open=function(excelFileName){
    var xls=null;
    var newBook;
    try{
         xls = new ActiveXObject("Excel.Application");
        }catch(e){
        alert("请您打开ActiveX控件，具体操作：单击IE中的“工具”里“Internet 选项”，单击“安全”中的“自定义级别”中“ActiveX控件和插件”中，请选择第三项为启用即可。详细错误："+e.message);
        return ;
    } 
    if (xls == null){
     alert("创建Excel文件失败,可能是您的计算机上没有正确安装Microsoft Office Excel软件或浏览器的安全级别设置过高!");
     return;
    }
    try{
         newBook = xls.Workbooks.Open(excelFileName);//这里的Add方法里的参数是模板的路径
         }catch(e){
        alert("加载的Excel文件路径有错误!详细："+e.message);
        return ;
    } 
    return newBook;	
}