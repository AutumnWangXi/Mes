import request from '@/utils/request'

// 查询安全性风险物质危害识别列表
export function listSubstances(query) {
  return request({
    url: '/web/substances/list',
    method: 'get',
    params: query
  })
}

// 查询安全性风险物质危害识别详细
export function getSubstances(id) {
  return request({
    url: '/web/substances/' + id,
    method: 'get'
  })
}

// 新增安全性风险物质危害识别
export function addSubstances(data) {
  return request({
    url: '/web/substances',
    method: 'post',
    data: data
  })
}

// 修改安全性风险物质危害识别
export function updateSubstances(data) {
  return request({
    url: '/web/substances',
    method: 'put',
    data: data
  })
}

// 删除安全性风险物质危害识别
export function delSubstances(id) {
  return request({
    url: '/web/substances/' + id,
    method: 'delete'
  })
}
