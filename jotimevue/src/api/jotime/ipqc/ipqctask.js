import request from '@/utils/request'

// 查询巡检任务管理列表
export function listIpqcTask(query) {
  return request({
    url: '/web/ipqctask/list',
    method: 'get',
    params: query
  })
}

// 查询巡检任务管理详细
export function getIpqcTask(id) {
  return request({
    url: '/web/ipqctask/' + id,
    method: 'get'
  })
}

// 新增巡检任务管理
export function addIpqcTask(data) {
  return request({
    url: '/web/ipqctask',
    method: 'post',
    data: data
  })
}

// 修改巡检任务管理
export function updateIpqcTask(data) {
  return request({
    url: '/web/ipqctask',
    method: 'put',
    data: data
  })
}

// 删除巡检任务管理
export function delIpqcTask(id) {
  return request({
    url: '/web/ipqctask/' + id,
    method: 'delete'
  })
}
