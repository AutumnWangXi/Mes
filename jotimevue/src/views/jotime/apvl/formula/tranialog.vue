<!-- 办理人选择页面 -->
<template>
  <div class="dialog-cont">
    <el-dialog :visible.sync="dialogVisible" width="950px">
      <el-row :gutter="20">
        <el-form
          :model="queryParams"
          ref="queryForm"
          :inline="true"
          v-show="showSearch"
          label-width="68px"
        >
          <el-form-item label="用户昵称" prop="nickName">
            <el-input
              v-model="queryParams.nickName"
              placeholder="请输入用户昵称"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="手机号码" prop="phonenumber">
            <el-input
              v-model="queryParams.phonenumber"
              placeholder="请输入手机号码"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item>
            <el-button
              type="primary"
              icon="el-icon-search"
              size="mini"
              @click="handleQuery"
            >搜索
            </el-button
            >
            <el-button icon="el-icon-refresh" size="mini" @click="resetQuery"
            >重置
            </el-button
            >
            <el-button type="danger" icon="el-icon-delete" size="mini" plain @click="resetData"
            >清空勾选
            </el-button
            >
          </el-form-item>
        </el-form>

        <el-table
          v-loading="loading"
          :data="userList"
          :row-key="rowKey"
          @selection-change="handleSelectionChange"
          style="width: 90%"
          ref='userList'
        >
          <el-table-column type="selection" width="50" align="center" :reserve-selection="true"/>
          <!--          <el-table-column-->
          <!--            label="用户编号"-->
          <!--            align="center"-->
          <!--            key="userId"-->
          <!--            prop="userId"-->
          <!--            v-if="columns[0].visible"-->
          <!--          />-->
          <!--          <el-table-column-->
          <!--            label="用户名称"-->
          <!--            align="center"-->
          <!--            key="userName"-->
          <!--            prop="userName"-->
          <!--            v-if="columns[1].visible"-->
          <!--            :show-overflow-tooltip="true"-->
          <!--          />-->
          <el-table-column
            label="用户昵称"
            align="center"
            key="nickName"
            prop="nickName"
            v-if="columns[2].visible"
            :show-overflow-tooltip="true"
          />
          <el-table-column
            label="部门"
            align="center"
            key="deptName"
            prop="dept.deptName"
            v-if="columns[3].visible"
            :show-overflow-tooltip="true"
          />
          <el-table-column
            label="手机号码"
            align="center"
            key="phonenumber"
            prop="phonenumber"
            v-if="columns[4].visible"
            width="120"
          />
        </el-table>

        <pagination
          v-show="total > 0"
          :total="total"
          :page.sync="queryParams.pageNum"
          :limit.sync="queryParams.pageSize"
          @pagination="getList"
        />
      </el-row>
      <div class="button">
        <el-button @click="cancel" type="primary">取消</el-button>
        <el-button @click="submitForm" type="primary">选择</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  changeUserStatus,
} from "@/api/system/user";
import {
  sysUserList,
} from "@/api/jotime/apvl/common/common";
import {getToken} from "@/utils/auth";
import {treeselect} from "@/api/system/dept";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";

export default {
  name: "tranDialog",
  dicts: ["sys_normal_disable", "sys_user_sex"],
  components: {Treeselect},
  data() {
    return {
      userId: '',
      nickName: '',
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
      // 用户表格数据
      userList: null,
      // 弹出层标题
      title: "",
      // 部门树选项
      deptOptions: undefined,
      // 是否显示弹出层
      dialogVisible: false,
      // 部门名称
      deptName: undefined,
      // 默认密码
      initPassword: undefined,
      // 日期范围
      dateRange: [],
      // 岗位选项
      postOptions: [],
      // 角色选项
      roleOptions: [],
      // 表单参数
      form: {
        ccToId: [],
      },
      defaultProps: {
        children: "children",
        label: "label",
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
        url: process.env.VUE_APP_BASE_API + "/system/user/importData",
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userName: undefined,
        nickName: undefined,
        phonenumber: undefined,
        status: undefined,
        deptId: undefined,
      },
      // 列信息
      columns: [
        {key: 0, label: `用户编号`, visible: true},
        {key: 1, label: `用户名称`, visible: true},
        {key: 2, label: `用户昵称`, visible: true},
        {key: 3, label: `部门`, visible: true},
        {key: 4, label: `手机号码`, visible: true},
        {key: 5, label: `状态`, visible: true},
        {key: 6, label: `创建时间`, visible: true},
      ],
    };
  },
  created() {
    this.getList();
    this.getTreeselect();
    this.getConfigKey("sys.user.initPassword").then((response) => {
      this.initPassword = response.msg;
    });
  },
  methods: {

    /** 查询用户列表 */
    getList() {
      this.loading = true;
      sysUserList(this.addDateRange(this.queryParams, this.dateRange)).then(
        (response) => {
          this.userList = response.rows;
          this.total = response.total;
          this.loading = false;
        }
      );
    },
    /** 查询部门下拉树结构 */
    getTreeselect() {
      treeselect().then((response) => {
        this.deptOptions = response.data;
      });
    },
    // 用户状态修改
    handleStatusChange(row) {
      let text = row.status === "0" ? "启用" : "停用";
      this.$modal
        .confirm('确认要"' + text + '""' + row.userName + '"用户吗？')
        .then(function () {
          return changeUserStatus(row.userId, row.status);
        })
        .then(() => {
          this.$modal.msgSuccess(text + "成功");
        })
        .catch(function () {
          row.status = row.status === "0" ? "1" : "0";
        });
    },
    // 取消按钮
    cancel() {
      this.dialogVisible = false;
      this.reset();
    },

    // 保存按钮
    submitForm() {
      this.$emit("getData", this.userId, this.nickName)


      //approver引用
      this.$emit('getDataNickName', this.nickName)

      this.$notify({
        title: '成功',
        message: '保存成功',
        type: 'success'
      });
      //关闭弹窗
      this.dialogVisible = false;
    },
    // 表单重置
    reset() {
      this.form = {
        userId: undefined,
        deptId: undefined,
        userName: undefined,
        nickName: undefined,
        password: undefined,
        phonenumber: undefined,
        email: undefined,
        sex: undefined,
        status: "0",
        remark: undefined,
        postIds: [],
        roleIds: [],
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
      this.dateRange = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    //清空抄送人
    resetData() {
      this.$refs.userList.clearSelection()
      this.$forceUpdate()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.userId = selection.map((item) => item.userId);
      this.nickName = selection.map((item) => item.nickName)

    },
    // 指定一个唯一标识。id或者其他唯一的
    rowKey(row) {
      return row.userId;
    },
    // 更多操作触发
    handleCommand(command, row) {
      switch (command) {
        case "handleResetPwd":
          this.handleResetPwd(row);
          break;
        case "handleAuthRole":
          this.handleAuthRole(row);
          break;
        default:
          break;
      }
    },
  },
};
</script>
<style lang="scss" scoped>
.dialog-cont {
  ::v-deep.el-pagination__jump > .el-input {
    width: 100px;
  }

  ::v-deep .el-pagination__editor.el-input .el-input__inner {
    width: 60px;
  }

  .button {
    display: flex;
    justify-content: space-around;
    margin-top: 50px;
  }

  ::v-deep .el-form el-form--inline {
    padding-top: 20px
  }
}
</style>
