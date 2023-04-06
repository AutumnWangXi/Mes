<template>
  <div>
    <el-dialog :visible.sync="dialog.visible" :fullscreen="true" :modal="false">
    <!-- :onerror="dialog.url" -->
    <!-- <img width="100%" :src="dialog.url"  alt="" /> -->

      <!-- <img  width="100%" :src="item.fileUrl"  alt="" /> -->

        <iframe v-if="item.fileType == 'pdf'"  ref="mainiframe" :src="item.fileUrl" style="height:90vh;width:100%" ></iframe>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "filepre",
  data() {
    return {
        item:{
        //     {
        //   name: "公司动态video",
        //   fileType: "video", //folder excel doc pdf ppt img video 如果还需要其他类型自行扩展
        //   icon: "",
        //   img: "https://img0.baidu.com/it/u=715279512,2555508937&fm=253&fmt=auto&app=138&f=PNG?w=500&h=706",
        //   size: '150kb',
        //   createDate: '2022-08-19',
        // }
        },
      dialog: {
        visible: false,
      },
    };
  },
  props: ["value", "limit", "size"],
  computed: {},
  watch: {},

  methods: {
    show(item){
        item.fileUrl='http://jotim-test.oss-cn-hangzhou.aliyuncs.com/file/list/2022/0822/c3aeec9cd2ec487d9a-工作总结计划表.pdf?response-content-type=application/pdf';
        this.item = item;
        this.dialog.visible = true;
    },
  },
};
</script>

<style scoped>
</style>
