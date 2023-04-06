import request from '@/utils/request'

// 查询订单信息
export function listWorkinfoOrder(query) {
  return request({
    url: '/pd/jotime/workinfo/order/list',
    method: 'get',
    params: query
  })
}

// 查询用户信息
export function listWorkinfoUser(query) {
  return request({
    url: '/pd/jotime/workinfo/user/list',
    method: 'get',
    params: query
  })
}

// 查询产品信息
export function listWorkinfoItem(query) {
  return request({
    url: '/pd/jotime/workinfo/item/list',
    method: 'get',
    params: query
  })
}

//订单费用详情
export function getSalaryDetails(data) {
  return request({
    url: '/pd/jotime/workinfo/selectSalaryDetails',
    method: 'post',
    data: data
  })
}

//人员费用详情
export function getUserSalaryDetails(data) {
  return request({
    url: '/pd/jotime/workinfo/selectUserSalaryDetails',
    method: 'post',
    data: data
  })
}

//产品费用详情
export function getItemSalaryDetails(data) {
  return request({
    url: '/pd/jotime/workinfo/selectItemSalaryDetails',
    method: 'post',
    data: data
  })
}
