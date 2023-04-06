import request from '@/utils/request'

// 查询编码规则当前值列表
export function listRulevalue(query) {
  return request({
    url: '/web/base/rulevalue/list',
    method: 'get',
    params: query
  })
}

// 查询编码规则当前值详细
export function getRulevalue(id) {
  return request({
    url: '/web/base/rulevalue/' + id,
    method: 'get'
  })
}

// 新增编码规则当前值
export function addRulevalue(data) {
  return request({
    url: '/web/base/rulevalue',
    method: 'post',
    data: data
  })
}

// 修改编码规则当前值
export function updateRulevalue(data) {
  return request({
    url: '/web/base/rulevalue',
    method: 'put',
    data: data
  })
}

// 删除编码规则当前值
export function delRulevalue(id) {
  return request({
    url: '/web/base/rulevalue/' + id,
    method: 'delete'
  })
}
