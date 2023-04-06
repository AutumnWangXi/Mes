<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="供应商编码" label-width="85px" prop="supplierCode">
        <el-input
          v-model="queryParams.supplierCode"
          placeholder="请输入供应商编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="供应商名称" label-width="85px" prop="supplierName">
        <el-input
          v-model="queryParams.supplierName"
          placeholder="请输入供应商名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="供应商类型" label-width="85px" prop="supplierItemType">
        <el-select
          v-model="queryParams.supplierItemType"
          placeholder="供应商类型"
          clearable
          size="small"
          style="width: 200px"

        >
          <el-option
            v-for="dict in dict.type.sys_supplier_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="供应商等级" label-width="85px" prop="supplierLevel">
        <el-select
          v-model="queryParams.supplierLevel"
          placeholder="供应商等级"
          clearable
          size="small"
          style="width: 200px"
        >
          <el-option
            v-for="lev in dict.type.sys_supplier_level"
            :key="lev.value"
            :label="lev.label"
            :value="lev.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="状态" label-width="85px" prop="status">
        <el-select
          v-model="queryParams.status"
          placeholder="供应商状态"
          clearable
          size="small"
          style="width: 200px"
        >
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
          v-hasPermi="['base:supplier:add']"
        >新增</el-button>
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
          v-hasPermi="['base:supplier:edit']"
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
          v-hasPermi="['base:supplier:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['base:supplier:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="supplierList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="供应商编码" align="center" prop="supplierCode" />
      <el-table-column label="供应商名字" align="center" prop="supplierName" width="150" />
      <el-table-column label="联系人" align="center" prop="contactPerson" />
      <el-table-column label="联系人手机" align="center" prop="contactTelephone" />
      <el-table-column label="联系人邮箱" align="center" prop="contactMail" />
      <el-table-column label="地址" align="center" prop="address" :show-overflow-tooltip="true" width="120" />
      <el-table-column label="营业执照号码" align="center" prop="businessLicense" :show-overflow-tooltip="true" />
      <el-table-column label="法人代表" align="center" prop="legalRepresentative" :show-overflow-tooltip="true" />
      <el-table-column label="公司电话" align="center" prop="companyTelephone" />
      <el-table-column label="纳税人识别号" align="center" prop="tin" width="120" />
      <el-table-column label="开户行" align="center" prop="bankName" width="150" />
      <el-table-column label="开户账号" align="center" prop="caccountNumber" width="120" />
      <el-table-column label="收件地址" align="center" prop="recipientAddress" :show-overflow-tooltip="true" width="120" />
      <el-table-column label="账期" align="center" prop="terms" />
      <el-table-column label="供应商类型" align="center" prop="supplierItemType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_supplier_type" :value="scope.row.supplierItemType"/>
        </template>
      </el-table-column>
      <el-table-column label="供应商等级" align="center" prop="supplierLevel">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_supplier_level" :value="scope.row.supplierLevel"/>
        </template>
      </el-table-column>
      <el-table-column label="供应产品名" align="center" prop="supplyItemName" />
      <el-table-column label="审核状态" align="center" prop="checkStatus" :formatter="checkStsFormat" ></el-table-column>
      <el-table-column label="审核备注" align="center" prop="checkNote" />
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
            v-hasPermi="['base:supplier:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['base:supplier:remove']"
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

    <!-- 添加或修改供应商对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="75%" append-to-body>
      <el-form style="margin-left: 5%" ref="form" :model="form" :rules="rules" :inline="true" label-width="80px">
        <el-form-item label="供应商编码" label-width="" prop="supplierCode">
          <el-input v-model="form.supplierCode" :disabled="true"/>
        </el-form-item>
        <el-form-item label="供应商名称" label-width="" prop="supplierName">
          <el-input v-model="form.supplierName" placeholder="请输入供应商名字" />
        </el-form-item>
        <el-form-item label="联系人" prop="contactPerson" label-width="">
          <el-input v-model="form.contactPerson" placeholder="请输入联系人" />
        </el-form-item>
        <el-form-item label="联系人手机" prop="contactTelephone" label-width="">
          <el-input v-model="form.contactTelephone" placeholder="请输入联系人手机" />
        </el-form-item>
        <el-form-item label="联系人邮箱" prop="contactTelephone" label-width="">
          <el-input v-model="form.contactMail" placeholder="请输入联系人邮箱" />
        </el-form-item>
        <el-form-item label="地址" prop="address" label-width="">
          <el-input v-model="form.address" placeholder="请输入地址" />
        </el-form-item>
        <el-form-item label="营业执照号码" prop="address" label-width="">
          <el-input v-model="form.businessLicense" placeholder="请输入营业执照号码" />
        </el-form-item>
        <el-form-item label="法人代表" prop="address" label-width="">
          <el-input v-model="form.legalRepresentative" placeholder="请输入法人代表" />
        </el-form-item>
        <el-form-item label="公司电话" prop="companyTelephone">
          <el-input v-model="form.companyTelephone" placeholder="请输入公司电话" />
        </el-form-item>
        <el-form-item label="纳税人识别号" prop="tin">
          <el-input v-model="form.tin" placeholder="请输入纳税人识别号" />
        </el-form-item>
        <el-form-item label="开户行" prop="bankName">
          <el-input v-model="form.bankName" placeholder="请输入开户行" />
        </el-form-item>
        <el-form-item label="开户账号" prop="caccountNumber">
          <el-input v-model="form.caccountNumber" placeholder="请输入开户账号" />
        </el-form-item>
        <el-form-item label="收件地址" prop="recipientAddress">
          <el-input v-model="form.recipientAddress" placeholder="请输入收件地址" />
        </el-form-item>
        <el-form-item label="账期" prop="terms">
          <el-input v-model="form.terms" placeholder="请输入账期" />
        </el-form-item>

        <el-form-item label="供应商类型" prop="supplierItemType" label-width="">
          <el-select v-model="form.supplierItemType" placeholder="供应商类型">
            <el-option
              v-for="item in dict.type.sys_supplier_type"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="供应商等级" prop="supplierLevel" label-width="">
          <el-select v-model="form.supplierLevel" placeholder="供应商类型">
            <el-option
              v-for="lev in dict.type.sys_supplier_level"
              :key="lev.value"
              :label="lev.label"
              :value="Number(lev.value)"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="供应物料类型" prop="supplyItemName" label-width="">
          <el-input v-model="form.supplyItemName" placeholder="请输入供应物料类型，多类型使用逗号隔开" />

<!--          <el-select v-model="form.supplyItemName" multiple placeholder="请选择">-->
<!--            <el-option-->
<!--              v-for="item in supplyItemOptions"-->
<!--              :key="item.value"-->
<!--              :label="item.label"-->
<!--              :value="item.value">-->
<!--            </el-option>-->
<!--          </el-select>-->

        </el-form-item>
        <el-form-item label="状态" prop="status" label-width="">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.sys_jotime_data_status"
              :key="dict.value"
              :label="Number(dict.value)"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="备注" prop="note" label-width="">
          <el-input v-model="form.note" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="附件">
          <el-upload
            class="upload-demo"
            :headers="thisToken"

            :action="fileUploadUrl"
            multiple
            :on-success="(response, file, fileList)=>fileSuccess(response, file, fileList,index)"
            :on-error="fileError"
            :on-preview="handlePreview"
            :on-remove="handleRemove"
            :before-remove="beforeRemove"
            :limit="6">
            <el-button size="small" type="primary">点击上传
            </el-button>
          </el-upload>
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
<!--          <el-checkbox v-model="upload.updateSupport"/>-->
<!--          是否更新已经存在的数据（根据包材编码判断）-->
          <el-link style="font-size:13px" @click="importTemplate" type="primary">点击此处 下载文件模板</el-link>
        </div>
        <div class="el-upload__tip" style="color:red" slot="tip">提示：仅允许导入“xls”或“xlsx”格式文件！</div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFileForm">确 定</el-button>
        <el-button @click="upload.open = false">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listSupplier, getSupplier, delSupplier, addSupplier, updateSupplier } from "@/api/jotime/base/basics/supplier";
import {getToken} from "@/utils/auth";
import {addManage, removeFileManageData, updateFileManage} from "@/api/jotime/file/file";
import {removeOssFile} from "@/api/jotime/apvl/formula/formula";

export default {
  name: "Supplier",
  dicts: ['sys_jotime_data_status','sys_yes_no',"sys_supplier_level","sys_supplier_type"],
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
      // 供应商表格数据
      supplierList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      //文件URL
      fileUrlArr: [],
      idArr: [],
      fileList: [],
      thisToken: {Authorization: "Bearer " + getToken()},
      fileUploadUrl: process.env.VUE_APP_BASE_API + "/oss/uploadFile?busType=A99",
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        supplierCode: null,
        supplierName: null,
        contactMail:null,
        address: null,
        businessLicense: null,
        legalRepresentative: null,
        companyTelephone:null,
        tin:null,
        bankName:null,
        caccountNumbe:null,
        recipientAddress:null,
        terms:null,
        contactPerson: null,
        contactTelephone: null,
        supplierItemType: null,
        supplierLevel: null,
        supplyItemName: null,
        checkStatus: null,
        checkId: null,
        checker: null,
        checkTime: null,
        status: null,
        note: null,
      },
      // 表单参数
      form: {},
      // 导入参数
      upload: {
        // 是否显示弹出层（导入）
        open: false,
        // 弹出层标题（导入）
        title: "",
        // 是否禁用上传
        isUploading: false,
        // 设置上传的请求头部
        headers: {Authorization: "Bearer " + getToken()},
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/web/base/supplier/importData",
      },
      // 表单校验
      rules: {
        supplierName: [
          { required: true, message: "供应商名称不能为空", trigger: "blur" }
        ],
        contactPerson: [
          { required: true, message: "联系人不能为空", trigger: "blur" }
        ],
        supplierLevel: [
          { required: true, message: "供应商等级不能为空", trigger: "blur" }
        ],
        supplierItemType: [
          { required: true, message: "供应商类型不能为空", trigger: "blur" }
        ],
        contactTelephone: [
          { required: true, message: "联系人手机不能为空", trigger: "blur" },
          {
            pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/,
            message: "请输入正确的手机号码",
            trigger: "blur"
          }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询供应商列表 */
    getList() {
      this.loading = true;
      listSupplier(this.queryParams).then(response => {
        this.supplierList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /**文件上传功能*/
    //移除所选文件
    handleRemove(file, fileList) {
      let data = {}
      data.deleteFileUrl = file.response.filepath
      data.fileUrl = file.response.ossUrl
      removeFileManageData(data).then(response => {
        this.$modal.msgSuccess('删除文件成功')
      })
    },

    beforeRemove(file, fileList) {
      return this.$confirm(`确定移除 ${file.name}？`);
    },

    handlePreview(file) {
      window.open(file.response.ossUrl)
    },
    //文件上传成功钩子
    fileSuccess(response, file, fileList,) {
      let UUID = Math.floor(Math.random() * 10000);
      this.fileIDArr.push(UUID);
      let ossUrl = response.ossUrl;
      let filepath = response.filepath;
      this.fileUrlArr.push(filepath);
      //获取文件的名称
      let fileName = file.raw.name;
      let fileType = file.raw.type;
      let fileSize = file.raw.size;
      let obj = {};
      obj.tableId = UUID;
      obj.fileName = fileName;
      obj.fileType = fileType;
      obj.fileSize = fileSize;
      obj.title = "资料上传附件";
      obj.tableName = "baseSupplier";
      obj.fileUrl = ossUrl;
      //评论附件类型
      obj.tableType = 1;
      if (response.code === 1) {
        addManage(obj);
        this.$modal.msgSuccess("文件上传成功");
      } else {
        // 实现缩略图模板时删除文件
        let index = fileList.findIndex((fileItem) => {
          return fileItem.uid === file.uid;
        });
        fileList.splice(index, 1);
        this.$modal.msgError(response.msg);
      }
    },
    //文件上传失败钩子
    fileError(err, file, fileList) {
      this.$modal.msgSuccess("文件上传失败，请联系管理员");
      console.log(err);
    },
    /**删除上传文件*/
    deleteFile(file, fileList) {
      let data = {}
      data.uuidList = this.fileIDArr
      data.filePaths = this.fileUrlArr;
      removeOssFile(data).then((response) => {
      });
    },
    fileRemove(file, fileList) {
      let arr = [];
      let id = file.id;
      let obj = {};
      obj.isDelete = 2;
      obj.id = id;
      arr.push(obj);
      this.deleteFile();
      updateFileManage(arr).then((response) => {
        this.$modal.msgSuccess("删除文件成功");
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
        supplierCode: null,
        supplierName: null,
        contactMail:null,
        address: null,
        businessLicense: null,
        legalRepresentative: null,
        companyTelephone:null,
        tin:null,
        bankName:null,
        caccountNumbe:null,
        recipientAddress:null,
        terms:null,
        contactPerson: null,
        contactTelephone: null,
        supplierItemType: null,
        supplierLevel: null,
        supplyItemName: null,
        checkStatus: "0",
        checkId: null,
        checker: null,
        checkTime: null,
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
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.form.status = 2;
      this.title = "添加供应商";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getSupplier(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改供应商";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateSupplier(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSupplier(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除供应商编号为"' + ids + '"的数据项？').then(function() {
        return delSupplier(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('base/supplier/export', {
        ...this.queryParams
      }, `supplier_${new Date().getTime()}.xlsx`)
    },
    /** 审核状态 */
    checkStsFormat(row, column) {
      if (row.checkStatus == 1) {
          return '待审核'
      } else if (row.checkStatus == 2) {
          return '审核中'
      } else if (row.checkStatus == 3) {
        return '通过'
      } else if (row.checkStatus == 9) {
        return '驳回'
      }
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "信息导入";
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
      this.download('web/base/supplier/importTemplate', {}, `supplier_${new Date().getTime()}.xlsx`)
    },
    // 提交上传文件
    submitFileForm() {
      this.$refs.upload.submit();
    },
  }
};
</script>
<style lang="scss" scoped>
::v-deep .el-input__inner{
  width: 200px;
}
::v-deep .el-form-item{
  margin-bottom: 0;
}
</style>
