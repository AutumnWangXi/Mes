<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
<!--      <el-form-item label="班组id" prop="groupId">-->
<!--        <el-input-->
<!--          v-model="queryParams.groupId"-->
<!--          placeholder="请输入班组id"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="车间" prop="workshopId"  >
        <el-select
          v-model="queryParams.workshopId"
          placeholder="请选择仓库"
          clearable
          filterable
          size="small"
          style="width: 200px"
        >
          <el-option
            v-for="dict in workShopListQuery"
            :key="dict.id"
            :label="dict.workshopName"
            :value="dict.id"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="班组" prop="groupId"  >
        <el-select
          v-model="queryParams.groupId"
          placeholder="请选择仓库"
          clearable
          filterable
          size="small"
          style="width: 200px"
        >
          <el-option
            v-for="dict in groupListQuery"
            :key="dict.id"
            :label="dict.groupName"
            :value="dict.id"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="组员编码" prop="userId"  >
        <el-select
          v-model="queryParams.userId"
          placeholder="请选择组员编码"
          clearable
          filterable
          size="small"
          style="width: 200px"
        >
          <el-option
            v-for="dict in infoListQuery"
            :key="dict.id"
            :label="dict.employeeCode"
            :value="dict.id"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="组员名称" prop="userId"  >
        <el-select
          v-model="queryParams.userId"
          placeholder="请选择组员名称"
          clearable
          filterable
          size="small"
          style="width: 200px"
        >
          <el-option
            v-for="dict in infoListQuery"
            :key="dict.id"
            :label="dict.employeeName"
            :value="dict.id"
          />
        </el-select>
      </el-form-item>
<!--      <el-form-item label="组员" prop="userId">-->
<!--        <el-input-->
<!--          v-model="queryParams.userId"-->
<!--          placeholder="请输入组员"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->





      <el-form-item label="班组编码" prop="groupCode">
        <el-input
          v-model="queryParams.groupCode"
          placeholder="请输入班组编码"
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
          v-hasPermi="['admin:groupuser:add']"
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
          v-hasPermi="['admin:groupuser:edit']"
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
          v-hasPermi="['admin:groupuser:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['admin:groupuser:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="groupuserList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="id" align="center" prop="id" />-->
<!--      <el-table-column label="班组id" align="center" prop="groupId" />-->
      <el-table-column label="车间名称" align="center" prop="workshopName" />
      <el-table-column label="班组名称" align="center" prop="groupName" />
<!--      <el-table-column label="车间id" align="center" prop="workshopId" />-->

      <el-table-column label="班组编码" align="center" prop="groupCode" />
<!--      <el-table-column label="状态" align="center" prop="status" />-->

<!--      <el-table-column label="组员" align="center" prop="userId" />-->
      <el-table-column label="组员编码" align="center" prop="userCode" />
      <el-table-column label="组员名称" align="center" prop="userName" />
      <el-table-column label="状态" align="center" prop="status"  width="100" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_base_groupuser_status" :value="scope.row.status"/>
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
            v-hasPermi="['admin:groupuser:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['admin:groupuser:remove']"
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

    <!-- 添加或修改班组人员管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
<!--        <el-form-item label="班组id" prop="groupId">-->
<!--          <el-input v-model="form.groupId" placeholder="请输入班组id" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="班组" prop="groupId">-->
<!--          <el-select v-model="form.groupId" placeholder="请选择"-->

<!--                     clearable filterable>-->
<!--            <el-option-->
<!--              v-for="item in groupList"-->
<!--              :key="item.id"-->
<!--              :label="item.groupName"-->
<!--              :value="parseInt(item.id)"-->
<!--            ></el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
        <el-form-item label="车间" prop="workshopId">
          <el-select v-model="form.workshopId" @change="getGroupList($event)" placeholder="请选择"  clearable filterable>
            <el-option
              v-for="item in this.workShopList"
              :key="item.id"
              :label="item.workshopName"
              :value="String(item.id)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="班组" prop="groupId">
          <el-select v-model="form.groupId"  filterable placeholder="请选择">
            <el-option
              v-for="item in groupList"
              :key="item.id"
              :label="item.groupName"
              :value="String(item.id)">
            </el-option>
          </el-select>
        </el-form-item>
<!--        <el-form-item label="车间id" prop="workshopId">-->
<!--          <el-input v-model="form.workshopId" placeholder="请输入属于哪个车间：id" />-->
<!--        </el-form-item>-->

<!--        <el-form-item label="班组编码" prop="groupCode">-->
<!--          <el-input v-model="form.groupCode" placeholder="请输入班组编码" />-->
<!--        </el-form-item>-->

<!--        <el-form-item label="班组编码" prop="groupCode">-->
<!--          <el-select v-model="form.groupCode" placeholder="请选择" clearable filterable disabled>-->
<!--            <el-option-->
<!--              v-for="item in groupList"-->
<!--              :key="item.id"-->
<!--              :label="item.groupCode"-->
<!--              :value="Number(item.groupCode)"-->
<!--            ></el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="组员" prop="userId">-->
<!--          <el-input v-model="form.userId" placeholder="请输入组员" />-->
<!--        </el-form-item>-->

        <el-form-item label="组员" prop="userId">
          <el-select v-model="form.userId" placeholder="请选择" clearable filterable>
            <el-option
              v-for="item in infoList"
              :key="item.id"
              :label="item.employeeName"
              :value="String(item.id)"
            ></el-option>
          </el-select>
        </el-form-item>


        <el-form-item label="备注" prop="note">
          <el-input v-model="form.note" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.sys_base_groupuser_status"
              :key="dict.value"
              :label="Number(dict.value)"
            >{{dict.label}}</el-radio>
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
import { listGroupuser,listGroupuserVo, getGroupuser, delGroupuser, addGroupuser, updateGroupuser } from "@/api/jotime/base/basics/groupuser";
import {listGroup,getWorkGroupList}from "@/api/jotime/base/basics/group";
import {listWorkshop}from "@/api/jotime/base/basics/workshop"
import {listInfo} from "@/api/jotime/employee/employee";

export default {
  name: "Groupuser",
  dicts: ['sys_base_groupuser_status'],
  data() {
    return {
      //
      groupList:[],
      workShopList:[],
      groupListQuery:[],
      workShopListQuery:[],
      infoList:[],
      infoListQuery:[],
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
      // 班组人员管理表格数据
      groupuserList: [],

      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        groupId: null,
        workshopId: null,
        groupCode: null,
        status: null,
        userId: null,
        note: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        // groupCode: [
        //   { required: true, message: "班组编码不能为空", trigger: "blur" }
        // ],
        workshopId: [
          { required: true, message: "车间不能为空", trigger: "blur" }
        ],
        userId: [
          { required: true, message: "组员不能为空", trigger: "blur" }
        ],
        groupId: [
          { required: true, message: "班组不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询班组人员管理列表 */
    getList() {
      this.loading = true;
      listGroupuserVo(this.queryParams).then(response => {
        this.groupuserList = response.rows;
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
        groupId: null,
        workshopId: null,
        groupCode: 1,
        status: 2,
        userId: null,
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
      this.title = "添加班组人员管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getGroupuser(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改班组人员管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateGroupuser(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addGroupuser(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除班组人员管理编号为"' + ids + '"的数据项？').then(function() {
        return delGroupuser(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('admin/groupuser/export', {
        ...this.queryParams
      }, `groupuser_${new Date().getTime()}.xlsx`)
    },
    //主页查询时调用//根据流程获取相应节点
    getGroupList(workShopId){
      console.log(workShopId);
      if(workShopId != null && workShopId != '' && workShopId != undefined){
        getWorkGroupList(workShopId).then(response => {
          //给groupList数组赋值
          this.groupList = response.data;
        })
      }
    },
  },

  mounted() {
    listGroup().then(response=>{
      this.groupList = response.rows;
      this.groupListQuery=response.rows;
    });
    listWorkshop().then(response=>{
      this.workShopList = response.rows;
      this.workShopListQuery = response.rows;
    });
    listInfo().then(response=>{
      this.infoList = response.rows;
      this.infoListQuery = response.rows;
    });
  }
};
</script>
