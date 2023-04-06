<template>
  <div>
    <!-- <div class="header-group">
      <el-breadcrumb>
        <el-breadcrumb-item :to="{ path: '/' }">知识管理</el-breadcrumb-item>
      </el-breadcrumb>
      <div class="common-search">
        <el-dropdown>
          <span class="el-dropdown-link">
            微搜<i class="el-icon-arrow-down el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item v-for="(item, index) in searchList" :key="index">{{ item }}</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <input class="common-input" type="text" placeholder="请输入关键词搜索" placeholder-style="color:#9db1ce;" />
        <i class="el-icon-search"></i>
      </div>
    </div> -->
    <div class="operation-group">
      <div class="operation-left">
        <div class="icon-book">
          <img class="icon-book-img" src="./static/book.png"></img>
        </div>
      </div>
      <div>
        <el-button type="primary" size="mini"  @click="handleAdd"
              v-hasPermi="['web:fileListManage:add']">添加文件</el-button>
        <el-button type="text" @click="fileListType = fileListType ? 0 : 1"><i class="el-icon-s-fold"></i></el-button>
      </div>
    </div>
    <div class="body-group">
      <!-- 左边 -->
      <div class="body-left border">
        <div class="body-header border">
          <el-dropdown>
           <!-- <span>
              <i class="el-icon-collection el-icon--right"></i>
              <span>全部目录</span>
              <i class="el-icon-arrow-down el-icon--right"></i>
            </span> -->
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item v-for="(item, index) in directoryList" :key="index">{{ item }}</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>

        <div class="body-header">
          <el-input style="width:170px" placeholder="请输入文件夹名称" v-model="queryFolderParams.fileFolder" @keyup.enter.native="getFileFolderTree">
            <i slot="suffix" class="el-input__icon el-icon-search"></i>
          </el-input>
          <el-button type="text" size="mini"
            @click="() => append(data)">
            添加
          </el-button>
        </div>
        </div>

        <div>
          <el-tree :key="treeKey" :data="fileFolderTree" node-key="id" :props="defaultProps" @node-click="handleNodeClick"
          highlight-current="true" default-expand-all="true" :expand-on-click-node="false"
          icon-class="el-icon-folder-opened"
          :current-node-key="defaultTree">
            <span class="custom-tree-node" slot-scope="{ node, data }">
              <div>
                <span>{{ node.label }}</span>
              </div>
              <span>
                  <!-- <el-button type="text" size="mini"
                    @click="() => append(data)">
                    添加
                  </el-button> -->
                  <el-button  type="text" size="mini"
                    @click="() => remove(node, data)">
                    删除
                  </el-button>
                </span>
            </span>
          </el-tree>
        </div>
        <!--  -->
      </div>
      <!-- 右边 -->
      <div class="body-right border">
        <div class="body-header border">
          <el-button type="text"><i class="el-icon-house"></i></el-button>
          <el-input style="width:200px" placeholder="请输入文件名"  v-model="queryParams.fileName" @keyup.enter.native="getList()">
            <i slot="suffix" class="el-input__icon el-icon-search"></i>
          </el-input>
        </div>
        <div v-if="fileListType != 1" class="file-header">
          <div class="file-size">文件编号</div>
          <div class="file-size">文件名</div>
          <div class="file-size">文件类型</div>
          <div class="file-size">版本号</div>
          <div class="file-size">生效日期</div>
          <div class="file-size">作废日期</div>
          <div class="file-size">状态</div>
          <div class="file-size">备注</div>
          <div class="file-size">操作</div>
        </div>
        <div class="body-right-info " :class="fileListType == 1 ? 'icon-type' : 'list-type'">
          <div  v-for="(item, index) in list" :key="index" class="file-info" @click="itemClick(item)">
            <img class="file-img" :src="item.icon || require('./static/file-' + item.originalFileName + '.png')"
              :onerror="require('./static/file-' + item.originalFileName + '.png')"></img>
            <div class="file-size">{{ item.fileNo }}</div>
            <div class="file-size">{{ item.fileName }}</div>
            <div class="file-size">{{ item.fileType }}
              <dict-tag :options="dict.type.sys_quality_origin" :value="item.fileType"/>
            </div>
            <div class="file-size">{{ item.version }}</div>
            <div class="file-size">{{ item.effectiveDate }}</div>
            <div class="file-size">{{ item.expiryDate }}</div>
            <div class="file-size">{{ item.status==1?'作废':'现行' }}</div>
            <div class="file-size">{{ item.note }}</div>
            <div class="file-size">
              <el-button type="text" size="mini" @click.stop="updateFile(item,1)"> 作废</el-button>
              <el-button type="text" size="mini"  @click.stop="updateFile(item,2)"> 现行</el-button>
            </div>
          </div>
          <!-- <el-table :data="list" v-if="fileListType != 1">
            <el-table-column label="文件名" prop="fileName">
              <template slot-scope="scope">
                <img class="file-img" :src="scope.row.icon || require('./static/file-' + scope.row.originalFileName + '.png')"
                  :onerror="require('./static/file-' + scope.row.originalFileName + '.png')"></img>
                <div class="file-name">{{ scope.row.fileName }}</div>
              </template>
            </el-table-column>
            <el-table-column label="文件类型" prop="fileType"></el-table-column>
          </el-table> -->

        </div>
        <pagination
          v-show="total>0"
          :total="total"
          :page.sync="queryParams.pageNum"
          :limit.sync="queryParams.pageSize"
          @pagination="getList"
        />
      </div>
    </div>




    <!-- 添加或修改文件夹名对话框 -->
    <el-dialog :title="addFolder.title" :visible.sync="addFolder.open" width="500px" append-to-body>
      <el-form ref="formFolder" :model="addFolder.form" :rules="addFolder.rules" label-width="80px">
        <el-form-item label="父文件夹内码" prop="parentId">
          <!-- <el-input v-model="addFolder.form.parentName" :disabled="addFolder.form.parentId" placeholder="请输入父文件夹内码" /> -->
          <treeselect v-model="addFolder.form.parentId" :options="deptOptions" :normalizer="normalizer" placeholder="选择文件夹" />
        </el-form-item>
        <el-form-item label="文件夹名" prop="fileFolder">
          <el-input v-model="addFolder.form.fileFolder" placeholder="请输入文件夹名" />
        </el-form-item>
        <el-form-item label="显示序号" prop="displaySort">
          <el-input v-model="addFolder.form.displaySort" placeholder="请输入显示序号" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFolder">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>


    <!-- 添加或修改描述：文件清单管理对话框 -->
       <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
         <el-form ref="form" :model="form" :rules="rules" label-width="100px">
           <el-form-item label="文件夹" prop="folderId">
             <!-- <el-input v-model="currentFolder.fileFolder" disabled/> -->
             <treeselect v-model="addFolder.form.folderId" :options="deptOptions" :normalizer="normalizer" placeholder="选择文件夹" />
           </el-form-item>
           <el-form-item label="文件类型" prop="fileType">
             <!-- <el-input v-model="form.fileType" placeholder="请输入文件类型"/> -->
             <el-select v-model="form.fileType">
               <el-option v-for="(item,key,index) in dict.type.sys_file_type"
               :key="item.value"
               :label="item.label"
               :value="item.value"
               ></el-option>
             </el-select>

           </el-form-item>
           <el-form-item label="文件编号" prop="fileNo">
             <el-input v-model="form.fileNo" placeholder="请输入文件编号" />
           </el-form-item>
           <el-form-item label="版本号" prop="version">
             <el-input v-model="form.version" placeholder="请输入版本号(01开始)" />
           </el-form-item>
           <el-form-item label="文件名称" prop="fileName">
             <el-input v-model="form.fileName" placeholder="请输入文件名称" />
           </el-form-item>
           <el-form-item label="文件" prop="fileUrl" >
             <el-upload
               id="uploadsFile"
               :limit="1"
               class="upload-demo"
               :action="fileUploadUrl"
               :headers="thisToken"
               :on-success="fileSuccess"
               :on-error="fileError"
               :on-preview="handlePreview"
               :on-remove="handleRemove"
               :file-list="fileUrlArr"
               :accept="'.pdf'"
               :before-upload="beforeUpload"
             >
               <el-button size="small"  type="primary">点击上传</el-button>
             </el-upload>
           </el-form-item>
           <el-form-item label="生效日期" prop="effectiveDate">
             <el-date-picker clearable size="small"
               v-model="form.effectiveDate"
               type="date"
               value-format="yyyy-MM-dd"
               placeholder="选择生效日期">
             </el-date-picker>
           </el-form-item>
           <el-form-item label="作废日期" prop="expiryDate">
             <el-date-picker clearable size="small"
               v-model="form.expiryDate"
               type="date"
               value-format="yyyy-MM-dd"
               placeholder="选择作废日期">
             </el-date-picker>
           </el-form-item>
           <el-form-item label="备注" prop="note">
             <el-input v-model="form.note" placeholder="请输入备注" />
           </el-form-item>
         </el-form>
         <div slot="footer" class="dialog-footer">
           <el-button type="primary" @click="submitForm">确 定</el-button>
           <el-button @click="cancel">取 消</el-button>
         </div>
       </el-dialog>
       <filepre ref="filepre"></filepre>
  </div>
</template>

  <script>
  import { getTree,listFolder, getFolder, delFolder, addFolder, updateFolder} from "@/api/jotime/file/folder";
import { listFileListManage, getFileListManage, delFileListManage, addFileListManage, updateFileListManage } from "@/api/jotime/file/fileListManage";
import {getToken} from "@/utils/auth";
import FileUp from "@/components/FileUpload";
import filepre from "./components/filepre.vue";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";
export default {
  components: {
    filepre,Treeselect
  },
  dicts: ['file_list_status','sys_file_type'],
  data() {
    return {
      fileListType: 0,
      // directoryList: ['全部目录', '小目录', '大目录', '中目录'],
      // searchList: ['微搜', '大搜', '小搜', '中搜'],
      list: [
        // {
        //   fileName: "公司动态foldersdfwsdfs士大夫士大夫士大夫士大zxczx士大夫士大夫士大夫士大夫夫",
        //   fileType: "folder", //folder excel doc pdf ppt img video 如果还需要其他类型自行扩展
        //   icon: "",
        //   fileUrl: "https://img0.baidu.com/it/u=715279512,2555508937&fm=253&fmt=auto&app=138&f=PNG?w=500&h=706",
        //   fileSize: '150kb',
        //   createTime: '2022-08-19',
        // },
        // {
        //   name: "公司动态excel",
        //   fileType: "excel", //folder excel doc pdf ppt img video 如果还需要其他类型自行扩展
        //   icon: "",
        //   img: "https://img0.baidu.com/it/u=715279512,2555508937&fm=253&fmt=auto&app=138&f=PNG?w=500&h=706",
        //   size: '150kb',
        //   createDate: '2022-08-19',
        // },
        // {
        //   name: "公司动态doc",
        //   fileType: "doc", //folder excel doc pdf ppt img video 如果还需要其他类型自行扩展
        //   icon: "https://img0.baidu.com/it/u=715279512,2555508937&fm=253&fmt=auto&app=138&f=PNG?w=500&h=706",
        //   img: "https://img0.baidu.com/it/u=715279512,2555508937&fm=253&fmt=auto&app=138&f=PNG?w=500&h=706",
        //   size: '150kb',
        //   createDate: '2022-08-19',
        // },
        // {
        //   name: "公司动态pdf",
        //   fileType: "pdf", //folder excel doc pdf ppt img video 如果还需要其他类型自行扩展
        //   icon: "",
        //   img: "https://jotim-test.oss-cn-hangzhou.aliyuncs.com/apply/formula/2022/0822/0c25c9c70aa14f29b5-FG003-2015%E5%B9%B4%E7%AC%AC265%E5%8F%B7%E5%85%AC%E5%91%8A.pdf",
        //   size: '150kb',
        //   createDate: '2022-08-19',
        // },
        // {
        //   name: "公司动态ppt",
        //   fileType: "ppt", //folder excel doc pdf ppt img video 如果还需要其他类型自行扩展
        //   icon: "",
        //   img: "https://img0.baidu.com/it/u=715279512,2555508937&fm=253&fmt=auto&app=138&f=PNG?w=500&h=706",
        //   size: '150kb',
        //   createDate: '2022-08-19',
        // },
        // {
        //   name: "公司动态img",
        //   fileType: "img", //folder excel doc pdf ppt img video 如果还需要其他类型自行扩展
        //   img: "",
        //   img: "https://img0.baidu.com/it/u=715279512,2555508937&fm=253&fmt=auto&app=138&f=PNG?w=500&h=706",
        //   size: '150kb',
        //   createDate: '2022-08-19',
        // },
        // {
        //   name: "公司动态video",
        //   fileType: "video", //folder excel doc pdf ppt img video 如果还需要其他类型自行扩展
        //   icon: "",
        //   img: "https://img0.baidu.com/it/u=715279512,2555508937&fm=253&fmt=auto&app=138&f=PNG?w=500&h=706",
        //   size: '150kb',
        //   createDate: '2022-08-19',
        // },
      ],
  //文件夹列表
  fileFolderTree: [],
  defaultProps: {
    children: 'children',
    label: 'fileFolder'
  },
  currentFolder:{},

  addFolder:{
    open:false,
    title:null,
    form:{},
     // 表单校验
    rules: {
      parentId: [
        { required: true, message: "父文件夹内码不能为空", trigger: "blur" }
      ],
      ancestors: [
        { required: true, message: "祖级列表不能为空", trigger: "blur" }
      ],
      createBy: [
        { required: true, message: "创建者不能为空", trigger: "blur" }
      ],
      createTime: [
        { required: true, message: "创建时间不能为空", trigger: "blur" }
      ],
    }
  },

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
  //文件URL
  fileUrlArr: [],
  // 描述：文件清单管理表格数据
  fileListManageList: [],
  // 弹出层标题
  title: "",
  // 是否显示弹出层
  open: false,
  queryFolderParams:{
    fileFolder:null
  },
  // 查询参数
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    folderId:null,
    primaryCategory: null,
    minorCategory: null,
    fileFolder: null,
    fileType: null,
    fileNo: null,
    version: null,
    fileName: null,
    fileUrl: null,
    effectiveDate: null,
    expiryDate: null,
    deptId: null,
    originalFileName: null,
    fileSize: null,
    operator: null,
    operatorCode: null,
    operateTime: null,
    status: null,
    note: null,
  },
  // 表单参数
  form: {
    fileType:"pdf"
  },
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
    url: process.env.VUE_APP_BASE_API + "/web/fileListManage/importData",
  },
  thisToken: {Authorization: "Bearer " + getToken()},
  fileUploadUrl: process.env.VUE_APP_BASE_API + "/oss/uploadFile?busType=J01",
  // 表单校验
  rules: {
    fileNo: [
      { required: true, message: "文件编号不能为空", trigger: "blur" }
    ],
    fileType: [
      { required: true, message: "文件类型不能为空", trigger: "blur" }
    ],
    fileUrl: [
      { required: true, message: "文件不能为空", trigger: "blur" }
    ],
    version: [
      { required: true, message: "版本号(01开始)不能为空", trigger: "blur" }
    ],
    fileName: [
      { required: true, message: "文件名称不能为空", trigger: "blur" }
    ],
    effectiveDate: [
      { required: true, message: "生效日期不能为空", trigger: "blur" }
    ],
    status: [
      { required: true, message: "状态 1 作废 2 现行(正常）不能为空", trigger: "blur" }
    ],
    createBy: [
      { required: true, message: "创建者id不能为空", trigger: "blur" }
    ],
    createTime: [
      { required: true, message: "创建时间不能为空", trigger: "blur" }
    ],
  },
  defaultTree:null,
  treeKey:false
    };
  },
  mounted() {
    this.getFileFolderTree();
    this.listFolder();
  },
  methods: {
    /** 转换部门数据结构 */
    normalizer(node) {
      if (node.children && !node.children.length) {
        delete node.children;
      }
      return {
        id: node.id,
        label: node.fileFolder,
        children: node.children
      };
    },
    listFolder(){
      listFolder().then(res=>{
        let data = res.rows;
        data.push({id:0,fileFolder:"根目录",children:[]})
        this.deptOptions = this.handleTree(res.rows, "id");

        let sdfas= this.deptOptions;
        console.log(sdfas)
      })
    },
    itemClick(item) {
      console.log(item);
      // this.$refs.filepre.show(item);
      window.open(item.fileUrl)

    },
    append(data) {
        this.addFolder.title="添加文件夹";
        if(data){
          this.addFolder.form.parentId = data.id;
          this.addFolder.form.parentName = data.fileFolder;
          this.addFolder.data = data;
        }
        this.addFolder.open = true;
      },

      remove(node, data) {
        const ids = data.id;
        this.$modal.confirm('是否确认删除文件夹名编号为"' + ids + '"的数据项？').then(function() {
          return delFolder(ids);
        }).then(() => {
          const parent = node.parent;
          const children = parent.data.children || parent.data;
          const index = children.findIndex(d => d.id === data.id);
          children.splice(index, 1);
        }).catch(() => {});

      },
      updateFile(item,status){
        item.status = status
        updateFileListManage(item).then(response => {
          this.$modal.msgSuccess("修改成功");
          // this.open = false;
          this.getList();
        });
      },
      /** 提交按钮 */
      submitFolder() {
        this.$refs["formFolder"].validate(valid => {
          if (valid) {
            if (this.addFolder.form.id != null) {
              updateFolder(this.addFolder.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.addFolder.open = false;
              });
            } else {
              addFolder(this.addFolder.form).then(response => {
                this.getFileFolderTree();
                this.$modal.msgSuccess("添加成功");
                this.addFolder.open = false;

              });
            }
          }
        });
      },
    //查询文件夹树状结构数据
    getFileFolderTree(){
      let param = this.queryFolderParams;
      getTree(param).then(res =>{
        let list = res.data;
        if(!!this.fileFolderTree){
          this.defaultTree = (list[0].id)
           this.handleNodeClick(list[0]);
        }
        this.fileFolderTree = list;
        this.treeKey = !this.treeKey;
      })
    },
    handleNodeClick(data) {
      this.currentFolder = data;
      this.fileListManageList = [];
      this.queryParams.folderId = data.id;
      this.getList();
    },

    /** 查询描述：文件清单管理列表 */
    getList() {
      this.loading = true;
      listFileListManage(this.queryParams).then(response => {
        let list = response.rows;
        if(list){
          list.forEach(item =>{
            item.fileUrl = item.fileUrl+"?response-content-type=application/pdf"
          })
        }
        this.fileListManageList = list;
        this.list = list;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.addFolder.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.fileUrlArr=[],
      this.form = {
        id: null,
        primaryCategory: null,
        minorCategory: null,
        fileFolder: null,
        fileType: null,
        fileNo: null,
        version: null,
        fileName: null,
        fileUrl: null,
        effectiveDate: null,
        expiryDate: null,
        deptId: null,
        originalFileName: null,
        fileSize: null,
        operator: null,
        operatorCode: null,
        operateTime: null,
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
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      if( !this.currentFolder.id){
        this.$modal.msgError("请选择左边目标")
        return;
      }
      this.form.folderId = this.currentFolder.id;
      this.open = true;
      this.title = "添加描述：文件清单管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getFileListManage(id).then(response => {
        this.form = response.data;
        if (this.form.fileUrl.length>10){
          let obj1 = {}
          let hz = this.form.fileUrl.split(".");
          obj1.name = this.form.fileName+"."+hz[hz.length-1];
          obj1.url = this.form.fileUrl;
          obj1.id = this.form.fileUrl;
          this.fileUrlArr.push(obj1);
        }
        this.open = true;
        this.title = "修改描述：文件清单管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateFileListManage(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addFileListManage(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除描述：文件清单管理编号为"' + ids + '"的数据项？').then(function() {
        return delFileListManage(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('web/fileListManage/export', {
        ...this.queryParams
      }, `fileListManage_${new Date().getTime()}.xlsx`)
    },
    /**文件上传功能*/
    //移除所选文件
    handleRemove(file, fileList) {
      this.deleteFile();
    },
    beforeUpload(file) {
      var testmsg = file.name.substring(file.name.lastIndexOf(".") + 1);
      const extension = testmsg === "pdf";
      if (!extension ) {
        this.$message({
          message: "上传文件只能是.pdf格式!",
          type: "warning",
        });
      }
      return extension;
    },
    handlePreview(file) {
      window.open(file.url)
    },
    //文件上传成功钩子
    fileSuccess(response, file, fileList) {
      if (response.code === 1) {
        let ossUrl = response.ossUrl;
        this.form.fileUrl=ossUrl;
        let isRightSize = file.size / 1024 / 1024
        this.form.fileSize = isRightSize;
        this.form.originalFileName = file.name.substring(file.name.lastIndexOf(".") + 1);
        // this.$modal.msgSuccess('文件上传成功')
      } else {
        this.$modal.msgError(response.msg)
      }
    },
    //文件上传失败钩子
    fileError(err, file, fileList) {
      this.$modal.msgSuccess("文件上传失败，请联系管理员");
      console.log(err);
    },
    /**删除上传文件*/
    deleteFile() {
      this.form.fileUrl='.';
      // fileList.splice(index, 1);
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
      this.download('/web/fileListManage/importTemplate', {}, `file_list_${new Date().getTime()}.xlsx`)
    },
    // 提交上传文件
    submitFileForm() {
      this.$refs.upload.submit();
    },
  },
};
</script>
  <style lang="scss" scoped>
  span {
    font-size: 12px;
  }

  .el-dropdown-link {
    cursor: pointer;
    color: #105aa3;
  }

  .el-icon-arrow-down {
    font-size: 12px;
  }

  .header-group {
    display: flex;
    align-items: center;
    height: 6vh;
  }

  .common-search {
    margin-left: 20px;

    padding: 12px;
    background-color: #ebebeb;
    border-radius: 4px;

    .common-input {
      margin-right: 10px;
      margin-left: 10px;
      background: none;
      outline: none;
      border: 0px;
      color: #105aa3;
    }

    .el-icon-search {
      color: #105aa3;
    }
  }

  .operation-group {
    display: flex;
    align-items: center;
    justify-content: space-between;

    background-color: #f9f9f9;

    padding: 8px;

    height: 6vh;

    //#d4603c
    .operation-left {
      display: flex;
      align-items: center;
    }
  }

  .icon-book {
    background-color: #d4603c;
    width: 50px;
    height: 50px;
    border-radius: 50px;
    padding-top: 5px;

    margin-right: 12px;

    display: flex;
    align-items: center;
    justify-content: center;

    .icon-book-img {
      width: 35px;
      height: 35px;
    }
  }

  .body-group {
    display: flex;
    // height: 200px;

    border-top: 1px solid #dfdfdf;
    border-left: 1px solid #dfdfdf;

    min-height: 88vh;

    .body-left {
      min-width: 250px;
      // height: 100%;
    }

    .body-right {
      grid-row: 1;
      width: 100%;

      .body-right-info {
        // padding: 20px;
      }
    }


    .file-header {
      display: flex;

      padding: 4px;

      background-color: #f5f5f5;

      .file-name {
        // background-color: #d4603c;
        width: 100%;
        padding-left: 10px;
      }

      .file-size {
        // background-color: #FFFF3c;
        width: 200px;
        padding-left: 10px;
      }

      .file-type {
        // background-color: #EEEEEE;
        width: 200px;
        padding-left: 10px;
      }

      .file-date {
        // background-color: #FFFF3c;
        width: 220px;
        padding-left: 10px;
      }
    }

    .icon-type {
      display: flex;
      flex-flow: row wrap;

      .file-info {
        width: 150px;

        display: flex;
        justify-content: center;
        align-items: center;

        flex-direction: column;

        border-radius: 24px;
        padding: 18px;
        margin: 5px;

        &:active {
          background-color: #cacaca !important;
        }

        .file-img {
          margin-bottom: 10px;
          height: 80px;
          width: 80px;
        }

        .file-name {
          // flex-flow: row wrap;
          // white-space:normal;
          // width:140px;
          display: flex;
          justify-content: center;

          // width:100%;
          word-wrap: break-word;
          text-overflow: ellipsis;
          overflow: hidden;

          display: -webkit-box;
          -webkit-box-orient: vertical;
          -webkit-line-clamp: 1;
          overflow: hidden;
        }
        .file-size {
          display: none;
        }

        .file-type {
          display: none;
        }

        .file-date {
          display: none;
        }
      }
    }

    .list-type {
      .file-info {
        display: flex;
        align-items: center;
        margin-bottom: 3px;

        padding: 4px;
        border-radius: 10px;

        &:hover {
          background-color: #f9f9f9 ;
        }
        &:active {
          background-color: #cacaca ;
        }

        .file-img {
          margin-left: 10px;
          width: 30px;
          height: 30px;
        }

        .file-name {
          margin-left: 10px;
          width: 100%;

          word-wrap: break-word;
          text-overflow: ellipsis;
          overflow: hidden;

          display: -webkit-box;
          -webkit-box-orient: vertical;
          -webkit-line-clamp: 1;
          overflow: hidden;

        }

        .file-size {
          width: 200px;
          padding-left: 10px;
        }

        .file-type {
          width: 200px;
          padding-left: 10px;
        }

        .file-date {
          width: 220px;
          padding-left: 10px;
        }
      }
    }

    .body-header {
      padding: 10px;

      display: flex;
      justify-content: space-between;
      align-items: center;
      height: 50px;
    }

    .border {
      border-top: 0px solid #dfdfdf;
      border-left: 0px solid #dfdfdf;
      border-right: 1px solid #dfdfdf;
      border-bottom: 1px solid #dfdfdf;
    }
  }
  .custom-tree-node {
      flex: 1;
      display: flex;
      align-items: center;
      justify-content: space-between;
      font-size: 14px;
      padding-right: 8px;
    }
  </style>
