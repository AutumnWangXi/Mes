import request from '@/utils/request'

// 查询质检模板明细列表
export function listTemplatesdtl(query) {
  return request({
    url: '/web/templatesdtl/list',
    method: 'get',
    params: query
  })
}

// 查询质检模板明细详细
export function getTemplatesdtl(id) {
  return request({
    url: '/web/templatesdtl/' + id,
    method: 'get'
  })
}

// 新增质检模板明细
export function addTemplatesdtl(data) {
  return request({
    url: '/web/templatesdtl',
    method: 'post',
    data: data
  })
}

// 修改质检模板明细
export function updateTemplatesdtl(data) {
  return request({
    url: '/web/templatesdtl',
    method: 'put',
    data: data
  })
}

// 删除质检模板明细
export function delTemplatesdtl(id) {
  return request({
    url: '/web/templatesdtl/' + id,
    method: 'delete'
  })
}
// 查询质检模板管理详情
export function getTemplatesdtlInfo(query) {
  return request({
    url: '/web/templatesdtl/getTemplatesdtl',
    method: 'get',
    params: query
  })
}
