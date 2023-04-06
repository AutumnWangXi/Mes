<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="110px">
      <el-form-item label="预混料编码" prop="itemCode">
        <el-input
          v-model="queryParams.itemCode"
          placeholder="请输入预混料编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="预混料名称" prop="itemName">
        <el-input
          v-model="queryParams.itemName"
          placeholder="请输入预混料名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="条形码" prop="barCode">-->
<!--        <el-input-->
<!--          v-model="queryParams.barCode"-->
<!--          placeholder="请输入条形码"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="客户名称" prop="customerId">
        <el-select v-model="queryParams.customerId" filterable placeholder="请选择" size="small">
          <el-option
            v-for="item in cusOptions"
            :key="item.id"
            :label="item.customerName"
            :value="item.id"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="供应商" prop="supplierId">
        <el-select v-model="queryParams.supplierId" clearable filterable placeholder="请选择" size="small">
          <el-option
            v-for="item in supplierList"
            :key="item.id"
            :label="item.supplierName"
            :value="item.id"
          />
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
          v-hasPermi="['admin:item:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="info"
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
        >导入
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
          v-hasPermi="['admin:item:edit']"
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
          v-hasPermi="['admin:item:remove']"
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
          v-hasPermi="['admin:item:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="itemList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="预混料编码" align="center" prop="itemCode"/>
      <el-table-column label="预混料编号" align="center" prop="itemNo"/>
      <el-table-column label="预混料名称" align="center" prop="itemName"/>
      <el-table-column label="含量" align="center">
        <template slot-scope="scope">
          <el-button @click="getItemContentList(scope.row)" size="mini" type="text" icon="el-icon-tickets">
            含量
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="规格" align="center" prop="specifications"/>
      <el-table-column label="预混料图片" align="center"  prop="imageUrl">
        <template slot-scope="scope">
          <img  style="width:50px;height:50px;border:none; " :src="scope.row.imageUrl" @click="showImage(scope.row.imageUrl)">
        </template>
      </el-table-column>
      <el-table-column label="表现" align="center" prop="appearance"/>
      <el-table-column label="条形码" align="center" prop="barCode"/>
      <el-table-column label="备注" align="center" prop="note"/>
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_jotime_data_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['admin:item:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['admin:item:remove']"
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

    <!-- 添加或修改物料对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-row>
        <el-form-item label="预混料编码" prop="itemCode" >
          <el-input v-model="form.itemCode" placeholder="请输入预混料编码" disabled/>
        </el-form-item>
        <el-form-item label="预混料编号" prop="itemNo">
          <el-input v-model="form.itemNo" placeholder="请输入预混料编号" disabled/>
        </el-form-item>
        <el-form-item label="预混料名称" prop="itemName">
          <el-input v-model="form.itemName" placeholder="请输入预混料名称"/>
        </el-form-item>
        <el-form-item label="规格" prop="specifications">
          <el-input v-model="form.specifications" placeholder="请输入规格"/>
        </el-form-item>

          <el-form-item label="预混料图片" prop="specifications">
            <el-image
              class="avatar"
              style="width: 80px; height: 80px"
              :src="src"
              @click="showImage(src)"
            ></el-image>
            <el-upload
              style="height: 50px"
              class="upload-demo"
              :headers="thisToken"
              :limit="1"
              :action="fileUploadUrl"
              :on-success="fileSuccess"
              :on-error="fileError"
              :on-preview="handlePreview"
              :on-remove="deleteFile"

            >
              <el-button size="small" type="primary">点击上传</el-button>
            </el-upload>
          </el-form-item>

        <el-form-item label="表现" prop="appearance">
          <el-input v-model="form.appearance" placeholder="请输入表现"/>
        </el-form-item>
        <el-form-item label="条形码" prop="barCode">
          <el-input v-model="form.barCode" placeholder="请输入条形码"/>
        </el-form-item>
        <el-form-item label="备注" prop="note">
          <el-input v-model="form.note" type="textarea" placeholder="请输入内容"/>
        </el-form-item>
        <el-col :span="12">
          <el-form-item label="状态">
            <el-radio-group v-model="form.status">
              <el-radio
                v-for="dict in dict.type.sys_jotime_data_status"
                :key="dict.value"
                :label="Number(dict.value)"
              >{{dict.label}}</el-radio>
            </el-radio-group>
          </el-form-item>
        </el-col>
        </el-row>
        <div align="right">
          <el-button size="mini" type="primary" plain @click="addBaseItemContentRow">添加行</el-button>
        </div>
        <el-tabs v-model="activeName" @tab-click="tabsClick" type="border-card">
          <el-tab-pane label="物料含量详细" name="1">
            <div class="table">
              <el-table v-loading="loading" border :data="form.baseItemContents">
                <!--            <el-table-column type="selection" width="45" align="center"></el-table-column>-->
                <!--                <el-table-column width="30" align="center"></el-table-column>-->
                <el-table-column label="序号" type="index" width="60" align="center"></el-table-column>
                <el-table-column label="化妆品适用原料序号" min-width="100%" align="center">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.serialNumber" disabled align="center"></el-input>
                  </template>
                </el-table-column>
                <el-table-column label="标准中文名" min-width="100%" align="center">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.inciNameCn" @change="inciNameCnChange(scope)" align="center"></el-input>
                  </template>
                </el-table-column>
                <el-table-column label="INCI名称(英文)" min-width="100%" align="center" prop="inspectContent">
                  <template slot-scope="scope">
                    <el-select v-model="scope.row.inciNameEn" @change="inciNameEnChange(scope.row.inciNameEn,scope)" clearable filterable placeholder="请选择">
                      <el-option
                        v-for="item in inciNameEnlist"
                        :key="item.value"
                        :label="item.inciNameEn"
                        :value="item.inciNameEn">
                      </el-option>
                    </el-select>
                  </template>
                </el-table-column>
                <el-table-column label="CAS编号" min-width="100%" align="center">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.casNo" align="center"></el-input>
                  </template>
                </el-table-column>
                <el-table-column label="含量" min-width="100%" align="center">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.content" align="center"></el-input>
                  </template>
                </el-table-column>
                <el-table-column label="EINECS号" min-width="100%" align="center">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.einecsNo" align="center"></el-input>
                  </template>
                </el-table-column>
                <el-table-column label="FEMA编号" min-width="100%" align="center">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.femaNo" align="center"></el-input>
                  </template>
                </el-table-column>
                <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
                  <template slot-scope="scope">
                    <el-button
                      size="mini"
                      type="text"
                      icon="el-icon-delete"
                      @click="delectBaseItemContentRowData(scope.row,scope.$index)"
                    >删除
                    </el-button>
                  </template>
                </el-table-column>
              </el-table>
            </div>
          </el-tab-pane>
          <el-tab-pane label="供应商" name="2">
            <div class="table">
              <el-table v-loading="loading" border :data="form.baseItemSupplierS">
                <!--            <el-table-column type="selection" width="45" align="center"></el-table-column>-->
                <!--                <el-table-column width="30" align="center"></el-table-column>-->
                <el-table-column label="序号" type="index" width="60" align="center"></el-table-column>
                <el-table-column label="供应商编号" min-width="100%" align="center">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.supplierCode" align="center"></el-input>
                  </template>
                </el-table-column>
                <el-table-column label="供应商名称" min-width="100%" align="center">
                  <template slot-scope="scope">
                    <!--                    <el-input v-model="scope.row.supplierName" align="center"></el-input>-->
                    <el-select v-model="scope.row.supplierName" @change="supplierNamechange(scope.row)" clearable filterable placeholder="请选择">
                      <el-option
                        v-for="item in supplierList"
                        :key="item.index"
                        :label="item.supplierName"
                        :value="item.supplierName">
                      </el-option>
                    </el-select>
                  </template>
                </el-table-column>
                <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
                  <template slot-scope="scope">
                    <el-button
                      size="mini"
                      type="text"
                      icon="el-icon-delete"
                      @click="delectbaseItemSupplierS(scope.row,scope.$index)"
                    >删除
                    </el-button>
                  </template>
                </el-table-column>
              </el-table>
            </div>
          </el-tab-pane>
        </el-tabs>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 导入对话框 -->
    <el-dialog :title="upload.title" :visible.sync="upload.open" width="400px">
      <el-upload
        ref="upload"
        :limit="1"
        accept=".xlsx, .xls"
        :headers="upload.headers"
        :action="upload.url + '?updateSupport=' + upload.updateSupport"
        :disabled="upload.isUploading"
        :on-progress="handleFileUploadProgress"
        :on-success="handleFileSuccess"
        :auto-upload="false"
        drag
      >
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">
          将文件拖到此处，或
          <em>点击上传</em>
        </div>
        <div class="el-upload__tip" slot="tip">
          <el-checkbox v-model="upload.updateSupport"/>
          是否更新已经存在的数据（根据预混料编码判断）
          <el-link style="font-size:13px" @click="importTemplate" type="primary">点击此处 下载文件模板</el-link>
        </div>
        <div class="el-upload__tip" style="color:red" slot="tip">提示：仅允许导入“xls”或“xlsx”格式文件！</div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFileForm">确 定</el-button>
        <el-button @click="upload.open = false">取 消</el-button>
      </div>
    </el-dialog>

    <el-drawer
      :title="thisItemName"
      v-loading="loading"
      :visible.sync="drawer"
      size="45%"
      :with-header="true">
      <el-table :data="baseItemContentList">
        <el-table-column align="center" min-width="100px" label="适用原料序号" prop="serialNumber">
        </el-table-column>
        <el-table-column align="center" min-width="100px" label="标准中文名" prop="inciNameCn">
        </el-table-column>
        <el-table-column align="center" min-width="100px" label="INCI名称(英文)" prop="inciNameEn">
        </el-table-column>
        <el-table-column align="center" min-width="90px" label="CAS编号" prop="casNo">
        </el-table-column>
        <el-table-column align="center" min-width="80px" label="含量" prop="content">
        </el-table-column>
        <el-table-column align="center" min-width="100px" label="EINECS号" prop="einecsNo">
        </el-table-column>
        <el-table-column align="center" min-width="100px" label="FEMA编号" prop="femaNo">
        </el-table-column>
        <el-table-column align="center" min-width="100px" label="成分安全分" prop="safetyScore">
        </el-table-column>
        <el-table-column align="center" min-width="100px" label="致痘风险" prop="acneRisk">
        </el-table-column>
      </el-table>
    </el-drawer>
    <el-image-viewer style="z-index: 3000 !important;" v-if="showViewer" :on-close="closeViewer" :url-list="previewList"></el-image-viewer>
  </div>
</template>

<script>
import {
  listItem,
  getItem,
  delItem,
  addItem,
  editOther,
  materiallist,material,
  ListCusOption, ListSuppliers,cosmeticMateria, materialcode
} from "@/api/jotime/base/basics/item";
import ElImageViewer from "element-ui/packages/image/src/image-viewer";
import FileUp from "@/components/FileUpload";
import {getToken} from "@/utils/auth";
import {listItemContent} from "@/api/jotime/base/basics/itemContent";

export default {
  name: "Item",
  components:{ElImageViewer,FileUp},
  dicts: ['sys_jotime_data_status'],
  data() {
    return {
      drawer: false,
      UUID: null,
      inciNameEnlist: [],
      //tabs默认选中
      activeName: '1',
      tabsName: '1',
      thisItemName: [],
      //物料含量表
      baseItemContentList: [],
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
      //图片默认路径
      src:"",
      // 物料表格数据
      itemList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      supplierList: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        itemCode: null,
        itemNo: null,
        itemName: null,
        inciName: null,
        casNo: null,
        itemShortName: null,
        itemSpecification: null,
        itemType: null,
        categoryType: null,
        customerItemCode: null,
        mItemType: null,
        sItemType: null,
        colourNumber: null,
        appearance: null,
        specifications: null,
        unit: null,
        brand: null,
        brandOwn: null,
        price: null,
        lineNetWeight: null,
        identificationNetWeight: null,
        fillingVolumeUpper: null,
        fillingVolumeLower: null,
        fillingUnit: null,
        imageUrl: null,
        density: null,
        percentage: null,
        barCode: null,
        customerId: null,
        property: null,
        supplierId: null,
        manufacturerId: null,
        note: null,
        warnToplimit: null,
        warnLowerlimit: null,
        content: null,
        storageCondition: null,
        placeOrigin: null,
        introductionConditions: null,
        introductionDate: null,
        validDate: null,
        needQuality: null,
        needBarcodeStockout: null,
        needWeigh: null,
        needConfidential: null,
        status: null,
        pageName: 'premix',
        productType: null
      },
      // 表单参数
      form: {},
      //图片
      thisToken: {Authorization: "Bearer " + getToken()},
      fileUploadUrl: process.env.VUE_APP_BASE_API + "/oss/uploadFile?busType=E01",
      previewList:[],
      showViewer:false,
      // 导入参数
      upload: {
        // 是否显示弹出层（导入）
        open: false,
        // 弹出层标题（导入）
        title: "",
        // 是否禁用上传
        isUploading: false,
        // 是否更新已经存在的用户数据
        updateSupport: 0,
        // 设置上传的请求头部
        headers: {Authorization: "Bearer " + getToken()},
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/web/base/item/importPremixData",
      },
      // 表单校验
      rules: {
        // itemNo: [
        //   {required: true, message: "物料编号不能为空", trigger: "blur"}
        // ],
        itemName: [
          {required: true, message: "物料名称不能为空", trigger: "blur"}
        ],
      }
    };
  },
  created() {
    this.getList();
    this.getCusOptions();
    this.getSupplierName();
    materiallist().then( res =>{
      console.log(res)
      this.supplierList = res.rows
    })
  },
  methods: {
    supplierNamechange(row){
      let obj = {}
      obj.supplierName = row.supplierName
      if(row.supplierName) {
        materialcode(obj).then(res => {
          for (let i in this.form.baseItemSupplierS) {
            if (row.id === this.form.baseItemSupplierS[i].id) {
              this.form.baseItemSupplierS[i].supplierCode = res.data.supplierCode
            }
          }
        })
      }
    },
    //中文名change
    inciNameCnChange(scope){
      cosmeticMateria(scope.row.inciNameCn).then(res=>{
        // this.form.baseItemContents[scope.$index].serialNumber = res.data.serialNumber
        if (res.data.length === 1){
          this.form.baseItemContents[scope.$index].inciNameEn = res.data[0].inciNameEn
          this.form.baseItemContents[scope.$index].serialNumber = res.data[0].serialNumber
          this.inciNameEnlist = res.data
        }else{
          this.inciNameEnlist = res.data
        }


      })

    },
    //INCI名称change
    inciNameEnChange(data,scope){
      for (let i in this.inciNameEnlist){
        if (this.inciNameEnlist[i].inciNameEn == data){
          this.form.baseItemContents[scope.$index].serialNumber = this.inciNameEnlist[i].serialNumber
        }
      }
    },


    // 增加行
    addBaseItemContentRow() {
      if (this.tabsName === '1'){
        if (this.form.baseItemContents === undefined){
          this.form.baseItemContents = []
          this.form.baseItemContents.push({serialNumber: null,inciNameCn: null,inciNameEn: null});
          this.$forceUpdate()
        }else{
          this.form.baseItemContents.push({serialNumber: null,inciNameCn: null,inciNameEn: null});
        }
      }else if(this.tabsName === '2'){
        if (this.form.baseItemSupplierS === undefined){
          this.form.baseItemSupplierS = []
          this.form.baseItemSupplierS.push({});
          this.$forceUpdate()
        }else{
          this.form.baseItemSupplierS.push({});
        }

      }

    },

    // 删除单行
    delectBaseItemContentRowData(row, index) {
      this.form.baseItemContents.splice(index, 1);
    },
    delectbaseItemSupplierS(row, index) {
      this.form.baseItemSupplierS.splice(index, 1);
    },

    getItemContentList(row) {
      this.thisItemName = '原料标准名称：' + row.itemName;
      this.reset();
      listItemContent({itemId: row.id}).then(res => {
        this.baseItemContentList = res.rows;
        console.log(this.baseItemContentList);
      });
      this.drawer = true
    },
    /** 查询物料列表 */
    getList() {
      this.loading = true;
      listItem(this.queryParams).then(response => {
        this.itemList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.fileUpload = false;
      this.reset();
    },
    //tabs切换
    tabsClick(tab,even){
      this.tabsName = tab.name
    },
    // 表单重置
    reset() {
      this.baseItemContentList = [];
      this.form = {
        id: null,
        itemCode: null,
        itemNo: null,
        itemName: null,
        inciName: null,
        casNo: null,
        itemShortName: null,
        itemSpecification: null,
        itemType: 3,
        categoryType: null,
        customerItemCode: null,
        mItemType: null,
        sItemType: null,
        colourNumber: null,
        appearance: null,
        specifications: null,
        unit: null,
        brand: null,
        brandOwn: null,
        price: null,
        lineNetWeight: null,
        identificationNetWeight: null,
        fillingVolumeUpper: null,
        fillingVolumeLower: null,
        fillingUnit: null,
        imageUrl: null,
        density: null,
        percentage: null,
        barCode: null,
        customerId: null,
        property: null,
        supplierId: null,
        manufacturerId: null,
        note: null,
        warnToplimit: null,
        warnLowerlimit: null,
        content: null,
        storageCondition: null,
        placeOrigin: null,
        introductionConditions: null,
        introductionDate: null,
        validDate: null,
        needQuality: 2,
        needBarcodeStockout: 1,
        needWeigh: 2,
        needConfidential: 1,
        status: 2,
        pageName: 'premix',
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        productType: null,
        // 客户列表
        cusOptions: null,
        //供应商列表
        supplierName: null
      };
      this.resetForm("form");
    },
    /** 查询客户列表 */
    getCusOptions() {
      ListCusOption().then(response => {
        this.cusOptions = response.data;
      });
    },
    //供应商名称
    getSupplierName() {
      ListSuppliers().then(response => {
        this.supplierName = response.data;
      });
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
      this.src=require('@/assets/images/defaultFindPic.png');
      this.open = true;
      this.title = "添加物料";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getItem(id).then(response => {
        this.form = response.data;
        this.src = response.data.imageUrl;
        this.open = true;
        this.title = "修改物料";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            editOther(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addItem(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除物料编号为"' + ids + '"的数据项？').then(function () {
        return delItem(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('web/base/item/export', {
        ...this.queryParams
      }, `item_${new Date().getTime()}.xlsx`)
    },
    /**删除上传文件*/
    deleteFile() {
      this.form.imageUrl=" ";
      this.$modal.msgSuccess("文件删除成功");
    },
    closeViewer(){
      this.previewList.splice(0,this.previewList.length);
      this.showViewer = false;
    },
    //图片点击事件
    showImage(imageUrl){
      this.previewList.push(imageUrl);
      this.showViewer = true;
    },
    handlePreview(file) {
      console.log(file);
    },
    //文件上传失败钩子
    fileError(err, file, fileList) {
      this.$modal.msgSuccess("文件上传失败，请联系管理员");
      console.log(err);
    },
    //文件上传成功钩子
    fileSuccess(response, file, fileList) {
      if (response.code === 1) {
        this.form.imageUrl = response.ossUrl;
        this.src =  response.ossUrl;
        console.log(this.form.imageUrl)
        this.$modal.msgSuccess('文件上传成功')

      } else {
        this.$modal.msgError('文件上传失败')
      }
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "预混料信息导入";
      this.upload.open = true;
    },
    // 文件上传中处理
    handleFileUploadProgress(event, file, fileList) {
      this.upload.isUploading = true;
    },
    // 文件上传成功处理
    handleFileSuccess(response, file, fileList) {
      this.upload.open = false;
      this.upload.isUploading = false;
      this.$refs.upload.clearFiles();
      this.$alert(response.msg, "导入结果", {dangerouslyUseHTMLString: true});
      this.getList();
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('web/base/item/importPremixTemplate', {}, `item_premix_${new Date().getTime()}.xlsx`)
    },
    // 提交上传文件
    submitFileForm() {
      this.$refs.upload.submit();
    },
  }
};
</script>
