<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="auto">
      <el-form-item label="微生物检测内码" prop="microbeId">
        <el-input
          v-model="queryParams.microbeId"
          placeholder="请输入微生物检测内码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
 <!--     <el-form-item label="判断方式" prop="judgmentMode">
        <el-input
          v-model="queryParams.judgmentMode"
          placeholder="请输入判断方式"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="标准值" prop="standardValue">
        <el-input
          v-model="queryParams.standardValue"
          placeholder="请输入标准值"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="上浮值" prop="upFloatingValue">
        <el-input
          v-model="queryParams.upFloatingValue"
          placeholder="请输入上浮值"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="下浮值" prop="downFloatingValue">
        <el-input
          v-model="queryParams.downFloatingValue"
          placeholder="请输入下浮值"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="排序" prop="sort">
        <el-input
          v-model="queryParams.sort"
          placeholder="请输入排序"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="检查项目" prop="inspectItems">
        <el-input
          v-model="queryParams.inspectItems"
          placeholder="请输入检查项目"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
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
          v-hasPermi="['web:microbedtl:add']"
        >新增</el-button>
      </el-col>
<!--      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['web:microbedtl:edit']"
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
          v-hasPermi="['web:microbedtl:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['web:microbedtl:export']"
        >导出</el-button> -->
      <!-- </el-col> -->
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="microbedtlList" @selection-change="handleSelectionChange">
      <el-table-column  label="序号" type="index" width="55" align="center" />
      <el-table-column label="微生物检测内码" align="center" prop="microbeId" />
      <el-table-column label="检查项目" align="center" prop="inspectItems" />
      <el-table-column label="标准值" align="center" prop="standardValue" />
      <el-table-column label="排序" align="center" prop="sort" />
     <!-- <el-table-column label="判断方式" align="center" prop="judgmentMode" />
      <el-table-column label="上浮值" align="center" prop="upFloatingValue" />
      <el-table-column label="下浮值" align="center" prop="downFloatingValue" /> -->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['web:microbedtl:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['web:microbedtl:remove']"
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

    <!-- 添加或修改微生物检测内容对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="微生物检测内码" prop="microbeId">
          <el-input v-model="form.microbeId" placeholder="请输入微生物检测内码" />
        </el-form-item>
        <el-form-item label="检查项目" prop="inspectItems">
          <el-input v-model="form.inspectItems" placeholder="请输入检查项目" />
        </el-form-item>
        <el-form-item label="标准值" prop="standardValue">
          <el-input v-model="form.standardValue" placeholder="请输入标准值" />
        </el-form-item>
       <!-- <el-form-item label="判断方式" prop="judgmentMode">
          <el-input v-model="form.judgmentMode" placeholder="请输入判断方式" />
        </el-form-item>
        <el-form-item label="上浮值" prop="upFloatingValue">
          <el-input v-model="form.upFloatingValue" placeholder="请输入上浮值" />
        </el-form-item>
        <el-form-item label="下浮值" prop="downFloatingValue">
          <el-input v-model="form.downFloatingValue" placeholder="请输入下浮值" />
        </el-form-item> -->
        <el-form-item label="排序" prop="sort">
          <el-input @input="replaceNumber" v-model="form.sort" placeholder="请输入排序" />
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
import { listBaseMicrobedtl, getBaseMicrobedtl, delBaseMicrobedtl, addBaseMicrobedtl, updateBaseMicrobedtl } from "@/api/jotime/base/microbedtl";

export default {
  name: "baseMicrobedtl",
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
      // 微生物检测内容表格数据
      microbedtlList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        microbeId: null,
        judgmentMode: null,
        standardValue: null,
        upFloatingValue: null,
        downFloatingValue: null,
        sort: null,
        inspectItems: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    var microbeId = this.$route.query.id;
    this.queryParams.microbeId = microbeId;
    this.getList();
  },
  watch :{
    '$route': function (to, from) {
      var microbeId = this.$route.query.id;
      this.queryParams.microbeId = microbeId;
      this.getList();
    }
  },
  methods: {
    // 判断成品容量是否为正数可以是小数
    replaceNumber(value) {
      let reg = /[^\d]/g
      if (reg.test(value)) {
        this.$message.error('只能输入正整数');
        this.form.sort = null;
      }
    },


    /** 查询微生物检测内容列表 */
    getList() {
      this.loading = true;
      listBaseMicrobedtl(this.queryParams).then(response => {
        this.microbedtlList = response.rows;
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
        microbeId: null,
        judgmentMode: null,
        standardValue: null,
        upFloatingValue: null,
        downFloatingValue: null,
        sort: null,
        inspectItems: null,
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
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.form.microbeId = this.queryParams.microbeId;
      this.title = "添加微生物检测内容";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getBaseMicrobedtl(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改微生物检测内容";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateBaseMicrobedtl(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addBaseMicrobedtl(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除微生物检测内容编号为"' + ids + '"的数据项？').then(function() {
        return delBaseMicrobedtl(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('web/basemicrobedtl/export', {
        ...this.queryParams
      }, `microbedtl_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
