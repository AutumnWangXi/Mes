-- 2022/10/19
ALTER TABLE pd_group_ordertask ADD COLUMN is_flow_pd VARCHAR(2) DEFAULT NULL COMMENT '是否流水线生产(Y是 N否)';
ALTER TABLE pd_group_ordertask ADD COLUMN last_gp_ordertask_no VARCHAR(32) DEFAULT NULL COMMENT '上一个班组任务单号';

ALTER TABLE base_item ADD COLUMN avg_price DECIMAL(16,0) DEFAULT 0 COMMENT '平均价格';
ALTER TABLE base_item ADD COLUMN last_price DECIMAL(16,0) DEFAULT 0 COMMENT '最近一次单价';
ALTER TABLE base_item ADD COLUMN last_pur_time datetime DEFAULT NULL COMMENT '最近采购时间';
ALTER TABLE base_item ADD COLUMN avg_start_time datetime DEFAULT NULL COMMENT '开始时间';
ALTER TABLE base_item ADD COLUMN avg_close_time datetime DEFAULT NULL COMMENT '结束时间';

ALTER TABLE pd_report ADD COLUMN used_qty DECIMAL(16,4) DEFAULT 0 COMMENT '已使用数量';
ALTER TABLE pd_report ADD COLUMN unused_qty DECIMAL(16,4) DEFAULT 0 COMMENT '未使用数量';
ALTER TABLE pd_report ADD COLUMN report_no varchar(32) DEFAULT 0 COMMENT '报产编号';
ALTER TABLE pd_report ADD COLUMN proportioning  decimal(16,4) DEFAULT 0 COMMENT '配比';
ALTER TABLE pd_report ADD COLUMN last_gp_ordertask_no  varchar(32) DEFAULT null COMMENT '上一个班组任务单号';

ALTER TABLE pd_group_ordertaskdtl ADD COLUMN `content` decimal(12,6) DEFAULT '0.000000' COMMENT '含量';
ALTER TABLE pd_group_ordertaskdtl ADD COLUMN `package_proportioning` decimal(12,6) DEFAULT '0.000000' COMMENT '配比';
ALTER TABLE pd_group_ordertaskdtl ADD COLUMN `standard_qty` decimal(11,4) DEFAULT '0.0000' COMMENT '基准量';
ALTER TABLE pd_group_ordertaskdtl ADD COLUMN `packages` int(8) DEFAULT '0' COMMENT '件数';

ALTER TABLE pd_wksh_ordertaskdtl ADD COLUMN `content` decimal(12,6) DEFAULT '0.000000' COMMENT '含量';
ALTER TABLE pd_wksh_ordertaskdtl ADD COLUMN `package_proportioning` decimal(12,6) DEFAULT '0.000000' COMMENT '配比';
ALTER TABLE pd_wksh_ordertaskdtl ADD COLUMN `standard_qty` decimal(11,4) DEFAULT '0.0000' COMMENT '基准量';
ALTER TABLE pd_wksh_ordertaskdtl ADD COLUMN `packages` int(8) DEFAULT '0' COMMENT '件数';

alter table pd_wksh_ordertask modify customer_id varchar(20) DEFAULT null COMMENT '客户内码';


-- 2022/11/9
ALTER TABLE base_item ADD COLUMN submission_code_sts varchar(1) DEFAULT 'N' COMMENT 'N 不报送 S 报送中 C 完成';


--2022-11-11
alter table stockin_location modify material_box_id INT(11) DEFAULT null COMMENT '物料箱内码';
ALTER TABLE stock_manage_his ADD COLUMN old_count_qty decimal(16,2) DEFAULT NULL COMMENT '旧的清点待质检数量';
ALTER TABLE stock_manage_his ADD COLUMN  `old_waiting_stockin_qty` decimal(16,2) DEFAULT NULL COMMENT '已检待入库数量';
ALTER TABLE stock_manage_his ADD COLUMN   `old_waiting_stockout_qty` decimal(16,2) DEFAULT NULL COMMENT '待出库数量';
ALTER TABLE stock_manage_his ADD COLUMN   `old_sorting_step1_qty` decimal(16,2) DEFAULT NULL COMMENT '已一次分拣数量';
ALTER TABLE stock_manage_his ADD COLUMN   `old_sorting_step2_qty` decimal(16,2) DEFAULT NULL COMMENT '已二次分拣数量';

--2022-11-28
ALTER TABLE pd_openline_checkinfo ADD COLUMN   `device_code` varchar(32) DEFAULT NULL COMMENT '设备编号';
ALTER TABLE pd_openline_checkinfo ADD COLUMN   `device_name` varchar(128) DEFAULT NULL COMMENT '设备名称';


--2022-12-15
ALTER TABLE pd_pp_record ADD COLUMN   `start_record_time1` datetime DEFAULT NULL COMMENT '记录开始时间1';
ALTER TABLE pd_pp_record ADD COLUMN   `close_record_time1` datetime DEFAULT NULL COMMENT '记录结束时间1';
ALTER TABLE pd_pp_record ADD COLUMN   `start_record_time2` datetime DEFAULT NULL COMMENT '记录开始时间2';
ALTER TABLE pd_pp_record ADD COLUMN   `close_record_time2` datetime DEFAULT NULL COMMENT '记录结束时间2';
ALTER TABLE pd_pp_record ADD COLUMN   `start_record_time3` datetime DEFAULT NULL COMMENT '记录开始时间3';
ALTER TABLE pd_pp_record ADD COLUMN   `close_record_time3` datetime DEFAULT NULL COMMENT '记录结束时间3';
ALTER TABLE pd_pp_record ADD COLUMN   `start_record_time4` datetime DEFAULT NULL COMMENT '记录开始时间4';
ALTER TABLE pd_pp_record ADD COLUMN   `close_record_time4` datetime DEFAULT NULL COMMENT '记录结束时间4';
ALTER TABLE pd_pp_record ADD COLUMN   `start_record_time5` datetime DEFAULT NULL COMMENT '记录开始时间5';
ALTER TABLE pd_pp_record ADD COLUMN   `close_record_time5` datetime DEFAULT NULL COMMENT '记录结束时间5';
ALTER TABLE pd_pp_record ADD COLUMN   `start_record_time6` datetime DEFAULT NULL COMMENT '记录开始时间6';
ALTER TABLE pd_pp_record ADD COLUMN   `close_record_time6` datetime DEFAULT NULL COMMENT '记录结束时间6';
ALTER TABLE pd_pp_record ADD COLUMN   `start_record_time7` datetime DEFAULT NULL COMMENT '记录开始时间7';
ALTER TABLE pd_pp_record ADD COLUMN   `close_record_time7` datetime DEFAULT NULL COMMENT '记录结束时间7';
ALTER TABLE pd_pp_record ADD COLUMN   `start_record_time8` datetime DEFAULT NULL COMMENT '记录开始时间8';
ALTER TABLE pd_pp_record ADD COLUMN   `close_record_time8` datetime DEFAULT NULL COMMENT '记录结束时间8';


--2022-12-22
alter table pd_order modify unit varchar(10) NOT NULL COMMENT '单位';
alter table pd_ordertask modify unit varchar(10) NOT NULL COMMENT '单位';
