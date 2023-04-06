import request from '@/utils/request'

//  查询生产订单共通信息
export function getPdOrderCommonInfo(query) {
  return request({
    url: '/common/pd/order',
    method: 'post',
    params: query
  })
}
