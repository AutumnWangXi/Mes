<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="设备编码" prop="deviceCode">
        <el-input
          v-model="queryParams.deviceCode"
          placeholder="请输入设备编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备名称" prop="deviceName">
        <el-input
          v-model="queryParams.deviceName"
          placeholder="请输入设备名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!--      <el-form-item label="车间名" prop="workshopName">-->
      <!--        <el-input-->
      <!--          v-model="queryParams.workshopName"-->
      <!--          placeholder="请输入车间名"-->
      <!--          clearable-->
      <!--          size="small"-->
      <!--          @keyup.enter.native="handleQuery"-->
      <!--        />-->
      <!--      </el-form-item>-->


      <el-form-item label="车间"  prop="workshopName">
        <el-select
          v-model="queryParams.workshopName"
          placeholder="请选择车间"
          clearable
          filterable
          size="small"
          style="width: 240px"
          @click.native="getWorkShopList()"
        >
          <el-option
            v-for="dict in workshopOptions"
            :key="dict.id"
            :label="dict.workshopName"
            :value="dict.workshopName"
          />
        </el-select>
      </el-form-item>

      <el-form-item label="保养人" prop="maintainer">
        <el-select
          v-model="queryParams.maintainer"
          placeholder="请选择保养人"
          clearable
          filterable
          size="small"
          style="width: 240px"
          @click.native="getInfoOptionsList()"
        >
          <el-option
            v-for="dict in maintainerOptions"
            :key="dict.id"
            :label="dict.employeeName"
            :value="dict.employeeName"
          />
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
          v-hasPermi="['base:maintain:add']"
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
          v-hasPermi="['base:maintain:edit']"
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
          v-hasPermi="['base:maintain:remove']"
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
          v-hasPermi="['base:maintain:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="maintaininfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="设备编码" align="center" prop="deviceCode"/>
      <el-table-column label="设备名称" align="center" prop="deviceName"/>
      <el-table-column label="设备类型" align="center" prop="deviceType"/>
      <el-table-column label="车间名" align="center" prop="workshopName"/>
      <el-table-column label="最新保养时间" align="center" prop="latestMaintenanceTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.latestMaintenanceTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="是否公司员工" align="center" prop="isEeInfo">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_yes_no" :value="scope.row.isEeInfo"/>
        </template>
      </el-table-column>
      <el-table-column label="保养人" align="center" prop="maintainer"/>
      <el-table-column label="备注" align="center" prop="note"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['base:maintain:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['base:maintain:remove']"
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

    <!-- 添加或修改设备保养信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="110px">
        <el-form-item label="设备编码" prop="deviceCode">
          <el-input v-model="form.deviceCode" placeholder="请输入设备编码"/>
        </el-form-item>
        <el-form-item label="设备名称" prop="deviceName">
          <el-input v-model="form.deviceName" placeholder="请输入设备名称"/>
        </el-form-item>
<!--        <el-form-item label="设备类型" prop="deviceType">-->
<!--          <el-input v-model="form.deviceType" placeholder="请输入设备类型"/>-->
<!--        </el-form-item>-->
        <el-form-item label="设备类型" prop="deviceType">
          <el-select v-model="form.deviceType" filterable placeholder="请选择" >
            <el-option
              v-for="item in deviceTypeList"
              :key="item.id"
              :label="item.deviceTypeName"
              :value="item.deviceTypeName"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="车间名" prop="workshopName">
          <el-select v-model="form.workshopName" clearable filterable placeholder="请选择"
                     @click.native="getWorkShopList()">
            <el-option
              v-for="item in workshopOptions"
              :key="item.id"

              :label="item.workshopName"
              :value="item.workshopName"
              :disabled="item.status == 1"
            ></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="最新保养时间" prop="latestMaintenanceTime">
          <el-date-picker clearable size="small"
                          v-model="form.latestMaintenanceTime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择最新保养时间">
          </el-date-picker>
        </el-form-item>
        <div v-if="form.id==null">
          <el-form-item label="是否公司员工" prop="isEeInfo">
            <!--          <el-input v-model="form.isEeInfo" placeholder="请输入保养人员是否公司员工" />-->
            <el-radio-group @change="isEeInfoChange($event)" v-model="form.isEeInfo">
              <el-radio
                v-for="dict in dict.type.sys_yes_no"
                :key="dict.value"
                :label="Number(dict.value)"
              >{{ dict.label }}
              </el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item v-if="!isEeInfo" label="保养人" prop="maintainer">
            <el-input v-model="form.maintainer" placeholder="请输入保养人" />
          </el-form-item>

          <el-form-item v-if="isEeInfo" label="保养人" prop="maintainer">
            <el-select v-model="form.maintainer" clearable filterable placeholder="请选择"
                       @click.native="getInfoOptionsList()">
              <el-option
                v-for="item in maintainerOptions"
                :key="item.id"
                :label="item.employeeName"
                :value="Number(item.id)"
                :disabled="item.status == 1"
              ></el-option>
            </el-select>
          </el-form-item>
        </div>

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
import {
  listMaintaininfo,
  getMaintaininfo,
  delMaintaininfo,
  addMaintaininfo,
  updateMaintaininfo
} from "@/api/jotime/base/basics/maintain";
import {getWorkShopList} from "@/api/jotime/base/basics/workshop"
import {getInfoOptionsList} from "@/api/jotime/employee/employee"
import {listDeviceType} from "@/api/jotime/base/basics/deviceType";

export default {
  name: "Maintaininfo",
  dicts: ['sys_yes_no'],
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
      // 设备保养信息表格数据
      maintaininfoList: [],
      //车间下拉框列表
      workshopOptions: [],
      //设备列表
      deviceTypeList:[],
      //车间下拉列表默认为空
      workshopOptionsIsNull: true,
      //负责人下拉框列表
      maintainerOptions: [],
      //负责人下拉列表默认为空
      maintainerOptionsIsNull: true,
      //是否是公司员工
      isEeInfo: true,
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        id: null,
        deviceCode: null,
        deviceName: null,
        deviceType: null,
        workshopName: null,
        latestMaintenanceTime: null,
        isEeInfo: null,
        maintenanceId: null,
        maintainer: null,
        note: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        deviceName: [
          {required: true, message: "设备名称不能为空", trigger: "blur"}
        ],
        workshopName: [
          {required: true, message: "车间不能为空", trigger: "blur"}
        ],
        deviceType: [
          {required: true, message: "设备类型不能为空", trigger: "blur"}
        ],
        deviceCode: [
          {required: true, message: "设备编码不能为空", trigger: "blur"}
        ],
        latestMaintenanceTime: [
          {required: true, message: "最新保养时间不能为空", trigger: "blur"}
        ],
        isEeInfo: [
          {required: true, message: "保养人员是否公司员工不能为空", trigger: "blur"}
        ],
        maintainer: [
          {required: true, message: "保养人不能为空", trigger: "blur"}
        ],
      }
    };
  },
  created() {
    this.getList();

  },
  methods: {
    isEeInfoChange(value) {
      if (value == 2) {
        this.isEeInfo=true;
      }
      if (value == 1) {
        this.isEeInfo=false;
      }
    },
    /** 查询设备保养信息列表 */
    getList() {
      this.loading = true;
      listDeviceType(null).then(response => {
        this.deviceTypeList = response.rows;
      });
      listMaintaininfo(this.queryParams).then(response => {
        this.maintaininfoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    //获取下拉框车间列表
    getWorkShopList() {
      if (this.workshopOptionsIsNull) {
        getWorkShopList().then(response => {
          this.workshopOptions = response.workshopOptions;
          this.workshopOptionsIsNull = false;
        });
      }
    },
    //获取下拉框负责人列表
    getInfoOptionsList() {
      if (this.maintainerOptionsIsNull) {
        getInfoOptionsList().then(response => {
          this.maintainerOptions = response.infoOptionsList;
          this.maintainerOptionsIsNull = false;
        });
      }
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
        deviceCode: null,
        deviceName: null,
        deviceType: null,
        workshopName: null,
        latestMaintenanceTime: null,
        isEeInfo: 2,
        maintenanceId: null,
        maintainer: null,
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
      this.title = "添加设备保养信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getMaintaininfo(id).then(response => {
        this.form = response.data;
        this.form.maintainer=null;
        this.open = true;
        this.title = "修改设备保养信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      console.log(this.form)
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            if (this.form.isEeInfo==2){
              this.form.maintenanceId = null;
            }
            updateMaintaininfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMaintaininfo(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除设备保养信息编号为"' + ids + '"的数据项？').then(function () {
        return delMaintaininfo(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('admin/maintaininfo/export', {
        ...this.queryParams
      }, `maintaininfo_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
