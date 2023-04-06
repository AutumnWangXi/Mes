import request from '@/utils/request'

// 查询一期配方投料列表
export function listFeeding(query) {
  return request({
    url: '/web/initfeeding/list',
    method: 'get',
    params: query
  })
}

// 查询一期配方投料详细
export function getFeeding(id) {
  return request({
    url: '/web/initfeeding/' + id,
    method: 'get'
  })
}

// 新增一期配方投料
export function addFeeding(data) {
  return request({
    url: '/web/initfeeding',
    method: 'post',
    data: data
  })
}

// 修改一期配方投料
export function updateFeeding(data) {
  return request({
    url: '/web/initfeeding',
    method: 'put',
    data: data
  })
}

// 删除一期配方投料
export function delFeeding(id) {
  return request({
    url: '/web/initfeeding/' + id,
    method: 'delete'
  })
}

//删除一期配方配方明细
export function deleteFeeding(data) {
  return request({
    url: '/web/initfeeding/',
    method: 'post',
    data: data
  })
}

//保存一期配方配方明细
export function saveFeeding(data) {
  return request({
    url: '/web/initfeeding/saveFeeding',
    method: 'post',
    data: data
  })
}
