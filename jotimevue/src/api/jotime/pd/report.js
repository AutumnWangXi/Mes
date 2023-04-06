import request from '@/utils/request'


// 查询生产报产列表2
export function listGroupOrderTask(query) {
  return request({
    url: '/web/pd/ordertask/list',
    method: 'get',
    params: query
  })
}

// 查询生产报产列表1
export function listReport(query) {
  return request({
    url: '/web/pd/report/list',
    method: 'get',
    params: query
  })
}

// 查询生产报产详细
export function getReport(id) {
  return request({
    url: '/web/pd/report/' + id,
    method: 'get'
  })
}

// 查询生产报产详细
export function getreportInfo(data) {
  return request({
    url: '/web/pd/report/reportInfo',
    method: 'post',
    data: data
  })
}

// 格式
export function GS() {
  return request({
    url: '/web/pd/report/GS',
    method: 'post'
  })
}

// 新增生产报产
export function addReport(data) {
  return request({
    url: '/web/pd/report',
    method: 'post',
    data: data
  })
}

// 修改生产报产
export function updateReport(data) {
  return request({
    url: '/web/pd/report',
    method: 'put',
    data: data
  })
}

// 删除生产报产
export function delReport(id) {
  return request({
    url: '/web/pd/report/' + id,
    method: 'delete'
  })
}

export function addReportDtl(data) {
  return request({
    url: '/web/pd/reportdtl',
    method: 'post',
    data: data
  })
}

export function getListGb(data) {
  return request({
    url: '/web/pd/ordertask/getListGb',
    method: 'post',
    data: data,
  })
}

export function getPringInfo(data) {
  return request({
    url: '/web/pd/report/getPringInfo',
   method: 'post',
   data: data,
  })
}
