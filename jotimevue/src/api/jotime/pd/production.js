import request from '@/utils/request'
// 总生产任务单列表
export function productionList(query) {
  return request({
    url: '/web/order/dataList',
    method: 'get',
    params: query
  })
}

export function filterDataList(query) {
  return request({
    url: '/web/order/filterDataList',
    method: 'get',
    params: query
  })
}

// 订单排产选择
export function productionOption (data) {
  return request({
    url:'/web/order/scheduleProductionChoose',
    method: 'post',
    data: data
  })
}

// 订单排产提交接口
export function productionSubmit (data) {
  return request({
    url:'/web/order/scheduleProduction',
    method: 'put',
    data: data
  })
}

// 车间查询
export function workShop (data) {
  return request({
    url:'/web/base/workshop/dataList',
    method: 'get',
    data: data
  })
}

// 已排产数量
export function scheduPdQty (data) {
  return request({
    url:'/web/pd/whordertask/getScheduledCount',
    method: 'post',
    data: data
  })
}
// bom数据查询
export function getBomNoData (orderNo) {
  return request({
    url:'/common/pd/order/getBomNoData/' + orderNo,
    method: 'get',
  })
}
