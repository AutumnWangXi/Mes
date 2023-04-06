import request from '@/utils/request'

// 查询物料箱基础列表
export function listMaterialbox(query) {
  return request({
    url: '/web/base/materialbox/list',
    method: 'get',
    params: query
  })
}

// 查询物料箱基础详细
export function getMaterialbox(id) {
  return request({
    url: '/web/base/materialbox/' + id,
    method: 'get'
  })
}

// 新增物料箱基础
export function addMaterialbox(data) {
  return request({
    url: '/web/base/materialbox',
    method: 'post',
    data: data
  })
}

// 修改物料箱基础
export function updateMaterialbox(data) {
  return request({
    url: '/web/base/materialbox',
    method: 'put',
    data: data
  })
}

// 删除物料箱基础
export function delMaterialbox(id) {
  return request({
    url: '/web/base/materialbox/' + id,
    method: 'delete'
  })
}
