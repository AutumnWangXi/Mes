<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="检测编码" prop="testCode">
        <el-input
          v-model="queryParams.testCode"
          placeholder="请输入检测编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="检测模板名称" prop="testName">
        <el-input
          v-model="queryParams.testName"
          placeholder="请输入检测模板名称"
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
          v-hasPermi="['web:microbe:add']"
        >新增</el-button>
      </el-col>
     <!-- <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['web:microbe:export']"
        >导出</el-button>
      </el-col> -->
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="microbeList" @selection-change="handleSelectionChange">
      <el-table-column label="序号" type="index" align="center" prop="id" />
      <el-table-column label="检测编码" align="center" prop="testCode" />
      <el-table-column label="检测模板名称" align="center" prop="testName" >
         <template slot-scope="scope">
           <router-link :to="{path:'/quality/file/basemicrobedtl',query:{id: scope.row.id}}" class="link-type">
             <span>{{ scope.row.testName }}</span>
           </router-link>
         </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="note" />
      <el-table-column label="状态" align="center" prop="status" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_base_microbe_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['web:microbe:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-close"
            @click="upateStatus(scope.row,1)"
            v-hasPermi="['web:microbe:edit']"
            v-if="scope.row.status == 2"
          >禁用</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-check"
            v-if="scope.row.status == 1"
            @click="upateStatus(scope.row,2)"
            v-hasPermi="['web:microbe:edit']"
          >启用</el-button>
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

    <!-- 添加或修改微生物检测对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="检测编码" prop="testCode">
          <el-input v-model="form.testCode" placeholder="请输入检测编码" />
        </el-form-item>
        <el-form-item label="检测模板名称" prop="testName">
          <el-input v-model="form.testName" placeholder="请输入检测模板名称" />
        </el-form-item>
        <el-form-item label="备注" prop="note">
          <el-input v-model="form.note" placeholder="请输入备注" />
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
import { listBaseMicrobe, getBaseMicrobe, delBaseMicrobe, addBaseMicrobe, updateBaseMicrobe } from "@/api/jotime/base/microbe";

export default {
  name: "baseMicrobe",
  dicts: ['sys_base_microbe_status'],
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
      // 微生物检测表格数据
      microbeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        testCode: null,
        testName: null,
        note: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    //更新状态
    upateStatus(row,status){
      let param = {
        id : row.id,
        status:status
      }
      updateBaseMicrobe(param).then(response => {
        this.$modal.msgSuccess("更新成功");
        this.getList();
      });
    },

    /** 查询微生物检测列表 */
    getList() {
      this.loading = true;
      listBaseMicrobe(this.queryParams).then(response => {
        this.microbeList = response.rows;
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
        testCode: null,
        testName: null,
        note: null,
        status: 0,
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
      this.title = "添加微生物检测";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getBaseMicrobe(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改微生物检测";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateBaseMicrobe(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addBaseMicrobe(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除微生物检测编号为"' + ids + '"的数据项？').then(function() {
        return delBaseMicrobe(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('web/basemicrobe/export', {
        ...this.queryParams
      }, `microbe_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
