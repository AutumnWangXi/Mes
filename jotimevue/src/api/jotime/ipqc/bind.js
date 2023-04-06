import request from '@/utils/request'

// 查询物料巡检列表
export function listBind(query) {
  return request({
    url: '/web/bind/list',
    method: 'get',
    params: query
  })
}

// 查询物料巡检详细
export function getBind(id) {
  return request({
    url: '/web/bind/' + id,
    method: 'get'
  })
}

// 新增物料巡检
export function addBind(data) {
  return request({
    url: '/web/bind',
    method: 'post',
    data: data
  })
}

// 修改物料巡检
export function updateBind(data) {
  return request({
    url: '/web/bind',
    method: 'put',
    data: data
  })
}

// 删除物料巡检
export function delBind(id) {
  return request({
    url: '/web/bind/' + id,
    method: 'delete'
  })
}
