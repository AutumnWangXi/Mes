<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="85px">
      <el-form-item label="审批编号" prop="apvlNo">
        <el-input
          v-model="queryParams.apvlNo"
          placeholder="请输入审批编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="流程内码" prop="moduleId">
        <el-input
          v-model="queryParams.moduleId"
          placeholder="请输入流程内码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="审批人内码" prop="approverId">
        <el-input
          v-model="queryParams.approverId"
          placeholder="请输入审批人内码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="审批人" prop="approver">
        <el-input
          v-model="queryParams.approver"
          placeholder="请输入审批人"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="审批方式" prop="apvlMethod">
        <el-select v-model="queryParams.apvlMethod" placeholder="请选择审批方式" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_jotime_approval_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="审批时间" prop="apvlTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.apvlTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择审批时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="审批结果" prop="apvlResult">
        <el-select v-model="queryParams.apvlResult" placeholder="请选择审批结果" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_jotime_approva_result"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="当前节点" prop="curNodeId">
        <el-input
          v-model="queryParams.curNodeId"
          placeholder="请输入当前节点"
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
          v-hasPermi="['admin:process:add']"
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
          v-hasPermi="['admin:process:edit']"
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
          v-hasPermi="['admin:process:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['admin:process:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="processList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="流程节点编号，主键" align="center" prop="id" />-->
      <el-table-column label="审批编号" align="center" prop="apvlNo" />
      <el-table-column label="流程名称" align="center" prop="moduleName" />
<!--      <el-table-column label="审批人内码" align="center" prop="approverId" />-->
      <el-table-column label="审批人" align="center" prop="approver" />
      <el-table-column label="审批方式" align="center" prop="apvlMethod">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_jotime_approval_type" :value="scope.row.apvlMethod"/>
        </template>
      </el-table-column>
      <el-table-column label="审批时间" align="center" prop="apvlTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.apvlTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="评论" align="center" prop="apvlComment" />
<!--      <el-table-column label="附件1" align="center" prop="attachmentUrl1" />-->
<!--      <el-table-column label="附件2" align="center" prop="attachmentUrl2" />-->
<!--      <el-table-column label="附件3" align="center" prop="attachmentUrl3" />-->
<!--      <el-table-column label="附件4" align="center" prop="attachmentUrl4" />-->
      <el-table-column label="审批结果" align="center" prop="apvlResult">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_jotime_approva_result" :value="scope.row.apvlResult"/>
        </template>
      </el-table-column>
      <el-table-column label="当前节点" align="center" prop="curNodeName" />
      <el-table-column label="备注" align="center" prop="note" />
      <el-table-column label="创建者id" align="center" prop="creatorName" />
      <el-table-column label="创建时间" align="center" prop="creatorTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.creatorTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="更新者ID" align="center" prop="modifiedName" />
      <el-table-column label="更新时间" align="center" prop="modifiedTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.modifiedTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" fixed="right">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['admin:process:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['admin:process:remove']"
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

    <!-- 添加或修改审批流程记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="审批编号" prop="apvlNo">
          <el-input v-model="form.apvlNo" placeholder="请输入审批编号" />
        </el-form-item>
        <el-form-item label="流程内码" prop="moduleId">
          <el-input v-model="form.moduleName" placeholder="请输入流程内码" />
        </el-form-item>
<!--        <el-form-item label="审批人内码" prop="approverId">-->
<!--          <el-input v-model="form.approverId" placeholder="请输入审批人内码" />-->
<!--        </el-form-item>-->
        <el-form-item label="审批人" prop="approver">
          <el-input v-model="form.approver" placeholder="请输入审批人" />
        </el-form-item>
        <el-form-item label="审批方式" prop="apvlMethod">
          <el-select v-model="form.apvlMethod" placeholder="请选择审批方式">
            <el-option
              v-for="dict in dict.type.sys_jotime_approval_type"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="审批时间" prop="apvlTime">
          <el-date-picker clearable size="small"
            v-model="form.apvlTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择审批时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="评论" prop="apvlComment">
          <el-input v-model="form.apvlComment" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="附件1" prop="attachmentUrl1">
          <el-input v-model="form.attachmentUrl1" placeholder="请输入附件1" />
        </el-form-item>
        <el-form-item label="附件2" prop="attachmentUrl2">
          <el-input v-model="form.attachmentUrl2" placeholder="请输入附件2" />
        </el-form-item>
        <el-form-item label="附件3" prop="attachmentUrl3">
          <el-input v-model="form.attachmentUrl3" placeholder="请输入附件3" />
        </el-form-item>
        <el-form-item label="附件4" prop="attachmentUrl4">
          <el-input v-model="form.attachmentUrl4" placeholder="请输入附件4" />
        </el-form-item>
        <el-form-item label="审批结果" prop="apvlResult">
          <el-select v-model="form.apvlResult" placeholder="请选择审批结果">
            <el-option
              v-for="dict in dict.type.sys_jotime_approva_result"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="当前节点" prop="curNodeId">
          <el-input v-model="form.curNodeId" placeholder="请输入当前节点" />
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
import { listProcess, getProcess, delProcess, addProcess, updateProcess } from "@/api/jotime/apvl/process/process";

export default {
  name: "Process",
  dicts: ['sys_jotime_approval_type', 'sys_jotime_approva_result'],
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
      // 审批流程记录表格数据
      processList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        apvlNo: null,
        moduleId: null,
        approverId: null,
        approver: null,
        apvlMethod: null,

        moduleName:null,
        creatorName:null,
        modifiedName:null,

        apvlTime: null,
        apvlComment: null,
        apvlResult: null,
        curNodeId: null,
        curNodeName:null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        apvlNo: [
          { required: true, message: "审批编号不能为空", trigger: "blur" }
        ],
        moduleId: [
          { required: true, message: "流程内码不能为空", trigger: "blur" }
        ],
        approverId: [
          { required: true, message: "审批人内码不能为空", trigger: "blur" }
        ],
        approver: [
          { required: true, message: "审批人内码不能为空", trigger: "blur" }
        ],
        apvlMethod: [
          { required: true, message: "审批方式'不能为空", trigger: "change" }
        ],
        apvlTime: [
          { required: true, message: "审批时间不能为空", trigger: "blur" }
        ],
        attachmentUrl4: [
          { required: true, message: "附件4不能为空", trigger: "blur" }
        ],
        apvlResult: [
          { required: true, message: "审批结果不能为空", trigger: "change" }
        ],
        curNodeId: [
          { required: true, message: "当前节点不能为空", trigger: "blur" }
        ],
        creatorId: [
          { required: true, message: "创建者id不能为空", trigger: "blur" }
        ],
        creatorTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询审批流程记录列表 */
    getList() {
      this.loading = true;
      listProcess(this.queryParams).then(response => {
        this.processList = response.rows;
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
        apvlNo: null,
        moduleId: null,
        approverId: null,
        approver: null,
        apvlMethod: null,
        apvlTime: null,
        apvlComment: null,
        attachmentUrl1: null,
        attachmentUrl2: null,
        attachmentUrl3: null,
        attachmentUrl4: null,
        apvlResult: null,
        curNodeId: null,
        curNodeName:null,
        note: null,
        creatorId: null,
        creatorTime: null,
        modifiedId: null,
        modifiedTime: null
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
      this.title = "添加审批流程记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getProcess(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改审批流程记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateProcess(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProcess(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除审批流程记录编号为"' + ids + '"的数据项？').then(function() {
        return delProcess(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('admin/process/export', {
        ...this.queryParams
      }, `process_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
