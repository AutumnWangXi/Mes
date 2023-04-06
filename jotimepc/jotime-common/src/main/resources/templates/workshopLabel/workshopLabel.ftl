<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>车间标签</title>
    <style type="text/css">
        .box { font-size: 1vw;}
    </style>
</head>

<body <#if osName?? && osName == 'window' > style="font-family: '阿里巴巴普惠体 Light'"</#if>>
<#if list?? && (list?size > 0) >
<#list list as item >
<#if item_index == list?size-1>
<div align="center">
    </#if>
    <#if item_index < list?size-1>
    <div style="page-break-after: always;">
        </#if>
        <h4 align="center" style="margin-bottom: 10px">杭州云陌仟信息科技有限公司</h4>
        <table  width="100%" border="1" cellpadding="0" cellspacing="0">
            <tbody>
            <tr>
                <th  style=" width: 35%;" rowspan="5"><img  style="width: 90%; height: auto;" src="data:image/png;base64,${(item.note)!''}" /></th>
                <th  style="height: 30px;" align="left"><h5 style="margin: 0;">&nbsp;&nbsp;车间名称：${(item.workshopName)!''}</h5></th>
            </tr>
            <tr>

                <th  style="height: 30px;" align="left"><h5 style="margin: 0;">&nbsp;&nbsp;编码：${(item.workshopCode)!''}</h5></th>
            </tr>
            <tr>

                <th  style="height: 30px;" align="left"><h5 style="margin: 0;">&nbsp;&nbsp;部门：${(item.deptName)!''}</h5></th>
            </tr>
            <tr>

                <th  style="height: 30px;" align="left"><h5 style="margin: 0;">&nbsp;&nbsp;负责人：${(item.leaderName)!''}</h5></th>
            </tr>
            <tr>

                <th  style="height: 30px;" align="left"><h5 style="margin: 0;">&nbsp;&nbsp;描述：${(item.description)!''}</h5></th>
            </tr>



<#--            <tr>-->
<#--                <th  style=" width: 30%;" rowspan="4"><img  style="width: 90%; height: auto;" src="data:image/png;base64,${(item.note)!''}" /></th>-->
<#--                <th  style="height: 23px;" align="left">车间编码：${(item.workshopCode)!''}</th>-->
<#--            </tr>-->
<#--            <tr>-->
<#--                <th  style="height: 23px;" align="left">部门：${(item.deptId)!''}</th>-->
<#--            </tr>-->
<#--            <tr>-->
<#--                <th style="height: 23px;" align="left">负责人：${(item.leaderId)!''}</th>-->
<#--            </tr>-->
<#--            <tr>-->
<#--                <th class="box" style="height: 30px;" align="left">车间描述：${(item.description)!''}</th>-->

<#--            </tr>-->
            </tbody>
        </table>
    </div>
    </#list>
    </#if>
</body>
</html>
