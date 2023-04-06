<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="110px">
      <el-form-item label="备用原料编码" prop="itemCode">
        <el-input
          v-model="queryParams.itemCode"
          placeholder="请输入备用原料编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备用原料名称" prop="itemName">
        <el-input
          v-model="queryParams.itemName"
          placeholder="请输入备用原料名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="原料类别" prop="categoryType">-->
<!--        <el-select v-model="queryParams.categoryType" clearable placeholder="请选择">-->
<!--          <el-option-->
<!--            v-for="dict in dict.type.sys_material_category"-->
<!--            :key="dict.value"-->
<!--            :label="dict.label"-->
<!--            :value="dict.value"-->
<!--          ></el-option>-->
<!--        </el-select>-->
<!--      </el-form-item>-->
      <el-form-item label="条形码" prop="barCode">
        <el-input
          v-model="queryParams.barCode"
          placeholder="请输入条形码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客户名称" prop="customerId">
        <el-select v-model="queryParams.customerId" clearable filterable placeholder="请选择" size="small">
          <el-option
            v-for="item in cusOptions"
            :key="item.id"
            :label="item.customerName"
            :value="item.id"
          />
        </el-select>
      </el-form-item>
      <!--      <el-form-item label="原料属性" prop="property">-->
      <!--        <el-select v-model="queryParams.property" clearable placeholder="请选择">-->
      <!--          <el-option-->
      <!--            v-for="dict in dict.type.sys_material_property "-->
      <!--            :key="dict.value"-->
      <!--            :label="dict.label"-->
      <!--            :value="dict.value"-->
      <!--          ></el-option>-->
      <!--        </el-select>-->
      <!--      </el-form-item>-->
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
      <el-form-item label="生产商" prop="manufacturerId">
        <el-select v-model="queryParams.manufacturerId" clearable filterable placeholder="请选择" size="small">
          <el-option
            v-for="item in manufacturerList"
            :key="item.id"
            :label="item.mfrsName"
            :value="item.id"
          />
        </el-select>
      </el-form-item>
<!--      <el-form-item label="控制原料" prop="needConfidential">-->
<!--        <el-select v-model="queryParams.needConfidential" placeholder="请选择">-->
<!--          <el-option-->
<!--            v-for="dict in dict.type.sys_yes_no"-->
<!--            :key="dict.value"-->
<!--            :label="dict.label"-->
<!--            :value="dict.value"-->
<!--          ></el-option>-->
<!--        </el-select>-->
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
      <!--      <el-col :span="1.5">-->
      <!--        <el-button-->
      <!--          type="warning"-->
      <!--          plain-->
      <!--          icon="el-icon-download"-->
      <!--          size="mini"-->
      <!--          @click="handleExport"-->
      <!--          v-hasPermi="['base:item:export']"-->
      <!--        >导出-->
      <!--        </el-button>-->
      <!--      </el-col>-->
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="itemList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="原料编码" align="center" prop="itemCode"/>
      <el-table-column label="原料商品名称" min-width="150%" align="center" prop="itemName" :show-overflow-tooltip="true"/>
<!--      <el-table-column label="原料标准名称" min-width="150%" align="center" prop="itemShortName"-->
                       :show-overflow-tooltip="true"/>
      <!--      <el-table-column label="INCI" min-width="150%" align="center" prop="inciName" :show-overflow-tooltip="true"/>-->
      <el-table-column label="含量" align="center">
        <template slot-scope="scope">
          <el-button @click="getItemContentList(scope.row)" size="mini" type="text" icon="el-icon-tickets">
            含量
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="原料属性" align="center" prop="property"/>
      <el-table-column label="制造厂商" min-width="150%" :show-overflow-tooltip="true" align="center"
                       prop="manufacturerName"/>
      <el-table-column label="原料报送码" align="center" prop="submissionCode"/>
      <el-table-column label="报送状态" align="center" prop="submissionCodeSts">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_submission_code_sts" :value="scope.row.submissionCodeSts"/>
        </template>
      </el-table-column>
      <el-table-column label="产地" align="center" prop="placeOrigin"/>

      <el-table-column label="储存条件" align="center" prop="storageCondition"/>
      <el-table-column label="紧急处理" align="center" prop="firstAid"/>
      <el-table-column label="引入日期" align="center" prop="introductionDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.introductionDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="熔点" align="center" prop="meltingPoint"/>
      <el-table-column label="粒径（µm）" align="center" prop="particleSize"/>
      <el-table-column label="常规包装" align="center" prop="conventionalPacking"/>
      <el-table-column label="价格" align="center" prop="price"/>
      <el-table-column label="非动物检测证明" align="center" prop="nonAnimalTest">
        <template slot-scope="scope">
          <el-button @click="downloadS(scope.row.nonAnimalTest,14)" size="mini" type="text" icon="el-icon-tickets">
            下载
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="过敏源信息" align="center" prop="allergenInfo">
        <template slot-scope="scope">
          <el-button @click="downloadS(scope.row.allergenInfo,6)" size="mini" type="text" icon="el-icon-tickets">
            下载
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="IFRA证明文件" align="center" prop="ifraFile">
        <template slot-scope="scope">
          <el-button @click="downloadS(scope.row.ifraFile,7)" size="mini" type="text" icon="el-icon-tickets">
            下载
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="其他资料" align="center" prop="otherFile">
        <template slot-scope="scope">
          <el-button @click="downloadS(scope.row.otherFile,8)" size="mini" type="text" icon="el-icon-tickets">
            下载
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="公司内部原料标准" align="center" prop="companyStandards">
        <template slot-scope="scope">
          <el-button @click="downloadS(scope.row.companyStandards,9)" size="mini" type="text" icon="el-icon-tickets">
            下载
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="MSDS" align="center" prop="msds">
        <template slot-scope="scope">
          <el-button @click="downloadS(scope.row.msds,10)" size="mini" type="text" icon="el-icon-tickets">
            下载
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="SPEC/COA" align="center" prop="coa">
        <template slot-scope="scope">
          <el-button @click="downloadS(scope.row.coa,11)" size="mini" type="text" icon="el-icon-tickets">
            下载
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="TDS" align="center" prop="tds">
        <template slot-scope="scope">
          <el-button @click="downloadS(scope.row.tds,12)" size="mini" type="text" icon="el-icon-tickets">
            下载
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="原料附件14" align="center" prop="attachmentUrl14">
        <template slot-scope="scope">
          <el-button @click="downloadS(scope.row.attachmentUrl14,13)" size="mini" type="text" icon="el-icon-tickets">
            下载
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="REACH号" align="center" prop="reachNo"/>
      <el-table-column label="来源" align="center" prop="origin"/>
      <el-table-column label="备注" align="center" prop="note"/>
      <!--      <el-table-column label="原料属性" align="center" prop="property">-->
      <!--        <template slot-scope="scope">-->
      <!--          <dict-tag :options="dict.type.sys_material_property" :value="scope.row.property"/>-->
      <!--        </template>-->
      <!--      </el-table-column>-->
<!--      <el-table-column label="原料类别" show-overflow-tooltip align="center" prop="categoryType">-->
<!--        <template slot-scope="scope">-->
<!--          <dict-tag :options="dict.type.sys_material_category" :value="scope.row.categoryType"/>-->
<!--        </template>-->
<!--      </el-table-column>-->
      <el-table-column label="规格" align="center" prop="specifications"/>
      <el-table-column label="原料图片" align="center" prop="imageUrl">
        <template slot-scope="scope">
          <img style="width:50px;height:50px;border:none; " :src="scope.row.imageUrl"
               @click="showImage(scope.row.imageUrl)">
        </template>
      </el-table-column>
      <el-table-column label="供应商" align="center" prop="supplierName"/>
      <el-table-column label="成品客户" align="center" prop="customerName"/>
      <el-table-column label="原料品牌" align="center" prop="brand"/>
<!--      <el-table-column label="含量" align="center" prop="content"/>-->
      <el-table-column label="引入条件" align="center" prop="introductionConditions"/>
      <el-table-column label="有效期" align="center" prop="effectiveDay"/>
      <el-table-column label="单位" align="center" prop="unit"/>
      <el-table-column label="仓库库存单位" align="center" prop="whStockUnit"/>
      <el-table-column label="转换比例(物料->库存)" align="center" prop="discount"/>
<!--      <el-table-column label="品牌所属" align="center" prop="brandOwn">-->
<!--        <template slot-scope="scope">-->
<!--          <dict-tag :options="dict.type.sys_brand_own" :value="scope.row.brandOwn"/>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--      &lt;!&ndash;      <el-table-column label="图片/附件" align="center" prop="imageUrl">&ndash;&gt;-->
<!--      &lt;!&ndash;        <template slot-scope="scope">&ndash;&gt;-->
<!--      &lt;!&ndash;          <img  style="width:50px;height:50px;border:none; " :src="scope.row.imageUrl" @click="showImage(scope.row.imageUrl)">&ndash;&gt;-->
<!--      &lt;!&ndash;        </template>&ndash;&gt;-->
<!--      &lt;!&ndash;        <el-image-viewer v-if="showViewer" :on-close="closeViewer" :url-list="previewList"></el-image-viewer>&ndash;&gt;-->
<!--      &lt;!&ndash;      </el-table-column>&ndash;&gt;-->
<!--      <el-table-column label="条形码" align="center" prop="barCode"/>-->
<!--      <el-table-column label="客户物料编码" align="center" prop="customerItemCode"/>-->
<!--      <el-table-column label="预警上限阈值" align="center" prop="warnToplimit"/>-->
<!--      <el-table-column label="预警下限阈值" align="center" prop="warnLowerlimit"/>-->


<!--      <el-table-column label="俗称" align="center" prop="vulgo"/>-->
<!--        <template slot-scope="scope">-->
<!--          <el-button @click="fileUploadA(scope.row,6)" size="mini" type="text" icon="el-icon-tickets">-->
<!--            上传-->
<!--          </el-button>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--      <el-table-column label="是否质检" align="center" prop="needQuality">-->
<!--        <template slot-scope="scope">-->
<!--          <dict-tag :options="dict.type.sys_yes_no" :value="scope.row.needQuality"/>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--      <el-table-column label="是否称重" align="center" prop="needWeigh">-->
<!--        <template slot-scope="scope">-->
<!--          <dict-tag :options="dict.type.sys_yes_no" :value="scope.row.needWeigh"/>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--      <el-table-column label="是否控制原料" align="center" prop="needConfidential">-->
<!--        <template slot-scope="scope">-->
<!--          <dict-tag :options="dict.type.sys_yes_no" :value="scope.row.needConfidential"/>-->
<!--        </template>-->
<!--      </el-table-column>-->
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_jotime_data_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" fixed="right">
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
    <el-dialog :title="title" ref="upload" :visible.sync="fileUpload" width="400px" append-to-body>
      <el-upload
        class="upload-demo"
        :headers="thisToken"
        drag
        multiple
        :action="fileUploadUrl"
        :on-success="updateFileSuccess"
        :on-error="fileError"
        :file-list="fileList"
        :on-remove="fileRemove"
        :on-preview="filePreview"
      >
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip" slot="tip">上传文件大小不能超过20mb</div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancel" type="primary">确 定</el-button>
        <el-button @click="cancel" type="danger">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 添加或修改原料对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="70%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="110px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="原料编码" prop="itemCode">
              <el-input v-model="form.itemCode"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="原料商品名称" prop="itemName">
              <el-input v-model="form.itemName" placeholder="请输入原料商品名称"/>
            </el-form-item>
          </el-col>
<!--          <el-col :span="12">-->
<!--            <el-form-item label="原料标准名称" prop="itemShortName">-->
<!--              <el-input v-model="form.itemShortName" placeholder="请输入料标准名称"/>-->
<!--            </el-form-item>-->
<!--          </el-col>-->
<!--          <el-col :span="12">-->
<!--            <el-form-item label="INCI" prop="inciName">-->
<!--              <el-input v-model="form.inciName" placeholder="请输入国际通用名称"/>-->
<!--            </el-form-item>-->
<!--          </el-col>-->
          <el-col :span="12">
            <el-form-item label="生产商" prop="manufacturerName">
              <el-select v-model="form.manufacturerId" style="min-width: 100%" filterable placeholder="请选择生产商"
                         size="small" @change="mfrsId">
                <el-option
                  v-for="item in manufacturerList"
                  :key="item.id"
                  :label="item.mfrsName"
                  :value="item.id"
                />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="原料报送码" prop="submissionCode">
              <el-input v-model="form.submissionCode" placeholder="请输入原料报送码"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="报送状态" prop="submissionCodeSts">
              <el-radio-group v-model="form.submissionCodeSts" @change="submissionCodeStschange()">
                <el-radio label="N">未报送</el-radio>
                <el-radio label="S">报送中</el-radio>
                <el-radio label="C">完成</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="原料属性" prop="property">
              <el-input v-model="form.property" placeholder="请输入原料属性"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="原产地" prop="placeOrigin">
              <el-input v-model="form.placeOrigin" placeholder="请输入原产地"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="非动物检测证明" prop="nonAnimalTest">
              <el-upload
                style="height: 50px"
                class="upload-demo"
                :headers="thisToken"
                :action="fileUploadUrl"
                :on-success="updateFileSuccess"
                :on-error="fileError"
                :on-preview="handlePreview"
                :on-remove="deleteFile"

              >
                <el-button size="small" type="primary" @click="tableTypes(14)">点击上传</el-button>
              </el-upload>

            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="过敏源信息" prop="allergenInfo">
              <el-upload
                style="height: 50px"
                class="upload-demo"
                :headers="thisToken"
                :action="fileUploadUrl"
                :on-success="updateFileSuccess"
                :on-error="fileError"
                :on-preview="handlePreview"
                :on-remove="deleteFile"

              >
                <el-button size="small" type="primary" @click="tableTypes(6)">点击上传</el-button>
              </el-upload>

            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="IFRA证明文件" prop="ifraFile">
              <el-upload
                style="height: 50px"
                class="upload-demo"
                :headers="thisToken"
                :action="fileUploadUrl"
                :on-success="updateFileSuccess"
                :on-error="fileError"
                :on-preview="handlePreview"
                :on-remove="deleteFile"

              >
                <el-button size="small" type="primary" @click="tableTypes(7)">点击上传</el-button>
              </el-upload>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="其他资料" prop="otherFile">
              <el-upload
                style="height: 50px"
                class="upload-demo"
                :headers="thisToken"
                :action="fileUploadUrl"
                :on-success="updateFileSuccess"
                :on-error="fileError"
                :on-preview="handlePreview"
                :on-remove="deleteFile"

              >
                <el-button size="small" type="primary" @click="tableTypes(8)">点击上传</el-button>
              </el-upload>

            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="公司内部原料标准" prop="companyStandards">
              <el-upload
                style="height: 50px"
                class="upload-demo"
                :headers="thisToken"
                :action="fileUploadUrl"
                :on-success="updateFileSuccess"
                :on-error="fileError"
                :on-preview="handlePreview"
                :on-remove="deleteFile"

              >
                <el-button size="small" type="primary" @click="tableTypes(9)">点击上传</el-button>
              </el-upload>

            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="MSDS" prop="msds">
              <el-upload
                style="height: 50px"
                class="upload-demo"
                :headers="thisToken"
                :action="fileUploadUrl"
                :on-success="updateFileSuccess"
                :on-error="fileError"
                :on-preview="handlePreview"
                :on-remove="deleteFile"

              >
                <el-button size="small" type="primary" @click="tableTypes(10)">点击上传</el-button>
              </el-upload>

            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="SPEC/COA" prop="coa">
              <el-upload
                style="height: 50px"
                class="upload-demo"
                :headers="thisToken"
                :action="fileUploadUrl"
                :on-success="updateFileSuccess"
                :on-error="fileError"
                :on-preview="handlePreview"
                :on-remove="deleteFile"

              >
                <el-button size="small" type="primary" @click="tableTypes(11)">点击上传</el-button>
              </el-upload>

            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="TDS" prop="tds">
              <el-upload
                style="height: 50px"
                class="upload-demo"
                :headers="thisToken"
                :action="fileUploadUrl"
                :on-success="updateFileSuccess"
                :on-error="fileError"
                :on-preview="handlePreview"
                :on-remove="deleteFile"

              >
                <el-button size="small" type="primary" @click="tableTypes(12)">点击上传</el-button>
              </el-upload>

            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="原料附件14" prop="attachmentUrl14">
              <el-upload
                style="height: 50px"
                class="upload-demo"
                :headers="thisToken"
                :action="fileUploadUrl"
                :on-success="updateFileSuccess"
                :on-error="fileError"
                :on-preview="handlePreview"
                :on-remove="deleteFile"

              >
                <el-button size="small" type="primary" @click="tableTypes(13)">点击上传</el-button>
              </el-upload>

            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="储存条件" prop="storageCondition">
              <el-input v-model="form.storageCondition" maxlength="500" show-word-limit type="textarea"
                        placeholder="请输入内容"/>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="紧急处理" prop="firstAid">
              <el-input v-model="form.firstAid" maxlength="500" show-word-limit type="textarea"
                        placeholder="请输入引入条件"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="引入日期" prop="introductionDate">
              <el-date-picker clearable size="small" style="min-width: 100%"
                              v-model="form.introductionDate"
                              type="date"
                              value-format="yyyy-MM-dd"
                              placeholder="选择引入日期">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="熔点" prop="meltingPoint">
              <el-input v-model="form.meltingPoint" placeholder="请输入熔点"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="粒径（µm）" prop="particleSize">
              <el-input v-model="form.particleSize" placeholder="请输入粒径（µm）"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="常规包装" prop="conventionalPacking">
              <el-input v-model="form.conventionalPacking" placeholder="请输入常规包装"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价格" prop="price">
              <el-input v-model="form.price" placeholder="请输入单价"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="非动物检测证明" prop="nonAnimalTest">
              <el-input v-model="form.nonAnimalTest" placeholder=""/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="REACH号" prop="reachNo">
              <el-input v-model="form.reachNo" placeholder="请输入REACH号"/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="来源" prop="origin">
              <el-input v-model="form.origin" placeholder="请输入来源"/>
            </el-form-item>
          </el-col>

          <el-col :span="16">
            <el-form-item label="备注" prop="note">
              <el-input v-model="form.note" type="textarea" maxlength="500" show-word-limit placeholder="请输入内容"/>
            </el-form-item>
          </el-col>
          <!--          <el-col :span="12">-->
          <!--            <el-form-item label="原料属性" prop="property" >-->
          <!--              <el-select v-model="form.property" style="min-width: 100%" placeholder="请选择">-->
          <!--                <el-option-->
          <!--                  v-for="dict in dict.type.sys_material_property"-->
          <!--                  :key="dict.value"-->
          <!--                  :label="dict.label"-->
          <!--                  :value="Number(dict.value)"-->
          <!--                ></el-option>-->
          <!--              </el-select>-->
          <!--            </el-form-item>-->
          <!--          </el-col>-->
<!--          <el-col :span="12">-->
<!--            <el-form-item label="原料类别" prop="categoryType">-->
<!--              <el-select v-model="form.categoryType" style="min-width: 100%" placeholder="请选择">-->
<!--                <el-option-->
<!--                  v-for="dict in dict.type.sys_material_category"-->
<!--                  :key="dict.value"-->
<!--                  :label="dict.label"-->
<!--                  :value="dict.value"-->
<!--                ></el-option>-->
<!--              </el-select>-->
<!--            </el-form-item>-->
<!--          </el-col>-->
          <el-col :span="12">
            <el-form-item label="原料规格" prop="specifications">
              <el-input v-model="form.specifications" placeholder="请输入原料规格"/>
            </el-form-item>
          </el-col>


<!--          <el-col :span="12">-->
<!--            <el-form-item label="供应商" prop="supplierName">-->
<!--              <el-select v-model="form.supplierId" style="min-width: 100%" filterable placeholder="请选择供应商" size="small"-->
<!--                         @change="supplierId">-->
<!--                <el-option-->
<!--                  v-for="item in supplierName"-->
<!--                  :key="item.id"-->
<!--                  :label="item.supplierName"-->
<!--                  :value="item.id"-->
<!--                />-->
<!--              </el-select>-->
<!--            </el-form-item>-->
<!--          </el-col>-->
          <el-col :span="12">
            <el-form-item label="客户" prop="customerName">
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
          </el-col>
          <el-col :span="12">
            <el-form-item label="品牌" prop="brand">
              <el-input v-model="form.brand" placeholder="请输入品牌"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="引入条件" prop="introductionConditions">
              <el-input v-model="form.introductionConditions" placeholder="请输入引入条件"/>
            </el-form-item>
          </el-col>
          <!--          <el-col :span="12">-->
          <!--            <el-form-item label="含量">-->
          <!--              <el-input v-model="form.content" placeholder="请输入含量"/>-->
          <!--            </el-form-item>-->
          <!--          </el-col>-->
          <el-col :span="12">
            <el-form-item label="有效月数" prop="effectiveDay">
              <!--              <el-input v-model="form.effectiveDay" placeholder="请输入有效天数"/>-->
              <el-input-number v-model="form.effectiveDay" style="min-width: 100%" :min="0"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="单位" prop="unit">
              <el-input v-model="form.unit" placeholder="请输入单位"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="仓库库存单位" prop="whStockUnit">
              <el-input v-model="form.whStockUnit" placeholder="请输入仓库库存单位"/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="品牌所属" prop="brandOwn">
              <el-select v-model="form.brandOwn" style="min-width: 100%" placeholder="请选择">
                <el-option
                  v-for="dict in dict.type.sys_brand_own"
                  :key="dict.value"
                  :label="dict.label"
                  :value="Number(dict.value)"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="条形码" prop="barCode">
              <el-input v-model="form.barCode" placeholder="请输入条形码"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="预警上限阈值" prop="warnToplimit">
              <el-input v-model="form.warnToplimit" placeholder="请输入预警上限阈值"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="预警下限阈值" prop="warnLowerlimit">
              <el-input v-model="form.warnLowerlimit" placeholder="请输入预警下限阈值"/>
            </el-form-item>
          </el-col>

<!--          <el-col :span="6">-->
<!--            <el-form-item label="是否质检" prop="needQuality">-->
<!--              <el-radio-group style="min-width: 100%" v-model="form.needQuality">-->
<!--                <el-radio-->
<!--                  v-for="dict in dict.type.sys_yes_no"-->
<!--                  :key="dict.value"-->
<!--                  :label="Number(dict.value)"-->
<!--                >{{ dict.label }}-->
<!--                </el-radio>-->
<!--              </el-radio-group>-->
<!--            </el-form-item>-->
<!--          </el-col>-->
<!--          <el-col :span="6">-->
<!--            <el-form-item label="是否称重" prop="needWeigh">-->
<!--              <el-radio-group style="min-width: 100%" v-model="form.needWeigh">-->
<!--                <el-radio-->
<!--                  v-for="dict in dict.type.sys_yes_no"-->
<!--                  :key="dict.value"-->
<!--                  :label="Number(dict.value)"-->
<!--                >{{ dict.label }}-->
<!--                </el-radio>-->
<!--              </el-radio-group>-->
<!--            </el-form-item>-->
<!--          </el-col>-->
<!--          <el-col :span="6">-->
<!--            <el-form-item label="是否控制原料" prop="needConfidential">-->
<!--              <el-radio-group style="min-width: 100%" v-model="form.needConfidential">-->
<!--                <el-radio-->
<!--                  v-for="dict in dict.type.sys_yes_no"-->
<!--                  :key="dict.value"-->
<!--                  :label="Number(dict.value)"-->
<!--                >{{ dict.label }}-->
<!--                </el-radio>-->
<!--              </el-radio-group>-->
<!--            </el-form-item>-->
<!--          </el-col>-->
<!--          -->
          <el-col :span="12">
            <el-form-item label="客户物料编码" prop="customerItemCode">
              <el-input v-model="form.customerItemCode" placeholder="请输入客户原料编码"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="俗称" prop="vulgo">
              <el-input v-model="form.vulgo" placeholder="请输入俗称"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
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
          </el-col>
<!--          <el-col :span="12">-->
<!--            <el-form-item label="MSDS" prop="msds">-->
<!--              <el-input v-model="form.msds" placeholder="请输入MSDS"/>-->
<!--            </el-form-item>-->
<!--          </el-col>-->
<!--          <el-col :span="12">-->
<!--            <el-form-item label="SPEC/COA" prop="coa">-->
<!--              <el-input v-model="form.coa" placeholder="请输入SPEC/COA"/>-->
<!--            </el-form-item>-->
<!--          </el-col>-->
<!--          <el-col :span="12">-->
<!--            <el-form-item label="TDS" prop="tds">-->
<!--              <el-input v-model="form.tds" placeholder="请输入TDS"/>-->
<!--            </el-form-item>-->
<!--          </el-col>-->
          <el-col :span="12">
            <el-form-item label="原料图片" prop="imageUrl">
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
<!--                    <el-input v-model="scope.row.inciNameEn" align="center"></el-input>-->
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
          <!--          <el-checkbox v-model="upload.updateSupport"/>-->
          <!--          是否更新已经存在的数据（根据原料编码判断）-->
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
    <el-image-viewer style="z-index: 3000 !important;" v-if="showViewer" :on-close="closeViewer"
                     :url-list="previewList"></el-image-viewer>
  </div>
</template>

<script>

import {
  listItem,
  getItem,
  getItemContent,
  delItem,
  addItem,
  updateItem,
  ListCusOption,
  ListSuppliers,
  selectMfrsName,
  updateItemContent,
  material,
  setmaterial,
  materiallist, materialcode, cosmeticMateria
} from "@/api/jotime/base/basics/item";
import {getToken} from "@/utils/auth";
import ElImageViewer from "element-ui/packages/image/src/image-viewer";
import {addManage, listManage, updateFileManage} from "@/api/jotime/file/BaseFileManage";
import FileUp from "@/components/FileUpload";
import {listItemContent} from "@/api/jotime/base/basics/itemContent";

export default {
  name: "Item",
  components: {ElImageViewer, FileUp},
  dicts: ['sys_submission_code_sts','sys_brand_own', 'sys_yes_no', 'sys_jotime_data_status', 'sys_sales_type', 'sys_product_type', 'sys_material_property', 'sys_material_category'],
  data() {
    return {
      UUID: null,
      inciNameEnlist: [],
      //tabs默认选中
      activeName: '1',
      tabsName: '1',
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      //含量
      drawer: false,
      src: "",
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 原料表格数据
      itemList: [],
      //文件上传弹框
      fileUpload: false,
      thisItemName: [],
      //物料含量表
      baseItemContentList: [],
      //后端获取的数据
      restaurants: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      previewList: [],
      supplierList: [],
      showViewer: false,
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
        manufacturerName: null,
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
        effectiveDay: null,
        needQuality: null,
        needBarcodeStockout: null,
        needWeigh: null,
        needConfidential: null,
        status: null,
        pageName: "temporaryMaterial",
        productType: null,
        firstAid: null
      },
      // 表单参数
      form: {},
      tableType: '',
      fileList: [],
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
        url: process.env.VUE_APP_BASE_API + "/web/base/item/importMaterialData",
      },
      thisToken: {Authorization: "Bearer " + getToken()},
      fileUploadUrl: process.env.VUE_APP_BASE_API + "/oss/uploadFile?busType=E01",
      // 表单校验
      rules: {
        // itemNo: [
        //   {required: true, message: "原料编号不能为空", trigger: "blur"}
        // ],
        itemName: [
          {required: true, message: "原料名称不能为空", trigger: "blur"}
        ],
        itemType: [
          {required: true, message: "原料类型", trigger: "change"}
        ],
        status: [
          {required: true, message: "状态不能为空", trigger: "blur"}
        ],
        property: [
          {required: true, message: "原料属性不能为空", trigger: "blur"}
        ],
        // categoryType: [
        //   {required: true, message: "原料类别不能为空", trigger: "blur"}
        // ],
        updateBy: [
          {required: true, message: "更新时间不能为空", trigger: "blur"}
        ],
        updateTime: [
          {required: true, message: "更新者不能为空", trigger: "blur"}
        ],
      },
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
  mounted() {
    this.loadMfrsName();
  },
  methods: {
    submissionCodeStschange(){
      let json = this.rules;
      if (this.form.submissionCodeSts == 'C') {
        json['submissionCode'] = [{required: true, message: "报产编码为空", trigger: "blur"}]
      }else{
        delete  json['submissionCode'];
      }
      this.rules = json;
    },
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
    //tabs切换
    tabsClick(tab,even){
      this.tabsName = tab.name
    },
    /**模糊查询*/
    loadMfrsName() {
      let that = this;
      selectMfrsName()
        .then(function (res) {
          if (res.code === 200) {
            that.manufacturerList = res.value;
          } else {
            // 失败的提示
            that.$message.error(res.msg);
          }
        })
        .catch(function (err) {
          console.log(err);
        });
    },
    customerId(id) {
      this.form.customerId = id;
    },
    supplierId(id) {
      this.form.supplierId = id;
    },
    mfrsId(id) {
      this.form.manufacturerId = id;
    },
    /** 查询原料列表 */
    getList() {
      this.loading = true;
      listItem(this.queryParams).then(response => {
        this.itemList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
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
    getItemContentList(row) {
      this.thisItemName = '原料标准名称：' + row.itemName;
      this.reset();
      listItemContent({itemId: row.id}).then(res => {
        this.baseItemContentList = res.rows;
        console.log(this.baseItemContentList);
      });
      this.drawer = true
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.fileUpload = false;
      this.reset();
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
        itemType: 1,
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
        msds: null,
        coa: null,
        tds: null,
        nonAnimalTest: null,
        submissionCode: null,
        reachNo: null,
        origin: null,
        brandOwn: null,
        price: null,
        lineNetWeight: null,
        identificationNetWeight: null,
        fillingVolumeUpper: null,
        fillingVolumeLower: null,
        fillingUnit: null,
        imageUrl: "null",
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
        effectiveDay: null,
        needQuality: 2,
        needBarcodeStockout: 1,
        needWeigh: 2,
        needConfidential: 1,
        status: 2,
        vulgo: null,
        meltingPoint: null,
        particleSize: null,
        conventionalPacking: null,
        // 客户列表
        cusOptions: null,
        //供应商列表
        supplierName: null,
        manufacturerList: null,
        pageName: 'temporaryMaterial',
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        productType: null,
        firstAid: null
      };
      //修改后初始客户 供应商 生产商值
      this.queryParams.customerId = null
      this.queryParams.supplierId = null
      this.queryParams.manufacturerId = null
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
      let UUID = Math.floor(Math.random() * 1000000)
      this.UUID = UUID
      this.src = require('@/assets/images/defaultFindPic.png');
      this.open = true;
      this.title = "添加原料";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      this.UUID = id
      material(id).then(response => {
        this.form = response.data;
        this.src = response.data.imageUrl;
        //把有效天数转成月数
        this.form.effectiveDay = this.form.effectiveDay != null && this.form.effectiveDay >= 30 ? this.form.effectiveDay / 30 : 0;
        this.open = true;
        this.title = "修改原料";
      });
      // 获取物料含量
      // getItemContent({itemId: row.id || this.ids[0]}).then(res => {
      //   this.baseItemContentList = res.rows;
      // });
    },
    /** 提交按钮 */
    submitForm() {
      // this.form.baseItemContents = this.baseItemContentList;
      //把有效月数转成天数
      // this.form.effectiveDay = this.form.effectiveDay!=null&&this.form.effectiveDay>=1?this.form.effectiveDay*30:0;
      // console.log(this.form.baseItemContents);
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            //更新物料主表
            this.form.uuid = this.UUID
            setmaterial(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              //  更新物料含量表
              // updateItemContent(this.form.baseItemContents, this.form.id).then(res => {
              //   this.$modal.msgSuccess("修改成功");
              //   this.open = false;
              //   this.getList();
              // });
            });
          } else {
            setmaterial(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除原料编号为"' + ids + '"的数据项？').then(function () {
        return delItem(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('base/item/export', {
        ...this.queryParams
      }, `item_${new Date().getTime()}.xlsx`)
    },

    /**删除上传文件*/
    deleteFile() {
      this.form.imageUrl = " ";
      this.$modal.msgSuccess("文件删除成功");
    },
    closeViewer() {
      this.previewList.splice(0, this.previewList.length);
      this.showViewer = false;
    },
    //图片点击事件
    showImage(imageUrl) {
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
    //图片文件上传成功钩子
    fileSuccess(response, file, fileList) {
      if (response.code === 1) {
        this.form.imageUrl = response.ossUrl;
        this.src = response.ossUrl;
        this.$modal.msgSuccess('文件上传成功')
      } else {
        this.$modal.msgError('文件上传失败')
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
    // 获取表格选中时的数据
    // selectRow(val) {
    //   //选中的数据提交到缺料补料详细表
    //   this.form.baseopenlinedtl=val;
    // },
    // 删除单行
    delectBaseItemContentRowData(row, index) {
      this.form.baseItemContents.splice(index, 1);
    },
    delectbaseItemSupplierS(row, index) {
      this.form.baseItemSupplierS.splice(index, 1);
    },

    //打开上传文件控件方法
    // fileUploadA(row, type) {
    fileUploadA(type) {
      //显示
      this.fileUpload = true
      //行id
      this.tableId = this.UUID
      // this.form.id = type
      let obj = {}
      obj.tableName = 'baseItem'
      obj.tableId = this.UUID
      obj.isDelete = 1
      obj.tableType = type
      this.tableType = type
      // console.log(row);
      console.log(type);

      //根据tableId和tableName 进行回显
      listManage(obj).then(response => {
        let rows = response.rows
        let fileList = []
        //控件值需要name 和 url 不然显示不了正确值
        for (let key in rows) {
          let obj1 = {}
          obj1.name = rows[key].fileName
          obj1.url = rows[key].fileUrl
          obj1.id = rows[key].id
          fileList.push(obj1)
        }
        this.fileList = fileList
      })
    },
    //文件上传成功钩子
    updateFileSuccess(response, file, fileList) {
      //获取图片访问网址
      let ossUrl = response.ossUrl
      //获取文件的名称
      let fileName = file.raw.name
      let fileType = file.raw.type
      let fileSize = file.raw.size
      let obj = {}
      obj.fileName = fileName
      obj.fileType = fileType
      obj.fileSize = fileSize
      obj.title = '原料文件'
      obj.tableName = 'baseItem'
      obj.tableId = this.UUID
      obj.fileUrl = ossUrl
      obj.tableType = this.tableType
      if (obj.tableType === 6) {
        obj.title = '过敏源信息'
      } else if (obj.tableType === 7) {
        obj.title = 'IFRA证明文件'
      } else if (obj.tableType === 8) {
        obj.title = '其他资料'
      } else if (obj.tableType === 9) {
        obj.title = '公司内部原料标准'
      }else if (obj.tableType === 10) {
        obj.title = 'MSDS'
      } else if (obj.tableType === 11) {
        obj.title = 'SPEC/COA'
      } else if (obj.tableType === 12) {
        obj.title = 'TDS'
      }else if (obj.tableType === 13) {
        obj.title = '原料附件14'
      }else if (obj.tableType === 14) {
        obj.title = '非动物检测证明'
      }
      if (response.code === 1) {
        addManage(obj)
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
    filePreview(file) {
      window.open(file.url)
    },
    fileRemove(file, fileList) {
      let arr = []
      let id = file.id
      let obj = {}
      obj.isDelete = 2
      obj.id = id
      arr.push(obj)
      updateFileManage(arr).then(response => {
        this.$modal.msgSuccess('删除文件成功')
      })
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "原料信息导入";
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
      this.download('web/base/item/importMaterialTemplate', {}, `item_material_${new Date().getTime()}.xlsx`)
    },
    // 提交上传文件
    submitFileForm() {
      this.$refs.upload.submit();
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
  //  下载按钮
    downloadS(row){
      for (let i in row){
        window.open(row[i])
      }

    },
    // 上传文件type
    tableTypes(type){
      this.tableType = type
    },
  }
};
</script>
<style lang="scss" scoped>
.demo-table-expand {
  font-size: 0;
}

.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}

td.el-table__cell.el-table__expanded-cell {
  padding-top: 0;
  padding-bottom: 0;
}

.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
}
::v-deep .el-col{
  margin-bottom: -8px;
}
::v-deep .el-tabs--border-card > .el-tabs__content{
  padding: 0;
}
</style>

