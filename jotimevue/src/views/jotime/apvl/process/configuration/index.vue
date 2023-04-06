<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="120px">
      <el-form-item label="配置名称" prop="processStepName">
        <el-input
          v-model="queryParams.processStepName"
          placeholder="请输入配置名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"

        />
      </el-form-item>
<!--      <el-form-item label="流程名称" prop="moduleId">-->
<!--        <el-input-->
<!--          v-model="queryParams.moduleId"-->
<!--          placeholder="请输入流程名称"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="流程名称" prop="moduleId">
        <el-select
          v-model="queryParams.moduleId"
          placeholder="请选择流程名称"
          clearable filterable
          size="small"
          style="width: 240px"
          @click.native="getModuleList()"
        >
          <el-option
            v-for="dict in moduleOptions"
            :key="dict.id"
            :label="dict.moduleName"
            :value="dict.id"
          />
        </el-select>
      </el-form-item>


<!--      <el-form-item label="审批方式 1 单人审批；2 多人审批" prop="apvlMethod">-->
<!--        <el-input-->
<!--          v-model="queryParams.apvlMethod"-->
<!--          placeholder="请输入审批方式 1 单人审批；2 多人审批"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->

      <el-form-item label="审批方式" prop="status">
        <el-select
          v-model="queryParams.apvlMethod"
          placeholder="审批方式"
          clearable
          size="small"
          style="width: 240px"
        >
          <el-option
            v-for="dict in dict.type.sys_jotime_approval_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>


<!--      <el-form-item label="上一个节点" prop="preNode">-->
<!--        <el-select-->
<!--          v-model="queryParams.preNode"-->
<!--          placeholder="上一个节点"-->
<!--          clearable filterable-->
<!--          size="small"-->
<!--          style="width: 240px"-->
<!--        >-->
<!--          <el-option-->
<!--            v-for="dict in nodeOptions"-->
<!--            :key="dict.id"-->
<!--            :label="dict.nodeName"-->
<!--            :value="dict.id"-->
<!--          />-->
<!--        </el-select>-->
<!--      </el-form-item>-->


<!--      <el-form-item label="下一个节点" prop="nextNode">-->
<!--        <el-select-->
<!--          v-model="queryParams.nextNode"-->
<!--          placeholder="下一个节点"-->
<!--          clearable filterable-->
<!--          size="small"-->
<!--          style="width: 240px"-->
<!--        >-->
<!--          <el-option-->
<!--            v-for="dict in nodeOptions"-->
<!--            :key="dict.id"-->
<!--            :label="dict.nodeName"-->
<!--            :value="dict.id"-->
<!--          />-->
<!--        </el-select>-->
<!--      </el-form-item>-->


<!--      <el-form-item label="驳回下一个节点" prop="rejectNextNode">-->
<!--        <el-select-->
<!--          v-model="queryParams.rejectNextNode"-->
<!--          placeholder="驳回下一个节点"-->
<!--          clearable filterable-->
<!--          size="small"-->
<!--          style="width: 240px"-->
<!--        >-->
<!--          <el-option-->
<!--            v-for="dict in nodeOptions"-->
<!--            :key="dict.id"-->
<!--            :label="dict.nodeName"-->
<!--            :value="dict.id"-->
<!--          />-->
<!--        </el-select>-->
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
          v-hasPermi="['admin:configuration:add']"
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
          v-hasPermi="['admin:configuration:edit']"
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
          v-hasPermi="['admin:configuration:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['admin:configuration:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="configurationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="配置内码" align="center" prop="id" />-->
      <el-table-column label="配置名称" align="center" prop="processStepName" />
      <el-table-column label="流程名称" align="center" prop="moduleName" />
      <el-table-column label="审批方式" align="center" prop="apvlMethod" width="100">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_jotime_approval_type" :value="scope.row.apvlMethod"/>
        </template>
      </el-table-column>
      <el-table-column label="上一个节点" align="center" prop="preNodeName" />
      <el-table-column label="下一个节点" align="center" prop="nextNodeName" />
      <el-table-column label="驳回下一个节点" align="center" prop="rejectNextNodeName" />
      <el-table-column label="状态" align="center" prop="status"  width="100" >
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
            v-hasPermi="['admin:configuration:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['admin:configuration:remove']"
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

    <!-- 添加或修改审批流程配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="配置名称" prop="processStepName">
          <el-input v-model="form.processStepName" placeholder="请输入流程名称" />
        </el-form-item>
<!--        <el-form-item label="流程内码" prop="moduleId">-->
<!--          <el-input v-model="form.moduleId" placeholder="请输入流程内码" />-->
<!--        </el-form-item>-->
            <el-form-item label="流程名称" prop="moduleId">
              <el-select v-model="form.moduleId" placeholder="请选择" clearable filterable
               @click.native="getModuleList()"
               @change="getNodeList($event)"
              >
                <el-option
                  v-for="item in moduleOptions"
                  :key="item.id"
                  :label="item.moduleName"
                  :value="item.id"
                  :disabled="item.status == 1"
                ></el-option>
              </el-select>
            </el-form-item>

<!--        <el-form-item label="审批方式 1 单人审批；2 多人审批" prop="apvlMethod">-->
<!--          <el-input v-model="form.apvlMethod" placeholder="请输入审批方式 1 单人审批；2 多人审批" />-->
<!--        </el-form-item>-->

        <el-form-item label="审批方式" prop="apvlMethod">
          <el-select v-model="form.apvlMethod" placeholder="请选择">
            <el-option
              v-for="dict in dict.type.sys_jotime_approval_type"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>





<!--        <el-form-item label="流程上一个节点" prop="preNode">-->
<!--          <el-input v-model="form.preNode" placeholder="请输入流程上一个节点" />-->
<!--        </el-form-item>-->

            <el-form-item label="上一个节点" prop="preNode">
              <el-select v-model="form.preNode" placeholder="请选择" clearable filterable>
                <el-option
                  v-for="item in nodeOptions"
                  :key="item.id"
                  :label="item.nodeName"
                  :value="item.id"
                  :disabled="item.status == 1"
                ></el-option>
              </el-select>
            </el-form-item>



            <el-form-item label="下一个节点" prop="nextNode">
              <el-select v-model="form.nextNode" placeholder="请选择" clearable filterable>
                <el-option
                  v-for="item in nodeOptions"
                  :key="item.id"
                  :label="item.nodeName"
                  :value="item.id"
                  :disabled="item.status == 1"
                ></el-option>
              </el-select>
            </el-form-item>



<!--        <el-form-item label="正常流程下一个节点" prop="nextNode">-->
<!--          <el-input v-model="form.nextNode" placeholder="请输入正常流程下一个节点" />-->
<!--        </el-form-item>-->


<!--        <el-form-item label="驳回流程下一个节点" prop="rejectNextNode">-->
<!--          <el-input v-model="form.rejectNextNode" placeholder="请输入驳回流程下一个节点" />-->
<!--        </el-form-item>-->

        <el-form-item label="驳回下一个节点" prop="rejectNextNode">
          <el-select v-model="form.rejectNextNode" placeholder="请选择" clearable filterable>
            <el-option
              v-for="item in nodeOptions"
              :key="item.id"
              :label="item.nodeName"
              :value="item.id"
              :disabled="item.status == 1"
            ></el-option>
          </el-select>
        </el-form-item>

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
  </div>
</template>

<script>
import { listConfiguration, getConfiguration, delConfiguration, addConfiguration, updateConfiguration } from "@/api/jotime/apvl/process/configuration";
import { getModuleList } from "@/api/jotime/apvl/process/module";
import { getNodeList } from "@/api/jotime/apvl/process/node";

export default {
  name: "Configuration",
  dicts: ['sys_jotime_data_status','sys_jotime_approval_type'],
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
      // 审批流程配置表格数据
      configurationList: [],
      //查询下拉框专用
      moduleOptions:[],
      moduleOptionsIsNull:true,
      //
      nodeOptions:[],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        processStepName: null,
        moduleId: null,
        moduleName:null,
        apvlMethod: null,
        preNodeName: null,
        preNode: null,
        nextNode: null,
        nextNodeName: null,
        rejectNextNode: null,
        rejectNextNodeName: null,
        status: null,
        note: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        processStepName: [
          { required: true, message: "流程名称不能为空", trigger: "blur" }
        ],
        moduleId: [
          { required: true, message: "流程内码不能为空", trigger: "blur" }
        ],
        apvlMethod: [
          { required: true, message: "审批方式 1 单人审批；2 多人审批不能为空", trigger: "blur" }
        ],
        preNode: [
          { required: true, message: "流程上一个节点不能为空", trigger: "blur" }
        ],
        nextNode: [
          { required: true, message: "正常流程下一个节点不能为空", trigger: "blur" }
        ],
        rejectNextNode: [
          { required: true, message: "驳回流程下一个节点不能为空", trigger: "blur" }
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
    /** 查询审批流程配置列表 */
    getList() {
      this.loading = true;
      listConfiguration(this.queryParams).then(response => {
        this.configurationList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    getNodeList(val){
      if(val != null && val != '' && val != undefined){
        getNodeList(val,-1).then(response => {
          //给nodeOptions数组赋值
          this.nodeOptions = response.nodeOptions;
        })
      }else {
        this.nodeOptions = [];
        this.resetForm("queryForm");
      }
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    //获取流程列表
    getModuleList(){
      if (this.moduleOptionsIsNull){
        getModuleList().then(response => {
          this.moduleOptions = response.moduleOptions;
        });
        this.moduleOptionsIsNull=false;
      }
    },
    // 表单重置
    reset() {
      this.nodeOptions=[],
      this.form = {
        id: null,
        processStepName: null,
        moduleId: null,
        apvlMethod: null,
        nextNode: null,
        rejectNextNode: null,
        status: 2,
        preNodeName: null,
        preNode: null,
        nextNodeName:null,
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
      this.title = "添加用户";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.getModuleList();
      const id = row.id || this.ids
      getConfiguration(id).then(response => {
        this.form = response.data;
        this.nodeOptions = response.nodeOption;
        this.open = true;
        this.title = "修改审批流程配置";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateConfiguration(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addConfiguration(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除审批流程配置编号为"' + ids + '"的数据项？').then(function() {
        return delConfiguration(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('admin/configuration/export', {
        ...this.queryParams
      }, `configuration_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
