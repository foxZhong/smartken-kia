# 功能介绍 #

**通过传入json配置参数生成相应的数据增改表单，配合特定返回结果格式能实现友好提示**

## 依赖控件 ##
  1. jquery
  1. easyui

## 调用方式 ##

```
     var opts={};
     $("<div></div>").kiaCrudForm(opts);
```

## 传参方式 ##
**参数必须使用json对象方式传入,如下例**
```
     var opts={};
     opts["colNum"]=4;
```

## 参数列表 ##

|参数名|参数类型|参数描述|默认值|备注|
|:--|:---|:---|:--|:-|
|prefix|string|表单内的所有input的name添加前缀|"" |如，一个input name为age,配置prefix为“person.",input name就会变为"person.age"|
|colNum|int |表单的行数|2  |主要用于控制生成表单的宽度|
|urlSave|string|表单提交的地址|"" |提交方式为post|
|editors|array|表单的编辑器配置|[.md](.md)|参数实例子[{field:"CCatalog",title:"硬件类型",editor:{type:"text"},width:200},\n {field:"ICom",title:"硬件端口",editor:{type:"numberbox",options:{increment:10,precision:0,required:true}},width:200}] |
|data|json|表单的填充数据|{} |  |
