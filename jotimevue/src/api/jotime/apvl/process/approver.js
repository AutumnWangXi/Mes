import request from '@/utils/request'

// 查询审批人员列表
export function listApprover(query) {
  return request({
    url: '/web/apvl/approver/list',
    method: 'get',
    params: query
  })
}

// 查询审批人员详细
export function getApprover(id) {
  return request({
    url: '/web/apvl/approver/' + id,
    method: 'get'
  })
}



// 新增审批人员
export function addApprover(data) {
  return request({
    url: '/web/apvl/approver',
    method: 'post',
    data: data
  })
}

// 修改审批人员
export function updateApprover(data) {
  return request({
    url: '/web/apvl/approver',
    method: 'put',
    data: data
  })
}

// 删除审批人员
export function delApprover(id) {
  return request({
    url: '/web/apvl/approver/' + id,
    method: 'delete'
  })
}
