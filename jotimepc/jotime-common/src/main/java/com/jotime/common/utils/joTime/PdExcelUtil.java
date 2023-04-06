package com.jotime.common.utils.joTime;

import com.jotime.common.utils.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PdExcelUtil {

    /**
     * 处理HTTP请求里是file文件
     *
     * @param multipartFile
     * @return 返回List<Map>每个Map存放一行
     */
    public static List<List<Object>> analysisFile(MultipartFile multipartFile) throws Exception {
        InputStream inputStream = null;
        try {
            inputStream = multipartFile.getInputStream();
        } catch (IOException e) {
            throw e;
        }
        String fileName = multipartFile.getOriginalFilename();
        Workbook workbook = null;
        try {
            //判断什么类型文件
            if (fileName.endsWith(".xls") || fileName.endsWith(".xlsx")) {
                workbook = WorkbookFactory.create(inputStream);
            }
        } catch (Exception e) {
            throw e;
        }
        if (workbook == null) {
            return null;
        } else {
            //获取所有的工作表的的数量
            int numOfSheet = workbook.getNumberOfSheets();
            System.out.println(numOfSheet + "--->numOfSheet");
            List<List<Object>> mapList = new ArrayList<>();
            //遍历表
            for (int i = 0; i < numOfSheet; i++) {
                //获取一个sheet也就是一个工作本。
                Sheet sheet = workbook.getSheetAt(i);
                if (sheet == null) {
                    continue;
                }
                //获取一个sheet有多少Row
                int lastRowNum = sheet.getLastRowNum();
                if (lastRowNum == 0) {
                    continue;
                }
                Row row;
                // 行头
                List<String> headName = new ArrayList<>();
                if (lastRowNum > 0) {
                    row = sheet.getRow(0);
                    // 获取一个Row有多少Cell
                    short lastCellNum = row.getLastCellNum();
                    for (int k = 0; k <= lastCellNum; k++) {
                        if (row.getCell(k) == null) {
                            continue;
                        }
                        String res = getCellVal(row.getCell(k));
                        headName.add(res);
                    }
                }

                // 每一行的内容
                for (int j = 1; j <= lastRowNum; j++) {
                    row = sheet.getRow(j);
                    if (row == null) {
                        continue;
                    }
                    //获取一个Row有多少Cell
                    short lastCellNum = row.getLastCellNum();
                    List<Object> rowString = new ArrayList<>();
                    for (int k = 0; k <= lastCellNum; k++) {
                        if (row.getCell(k) == null) {
                            continue;
                        }
                        String res = getCellVal(row.getCell(k));
                        rowString.add(res);
                    }
                    mapList.add(rowString);
                }
            }
            return mapList;
        }
    }

    private static String getCellVal(Cell cell) {
        DecimalFormat df = new DecimalFormat("0");// 格式化 number String 字符
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
        DecimalFormat nf = new DecimalFormat("0");// 格式化数字
        String val;
        switch (cell.getCellType()) {
            case NUMERIC:
                if ("@".equals(cell.getCellStyle().getDataFormatString())) {
                    val = df.format(cell.getNumericCellValue());
                } else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                    val = nf.format(cell.getNumericCellValue());
                } else {
                    val = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
                }
                break;
            case STRING: //文本类型
                val = cell.getStringCellValue();
                break;
            case BOOLEAN: //布尔型
                val = String.valueOf(cell.getBooleanCellValue());
                break;
            case BLANK: //空白
                val = cell.getStringCellValue();
                break;
            case ERROR: //错误
                val = "错误";
                break;
            case FORMULA: //公式
                try {
                    val = String.valueOf(cell.getStringCellValue());
                } catch (IllegalStateException e) {
                    val = String.valueOf(cell.getNumericCellValue());
                }
                break;
            default:
                val = cell.getRichStringCellValue() == null ? null : cell.getRichStringCellValue().toString();
        }
        return val;
    }

    /**
     * 是否提供转换成数据库存储类型
     *
     * @param value 是 否
     * @return 转换后VALUE
     */
    public static Integer stringToInteger(String value) {
        if (StringUtils.isNull(value)) {
            return 999;
        }
        if ("是".equals(value)) {
            return 2;
        }
        if ("否".equals(value)) {
            return 1;
        }
        return 999;
    }
}

