import request from '@/utils/request'

// 查询描述：缺料补料申请明细列表
export function listSupplementariesdtl(query) {
  return request({
    url: '/web/Apvl/supplementariesdtl/list',
    method: 'get',
    params: query
  })
}

// 查询描述：缺料补料申请明细详细
export function getSupplementariesdtl(id) {
  return request({
    url: '/web/Apvl/supplementariesdtl/' + id,
    method: 'get'
  })
}

// 新增描述：缺料补料申请明细
export function addSupplementariesdtl(data) {
  return request({
    url: '/web/Apvl/supplementariesdtl',
    method: 'post',
    data: data
  })
}

// 修改描述：缺料补料申请明细
export function updateSupplementariesdtl(data) {
  return request({
    url: '/web/Apvl/supplementariesdtl',
    method: 'put',
    data: data
  })
}

// 删除描述：缺料补料申请明细
export function delSupplementariesdtl(id) {
  return request({
    url: '/web/Apvl/supplementariesdtl/' + id,
    method: 'delete'
  })
}
