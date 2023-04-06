<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>内料称量后标签</title>
    <style type="text/css">
        *{
            margin: 0px;
            padding: 0px;
        }
        table{
            border-collapse:collapse;border-style: solid;border-width: 1px;
        }
        td{
            border-style: solid;border-width: 1px;
        }
    </style>
</head>

<body style="font-size: 12px;font-weight:600;left: 0px;font-family: '阿里巴巴普惠体 Light' ">
<div style="float:left"><span>客户编号:&nbsp;&nbsp;${(map.customerCode)!''}</span></div>
<br>
<div style="float:left"><span>产品名称:&nbsp;&nbsp;${(map.goodsName)!''}</span></div>
<table width="100%" align="center">
    <tr style="height: 30px">
        <td width="25%" rowspan="5" align="center" valign="middle">
            <div style="height: 150px">
                <br>
                <br>
                <img style="width:85px;height:85px;"
                     src="data:image/png;base64,${(map.qrCode)!''}"/>
            </div>
        </td>
        <td colspan="2" class="right" valign="middle">物料编号：${(map.itemCode)!''}</td>
    </tr>
    <tr style="height: 30px">
        <td colspan="2" class="right" valign="middle">物料名称：${(map.itemName)!''}</td>
    </tr>
    <tr style="height: 30px">
        <td colspan="1" class="right" valign="middle">称重人：${(map.weighing)!''}</td>
        <td colspan="1" class="right" valign="middle">重量：${(map.netWeight)!''}${(map.unit)!''}</td>
    </tr>
    <tr style="height: 30px">
        <td colspan="2" class="right" valign="middle">称重时间：${(map.weighingDate)!''}</td>
    </tr>
    <tr style="height: 30px">
        <td colspan="1" class="right" valign="middle">投入设备：${(map.deviceCode)!''}</td>
        <td colspan="1" class="right" valign="middle">投料序号：${(map.stepSort)!''}</td>
    </tr>
</table>
<div>
    <div style="float:left"><span>任务单编号:&nbsp;&nbsp;<span style="font-weight: normal">${(map.orderNo)!''}</span></span></div>
    <div align="right" style="float:right"><span>分拣指示单号:&nbsp;&nbsp;<span style="font-weight: normal">${(map.stockoutNo)!''}</span></span></div>
</div>
</body>
</html>
