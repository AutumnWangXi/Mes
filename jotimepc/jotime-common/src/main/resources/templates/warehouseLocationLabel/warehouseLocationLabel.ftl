<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>车间标签</title>
    <style type="text/css">

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
        <h4  align="center" >杭州云陌仟信息科技有限公司</h4>
        <table  width="100%" border="1" cellpadding="0" cellspacing="0">
            <tbody>



            <tr  >
                <th  style="width: 35%;" rowspan="5"><img  style="width: 90%;height: auto;" src="data:image/png;base64,${(item.note)!''}" /></th>

            </tr>
            <tr>
                <th   style="height:33px;"align="left"><h5 style="margin: 0;">&nbsp;库位名称：${(item.locationNoView)!''}</h5></th>
            </tr>
            <tr>
                <th   style="height:33px;"align="left"><h5 style="margin: 0;">&nbsp;库位编码：${(item.locationCode)!''}</h5></th>
            </tr>
            <tr>
                <th   style="height:33px;"align="left"><h5 style="margin: 0;">&nbsp;库区：${(item.areaName)!''}</h5></th>
            </tr>

            <tr>
                <th   style="height: 33px;"align="left"><h5 style="margin: 0;">&nbsp;存放品质类型：${(item.locationType)!''}</h5></th>
            </tr>

            </tbody>
        </table>

    </div>
    </#list>
    </#if>
</body>
</html>
