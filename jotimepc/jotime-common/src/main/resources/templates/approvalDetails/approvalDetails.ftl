<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>审批详情</title>
    <style type="text/css">
        * {
            font-size: 20px
        }

        * tr {
            height: 51px
        }
    </style>
</head>

<body style="font-family: '阿里巴巴-普惠体 Light'">
<h2 align="center"><strong style="font-size: 30px">打样单详情</strong></h2>
<table width="100%" border="1" cellpadding="0" cellspacing="0">
    <tr>
        <td>打样单号：</td>
        <td align="center" valign="middle">${(apvlFormulaVo.formulataskNo)!''}</td>
        <td align="center" valign="middle">申请日期：</td>
        <td align="center"
            valign="middle"><#if apvlFormulaVo?? && apvlFormulaVo.proposeTime??>${(apvlFormulaVo.proposeTime)?string("yyyy-MM-dd HH:mm:ss")!''}</#if></td>
    </tr>
    <tr>
        <td>客户编号：</td>
        <td align="center" valign="middle">${(apvlFormulaVo.customerCode)!''}</td>
        <td align="center" valign="middle">客户名称：</td>
        <td align="center"
            valign="middle">${(apvlFormulaVo.customerName)!''}</td>
    </tr>
    <tr>
        <td width="20%">发单日期：</td>
        <td width="25%" align="center"
            valign="middle"><#if apvlFormulaVo?? && apvlFormulaVo.issueDate??>${(apvlFormulaVo.issueDate)?string("yyyy-MM-dd HH:mm:ss")!''}</#if></td>
        <td width="20%" align="center" valign="middle">取样日期：</td>
        <td width="35%" align="center"
            valign="middle">
            <#if apvlFormulaVo?? && apvlFormulaVo.samplingDate??>${(apvlFormulaVo.samplingDate)?string("yyyy-MM-dd HH:mm:ss")!''}</#if></td>
    </tr>
    <tr>
        <td>品牌名称：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.brand)!''}</td>
    </tr>
    <tr>
        <td>申请人：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.proposer)!''}</td>
    </tr>

    <tr>
        <td>样品名称：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.itemName)!''}</td>
    </tr>
    <tr>
        <td>样品类型：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.formulaType)!''}</td>
<#--        <td width="20%" align="center" valign="middle">样品剂型：</td>-->
<#--        <td width="35%" align="center" valign="middle">${(apvlFormulaVo.formulaDosage)!''}</td>-->
    </tr>
    <tr>
        <td>样品剂型：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.formulaDosage)!''}</td>
    </tr>
    <tr>
        <td>开发背景：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.devBackground)!''}</td>
    </tr>
    <tr>
        <td>销售地区：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.salesDistrict)!''}</td>
    </tr>
    <tr>
        <td>销售地区(其他)：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.salesDistrictNote)!''}</td>
    </tr>
    <tr>
        <td>销售渠道：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.salesChannel)!''}</td>
    </tr>
    <tr>
        <td>打样类型：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.formulaType)!''}</td>
    </tr>
    <tr>
        <td>目标人群：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.applUser)!''}</td>
<#--        <td width="20%" align="center" valign="middle">适用肌肤：</td>-->
<#--        <td width="35%" align="center" valign="middle">${(apvlFormulaVo.applSkinType)!''}</td>-->
    </tr>
    <tr>
        <td>适用肌肤：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.applSkinType)!''}</td>
    </tr>
<#--    <tr>-->
<#--        <td>适用肌肤(其他)：</td>-->
<#--        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.applSkinTypeNote)!''}</td>-->
<#--    </tr>-->
    <tr>
        <td>使用部位：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.usedPart)!''}</td>
    </tr>
    <tr>
        <td>使用功效要求：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.usedEfficacyReq)!''}</td>
    </tr>
    <tr>
        <td>配方特殊要求：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.specificaReq)!''}</td>
    </tr>
    <tr>
        <td>颜色&amp;香型：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.colorAndFlavor)!''}</td>
    </tr>
<#--    <tr>-->
<#--        <td>颜色&amp;香型(其他)：</td>-->
<#--        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.colorAndFlavorNote)!''}</td>-->
<#--    </tr>-->
    <tr>
        <td>容器类型：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.containerType)!''}</td>
    </tr>
<#--    <tr>-->
<#--        <td>容器类型备注：</td>-->
<#--        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.containerTypeNote)!''}</td>-->
<#--    </tr>-->
    <tr>
        <td>成品容量：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.finishProductVolumes)!''}</td>
    </tr>
    <tr>
        <td>成品预计售价：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.erpCustomer)!''}</td>
<#--        <td width="20%" align="center" valign="middle">内料预计单价：</td>-->
<#--        <td width="35%" align="center" valign="middle">${(apvlFormulaVo.interMaterialsPrice)!''}</td>-->
    </tr>
    <tr>
        <td>内料预计单价：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.interMaterialsPrice)!''}</td>
    </tr>
    <tr>
        <td>其他要求(说明)：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.note)!''}</td>
    </tr>
    <tr>
        <td>样品包装方式：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.packing)!''}</td>
    </tr>
    <tr>
        <td>样品容量：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.formulaVolumes)!''}</td>
<#--        <td width="20%" align="center" valign="middle">样品数量：</td>-->
<#--        <td width="35%" align="center" valign="middle">${(apvlFormulaVo.formulaQty)!''}</td>-->
    </tr>
    <tr>
        <td>样品数量：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.formulaQty)!''}</td>
    </tr>

<#--    <tr>-->
<#--        <td>配方编号：</td>-->
<#--        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.formulationNo)!''}</td>-->
<#--    </tr>-->

    <tr>
        <td>抄送人：</td>
        <td colspan="3" align="center" valign="middle">${(apvlFormulaVo.ccToName)!''}</td>
    </tr>
    <tr>
        <td>是否加急：</td>
        <td colspan="3" align="center" valign="middle"><#if apvlFormulaVo.isUrgent ==1>不加急</#if>
            <#if apvlFormulaVo.isUrgent ==2>加急</#if>
        </td>
    </tr>
</table>
</body>
</html>
