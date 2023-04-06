<template xmlns="http://www.w3.org/1999/html">
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="成品编码" prop="itemCode">
        <el-input
          v-model="queryParams.itemCode"
          placeholder="请输入成品编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="成品名称" prop="itemName">
        <el-input
          v-model="queryParams.itemName"
          placeholder="请输入成品名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="成品类别" prop="categoryType">
        <el-select v-model="queryParams.categoryType" placeholder="请选择">
          <el-option
            v-for="dict in dict.type.sys_product_category"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="成品类型" prop="productType">
        <el-select v-model="queryParams.productType" placeholder="请选择">
          <el-option
            v-for="dict in dict.type.sys_product_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          ></el-option>
        </el-select>
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
      <el-table-column label="产品编码" align="center" prop="itemCode"/>
<!--      <el-table-column label="产品编号" align="center" prop="itemNo"/>-->
      <el-table-column label="客户名称" align="center" prop="customerName" :show-overflow-tooltip="true"/>
      <el-table-column label="产品名称" align="center" prop="itemName" :show-overflow-tooltip="true"/>
      <el-table-column label="化妆品使用方法分类" align="center" prop="productUseMethods">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_product_use_methods" :value="scope.row.productUseMethods"/>
        </template>
      </el-table-column>
      <el-table-column label="产品类别" show-overflow-tooltip align="center" prop="categoryType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_product_category" :value="scope.row.categoryType"/>
        </template>
      </el-table-column>
      <el-table-column label="规格" align="center" prop="specifications"/>
      <el-table-column label="产品图片1" align="center" prop="imageUrl">
        <template slot-scope="scope">
          <img style="width:50px;height:50px;border:none; " :src="scope.row.imageUrl"
               @click="showImage(scope.row.imageUrl)">
        </template>
      </el-table-column>
      <el-table-column label="产品图片2" align="center" prop="imageUrl2" >
        <template slot-scope="scope">
          <img style="width:50px;height:50px;border:none; " :src="scope.row.imageUrl2"
               @click="showImage(scope.row.imageUrl2)">
        </template>
      </el-table-column>
      <el-table-column label="内包装图1" align="center" prop="innerImageUrl" >
        <template slot-scope="scope">
          <img style="width:50px;height:50px;border:none; " :src="scope.row.innerImageUrl"
               @click="showImage(scope.row.innerImageUrl)">
        </template>
      </el-table-column>
      <el-table-column label="内包装图2" align="center" prop="innerImageUrl2" >
        <template slot-scope="scope">
          <img style="width:50px;height:50px;border:none; " :src="scope.row.innerImageUrl2"
               @click="showImage(scope.row.innerImageUrl2)">
        </template>
      </el-table-column>
      <el-table-column label="品牌" align="center" prop="brand"/>
      <el-table-column label="单价" align="center" prop="price"/>
      <el-table-column label="单位" align="center" prop="unit"/>
      <el-table-column label="含量" align="center">
        <template slot-scope="scope">
          <el-button @click="getItemContentList(scope.row)" size="mini" type="text" icon="el-icon-tickets">
            含量
          </el-button>
        </template>
      </el-table-column>
<!--      <el-table-column label="仓库库存单位" align="center" prop="whStockUnit"/>-->
<!--      <el-table-column label="转换比例(物料->库存)" align="center" prop="discount"/>-->
<!--      <el-table-column label="毛重" align="center" prop="tareWeight"/>-->
<!--      <el-table-column label="皮重" align="center" prop="grossWeight"/>-->
<!--      <el-table-column label="净重" align="center" prop="netWeight"/>-->
<!--      <el-table-column label="密度(g/cm³)" align="center" prop="density"/>-->
      <el-table-column label="描述" align="center" prop="description" :show-overflow-tooltip="true" />
      <el-table-column label="净含量" align="center" prop="netContent" />
      <el-table-column label="条形码" align="center" prop="barCode"/>
      <el-table-column label="产品类型" align="center" prop="productType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_product_type" :value="scope.row.productType"/>
        </template>
      </el-table-column>
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

    <!-- 添加或修改产品对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="60%" append-to-body>
      <el-form ref="form" :model="form" :inline="true" :rules="rules" label-width="120px">
        <el-row>
        <el-form-item label="产品编码" prop="itemCode">
          <el-input v-model="form.itemCode" placeholder="请输入产品序号" disabled/>
        </el-form-item>
        <el-form-item label="产品编号" prop="itemNo">
          <el-input v-model="form.itemNo" placeholder="请输入产品编码" disabled/>
        </el-form-item>
        <el-form-item label="产品名称" prop="itemName">
          <el-input v-model="form.itemName" placeholder="请输入产品名称"/>
        </el-form-item>
        <el-form-item label="化妆品使用方法分类" prop="productUseMethods">
          <el-select v-model="form.productUseMethods" style="min-width: 100%" placeholder="请选择">
            <el-option
              v-for="dict in dict.type.sys_product_use_methods"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="产品类别" prop="categoryType">
          <el-select v-model="form.categoryType" style="min-width: 100%" placeholder="请选择">
            <el-option
              v-for="dict in dict.type.sys_product_category"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="客户" prop="customerId">
          <el-select v-model="form.customerId" style="min-width: 100%" filterable placeholder="请选择客户" size="small"
                     @change="customerId">
            <el-option
              v-for="item in cusOptions"
              :key="item.id"
              :label="item.customerName"
              :value="item.id"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="规格" prop="specifications">
          <el-input v-model="form.specifications" placeholder="请输入规格"/>
        </el-form-item>

        <el-form-item label="品牌" prop="brand">
          <el-input v-model="form.brand" placeholder="请输入品牌"/>
        </el-form-item>
        <el-form-item label="单价" prop="price">
          <el-input v-model="form.price" placeholder="请输入单价"/>
        </el-form-item>
        <el-form-item label="单位" prop="unit">
          <el-input v-model="form.unit" placeholder="请输入单位"/>
        </el-form-item>
        <el-form-item label="仓库库存单位" prop="whStockUnit">
          <el-input v-model="form.whStockUnit" placeholder="请输入仓库库存单位"/>
        </el-form-item>
<!--        <el-form-item label="转换比例(物料->库存)" prop="discount">-->
<!--          <el-input v-model="form.discount" placeholder="请输入转换比例(物料->库存)"/>-->
<!--        </el-form-item>-->
        <el-form-item label="毛重" prop="tareWeight">
          <el-input v-model="form.tareWeight" placeholder="请输入毛重"/>
        </el-form-item>
        <el-form-item label="皮重" prop="grossWeight">
          <el-input v-model="form.grossWeight" placeholder="请输入皮重"/>
        </el-form-item>
        <el-form-item label="净重" prop="netWeight">
          <el-input v-model="form.netWeight" placeholder="请输入皮重"/>
        </el-form-item>
<!--        <el-form-item label="密度(g/cm³)" prop="density">-->
<!--          <el-input-number :precision="3" v-model="form.density" placeholder="请输入密度(g/cm³)"/>-->
<!--        </el-form-item>-->
        <br>
        <el-form-item label="产品图片1" prop="specifications">
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
            :file-list="fileList"
            :on-error="fileError"
            :on-preview="handlePreview"
            :on-remove="deleteFile"
          >
            <el-button size="small" type="primary" @click="test(1)">点击上传</el-button>
          </el-upload>
        </el-form-item>

        <el-form-item label="产品图片2" prop="imageUrl2">
          <el-image
            class="avatar"
            style="width: 80px; height: 80px"
            :src="srcs"
            @click="showImage(srcs)"
          ></el-image>
          <el-upload
            style="height: 50px"
            class="upload-demo"
            :headers="thisToken"
            :limit="1"
            :action="fileUploadUrl"
            :on-success="fileSuccess"
            :file-list="fileList"
            :on-error="fileError"
            :on-preview="handlePreview"
            :on-remove="deleteFile"
          >
            <el-button size="small" type="primary" @click="test(2)">点击上传</el-button>
          </el-upload>
        </el-form-item>
        <el-form-item label="内包装图1" prop="innerImageUrl">
          <el-image
            class="avatar"
            style="width: 80px; height: 80px"
            :src="innersrc"
            @click="showImage(innersrc)"
          ></el-image>
          <el-upload
            style="height: 50px"
            class="upload-demo"
            :headers="thisToken"
            :limit="1"
            :action="fileUploadUrl"
            :on-success="fileSuccess"
            :file-list="fileList"
            :on-error="fileError"
            :on-preview="handlePreview"
            :on-remove="deleteFile"
          >
            <el-button size="small" type="primary" @click="test(3)">点击上传</el-button>
          </el-upload>
        </el-form-item>

        <el-form-item label="内包装图2" prop="innerImageUrl2">
          <el-image
            class="avatar"
            style="width: 80px; height: 80px"
            :src="innersrcs"
            @click="showImage(innersrcs)"
          ></el-image>
          <el-upload
            style="height: 50px"
            class="upload-demo"
            :headers="thisToken"
            :limit="1"
            :action="fileUploadUrl"
            :file-list="fileList"
            :on-success="fileSuccess"
            :on-error="fileError"
            :on-preview="handlePreview"
            :on-remove="deleteFile"
          >
            <el-button size="small" type="primary" @click="test(4)">点击上传</el-button>
          </el-upload>
        </el-form-item>
        <el-form-item label="描述" prop="description">
          <el-input v-model="form.description" placeholder="请输入描述" />
        </el-form-item>
<!--        <el-form-item label="净含量">-->
<!--          <el-input v-model="form.netContent" />-->
<!--        </el-form-item>-->
        <el-form-item label="条形码" prop="barCode">
          <el-input v-model="form.barCode" placeholder="请输入条形码"/>
        </el-form-item>
        <el-form-item label="产品类型" prop="productType">
          <el-select v-model="form.productType" placeholder="请选择">
            <el-option
              v-for="dict in dict.type.sys_product_type"
              :key="dict.value"
              :label="dict.label"
              :value="Number(dict.value)"
            />
          </el-select>
        </el-form-item>

        <el-form-item label="状态">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.sys_jotime_data_status"
              :key="dict.value"
              :label="Number(dict.value)"
            >{{ dict.label }}
            </el-radio>
          </el-radio-group>
        </el-form-item>
        </el-row>
        <div align="right">
          <el-button size="mini" type="primary" plain @click="addBaseItemContentRow">添加行</el-button>
        </div>
        <el-tabs v-model="activeName" @tab-click="tabsClick" type="border-card">
          <el-tab-pane label="物料含量详细" name="1">
            <div class="table">
              <el-table v-loading="loading" border :data="form.baseItemNetContents" :key="sss">
                <el-table-column label="内料配方编号" min-width="100%" align="center">
                  <template slot-scope="scope">
                    <el-select v-model="scope.row.bomNo" filterable style="width:92.6%" @change="changeData(scope)">
                      <el-option
                        v-for="item in bomNoList"
                        :key="item"
                        :label="item.bomNo"
                        :value="item">
                      </el-option>
                    </el-select>
                  </template>
                </el-table-column>
                <el-table-column label="套内物料" min-width="100%" align="center">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.innerItemId" align="center" disabled></el-input>
<!--                    <el-select v-model="scope.row.innerItemId" filterable style="width:92.6%" disabled>-->
<!--                    <el-option-->
<!--                      v-for="item in bomNoList"-->
<!--                      :key="item.innerItemId"-->
<!--                      :label="item.innerItemName"-->
<!--                      :value="item.innerItemId"-->
<!--                      >-->
<!--                    </el-option>-->
<!--                    </el-select>-->
                  </template>
                </el-table-column>
                <el-table-column label="版本号" min-width="100%" align="center">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.version" align="center"></el-input>
                  </template>
                </el-table-column>
                <el-table-column label="密度" min-width="100%" align="center">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.density" align="center" @blur="BlurText(scope.row)"></el-input>
                  </template>
                </el-table-column>
                <el-table-column label="净含量" min-width="100%" align="center">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.netContent" align="center" @blur="BlurText(scope.row)"></el-input>
                  </template>
                </el-table-column>
                <el-table-column label="净重" min-width="100%" align="center">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.netWeight" align="center" disabled></el-input>
                  </template>
                </el-table-column>
                <el-table-column label="产品数量" min-width="100%" align="center">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.productQty" align="center"></el-input>
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
<!--          <el-checkbox v-model="upload.updateSupport"/>-->
<!--          是否更新已经存在的数据（根据成品编码判断）-->
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
      <el-table :data="baseItemContentLists">
        <el-table-column align="center" min-width="100px" label="内料配方编号" prop="bomNo">
        </el-table-column>
        <el-table-column align="center" min-width="100px" label="套内物料内码" prop="innerItemId">
        </el-table-column>
        <el-table-column align="center" min-width="100px" label="版本号" prop="version">
        </el-table-column>
        <el-table-column align="center" min-width="100px" label="密度(g/cm³)" prop="density">
      </el-table-column>
        <el-table-column align="center" min-width="100px" label="净含量" prop="netContent">
        </el-table-column>
        <el-table-column align="center" min-width="100px" label="净重" prop="netWeight">
        </el-table-column>
        <el-table-column align="center" min-width="100px" label="产品数量" prop="productQty">
        </el-table-column>
      </el-table>
    </el-drawer>
    <el-image-viewer style="z-index: 3000 !important;" v-if="showViewer" :on-close="closeViewer"
                     :url-list="previewList"></el-image-viewer>
  </div>
</template>

<script>
import {
  listItem,
  getItem,
  delItem,
  addItem,
  editOther,
  ListCusOption,material,
  materiallist,getDistinctlist,cosmeticMateria, materialcode
} from "@/api/jotime/base/basics/item";
import {getToken} from "@/utils/auth";
import ElImageViewer from "element-ui/packages/image/src/image-viewer";
import FileUp from "@/components/FileUpload";
import {addManage} from "@/api/jotime/file/BaseFileManage";
import {listItemContent, listItemContents} from "@/api/jotime/base/basics/itemContent";
import {selectAllBaseBomdtl} from "@/api/jotime/base/bom/bomdtl"

export default {
  name: "Item",
  components: {ElImageViewer, FileUp},
  dicts: ['sys_brand_own','sys_product_use_methods', 'sys_jotime_data_status', 'sys_yes_no', 'sys_sales_type', 'sys_product_type', 'sys_product_category'],
  data() {
    return {
      sss:false,
      bomNoList: [],
      UUID: null,
      inciNameEnlist: [],
      //tabs默认选中
      activeName: '1',
      tabsName: '1',
      thisItemName: [],
      //物料含量表
      baseItemContentList: [],
      type: '',
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
      //物料含量表
      baseItemContentLists: [],
      //含量
      drawer: false,
      src: "",
      srcs: "",
      innersrc: "",
      innersrcs: "",
      // 总条数
      total: 0,
      // 产品表格数据
      itemList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      UUIDArr: [],
      fileUrlArr:[],
      supplierList: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        itemCode: null,
        itemNo: null,
        itemName: null,
        productUseMethods:null,
        inciName: null,
        casNo: null,
        itemShortName: null,
        itemSpecification: null,
        itemType: null,
        categoryType: null,
        customerItemCode: null,
        customerNameList: [],
        mItemType: null,
        sItemType: null,
        colourNumber: null,
        specifications: null,
        unit: null,
        whStockUnit: null,
        discount: null,
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
        imageUrl2: null,
        innerImageUrl: null,
        innerImageUrl2: null,
        description: null,
        netContent: null,
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
        pageName: "product",
        productType: null
      },
      // 表单参数
      form: {},
      //图片
      thisToken: {Authorization: "Bearer " + getToken()},
      fileUploadUrl: process.env.VUE_APP_BASE_API + "/oss/uploadFile?busType=E01",
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
        url: process.env.VUE_APP_BASE_API + "/web/base/item/importProductData",
      },
      previewList: [],
      showViewer: false,
      // 表单校验
      rules: {
        // itemNo: [
        //   {required: true, message: "产品编号不能为空", trigger: "blur"}
        // ],
        itemName: [
          {required: true, message: "产品名称不能为空", trigger: "blur"}
        ],
        itemType: [
          {required: true, message: "产品类型", trigger: "change"}
        ],
        customerId: [
          {required: true, message: "客户不能为空", trigger: "change"}
        ],
        status: [
          {required: true, message: "状态不能为空", trigger: "blur"}
        ],
        categoryType: [
          {required: true, message: "产品类别不能为空", trigger: "blur"}
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
    this.getCusOptions();
    materiallist().then( res =>{
      this.supplierList = res.rows
    });
  },

  methods: {
    changeData(scope){
      scope.row.innerItemId=scope.row.bomNo.innerItemId
      scope.row.bomNo=scope.row.bomNo.bomNo
      scope.row.innerItemName=scope.row.bomNo.innerItemName
      this.$forceUpdate()
      console.log(scope)
    },

    BlurText(row) {
      let a = 0
      if (row.netContent&&row.density){
        a = Number(row.netContent*row.density)
        row.netWeight=a;
      }else {
        row.netWeight=0;
      }
      this.$forceUpdate()
      this.sss =!this.sss
      return row.netWeight;
    },
    // 增加行
    addBaseItemContentRow() {
      if (this.tabsName === '1'){
        if (this.form.baseItemNetContents === undefined||this.form.baseItemNetContents === null){
          this.form.baseItemNetContents = []
          this.form.baseItemNetContents.push({innerItemId: null,bomNo: null,version: null});
          this.$forceUpdate()
        }else{
          this.form.baseItemNetContents.push({innerItemId: null,bomNo: null,version: null});
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
      this.form.baseItemNetContents.splice(index, 1);
    },
    delectbaseItemSupplierS(row, index) {
      this.form.baseItemSupplierS.splice(index, 1);
    },

    /** 查询客户列表 */
    getCusOptions() {
      ListCusOption().then(response => {
        this.cusOptions = response.data;
      });
    },
    customerId(id) {
      this.form.customerId = id;
    },
    /** 查询产品列表 */
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
      this.baseItemContentLists = [];
      this.form = {
        id: null,
        itemCode: null,
        itemNo: null,
        itemName: null,
        productUseMethods:null,
        inciName: null,
        casNo: null,
        itemShortName: null,
        itemSpecification: null,
        itemType: 6,
        categoryType: null,
        customerItemCode: null,
        mItemType: null,
        sItemType: null,
        colourNumber: null,
        specifications: null,
        unit: null,
        whStockUnit: null,
        discount: null,
        brand: null,
        brandOwn: null,
        price: null,
        cusOptions: null,
        tareWeight: null,
        grossWeight: null,
        netWeight: null,
        lineNetWeight: null,
        identificationNetWeight: null,
        fillingVolumeUpper: null,
        fillingVolumeLower: null,
        fillingUnit: null,
        imageUrl: null,
        density: null,
        percentage: null,
        barCode: null,
        imageUrl2: null,
        innerImageUrl: null,
        innerImageUrl2: null,
        description: null,
        netContent: null,
        customerId: null,
        cCode: null,
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
        status: 2,
        pageName: "product",
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        productType: null
      };
      this.queryParams.customerId = null
      this.resetForm("form");
    },
    // 文件类型type(1)=image_url type(2)=内包装图1 type(3)=内包装图2 type(4)=产品图
    test(type) {
      this.type = type
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
      this.src = require('@/assets/images/defaultFindPic.png');
      this.srcs = require('@/assets/images/defaultFindPic.png');
      this.innersrc = require('@/assets/images/defaultFindPic.png');
      this.innersrcs = require('@/assets/images/defaultFindPic.png');
      this.open = true;
      this.title = "添加产品";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      selectAllBaseBomdtl(id).then( res =>{
        this.bomNoList = res.data
      });
      material(id).then(response => {
        this.form = response.data;
        console.log(response.data);
        this.src = response.data.imageUrl;
        this.srcs = response.data.imageUrl2;
        this.innersrc = response.data.innerImageUrl;
        this.innersrcs = response.data.innerImageUrl2;
        this.open = true;
        this.title = "修改产品";
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
      this.$modal.confirm('是否确认删除产品编号为"' + ids + '"的数据项？').then(function () {
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
    showImage(imageUrl) {
      this.previewList.push(imageUrl);
      this.showViewer = true;
    },
    //预览图片点击事件
    closeViewer() {
      this.previewList.splice(0, this.previewList.length);
      this.showViewer = false;
    },
    //文件上传失败钩子
    fileError(err, file, fileList) {
      this.$modal.msgSuccess("文件上传失败，请联系管理员");
      console.log(err);
    },
    //文件上传成功钩子
    fileSuccess(response, file, fileList) {
      let UUID = Math.floor(Math.random() * 1000000)
      this.UUIDArr.push(UUID);
      let ossUrl = response.ossUrl;
      let filepath = response.filepath;
      this.fileUrlArr.push(filepath);
      //获取文件的名称
      let fileName = file.raw.name
      let fileType = file.raw.type
      let fileSize = file.raw.size
      let obj = {}
      obj.tableId = UUID
      obj.fileName = fileName
      obj.fileType = fileType
      obj.fileSize = fileSize
      obj.tableType = this.type
      // obj.title = '成品'
      obj.tableName = "baseItem";
      obj.fileUrl = ossUrl
      if (obj.tableType === 1) {
        obj.title = '产品图片image_url'
      } else if (obj.tableType === 2) {
        obj.title = 'image_url'
      } else if (obj.tableType === 3) {
        obj.title = '内包装图1'
      } else if (obj.tableType === 4) {
        obj.title = '内包装图2'
      }
      if (response.code === 1) {
        addManage(obj)
        if (obj.tableType === 1) {
          this.form.imageUrl = response.ossUrl;
          this.src = response.ossUrl;
        } else if (obj.tableType === 2) {
          this.form.imageUrl2 = response.ossUrl;
          this.src = response.ossUrl;
        } else if (obj.tableType === 3) {
          this.form.innerImageUrl = response.ossUrl;
          this.src = response.ossUrl;
        } else if (obj.tableType === 4) {
          this.form.innerImageUrl2 = response.ossUrl;
          this.src = response.ossUrl;
        }
        console.log(this.form.imageUrl)
        this.$modal.msgSuccess('文件上传成功')
      } else {
        // 实现缩略图模板时删除文件
        let index = fileList.findIndex(fileItem => {
          return fileItem.uid === file.uid
        })
        fileList.splice(index, 1)
        this.$modal.msgError(response.msg)
      }
    },
    //预览
    handlePreview(file) {
      console.log(file);
    },
    getItemContentList(row) {
      this.thisItemName = row.itemName;
      this.reset();
      listItemContents(row.id).then(res => {
        this.baseItemContentLists = res.data;
        console.log(this.baseItemContentLists);
      });

      this.drawer = true
    },
    /**删除上传文件*/
    deleteFile() {
      this.form.imageUrl = " ";
      if (obj.tableType === 1) {
        this.form.imageUrl = " ";
      } else if (obj.tableType === 2) {
        this.form.imageUrl2 = " ";
      } else if (obj.tableType === 3) {
        this.form.innerImageUrl = " ";
      } else if (obj.tableType === 4) {
        this.form.innerImageUrl2 = " ";
      }
      this.$modal.msgSuccess("文件删除成功");
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "成品信息导入";
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
      this.download('web/base/item/importProductTemplate', {}, `item_product_${new Date().getTime()}.xlsx`)
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
//::v-deep .el-form-item{
//  margin-bottom: 0;
//}
</style>
