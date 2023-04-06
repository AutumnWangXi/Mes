<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>打样标签</title>
    <style type="text/css">

    </style>
</head>
<body <#if osName?? && osName == 'window' > style="font-family: '阿里巴巴普惠体 Light';font-size: 10px"</#if>>
    <div align="center" style="width: 25%;height: 20%;text-align: center;">
        <span style="display: block;font-size: 20px">${(rdEeformula.itemName)!''}</span>
        <span style="display: block;font-size: 20px">${(rdEeformula.formulaNo)!''}</span><br>
        <#if (rdEeformula.status == 1)>
            <span style="display: block;font-size: 15px">天然日化用品</span>
            <span style="display: block;font-size: 15px">省级高新技术企业研究开发中心</span>
        </#if>
        <#if (rdEeformula.status == 0)>
            <span style="display: block;font-size: 20px">JOTIM</span>
            <span style="display: block;font-size: 10px">Natural Daily Chemical Products</span>
            <span style="display: block;font-size: 10px"> High-Tec R&D Center</span>
        </#if>
        <span style="display: block;font-size: 20px">${(rdEeformula.createTime)?string("yy.MM.dd")}</span>
    </div>
</body>
