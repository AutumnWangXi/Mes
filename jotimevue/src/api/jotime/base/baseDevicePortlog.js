import request from '@/utils/request'

// 查询设备端口连接日志列表
export function listLog(query) {
  return request({
    url: '/web/deviceportlog/list',
    method: 'get',
    params: query
  })
}

// 查询设备端口连接日志详细
export function getLog(id) {
  return request({
    url: '/web/deviceportlog/' + id,
    method: 'get'
  })
}

// 新增设备端口连接日志
export function addLog(data) {
  return request({
    url: '/web/deviceportlog',
    method: 'post',
    data: data
  })
}

// 修改设备端口连接日志
export function updateLog(data) {
  return request({
    url: '/web/deviceportlog',
    method: 'put',
    data: data
  })
}

// 删除设备端口连接日志
export function delLog(id) {
  return request({
    url: '/web/deviceportlog/' + id,
    method: 'delete'
  })
}
