import request from '@/utils/request'

// 查询描述：研发打样任务列表
export function listFormulatask(query) {
  return request({
    url: '/web/formulatask/list',
    method: 'get',
    params: query
  })
}

// 查询描述：研发打样任务详细
export function getFormulatask(id) {
  return request({
    url: '/web/formulatask/' + id,
    method: 'get'
  })
}

// 新增描述：研发打样任务
export function addFormulatask(data) {
  return request({
    url: '/web/formulatask',
    method: 'post',
    data: data
  })
}

// 修改描述：研发打样任务
export function updateFormulatask(data) {
  return request({
    url: '/web/formulatask',
    method: 'put',
    data: data
  })
}

// 删除描述：研发打样任务
export function delFormulatask(id) {
  return request({
    url: '/web/formulatask/' + id,
    method: 'delete'
  })
}
