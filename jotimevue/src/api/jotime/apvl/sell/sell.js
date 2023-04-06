import request from '@/utils/request'

// 查询描述：销售申请列表
export function listSell(query) {
  return request({
    url: '/web/apvl/sell/list',
    method: 'get',
    params: query
  })
}

// 查询描述：销售申请详细
export function getSell(id) {
  return request({
    url: '/web/apvl/sell/' + id,
    method: 'get'
  })
}

// 新增描述：销售申请
export function addSell(data) {
  return request({
    url: '/web/apvl/sell',
    method: 'post',
    data: data
  })
}

// 修改描述：销售申请
export function updateSell(data) {
  return request({
    url: '/web/apvl/sell',
    method: 'put',
    data: data
  })
}

// 删除描述：销售申请
export function delSell(id) {
  return request({
    url: '/web/apvl/sell/' + id,
    method: 'delete'
  })
}

//客户查询
export function getCustomersData(query) {
  return request({
    url: '/web/contract/getCustomersData',
    method: 'post',
    data: query
  })
}
