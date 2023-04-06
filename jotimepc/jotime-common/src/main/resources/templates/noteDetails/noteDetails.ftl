<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>研发笔记</title>
    <style type="text/css">

    </style>
</head>
<body <#if osName?? && osName == 'window' > style="font-family: '阿里巴巴普惠体 Light';font-size: 25px"</#if>>
<h2 align="center">打样</h2>

<div>
    <span style="position:absolute;left:5px;font-size: 25px;">部门打样编号：${(rdEeformulaVo.depttaskNo)!''}</span>
    <span style="position:absolute;left:60%;font-size: 25px;">打样编号：${(rdEeformulaVo.formulataskNo)!''}</span>
</div>
<br>
<div>
    <span style="position:absolute;left:5px;font-size: 25px;">配方编号：${(rdEeformulaVo.formulaNo)!''}</span>
    <span style="position:absolute;left:60%;font-size: 25px;">客户编号：${(rdEeformulaVo.customerCode)!''}</span>
</div>
<br>
<div>
    <span style="position:absolute;left:5px;font-size: 25px;">配方名称：${(rdEeformulaVo.formulaName)!''}</span>
    <span style="position:absolute;left:60%;font-size: 25px;">打样重量：${(rdEeformulaVo.rdEeformuladtls[0].formulaWeight)!''}</span>
</div>
<br>
<br>
<#--<div id="center">-->
<table  width="100%" border="0" cellpadding="0" cellspacing="5">
    <tr style="width: 100%">
        <td style="width: 52%" valign="top">
            <table width="100%" border="1" cellpadding="0" cellspacing="0">
                <tr bgcolor="#f2f2f1">
                    <td align="center">序号</td>
                    <td align="center">原料编号</td>
                    <td align="center">百分比(%)</td>
                    <td align="center">基准量</td>
                </tr>
                <#if (rdEeformulaVo.rdEeformuladtls?size >= 1)>
                    <#list 0..rdEeformulaVo.rdEeformuladtls?size - 1 as item>
                        <tr>
                            <td align="center">${(rdEeformulaVo.rdEeformuladtls[item].itemSort)!''}</td>
                            <td align="center">${(rdEeformulaVo.rdEeformuladtls[item].itemCode)!''}</td>
                            <td align="center">${(rdEeformulaVo.rdEeformuladtls[item].content)!''}</td>
                            <td align="center">${(rdEeformulaVo.rdEeformuladtls[item].standardQty)!''}</td>
                        </tr>
                    </#list>
                </#if>
            </table>
        </td>
        <td style="width: 48%" valign="top">
            <#if (rdEeformulaVo.rdEeformulaProcesssteps?size >= 1)>
                <#list rdEeformulaVo.rdEeformulaProcesssteps as item>
                <#--                    <tr>-->
                <#--                        <td align="center">${(item.stepSort)!''}</td>-->
                <#--                        <td align="center">${(item.processName)!''}</td>-->
                <#--                    </tr>-->
                    <span align="left" style="word-break: break-word;max-width: 100%">步骤${(item.stepSort)!''}描述：${(item.processDescription)!''}</span>
                    <br>
                    <br>
                </#list>
            </#if>
        </td>
    </tr>
</table>
<#--</div>-->
<div style="border:1px #000000   solid;">
    <span class="title_span" style="word-break: break-word; padding-right: 60px">关键点 :<br> ${(rdEeformulaVo.keypoint)!''}</span>
</div>
</body>
</html>
<style>
    td{
        font-size: 25px;
    }
    *{
        margin: 0;
        padding: 0;
    }
    #center{
        width: 100%;
       position: relative;
    }
    #right{
        width: 50%;
        position: absolute;
        left:50%;
        top:0;
    }
</style>