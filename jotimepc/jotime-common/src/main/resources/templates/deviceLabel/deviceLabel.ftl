<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>设备标签</title>
    <style type="text/css">
    .box { font-size: 3vw;}
        .right {
            border-right: none;
        }

        .left {
            border-left: none;
        }

        /** tr {*/
        /*    height: 30px*/
        /*}*/

        /** td {*/
        /*    border: 1px solid;*/
        /*}*/
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
        <h4 align="center" style="margin-bottom: 30px">杭州云陌仟信息科技有限公司</h4>

        <table style="margin-top: -20px" width="100%" border="1" cellpadding="0" cellspacing="0">
            <tbody>
            <tr>
                <th  style=" width: 35%;" rowspan="6"><img  style="width: 90%; height: auto;" src="data:image/png;base64,${(item.qrCode)!''}" /></th>
                <th  style="height: 20px;" align="left"><font style="font-size: 13px">&nbsp;设备名称：${(item.deviceName)!''}</font></th>
            </tr>
            <tr>
                <th  style="height: 20px;" align="left"><font style="font-size: 13px">&nbsp;设备编码：${(item.deviceCode)!''}</font></th>
            </tr>
            <tr>
                <th  style="height: 20px;" align="left"><font style="font-size: 13px">&nbsp;设备类型：${(item.deviceType)!''}</font></th>
            </tr>
            <tr>
                <th style="height: 20px;" align="left"><font style="font-size: 13px">&nbsp;设备组：${(item.deviceGroup)!''}</font></th>
            </tr>
            <tr>
                <th class="box" style="height: 20px;" align="left"><font style="font-size: 13px">&nbsp;车间：${(item.workshopName)!''}</font></th>

            </tr>
            <tr>
                <th class="box" style="height: 20px;" align="left"><font style="font-size: 13px">&nbsp;流水线：${(item.lineName)!''}</font></th>

            </tr>

            </tbody>
        </table>


<#--        <div style="margin: 3%;" align="center">-->
<#--            <h3 align="center">杭州云陌仟信息科技有限公司</h3>-->
<#--            <HR align=center width=100% color=#987cb9 SIZE=1>-->
<#--            <table  width="100%">-->
<#--                <tr>-->
<#--                    <th >&nbsp;</th>-->
<#--                </tr>-->
<#--                <tr>-->
<#--                    <th  class="box"   style="width: 20%;" align="right">设备编码：</th>-->
<#--                    <th   class="box"  style="width: 30%;">${(item.deviceCode)!''}</th>-->
<#--                    <th   colspan="2" width="50%" rowspan="7"  style="height: 1.25rem;">-->
<#--                        <img  style="width: 60%; height: auto;" src="data:image/png;base64,${(item.qrCode)!''}" />-->
<#--                    </th>-->
<#--                </tr>-->
<#--                <tr>-->
<#--                    <th   class="box"  align="right">设备名称：</th>-->
<#--                    <th   class="box" >${(item.deviceName)!''}</th>-->
<#--                </tr>-->
<#--                <tr>-->
<#--                    <th   class="box" align="right">设备类型：</th>-->
<#--                    <th   class="box" >${(item.deviceType)!''}</th>-->
<#--                </tr>-->
<#--                <tr>-->
<#--                    <th class="box"   align="right">设备组：</th>-->
<#--                    <th   class="box">${(item.deviceGroup)!''}</th>-->
<#--                </tr>-->
<#--                <tr>-->
<#--                    <th class="box"   align="right">车间：</th>-->
<#--                    <th   class="box">${(item.workshopName)!''}</th>-->
<#--                </tr>-->
<#--                <tr>-->
<#--                    <th class="box" align="right">流水线：</th>-->
<#--                    <th   class="box" >${(item.lineName)!''}</th>-->
<#--                </tr>-->
<#--                <tr>-->
<#--                    <th class="box" align="right">最新保养时间：</th>-->
<#--                    <th   class="box" >${(item.maintenanceDate)?string("yyyy-MM-dd HH:mm:ss")!''}</th>-->
<#--                </tr>-->
<#--            </table>-->
<#--        </div>-->


</div>

<#--        <h3 align="center">杭州云陌仟信息科技有限公司</h3>-->
<#--        <table width="100%" border="1" cellpadding="0" cellspacing="0" align="center">-->
<#--            <tr>-->
<#--                <td width="50%" class="right">id：${(item.id)!''}</td>-->
<#--                <td class="left" width="50%">设备名称：${(item.deviceName)!''}</td>-->
<#--            </tr>-->
<#--            <tr>-->
<#--                <td class="right">设备规格：${(item.deviceModel)!''}</td>-->
<#--                <td class="left">设备分组：${(item.deviceGroup)!''}</td>-->
<#--            </tr>-->
<#--&lt;#&ndash;            <tr>&ndash;&gt;-->
<#--&lt;#&ndash;                <td class="right" style="border-bottom: none">备注：${(item.note)!''}</td>&ndash;&gt;-->
<#--&lt;#&ndash;                <td class="left" style="border-bottom: none">供应商批次号：${(item.stdBatchNo)!''}</td>&ndash;&gt;-->
<#--&lt;#&ndash;            </tr>&ndash;&gt;-->

<#--        </table>-->
<#--        <table width="100%" border="1" cellpadding="0" cellspacing="0" align="center">-->
<#--            <tr>-->
<#--                <td width="25%" rowspan="4" align="center" valign="middle">-->
<#--                    <img style="width:80%;height:auto;"-->
<#--                         src="data:image/png;base64,${(item.qrCode)!''}"/>-->
<#--                </td>-->
<#--&lt;#&ndash;                <td width="46%" class="right">规格：${(item.specifications)!''}</td>&ndash;&gt;-->
<#--&lt;#&ndash;                <td width="24%" class="left">单位：${(item.unit)!''}</td>&ndash;&gt;-->
<#--            </tr>-->
<#--&lt;#&ndash;            <tr>&ndash;&gt;-->
<#--&lt;#&ndash;                <td colspan="2" class="right">供应商：${(item.supplierName)!''}</td>&ndash;&gt;-->
<#--&lt;#&ndash;            </tr>&ndash;&gt;-->
<#--&lt;#&ndash;            <tr>&ndash;&gt;-->
<#--&lt;#&ndash;                <td colspan="2" class="right">过期时间：${(item.validDate)?string("yyyy-MM-dd HH:mm:ss")!''}</td>&ndash;&gt;-->
<#--&lt;#&ndash;            </tr>&ndash;&gt;-->
<#--&lt;#&ndash;            <tr>&ndash;&gt;-->
<#--&lt;#&ndash;                <td colspan="2" class="right">打印时间：${.now}</td>&ndash;&gt;-->
<#--&lt;#&ndash;            </tr>&ndash;&gt;-->
<#--        </table>-->
<#--    </div>-->

    </#list>
    </#if>
</body>
</html>
