<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <style type="text/css">
        * {
            font-size: 20px;
            margin: 0px;
            padding: 0px;
        }

        * tr {
            height: 51px
        }
    </style>
</head>

<body style="font-family: '阿里巴巴-普惠体 Light'">
<div align="center"><strong style="font-size: 25px">打样单详情</strong></div>
<table width="100%" border="1" cellpadding="0" cellspacing="0">
    <tr>
        <td>打样单号：</td>
        <td align="center" valign="middle">${(rdDeptFormulatask.formulataskNo)!''}</td>
        <td align="center" valign="middle">申请日期：</td>
        <td align="center"
            valign="middle"><#if rdDeptFormulatask?? && rdDeptFormulatask.date??>${(rdDeptFormulatask.date)?string("yyyy-MM-dd")!''}</#if></td>
    </tr>
    <tr>
        <td>客户编号：</td>
        <td align="center" valign="middle">${(rdDeptFormulatask.customerCode)!''}</td>
        <td align="center" valign="middle">客户名称：</td>
        <td align="center"
            valign="middle">${(rdDeptFormulatask.customerName)!''}</td>
    </tr>
    <tr>
        <td width="20%">发单日期：</td>
        <td width="25%" align="center"
            valign="middle"><#if rdDeptFormulatask?? && rdDeptFormulatask.date??>${(rdDeptFormulatask.date)?string("yyyy-MM-dd")!''}</#if></td>
        <td width="20%" align="center" valign="middle">取样日期：</td>
        <td width="35%" align="center"
            valign="middle">
            <#if rdDeptFormulatask?? && rdDeptFormulatask.samplingDate??>${(rdDeptFormulatask.samplingDate)?string("yyyy-MM-dd")!''}</#if></td>
    </tr>
    <tr>
        <td>品牌名称：</td>
        <td colspan="3" align="center" valign="middle">${(rdDeptFormulatask.brand)!''}</td>
    </tr>
    <tr>
        <td>申请人：</td>
        <td colspan="3" align="center" valign="middle">${(rdDeptFormulatask.salesmanCode)!''}</td>
    </tr>

    <tr>
        <td>样品名称：</td>
        <td colspan="3" align="center" valign="middle">${(rdDeptFormulatask.itemName)!''}</td>
    </tr>
    <tr>
        <td width="20%">样品类型：</td>
        <td width="25%" align="center" valign="middle">${(rdDeptFormulatask.formulaType)!''}</td>
        <td width="20%">样品剂型：</td>
        <td width="35%" align="center" valign="middle">${(rdDeptFormulatask.formulaDosage)!''}</td>
    </tr>
<#--    <tr>-->
<#--        <td>样品类型：</td>-->
<#--        <td colspan="3" align="center" valign="middle">${(rdDeptFormulatask.formulaType)!''}</td>-->
<#--    </tr>-->
<#--    <tr>-->
<#--        <td>样品剂型：</td>-->
<#--        <td colspan="3" align="center" valign="middle">${(rdDeptFormulatask.formulaDosage)!''}</td>-->
<#--    </tr>-->
    <tr>
        <td>开发背景：</td>
        <td colspan="3" align="center" valign="middle">${(rdDeptFormulatask.devBackground)!''}</td>
    </tr>
    <tr>
        <td>销售地区：</td>
        <td colspan="3" align="center" valign="middle">${(rdDeptFormulatask.salesDistrict)!''}</td>
    </tr>
    <tr>
        <td>销售渠道：</td>
        <td colspan="3" align="center" valign="middle">${(rdDeptFormulatask.salesChannelList)!''}</td>
    </tr>
    <tr>
        <td>打样类型：</td>
        <td colspan="3" align="center" valign="middle">${(rdDeptFormulatask.formulaMethod)!''}</td>
    </tr>
    <tr>
        <td width="20%">目标人群：</td>
        <td width="25%" align="center" valign="middle">${(rdDeptFormulatask.applUser)!''}</td>
        <td width="20%">适用肌肤：</td>
        <td width="35%" align="center" valign="middle">${(rdDeptFormulatask.applSkinType)!''}</td>
    </tr>
<#--    <tr>-->
<#--        <td>目标人群：</td>-->
<#--        <td colspan="3" align="center" valign="middle">${(rdDeptFormulatask.applUser)!''}</td>-->
<#--    </tr>-->
<#--    <tr>-->
<#--        <td>适用肌肤：</td>-->
<#--        <td colspan="3" align="center" valign="middle">${(rdDeptFormulatask.applSkinType)!''}</td>-->
<#--    </tr>-->
        <td>使用部位：</td>
        <td colspan="3" align="center" valign="middle">${(rdDeptFormulatask.usedPart)!''}</td>
    </tr>
    <tr>
        <td>使用功效要求：</td>
        <td colspan="3" align="center" valign="middle">${(rdDeptFormulatask.usedEfficacyReqlist)!''}</td>
    </tr>
    <tr>
        <td>配方特殊要求：</td>
        <td colspan="3" align="center" valign="middle">${(rdDeptFormulatask.specificaReqlist)!''}</td>
    </tr>
    <tr>
        <td>颜色&amp;香型：</td>
        <td colspan="3" align="center" valign="middle">${(rdDeptFormulatask.colorAndFlavor)!''}</td>
    </tr>
    <tr>
        <td>容器类型：</td>
        <td colspan="3" align="center" valign="middle">${(rdDeptFormulatask.containerType)!''}</td>
    </tr>
    <tr>
        <td>成品容量：</td>
        <td colspan="3" align="center" valign="middle">${(rdDeptFormulatask.finishProductVolumes)!''}</td>
    </tr>
    <tr>
        <td width="20%">成品预计售价：</td>
        <td width="25%" align="center" valign="middle">${(rdDeptFormulatask.erpCustomer)!''}</td>
        <td width="20%">内料预计单价：</td>
        <td width="35%" align="center" valign="middle">${(rdDeptFormulatask.interMaterialsPrice)!''}</td>
    </tr>
<#--    <tr>-->
<#--        <td>成品预计售价：</td>-->
<#--        <td colspan="3" align="center" valign="middle">${(rdDeptFormulatask.erpCustomer)!''}</td>-->
<#--    </tr>-->
<#--    <tr>-->
<#--        <td>内料预计单价：</td>-->
<#--        <td colspan="3" align="center" valign="middle">${(rdDeptFormulatask.interMaterialsPrice)!''}</td>-->
<#--    </tr>-->
    <tr>
        <td>其他要求(说明)：</td>
        <td colspan="3" align="center" valign="middle">${(rdDeptFormulatask.note)!''}</td>
    </tr>
    <tr>
        <td>样品包装方式：</td>
        <td colspan="3" align="center" valign="middle">${(rdDeptFormulatask.packing)!''}</td>
    </tr>
<#--    <tr>-->
<#--        <td width="20%">样品容量：</td>-->
<#--        <td width="25%" align="center" valign="middle">${(rdDeptFormulatask.formulaVolumes)!''}</td>-->
<#--        <td width="20%">样品数量：</td>-->
<#--        <td width="35%" align="center" valign="middle">${(rdDeptFormulatask.formulaQty)!''}</td>-->
<#--    </tr>-->
    <tr>
        <td>样品数量：</td>
        <td colspan="3" align="center" valign="middle">${(rdDeptFormulatask.formulaQty)!''}</td>
    </tr>

</table>
</body>
</html>
