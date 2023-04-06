<style type="text/css">
td.el-table__cell.el-table__expanded-cell {
  padding-top: 0;
  padding-bottom: 0;
}
</style>
<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="班组编码" prop="groupCode">
        <el-input
          v-model="queryParams.groupCode"
          placeholder="请输入班组编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="班组名称" prop="groupName">
        <el-input
          v-model="queryParams.groupName"
          placeholder="请输入班组名称"
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
          v-hasPermi="['admin:group:add']"
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
          v-hasPermi="['admin:group:edit']"
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
          v-hasPermi="['admin:group:remove']"
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
          v-hasPermi="['admin:group:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="groupList" @selection-change="handleSelectionChange">

      <el-table-column type="expand">
        <template slot-scope="scope">
          <el-table :data="scope.row.baseGroupusers" style="width: 92%; left: 8%">
            <el-table-column align="center" label="编码" prop="userCode">
            </el-table-column>
            <el-table-column align="center" label="组员" prop="userName">
            </el-table-column>
            <el-table-column align="center" label="车间名称" prop="workshopName">
            </el-table-column>
            <el-table-column align="center" label="状态" prop="status">
              <template slot-scope="scope">
                <dict-tag :options="dict.type.sys_base_groupuser_status" :value="scope.row.status"/>
              </template>
            </el-table-column>
            <el-table-column align="center" label="备注" prop="note">
            </el-table-column>
            <!--            <el-table-column width="80px" align="center" label="公关配方" prop="attackFormulationCount">-->
            <!--            </el-table-column>-->
            <!--            <el-table-column width="80px" align="center" label="创新配方" prop="innovativeFormulationCount">-->
            <!--            </el-table-column>-->
            <!--            <el-table-column width="100px" align="center" label="打样状态" prop="status" :formatter="statusFormat">-->
            <!--            </el-table-column>-->
            <!--            <el-table-column label="实验室评估" align="center" prop="laboratoryEvaluationResult" width="100px">-->
            <!--              <template slot-scope="scope">-->
            <!--                <el-button-->
            <!--                  size="mini"-->
            <!--                  type="text"-->
            <!--                  icon="el-icon-edit"-->
            <!--                  @click="fileUploadA(scope.row,1)"-->
            <!--                  v-hasPermi="['web:deptFormulatask:edit']"-->
            <!--                  v-if="scope.row.status == 4 || scope.row.laboratoryEvaluationResult == 1 || scope.row.laboratoryEvaluationResult ==2"-->
            <!--                >实验室评估-->
            <!--                </el-button>-->
            <!--              </template>-->
            <!--            </el-table-column>-->
            <!--            <el-table-column width="72px" label="评估状态" prop="laboratoryEvaluationResult" align="center">-->
            <!--              <template slot-scope="scope">-->
            <!--                <label v-if="scope.row.laboratoryEvaluationResult ==1 ">不通过</label>-->
            <!--                <label v-if="scope.row.laboratoryEvaluationResult ==2 ">通过</label>-->
            <!--              </template>-->
            <!--            </el-table-column>-->
            <!--            <el-table-column label="业务完成评估" align="center" prop="businessEvaluationResult" width="100px">-->
            <!--              <template slot-scope="scope">-->
            <!--                <el-button-->
            <!--                  size="mini"-->
            <!--                  type="text"-->
            <!--                  icon="el-icon-edit"-->
            <!--                  @click="fileUploadA(scope.row,2 )"-->
            <!--                  v-hasPermi="['web:deptFormulatask:edit']"-->
            <!--                  v-if="scope.row.status == 5 || scope.row.laboratoryEvaluationResult ==2-->
            <!--              || scope.row.businessEvaluationResult == 1 || scope.row.businessEvaluationResult == 1">业务评估-->
            <!--                </el-button>-->
            <!--              </template>-->
            <!--            </el-table-column>-->
            <!--            <el-table-column width="72px" label="评估状态" prop="businessEvaluationResult" align="center">-->
            <!--              <template slot-scope="scope">-->
            <!--                <label v-if="scope.row.businessEvaluationResult === 1 ">不通过</label>-->
            <!--                <label v-if="scope.row.businessEvaluationResult === 2 ">通过</label>-->
            <!--              </template>-->
            <!--            </el-table-column>-->
            <!--            <el-table-column label="操作" align="center" class-name="small-padding fixed-width">-->
            <!--              <template slot-scope="scope">-->
            <!--                <el-button-->
            <!--                  size="mini"-->
            <!--                  type="text"-->
            <!--                  icon="el-icon-edit"-->
            <!--                  @click="handleAssign(scope.row)"-->
            <!--                  v-hasPermi="['web:deptFormulatask:edit']"-->
            <!--                  v-if="scope.row.status == 1"-->
            <!--                >分配人员-->
            <!--                </el-button>-->

            <!--                <el-button-->
            <!--                  size="mini"-->
            <!--                  type="text"-->
            <!--                  icon="el-icon-edit"-->
            <!--                  @click="handleAssign(scope.row)"-->
            <!--                  v-hasPermi="['web:deptFormulatask:edit']"-->
            <!--                  v-if="scope.row.status == 2 || scope.row.status == 3"-->
            <!--                >重新分配-->
            <!--                </el-button>-->
            <!--                <el-button-->
            <!--                  size="mini"-->
            <!--                  type="text"-->
            <!--                  icon="el-icon-delete"-->
            <!--                  @click="handleDeleteDept(scope.row)"-->
            <!--                  v-hasPermi="['web:deptFormulatask:remove']"-->
            <!--                >取消-->
            <!--                </el-button>-->
            <!--              </template>-->
            <!--            </el-table-column>-->
          </el-table>
        </template>
      </el-table-column>


      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="编号" align="center" prop="id"/>
      <el-table-column label="班组编码" align="center" prop="groupCode"/>
      <el-table-column label="班组名称" align="center" prop="groupName"/>
      <el-table-column label="班组负责人" align="center" prop="groupLeaderName"/>
      <el-table-column label="生产车间名称" align="center" prop="workshopName"/>
      <el-table-column label="部门名称" align="center" prop="deptName"/>
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
            v-hasPermi="['admin:group:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['admin:group:remove']"
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

    <!-- 添加或修改班组对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="1000px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px" :inline="true">

          <el-form-item label="班组编码" prop="groupCode">
            <el-input :disabled="!addOrEdit" v-model="form.groupCode" placeholder="请输入班组编码"/>
          </el-form-item>

        <el-form-item label="班组名称" prop="groupName">
          <el-input v-model="form.groupName" placeholder="请输入班组名称"/>
        </el-form-item>
        <el-form-item label="班组负责人" prop="groupLeaderId">
          <el-select style="width: 200px" v-model="form.groupLeaderId" filterable placeholder="请选择">
            <el-option
              v-for="item in groupLeaders"
              :key="item.id"
              :label="item.employeeCode + '-' +item.employeeName"
              :value="Number(item.id)">
            </el-option>
          </el-select>
        </el-form-item>
<!--        <el-form-item label="部门" prop="deptId">-->
<!--          <el-select v-model="form.deptId" style="width: 204px"  @change="getWorkShopOptionsList($event)" filterable placeholder="请选择">-->
<!--            <el-option-->
<!--              v-for="item in deptList"-->
<!--              :key="item.id"-->
<!--              :label="item.deptName"-->
<!--              :value="item.deptId">-->
<!--            </el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
        <el-form-item label="部门" prop="deptId">
          <treeselect style="width: 204px" v-model="form.deptId" :options="deptOptions" :show-count="true" placeholder="请选择归属部门" @select="getWorkShopOptionsList($event)"/>
        </el-form-item>
        <el-form-item label="生产车间" prop="workshopId">
          <el-select v-model="form.workshopId" style="width: 202px"  filterable placeholder="请选择">
            <el-option
              v-for="item in workshops"
              :key="item.id"
              :label="item.workshopCode + '-' +item.workshopName"
              :value="Number(item.id)">
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="备注" prop="note">
          <el-input v-model="form.note" type="textarea" placeholder="请输入内容"/>
        </el-form-item>
      </el-form>


      <div v-if="!addOrEdit">
        <div><span style="font-width: bold;font-size: large">此班组人员</span></div>
        <div align="right">
          <el-button size="mini" type="primary" plain @click="addBaseGroupUserRow">添加班组人员</el-button>
        </div>

        <div class="table">
          <el-table v-loading="loading" :data="groupUserList">
            <!--            <el-table-column type="selection" width="45" align="center"></el-table-column>-->
            <el-table-column width="30" align="center"></el-table-column>
            <el-table-column label="序号" type="index" width="60" align="center"></el-table-column>

            <el-table-column label="组员" align="center" prop="userId">
              <template slot-scope="scope">
                <!--              <el-input v-model="scope.row.userId"  align="center"></el-input>-->
                <el-select v-model="scope.row.userId" filterable placeholder="组员名称"  >
                  <el-option v-for="item in employeeList"

                             :key="item.id"
                             :label="item.employeeName"
                             :value="String(item.id)"
                  />
                </el-select>
              </template>
            </el-table-column>
            <el-table-column label="组员编码" align="center" prop="userId">
              <template slot-scope="scope">
                <!--              <el-input v-model="scope.row.userId"  align="center"></el-input>-->
                <el-select v-model="scope.row.userId" filterable placeholder="组员编码"  >
                  <el-option v-for="item in employeeList"
                             :key="item.id"
                             :label="item.employeeCode"
                             :value="String(item.id)"
                  />
                </el-select>
              </template>
            </el-table-column>
            <el-table-column label="工作状态" align="center" prop="status">
              <template slot-scope="scope">
                <el-radio-group v-model="scope.row.status">
                  <el-radio
                    v-for="dict in dict.type.sys_base_groupuser_status"
                    :key="dict.value"
                    :label="Number(dict.value)"
                  >{{dict.label}}</el-radio>
                </el-radio-group>
              </template>
            </el-table-column>

            <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  type="text"
                  icon="el-icon-delete"
                  @click="delectGroupUserRowData(scope.row,scope.$index)"
                >删除
                </el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
      </div>


      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {listGroup,getGroupVo, getGroup, delGroup, addGroup, updateGroupVo} from "@/api/jotime/base/basics/group";
import {listUser} from "@/api/system/user";
import {listWorkshop} from "@/api/jotime/base/basics/workshop";
import {listDept, treeselect} from "@/api/system/dept";
import {listInfo} from "@/api/jotime/employee/employee";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";

export default {
  name: "Group",
  dicts: ['sys_jotime_data_status', 'sys_base_groupuser_status'],
  components: { Treeselect },
  data() {
    return {
      //row的班组人员列表
      groupUserList: [],
      groupLeaders: [],
      workshops: [],
      deptList: [],
      employeeList:[],
      // 遮罩层
      loading: true,
      addOrEdit:true,
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
      // 班组表格数据
      groupList: [],
      // 部门树选项
      deptOptions: undefined,
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        groupCode: null,
        groupName: null,
        groupLeaderId: null,
        workshopId: null,
        status: null,
        note: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        groupCode: [
          {required: true, message: "班组编码不能为空", trigger: "blur"}
        ],
        groupName: [
          {required: true, message: "班组名称不能为空", trigger: "blur"}
        ],
        groupLeaderId: [
          {required: true, message: "班组负责人id不能为空", trigger: "blur"}
        ],
        deptId: [
          {required: true, message: "部门不能为空", trigger: "blur"}
        ],
        workshopId: [
          {required: true, message: "生产车间不能为空", trigger: "blur"}
        ],

      }
    };
  },
  created() {
    this.getTreeselect();
    this.getList();
  },
  methods: {
    /** 查询部门下拉树结构 */
    getTreeselect() {
      treeselect().then(response => {
        this.deptOptions = response.data;
      });
    },
    /** 查询班组列表 */
    getList() {
      this.loading = true;
      listGroup(this.queryParams).then(response => {
        this.groupList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
      listDept().then(res => {
        this.deptList = res.data;
      });
      listInfo().then(res=>{
        this.employeeList = res.rows;
      })
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.groupUserList = [];
        this.form = {
          baseGroupusers:null,
          id: null,
          groupCode: null,
          groupName: null,
          groupLeaderId: null,
          workshopId: null,
          deptId: null,
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
      this.getTreeselect();
      this.reset();
      this.addOrEdit=true,
      this.open = true;
      this.title = "添加班组";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.getTreeselect();
      this.reset();
      this.addOrEdit=false;
      const id = row.id || this.ids
      getGroupVo(id).then(response => {
        this.form = response.data;
        this.groupUserList=this.form.baseGroupusers;
        this.open = true;
        this.title = "修改班组";
      });
      listWorkshop({deptId: this.form.deptId}).then(response => {
        this.workshops = response.rows
      })
    },
    /** 提交按钮 */
    submitForm() {


      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateGroupVo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.form.baseGroupusers = this.groupUserList;
              console.log(this.form);
              this.open = false;
              this.getList();
            });
          } else {
            addGroup(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除班组编号为"' + ids + '"的数据项？').then(function () {
        return delGroup(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('admin/group/export', {
        ...this.queryParams
      }, `group_${new Date().getTime()}.xlsx`)
    },
    getWorkShopOptionsList(val) {
      listWorkshop({deptId: val.id}).then(response => {
        this.workshops = response.rows
      })
    },
    // 增加行
    addBaseGroupUserRow() {
      this.groupUserList.push({status:1});
    },
    // 删除单行
    delectGroupUserRowData(row, index) {
      this.groupUserList.splice(index, 1);
    },
  },

  mounted() {
    listInfo().then(response => {
      this.groupLeaders = response.rows
    })


  }
};
</script>
