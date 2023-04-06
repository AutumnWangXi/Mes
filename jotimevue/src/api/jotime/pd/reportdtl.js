import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listReportdtl(query) {
  return request({
    url: '/web/pd/reportdtl/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getReportdtl(id) {
  return request({
    url: '/web/pd/reportdtl/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addReportdtl(data) {
  return request({
    url: '/web/pd/reportdtl',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateReportdtl(data) {
  return request({
    url: '/web/pd/reportdtl',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delReportdtl(id) {
  return request({
    url: '/web/pd/reportdtl/' + id,
    method: 'delete'
  })
}
