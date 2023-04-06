package com.jotime.common.utils.joTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class GetID {

    private String ID;


    @Autowired
    DataSource dataSource;

    //生产6位日期字符串  210629 - 2021-06-29
    private String getdatestring(Date date) {
        System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String dateNowStr = sdf.format(date);
        //System.out.println("格式化后的日期：" + dateNowStr);
        return dateNowStr;

    }

    private String getdatestring_8(Date date) {
        System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateNowStr = sdf.format(date);
        //System.out.println("格式化后的日期：" + dateNowStr);
        return dateNowStr;
    }

    //生成客户id   （7 或者 8 加上 三位流水号） str_staff业务员工的id
    public String getCustomerID(String str_staff) {

        //todo： 根据业务部门 区分 “7” ，“8” 现在暂时定为 “7”
        int customer = 0; //客户流水号
        Connection connection = null;
        String sql = "";
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            sql = "select customer from ID_configure;";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                customer = resultSet.getInt(1);

            }
            sql = "update ID_configure set customer = customer+1;";
            statement.execute(sql);
            connection.close();
//
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "";
        }
        customer++;
        ID = "7" + String.format("%03d", customer);
        return ID;
    }

    //获取生产商编号   生产单编号：4位客户编号+6位日期+2位流水号
    public String getProductionID(String str_customer) {

        int production = 0; //生产订单流水号
        Connection connection = null;
        Date date = new Date();
        String strdate_now = getdatestring(date);
        String sql = "";
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            sql = "select production,up_date from ID_production;";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                production = resultSet.getInt(1);
                Date date_sql = (Date) resultSet.getObject(2);
                String strdate_sql = getdatestring(date_sql);
                if (!strdate_now.equals(strdate_sql)) //日期不一样，流水号从0开始
                {
                    production = 0;
                    sql = "update ID_production set production = 1,up_date =now() ;";
                } else {
                    sql = "update ID_production set production = production+1;";
                }

            }

            statement.execute(sql);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "";
        }
        production++;
        ID = str_customer + strdate_now + String.format("%02d", production);
        return ID;
    }

    //原料供应商流水号 以1为开头 加上三位流水号
    public String getRawm_supplierID() {

        int rawm_supplier = 0; //原料供应商流水号
        Connection connection = null;
        String sql = "";
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            sql = "select rawm_supplier from ID_configure;";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                rawm_supplier = resultSet.getInt(1);

            }
            sql = "update ID_configure set rawm_supplier = rawm_supplier+1;";
            statement.execute(sql);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "";
        }
        rawm_supplier++;
        ID = "1" + String.format("%03d", rawm_supplier);
        return ID;
    }

    //原料生产商编号 以2为开头 加上三位流水号
    public String getRawm_manufacturerID() {

        int rawm_manufacturer = 0; //原料生产商流水号
        Connection connection = null;
        String sql = "";
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            sql = "select rawm_manufacturer from ID_configure;";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                rawm_manufacturer = resultSet.getInt(1);

            }
            sql = "update ID_configure set rawm_manufacturer = rawm_manufacturer+1;";
            statement.execute(sql);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "";
        }
        rawm_manufacturer++;
        ID = "2" + String.format("%03d", rawm_manufacturer);
        return ID;
    }


    //获取包材编号
    // 我司订单号编制规则：如800113032101，前4位为客户代码，后6位为客户订单接收日期，最后两位为流水号，我司的订单号与客户订单号要一一对应。
    // 我司订单号编制规则：如800113032101，前4位为客户代码，后6位为客户订单接收日期，最后两位为流水号，我司的订单号与客户订单号要一一对应。
    public String getPackagingID(String str_customer) {

        int packaging = 0; //包材流水号
        Connection connection = null;
        Date date = new Date();
        String strdate_now = getdatestring(date);
        String sql = "";
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            sql = "select packaging,up_date from id_packaging;";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                packaging = resultSet.getInt(1);
                Date date_sql = (Date) resultSet.getObject(2);
                String strdate_sql = getdatestring(date_sql);
                if (!strdate_now.equals(strdate_sql)) //日期不一样，流水号从0开始
                {
                    packaging = 0;
                    sql = "update id_packaging set packaging = 1,up_date =now() ;";
                } else {
                    sql = "update id_packaging set packaging = packaging+1;";
                }

            }

            statement.execute(sql);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "";
        }
        packaging++;
        ID = str_customer + strdate_now + String.format("%02d", packaging);
        return ID;
    }


    //获取原料批号
    //以我司物料批号追溯。
    //批号方式以6位接收日期+1位流水号追溯，如1711261，若同一天接收2批以上不同供应商批号的同一种原料，
    // 则1711261，1711262，以此类推

    public String getRaw_materialID() {

        int raw_material = 0; //原料流水号流水号
        Connection connection = null;
        Date date = new Date();
        String strdate_now = getdatestring(date);
        String sql = "";
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            sql = "select raw_material,up_date from ID_raw_material;";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                raw_material = resultSet.getInt(1);
                Date date_sql = (Date) resultSet.getObject(2);
                String strdate_sql = getdatestring(date_sql);
                if (!strdate_now.equals(strdate_sql)) //日期不一样，流水号从0开始
                {
                    raw_material = 0;
                    sql = "update ID_raw_material set raw_material = 1,up_date =now() ;";
                } else {
                    sql = "update ID_raw_material set raw_material = raw_material+1;";
                }

            }

            statement.execute(sql);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "";
        }
        raw_material++;
        ID = strdate_now + String.format("%01d", raw_material);
        return ID;
    }

    //以我司物料批号追溯。
    //批号方式以6位制料日期+2位流水号追溯，如17112601，
    // 若同一天制造2锅以上的同一种半成品，则17112601，17112602，以此类推。

    public String getSemifinishedID() {

        int semifinished; //半成品流水号
        Connection connection = null;
        Date date = new Date();
        String strdate_now = getdatestring(date);
        String sql = "";
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            sql = "select semifinished,up_date from ID_semifinished;";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                semifinished = resultSet.getInt(1);
                Date date_sql = (Date) resultSet.getObject(2);
                String strdate_sql = getdatestring(date_sql);
                int version = 1;
                if (!strdate_now.equals(strdate_sql)) //日期不一样，流水号从0开始
                {
                    semifinished = 0;
                    sql = "update ID_semifinished set semifinished = 1,up_date =now() ;";
                } else {
                    sql = "update ID_semifinished set semifinished = semifinished+1 "; //末尾留一个空格
                    //sql = sql + "where version = "+ version + ";";
                }

            } else {
                return "";
            }

            int execute = statement.executeUpdate(sql);
//            if (execute == 1){
//                System.out.println("yes");
//            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "";
        }
        semifinished++;
        ID = strdate_now + semifinished;
        return ID;
    }


    //获取打样单号
    public String getProofingFormulaID(char code_persionnal, char product_type, String raw_material_type) {
        //////////
        product_type = 'C';
        raw_material_type = "SL";
        code_persionnal = 'A';
        ////////////
        Connection connection = null;
        Date date = new Date();
        String strdate_now = getdatestring(date);
        String sql = "";
        char c_proofing_num = '0';
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            sql = "select proofing_num,up_date from ID_proofing where product_type = ";
            sql = sql + "'" + product_type + "'" + ";";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                c_proofing_num = (char) resultSet.getByte(1);
                Date date_sql = (Date) resultSet.getObject(2);
                String strdate_sql = getdatestring(date_sql);
                if (!strdate_now.equals(strdate_sql)) //日期不一样，流水号从0开始
                {
                    c_proofing_num = 'A';
                    sql = "update ID_proofing set proofing_num = 'A',up_date =now() where product_type = '" + product_type + "';";
                } else {
                    int iproofing_num = c_proofing_num + 1;
                    c_proofing_num = (char) iproofing_num;
                    sql = "update ID_proofing set proofing_num = '" + c_proofing_num + "' where product_type = '" + product_type + "';";
                }

            } else {           //如果没有，就插入
                c_proofing_num = 'A';
                sql = "insert into ID_proofing (proofing_num,up_date,product_type) values ('A',now(),'" + product_type + "'); ";
            }

            statement.executeUpdate(sql);

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "";
        }
        ID = product_type + raw_material_type + strdate_now + code_persionnal + c_proofing_num;
        return ID;
    }


    //获取原料编码id
    public String getRaw_materialID(char code_raw_material) {

        code_raw_material = 'A';

        int raw_material = 0;  //原料编码id流水号
        Connection connection = null;
        String sql = "";
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            sql = "select raw_material from id_raw_material_code;";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                raw_material = resultSet.getInt(1);
                sql = "update id_raw_material_code set raw_material = raw_material+1;";
            } else {
                return "";
            }

            statement.executeUpdate(sql);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "";
        }
        ID = "JS" + code_raw_material + String.format("%03d", raw_material);
        return ID;
    }

    //获取合同编号ID 8位日期+ 2位流水号
    public String getContractID() {

        int contract = 0;  //合同id流水号
        String str_date_now = getdatestring_8(new Date());
        Connection connection = null;
        String sql = "";
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            sql = "select contract,up_date from id_contract;";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                contract = resultSet.getInt(1);
                Date date_sql = (Date) resultSet.getObject(2);
                String str_date_sql = getdatestring_8(date_sql);
                if (!str_date_now.equals(str_date_sql)) {
                    sql = "update id_contract set contract = 0, up_date = now();";
                } else {

                    sql = "update id_contract set contract = contract+1;";
                }

            } else {
                sql = " insert into id_contract (contract,up_date) values (1,now());";
            }

            statement.executeUpdate(sql);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "";
        }
        contract++;

        ID = str_date_now + String.format("%02d", contract);
        return ID;
    }


    public String getUUID() {
        //生成唯一id
        String id = UUID.randomUUID().toString();
        //替换uuid中的"-"
        id = id.replace("-", "");
        return id;
    }
}



