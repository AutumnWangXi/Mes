<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
<!--      <el-form-item label="库位编码" prop="locationCode">-->
<!--        <el-input-->
<!--          v-model="queryParams.locationCode"-->
<!--          placeholder="请输入库位编码"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="库位名称" prop="locationNoView">-->
<!--        <el-input-->
<!--          v-model="queryParams.locationNoView"-->
<!--          placeholder="请输入库位名称"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="是否允许混放 1 不允许混放  2允许混放" prop="isMix">-->
<!--        <el-input-->
<!--          v-model="queryParams.isMix"-->
<!--          placeholder="请输入是否允许混放 1 不允许混放  2允许混放"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="库位分组" prop="locationGroup">
        <el-input
          v-model="queryParams.locationGroup"
          placeholder="请输入库位分组"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="仓库">
        <el-select v-model="queryParams.whId" clearable filterable @change="warehouseChange">
          <el-option
            v-for="item in warehouseOptions"
            :key="item.id"
            :label="item.whName"
            :value="item.id"
          >
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="库区">
        <el-select v-model="queryParams.areaId" clearable filterable @change="operatorChange">
          <el-option
            v-for="item in areaOptions"
            :key="item.id"
            :label="item.areaName"
            :value="item.id"
          >
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="库位">
        <el-select v-model="queryParams.locationCode" clearable filterable>
          <el-option
            v-for="item in locationOptions"
            :key="item.locationCode"
            :label="item.locationNoView"
            :value="item.locationCode"
          >
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" filterable placeholder="请选择状态" size="small">
          <el-option
            v-for="dict in dict.type.sys_jotime_data_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>

      <el-form-item label="库位类型" prop="locationType">
        <el-select v-model="queryParams.isMix" filterable placeholder="请选择状态" size="small">
          <el-option
            v-for="dict in dict.type.sys_jotime_base_location_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否混放" prop="isMix">
        <el-select v-model="queryParams.isMix" filterable placeholder="请选择状态" size="small">
          <el-option
            v-for="dict in dict.type.sys_jotime_base_ismix"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="品质类型" prop="keepType">
        <el-select v-model="queryParams.keepType" filterable placeholder="请选择状态" size="small">
          <el-option
            v-for="dict in dict.type.sys_stock_keepType"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>

<!--      <el-form-item label="仓库" prop="whId"  >-->
<!--        <el-select-->
<!--          v-model="queryParams.whId"-->
<!--          placeholder="请选择仓库"-->
<!--          clearable-->
<!--          filterable-->
<!--          size="small"-->
<!--          style="width: 200px"-->
<!--          @click.native="getWarehouseList()"-->
<!--          @change="getAreaList($event)"-->
<!--        >-->
<!--          <el-option-->
<!--            v-for="dict in warehouseOptions"-->
<!--            :key="dict.id"-->
<!--            :label="dict.whName"-->
<!--            :value="dict.id"-->
<!--          />-->
<!--        </el-select>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="仓库id" prop="whId">-->
<!--        <el-input-->
<!--          v-model="queryParams.whId"-->
<!--          placeholder="请输入仓库id"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="库区id" prop="areaId">-->
<!--        <el-input-->
<!--          v-model="queryParams.areaId"-->
<!--          placeholder="请输入库区id"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->

<!--      <el-form-item label="库区" prop="areaId"  >-->
<!--        <el-select-->
<!--          v-model="queryParams.areaId"-->
<!--          placeholder="请选择库区"-->
<!--          clearable-->
<!--          filterable-->
<!--          size="small"-->
<!--          style="width: 200px"-->
<!--        >-->
<!--          <el-option-->
<!--            v-for="dict in areaOptions"-->
<!--            :key="dict.id"-->
<!--            :label="dict.areaName"-->
<!--            :value="dict.id"-->
<!--          />-->
<!--        </el-select>-->
<!--      </el-form-item>-->

<!--      <el-form-item label="备注" prop="note">-->
<!--        <el-input-->
<!--          v-model="queryParams.note"-->
<!--          placeholder="请输入备注"-->
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
          v-hasPermi="['web:location:add']"
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
          v-hasPermi="['web:location:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-check"
          size="mini"
          :disabled="multiple"
          @click="editWarehouse"
          v-hasPermi="['web:location:editWarehouse']"
        >改仓库库区</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['web:location:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['web:location:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="locationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="库位id" align="center" prop="id" />-->
      <el-table-column label="库位编码" align="center" prop="locationCode" />
      <el-table-column label="库位名称" align="center" prop="locationNoView" />
<!--      <el-table-column label="DD 地堆 GB 隔板 GJ 高架" align="center" prop="locationType" />-->
      <el-table-column label="库位类型" align="center" prop="locationType"   width="80">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_jotime_base_location_type" :value="scope.row.locationType"/>
        </template>
      </el-table-column>
<!--      <el-table-column label="是否允许混放 1 不允许混放  2允许混放" align="center" prop="isMix" />-->
      <el-table-column label="是否允许混放" align="center" prop="isMix"   width="100">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_jotime_base_ismix" :value="scope.row.isMix"/>
        </template>
      </el-table-column>
<!--      <el-table-column label="存放品质类型 1 不良品  2 良品  3 都可以 " align="center" prop="keepType" />-->
      <el-table-column label="存放品质类型" align="center" prop="keepType"   width="100">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_stock_keepType" :value="scope.row.keepType"/>
        </template>
      </el-table-column>
<!--      <el-table-column label="打印类型 1 简化  2完整" align="center" prop="printType" />-->
<!--      <el-table-column label="打印类型" align="center" prop="printType"   width="80">-->
<!--        <template slot-scope="scope">-->
<!--          <dict-tag :options="dict.type.sys_jotime_print_type" :value="scope.row.printType"/>-->
<!--        </template>-->
<!--      </el-table-column>-->
      <el-table-column label="库位分组" align="center" prop="locationGroup" />
      <el-table-column label="仓库" align="center" prop="whName" />
      <el-table-column label="库区" align="center" prop="areaName" />
<!--      <el-table-column label="状态 0  禁用 1启用" align="center" prop="status" />-->
      <el-table-column label="状态" align="center" prop="status"   width="60">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_jotime_data_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="note" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['web:location:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['web:location:remove']"
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

    <!-- 改仓库库区弹框 -->
    <el-dialog :title="title" :visible.sync="editWare" width="35%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
<!--        <el-form-item label="仓库" prop="whId">-->
<!--          <el-select v-model="form.whId" filterable style="width:80%">-->
<!--            <el-option-->
<!--              v-for="item in warehouseOptions"-->
<!--              :key="item.id"-->
<!--              :label="item.whName"-->
<!--              :value="item.id"-->
<!--            >-->
<!--            </el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="库区" prop="areaId">-->
<!--          <el-select v-model="form.areaId" @change="operatorChange" filterable style="width:80%">-->
<!--            <el-option-->
<!--              v-for="item in areaOptions"-->
<!--              :key="item.id"-->
<!--              :label="item.areaName"-->
<!--              :value="item.id"-->
<!--            >-->
<!--            </el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
        <el-form-item label="仓库" prop="whId"  >
          <el-select
            v-model="form.whId"
            placeholder="请选择仓库"
            clearable
            filterable
            size="small"
            style="width: 240px"
            @click.native="getWarehouseList()"
            @change="getAreaList($event)"
          >
            <el-option
              v-for="dict in warehouseOptions"
              :key="dict.id"
              :label="dict.whName"
              :value="dict.id"
              :disabled="dict.status == 0"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="库区" prop="areaId">
          <el-select
            v-model="form.areaId"
            placeholder="请选择库区"
            clearable
            filterable
            size="small"
            style="width: 240px"
          >
            <el-option
              v-for="dict in areaOptions"
              :key="dict.id"
              :label="dict.areaName"
              :value="dict.id"
              :disabled="dict.status == 0"
            />
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" :loading="buttonloading" @click="countSubmit">提 交</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 添加或修改库位列对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="110px">
        <el-form-item label="库位编码" prop="locationCode">
          <el-input v-model="form.locationCode" placeholder="请输入库位编码" />
        </el-form-item>
        <el-form-item label="库位名称" prop="locationNoView">
          <el-input v-model="form.locationNoView" placeholder="请输入库位名称" />
        </el-form-item>
<!--        <el-form-item label="是否允许混放" prop="isMix">-->
<!--          <el-input v-model="form.isMix" placeholder="请输入是否允许混放" />-->
<!--        </el-form-item>-->


        <el-form-item label="库位类型" prop="locationType">
          <el-select v-model="form.locationType" placeholder="请选择">
            <el-option
              v-for="dict in dict.type.sys_jotime_base_location_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="是否允许混放" prop="isMix">
          <el-radio-group v-model="form.isMix">
            <el-radio
              v-for="dict in dict.type.sys_jotime_base_ismix"
              :key="dict.value"
              :label="Number(dict.value)"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="存放品质类型" prop="keepType">
          <el-radio-group v-model="form.keepType">
            <el-radio
              v-for="dict in dict.type.sys_stock_keepType"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>

<!--        <el-form-item label="打印类型" prop="printType">-->
<!--          <el-radio-group v-model="form.printType">-->
<!--            <el-radio-->
<!--              v-for="dict in dict.type.sys_jotime_print_type"-->
<!--              :key="dict.value"-->
<!--              :label="Number(dict.value)"-->
<!--            >{{dict.label}}</el-radio>-->
<!--          </el-radio-group>-->
<!--        </el-form-item>-->

        <el-form-item label="库位分组" prop="locationGroup">
          <el-input v-model="form.locationGroup" placeholder="请输入库位分组" />
        </el-form-item>
<!--        <el-form-item label="仓库id" prop="whId">-->
<!--          <el-input v-model="form.whId" placeholder="请输入仓库id" />-->
<!--        </el-form-item>-->

        <el-form-item label="仓库" prop="whId"  >
          <el-select
            v-model="form.whId"
            placeholder="请选择仓库"
            clearable
            filterable
            size="small"
            style="width: 240px"
            @click.native="getWarehouseList()"
            @change="getAreaList($event)"
          >
            <el-option
              v-for="dict in warehouseOptions"
              :key="dict.id"
              :label="dict.whName"
              :value="dict.id"
              :disabled="dict.status == 0"
            />
          </el-select>
        </el-form-item>

<!--        <el-form-item label="库区id" prop="areaId">-->
<!--          <el-input v-model="form.areaId" placeholder="请输入库区id" />-->
<!--        </el-form-item>-->

        <el-form-item label="库区" prop="areaId">
          <el-select
            v-model="form.areaId"
            placeholder="请选择库区"
            clearable
            filterable
            size="small"
            style="width: 240px"
          >
            <el-option
              v-for="dict in areaOptions"
              :key="dict.id"
              :label="dict.areaName"
              :value="dict.id"
              :disabled="dict.status == 0"
            />
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
          <el-input v-model="form.note" placeholder="请输入备注" />
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
import {
  listLocation,
  printPdf,
  getLocation,
  delLocation,
  addLocation,
  updateLocation,
  selectArea,
  editWarehouses
} from "@/api/jotime/base/basics/warehouselocation";
import {getWarehouseList} from "@/api/jotime/base/basics/warehouse";
import {getAreaList} from "@/api/jotime/base/basics/warehousearea";
import {Loading} from "element-ui";
import {generalInventory} from "@/api/jotime/stock/notice";


export default {
  name: "Location",
  dicts: ['sys_jotime_base_ismix','sys_stock_keepType','sys_jotime_print_type','sys_jotime_data_status','sys_jotime_base_location_type'],
  data() {
    return {
      editWare: false,
      warehouseValue: '',
      operatorValue: '',
      locationValue: '',
      locationOptions: [],
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
      // 库位列表格数据
      locationList: [],
      //仓库列表
      warehouseOptions:[],
      //判断仓库列表是否为空，只加载一次
      warehouseOptionsIsNull:true,
      //库区列表
      areaOptions:[],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        locationCode: null,
        locationNoView: null,
        locationType: null,
        isMix: null,
        keepType: null,
        printType: null,
        locationGroup: null,
        whId: null,
        whName: null,
        areaName: null,
        areaId: null,
        status: null,
        note: null,
      },
      //打印
      printWidth: 90,
      printCount: 1,
      printHeight: 67,
      openPrint: false,
      //选择数据
      rows: [],
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        locationCode: [
          { required: true, message: "库位编码不能为空", trigger: "blur" }
        ],
        locationNoView: [
          { required: true, message: "库位名称不能为空", trigger: "blur" }
        ],
        keepType: [
          { required: true, message: "存放品质类型", trigger: "change" }
        ],
        whId: [
          { required: true, message: "仓库id不能为空", trigger: "blur" }
        ],
        areaId: [
          { required: true, message: "库区id不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "状态 0  禁用 1启用不能为空", trigger: "blur" }
        ],
        createBy: [
          { required: true, message: "$comment不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "$comment不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
    getWarehouseList().then(res => {
      this.warehouseOptions = res.warehouseOptions
    })
  },
  methods: {
    //改仓库库区数据提交
    countSubmit() {
      this.form.ids =this.ids;
      //详情数据
      //详情数据
      let form = JSON.parse(JSON.stringify(this.form))
      editWarehouses(form).then(res => {
        this.$modal.msgSuccess("改仓库库区数据成功");
        this.editWare = false
        this.open = false;
        this.getList();
        //请求完接口进行刷新
        this.reset()
        this.resetQuery()
      })
    },

    editWarehouse() {
      // let rows = this.rows
      // this.form = rows[0]
      this.title = '改仓库库区'
      this.editWare = true
    },
    warehouseChange(value) {
      if (value) {
        getAreaList(value).then(res => {
          let areaOptions = res.areaOptions
          this.areaOptions = areaOptions
        })
      }
    },
    operatorChange(value) {
      if (value) {
        selectArea(value).then(res => {
          let locationOptions = res.data
          this.locationOptions = locationOptions
        })
      }
    },
    /** 查询库位列列表 */
    getList() {
      this.loading = true;
      listLocation(this.queryParams).then(response => {
        this.locationList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.editWare = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        locationCode: null,
        locationNoView: null,
        locationType: null,
        isMix: 2,
        keepType: "01",
        printType: 1,
        locationGroup: null,
        whId: null,
        areaId: null,
        status: 2,
        note: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    //获取仓库列表
    getWarehouseList(){
      if (this.warehouseOptionsIsNull){
        getWarehouseList().then(response => {
          this.warehouseOptions = response.warehouseOptions;
          this.warehouseOptionsIsNull=false;
        });
      }
    },
    //获取库区列表
    getAreaList(val){
      if(val != null && val != '' && val != undefined){
        getAreaList(val).then(response => {
          //给areaOptions数组赋值
          this.areaOptions = response.areaOptions;
        })
      }else {
        this.areaOptions = [];
        this.resetForm("queryForm");
      }
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
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加库位列";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      this.getWarehouseList();
      getLocation(id).then(response => {
        this.form = response.data;
        this.areaOptions = response.areaOptions;
        this.open = true;
        this.title = "修改库位列";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateLocation(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLocation(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除库位列编号为"' + ids + '"的数据项？').then(function() {
        return delLocation(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('web/location/export', {
        ...this.queryParams
      }, `location_${new Date().getTime()}.xlsx`)
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
      if (this.rows==null||this.rows.length==0) return this.$modal.msgError("请选择要打印的库位！");
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
      obj.isRight = 10;
      obj.isLeft = 2;
      obj.isTop=13;
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
