import request from '@/utils/request'

// 查询描述：bom工序列表
export function listProcess(query) {
  return request({
    url: '/admin/process/list',
    method: 'get',
    params: query
  })
}

// 查询描述：bom工序详细
export function getProcess(id) {
  return request({
    url: '/admin/process/' + id,
    method: 'get'
  })
}

// 新增描述：bom工序
export function addProcess(data) {
  return request({
    url: '/admin/process',
    method: 'post',
    data: data
  })
}

// 修改描述：bom工序
export function updateProcess(data) {
  return request({
    url: '/admin/process',
    method: 'put',
    data: data
  })
}

// 删除描述：bom工序
export function delProcess(id) {
  return request({
    url: '/admin/process/' + id,
    method: 'delete'
  })
}
