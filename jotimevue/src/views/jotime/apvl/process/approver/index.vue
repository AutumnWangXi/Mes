<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
            <el-form-item label="流程" prop="moduleId">
              <el-select v-model="queryParams.moduleId" @change="getNodeList($event)" clearable filterable placeholder="请选择流程">
                <el-option v-for="item in moduleOptions" :label="item.moduleName" :key="item.id" :value="item.id">
                </el-option>
              </el-select>
            </el-form-item>
      <el-form-item label="节点" prop="nodeId">
        <el-select v-model="queryParams.nodeId" clearable placeholder="请选择节点" filterable>
          <el-option v-for="item in nodeOptions" :label="item.nodeName" :key="item.id" :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>



<!--      <el-form-item label="节点内码" prop="nodeId">-->
<!--        <el-input-->
<!--          v-model="queryParams.nodeId"-->
<!--          placeholder="请输入节点内码"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="审批人内码" prop="approverId">-->
<!--        <el-input-->
<!--          v-model="queryParams.approverId"-->
<!--          placeholder="请输入审批人内码"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="审批人名称" prop="approver">-->
<!--        <el-input-->
<!--          v-model="queryParams.approver"-->
<!--          placeholder="请输入审批人名称"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
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
          v-hasPermi="['admin:approver:add']"
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
          v-hasPermi="['admin:approver:edit']"
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
          v-hasPermi="['admin:approver:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['admin:approver:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="approverList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="审批人员内码" align="center" prop="id" />-->
      <el-table-column label="流程" align="center" prop="moduleName" />
      <el-table-column label="节点" align="center" prop="nodeName" />
<!--      <el-table-column label="审批人内码" align="center" prop="approverId" />-->
      <el-table-column label="审批人名称" align="center" prop="approver" />
<!--      <el-table-column label="状态 1 删除  2 正常" align="center" prop="status" />-->

      <el-table-column label="状态" align="center" prop="status"   width="100">
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
            v-hasPermi="['admin:approver:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['admin:approver:remove']"
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

    <!-- 添加或修改审批人员对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form"  :rules="rules" label-width="80px">
<!--        <el-form-item label="流程内码" prop="moduleId">-->
<!--          <el-input v-model="form.moduleId" placeholder="请输入流程内码" />-->
<!--        </el-form-item>-->

        <el-form-item label="流程" prop="moduleId" >
          <el-select v-model="form.moduleId" clearable filterable placeholder="请选择"  @change="getNodeList($event)">
            <el-option
              v-for="item in moduleOptions"
              :key="item.id"
              :label="item.moduleName"
              :value="item.id"
              :disabled="item.status == 1"
            ></el-option>
          </el-select>
        </el-form-item>


<!--        <el-form-item label="节点内码" prop="nodeId">-->
<!--          <el-input v-model="form.nodeId" placeholder="请输入节点内码" />-->
<!--        </el-form-item>-->
        <el-form-item label="节点" prop="nodeId">
          <el-select  v-model="form.nodeId"  clearable filterable placeholder="请选择">
            <el-option
              v-for="item in nodeOptions"
              :key="item.id"
              :label="item.nodeName"
              :value="item.id"
              :disabled="item.status == 1"
            ></el-option>
          </el-select>
        </el-form-item>


        <el-form-item style="margin-right: 10px" label="审批人"  >
          <el-input
            placeholder="请输入"
            v-model="form.approver"
            @click.native="openDialog"
          ></el-input>
          <!-- <el-button @click="openDialog"></el-button> -->
        </el-form-item>

        <el-form-item style="margin-right: 10px" label="审批人内码" hidden>
          <el-input
            placeholder="请输入"
            v-model="form.approverId"
            @click.native="openDialog"
          ></el-input>
          <!-- <el-button @click="openDialog"></el-button> -->
        </el-form-item>

<!--        <el-form-item label="审批人内码" prop="approverId">-->
<!--          <el-input v-model="form.approverId" placeholder="请输入审批人内码" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="审批人名称" prop="approver">-->
<!--          <el-input v-model="form.approver" placeholder="请输入审批人名称" />-->
<!--        </el-form-item>-->
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.sys_jotime_data_status"
              :key="dict.value"
              :label="Number(dict.value)"
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
    <Dialog @getData='list' @getDataNickName="nickNameList"  ref="ccToId"/>
  </div>
</template>

<script>
import { listApprover, getApprover, delApprover, addApprover, updateApprover } from "@/api/jotime/apvl/process/approver";
import { getModuleList } from "@/api/jotime/apvl/process/module";
import { getNodeList } from "@/api/jotime/apvl/process/node";
import Dialog from "../../formula/dialog.vue";

export default {
  name: "Approver",
  components: { Dialog},
  dicts: ['sys_jotime_data_status','sys_yes_no','sys_base_device_status'],
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
      // 审批人员表格数据
      approverList: [],
      //流程列表
      moduleOptions:[],
      nodeOptions:[],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        moduleId: null,
        moduleName: null,
        nodeId: null,
        nodeName: null,
        approverId: null,
        approver: null,
        status: null,
        note: null,
      },
      // 表单参数
      form: {
      },
      // 表单校验
      rules: {
        moduleId: [
          { required: true, message: "流程内码不能为空", trigger: "blur" }
        ],
        nodeId: [
          { required: true, message: "节点内码不能为空", trigger: "blur" }
        ],
        approverId: [
          { required: true, message: "审批人内码不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "状态 1 删除  2 正常不能为空", trigger: "blur" }
        ],
        createBy: [
          { required: true, message: "创建人不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "$comment不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();

  },
  methods: {
    /** 查询审批人员列表 */
    getList() {
      this.loading = true;
      this.reset();
      getModuleList().then(response => {
        this.moduleOptions = response.moduleOptions;
      });
      listApprover(this.queryParams).then(response => {
        this.approverList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    //抄送人弹出
    openDialog() {
      this.$refs.ccToId.dialogVisible = true;
    },
    // 抄送
    nickNameList(data) {
      this.form.approver = data + ''
      this.$forceUpdate()
      console.log(this.form.approverId)
    },
    //
    list(data) {
      this.form.approverId = data + ''
      this.$forceUpdate()
      console.log(this.form.approverId)
    },
    //主页查询时调用//根据流程获取相应节点
    getNodeList(val){
      if(val != null && val != '' && val != undefined){
        getNodeList(val,1).then(response => {
            //给nodeOptions数组赋值
            this.nodeOptions = response.nodeOptions;
          })
      }else {
        this.nodeOptions = [];
        this.resetForm("queryForm");
      }
    },
    //添加或修改时调，根据流程获取相应节点


    // 取消按钮
    cancel() {
      this.open = false;
      this.resetForm('queryForm');
      this.reset();
    },
    // 表单重置
    reset() {
      this.nodeOptions=[];
      this.form = {
        id: null,
        moduleId: null,
        nodeId: null,
        approverId: null,
        approver: null,
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
      this.resetForm("queryForm");
      this.open = true;
      this.title = "添加审批人员";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getApprover(id).then(response => {
        this.form = response.data;
        this.nodeOptions = response.nodeOption;
        this.open = true;
        this.title = "修改审批人员";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateApprover(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addApprover(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
      this.resetForm("form");
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除审批人员编号为"' + ids + '"的数据项？').then(function() {
        return delApprover(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('admin/approver/export', {
        ...this.queryParams
      }, `approver_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
