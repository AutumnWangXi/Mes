import request from '@/utils/request'

// 查询打样一期配方管理明细列表
export function listFormuladtl(query) {
  return request({
    url: '/web/formuladtl/list',
    method: 'get',
    params: query
  })
}

// 查询打样一期配方管理明细详细
export function getFormuladtl(id) {
  return request({
    url: '/web/formuladtl/' + id,
    method: 'get'
  })
}

// 新增打样一期配方管理明细
export function addFormuladtl(data) {
  return request({
    url: '/web/formuladtl',
    method: 'post',
    data: data
  })
}

// 修改打样一期配方管理明细
export function updateFormuladtl(data) {
  return request({
    url: '/web/formuladtl',
    method: 'put',
    data: data
  })
}

// 删除打样一期配方管理明细
export function delFormuladtl(id) {
  return request({
    url: '/web/formuladtl/' + id,
    method: 'delete'
  })
}

// 新增打样一期配方管理明细
export function saveBomDtl(data) {
  return request({
    url: '/web/formuladtl/saveformuladtl',
    method: 'post',
    data: data
  })
}
//删除明细
export function deleteBomDtl(data) {
  return request({
    url: '/web/formuladtl/deleteBomDtl',
    method: 'post',
    data: data
  })
}
// 保存一期配方组成信息
export function saveFormuladtlTab(data) {
  return request({
    url: '/web/formuladtl/saveformuladtl',
    method: 'post',
    data: data
  })
}

// 新增打样一期配方管理明细
export function saveRowBomDtl(data) {
  return request({
    url: '/web/formuladtl/saverowformuladtl',
    method: 'post',
    data: data
  })
}
