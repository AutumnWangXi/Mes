<#--noinspection ALL-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>公共表格</title>

    <style type="text/css">
        body {
            font-family: pingfang sc light;
        }

        .center {
            text-align: center;
            width: 100%;
        }

        table {
            word-break: break-all;
            word-wrap: break-word;
            border-collapse: collapse;
        }


        tr {
            page-break-before: always;
            page-break-after: always;
            page-break-inside: avoid;
        }

        td {
            text-align: center;
            border: 1px solid #000;
        }

        thead {
            display: table-row-group;
        }

        * {
        <#if fontSize??> font-size: ${fontSize!''}px;
        </#if>
        }
    </style>
</head>

<body <#if osName?? && osName == 'window' > style="font-family: '阿里巴巴普惠体 Light'"</#if>>
<#if publicTableParamList?? && (publicTableParamList?size > 0) >
<#list publicTableParamList as publicTableParams >
<#if publicTableParams_index == publicTableParamList?size-1>
<div style="width: 100%;" align="center">
    </#if>
    <#if publicTableParams_index < publicTableParamList?size-1>
    <div style="width: 100%;
    <#if publicTableParamList[0].topHtmlCode?index_of("药品执行单") == -1>
            page-break-after: always;
    </#if>
            "
    >
        </#if>

        <#assign name=""/>
        <#assign groupValue="">
        <#assign group="">
        <table width="100%" border="0" cellspacing="0">
            <tr>
                <#if publicTableParams.widthList?? && (publicTableParams.widthList?size > 0) >
                    <#list publicTableParams.widthList as widthList >
                        <td width="${widthList!''}%"></td>
                    </#list>
                </#if>
            </tr>
            <THEAD style="display:table-header-group;font-weight:bold;">
            <tr>
                <td <#if publicTableParams.lists?? && (publicTableParams.lists?size > 0) && publicTableParams.lists[0]??>
                    colspan="${publicTableParams.lists[0]?size}"
                </#if>
                        style="border: none"
                >
                    <h2 align="center">${(publicTableParams.title)!''}</h2>
                    ${(publicTableParams.topHtmlCode)!''}
                </td>
            </tr>


            <#if publicTableParams.lists?? && (publicTableParams.lists?size > 0) >
            <#list publicTableParams.lists as item >

            <tr>
                <#list item as itemSon >
                    <#if item??>
                        <#assign item="no">
                    </#if>
                    <#if itemSon_index == publicTableParams.groupIndex!9999>
                        <#assign groupSubIndex > ${itemSon?index_of("@")!9999}</#assign>
                        <#if  -1 != (itemSon?index_of("@")!9999)>
                            <#assign groupValue> ${itemSon?substring(0,itemSon?index_of("@")!9999)!''}</#assign>
                            <#assign group> ${itemSon?substring(itemSon?index_of("@")+1!9999,itemSon?length)!''}</#assign>
                        </#if>
                        <#if  -1 == (itemSon?index_of("@")!9999)>
                            <#assign groupValue> ${itemSon!''}</#assign>
                        </#if>

                    </#if>
                    <#if itemSon_index != publicTableParams.groupIndex!9999>
                        <#assign groupValue> ${itemSon!''}</#assign>
                    </#if>

                    <#if !item?seq_contains("合计")>

                        <td align="center">
                            <#if item_index == 0>
                                <strong>${itemSon!''}</strong>
                            </#if>
                            <#if item_index != 0>
                                <#if group?trim=="parent">
                                    <div style="border-top: 1px solid #707070;
                                                            border-left: 1px solid #707070;
                                                            width: 24px;
                                                            height: 15px;margin-top: 5px">
                                    </div>
                                </#if>
                                <#if group?trim=="subGroup">
                                    <div style="border-left: 1px solid #707070;
                                        display: inline;
                                        display: initial;
                                        margin-right: 11px;
                                        width: 24px;
                                        height: 15px;"></div>
                                </#if>
                                <#if group?trim=="lastGroup">
                                    <div style="border-bottom: 1px solid #707070;
                                                            border-left: 1px solid #707070;
                                                            width: 24px;
                                                            height: 15px;"></div>
                                    <br/>
                                </#if>
                                ${groupValue!''}
                            </#if>
                        </td>
                    </#if>
                    <#if item?seq_contains("合计")>
                        <#if itemSon == '合计' || name!=''>
                            <#if itemSon == '合计'>
                                <#assign name="合计"/>
                                <td colspan="${itemSon_index+1}" align="center">
                                    ${itemSon!''}
                                </td>
                            <#else>
                                <#assign name=""/>
                                <td align="center" colspan="${item?size} - ${item_index+1}">
                                    ${itemSon!''}
                                </td>

                            </#if>

                        </#if>
                    </#if>
                    <#assign groupValue="">
                    <#assign group="">
                </#list>
            </tr>
            <#if item_index ==0>
            </THEAD>
            </#if>
            </#list>
            </#if>
            <TFOOT style="display:table-footer-group;font-weight:bold">
            <tr>
                <td <#if publicTableParams.lists?? && (publicTableParams.lists?size > 0) && publicTableParams.lists[0]??>
                    colspan="${publicTableParams.lists[0]?size}"
                </#if>
                        style="border: 0"
                >
                    ${(publicTableParams.bottomHtmlCode)!''}
                </td>
            </tr>
            </TFOOT>
        </table>

    </div>
    </#list>
    </#if>

</body>
</html>
