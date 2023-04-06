import request from '@/utils/request'

// 查询生产设备列表
export function listOrderdevice(query) {
  return request({
    url: '/web/orderdevice/list',
    method: 'get',
    params: query
  })
}

// 查询生产设备详细
export function getOrderdevice(id) {
  return request({
    url: '/web/orderdevice/' + id,
    method: 'get'
  })
}

// 新增生产设备
export function addOrderdevice(data) {
  return request({
    url: '/web/orderdevice',
    method: 'post',
    data: data
  })
}
// 新增生产设备
export function addOrderdeviceList(data) {
  return request({
    url: '/web/orderdevice/addOrderdeviceList',
    method: 'post',
    data: data
  })
}

// 修改生产设备
export function updateOrderdevice(data) {
  return request({
    url: '/web/orderdevice',
    method: 'put',
    data: data
  })
}

// 删除生产设备
export function delOrderdevice(id) {
  return request({
    url: '/web/orderdevice/' + id,
    method: 'delete'
  })
}
