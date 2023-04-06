  <template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="车间编码" prop="workshopCode">
        <el-input
          v-model="queryParams.workshopCode"
          placeholder="请输入车间编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车间名称" prop="workshopName">
        <el-input
          v-model="queryParams.workshopName"
          placeholder="请输入车间名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select
          v-model="queryParams.status"
          placeholder="车间状态"
          clearable
          size="small"
          style="width: 240px"
        >
          <el-option
            v-for="dict in dict.type.sys_jotime_data_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
<!--      <el-form-item label="部门内码" prop="deptId">-->
<!--        <el-input-->
<!--          v-model="queryParams.deptId"-->
<!--          placeholder="请输入部门内码"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="负责人内码" prop="leaderId">-->
<!--        <el-input-->
<!--          v-model="queryParams.leaderId"-->
<!--          placeholder="请输入负责人内码"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="产能" prop="productivity">-->
<!--        <el-input-->
<!--          v-model="queryParams.productivity"-->
<!--          placeholder="请输入产能"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="单位" prop="unit">-->
<!--        <el-input-->
<!--          v-model="queryParams.unit"-->
<!--          placeholder="请输入单位"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="车间描述" prop="description">-->
<!--        <el-input-->
<!--          v-model="queryParams.description"-->
<!--          placeholder="请输入车间描述"-->
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
          size="mini"
          @click="redoPrint"
        >打印标签
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['base:workshop:add']"
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
          v-hasPermi="['base:workshop:edit']"
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
          v-hasPermi="['base:workshop:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['base:workshop:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="workshopList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="内码" align="center" prop="id" />-->
      <el-table-column label="车间编码" align="center" prop="workshopCode" />
      <el-table-column label="车间名称" align="center" prop="workshopName" />
      <el-table-column label="部门" align="center" prop="deptName" />
      <el-table-column label="负责人" align="center" prop="leaderName" />
      <el-table-column label="角色名字" align="center" prop="roleName" />
      <el-table-column label="车间类型" align="center" prop="workshopType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.base_workshop_type" :value="scope.row.workshopType"/>
        </template>
      </el-table-column>
<!--      <el-table-column label="状态" align="center" prop="status" />-->
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
            v-hasPermi="['base:workshop:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['base:workshop:remove']"
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

    <!-- 添加或修改车间对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="车间编码" prop="workshopCode">
          <el-input v-model="form.workshopCode" placeholder="请输入车间编码" />
        </el-form-item>
        <el-form-item label="车间名称" prop="workshopName">
          <el-input v-model="form.workshopName" placeholder="请输入车间名称" />
        </el-form-item>
        <el-form-item label="归属部门" prop="deptId">
          <treeselect v-model="form.deptId" :options="deptOptions" :show-count="true" placeholder="请选择归属部门" /></el-form-item>

<!--        <el-form-item label="负责人内码" prop="leaderId">-->
<!--          <el-input v-model="form.leaderId" placeholder="请输入负责人内码" />-->
<!--        </el-form-item>-->

        <el-form-item label="负责人" prop="leaderId">
              <el-select v-model="form.leaderId" clearable filterable placeholder="请选择" @click.native="getInfoOptionsList()">
                <el-option
                  v-for="item in infoOptionsList"
                  :key="item.id"
                  :label="item.employeeName"
                  :value="item.id"
                  :disabled="item.status == 1"
                ></el-option>
              </el-select>
            </el-form-item>
          <el-form-item label="角色">
            <el-select v-model="form.roleIds" multiple placeholder="请选择">
              <el-option
                v-for="item in roleOptions"
                :key="item.roleId"
                :label="item.roleName"
                :value="item.roleId"
                :disabled="item.status == 1"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="车间类型">
            <el-select v-model="form.workshopType" placeholder="请选择">
              <el-option
                v-for="dict in dict.type.base_workshop_type"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
              ></el-option>
            </el-select>
          </el-form-item>

<!--        <el-form-item label="单位" prop="unit">-->
<!--          <el-input v-model="form.unit" placeholder="请输入单位" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="状态" prop="status">-->
<!--          <el-radio-group v-model="form.status">-->
<!--            <el-radio-->
<!--              v-for="dict in dict.type.sys_jotime_data_status"-->
<!--              :key="dict.value"-->
<!--              :label="dict.value"-->
<!--            >{{dict.label}}</el-radio>-->
<!--          </el-radio-group>-->
<!--        </el-form-item>-->
<!--        -->
        <el-form-item label="状态">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.sys_jotime_data_status"
              :key="dict.value"
              :label="Number(dict.value)"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="车间描述" prop="description">
          <el-input v-model="form.description" placeholder="请输入车间描述" />
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




    <!-- 打印弹框 -->
    <el-dialog :title="title" :visible.sync="openPrint" width="800px" append-to-body>
      <div>
        <el-row :gutter="24">
          <el-col :span="4">
            <label> 请输入打印张数</label></el-col>
          <el-col :span="4">
            <div class="input">
              <el-input type="text" v-model="printCount"></el-input>
            </div>
          </el-col>
          <el-col :span="4"><label> 请输入纸张长度</label></el-col>
          <el-col :span="4">
            <div class="input">
              <el-input type="text" v-model="printWidth"></el-input>
            </div>
          </el-col>
          <el-col :span="4"><label> 请输入纸张宽度</label></el-col>

          <el-col :span="4">
            <div class="input">
              <el-input type="text" v-model="printHeight"
              ></el-input>
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="24" style="margin-top: 50px">
          <el-col :span="24" align="center">
            <el-button type="primary"@click="printList">打印标签</el-button>
          </el-col>
        </el-row>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listWorkshop, getWorkshop, delWorkshop, addWorkshop, updateWorkshop ,printPdf} from "@/api/jotime/base/basics/workshop";
import { treeselect } from "@/api/system/dept";
import { getInfoOptionsList } from "@/api/jotime/employee/employee";
import { getInforoleList } from "@/api/system/role.js";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";
import {Loading} from "element-ui";

export default {
  name: "Workshop",
  components: { Treeselect },
  dicts: ["sys_jotime_data_status","base_workshop_type"],
  data() {
    return {
      // 角色选项
      roleOptions: [],
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
      deptOptions: undefined,
      // 总条数
      total: 0,
      // 车间表格数据
      workshopList: [],
      //员工列表
      infoOptionsList:[],
      inforoleList:[],
      infoOptionsListIsNull:true,
      inforoleListIsNull:true,
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        workshopName: null,
        workshopCode:null,
        deptId: null,
        leaderId: null,
        roleId: null,
        workshopType: null,
        leaderName: null,
        productivity: null,
        unit: null,
        description: null,
        status: null,
        note: null,
        deptName:null,
      },
      // 表单参数
      form: {},
      //打印
      printWidth: 90,
      printCount: 1,
      printHeight: 70,
      openPrint: false,
      //选择数据
      rows: [],
      // 表单校验
      rules: {
        workshopCode: [
          { required: true, message: "车间编码不能为空", trigger: "blur" }
        ],

        workshopName: [

          { required: true, message: "车间名称不能为空", trigger: "blur" }
        ],

        status: [
          { required: true, message: "状态不能为空", trigger: "blur" }
        ],
        deptId: [
          { required: true, message: "部门不能为空", trigger: "blur" }
        ],
        leaderId: [
          { required: true, message: "负责人不能为空", trigger: "blur" }
        ],
        createBy: [
          { required: true, message: "创建者不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ],
      }
    };
  },

  watch: {
    // 根据名称筛选部门树
    deptName(val) {
      this.$refs.tree.filter(val);
    }
  },
  created() {
    this.getList();
    this.getTreeselect();
  },
  methods: {
    /** 查询车间列表 */
    getList() {
      this.loading = true;
      listWorkshop(this.queryParams).then(response => {
        this.workshopList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 筛选节点
    filterNode(value, data) {
      if (!value) return true;
      return data.label.indexOf(value) !== -1;
    },
    // 节点单击事件
    handleNodeClick(data) {
      this.queryParams.deptId = data.id;
      this.getList();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        workshopName: null,
        workshopCode:null,
        deptId: null,
        leaderId: null,
        roleId: null,
        workshopType: null,
        leaderName: null,
        productivity: null,
        unit: null,
        description: null,
        status: null,
        note: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        deptName:null,
        roleIds: []
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
      this.rows = selection.map(item => item)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 查询部门下拉树结构 */
    getTreeselect() {
      treeselect().then(response => {
        this.deptOptions = response.data;
      });
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.getTreeselect();
      this.roleOptions = response.roles;
      this.form.roleIds = response.roleIds;
      this.form.status = 2;
      this.open = true;
      this.title = "添加车间";
    },
    //获取员工列表
    getInfoOptionsList(){
      //只加载一次列表
      if (this.infoOptionsListIsNull){
        getInfoOptionsList().then(response => {
          this.infoOptionsList = response.infoOptionsList;
        });
        this.infoOptionsListIsNull=false;
      }
    },

    //获取员工列表
    getInforoleList(){
      //只加载一次列表
      if (this.inforoleListIsNull){
        getInforoleList().then(response => {
          this.inforoleList = response.inforoleList;
        });
        this.inforoleListIsNull=false;
      }
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.getInfoOptionsList();
      this.getInforoleList();
      const id = row.id || this.ids
      getWorkshop(id).then(response => {
        this.form = response.data;
        this.roleOptions = response.roles;
        this.form.roleIds = response.roleIds;
        this.open = true;
        this.title = "修改车间";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateWorkshop(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addWorkshop(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除车间编号为"' + ids + '"的数据项？').then(function() {
        return delWorkshop(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('base/workshop/export', {
        ...this.queryParams
      }, `workshop_${new Date().getTime()}.xlsx`)
    },

    printPDF(stream) {
      /**
       * iframe src 为pdf 流 时，打印控件弹出后删除或造成控件隐藏
       * 所以等下一次打印触发清除上一次 创建的 iframe
       */
      let printBox = document.getElementById('print-stream-box')
      if (printBox) {
        document.body.removeChild(printBox)
      }
      let binaryData = []
      binaryData.push(stream.data)
      let blob = new Blob(binaryData, {type: 'application/pdf'})
      let url = URL.createObjectURL(blob)
      const iframe = document.createElement('iframe')
      iframe.setAttribute('id', 'print-stream-box')
      iframe.setAttribute('style', 'position:absolute;width:100px;height:100px;left:99999px;top:999999px;z-index:0px,')
      iframe.src = url
      document.body.appendChild(iframe)
      iframe.onload = function () {
        iframe.contentWindow.print()
        iframe.hidden
      }
    },
    //打印弹框
    redoPrint(){
      if (this.rows==null||this.rows.length==0) return this.$modal.msgError("请选择要打印的车间！");
      this.openPrint = true;
    },
    printList() {
      let loadingInstance = Loading.service({
        lock: true,
        text: 'Loading',
        spinner: 'el-icon-loading',
        background: 'rgba(0, 0, 0, 0.7)'
      })
      let forCount = this.printCount
      let rows = this.rows
      let afterArr = []
      for (let key in rows) {
        let row = rows[key]
        for (let i = 0; i < forCount; i++) {
          row.printReps = forCount
          afterArr.push(row)
        }
      }
      let obj = {}
      obj.printCount = this.printCount
      obj.printWidth = this.printWidth
      obj.printHeight = this.printHeight
      obj.isLeft=2;
      obj.isTop=10;
      let afterArr2 = []
      for (let i = 0; i < this.rows.length; i++) {
        afterArr2.push(JSON.parse(JSON.stringify(this.rows[i])))
      }
      obj.data = afterArr2;
      printPdf(obj).then(res => {
        this.printPDF(res)
        this.openPrint = false
        loadingInstance.close()
      })
    },
  }
};
</script>
