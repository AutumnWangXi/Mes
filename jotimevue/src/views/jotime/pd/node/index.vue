<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="节点编码" prop="nodeCode">
        <el-input
          v-model="queryParams.nodeCode"
          placeholder="请输入节点编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="节点名称" prop="nodeName">
        <el-input
          v-model="queryParams.nodeName"
          placeholder="请输入节点名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="流程" prop="moduleId">
        <el-select
          v-model="queryParams.moduleId"
          placeholder="请选择流程名称"
          clearable filterable
          size="small"
          style="width: 240px"
          @click.native="getModuleList()"
        >
          <el-option
            v-for="dict in selectOptions"
            :key="dict.id"
            :label="dict.moduleName"
            :value="dict.id"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="开始节点" prop="isStart">
        <el-select v-model="queryParams.isStart" filterable placeholder="请选择" style="width: 93%;">
          <el-option
            v-for="item in isStartOption"
            :key="item.key"
            :label="item.value"
            :value="item.key"
          >
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="微生物检测" prop="isMicrobeTests">
        <el-select v-model="queryParams.isStart" filterable placeholder="请选择" style="width: 93%;">
          <el-option
            v-for="item in isStartOption"
            :key="item.key"
            :label="item.value"
            :value="item.key"
          >
          </el-option>
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
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['web:node:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['web:node:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['web:node:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['web:node:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="nodeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="节点编码" align="center" prop="nodeCode"/>
      <el-table-column label="节点名称" align="center" prop="nodeName"/>
      <el-table-column label="流程名称" align="center" prop="moduleName"/>
      <el-table-column label="开始节点" align="center" prop="isStart">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_yes_no" :value="scope.row.isStart"/>
        </template>
      </el-table-column>
      <el-table-column label="微生物检测" align="center" prop="isMicrobeTests">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_yes_no" :value="scope.row.isMicrobeTests"/>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_jotime_data_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="note"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['web:node:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['web:node:remove']"
          >删除
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

    <!-- 添加或修改描述：生产流程节点对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="节点编码" prop="nodeCode">
          <el-input v-model="form.nodeCode" placeholder="请输入节点编码"/>
        </el-form-item>
        <el-form-item label="节点名称" prop="nodeName">
          <el-input v-model="form.nodeName" placeholder="请输入节点名称"/>
        </el-form-item>
        <el-form-item label="流程名称" prop="whName" v-if="form.id==null">
          <el-select v-model="form.moduleName" placeholder="请选择流程名称" @click.native="getModuleList(2)"
                     v-on:change="getModuleName($event)">
            <el-option v-for="(item,index) in this.moduleNameList" :key="item.moduleName" :label="item.moduleName"
                       :value="index"
                       :disabled="item.status === 1"/>
          </el-select>
        </el-form-item>
        <div hidden>
          <el-form-item label="流程内码" prop="moduleId">
            <el-input v-model="form.moduleId" placeholder="流程内码"/>
          </el-form-item>
        </div>
        <el-form-item label="开始节点">
          <el-radio-group v-model="form.isStart">
            <el-radio
              v-for="dict in dict.type.sys_yes_no"
              :key="dict.value"
              :label="Number(dict.value)"
            >{{ dict.label }}
            </el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="微生物检测">
          <el-radio-group v-model="form.isMicrobeTests">
            <el-radio
              v-for="dict in dict.type.sys_yes_no"
              :key="dict.value"
              :label="Number(dict.value)"
            >{{ dict.label }}
            </el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="状态">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.sys_jotime_data_status"
              :key="dict.value"
              :label="Number(dict.value)"
            >{{ dict.label }}
            </el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="备注" prop="note">
          <el-input v-model="form.note" type="textarea" placeholder="请输入内容"/>
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
import {listNode, getNode, delNode, addNode, updateNode, nodeDataList} from "@/api/jotime/pd/node";
import {listModule, moduleDataList} from "@/api/jotime/pd/module";

export default {
  name: "Node",
  dicts: ['sys_jotime_data_status', 'sys_yes_no'],
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
      // 描述：生产流程节点表格数据
      nodeList: [],
      // 弹出层标题
      title: "",
      //查询下拉框
      selectOptions: [],
      //节点信息
      nodeNameList: [],
      //流程信息
      moduleNameList: [],
      // 是否显示弹出层
      open: false,
      isStartOption: [
        {key: 1, value: '不是'},
        {key: 2, value: '是'}
      ],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        nodeCode: null,
        nodeName: null,
        moduleId: null,
        isStart: null,
        status: null,
        note: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {}
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /**查询流程信息*/
    getModuleList() {
        listModule().then(response => {
          this.moduleNameList = response.rows
        })
    },
    getModuleName(index) {
      this.form.moduleId = this.moduleNameList[index].id;
      this.form.moduleName = this.moduleNameList[index].moduleName;
      this.$forceUpdate()
    },
    /**查询节点信息*/
    getNodeList(type) {
      if (type === 1) {
        moduleDataList(this.queryParams).then(response => {
          this.selectOptions = response.rows
        })
      } else {
        const data = {}
        if (this.form.moduleId === null || this.form.moduleId === '') {
          alert("请先选择流程!");
        } else {
          data.moduleId = this.form.moduleId
          listNode(data).then(response => {
            this.selectOptions = response.rows
          })
        }
      }
    },
    /** 查询描述：生产流程节点列表 */
    getList() {
      this.loading = true;
      nodeDataList(this.queryParams).then(response => {
        this.nodeList = response.rows;
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
        nodeCode: null,
        nodeName: null,
        moduleId: null,
        isStart: null,
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
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加描述：生产流程节点";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getNode(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改描述：生产流程节点";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateNode(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addNode(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除描述：生产流程节点编号为"' + ids + '"的数据项？').then(function () {
        return delNode(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('web/node/export', {
        ...this.queryParams
      }, `node_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
