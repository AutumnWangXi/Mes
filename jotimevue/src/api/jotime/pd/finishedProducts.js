import request from '@/utils/request'
//-车间排班到班组列表
export function productionList(data) {
  return request({
    url: '/web/pd/whordertask/dataList',
    method: 'get',
    params: data
  })
}
//-查询可生产数量
export function calculateProductionQuantity(whordertaskNo) {
  return request({
    url: '/web/pd/whordertask/calculateProductionQuantity/' + whordertaskNo,
    method: 'get',
  })
}
//-车间排班到班组列表
export function filterDataList(data) {
  return request({
    url: '/web/pd/whordertask/filterDataList',
    method: 'get',
    params: data
  })
}
// 车间排班到班组提交接口，提交格式与订单排班到车间相同
export function productionSubmit (data) {
  return request({
    url:'/web/pd/whordertask/scheduleWorkShopChoose',
    method: 'put',
    data: data
  })
}

//-车间到班组查询
export function productionOpen(workShopId) {
  return request({
    url: '/admin/group/getWorkGroupList/'+workShopId,
    method: 'get',
  })
}
//选择数据弹出弹窗
export function prodOpenData(orderNo) {
  return request({
    url: '/web/pd/whordertask/getCommonData',
    method: 'get',
    params: orderNo
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

// 车间列表
export function workShopList (data) {
  return request({
    url:'/web/pd/whordertask/getTheNumberOfWorkshopTasks',
    method: 'get',
    params: data
  })
}

// 车间排班到班组提交接口，提交格式与订单排班到车间相同
export function submitShowDetails (data) {
  return request({
    url:'/web/pd/whordertask/submitShowDetails',
    method: 'post',
    data: data
  })
}
