<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
        <el-form-item label="归属部门" prop="deptId" >
          <treeselect v-model="queryParams.deptId" :options="deptOptions" :show-count="true" placeholder="请选择归属部门"
          style="width: 200px"
          />
        </el-form-item>
      <el-form-item label="员工编码" prop="employeeCode">
        <el-input
          v-model="queryParams.employeeCode"
          placeholder="请输入员工编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="员工姓名" prop="employeeName">
        <el-input
          v-model="queryParams.employeeName"
          placeholder="请输入员工姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号" prop="mobileNumber">
        <el-input
          v-model="queryParams.mobileNumber"
          placeholder="请输入手机号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>


<!--      <el-form-item label="职务" prop="positionId">-->
<!--        <el-input-->
<!--          v-model="queryParams.positionId"-->
<!--          placeholder="请输入职务"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="职务" prop="positionId">
        <el-select
          v-model="queryParams.positionId"
          placeholder="请选择职务"
          clearable
          filterable
          size="small"
          style="width: 240px"
        >
          <el-option
            v-for="dict in postListOptions"
            :key="dict.postId"
            :label="dict.postName"
            :value="dict.postId"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input
          v-model="queryParams.email"
          placeholder="请输入邮箱"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="签字模板" prop="status">
        <el-select
          v-model="queryParams.isSignatureTemplate"
          placeholder="签字模板"
          clearable
          size="small"
          style="width: 240px"
        >
          <el-option
            v-for="dict in dict.type.sys_yes_no"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="在职状态" prop="">
        <el-select
          v-model="queryParams.jobStatus"
          placeholder="在职状态"
          clearable
          size="small"
          style="width: 240px"
        >
          <el-option
            v-for="dict in dict.type.sys_on_job_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-row>
        <el-col :span="8" >
          <el-form-item>
            <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
            <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
          </el-form-item>
        </el-col>
      </el-row>
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
          v-hasPermi="['web:employee:add']"
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
          v-hasPermi="['web:employee:edit']"
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
          v-hasPermi="['web:employee:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['web:employee:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="infoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="员工编码" align="center" prop="employeeCode" />
      <el-table-column label="员工姓名" align="center" prop="employeeName" />
      <el-table-column label="部门" align="center" prop="deptName" />
      <el-table-column label="车间" align="center" prop="workshopName" />
      <el-table-column label="班组id" align="center" prop="groupId" />
      <el-table-column label="职务" align="center" prop="postName" />
      <el-table-column label="手机号" align="center" prop="mobileNumber" />
      <el-table-column label="性别" align="center" prop="sex" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_user_sex" :value="scope.row.sex"/>
        </template>
      </el-table-column>
      <el-table-column label="邮箱" align="center" prop="email" />
      <el-table-column label="工龄" align="center" prop="lengthService" />
      <el-table-column label="年龄" align="center" prop="age" />
      <el-table-column label="婚姻" align="center" prop="marriage" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_employeeInfo_marriage" :value="scope.row.marriage"/>
        </template>
      </el-table-column>
      <el-table-column label="民族" align="center" prop="nationality" />
      <el-table-column label="政治面貌" align="center" prop="politicalStatus" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_employeeInfo_politicalStatus" :value="scope.row.politicalStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="籍贯" align="center" prop="nativePlace" />
      <el-table-column label="身份证号" align="center" prop="idCard" />
      <el-table-column label="出生日期" align="center" prop="birthday" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.birthday, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="户口所在地" align="center" prop="homePlace" />
      <el-table-column label="实际居住地" align="center" prop="address" />
      <el-table-column label="毕业学校" align="center" prop="graduateSchool" />
      <el-table-column label="专业" align="center" prop="specialty" />
      <el-table-column label="毕业时间" align="center" prop="graduationDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.graduationDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="职称" align="center" prop="professional" />
      <el-table-column label="入职时间" align="center" prop="joinDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.joinDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="离职时间" align="center" prop="dimissionDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.dimissionDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="离职原因" align="center" prop="leaveReason" />
      <el-table-column label="离职原因描述" align="center" prop="reasonDec" />
      <el-table-column label="合同生效日" align="center" prop="contractEffective" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.contractEffective, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="合同失效日" align="center" prop="contractExpiration" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.contractExpiration, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="语言/技能" align="center" prop="skills" />
      <el-table-column label="职务" align="center" prop="positionalTitles" />
      <el-table-column label="学历" align="center" prop="education" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_employeeInfo_education" :value="scope.row.education"/>
        </template>
      </el-table-column>
      <el-table-column label="入职承诺书" align="center" prop="letterCommitment" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_employeeInfo_letterCommitment" :value="scope.row.letterCommitment"/>
        </template>
      </el-table-column>
      <el-table-column label="保密廉洁协议" align="center" prop="confidentialityAgreement" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_employeeInfo_confidentialityAgreement" :value="scope.row.confidentialityAgreement"/>
        </template>
      </el-table-column>
      <el-table-column label="在职状态" align="center" prop="jobStatus" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_employeeInfo_jobStatus" :value="scope.row.jobStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="附件"  prop="attachmentUrl">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="FileUpload(scope.row.attachmentUrl)"
          >下载附件
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="签字模板" align="center" prop="isSignatureTemplate" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_yes_no" :value="scope.row.isSignatureTemplate"/>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status" >
      <template slot-scope="scope">
        <dict-tag :options="dict.type.sys_jotime_data_status" :value="scope.row.status"/>
      </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="note" />
<!--      <el-table-column label="创建者" align="center" prop="creatorId" />-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['web:employee:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['web:employee:remove']"
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

    <!-- 添加或修改员工信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="员工姓名" prop="employeeName">
          <el-input v-model="form.employeeName" placeholder="请输入员工姓名" />
        </el-form-item>
        <el-form-item label="手机号码" prop="mobileNumber">
          <el-input v-model="form.mobileNumber" placeholder="请输入手机号码" />
        </el-form-item>
        <el-form-item label="归属部门" prop="deptId">
            <treeselect v-model="form.deptId" :options="deptOptions" :show-count="true" placeholder="请选择归属部门" /></el-form-item>
<!--        <el-form-item label="职务" prop="positionId">-->
<!--          <el-input v-model="form.positionId" placeholder="请输入职务" />-->
<!--        </el-form-item>-->
        <el-form-item label="职务" prop="positionId">
          <el-select v-model="form.positionId" clearable filterable placeholder="请选择职务">
            <el-option
              v-for="item in postListOptions"
              :key="item.postId"
              :label="item.postName"
              :value="item.postId"
              :disabled="item.status == 1"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="性别" prop="sex">
            <el-select v-model="form.sex" placeholder="请选择">
              <el-option
                v-for="dict in dict.type.sys_user_sex"
                :key="dict.value"
                :label="dict.label"
                :value="Number(dict.value)"
              ></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入邮箱" />
        </el-form-item>
        <el-form-item label="工龄" prop="lengthService">
          <el-input v-model="form.lengthService" placeholder="请输入工龄" />
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input v-model="form.age" placeholder="请输入年龄" />
        </el-form-item>
        <el-form-item label="婚姻" prop="marriage">
          <el-select v-model="form.marriage" placeholder="请选择">
            <el-option
              v-for="dict in dict.type.sys_employeeInfo_marriage"
              :key="dict.value"
              :label="dict.label"
              :value="Number(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="民族" prop="nationality">
          <el-input v-model="form.nationality" placeholder="请输入民族" />
        </el-form-item>
        <el-form-item label="籍贯" prop="nativePlace">
          <el-input v-model="form.nativePlace" placeholder="请输入籍贯" />
        </el-form-item>
        <el-form-item label="身份证号" prop="idCard">
          <el-input v-model="form.idCard" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="出生日期" prop="birthday">
          <el-date-picker clearable size="small"
                          v-model="form.birthday"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择出生日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="户口所在地" prop="homePlace">
          <el-input v-model="form.homePlace" placeholder="请输入户口所在地" />
        </el-form-item>
        <el-form-item label="实际居住地" prop="address">
          <el-input v-model="form.address" placeholder="请输入实际居住地" />
        </el-form-item>
        <el-form-item label="毕业学校" prop="graduateSchool">
          <el-input v-model="form.graduateSchool" placeholder="请输入毕业学校" />
        </el-form-item>
        <el-form-item label="专业" prop="specialty">
          <el-input v-model="form.specialty" placeholder="请输入专业" />
        </el-form-item>
        <el-form-item label="毕业时间" prop="graduationDate">
          <el-date-picker clearable size="small"
                          v-model="form.graduationDate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择毕业时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="入职时间" prop="joinDate">
          <el-date-picker clearable size="small"
            v-model="form.joinDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择入职时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="离职时间" prop="dimissionDate">
          <el-date-picker clearable size="small"
                          v-model="form.dimissionDate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择离职时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="离职原因" prop="leaveReason">
          <el-input v-model="form.leaveReason" placeholder="请输入离职原因" />
        </el-form-item>
        <el-form-item label="离职原因描述" prop="reasonDec">
          <el-input v-model="form.reasonDec" placeholder="请输入离职原因描述" />
        </el-form-item>
        <el-form-item label="合同生效日" prop="contractEffective">
          <el-date-picker clearable size="small"
                          v-model="form.contractEffective"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择合同生效日">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="合同失效日" prop="contractExpiration">
          <el-date-picker clearable size="small"
                          v-model="form.contractExpiration"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择合同失效日">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="语言/技能" prop="skills">
          <el-input v-model="form.skills" placeholder="请输入语言/技能" />
        </el-form-item>
        <el-form-item label="职务" prop="positionalTitles">
          <el-input v-model="form.positionalTitles" placeholder="请输入职务" />
        </el-form-item>
        <el-form-item label="学历" prop="education">
          <el-select v-model="form.education" placeholder="请选择">
            <el-option
              v-for="dict in dict.type.sys_employeeInfo_education"
              :key="dict.value"
              :label="dict.label"
              :value="Number(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="入职承诺书" prop="letterCommitment">
          <el-select v-model="form.letterCommitment" placeholder="请选择">
            <el-option
              v-for="dict in dict.type.sys_employeeInfo_letterCommitment"
              :key="dict.value"
              :label="dict.label"
              :value="Number(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="保密廉洁协议" prop="confidentialityAgreement">
          <el-select v-model="form.confidentialityAgreement" placeholder="请选择">
            <el-option
              v-for="dict in dict.type.sys_employeeInfo_confidentialityAgreement"
              :key="dict.value"
              :label="dict.label"
              :value="Number(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="签字模板">
          <el-select v-model="form.isSignatureTemplate" placeholder="请选择">
            <el-option
              v-for="dict in dict.type.sys_yes_no"
              :key="dict.value"
              :label="dict.label"
              :value="Number(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="备注" prop="note">
          <el-input v-model="form.note" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="在职状态" prop="jobStatus">
          <el-select v-model="form.jobStatus" placeholder="请选择状态">
            <el-option
              v-for="dict in dict.type.sys_employeeInfo_jobStatus"
              :key="dict.value"
              :label="dict.label"
              :value="Number(dict.value)"
            ></el-option>
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
        <el-form-item label="附件" prop="attachmentUrl">
          <!-- <FileUp style="margin-left: 22px;width:380px;height:100px"/>-->
          <el-upload
            id="attachmentUrlUpload"
            class="upload-demo"
            :headers="thisToken"
            v-model="form.attachmentUrl"
            drag
            :action="fileUploadUrl"
            :on-success="fileSuccess"
            multiple
            :on-error="fileError"
            :on-preview="handlePreview"
            :on-remove="handleRemove">
            <el-button size="small" type="primary">选取附件</el-button>
          </el-upload>
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
          <el-col :span="24" 21w1align="center">
            <el-button type="primary"@click="printList">打印标签</el-button>
          </el-col>
        </el-row>

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
<!--          是否更新已经存在的数据（根据工号判断）-->
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
import { listInfo,printPdf, getInfo, delInfo, addInfo, updateInfo, deleteFile ,getPostList} from "@/api/jotime/employee/employee";
import { getToken } from "@/utils/auth";
import { treeselect } from "@/api/system/dept";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";
import FileUp from "@/components/FileUpload";

import {Loading} from "element-ui";


export default {
  name: "Employee",
  dicts: ['sys_yes_no','sys_on_job_status','sys_jotime_data_status','sys_normal_disable','sys_user_sex','sys_employeeInfo_marriage','sys_employeeInfo_education','sys_employeeInfo_letterCommitment','sys_employeeInfo_confidentialityAgreement','sys_employeeInfo_jobStatus',],
  components: { Treeselect, FileUp },
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
      // 员工信息表格数据
      infoList: [],
      // 弹出层标题
      title: "",
      // 部门树选项
      deptOptions: undefined,
      postListOptions:[],
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
        headers: { Authorization: "Bearer " + getToken() },
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/web/employee/importData"
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        employeeCode: null,
        employeeName: null,
        deptId: null,
        workshopId: null,
        groupId: null,
        positionId: null,
        mobileNumber: undefined,
        sex: null,
        email: null,
        lengthService: null,
        age: null,
        marriage: null,
        nationality: null,
        politicalStatus: null,
        nativePlace: null,
        idCard: null,
        birthday: null,
        homePlace: null,
        address: null,
        graduateSchool: null,
        specialty: null,
        graduationDate: null,
        professional: null,
        joinDate: null,
        dimissionDate: null,
        leaveReason: null,
        reasonDec: null,
        contractEffective: null,
        contractExpiration: null,
        positionalTitles: null,
        skills: null,
        education: null,
        letterCommitment: null,
        confidentialityAgreement: null,
        jobStatus: null,
        attachmentUrl: null,
        isSignatureTemplate: null,
        status: null,
        note: null,
      },
      //打印
      printWidth: 100,
      printCount: 1,
      printHeight: 80,
      openPrint: false,
      //选择数据
      rows: [],
      // 表单参数
      form: {},
      thisToken: {'Authorization': 'Bearer ' + getToken()},
      fileUploadUrl: process.env.VUE_APP_BASE_API + '/oss/uploadFile?busType=E03',
      // 表单校验
      rules: {
        employeeName: [
          { required: true, message: "员工姓名不能为空", trigger: "blur" },
          { min: 2, max: 15, message: '用户名称长度必须介于 2 和 15 之间', trigger: 'blur' }
        ],
        jobStatus: [
          { required: true, message: "在职状态不能为空", trigger: "blur" },
        ],
        email: [
          {
            type: "email",
            message: "'请输入正确的邮箱地址",
            trigger: ["blur", "change"]
          }
        ],
        mobileNumber: [
          { required: true, message: "手机号码不能为空", trigger: "blur" },
          {
            pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/,
            message: "请输入正确的手机号码",
            trigger: "blur"
          }
        ]
      }
    };
  },
  watch: {
    // 根据名称筛选部门树
    deptName(val) {
      this.$refs.tree.filter(val);
    }
  },
  created() {
    this.getList();
    this.getTreeselect();
  },
  methods: {
    //移除所选文件
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },

    handlePreview(file) {
      console.log(file);
    },
    //文件上传成功钩子
    fileSuccess(response, file, fileList) {
      //获取图片访问网址
      let ossUrl = response.ossUrl
      //获取文件的名称
      let fileName = file.raw.name
      let fileType = file.raw.type
      let fileSize = file.raw.size
      this.form.fileName = fileName
      this.form.fileType = fileType
      this.form.fileSize = fileSize
      this.form.title = '员工附件'
      if (fileList.length>=1){
        this.form.attachmentUrl = ossUrl
      }
      this.form.attachmentUrl.anchor(fileList)
    },
    //文件上传失败钩子
    fileError(err, file, fileList) {
      this.$modal.msgSuccess('文件上传失败，请联系管理员')
      console.log(err)
    },
    /** 查询员工信息列表 */
    getList() {
      this.loading = true;
      getPostList().then(response => {
        this.postListOptions = response.postListOptions;
      });
      listInfo(this.queryParams).then(response => {
        this.infoList = response.rows;
        // for (let i = 0; i < this.infoList.length; i++) {
        //   for (let j = 0; j < this.postListOptions.length; j++) {
        //     if (this.infoList[i].positionId==this.postListOptions[j].postId){
        //       this.infoList[i].positionId=this.postListOptions[j].postName;
        //       break;
        //     }
        //   }
        // }
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询部门下拉树结构 */
    getTreeselect() {
      treeselect().then(response => {
        this.deptOptions = response.data;
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
        employeeCode: null,
        employeeName: null,
        deptId: null,
        workshopId: null,
        groupId: null,
        positionId: null,
        mobileNumber: null,
        sex: null,
        email: null,
        lengthService: null,
        age: null,
        marriage: null,
        nationality: null,
        politicalStatus: "0",
        nativePlace: null,
        idCard: null,
        birthday: null,
        homePlace: null,
        address: null,
        graduateSchool: null,
        specialty: null,
        graduationDate: null,
        professional: null,
        joinDate: null,
        dimissionDate: null,
        leaveReason: null,
        reasonDec: null,
        contractEffective: null,
        contractExpiration: null,
        positionalTitles: null,
        skills: null,
        education: null,
        letterCommitment: null,
        confidentialityAgreement: null,
        jobStatus: 1,
        attachmentUrl: null,
        isSignatureTemplate: null,
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
      this.getTreeselect();
      this.open = true;
      this.title = "添加员工信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改员工信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateInfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addInfo(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除员工信息编号为"' + ids + '"的数据项？').then(function() {
        return delInfo(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('web/employee/export', {
        ...this.queryParams
      }, `info_${new Date().getTime()}.xlsx`)
    },
    FileUpload(item){
      if (item==null){
        this.$modal.msgSuccess('请先上传文件/附件。')
      }else {
        window.location.href = item;
      }
    },
    /**删除上传文件*/
    deleteFile() {
      let fileUrl = this.form.fileUrl
      let filepath = fileUrl.substr(45);
      this.fileUrlArr.push(filepath)
      console.log(filepath);
      deleteFile(this.fileUrlArr).then(response => {
        this.$modal.msgSuccess("文件" + fileUrl + "删除成功");
      })
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
      if (this.rows==null||this.rows.length==0) return this.$modal.msgError("请选择要打印的员工！");
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
      // console.log(obj)

      obj.isRight=20;
      obj.isLeft = 2;
      let afterArr2 = []
      for (let i = 0; i < this.rows.length; i++) {
        afterArr2.push(JSON.parse(JSON.stringify(this.rows[i])))
      }
      obj.data = afterArr2;
      console.log(obj);
      printPdf(obj).then(res => {
        this.printPDF(res)
        this.openPrint = false
        loadingInstance.close()
      })
      // })
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "员工导入";
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
      this.download('/web/employee/importTemplate', {}, `employee_${new Date().getTime()}.xlsx`)
    },
    // 提交上传文件
    submitFileForm() {
      this.$refs.upload.submit();
    },
  }
};
</script>

<style>

#attachmentUrlUpload .el-upload-dragger{
  width: 90px;
  height: 35px;
  border:none;
}
</style>
