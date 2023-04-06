<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="规则序号" prop="ruleNumber">
        <el-input
          v-model="queryParams.ruleNumber"
          placeholder="请输入编码规则序号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['base:ruledtl:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['base:ruledtl:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['base:ruledtl:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['base:ruledtl:export']"
        >导出</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-close"
          size="mini"
          @click="handleClose"
        >关闭</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="ruledtlList" @selection-change="handleSelectionChange">
      <el-table-column v-if="show" label="编码id" align="center" prop="ruleId" />
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="规则编号" align="center" prop="ruleNo" />
      <el-table-column label="规则名称" align="center" prop="ruleName" />
      <el-table-column label="规则序号" align="center" prop="ruleNumber" />
      <el-table-column label="规则类型" align="center" prop="ruleType" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_rule_type" :value="scope.row.ruleType"/>
        </template>
      </el-table-column>
      <el-table-column label="规则参数" align="center" prop="ruleParam" />
      <el-table-column label="编码长度" align="center" prop="paddingLength" />
      <el-table-column label="补位方式" align="center" prop="paddingSide" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_rule_padding_side" :value="scope.row.paddingSide"/>
        </template>
      </el-table-column>
      <el-table-column label="补位字符" align="center" prop="paddingChar" />
      <el-table-column label="步长" align="center" prop="step" />
      <el-table-column label="流水号初始值" align="center" prop="initValue" />
      <el-table-column label="状态" align="center" prop="status" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_jotime_data_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="note" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['base:ruledtl:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['base:ruledtl:remove']"
          >删除</el-button>
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

    <!-- 添加或修改编码规则明细对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-table-column v-if="show" label="编码id" align="center" prop="ruleId" />
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="规则序号" prop="ruleNumber">
          <el-input v-model.number="form.ruleNumber" placeholder="请输入编码规则序号" />
        </el-form-item>
        <el-form-item label="规则类型" prop="ruleType">
          <el-select v-model="form.ruleType" placeholder="请选择规则类型" @change="handleRuleTypeChange">
            <el-option
              v-for="dict in dict.type.sys_rule_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="规则参数" prop="ruleParam">
          <el-input v-model="form.ruleParam" placeholder="请输入编码规则参数" />
        </el-form-item>
        <div v-if="form.ruleType == 'numbering'">
          <el-form-item label="编码长度" prop="paddingLength">
            <el-input v-model="form.paddingLength" placeholder="请输入编码长度" />
          </el-form-item>
          <el-form-item label="补位方式" prop="paddingSide">
            <el-radio-group v-model="form.paddingSide">
              <el-radio
                v-for="dict in dict.type.sys_rule_padding_side"
                :key="dict.value"
                :label="dict.value"
              >{{ dict.label }}
              </el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="补位字符" prop="paddingChar">
            <el-input v-model="form.paddingChar" placeholder="请输入编码补位字符" />
          </el-form-item>
          <el-form-item label="步长" prop="step">
            <el-input v-model="form.step" placeholder="请输入步长" />
          </el-form-item>
          <el-form-item label="流水号初始值" prop="initValue">
            <el-input v-model="form.initValue" placeholder="请输入流水号初始值" />
          </el-form-item>
        </div>
        <el-form-item label="备注" prop="note">
          <el-input v-model="form.note" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.sys_jotime_data_status"
              :key="dict.value"
              :label="Number(dict.value)"
            >{{ dict.label }}
            </el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listRuledtl, getRuledtl, delRuledtl, addRuledtl, updateRuledtl } from "@/api/jotime/base/basics/ruledtl";
import {getRule, listRule} from "@/api/jotime/base/basics/rule";

export default {
  name: "Ruledtl",
  dicts: [ 'sys_jotime_data_status','sys_rule_padding_side','sys_rule_type'],
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
      // 编码规则明细表格数据
      ruledtlList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        ruleId: null,
        ruleNumber: null,
        ruleType: null,
        ruleParam: null,
        paddingLength: null,
        paddingSide: null,
        paddingChar: null,
        step: null,
        initValue: null,
        status: null,
        note: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        ruleId: [
          { required: true, message: "编码规则内码不能为空", trigger: "blur"}
        ],
        ruleNumber: [
          { required: true, message: "请正确输入整数", trigger: "blur",type:"number"  }
        ],
        ruleType: [
          { required: true, message: "编码规则类型", trigger: "change" }
        ],
      }
    };
  },
  created() {
    const ruleId = this.$route.params && this.$route.params.ruleId;
    this.getRuleId(ruleId);
  },
  methods: {

    /** 查询字典类型详细 */
    getRuleId(ruleId) {
      this.queryParams.ruleId = ruleId;
      this.getList();
    },

    /** 查询编码规则明细列表 */
    getList() {
      this.loading = true;
      listRuledtl(this.queryParams).then(response => {
        this.ruledtlList = response.rows;
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
        ruleId: null,
        ruleNumber: null,
        ruleType: null,
        ruleParam: null,
        paddingLength: null,
        paddingSide: null,
        paddingChar: null,
        step: null,
        initValue: null,
        status: 2,
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
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    // 多选框选中数据
    handleRuleTypeChange() {
      this.form.paddingSide = 'left';
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加编码规则明细";
      this.form.ruleId = this.queryParams.ruleId;
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getRuledtl(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改编码规则明细";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateRuledtl(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRuledtl(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除编码规则明细编号为"' + ids + '"的数据项？').then(function() {
        return delRuledtl(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 返回按钮操作 */
    handleClose() {
      const obj = { path: "/system/rule" };
      this.$tab.closeOpenPage(obj);
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('base/ruledtl/export', {
        ...this.queryParams
      }, `ruledtl_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
