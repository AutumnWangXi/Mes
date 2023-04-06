import request from '@/utils/request'

// 查询车间生产任务列表
export function listOrdertask(query) {
  return request({
    url: '/web/pd/ordertask/list',
    method: 'get',
    params: query
  })
}
// 查询车间生产任务列表
export function getWkshOrdertaskList(query) {
  return request({
    url: '/web/pd/whordertask/list',
    method: 'get',
    params: query
  })
}

//-车间排班到班组列表
export function productionList(data) {
  return request({
    url: '/web/pd/whordertask/dataList',
    method: 'get',
    params: data
  })
}
// 查询车间生产任务详细
export function getOrdertask(id) {
  return request({
    url: '/web/pd/whordertask/' + id,
    method: 'get'
  })
}

// 新增车间生产任务
export function addOrdertask(data) {
  return request({
    url: '/web/pd/whordertask',
    method: 'post',
    data: data
  })
}

// 修改车间生产任务
export function updateOrdertask(data) {
  return request({
    url: '/web/pd/whordertask',
    method: 'put',
    data: data
  })
}

// 删除车间生产任务
export function delOrdertask(id) {
  return request({
    url: '/web/pd/whordertask/' + id,
    method: 'delete'
  })
}

// 删除车间生产任务
export function showDetails(wkshOrdertaskId) {
  return request({
    url: '/web/pd/whordertask/showDetails/' + wkshOrdertaskId,
    method: 'get'
  })
}

// 关闭车间生产任务
export function closeWkshOrderTask(wkshOrdertaskId) {
  return request({
    url: '/web/pd/whordertask/closeWkshOrderTask/' + wkshOrdertaskId,
    method: 'put'
  })
}

/**
 * 生产任务分配(添加车间任务)
 * @param pdOrderTaskList
 * @returns {AxiosPromise}
 */
export function addWkshOrdertaskList(pdOrderTaskList) {
  return request({
    url: '/web/pd/whordertask/addWkshOrdertaskList',
    method: 'post',
    data:pdOrderTaskList
  })
}
