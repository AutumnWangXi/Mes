import request from '@/utils/request'

// 查询描述：缺料补料申请列表
export function listSupplementaries(query) {
  return request({
    url: '/web/apvl/supplementaries/list',
    method: 'get',
    params: query
  })
}

// 查询描述：缺料补料申请详细
export function getSupplementaries(id) {
  return request({
    url: '/web/apvl/supplementaries/' + id,
    method: 'get'
  })
}

// 新增描述：缺料补料申请
export function addSupplementaries(data) {
  return request({
    url: '/web/apvl/supplementaries',
    method: 'post',
    data: data
  })
}

// 修改描述：缺料补料申请
export function updateSupplementaries(data) {
  return request({
    url: '/web/apvl/supplementaries',
    method: 'put',
    data: data
  })
}

// 删除描述：缺料补料申请
export function delSupplementaries(id) {
  return request({
    url: '/web/apvl/supplementaries/' + id,
    method: 'delete'
  })
}
// 选择描述：缺料补料
export function dialogSupplementaries(gpOrderTaskNo) {
  return request({
    url: '/web/apvl/supplementaries/getGpOrderTaskNoData/'+gpOrderTaskNo,
    method: 'get',
  })
}
