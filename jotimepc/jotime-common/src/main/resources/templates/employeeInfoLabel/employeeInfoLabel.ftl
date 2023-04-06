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
            <h4 align="center" >杭州云陌仟信息科技</h4>
            <table  width="100%" border="1" cellpadding="0" cellspacing="0">
                <tbody>
                <tr>
                    <th  style="width: 30%;" rowspan="4">照片</th>
                    <th style="height: 33px; margin: 0" align="left">&nbsp;员工名称：${(item.employeeName)!''}</th>
                    <th rowspan="2"><img  width="60px" height="60px" src="data:image/png;base64,${(item.attachmentUrl)!''}" /></th>
                </tr>
                <tr>
                    <th   style="height: 33px; margin: 0" align="left">&nbsp;编码：${(item.employeeCode)!''}</th>
                </tr>
                <tr>
                    <th colspan="2"  style="height: 33px; margin:  0"align="left">&nbsp;车间：${(item.updateBy)!''}</th>
                </tr>
                <tr>
                    <th colspan="2"  style="height: 33px; margin: 0"align="left" >&nbsp;职务：${(item.createBy)!''}</th>
                </tr>
                </tbody>
            </table>
            </tbody>
        </table>
    </div>
    </#list>
    </#if>
</body>
</html>
