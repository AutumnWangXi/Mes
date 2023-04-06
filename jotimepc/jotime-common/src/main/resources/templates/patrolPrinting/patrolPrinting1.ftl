<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>巡检打印</title>
    <style type="text/css">

    </style>
</head>

<body>
<h2 align="center">巡检打印</h2>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="15%" align="right">生产通知单号：</td>
        <td width="42%">${map.orderNo!}</td>
        <td width="22%" align="right">合同订单号：</td>
        <td width="21%">${map.contractorderNo!}</td>
    </tr>
    <tr>
        <td align="right">产品名称：</td>
        <td>${map.productName!}</td>
        <td align="right">内料批次号：</td>
        <td>20220222</td>
    </tr>
    <tr>
        <td align="right">客户编号：</td>
        <td>${map.customerCode!}</td>
        <td align="right">巡检日期：</td>
        <td>${map.qualityStartTime!}</td>
    </tr>
</table>
<br/>
<#if (map.tableList?size >= 1)>
    <#list map.tableList as item >
        <table border="0" style="width:100%">
            <tr>
                <td width="41%">${item.tableName!}</td>
                <td width="26%">检验员：${map.qualityName!}</td>
                <td width="33%">检验时间：${map.qualityStartTime!}</td>
            </tr>
        </table>
        <#if item.dispalyMode == 'row' >
            <table width="100%" border="1" cellpadding="0" cellspacing="0">
                <tr bgcolor="#f2f2f1">
                    <#list item.cols as title>
                        <td align="center">${title.label!}</td>
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
        </#if>

        <#if item.dispalyMode == 'line' >
            <table width="100%" border="1" cellpadding="0" cellspacing="0">
                <#list item.data as content>
                    <tr>
                        <td align="center">${content.title!}</td>
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
        </#if>
        <br/>
    </#list>
</#if>
</body>
</html>
