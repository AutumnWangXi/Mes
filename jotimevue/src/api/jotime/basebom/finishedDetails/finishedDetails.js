import request from '@/utils/request'

// 删除步骤
export function deleteProcess(id) {
  return request({
    url: '/web/processBom/deleteProcess/' + id,
    method: 'get'
  })
}
