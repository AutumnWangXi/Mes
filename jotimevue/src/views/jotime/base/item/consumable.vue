<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="耗材名称" prop="itemName">
        <el-input
          v-model="queryParams.itemName"
          placeholder="耗材名称"
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
          v-hasPermi="['admin:item:add']"
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
          v-hasPermi="['admin:item:edit']"
        >修改
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
      <el-table-column label="耗材编码" align="center" prop="itemCode"/>
      <el-table-column label="耗材编号" align="center" prop="itemNo"/>
      <el-table-column label="耗材名称" align="center" prop="itemName"/>
      <el-table-column label="耗材类别" align="center" prop="categoryType"/>
      <el-table-column label="耗材图片" align="center"  prop="imageUrl">
        <template slot-scope="scope">
          <img  style="width:50px;height:50px;border:none; " :src="scope.row.imageUrl" @click="showImage(scope.row.imageUrl)">
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

    <!-- 添加或修改耗材对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="60%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="110px">
            <el-form-item label="耗材编码" prop="itemCode">
          <el-input v-model="form.itemCode"  disabled/>
        </el-form-item>
            <el-form-item label="耗材编号" prop="itemNo">
              <el-input v-model="form.itemNo"  disabled/>
            </el-form-item>
            <el-form-item label="耗材名称" prop="itemName">
              <el-input v-model="form.itemName" placeholder="请输入耗材名称"/>
            </el-form-item>
            <el-form-item label="耗材类别" prop="categoryType">
              <el-input v-model="form.categoryType" placeholder="耗材类别"/>
            </el-form-item>

          <el-form-item label="包材图片" prop="specifications">
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

            <el-form-item label="备注" prop="note">
              <el-input v-model="form.note" type="textarea" maxlength="500" show-word-limit placeholder="请输入内容"/>
            </el-form-item>
            <el-form-item label="状态">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.sys_jotime_data_status"
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
          是否更新已经存在的数据（根据耗材编码判断）
          <el-link style="font-size:13px" @click="importTemplate" type="primary">点击此处 下载文件模板</el-link>
        </div>
        <div class="el-upload__tip" style="color:red" slot="tip">提示：仅允许导入“xls”或“xlsx”格式文件！</div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFileForm">确 定</el-button>
        <el-button @click="upload.open = false">取 消</el-button>
      </div>
    </el-dialog>
    <el-image-viewer style="z-index: 3000 !important;" v-if="showViewer" :on-close="closeViewer" :url-list="previewList"></el-image-viewer>
  </div>
</template>

<script>
import {
  listItem,
  getItem,
  delItem,
  addItem,
  updateItem,
  ListCusOption,
  ListSuppliers,
  selectMfrsName
} from "@/api/jotime/base/basics/item";
import {getToken} from "@/utils/auth";
import ElImageViewer from "element-ui/packages/image/src/image-viewer";
import FileUp from "@/components/FileUpload";
export default {
  name: "Item",
  components:{ElImageViewer,FileUp},
  dicts: ['sys_brand_own', 'sys_yes_no', 'sys_sales_type', 'sys_product_type', 'sys_material_property', 'sys_material_category','sys_jotime_data_status'],
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
      // 包材表格数据
      itemList: [],
      // 弹出层标题
      title: "",
      src:"",
      // 是否显示弹出层
      open: false,
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
        pageName:"consumable",
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
        url: process.env.VUE_APP_BASE_API + "/web/base/item/importConsumableData",
      },
      // 表单校验
      rules: {
        // itemNo: [
        //   {required: true, message: "耗材编号不能为空", trigger: "blur"}
        // ],
        itemName: [
          {required: true, message: "耗材名称不能为空", trigger: "blur"}
        ],
        itemType: [
          {required: true, message: "耗材类型", trigger: "change"}
        ],
        status: [
          {required: true, message: "状态不能为空", trigger: "blur"}
        ],
        updateBy: [
          {required: true, message: "更新时间不能为空", trigger: "blur"}
        ],
        updateTime: [
          {required: true, message: "更新者不能为空", trigger: "blur"}
        ],
      }
    };
  },

  created() {
    this.getList();
  },
  methods: {
    /** 查询耗材列表 */
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
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        itemCode: null,
        itemNo: null,
        itemName: null,
        inciName: null,
        casNo: null,
        itemShortName: null,
        itemSpecification: null,
        itemType: 7,
        categoryType: null,
        customerItemCode: null,
        mItemType: null,
        sItemType: null,
        colourNumber: null,
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
        needQuality: 1,
        needBarcodeStockout: null,
        needWeigh: 1,
        needConfidential: 1,
        pageName: "consumable",
        status: 2,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        productType: null,
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
      this.src=require('@/assets/images/defaultFindPic.png');
      this.open = true;
      this.title = "添加耗材";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getItem(id).then(response => {
        this.form = response.data;
        this.src = response.data.imageUrl;
        this.open = true;
        this.title = "修改耗材";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateItem(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除耗材编号为"' + ids + '"的数据项？').then(function () {
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
    //图片点击事件
    showImage(imageUrl){
      this.previewList.push(imageUrl);
      this.showViewer = true;
    },
    //预览图片点击事件
    closeViewer(){
      this.previewList.splice(0,this.previewList.length);
      this.showViewer = false;
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
    //预览
    handlePreview(file) {
      console.log(file);
    },
    /**删除上传文件*/
    deleteFile() {
      this.form.imageUrl=" ";
      this.$modal.msgSuccess("文件删除成功");
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "耗材信息导入";
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
      this.download('web/base/item/importConsumableTemplate', {}, `item_consumable_${new Date().getTime()}.xlsx`)
    },
    // 提交上传文件
    submitFileForm() {
      this.$refs.upload.submit();
    },
  }
};
</script>

