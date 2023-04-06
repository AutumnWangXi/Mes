<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
<!--      <el-form-item label="库区编码" prop="areaCode">-->
<!--        <el-input-->
<!--          v-model="queryParams.areaCode"-->
<!--          placeholder="请输入库区编码"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="库区名称" prop="areaName">-->
<!--        <el-input-->
<!--          v-model="queryParams.areaName"-->
<!--          placeholder="请输入库区名称"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
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
        <el-select v-model="queryParams.areaName" clearable filterable>
          <el-option
            v-for="item in areaOptions"
            :key="item.areaName"
            :label="item.areaName"
            :value="item.areaName"
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
<!--      <el-form-item label="本库位数量" prop="areaLocationQty">-->
<!--        <el-input-->
<!--          v-model="queryParams.areaLocationQty"-->
<!--          placeholder="请输入本库位数量"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="仓库" prop="whId">-->
<!--        <el-input-->
<!--          v-model="queryParams.whId"-->
<!--          placeholder="请输入仓库id"-->
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
          v-hasPermi="['admin:area:add']"
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
          v-hasPermi="['admin:area:edit']"
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
          v-hasPermi="['admin:area:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['admin:area:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="areaList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="库区id" align="center" prop="id" />-->
      <el-table-column label="库区编码" align="center" prop="areaCode" />
      <el-table-column label="库区名称" align="center" prop="areaName" />
      <el-table-column label="库区类型" align="center" prop="areaType" />
      <el-table-column label="本库位数量" align="center" prop="areaLocationQty" />
      <el-table-column label="仓库" align="center" prop="whName" />
<!--      <el-table-column label="状态0  禁用 1启用" align="center" prop="status" />-->
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
            v-hasPermi="['admin:area:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['admin:area:remove']"
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

    <!-- 添加或修改库区列对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="库区编码" prop="areaCode">
          <el-input v-model="form.areaCode" placeholder="请输入库区编码" />
          </el-form-item>
        <el-form-item label="库区名称" prop="areaName">
          <el-input v-model="form.areaName" placeholder="请输入库区名称" />
        </el-form-item>
        <el-form-item label="库区类型" prop="areaType">
          <el-input v-model="form.areaType" placeholder="请输入库区类型" />
        </el-form-item>
<!--        <el-form-item label="本库位数量" prop="areaLocationQty">-->
<!--          <el-input v-model="form.areaLocationQty" placeholder="请输入本库位数量" />-->
<!--        </el-form-item>-->

        <el-form-item label="本库位数量" prop="areaLocationQty">
          <el-input-number v-model="form.areaLocationQty" controls-position="right" :min="0" />
        </el-form-item>

        <el-form-item label="仓库" prop="whId">
          <el-select v-model="form.whId" placeholder="请选择" clearable filterable  @click.native="getWarehouseList()">
            <el-option
              v-for="item in warehouseOptions"
              :key="item.id"
              :label="item.whName"
              :value="item.id"
              :disabled="item.status == 0"
            ></el-option>
          </el-select>
        </el-form-item>

<!--        <el-form-item label="仓库id" prop="whId">-->
<!--          <el-input v-model="form.whId" placeholder="请输入仓库id" />-->
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
import { listArea,printPdf, getArea, delArea, addArea, updateArea } from "@/api/jotime/base/basics/warehousearea";
import { getWarehouseList } from "@/api/jotime/base/basics/warehouse";
import {Loading} from "element-ui";
import { getAreaList } from '../../../../api/jotime/base/basics/warehousearea'


export default {
  name: "Area",
  dicts: ['sys_jotime_data_status'],
  data() {
    return {
      areaOptions: [],
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
      // 库区列表格数据
      areaList: [],
      //仓库列表
      warehouseOptions:[],
      //判断仓库列表是否为空，只加载一次
      warehouseOptionsIsNull:true,
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        areaCode: null,
        areaName: null,
        areaType: null,
        areaLocationQty: null,
        whId: null,
        whName: null,
        status: null,
        note: null,
      },
      //打印
      printWidth: 90,
      printCount: 1,
      printHeight: 80,
      openPrint: false,
      //选择数据
      rows: [],
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        areaCode: [
          { required: true, message: "库区编码不能为空", trigger: "blur" }
        ],
        areaName: [
          { required: true, message: "库区名称不能为空", trigger: "blur" }
        ],
        areaType: [
          { required: true, message: "库区类型不能为空", trigger: "blur" }
        ],
        areaLocationQty: [
          { required: true, message: "本库位数量不能为空", trigger: "blur" }
        ],
        whId: [
          { required: true, message: "仓库不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "状态不能为空", trigger: "blur" }
        ],
        createBy: [
          { required: true, message: "创建人不能为空", trigger: "blur" }
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
    /** 查询库区列列表 */
    getList() {
      this.loading = true;
      listArea(this.queryParams).then(response => {
        this.areaList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    warehouseChange(value) {
      if (value) {
        getAreaList(value).then(res => {
          let areaOptions = res.areaOptions
          this.areaOptions = areaOptions
        })
      }
    },
    getWarehouseList(){
      if (this.warehouseOptionsIsNull){
        getWarehouseList().then(response => {
          this.warehouseOptions = response.warehouseOptions;
          this.warehouseOptionsIsNull=false;
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
        areaCode: null,
        areaName: null,
        areaType: null,
        areaLocationQty: null,
        whId: null,
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
      this.queryParams.whId = ''
      this.queryParams.areaName = ''
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
      this.title = "添加库区列";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.getWarehouseList();
      const id = row.id || this.ids
      getArea(id).then(response => {
        this.form = response.data;
        this.form.status=parseInt(this.form.status);
        this.open = true;
        this.title = "修改库区列";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateArea(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addArea(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除库区列编号为"' + ids + '"的数据项？').then(function() {
        return delArea(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('admin/area/export', {
        ...this.queryParams
      }, `area_${new Date().getTime()}.xlsx`)
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
      if (this.rows==null||this.rows.length==0) return this.$modal.msgError("请选择要打印的库区！");
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
      obj.isLeft = 2;
      obj.isRight = 10;
      obj.isTop = 13;
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
