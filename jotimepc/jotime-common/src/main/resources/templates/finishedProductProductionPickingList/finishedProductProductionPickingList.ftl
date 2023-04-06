<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>成品生产领料单</title>
    <style type="text/css">

    </style>
</head>

<body <#if osName?? && osName == 'window' > style="font-family: '阿里巴巴普惠体 Light'"</#if>>
<#if maps?? && (maps?size > 0) >
<#list maps as item >
<#if item_index == maps?size-1>
<div style="width: 100%;">
    </#if>
    <#if item_index < maps?size-1>
    <div style="width: 100%;page-break-after: always;">
        </#if>
        <h2 align="center">成品生产领料单</h2>
        <div>
            <div style="float:left"><img src="data:image/png;base64,${(item.qrCode)!''}"
                                         style="width:50px;height:50px;margin-top: -54%;"/></div>
            <div style="float:right">生产通知单编号：${(item.orderNo)!''}</div>
        </div>
        <br/>
        <hr/>
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td width="9%" valign="middle">客户名称：</td>
                <td width="58%" valign="middle">${(item.null)!''}</td>
                <td width="15%" align="right" valign="middle">合同订单号(PO)：</td>
                <td width="18%" valign="middle">${(item.null)!''}</td>
            </tr>
            <tr>
                <td valign="middle">产品名称：</td>
                <td valign="middle">${(item.itemName)!''}</td>
                <td align="right" valign="middle">产品类型：</td>
                <td valign="middle">${(item.itemType)!''}</td>
            </tr>
            <tr>
                <td valign="middle">制造商：</td>
                <td valign="middle">${(item.null)!''}</td>
                <td align="right" valign="middle">任务单编号：</td>
                <td valign="middle">${(item.null)!''}</td>
            </tr>
        </table>
        <br/>
        成品生产领料单
        <table width="100%" border="1" cellpadding="0" cellspacing="0">
            <tr>
                <td align="center" valign="middle">序号</td>
                <td align="center" valign="middle">产品编号</td>
                <td align="center" valign="middle">产品名称</td>
                <td align="center" valign="middle">出库数量</td>
                <td align="center" valign="middle">产品条形码</td>
            </tr>
            <#if item.stockoutOrderMergeVos?? && (item.stockoutOrderMergeVos?size > 0) >
                <#list item.stockoutOrderMergeVos as itemSon >
                    <tr>
                        <td align="center" valign="middle">${(item_index+1)!''}</td>
                        <td align="center" valign="middle">${(itemSon.itemCode)!''}</td>
                        <td align="center" valign="middle">${(itemSon.itemName)!''}</td>
                        <td align="center" valign="middle">${(itemSon.plannedStockoutQty)!''}</td>
                        <td align="center" valign="middle">${(itemSon.barCode)!''}</td>
                    </tr>
                </#list>
            </#if>
        </table>
    </div>
    </#list>
    </#if>
</body>
</html>
