import request from '@/utils/request'

// 查询描述：工艺参数列表
export function listProcessparm(query) {
  return request({
    url: '/admin/processparm/list',
    method: 'get',
    params: query
  })
}

// 查询描述：工艺参数详细
export function getProcessparm(id) {
  return request({
    url: '/admin/processparm/' + id,
    method: 'get'
  })
}

// 新增描述：工艺参数
export function addProcessparm(data) {
  return request({
    url: '/admin/processparm',
    method: 'post',
    data: data
  })
}

// 修改描述：工艺参数
export function updateProcessparm(data) {
  return request({
    url: '/admin/processparm',
    method: 'put',
    data: data
  })
}

// 删除描述：工艺参数
export function delProcessparm(id) {
  return request({
    url: '/admin/processparm/' + id,
    method: 'delete'
  })
}
