import request from '@/utils/request'

// 查询生产测试记录列表
export function listRecord(query) {
  return request({
    url: '/web/pdRecord/list',
    method: 'get',
    params: query
  })
}

// 查询生产测试记录详细
export function getRecord(id) {
  return request({
    url: '/web/pdRecord/' + id,
    method: 'get'
  })
}

// 新增生产测试记录
export function addRecord(data) {
  return request({
    url: '/web/pdRecord',
    method: 'post',
    data: data
  })
}

// 修改生产测试记录
export function updateRecord(data) {
  return request({
    url: '/web/pdRecord',
    method: 'put',
    data: data
  })
}

// 添加或者修改测试记录和明细
export function saveTestRecordAndDtl(data) {
  return request({
    url: '/web/pdTestRecord/saveTestRecordAndDtl',
    method: 'post',
    data: data
  })
}

// 查询所有的数据
export function queryProductionRecord(data) {
  return request({
    url: '/web/pdTestRecord/queryProductionRecord',
    method: 'get',
    params: data
  })
}

// 删除生产测试记录
export function delRecord(id) {
  return request({
    url: '/web/pdRecord/' + id,
    method: 'delete'
  })
}

//查询不良品记录
export function selectDtlByProductionRecord(data) {
  return request({
    url: '/web/ordertaskdtl/selectDtlByProductionRecord',
    method: 'get',
    params: data
  })
}

//保存不良品
export function saveByProductionRecord(data) {
  return request({
    url: '/web/ordertaskdtl/saveByProductionRecord',
    method: 'post',
    data: data
  })
}

//查询灌装内料领用
export function queryFillingRecord(data) {
  return request({
    url: '/web/ordertaskdtl/queryFillingRecord',
    method: 'get',
    params: data
  })
}

//保存灌装内料不良品
export function saveByFillingRecord(data) {
  return request({
    url: '/web/ordertaskdtl/saveByFillingRecord',
    method: 'post',
    data: data
  })
}

//根据订单号查询数据
export function selectByOrderNo(data) {
  return request({
    url: '/web/pdRecord/selectByOrderNo',
    method: 'get',
    params: data
  })
}

//根据流水线号查询设备列表
export function selectAllByLineCode(data) {
  return request({
    url: '/web/base/device/selectAllByLineCode',
    method: 'get',
    params: data
  })
}
