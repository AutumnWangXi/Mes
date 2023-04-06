import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listPallet(query) {
  return request({
    url: '/web/pallet/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getPallet(id) {
  return request({
    url: '/web/pallet/' + id,
    method: 'get'
  })
}

// 查询物料内码
export function getItemCodes() {
  return request({
    url: '/web/purchase/getItemCodes',
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addPallet(data) {
  return request({
    url: '/web/pallet',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updatePallet(data) {
  return request({
    url: '/web/pallet',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delPallet(id) {
  return request({
    url: '/web/pallet/' + id,
    method: 'delete'
  })
}
