import request from '@/utils/request'

// 查询设备工艺参数列表
export function listDevicepp(query) {
  return request({
    url: '/web/devicepp/list',
    method: 'get',
    params: query
  })
}
// 查询设备工艺参数列表
export function listDeviceppVo(query) {
  return request({
    url: '/web/devicepp/listVo',
    method: 'get',
    params: query
  })
}
// 查询设备工艺参数详细
export function getDevicepp(id) {
  return request({
    url: '/web/devicepp/' + id,
    method: 'get'
  })
}

// 新增设备工艺参数
export function addDevicepp(data) {
  return request({
    url: '/web/devicepp',
    method: 'post',
    data: data
  })
}
// 新增设备工艺参数
export function addDeviceppAndDtl(data) {
  return request({
    url: '/web/devicepp/addDeviceppAndDtl',
    method: 'post',
    data: data
  })
}
// 修改设备工艺参数
export function updateDevicepp(data) {
  return request({
    url: '/web/devicepp',
    method: 'put',
    data: data
  })
}

// 删除设备工艺参数
export function delDevicepp(id) {
  return request({
    url: '/web/devicepp/' + id,
    method: 'delete'
  })
}
