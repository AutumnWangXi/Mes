import request from '@/utils/request'

// 查询描述：工艺参数列表
export function listProcessparm(query) {
  return request({
    url: '/web/processparm/list',
    method: 'get',
    params: query
  })
}

// 查询描述：工艺参数详细
export function getProcessparm(id) {
  return request({
    url: '/web/processparm/' + id,
    method: 'get'
  })
}

// 新增描述：工艺参数
export function addProcessparm(data) {
  return request({
    url: '/web/processparm',
    method: 'post',
    data: data
  })
}

// 修改描述：工艺参数
export function updateProcessparm(data) {
  return request({
    url: '/web/processparm',
    method: 'put',
    data: data
  })
}

// 删除描述：工艺参数
export function delBomDtl(data) {
  return request({
    url: '/web/bomdtl/deleteBomDtl',
    method: 'post',
    data: data
  })
}

// 查询所有步骤下所有数据
export function allDataInTheCurrentStep(data) {
  return request({
    url: '/web/bom/allcurProcess',
    method: 'post',
    data: data
  })
}
// 查询所有步骤下所有数据
export function allDataInTheStep(data) {
  return request({
    url: '/web/bom/allProcess',
    method: 'post',
    data: data
  })
}
// 查询当前步骤下所有数据
export function selectInfo(data) {
  return request({
    url: '/web/processBom/stepProcess',
    method: 'post',
    data: data
  })
}
// 查询所有步骤下所有数据
export function selectAllInfo(data) {
  return request({
    url: '/web/processBom/selectAllInfo',
    method: 'post',
    data: data
  })
}

// 批量保存bom
export function saveProcessInfo(data) {
  return request({
    url: '/web/processBom/saveBomProcesses',
    method: 'Post',
    data: data
  })
}

// 批量保存bom
export function addProcessInfo(data) {
  return request({
    url: '/web/processBom/addBomProcesses',
    method: 'Post',
    data: data
  })
}

// 批量保存工艺
export function saveProcessparm(data) {
  return request({
    url: '/web/processBom/saveprocessparam',
    method: 'Post',
    data: data
  })
}// 批量保存投料
export function saveBomFeeding(data) {
  return request({
    url: '/web/feeding/savefeeding',
    method: 'Post',
    data: data
  })
}

//批量删除工艺
export function deleteProcessparm(data) {
  return request({
    url: '/web/processparm/deleteProcessparm',
    method: 'Post',
    data: data
  })
}

//批量删除投料
export function deleteFeedingFeeding(id) {
  return request({
    url: '/web/feeding/' + id,
    method: 'Delete'
  })
}

//查询所有物料
export function selectAllItem() {
  return request({
    url: '/web/base/item/selectItem',
    method: 'post'
  })
}

//查询所有设备
export function deviceListAll(query) {
  return request({
    url: '/web/base/device/listAll',
    method: 'get',
    params: query
  })
}

//查询所有设备类型
export function availableList() {
  return request({
    url: '/web/deviceType/availableList',
    method: 'get'
  })
}
//查询所有设备类型
export function deviceTypedtl(deviceType) {
  return request({
    url: '/web/deviceTypedtl/detailedList/'+deviceType,
    method: 'get'
  })
}
//查询步骤投料信息
export function getProcessFeeding(processstepId) {
  return request({
    url: '/web/feeding/processfeeding' + processstepId,
    method: 'get'
  })
}
// 查询配方步骤
export function getBomStep(data) {
  return request({
    url: '/web/bom/bomstep',
    method: 'post',
    data: data
  })
}
// 总览步骤确认按钮
export function savealldata(data) {
  return request({
    url: '/web/bom/savealldata',
    method: 'post',
    data: data
  })
}

//查询所有物料
export function getParamInfo(processId) {
  return request({
    url: '/web/processparm/paramInfo/' + processId,
    method: 'get'
  })
}
