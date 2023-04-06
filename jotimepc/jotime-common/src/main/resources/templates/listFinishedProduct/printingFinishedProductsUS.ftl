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
            border-style: none;
            border-width: 1px;
        }

        td {
            font-size:75px;
            border-style: none;
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
            <h4 align="center" style="font-size:80px">杭州云陌仟信息科技有限公司</h4>
            <table width="100%">
                <tr style="height: 20px">
                    <td colspan="3" valign="middle">  Pallet #： ${(item.pallet)!''}</td>
                    <td colspan="1" valign="middle" style="font-size:40px"> ${(item.meters)!''}</td>
                </tr>
                <tr style="height: 20px">
                    <td colspan="3" valign="right"> ITEM#：${(item.item)!''}</td>
                    <td width="25%" rowspan="4" align="center" valign="middle">
                        <div style="height: 120px">
                        </div>
                    </td>
                </tr>
                <tr style="height: 20px">
                    <td colspan="4" valign="right">PO#：${(item.po)!''}</td>

                </tr>
                <tr style="height: 20px">
                    <td colspan="4" class="right"> LOT#：${(item.lot)!''}</td>

                </tr>
                <tr style="height: 20px">
                    <td colspan="4" class="right"> CTN#：${(item.ctn)!''}</td>
                </tr>
                <tr style="height: 20px">
                    <td colspan="3" valign="middle"> QTY#：${(item.total)!''}</td>
                    <td colspan="1" valign="middle"> ${(item.supplierName)!'PCS'}</td>
                </tr>
                <tr style="height: 20px">
                    <td colspan="1" valign="middle"> TIHI：&nbsp
                    </td>
                    <td colspan="2" valign="middle" style="font-size:40px">Layers  ${(item.layers)!''}  High ${(item.high)!''}  Mantissa ${(item.mantissa)!''} </td>
                    <td colspan="1" valign="middle" style="font-size:40px">${(item.locationNoView)!''}</td>
                </tr>
            </table>
        </div>
    </#list>
</#if>
</div>
</body>
</html>
