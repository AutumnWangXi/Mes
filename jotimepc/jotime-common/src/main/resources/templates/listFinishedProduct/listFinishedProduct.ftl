<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>成品入库</title>
    <style type="text/css">
        * {
            margin: 0px;
            padding: 0px;
        }

        table {
            border-collapse: collapse;
            border-style: solid;
            border-width: 1px;
        }

        td {
            border-style: solid;
            border-width: 1px;
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
        <table width="100%">
            <tr style="height: 25px">
                <td colspan="1" valign="middle"> 物料类型：${(item.orderType)!''}</td>
                <td colspan="1" valign="middle">物料编号：${(item.itemCode)!''}</td>
            </tr>
            <tr style="height: 25px">
                <td colspan="2" class="right"> 物料名称：${(item.itemName)!''}</td>
            </tr>
            <tr style="height: 25px">
                <td colspan="2" class="right"> 备注：${(item.note)!''}</td>
            </tr>
        </table>
        <table width="100%">
            </tr>
            <tr style="height: 25px">
                <td width="25%" rowspan="4" align="center" valign="middle">
                    <div style="height: 120px">
                        <br/>
                        <img style="width:85px;height:85px;"
                             src="data:image/png;base64,${(item.qrCode)!''}"/>
                    </div>
                </td>
                <td colspan="1" valign="middle"> 规格：${(item.specifications)!''}</td>
                <td colspan="1" valign="middle"> 单位：${(item.unit)!''}</td>
            </tr>
            <tr style="height: 25px">
                <td colspan="2" class="right">供应商：${(item.supplierName)!''}</td>
            </tr>
            <tr style="height: 25px">
                <td colspan="2" class="right">过期时间：<#if item?? && item.validDate??>${(item.validDate)?string("yyyy-MM-dd HH:mm:ss")!''}</#if>
                </td>
            </tr>
            <tr style="height: 25px">
                <td colspan="2" class="right">打印时间：${.now}</td>
            </tr>
        </table>
    </div>
    </#list>
    </#if>
</div>
</body>
</html>
