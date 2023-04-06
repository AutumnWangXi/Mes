import request from '@/utils/request'

// 查询订单审批
export function getOrderAudit(query) {
  return request({
    url: '/web/order/productionApprovalList',
    method: 'get',
    params: query
  })
}

// 详情
export function bomInfo(query) {
  return request({
    url: '/web/bom/orderAudit/bomInfo',
    method: 'post',
    data: query
  })
}

// 详情中的配方物料
export function bomItemInfo(query) {
  return request({
    url: '/web/bom/orderAudit/formulaMaterialList',
    method: 'post',
    data: query
  })
}

// 审批
export function reviewOrder(data) {
  return request({
    url: '/web/order/reviewOrder',
    method: 'post',
    data: data
  })
}

// 物料清单
export function billOfMaterials(query) {
  return request({
    url: '/web/order/billOfMaterials',
    method: 'get',
    params: query
  })
}

// 物料清单
export function allProcess(data) {
  return request({
    url: '/web/pd/process/allProcess',
    method: 'post',
    data: data
  })
}

