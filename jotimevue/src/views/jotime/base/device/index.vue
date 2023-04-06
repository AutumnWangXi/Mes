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
      <el-form-item label="设备规格" prop="deviceModel">
        <el-input
          v-model="queryParams.deviceModel"
          placeholder="请输入设备名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!--      <el-form-item label="车间" prop="workshopId">-->
      <!--        <el-input-->
      <!--          v-model="queryParams.workshopId"-->
      <!--          placeholder="请输入车间"-->
      <!--          clearable-->
      <!--          size="small"-->
      <!--          @keyup.enter.native="handleQuery"-->
      <!--        />-->
      <!--      </el-form-item>-->

      <el-form-item label="车间" prop="workshopId">
        <el-select
          v-model="queryParams.workshopId"
          placeholder="请选择车间"
          clearable filterable
          size="small"
          style="width: 240px"
          @click.native="getWorkShopList()"
        >
          <el-option
            v-for="dict in workshopOptions"
            :key="dict.id"
            :label="dict.workshopName"
            :value="dict.id"
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
          v-hasPermi="['base:device:add']"
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
          v-hasPermi="['base:device:edit']"
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
          v-hasPermi="['base:device:remove']"
        >删除
        </el-button>
      </el-col>
      <el-button
        type="info"
        icon="el-icon-upload2"
        size="mini"
        @click="handleImport"
      >导入
      </el-button>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['base:device:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!--    原料入库通知单导入对话框 -->
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
          <el-link style="font-size:12px" @click="importData" type="primary">下载模板</el-link>
        </div>
        <div class="el-upload__tip" style="color:red" slot="tip">提示：仅允许导入“xls”或“xlsx”格式文件！</div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFileForm">确 定</el-button>
        <el-button @click="upload.open = false">取 消</el-button>
      </div>
    </el-dialog>

    <el-table v-loading="loading" :data="deviceList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="设备编码" align="center" prop="deviceCode"/>
<!--      <el-table-column label="二维码 " align="center" prop="qrCode" min-width="100%">-->
<!--        <template slot-scope="scope">-->
<!--          &lt;!&ndash;          <qrcode :value="www.baidu.com"  :options="{ size: 100 }"></qrcode>&ndash;&gt;-->
<!--        </template>-->
<!--      </el-table-column>-->
      <el-table-column label="设备名称" align="center" prop="deviceName"/>
      <el-table-column label="设备类型" align="center" prop="deviceType"/>
      <el-table-column label="设备组" align="center" prop="deviceGroup"/>
      <el-table-column label="购买日期" align="center" prop="purchaseDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.purchaseDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="最大生产值" align="center" prop="maximumProduction" />
      <el-table-column label="单位" align="center" prop="unit" />
      <!--      <el-table-column label="车间" align="center" prop="workshopId" />-->
      <el-table-column label="流水线" align="center" prop="lineName"/>
      <el-table-column label="车间" align="center" prop="workshopName"/>
      <!--      <el-table-column label="设备说明书" align="center" prop="content" />-->
      <el-table-column label="最新保养时间" align="center" prop="maintenanceDate" width="100">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.maintenanceDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="保养周期(天数)" align="center" prop="maintenanceCycle"/>
      <el-table-column label="说明书" align="center">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-download"
            @click="fileUploadA(scope.row)"
          >上传说明书
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="下次保养日期" align="center" prop="nextMaintenanceDate" width="100">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.nextMaintenanceDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <!--      <el-table-column label="状态" align="center" prop="status" />-->

      <el-table-column label="状态" align="center" prop="status" width="100">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_base_device_status" :value="scope.row.status"/>
        </template>
      </el-table-column>

      <el-table-column label="备注" align="center" prop="note"/>
      <el-table-column label="二级保养周期(月)" align="center" prop="twoNdMaintenanceCycle" />
      <el-table-column label="二级保养周期(月)" align="center" prop="nextTwoNdMaintenanceDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.nextTwoNdMaintenanceDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="设备分类" align="center" prop="deviceClass" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_device_class" :value="scope.row.deviceClass"/>
        </template>
      </el-table-column>
      <el-table-column label="生产厂及国别" align="center" prop="deviceMfrs" />
      <el-table-column label="生产日期" align="center" prop="pdDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.pdDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="联系电话" align="center" prop="contactTelephone" />
      <el-table-column label="设备负责人" align="center" prop="deviceLeaderName" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['admin:device:edit']"
          >修改
          </el-button>
          <!--          <el-table-column label="设备类型" align="center" :show-overflow-tooltip="true">-->
          <!--            <template slot-scope="scope">-->
          <!--              <router-link :to="'/jotime/deviceTypedtl-data/deviceType/' + scope.row.deviceType" class="link-type">-->
          <!--                <span>{{ scope.row.deviceType }}</span>-->
          <!--              </router-link>-->
          <!--            </template>-->
          <!--          </el-table-column>-->

          <!--          <el-button-->
          <!--            size="mini"-->
          <!--            type="text"-->
          <!--            icon="el-icon-menu"-->
          <!--          >-->
          <!--            <router-link :to="'/jotime/deviceTypedtl-data/deviceType/' + scope.row.deviceType" class="link-type">-->
          <!--              <span>工艺管理</span>-->
          <!--            </router-link>-->
          <!--          </el-button>-->
          <el-button
            size="mini"
            type="text"
            icon="el-icon-menu"
            @click="handleProductionDevice(scope.row)"
          >工艺参数
          </el-button>
<!--          <el-button-->
<!--            size="mini"-->
<!--            type="text"-->
<!--            icon="el-icon-menu"-->
<!--            @click="redoPrint(scope.row)"-->
<!--            v-hasPermi="['web:notice:edit']"-->
<!--          >打印-->
<!--          </el-button>-->
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['admin:device:remove']"
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

    <!-- 添加或修改设备信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="75%" append-to-body>
      <el-form style="margin-left: 5%" ref="form" :inline="true" :model="form" :rules="rules" label-width="130px">
<!--        <el-form-item label="设备编码" prop="deviceCode">-->
<!--          <el-input v-model="form.deviceCode" placeholder="请输入设备编码"/>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="二维码" prop="qrCode">-->
<!--          <el-input v-model="form.qrCode" placeholder="请输入设备编码"/>-->
<!--        </el-form-item>-->
        <el-form-item label="设备名称" prop="deviceName">
          <el-input v-model="form.deviceName" placeholder="请输入设备名称"/>
        </el-form-item>
        <!--        <el-form-item label="车间" prop="workshopId">-->
        <!--          <el-input v-model="form.workshopId" placeholder="请输入车间" />-->
        <!--        </el-form-item>-->


        <el-form-item label="设备类型" prop="deviceType">
          <template slot-scope="scope">
            <el-select v-model="form.deviceType"  @change="getdeviceGroupList($event)" filterable placeholder="请选择">
              <el-option
                v-for="item in deviceTypeList"
                :key="item.id"
                :label="item.deviceTypeName"
                :value="item.deviceType"
              ></el-option>
            </el-select>
          </template>

        </el-form-item>
        <el-form-item label="设备分组" prop="deviceGroup">
          <el-select v-model="form.deviceGroup" filterable placeholder="请选择">
            <el-option
              v-for="item in deviceGroupList"
              :key="item.id"
              :label="item.typeLabel"
              :value="item.typeValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="购买日期" prop="purchaseDate">
          <el-date-picker clearable size="small"
                          v-model="form.purchaseDate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择购买日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="最大生产值" prop="maximumProduction">
          <el-input v-model="form.maximumProduction" placeholder="请输入最大生产值" />
        </el-form-item>
        <el-form-item label="单位" prop="unit">
          <el-input v-model="form.unit" placeholder="请输入单位" />
        </el-form-item>

        <el-form-item label="流水线" prop="lineId">
          <el-select v-model="form.lineId" filterable placeholder="请选择" @change="getWorkShop($event)">
            <el-option
              v-for="item in lineList"
              :key="item.id"
              :label="item.lineName"
              :value="item.id"
              :disabled="item.status == 1"
            ></el-option>
          </el-select>
        </el-form-item>
<!--        <el-form-item label="车间" prop="workshopId" hidden>-->
<!--          <el-input v-model="form.workshopId" placeholder="车间"/>-->
<!--        </el-form-item>-->
        <!--        <el-form-item label="车间名" prop="workshopName">-->
        <!--          <el-input v-model="workshopName" placeholder="车间" disabled />-->
        <!--        </el-form-item>-->
        <el-form-item label="车间" prop="workshopId">
          <el-select v-model="form.workshopId" clearable filterable placeholder="请选择">
            <el-option
              v-for="item in workshopOptions"
              :key="item.id"
              :label="item.workshopName"
              :value="item.id"
              :disabled="item.status == 1"
            ></el-option>
          </el-select>
        </el-form-item>
        <!--        <el-form-item label="设备说明书">-->
        <!--          <el-input v-model="form.content" placeholder="请输入车间" />-->
        <!--        </el-form-item>-->


        <el-form-item label="最新保养时间" prop="maintenanceDate">
          <el-date-picker clearable size="small"
                          v-model="form.maintenanceDate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择最新保养时间">
          </el-date-picker>
        </el-form-item>
        <!--        <el-form-item label="保养周期" prop="maintenanceCycle">-->
        <!--          <el-input v-model="form.maintenanceCycle" placeholder="请输入保养周期" />-->
        <!--        </el-form-item>-->
        <el-form-item label="一级保养周期(月)" prop="maintenanceCycle">
          <el-input-number v-model="form.maintenanceCycle"  controls-position="right" :min="0"/>
        </el-form-item>

        <el-form-item label="一级下次保养日期" prop="nextMaintenanceDate">
          <el-date-picker clearable size="small"
                          v-model="form.nextMaintenanceDate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择下次保养日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="二级保养周期(月)" prop="twoNdMaintenanceCycle">
          <el-input-number v-model="form.twoNdMaintenanceCycle" placeholder="请输入二级保养周期(月)" controls-position="right" :min="0"/>
        </el-form-item>
        <el-form-item label="二级下次保养日期" prop="nextTwoNdMaintenanceDate">
          <el-date-picker clearable size="small"
                          v-model="form.nextTwoNdMaintenanceDate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择二级下次保养日期(月)">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="设备分类" prop="deviceClass">
          <!--          <el-input v-model="form.deviceClass" placeholder="请输入设备分类 A 重要设备 B  主要设备  C 一般设备" />-->
          <el-select v-model="form.deviceClass" placeholder="请选择">
            <el-option
              v-for="dict in dict.type.sys_device_class"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="生产厂及国别" prop="deviceMfrs">
          <el-input v-model="form.deviceMfrs" placeholder="请输入生产厂及国别" />
        </el-form-item>
        <el-form-item label="生产日期" prop="pdDate">
          <el-date-picker clearable size="small"
                          v-model="form.pdDate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择生产日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="联系电话" prop="contactTelephone">
          <el-input v-model="form.contactTelephone" placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item label="设备负责人" prop="deviceLeaderId">
<!--          <el-input v-model="form.deviceLeaderId" placeholder="请输入设备负责人" />-->
          <el-select v-model="form.deviceLeaderId" clearable filterable placeholder="请选择">
            <el-option
              v-for="item in infoList"
              :key="item.id"
              :label="item.employeeName"
              :value="item.id"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.sys_base_device_status"
              :key="dict.value"
              :label="String(dict.value)"
            >{{ dict.label }}
            </el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="备注" prop="note">
          <el-input style="width: 500px" v-model="form.note" type="textarea" placeholder="请输入内容"/>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <el-dialog :title="title" ref="upload" :visible.sync="fileUpload" width="400px" append-to-body>
      <el-upload
        class="upload-demo"
        :headers="thisToken"
        drag
        :action="fileUploadUrl"
        multiple
        :on-success="fileSuccess"
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


    <!--    添加工艺参数-->
    <el-dialog :title="titleProcessParam" :visible.sync="openProcessParam" width="985px" append-to-body>
      <el-form v-if="!addProcessparam" ref="form" :model="formProcessParam" :rules="ruless">
        <el-form :inline="true">
          <el-form-item style="margin-left: 20px" label="设备" prop="deviceName">
            <el-input  v-model="formProcessParam.deviceName"  style="max-width: 200px" disabled/>
          </el-form-item>
          <el-form-item style="margin-left: 20px" label="工艺组名称" prop="groupName">
            <el-input  v-model="formProcessParam.groupName" placeholder="请输入工艺组名称" style="max-width: 200px"/>
          </el-form-item>
          <el-form-item style="margin-left: 20px" label="排序" prop="paramSort">
            <el-input-number v-model="formProcessParam.paramSort" controls-position="right" :min="0" />
          </el-form-item>
        </el-form>
        <el-divider></el-divider>

        <el-form-item label="工艺参数名称" style="margin-left: 20px" :model="queryProcessparam">
          <el-input
            style="max-width: 150px;margin-right: 20px"
            placeholder="请输入工艺参数名称"
            clearable
            size="small"
            v-model="queryProcessparam.paramName"
            @keyup.enter.native="handleProcessparam"
          />
          <el-button type="primary" icon="el-icon-search" size="mini" @click="handleProcessparam">搜索</el-button>
          <el-button type="primary" style="margin-left: 100px" @click="cutProcessparam()"><label v-text="cut"></label></el-button>
        </el-form-item>
        <el-form-item prop="value">
            <div class="table">
              <el-table style="width: 100%" height="300px" v-loading="loading" :data="ProcessparamList" @selection-change="selectRow"
              >
                <el-table-column type="selection" width="45" align="center"></el-table-column>
                <el-table-column label="序号" type="index" width="60" align="center"></el-table-column>
                <el-table-column label="工艺参数值" align="center" prop="paramValue">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.paramValue" align="center"></el-input>
                  </template>
                </el-table-column>
                <el-table-column label="工艺参数名称" align="center" prop="paramName">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.paramName" align="center"></el-input>
                  </template>
                </el-table-column>
                <el-table-column label="单位" align="center" prop="unit">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.unit" align="center"></el-input>
                  </template>
                </el-table-column>
                <el-table-column label="排序" align="center" prop="paramSort">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.paramSort" type="textarea" align="center"></el-input>
                  </template>
                </el-table-column>
              </el-table>
            </div>
        </el-form-item>
      </el-form>
<!--查看工艺参数-->
      <el-form v-if="addProcessparam" >
        <el-form >
          <el-form-item style="margin-left: 20px" label="设备" prop="deviceName">
            <el-input  v-model="formProcessParam.deviceName"  style="max-width: 200px" disabled/>
          </el-form-item>
        </el-form>
        <el-divider></el-divider>
        <el-button type="primary" style="margin-left: 20px" @click="cutProcessparam()"><label v-text="cut"></label></el-button>
        <el-form-item prop="value">
            <div >
              <el-table style="width: 100%" height="300px" v-loading="loading" :data="cutProcessparamList"
              >
                <el-table-column width="30"  align="center"></el-table-column>
                <el-table-column label="序号" type="index" width="60" align="center"></el-table-column>
                <el-table-column label="工艺组名称" align="center" >
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.groupName" align="center" disabled></el-input>
                  </template>
                </el-table-column>
                <el-table-column label="工艺参数值" align="center" >
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.paramValue" align="center" disabled></el-input>
                  </template>
                </el-table-column>
                <el-table-column label="工艺参数名称" align="center">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.paramName" align="center" disabled></el-input>
                  </template>
                </el-table-column>

                <el-table-column label="单位" align="center" >
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.unit" align="center" disabled></el-input>
                  </template>
                </el-table-column>
                <el-table-column label="排序" align="center"  disabled>
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.paramSort" type="textarea" align="center" disabled></el-input>
                  </template>
                </el-table-column>
                <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
                  <template slot-scope="scope">
                    <el-button
                      size="mini"
                      type="text"
                      icon="el-icon-delete"
                      @click="delectdeviceppdtlRowData(scope.row,scope.$index)"
                      v-hasPermi="['web:deviceppdtl:remove']"
                    >删除
                    </el-button>
                  </template>
                </el-table-column>
              </el-table>
            </div>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitProcessparam" v-if="!addProcessparam">保 存</el-button>
        <el-button @click="cancelProcessparam">完 成</el-button>
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

<!--        <el-row :gutter="24" style="margin-top: 100px">-->
<!--          <el-col :span="3">-->
<!--            <label v-text=""> 设备名称</label></el-col>-->
<!--          <el-col :span="9">-->
<!--            <div class="input">-->
<!--              <el-input type="text" v-model="form.deviceName"disabled></el-input>-->
<!--            </div>-->
<!--          </el-col>-->
<!--          <el-col :span="3"><label> 设备编码</label></el-col>-->
<!--          <el-col :span="9">-->
<!--            <div class="input">-->
<!--              <el-input type="text" v-model="form.deviceCode" disabled></el-input>-->
<!--            </div>-->
<!--          </el-col>-->
<!--          <el-col :span="3" style="margin-top: 20px"><label> 二维码信息</label></el-col>-->

<!--          <el-col :span="21"  style="margin-top: 20px">-->
<!--            <div class="input">-->
<!--              <el-input type="text" v-model="form.qrCode" disabled-->
<!--              ></el-input>-->
<!--            </div>-->
<!--          </el-col>-->
<!--        </el-row>-->

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
import {listDevice,printPdf,listDeviceVo, getDevice, delDevice, addDevice, updateDevice} from "@/api/jotime/base/basics/device";

import {getToken} from "@/utils/auth";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";
import FileUp from "@/components/FileUpload";
import {addManage, deleteFileByUrl, listManage, updateFileManage} from "@/api/jotime/file/BaseFileManage";
import {getWorkShopList, getWorkshop} from "@/api/jotime/base/basics/workshop"
import {listLineVo, getLine} from "@/api/jotime/base/basics/line";
import {listDeviceType} from "@/api/jotime/base/basics/deviceType";
import {listProcessparam} from "@/api/jotime/base/basics/processparam";
import {addDeviceppAndDtl} from "@/api/jotime/base/basics/devicepp";
import {delDeviceppdtl, listDeviceppdtlVo} from "@/api/jotime/base/basics/deviceppdtl";
import {Loading} from "element-ui";
import {listDeviceTypedtl} from "@/api/jotime/base/basics/deviceTypedtl";
import {listInfo} from "@/api/jotime/employee/employee";

export default {
  name: "Device",
  components: {FileUp},
  dicts: ['sys_jotime_data_status', 'sys_yes_no', 'sys_base_device_status','sys_device_class'],
  data() {
    return {
      data: [],
      //工艺参数列表
      ProcessparamList: [],
      groupNameInput:false,
      //生产设备弹出层标题
      titleProcessParam: "",
      //生产设备是否显示弹出层
      openProcessParam: false,
      // 遮罩层
      tableType: '',
      loading: true,
      infoList:[],
      // 选中数组
      ids: [],
      //按钮是查看还是添加
      cut:"添加",
      //设备工艺参数列表
      cutProcessparamList:[],
      //设备组列表
      deviceGroupList:[],
      //是否是添加设备工艺参数
      addProcessparam:true,
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      workshopName: "",
      // 总条数
      total: 0,
      // 设备信息表格数据
      deviceList: [],
      //车间下拉框列表
      workshopOptions: [],
      //设备列表
      deviceTypeList: [],
      //车间下拉列表默认为空
      workshopOptionsIsNull: true,
      // 弹出层标题
      title: "",
      temp: "",
      // 是否显示弹出层
      this: false,
      open: false,
      fileUpload: false,
      //打印
      printWidth: 90,
      printCount: 1,
      printHeight: 80,


      openPrint: false,
      //选择数据
      rows: [],
      // 流水线列表
      lineList: [],
      // 用户导入参数
      // upload: {
      //   // 是否显示弹出层（用户导入）
      //   open: false,
      //   // 弹出层标题（用户导入）
      //   title: "",
      //   // 是否禁用上传
      //   isUploading: false,
      //   fileUpload: false,
        // 是否更新已经存在的用户数据
        updateSupport: 0,
      //   // 设置上传的请求头部
      //   headers: {Authorization: "Bearer " + getToken()},
      //   // 上传的地址
      //   url: process.env.VUE_APP_BASE_API + "/system/employee/importData"
      // },
      queryProcessparam: {
        paramName: null,
      },
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
        url: process.env.VUE_APP_BASE_API + "/web/base/device/importData",
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        deviceCode: null,
        deviceName: null,
        deviceGroup: null,
        purchaseDate: null,
        maximumProduction: null,
        unit: null,
        deviceType: null,
        deviceModel:null,
        workshopId: null,
        lineId: null,
        content: null,
        maintenanceDate: null,
        maintenanceCycle: null,
        nextMaintenanceDate: null,
        status: null,
        note: null,
        twoNdMaintenanceCycle: null,
        nextTwoNdMaintenanceDate: null,
        deviceClass: null,
        deviceMfrs: null,
        pdDate: null,
        contactTelephone: null,
        deviceLeaderId: null
      },
      // 表单参数
      form: {},
      formProcessParam: {},
      development: '',
      thisToken: {'Authorization': 'Bearer ' + getToken()},
      fileUploadUrl: process.env.VUE_APP_BASE_API + '/oss/uploadFile?busType=E02',
      fileList: [],
      temporaryPicture: [],
      // 表单校验
      ruless:{
        groupName: [
          {required: true, message: "工艺组名称不能为空", trigger: "blur"}
        ],
      },
      rules: {
        deviceName: [
          {required: true, message: "设备名称不能为空", trigger: "blur"}
        ],
        workshopId: [
          {required: true, message: "车间不能为空", trigger: "blur"}
        ],
        deviceCode: [
          {required: true, message: "设备编码不能为空", trigger: "blur"}
        ],
        qrCode: [
          {required: true, message: "设备二维码不能为空", trigger: "blur"}
        ],
        latestMaintenanceTime: [
          {required: true, message: "最新保养时间不能为空", trigger: "blur"}
        ],

      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询设备信息列表 */
    getList() {
      this.loading = true;
      this.getWorkShopList();
      listDeviceType(null).then(response => {
        this.deviceTypeList = response.rows;
      });
      listDeviceVo(this.queryParams).then(response => {
        this.deviceList = response.rows;
        this.fileUpload = false;
        this.total = response.total;
        this.loading = false;
      });
      listInfo().then(response=> {
        this.infoList = response.rows;
      })
    },
    //根据流水线获取车间
    getWorkShop(val) {
      getLine(val).then(re => {
        this.form.workshopId = Number(re.data.workshopId);
        getWorkshop(this.form.workshopId).then(response => {
          this.workshopName = response.data.workshopName;
        });
      });
      this.$forceUpdate()
    },
    //获取设备组
    getdeviceGroupList(val){
      listDeviceTypedtl({deviceType:val}).then(res=>{
          this.deviceGroupList = res.rows;
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

    // 取消按钮
    cancel() {
      this.open = false;
      this.fileUpload = false;
    },
    // 表单重置
    reset() {
      //重置设备工艺信息
      this.ProcessparamList = [];
      this.formProcessParam = {
        deviceId: null,
        groupName: null,
        paramSort: null,
        baseDevicePpdtls: null,
      };
      this.workshopName = null;
      this.form = {
        id: null,
        deviceCode: null,
        deviceName: null,
        deviceGroup: null,
        purchaseDate: null,
        maximumProduction: null,
        unit: null,
        deviceType: null,
        workshopId: null,
        content: null,
        lineId: null,
        maintenanceDate: null,
        maintenanceCycle: null,
        nextMaintenanceDate: null,
        status: "1",
        note: null,
        twoNdMaintenanceCycle: null,
        nextTwoNdMaintenanceDate: null,
        deviceClass: null,
        deviceMfrs: null,
        pdDate: null,
        contactTelephone: null,
        deviceLeaderId: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
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
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      listLineVo(null).then(response => {
        this.lineList = response.rows;
      });
      this.open = true;
      this.title = "添加设备信息";
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "设备导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importData() {
      this.download('web/base/device/importTemplate', {}, `device_importData_${new Date().getTime()}.xlsx`)
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
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      listLineVo(null).then(response => {
        this.lineList = response.rows;
      });

      const id = row.id || this.ids
      getDevice(id).then(response => {
        this.form = response.data;
        if (this.form.deviceType!=null){
          listDeviceTypedtl({deviceType:this.form.deviceType}).then(res=>{
            this.deviceGroupList = res.rows;
          });
        }
        this.temp = this.form.lineId;
        if (this.form.workshopId != null) {
          getWorkshop(this.form.workshopId).then(response => {
            this.workshopName = response.data.workshopName;
          });
        }
        this.open = true;
        this.title = "修改设备信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateDevice(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDevice(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除设备信息编号为"' + ids + '"的数据项？').then(function () {
        return delDevice(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('admin/device/export', {
        ...this.queryParams
      }, `device_${new Date().getTime()}.xlsx`)
    },

    filePreview(file) {
      window.open(file.url)
    },
    deleteFile() {
      let temporaryPicture = this.temporaryPicture
      console.log(temporaryPicture)
      let urlList = []
      for (let key in temporaryPicture) {
        urlList.push(temporaryPicture[key].response.ossUrl)
      }
      if (!!urlList) {
        deleteFileByUrl(urlList)
      }
      this.fileUpload = false
      this.reset()
      this.handleQuery()
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
    //打开上传文件控件方法
    fileUploadA(row, type) {
      this.temporaryPicture = []
      //显示
      this.fileUpload = true
      //行id
      this.tableId = row.id
      this.form.id = row.id
      let obj = {}
      obj.tableName = 'baseDevice'
      obj.tableId = this.tableId
      obj.isDelete = 1
      obj.tableType = type
      this.tableType = type
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
    fileSuccess(response, file, fileList) {
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
      obj.title = '设备说明书'
      obj.tableName = 'baseDevice'
      obj.tableId = this.tableId
      obj.fileUrl = ossUrl
      obj.tableType = this.tableType
      if (response.code === 1) {
        addManage(obj)
        this.$modal.msgSuccess('文件上传成功')
        this.temporaryPicture.push(file)
      } else {
        // 实现缩略图模板时删除文件
        let index = fileList.findIndex(fileItem => {
          return fileItem.uid === file.uid
        })
        fileList.splice(index, 1)
        this.$modal.msgError(response.msg)
      }

    },
    //文件上传失败钩子
    fileError(err, file, fileList) {
      this.$modal.msgSuccess('文件上传失败，请联系管理员')
    },
    //获取工艺参数列表
    listProcessparam() {
      listProcessparam(null).then(response => {
        this.ProcessparamList = response.rows;
        this.titleProcessParam = "设备工艺管理";
        this.openProcessParam = true;
      });
    },

    /** 点击设备工艺参数操作 */
    handleProductionDevice(row) {
      this.reset();
      this.listProcessparam();
      listDeviceppdtlVo({deviceId:row.id}).then(re=>{
        this.cutProcessparamList = re.rows;
      });
      this.formProcessParam.deviceName = row.deviceName;
      this.formProcessParam.deviceId = row.id;
      this.addProcessparam=true;
      this.cut="添加";
    },
    /** 提交按钮 */
    submitProcessparam() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          addDeviceppAndDtl(this.formProcessParam).then(response => {
            // console.log(this.formProcessParam);
            this.$modal.msgSuccess("提交成功！");
          });
        }
      });
    },
    //查看||添加设备工艺参数操作
    cutProcessparam(){
      if (this.cut=="添加"){
        this.addProcessparam = false;
        this.cut = "返回";
      }else if (this.cut=="返回"){
        this.addProcessparam = true;
        listDeviceppdtlVo({deviceId:this.formProcessParam.deviceId}).then(re=>{
          this.cutProcessparamList = re.rows;
        });
        this.cut = "添加";
      }
    },
    //工艺参数完成按钮
    cancelProcessparam() {
      this.openProcessParam = false;
    },
    /** 搜索按钮操作 */
    handleProcessparam() {
      listProcessparam(this.queryProcessparam).then(re => {
        this.ProcessparamList = re.rows;
      })
    },
    //删除工艺行数据
    delectdeviceppdtlRowData(row,index){
      const id = row.id;
      this.$modal.confirm('是否确认删除当前项？').then(function () {
        return delDeviceppdtl(id);
      }).then(() => {
        listDeviceppdtlVo({deviceId:row.deviceId}).then(re=>{
          this.cutProcessparamList = re.rows;
        });
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    // 获取表格选中时的数据
    selectRow(val) {
      //选中的数据提交到缺料补料详细表
      this.formProcessParam.baseDevicePpdtls=val;
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
      if (this.rows==null||this.rows.length==0) return this.$modal.msgError("请选择要打印的设备！");
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
        // obj.data = afterArr2


      let afterArr2 = []
      for (let i = 0; i < this.rows.length; i++) {
        afterArr2.push(JSON.parse(JSON.stringify(this.rows[i])))
      }
      obj.data = afterArr2;
      obj.isLeft=2;
      obj.isTop=10;
      printPdf(obj).then(res => {
          this.printPDF(res)
          this.openPrint = false
          loadingInstance.close()
        })
      // })
    },
  }
};
</script>

<!--<style scoped>-->
<!--.edit_transfer >>> .el-transfer-panel {-->
<!--  width: 350px;-->
<!--}-->
<!--</style>-->
<style lang="scss" scoped>
::v-deep .el-input__inner{
  width: 200px;
  height: 36px;
}
::v-deep .el-date-editor{
  width: 200px;
}
::v-deep .el-pagination .el-select .el-input .el-input__inner{
  width: 100%;
}
</style>
