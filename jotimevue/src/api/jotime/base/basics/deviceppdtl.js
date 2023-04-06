import request from '@/utils/request'

// 查询设备工艺参数列表
export function listDeviceppdtl(query) {
  return request({
    url: '/web/deviceppdtl/list',
    method: 'get',
    params: query
  })
}
// 查询设备工艺参数列表
export function listDeviceppdtlVo(query) {
  return request({
    url: '/web/deviceppdtl/listVo',
    method: 'get',
    params: query
  })
}
// 查询设备工艺参数详细
export function getDeviceppdtl(id) {
  return request({
    url: '/web/deviceppdtl/' + id,
    method: 'get'
  })
}

// 新增设备工艺参数
export function addDeviceppdtl(data) {
  return request({
    url: '/web/deviceppdtl',
    method: 'post',
    data: data
  })
}

// 修改设备工艺参数
export function updateDeviceppdtl(data) {
  return request({
    url: '/web/deviceppdtl',
    method: 'put',
    data: data
  })
}

// 删除设备工艺参数
export function delDeviceppdtl(id) {
  return request({
    url: '/web/deviceppdtl/' + id,
    method: 'delete'
  })
}

// 查询设备工艺参数全部列表
export function allList(query) {
  return request({
    url: '/web/deviceppdtl/listall',
    method: 'get',
    params: query
  })
}
