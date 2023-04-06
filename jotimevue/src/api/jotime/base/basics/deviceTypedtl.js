import request from '@/utils/request'

// 查询设备类型详细列表
export function listDeviceTypedtl(query) {
  return request({
    url: '/web/deviceTypedtl/list',
    method: 'get',
    params: query
  })
}

// 查询设备类型详细详细
export function getDeviceTypedtl(id) {
  return request({
    url: '/web/deviceTypedtl/' + id,
    method: 'get'
  })
}

// 新增设备类型详细
export function addDeviceTypedtl(data) {
  return request({
    url: '/web/deviceTypedtl',
    method: 'post',
    data: data
  })
}

// 修改设备类型详细
export function updateDeviceTypedtl(data) {
  return request({
    url: '/web/deviceTypedtl',
    method: 'put',
    data: data
  })
}

// 删除设备类型详细
export function delDeviceTypedtl(id) {
  return request({
    url: '/web/deviceTypedtl/' + id,
    method: 'delete'
  })
}
