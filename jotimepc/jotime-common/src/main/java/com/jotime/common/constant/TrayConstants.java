package com.jotime.common.constant;


import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 原料托盘语言
 * @Description
 * @Date 2022/6/7 15:32
 * @Created by zjm
 */
public class TrayConstants {

    private static final String pallet = "Pallet";
    private static final String item = "ITEM";
    private static final String po = "PO";
    private static final String lot = "LOT";
    private static final String ctn = "CTN";
    private static final String qty = "QTY";
    private static final String tihi = "TIHI";
    private static final String layers = "Layers";
    private static final String high = "High";
    private static final String mantissa = "Mantissa";

    private static final String cnPallet = "托盘号";
    private static final String cnItem = "型号";
    private static final String cnPo = "批号";
    private static final String cnLot = "生产日期";
    private static final String cnCtn = "件数";
    private static final String cnQty = "数量";
    private static final String cnTihi = "托盘信息";
    private static final String cnLayers = "每层";
    private static final String cnHigh = "层数";
    private static final String cnMantissa = "剩余";

    public static Map getMap() {
        Map<String, String> map = new HashMap<>();
        map.put("pallet", pallet);
        map.put("item", item);
        map.put("po", po);
        map.put("lot", lot);
        map.put("ctn", ctn);
        map.put("qty", qty);
        map.put("tihi", tihi);
        map.put("layers", layers);
        map.put("high", high);
        map.put("mantissa", mantissa);
        return map;
    }

    public static Map getcnMap() {
        Map<String, String> map = new HashMap<>();
        map.put("pallet", cnPallet);
        map.put("item", cnItem);
        map.put("po", cnPo);
        map.put("lot", cnLot);
        map.put("ctn", cnCtn);
        map.put("qty", cnQty);
        map.put("tihi", cnTihi);
        map.put("layers", cnLayers);
        map.put("high", cnHigh);
        map.put("mantissa", cnMantissa);
        return map;
    }

}
