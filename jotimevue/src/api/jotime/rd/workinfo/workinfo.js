import request from '@/utils/request'

// 查询研发人员工作信息列表
export function listWorkinfo(query) {
  return request({
    url: '/web/workinfo/list',
    method: 'Post',
    params: query
  })
}

// 查询研发人员工作信息详细
export function getWorkinfo(id) {
  return request({
    url: '/web/workinfo/' + id,
    method: 'get'
  })
}

// 新增研发人员工作信息
export function addWorkinfo(data) {
  return request({
    url: '/web/workinfo',
    method: 'post',
    data: data
  })
}

// 删除研发人员工作信息
export function delWorkinfo(id) {
  return request({
    url: '/web/workinfo/' + id,
    method: 'delete'
  })
}

// 删除研发人员工作信息
export function saveWorkInfoStatus(data) {
  return request({
    url: '/web/workinfo/updateWorkInfoStatus',
    method: 'Post',
    data: data
  })
}

// 转让配方任务
export function saveTransfer(data) {
  return request({
    url: '/web/workinfo/transferwork',
    method: 'Post',
    data: data
  })
}
// 修改研发人员工作状态
export function saveStartWork(data) {
  return request({
    url: '/web/workinfo/startworkinfo',
    method: 'Post',
    data: data
  })
}
// 保存工作进度
export function saveWorkProgress(data) {
  return request({
    url: '/web/workinfo/workprogress',
    method: 'Post',
    data: data
  })
}
// 取得转让工单关联信息
export function selTransferWorkInfo(dataId) {
  return request({
    url: '/web/workinfo/transferworklist/' + dataId,
    method: 'Get',
  })
}
// 修改个人打样单状态(取消)
export function updateTaskCancel(data) {
  return request({
    url: '/web/workinfo/taskcancel',
    method: 'Post',
    data: data
  })
}
