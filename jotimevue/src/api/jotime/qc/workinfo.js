import request from '@/utils/request'

// 查询质检人员工作信息列表
export function listWorkinfo(query) {
  return request({
    url: '/web/qcworkinfo/list',
    method: 'get',
    params: query
  })
}

// 查询质检人员工作信息详细
export function getWorkinfo(id) {
  return request({
    url: '/web/qcworkinfo/' + id,
    method: 'get'
  })
}

// 新增质检人员工作信息
export function addWorkinfo(data) {
  return request({
    url: '/web/qcworkinfo',
    method: 'post',
    data: data
  })
}

// 修改质检人员工作信息
export function updateWorkinfo(data) {
  return request({
    url: '/web/qcworkinfo',
    method: 'put',
    data: data
  })
}
// 修改质检人员工作信息（领取质检任务）
export function receiveQcTask(data) {
  return request({
    url: '/web/qcworkinfo/receiveQcTask',
    method: 'put',
    data: data
  })
}

// 删除质检人员工作信息
export function delWorkinfo(id) {
  return request({
    url: '/web/qcworkinfo/' + id,
    method: 'delete'
  })
}
// 转让质检任务
export function transferTask(data) {
  return request({
    url: '/web/qcworkinfo/transferTask',
    method: 'put',
    data: data
  })
}
