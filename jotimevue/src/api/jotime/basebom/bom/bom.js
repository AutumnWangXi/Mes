import request from '@/utils/request'

// 查询描述：bom管理列表
export function listBom(query) {
  return request({
    url: '/web/bom/list',
    method: 'get',
    params: query
  })
}
// 查询描述：根据物料id查询可用的bom列表
export function availableList(data) {
  return request({
    url: '/web/bom/availableList',
    method: 'post',
    data: data
  })
}



// 查询描述：bom管理详细
export function getBom(id) {
  return request({
    url: '/web/bom/info/' + id,
    method: 'get'
  })
}

// 新增描述：bom管理
export function addBom(data) {
  return request({
    url: '/web/bom/save',
    method: 'post',
    data: data
  })
}

// 修改描述：bom管理
export function updateBom(data) {
  return request({
    url: '/web/bom',
    method: 'put',
    data: data
  })
}

// 删除描述：bom管理
export function delBom(id) {
  return request({
    url: '/web/bom/' + id,
    method: 'delete'
  })
}

// 根据物料编号查询物料数据
export function selectItemByNo(itemNo, type) {
  return request({
    url: '/web/base/item/selectItemByNo/' + itemNo + '/' + type,
    method: 'get'
  })
}// 根据物料编号查询物料数据
export function selectItemByCode(itemCode, type) {
  return request({
    url: '/web/base/item/selectItemByCode/' + itemCode + '/' + type,
    method: 'get'
  })
}

// 单行保存更新
export function saveRowBomDtl(data) {
  return request({
    url: '/web/bomdtl/saveRowBomDtl',
    method: 'post',
    data: data
  })
}

// 表单保存更新
export function saveFormBomDtl(data) {
  return request({
    url: '/web/bomdtl/saveFormBomDtl',
    method: 'post',
    data: data
  })
}

// 根据物料id查询物料数据
export function selectItemById(itemId) {
  return request({
    url: '/web/base/item/selectItemById/' + itemId,
    method: 'get'
  })
}

// 查询bom明细
export function selectBomDtlsGroupByItemType(bomId) {
  return request({
    url: '/web/bomdtl/selectBomDtlsGroupByItemType/' + bomId,
    method: 'get'
  })
}

// 查询bom明细
export function selectBomDtlsByItemId(itemId) {
  return request({
    url: '/web/bomdtl/selectBomDtlsByItemId/' + itemId,
    method: 'get'
  })
}

// 查询所有的打样单
export function listAllTask() {
  return request({
    url: '/web/formulatask/listAll',
    method: 'get'
  })
}

// 查询所有的客户
export function selectAllCustomer() {
  return request({
    url: '/web/base/customers/selectAllCustomer',
    method: 'get'
  })
}

// 查询所有的部门
export function selectDeptList() {
  return request({
    url: '/system/dept/list',
    method: 'get'
  })
}

// 根据部门查询车间
export function selectAllByDeptId(deptId) {
  return request({
    url: '/web/base/workshop/selectAllByDeptId/' + deptId,
    method: 'get'
  })
}

// 统计配方
export function researchAndDevelopmentOfStatistical(data) {
  return request({
    url: '/web/bom/researchAndDevelopmentOfStatistical',
    method: 'post',
    data: data
  })
}

// 新增
export function addPhaseTwoBom(data) {
  return request({
    url: '/web/bom/addPhaseTwoBom',
    method: 'post',
    data: data
  })
}

// 新增
export function editPhaseTwoBom(data) {
  return request({
    url: '/web/bom/editPhaseTwoBom',
    method: 'post',
    data: data
  })
}

// 查询编号
export function list(type) {
  return request({
    url: '/web/base/item/selectItemName'+'/'+type,
    method: 'get'
  })
}

// 查询编号
export function selectItemDataByItemType(data) {
  return request({
    url: '/web/base/item/selectItemDataByItemType',
    method: 'Post',
    data: data
  })
}

export function record(data){
  axios({
    method: "POST",
    url: "/web/record/getRecord",
    data: data,
    responseType: "blob"
  })
    .then(response => {
      let blob = new Blob([response.data], { type: "application/zip" });
      let url = window.URL.createObjectURL(blob);
      const link = document.createElement("a"); // 创建a标签
      link.href = url;
      link.download = "code"; // 重命名文件
      link.click();
      URL.revokeObjectURL(url); // 释放内存
    })
    .catch(error => this.$message.error(error));
  // return request({
  //   url: '/web/record/getRecord',
  //   method: 'post',
  //   data: data,
  //   responseType:'blob'
  // })
}

// 查询描述：bom管理列表
export function getFilings(query) {
  return request({
    url: '/web/bom/getFilings',
    method: 'get',
    params: query
  })
}

