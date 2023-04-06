<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="110px">
      <el-form-item label="关联的业务表名" prop="tableName">
        <el-input
          v-model="queryParams.tableName"
          placeholder="请输入关联的业务表名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="关联表数据的id" prop="tableId">
        <el-input
          v-model="queryParams.tableId"
          placeholder="请输入关联表数据的id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="文件名" prop="fileName">
        <el-input
          v-model="queryParams.fileName"
          placeholder="请输入文件名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="操作时间" prop="operateTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.operateTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择操作时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>


    <el-table v-loading="loading" :data="manageList">
      <el-table-column width="55" align="center" />
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="关联的业务表名" align="center" prop="tableName" width="300px"/>
      <el-table-column label="关联表数据的id" align="center" prop="tableId" />
      <el-table-column label="标识" align="center" prop="tableType" />
      <el-table-column label="主题描述" align="center" prop="title" width="300px"/>
      <el-table-column label="文件名" align="center" prop="fileName" width="300px"/>
      <el-table-column label="文件类型" align="center" prop="fileType" width="500px"/>
      <el-table-column label="文件url地址" align="center" prop="fileUrl" width="800px"/>
      <el-table-column label="扩展名" align="center" prop="originalFileName" />
      <el-table-column label="文件大小" align="center" prop="fileSize" />
      <el-table-column label="操作人" align="center" prop="operator" />
      <el-table-column label="操作人编码" align="center" prop="operatorCode" />
      <el-table-column label="操作时间" align="center" prop="operateTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.operateTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="note" />
      <el-table-column label="逻辑删除" align="center" prop="isDelete" >
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.sys_yes_no"
            :value="scope.row.isDelete"
          />
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.sys_jotime_data_status"
            :value="scope.row.status"
          />
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

    <!-- 添加或修改描述 研发文件管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="关联的业务表名(建议使用表明驼峰作为标识，不遵守也可，但要保证其业务唯一性)" prop="tableName">
          <el-input v-model="form.tableName" placeholder="请输入关联的业务表名(建议使用表明驼峰作为标识，不遵守也可，但要保证其业务唯一性)" />
        </el-form-item>
        <el-form-item label="关联表数据的id，查询时可通过表名 和 id拿到具体的文件数据" prop="tableId">
          <el-input v-model="form.tableId" placeholder="请输入关联表数据的id，查询时可通过表名 和 id拿到具体的文件数据" />
        </el-form-item>
        <el-form-item label="主题描述" prop="title">
          <el-input v-model="form.title" placeholder="请输入主题描述" />
        </el-form-item>
        <el-form-item label="文件名" prop="fileName">
          <el-input v-model="form.fileName" placeholder="请输入文件名" />
        </el-form-item>
        <el-form-item label="文件url地址" prop="fileUrl">
          <el-input v-model="form.fileUrl" placeholder="请输入文件url地址" />
        </el-form-item>
        <el-form-item label="扩展名" prop="originalFileName">
          <el-input v-model="form.originalFileName" placeholder="请输入扩展名" />
        </el-form-item>
        <el-form-item label="文件大小" prop="fileSize">
          <el-input v-model="form.fileSize" placeholder="请输入文件大小" />
        </el-form-item>
        <el-form-item label="操作人" prop="operator">
          <el-input v-model="form.operator" placeholder="请输入操作人" />
        </el-form-item>
        <el-form-item label="操作人编码" prop="operatorCode">
          <el-input v-model="form.operatorCode" placeholder="请输入操作人编码" />
        </el-form-item>
        <el-form-item label="操作时间" prop="operateTime">
          <el-date-picker clearable size="small"
            v-model="form.operateTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择操作时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="备注" prop="note">
          <el-input v-model="form.note" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="逻辑删除(1 否 2 是)" prop="isDelete">
          <el-input v-model="form.isDelete" placeholder="请输入逻辑删除(1 否 2 是)" />
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
import { listManage, getManage, delManage, addManage, updateManage } from "@/api/jotime/file/RdFileManage";

export default {
  name: "Manage",
  dicts: [
    "sys_yes_no",
    "sys_jotime_data_status" ,
  ],
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
      // 描述 研发文件管理表格数据
      manageList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        tableName: null,
        tableId: null,
        tableType: null,
        title: null,
        fileName: null,
        fileType: null,
        fileUrl: null,
        originalFileName: null,
        fileSize: null,
        operator: null,
        operatorCode: null,
        operateTime: null,
        note: null,
        isDelete: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        fileUrl: [
          { required: true, message: "文件url地址不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询描述 研发文件管理列表 */
    getList() {
      this.loading = true;
      listManage(this.queryParams).then(response => {
        this.manageList = response.rows;
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
        tableName: null,
        tableId: null,
        tableType: null,
        title: null,
        fileName: null,
        fileType: null,
        fileUrl: null,
        originalFileName: null,
        fileSize: null,
        operator: null,
        operatorCode: null,
        operateTime: null,
        note: null,
        isDelete: null,
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
      this.title = "添加描述 研发文件管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getManage(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改描述 研发文件管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateManage(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addManage(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除描述 研发文件管理编号为"' + ids + '"的数据项？').then(function() {
        return delManage(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('web/manage/export', {
        ...this.queryParams
      }, `manage_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
