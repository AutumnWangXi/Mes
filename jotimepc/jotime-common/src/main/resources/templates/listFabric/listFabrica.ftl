<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>预处理料入库</title>
    <style type="text/css">
        *{
            margin: 0px;
            padding: 0px;
        }
        table{
            border-collapse:collapse;border-style: solid;border-width: 1px;
        }
        td{
            border-style: solid;border-width: 1px;
        }
    </style>
</head>

<body <#if osName?? && osName == 'window' > style="font-family: '阿里巴巴普惠体 Light';font-size: 12px"</#if>>
<#if list?? && (list?size > 0) >
<#list list as item >
<#if item_index == list?size-1>
<div align="center">
    </#if>
    <#if item_index < list?size-1>
    <div style="page-break-after: always;">
        </#if>
        <div style="float:left">客户编号: ${(item.customerCode)!''}</div>
        <br/>
        <div style="float:left">产品名称：${(item.pItemName)!''}</div>
        <table  width="100%">
            <tr style="height: 20px">
                <td width="25%" rowspan="6" align="center" valign="middle">
                    <div style="height: 120px">
                        <br/>
                        <img style="width:85px;height:85px;"
                             src="data:image/png;base64,${(item.qrCode)!''}"/>
                    </div>
                </td>
                <td colspan="2" class="right" valign="middle"> 物料编号：${(item.itemCode)!''}</td>
            </tr>
            <tr style="height: 20px">
                <td colspan="2" class="right" valign="middle"> 物料名称：${(item.itemName)!''}</td>
            </tr>
            <tr style="height: 20px">
                <td colspan="2" class="right"> 制料批次号：${(item.batchNo)!''}</td>
            </tr>
            <tr style="height: 20px">
                <td style="height: 10px" colspan="1" class="right" valign="middle"> 重量：${(item.netWeight)!''}</td>
            </tr>
        </table>
        <div style="float:left"><span>生产任务编号:${(item.originOrderNo)!''}</span></div>
        <br/>
        </#list>
        </#if>
</body>
</html>
