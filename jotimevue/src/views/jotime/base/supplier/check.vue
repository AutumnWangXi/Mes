<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="供应商编码" label-width="85px" prop="supplierCode">
        <el-input
          v-model="queryParams.supplierCode"
          placeholder="请输入供应商编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="供应商名称" label-width="85px" prop="supplierName">
        <el-input
          v-model="queryParams.supplierName"
          placeholder="请输入供应商名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="供应商类型" label-width="85px" prop="supplierType">
        <el-select
          v-model="queryParams.supplierType"
          placeholder="供应商类型"
          clearable
          size="small"
          style="width: 200px"
        >
          <el-option
            v-for="dict in dict.type.sys_supplier_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="供应商等级" label-width="85px" prop="supplierLevel">
        <el-select
          v-model="queryParams.supplierLevel"
          placeholder="供应商等级"
          clearable
          size="small"
          style="width: 200px"
        >
          <el-option
              v-for="lev in dict.type.sys_supplier_level"
            :key="lev.value"
            :label="lev.label"
            :value="lev.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="审核状态" label-width="85px" prop="checkStatus">
        <el-select
          v-model="queryParams.checkStatus"
          placeholder="审核状态"
          clearable
          size="small"
          style="width: 200px"
        >
          <el-option
            v-for="item in checkStsOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['base:supplier:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="supplierList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="供应商编码" align="center" prop="supplierCode"/>
      <el-table-column label="供应商名" align="center" prop="supplierName"/>
      <el-table-column label="联系人" align="center" prop="contactPerson"/>
      <el-table-column label="联系人手机" align="center" prop="contactTelephone"/>
      <el-table-column label="地址" align="center" prop="address" :show-overflow-tooltip="true" />
      <el-table-column label="公司电话" align="center" prop="companyTelephone" />
      <el-table-column label="纳税人识别号" align="center" prop="tin" />
      <el-table-column label="开户行" align="center" prop="bankName" />
      <el-table-column label="开户账号" align="center" prop="caccountNumber" />
      <el-table-column label="收件地址" align="center" prop="recipientAddress" :show-overflow-tooltip="true" />
      <el-table-column label="账期" align="center" prop="terms" />
      <el-table-column label="供应商类型" align="center" prop="supplierItemType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_supplier_type" :value="scope.row.supplierItemType"/>
        </template>
      </el-table-column>
      <el-table-column label="供应商等级" align="center" prop="supplierLevel">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_supplier_level" :value="scope.row.supplierLevel"/>
        </template>
      </el-table-column>
      <el-table-column label="供应产品名" align="center" prop="supplyItemName"/>
      <el-table-column label="审核状态" align="center" prop="checkStatus" :formatter="checkStsFormat">
      </el-table-column>
      <el-table-column label="审核时间" align="center" prop="checkTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.checkTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="审核备注" align="center" prop="checkNote"/>
      <el-table-column label="备注" align="center" prop="note"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            v-if="scope.row.checkStatus == 1"
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleCheck(scope.row)"
            v-hasPermi="['base:supplier:query']"
          >审核
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改供应商对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="供应商编码" label-width="100px" prop="supplierCode">
              <el-input v-model="form.supplierCode" :disabled="true"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="供应商名称" label-width="100px" prop="supplierName">
              <el-input v-model="form.supplierName" :disabled="true"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="联系人" prop="contactPerson" label-width="100px">
              <el-input v-model="form.contactPerson" :disabled="true"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="联系人手机" prop="contactTelephone" label-width="100px">
              <el-input v-model="form.contactTelephone" :disabled="true"/>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="地址" prop="address" label-width="100px">
              <el-input v-model="form.address" :disabled="true"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="供应商类型" prop="supplierItemType" label-width="100px">
              <el-select v-model="form.supplierItemType" :disabled="true">
                <el-option
                  v-for="item in dict.type.sys_supplier_type"
                  :key="item.value"
                  :label="item.label"
                  :value="Number(item.value)"
                />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="供应商等级" prop="supplierLevel" label-width="100px">
              <el-select v-model="form.supplierLevel" :disabled="true">
                <el-option
                  v-for="level in dict.type.sys_supplier_level"
                  :key="level.value"
                  :label="level.label"
                  :value="Number(level.value)"
                />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="供应物料类型" prop="supplyItemName" label-width="100px">
              <el-input v-model="form.supplyItemName" :disabled="true"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="状态" prop="status" label-width="100px">
              <el-radio-group v-model="form.status">
                <el-radio
                  v-for="dict in dict.type.sys_jotime_data_status"
                  :key="dict.value"
                  :label="Number(dict.value)"
                >{{ dict.label }}
                </el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="备注" prop="note" label-width="100px">
              <el-input v-model="form.note" type="textarea" :disabled="true"/>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="审核备注" prop="checkNote" label-width="100px">
              <el-input v-model="form.checkNote" type="textarea" placeholder="请输入审批备注"/>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitPassForm">通 过</el-button>
        <el-button type="primary" @click="submitRejectForm">驳 回</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listChkSupplier,
  getSupplier,
  updateCheckSts, updateChkSts
} from "@/api/jotime/base/basics/supplier";

export default {
  name: "Supplier",
  dicts: ['sys_jotime_data_status', 'sys_yes_no', "sys_supplier_level", "sys_supplier_type"],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 供应商表格数据
      supplierList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        supplierCode: null,
        supplierName: null,
        address: null,
        contactPerson: null,
        contactTelephone: null,
        supplierItemType: null,
        supplierLevel: null,
        supplyItemName: null,
        checkStatus: null,
        checkId: null,
        checker: null,
        checkTime: null,
        status: null,
        note: null,
        checkNote: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {},
      // 审核状态下拉框
      checkStsOptions: [{
        value: 1,
        label: '待审核'
      }, {
        value: 2,
        label: '审核中'
      }, {
        value: 3,
        label: '通过'
      }, {
        value: 4,
        label: '驳回'
      }],
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询供应商列表 */
    getList() {
      this.loading = true;
      listChkSupplier(this.queryParams).then(response => {
        this.supplierList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        supplierCode: null,
        supplierName: null,
        address: null,
        contactPerson: null,
        contactTelephone: null,
        supplierItemType: null,
        supplierLevel: null,
        supplyItemName: null,
        checkStatus: "0",
        checkId: null,
        checker: null,
        checkTime: null,
        status: 0,
        note: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 审核按钮操作 */
    handleCheck(row) {
      this.reset();
      const id = row.id || this.ids
      getSupplier(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "审核供应商";
      });
    },
    /** 提交按钮 */
    submitPassForm() {
      this.$refs["form"].validate(valid => {
        if (this.form.id != null) {
          this.form.checkStatus = 3;
          updateChkSts(this.form).then(response => {
            this.$modal.msgSuccess("审核成功");
            this.open = false;
            this.getList();
          });
        }
      });
    },

    /** 提交按钮 */
    submitRejectForm() {
      this.$refs["form"].validate(valid => {
        if (this.form.id != null) {
          this.form.checkStatus = 9;
          updateChkSts(this.form).then(response => {
            this.$modal.msgSuccess("审核成功");
            this.open = false;
            this.getList();
          });
        }
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('base/supplier/export', {
        ...this.queryParams
      }, `supplier_${new Date().getTime()}.xlsx`)
    },
    /** 审核状态 */
    checkStsFormat(row, column) {
      if (row.checkStatus == 1) {
        return '待审核'
      } else if (row.checkStatus == 2) {
        return '审核中'
      } else if (row.checkStatus == 3) {
        return '通过'
      } else if (row.checkStatus == 9) {
        return '驳回'
      }
    }
  }
};
</script>
