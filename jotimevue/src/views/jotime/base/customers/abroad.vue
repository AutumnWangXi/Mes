<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="客户名称" prop="customerName">
        <el-input
          v-model="queryParams.customerName"
          placeholder="请输入客户名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="合作深度" prop="cooperationDepth">
        <el-input
          v-model="queryParams.cooperationDepth"
          placeholder="请输入合作深度"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客户等级" prop="customerLevel">
        <el-select
          v-model="queryParams.customerLevel"
          placeholder="请输入客户等级"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        >
          <el-option v-for="lev in dict.type.sys_customers_level"
                     :key="lev.value"
                     :label="lev.label"
                     :value="lev.value"/>
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
          type="info"
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
        >导入
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['web:customers:add']"
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
          v-hasPermi="['web:customers:edit']"
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
          v-hasPermi="['web:customers:remove']"
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
          v-hasPermi="['web:customers:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="customersList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="客户编号" align="center" prop="customerCode"/>
      <el-table-column label="客户名称" align="center" prop="customerName"/>
      <el-table-column label="地址" align="center" width="200" :show-overflow-tooltip="true" prop="address"/>
      <el-table-column label="公司电话" align="center" prop="companyTelephone"/>
      <el-table-column label="纳税人识别号" align="center" prop="tin"/>
      <el-table-column label="开户行" align="center" prop="bankName"/>
      <el-table-column label="开户账号" align="center" prop="caccountNumber"/>
      <el-table-column label="收件地址" align="center" prop="recipientAddress"/>
      <el-table-column label="收货人" align="center" prop="consignee"/>
      <el-table-column label="收货人联系电话" align="center" prop="consigneeTelephone"/>
      <el-table-column label="收货地址" align="center" prop="deliveryAddress"/>
      <el-table-column label="联系人" align="center" prop="contactPerson"/>
      <el-table-column label="邮箱" align="center" prop="email"/>
      <el-table-column label="客户类型" align="center" prop="customerCategory">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_customer_category" :value="scope.row.customerCategory"/>
        </template>
      </el-table-column>
      <el-table-column label="付款方式" align="center" prop="payType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_payment_method" :value="scope.row.payType"/>
        </template>
      </el-table-column>
      <el-table-column :show-overflow-tooltip="true" label="业务联系概况" align="center" prop="businessContactOutline"/>
      <el-table-column label="业务类型" align="center" prop="businessType"/>
      <el-table-column :show-overflow-tooltip="true" label="客户品牌" align="center" prop="customerBrand"/>
      <el-table-column label="主营产品" align="center" prop="mainProduct"/>
      <el-table-column label="销售渠道" align="center" prop="distributionChannel"/>
      <el-table-column label="主要国别市场" align="center" prop="majorCountryMarkets"/>
      <el-table-column label="年销售额(美元）" align="center" prop="salesYear"/>
      <el-table-column label="人员规模" align="center" prop="staffSize"/>
      <el-table-column :show-overflow-tooltip="true" label="客户需求" align="center" prop="customerDemand"/>
      <el-table-column label="星级评定" align="center" prop="customerStarLevel">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_customers_level" :value="scope.row.customerStarLevel"/>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_jotime_data_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column :show-overflow-tooltip="true" label="备注" align="center" prop="note"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" fixed="right">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['web:customers:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['web:customers:remove']"
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

    <!--    国内客户导入对话框 -->
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
          是否更新已经存在的用户数据
          <el-link style="font-size:12px" @click="importTemplate" type="primary">下载模板</el-link>
        </div>
        <div class="el-upload__tip" style="color:red" slot="tip">提示：仅允许导入“xls”或“xlsx”格式文件！</div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFileForm">确 定</el-button>
        <el-button @click="upload.open = false">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 添加或修改客户集合对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="60%x" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="32%">
        <el-row>
          <el-col :span="12">
            <el-form-item label="客户编号" prop="customerCode">
              <el-input v-model="form.customerCode" disabled />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="客户名称" prop="customerName">
              <el-input v-model="form.customerName" placeholder="请输入客户名称"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="联系人" prop="contactPerson">
              <el-input v-model="form.contactPerson" placeholder="请输入联系人"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="地址" prop="address">
              <el-input v-model="form.address" placeholder="请输入地址"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-col :span="12">
          <el-form-item label="公司电话" prop="companyTelephone">
            <el-input v-model="form.companyTelephone" placeholder="请输入公司电话"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="纳税人识别号" prop="tin">
            <el-input v-model="form.tin" placeholder="请输入纳税人识别号"/>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="开户行" prop="bankName">
            <el-input v-model="form.bankName" placeholder="请输入开户行"/>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="开户账号" prop="caccountNumber">
            <el-input v-model="form.caccountNumber" placeholder="请输入开户账号"/>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="收件地址" prop="recipientAddress">
            <el-input v-model="form.recipientAddress" placeholder="请输入收件地址"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="收货人" prop="consignee">
            <el-input v-model="form.consignee" placeholder="请输入收货人"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="收货人联系电话" prop="consigneeTelephone">
            <el-input v-model="form.consigneeTelephone" placeholder="请输入收货人联系电话"/>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="收货地址" prop="deliveryAddress">
            <el-input v-model="form.deliveryAddress" placeholder="请输入收货地址"/>
          </el-form-item>
        </el-col>
        <el-row>
          <el-col :span="12">
            <el-form-item label="邮箱" prop="email">
              <el-input v-model="form.email" placeholder="请输入邮箱"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="客户类型" align="center" prop="customerCategory">
              <el-select v-model="form.customerCategory" placeholder="请选择付款方式">
                <el-option v-for="lev in dict.type.sys_customer_category"
                           :key="lev.value"
                           :label="lev.label"
                           :value="String(lev.value)"/>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="付款方式" prop="customerLevel">
              <el-select v-model="form.payType" placeholder="请选择付款方式">
                <el-option v-for="lev in dict.type.sys_payment_method"
                           :key="lev.value"
                           :label="lev.label"
                           :value="Number(lev.value)"/>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="业务联系概况" prop="businessContactOutline">
              <el-input v-model="form.businessContactOutline" placeholder="请输入业务联系概况"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="业务类型" prop="businessType">
              <el-select v-model="form.businessType" placeholder="请选择付款方式">
                <el-option v-for="lev in dict.type.sys_business_type"
                           :key="lev.value"
                           :label="lev.label"
                           :value="Number(lev.value)"/>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="客户品牌" prop="customerBrand">
              <el-input v-model="form.customerBrand" placeholder="请输入客户品牌"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="主营产品" prop="mainProduct">
              <el-input v-model="form.mainProduct" placeholder="请输入主营产品"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="销售渠道" prop="distributionChannel">
              <el-input v-model="form.distributionChannel" placeholder="请输入销售渠道"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="主要国别市场" prop="majorCountryMarkets">
              <el-input v-model="form.majorCountryMarkets" placeholder="请输入主要国别市场"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="年度销售($）" prop="salesYear">
              <el-input v-model="form.salesYear" placeholder="请输入年度销售额度(单位：美元）"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="人员规模" prop="staffSize">
              <el-input v-model="form.staffSize" placeholder="请输入人员规模"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="客户需求" prop="customerDemand">
              <el-input v-model="form.customerDemand" placeholder="请输入客户需求"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="客户星级评定" prop="customerStarLevel">
              <el-select v-model="form.customerStarLevel" placeholder="请输入成品合作供应商">
                <el-option v-for="dict in dict.type.sys_customers_level"
                           :key="dict.value"
                           :label="dict.label"
                           :value="Number(dict.value)"/>
              </el-select>
            </el-form-item>
          </el-col>
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
        <el-form-item label="备注" style="margin-left: -170px" prop="note">
          <el-input v-model="form.note"  type="textarea" maxlength="500" show-word-limit placeholder="请输入内容"/>
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
  listCustomers,
  getCustomers,
  delCustomers,
  addCustomers,
  updateCustomers
} from "@/api/jotime/base/basics/customers";
import {getToken} from "@/utils/auth";

export default {
  name: "Customers",
  //数据字典
  dicts: ['sys_yes_no', 'sys_customers_level', 'sys_jotime_data_status', 'sys_payment_method','sys_customer_category','sys_business_type'],
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
      // 客户集合表格数据
      customersList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 用户导入参数
      upload: {
        // 是否显示弹出层（用户导入）
        open: false,
        // 弹出层标题（用户导入）
        title: "",
        // 是否禁用上传
        isUploading: false,
        // 是否更新已经存在的用户数据
        updateSupport: 0,
        // 设置上传的请求头部
        headers: {Authorization: "Bearer " + getToken()},
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/web/base/customers/importData",
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        customerCode: null,
        customerName: null,
        address: null,
        companyTelephone:null,
        tin:null,
        bankName:null,
        caccountNumber:null,
        recipientAddress:null,
        consignee:null,
        consigneeTelephone:null,
        deliveryAddress:null,
        contactPerson: null,
        contactTelephone: null,
        email: null,
        payType: null,
        cooperationDepth: null,
        customerBrand: null,
        brandStatus: null,
        categoryStatus: null,
        customerLevel: null,
        salesModel: null,
        onlineShopAddress: null,
        onlineMonthlySales: null,
        staffSize: null,
        salesScale: null,
        packagingSupplier: null,
        completeSuppliers: null,
        customerDemand: null,
        businessContactOutline: null,
        businessType: null,
        mainProduct: null,
        distributionChannel: null,
        majorCountryMarkets: null,
        salesYear: null,
        customerStarLevel: null,
        customerType: null,
        status: null,
        note: null,
        creator: null,
        creatorId: null,
        createDate: null,
        modifiedUser: null,
        gmtModified: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        email: [
          {
            type: "email",
            message: "'请输入正确的邮箱地址",
            trigger: ["blur", "change"]
          }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询客户集合列表 */
    getList() {
      this.loading = true;
      listCustomers(this.queryParams, 'abroad').then(response => {
        this.customersList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "国内客户导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('web/base/customers/importTemplate', {}, `customers_template_${new Date().getTime()}.xlsx`)
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
// 提交上传文件
    submitFileForm() {
      this.$refs.upload.submit();
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.openPrint = false
      this.countStatus = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        customerCode: null,
        customerName: null,
        address: null,
        companyTelephone: null,
        tin: null,
        bankName: null,
        caccountNumber: null,
        recipientAddress: null,
        consignee: null,
        consigneeTelephone: null,
        deliveryAddress: null,
        contactPerson: null,
        contactTelephone: null,
        email: null,
        payType: null,
        cooperationDepth: null,
        customerBrand: null,
        brandStatus: "0",
        categoryStatus: "0",
        customerLevel: null,
        salesModel: null,
        onlineShopAddress: null,
        onlineMonthlySales: null,
        staffSize: null,
        salesScale: null,
        packagingSupplier: null,
        completeSuppliers: null,
        customerDemand: null,
        businessContactOutline: null,
        businessType: null,
        mainProduct: null,
        distributionChannel: null,
        majorCountryMarkets: null,
        salesYear: null,
        customerStarLevel: null,
        customerType: null,
        status: 0,
        note: null,
        creator: null,
        creatorId: null,
        createDate: null,
        modifiedUser: null,
        gmtModified: null
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
      this.form.status = 2;
      this.title = "添加国外客户";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCustomers(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改国外客户";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCustomers(this.form,'abroad').then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCustomers(this.form,'abroad').then(response => {
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
      this.$modal.confirm('是否确认删除客户集合编号为"' + ids + '"的数据项？').then(function () {
        return delCustomers(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('admin/customers/export', {
        ...this.queryParams
      }, `customers_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
