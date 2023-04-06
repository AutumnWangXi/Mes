import request from '@/utils/request'

// 查询巡检记录明细列表
export function listData(query) {
  return request({
    url: '/web/ipqcdata/list',
    method: 'get',
    params: query
  })
}

// 查询巡检记录明细详细
export function getData(id) {
  return request({
    url: '/web/ipqcdata/' + id,
    method: 'get'
  })
}

// 新增巡检记录明细
export function addData(data) {
  return request({
    url: '/web/ipqcdata',
    method: 'post',
    data: data
  })
}

// 修改巡检记录明细
export function updateData(data) {
  return request({
    url: '/web/ipqcdata',
    method: 'put',
    data: data
  })
}

// 删除巡检记录明细
export function delData(id) {
  return request({
    url: '/web/ipqcdata/' + id,
    method: 'delete'
  })
}
