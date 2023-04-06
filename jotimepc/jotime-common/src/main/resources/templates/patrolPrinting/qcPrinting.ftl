<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>质检打印</title>
    <style type="text/css">

    </style>
</head>

<body>
<h2 align="center">巡检打印</h2>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="12%" align="right">订单号：</td>
        <td width="23%">${map.orderNo!}</td>
        <td width="12%" align="right">客户编号：</td>
        <td width="23%">${map.customerCode!}</td>
        <td width="10%" align="right">到货日期：</td>
        <td width="20%">${map.arrivalDate!}</td>
    </tr>
    <tr>
        <td align="right">产品名称：</td>
        <td>${map.productName!}</td>
        <td align="right">供应商：</td>
        <td>${map.supplierName!}</td>
        <td align="right">到货数量：</td>
        <td>${map.arrivalQty!}</td>
    </tr>
    <tr>
        <td align="right">物料编码：</td>
        <td>${map.itemCode!}</td>
    </tr>

</table>
<br/>
<#if (map.tableList?size>0)>
    <#list map.tableList as item>
        <table width="100%" border="1" cellpadding="0" cellspacing="0">
            <tr bgcolor="#f2f2f1">
                <#list item.cols as title>
                    <td align="center">${title.label}</td>
                </#list>
            </tr>
            <#list item.data as content>
                <tr>
                    <#if (item.cols?size >= 1) >
                        <td align="center">${content.content1!}</td>
                    </#if>
                    <#if (item.cols?size >= 2) >
                        <td align="center">${content.content2!}</td>
                    </#if>
                    <#if (item.cols?size >= 3) >
                        <td align="center">${content.content3!}</td>
                    </#if>
                    <#if (item.cols?size >= 4) >
                        <td align="center">${content.content4!}</td>
                    </#if>
                    <#if (item.cols?size >= 5) >
                        <td align="center">${content.content5!}</td>
                    </#if>
                    <#if (item.cols?size >= 6) >
                        <td align="center">${content.content6!}</td>
                    </#if>
                    <#if (item.cols?size >= 7) >
                        <td align="center">${content.content7!}</td>
                    </#if>
                    <#if (item.cols?size >= 8) >
                        <td align="center">${content.content8!}</td>
                    </#if>
                    <#if (item.cols?size >= 9) >
                        <td align="center">${content.content9!}</td>
                    </#if>
                    <#if (item.cols?size >= 10) >
                        <td align="center">${content.content10!}</td>
                    </#if>
                </tr>
            </#list>
        </table>
    </#list>
</#if>
<p>结论：${map.qcResult!}</p>

</body>
</html>
