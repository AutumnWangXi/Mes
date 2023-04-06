import request from '@/utils/request'

// 查询设备端口信息列表
export function listPort(query) {
  return request({
    url: '/web/deviceport/list',
    method: 'get',
    params: query
  })
}

// 查询设备端口信息详细
export function getPort(id) {
  return request({
    url: '/web/deviceport/' + id,
    method: 'get'
  })
}

// 新增设备端口信息
export function addPort(data) {
  return request({
    url: '/web/deviceport',
    method: 'post',
    data: data
  })
}

// 修改设备端口信息
export function updatePort(data) {
  return request({
    url: '/web/deviceport',
    method: 'put',
    data: data
  })
}

// 删除设备端口信息
export function delPort(id) {
  return request({
    url: '/web/deviceport/' + id,
    method: 'delete'
  })
}
