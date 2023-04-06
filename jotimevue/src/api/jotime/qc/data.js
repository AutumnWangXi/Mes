import request from '@/utils/request'

// 查询质检记录明细列表
export function listData(query) {
  return request({
    url: '/web/data/list',
    method: 'get',
    params: query
  })
}

// 查询质检记录明细详细
export function getData(id) {
  return request({
    url: '/web/data/' + id,
    method: 'get'
  })
}

// 新增质检记录明细
export function addData(data) {
  return request({
    url: '/web/data',
    method: 'post',
    data: data
  })
}

// 修改质检记录明细
export function updateData(data) {
  return request({
    url: '/web/data',
    method: 'put',
    data: data
  })
}

// 删除质检记录明细
export function delData(id) {
  return request({
    url: '/web/data/' + id,
    method: 'delete'
  })
}
