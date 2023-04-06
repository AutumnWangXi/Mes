<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
<!--      <el-form-item label="类型排序" prop="typeSort">-->
<!--        <el-input-->
<!--          v-model="queryParams.typeSort"-->
<!--          placeholder="请输入类型排序"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="名称" prop="typeLabel">
        <el-input
          v-model="queryParams.typeLabel"
          placeholder="请输入名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="类型键值" prop="typeValue">
        <el-input
          v-model="queryParams.typeValue"
          placeholder="请输入类型键值"
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
          v-hasPermi="['web:deviceTypedtl:add']"
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
          v-hasPermi="['web:deviceTypedtl:edit']"
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
          v-hasPermi="['web:deviceTypedtl:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['web:deviceTypedtl:export']"
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

    <el-table v-loading="loading" :data="deviceTypedtlList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="设备信息内码" align="center" prop="id" />-->
      <el-table-column label="设备类型" align="center" prop="deviceType" />
      <el-table-column label="名称" align="center" prop="typeLabel" />
      <el-table-column label="类型键值" align="center" prop="typeValue" />
      <el-table-column label="类型排序" align="center" prop="typeSort" />
      <el-table-column label="状态" align="center" prop="status">
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
            v-hasPermi="['web:deviceTypedtl:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['web:deviceTypedtl:remove']"
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

    <!-- 添加或修改设备类型详细对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="设备类型" prop="typeSort" >
          <el-input v-model="form.deviceType" placeholder="请输入类型排序" disabled />
        </el-form-item>

        <el-form-item label="名称" prop="typeLabel">
          <el-input v-model="form.typeLabel" placeholder="请输入类型标签" />
        </el-form-item>
        <el-form-item label="类型键值" prop="typeValue">
          <el-input v-model="form.typeValue" placeholder="请输入类型键值" />
        </el-form-item>
        <el-form-item label="类型排序" prop="typeSort">
<!--          <el-input v-model="form.typeSort" placeholder="请输入类型排序" />-->
          <el-input-number v-model="form.typeSort" controls-position="right" :min="0" />
        </el-form-item>
        <el-form-item label="状态">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.sys_jotime_data_status"
              :key="dict.value"
:label="parseInt(dict.value)"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="备注" prop="note">
          <el-input v-model="form.note" type="textarea" placeholder="请输入内容" />
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
import { listDeviceTypedtl, getDeviceTypedtl, delDeviceTypedtl, addDeviceTypedtl, updateDeviceTypedtl } from "@/api/jotime/base/basics/deviceTypedtl";

export default {
  name: "DeviceTypedtl",
  dicts: ['sys_jotime_data_status'],
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
      // 设备类型详细表格数据
      deviceTypedtlList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        deviceType: null,
        typeSort: null,
        typeLabel: null,
        typeValue: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        deviceType: [
          { required: true, message: "设备类型不能为空", trigger: "change" }
        ],
        typeSort: [
          { required: true, message: "类型排序不能为空", trigger: "blur" }
        ],
        typeLabel: [
          { required: true, message: "类型标签不能为空", trigger: "blur" }
        ],
        typeValue: [
          { required: true, message: "类型键值不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "状态不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    const deviceType = this.$route.params && this.$route.params.deviceType;
    this.getDeviceTypedtl(deviceType);
  },
  methods: {
    /** 查询字典类型详细 */
    getDeviceTypedtl(deviceType) {
      this.queryParams.deviceType = deviceType;
      this.getList();
    },
    /** 查询设备类型详细列表 */
    getList() {
      this.loading = true;
      listDeviceTypedtl(this.queryParams).then(response => {
        this.deviceTypedtlList = response.rows;
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
        deviceType: null,
        typeSort: null,
        typeLabel: null,
        typeValue: null,
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
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加设备类型详细";
      this.form.deviceType = this.queryParams.deviceType;
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getDeviceTypedtl(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改设备类型详细";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateDeviceTypedtl(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDeviceTypedtl(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 返回按钮操作 */
    handleClose() {
      const obj = { path: "/systeamsettings/device/deviceType" };
      this.$tab.closeOpenPage(obj);
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除设备类型详细编号为"' + ids + '"的数据项？').then(function() {
        return delDeviceTypedtl(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('web/deviceTypedtl/export', {
        ...this.queryParams
      }, `deviceTypedtl_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
