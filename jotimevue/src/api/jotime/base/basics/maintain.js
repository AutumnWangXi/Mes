import request from '@/utils/request'
// 查询设备保养信息列表
export function listMaintaininfo(query) {
  return request({
    url: '/web/base/maintain/list',
    method: 'get',
    params: query
  })
}

// 查询设备保养信息详细
export function getMaintaininfo(baseDeviceMaintaininfo) {
  return request({
    url: '/web/base/maintain/' + baseDeviceMaintaininfo,
    method: 'get'
  })
}

// 新增设备保养信息
export function addMaintaininfo(data) {
  return request({
    url: '/web/base/maintain',
    method: 'post',
    data: data
  })
}

// 修改设备保养信息
export function updateMaintaininfo(data) {
  return request({
    url: '/web/base/maintain',
    method: 'put',
    data: data
  })
}

// 删除设备保养信息
export function delMaintaininfo(baseDeviceMaintaininfo) {
  return request({
    url: '/web/base/maintain/' + baseDeviceMaintaininfo,
    method: 'delete'
  })
}
