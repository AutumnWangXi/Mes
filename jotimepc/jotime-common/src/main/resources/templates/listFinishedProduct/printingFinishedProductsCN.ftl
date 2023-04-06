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
            font-size:65px;
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
        <h4 align="center" style="font-size:80px">成品标识牌</h4>
        <table width="100%">
            <tr style="height: 55px">
                <td colspan="1" align="center"> 产品型号：</td>
                <td colspan="1" align="center" width="70%"> ${(item.itemType)!''}</td>
            </tr>
            <tr style="height: 55px">
                <td colspan="1" align="center"> 客户代码：</td>
                <td colspan="1" align="center" width="70%"> ${(item.customerCode)!''}</td>
            </tr>
            <tr style="height: 55px">
                <td colspan="1" align="center"> 限用日期：</td>
                <td colspan="1" align="center" width="70%"> <#if item?? && item.validDate??>${(item.validDate)?string("yyyy-MM-dd HH:mm:ss")!''}</#if></td>
            </tr>
            <tr style="height: 55px">
                <td colspan="1" align="center">暗码批号：</td>
                <td colspan="1" align="center" width="70%">${(item.cnPo)!''}</td>
            </tr>
            <tr style="height: 55px">
                <td colspan="1" align="center">入库数量：</td>
                <td colspan="1" align="center" width="70%">${(item.total)!''}</td>
            </tr>
            <tr style="height: 55px">
                <td colspan="1" align="center">入库件数：</td>
                <td colspan="1" align="center" width="70%">${(item.ctn)!''}</td>
            </tr>
            <tr style="height: 55px;width:100%">

                <td colspan="1" align="center" width="30%"> 入库明细：
<#--                <td colspan="1" width="10%"> 整件数：${(item.cnHigh)!''}</td>-->
<#--                <td colspan="1" width="13.3%"> ${(item.cnHigh)!''}</td>-->
<#--                <td colspan="2" width="10%"> 单件数量：${(item.cnLayers)!''}</td>-->
<#--                <td colspan="2" width="13.3%"> ${(item.cnLayers)!''}</td>-->
<#--                <td colspan="3" width="10%"> 尾数：${(item.cnMantissa)!''}</td>-->
<#--                <td colspan="3" width="13.4%"> ${(item.cnMantissa)!''}</td>-->
                <td colspan="2" valign="middle" style="font-size:50px" align="center">整件数  ${(item.ctn)!''}  单件数量 ${(item.perCartonQty)!''}  尾数 ${(item.mantissa)!''} </td>
            </tr>
            <tr style="height: 55px">
                <td colspan="1" align="center">入库日期：</td>
                <td colspan="1" align="center" width="70%"></td>
            </tr>
        </table>
    </div>
    </#list>
    </#if>
</body>
</html>
