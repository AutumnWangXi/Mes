import request from '@/utils/request'

// 查询质检任务管理列表
export function listTask(query) {
  return request({
    url: '/web/task/list',
    method: 'get',
    params: query
  })
}
// 查询质检任务管理列表
export function getlist(query) {
  return request({
    url: '/web/task/getlist',
    method: 'get',
    params: query
  })
}


// 查询质检任务管理详细
export function getTask(id) {
  return request({
    url: '/web/task/' + id,
    method: 'get'
  })
}

// 新增质检任务管理
export function addTask(data) {
  return request({
    url: '/web/task',
    method: 'post',
    data: data
  })
}

// 修改质检任务管理
export function updateTask(data) {
  return request({
    url: '/web/task',
    method: 'put',
    data: data
  })
}

// 删除质检任务管理
export function delTask(id) {
  return request({
    url: '/web/task/' + id,
    method: 'delete'
  })
}
// 获取部门列表
export function selectDept(parent_id) {
  return request({
    url: '/system/dept/selectDept/'+parent_id,
    method: 'Get'
  })
}

// 下载质检结果
export function exportExcel(testId) {
  return request({
    url: '/oss/qc/exportExcel',
    method: 'post',
    data: testId
  })
}
//获取未处理完成的质检数量
export function getListSize(query) {
  return request({
    url: '/web/task/getListSize',
    method: 'get',
    params: query
  })
}

//免检
export function exemptionFromInspection(query) {
  return request({
    url: '/web/task/exemptionFromInspection',
    method: 'post',
    params: query
  })
}

//查询质检列表
export function getQcTaskList(query) {
  return request({
    url: '/web/task/getQcTaskList',
    method: 'post',
    params: query
  })
}

//查询质检列表
export function getTaskInfo(query) {
  return request({
    url: '/web/task/getTaskInfo',
    method: 'post',
    params: query
  })
}



