import request from '@/utils/request'

// 查询班组生产任务列表
export function listOrdertask(query) {
  return request({
    url: '/web/pd/ordertask/dataList',
    method: 'get',
    params: query
  })
}
export function selectPdGroupOrdertaskList() {
  return request({
    url: '/web/pd/ordertask/selectPdGroupOrdertaskList',
    method: 'get',
  })
}

// 查询班组生产任务详细
export function getOrdertask(id) {
  return request({
    url: '/web/pd/ordertask/' + id,
    method: 'get'
  })
}
// 查询班组生产任务详细，根据编号
export function getOrdertaskByNo(gpOrdertaskNo) {
  return request({
    url: '/web/pd/ordertask/getOrdertaskByNo/' + gpOrdertaskNo,
    method: 'get'
  })
}
// 新增班组生产任务
export function addOrdertask(data) {
  return request({
    url: '/web/pd/ordertask',
    method: 'post',
    data: data
  })
}

// 修改班组生产任务
export function updateOrdertask(data) {
  return request({
    url: '/web/pd/ordertask',
    method: 'put',
    data: data
  })
}
// 修改生产订单表
export function updatePdOrderTask(data) {
  return request({
    url: '/web/ordertask',
    method: 'put',
    data: data
  })
}



// 删除班组生产任务
export function delOrdertask(id) {
  return request({
    url: '/web/pd/ordertask/' + id,
    method: 'delete'
  })
}

// 关闭班组生产任务
export function closeOrderTask(id) {
  return request({
    url: '/web/pd/ordertask/closeOrderTask/' + id,
    method: 'PUT'
  })
}

//查询全部流水线
export function lineList() {
  return request({
    url: '/web/line/lineList',
    method: 'get'
  })
}

//查询全部流水线
export function itemTraceSourceList(param) {
  return request({
    url: '/web/pd/ordertask/itemTraceSourceList',
    method: 'get',
    params: param
  })
}

// 查询班组任务列表
export function getOrderTaskList (data) {
  return request({
    url:'/web/pd/ordertask/list',
    method: 'get',
    params: data
  })
}


// 查询生产任务明细表
export function getOrderTaskDtlList (data) {
  return request({
    url:'/web/pd/ordertaskdtl/listAll',
    method: 'get',
    params: data
  })
}

// 添加成品质检任务
export function addFinishedQc(data) {
  return request({
    url: '/web/pd/ordertask/addFinishedQc',
    method: 'post',
    data: data
  })
}


// 查询生产任务列表
export function listPdOrdertask(query) {
  return request({
    url: '/web/ordertask/list',
    method: 'get',
    params: query
  })
}

// 查询生产任务详细
export function getPdOrdertask(id) {
  return request({
    url: '/web/ordertask/' + id,
    method: 'get'
  })
}

// 新增生产任务
export function addPdOrdertask(data) {
  return request({
    url: '/web/ordertask',
    method: 'post',
    data: data
  })
}

// 修改生产任务
export function updatePdOrdertask(data) {
  return request({
    url: '/web/ordertask',
    method: 'put',
    data: data
  })
}

// 删除生产任务
export function delPdOrdertask(id) {
  return request({
    url: '/web/ordertask/' + id,
    method: 'delete'
  })
}
// 根据车间任务编号获取计划生产任务
export function getPdOrdertaskList(data) {
  return request({
    url: '/web/ordertask/orderTasklist',
    method: 'post',
    data: data
  })
}

