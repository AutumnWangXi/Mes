import request from '@/utils/request'

// 查询实际工艺参数列表
export function listactualProcessparm(query) {
  return request({
    url: '/web/actualProcessparm/list',
    method: 'get',
    params: query
  })
}

// 查询实际工艺参数详细
export function getactualProcessparm(id) {
  return request({
    url: '/web/actualProcessparm/' + id,
    method: 'get'
  })
}

// 新增实际工艺参数
export function addactualProcessparm(data) {
  return request({
    url: '/web/actualProcessparm',
    method: 'post',
    data: data
  })
}

// 修改实际工艺参数
export function updateactualProcessparm(data) {
  return request({
    url: '/web/actualProcessparm',
    method: 'put',
    data: data
  })
}

// 删除实际工艺参数
export function delactualProcessparm(id) {
  return request({
    url: '/web/actualProcessparm/' + id,
    method: 'delete'
  })
}
