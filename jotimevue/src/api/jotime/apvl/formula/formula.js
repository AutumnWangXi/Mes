import request from '@/utils/request'

// 查询打样申请单 包含申请单状态列表
export function listFormula(query) {
  return request({
    url: '/web/apvl/formula/list',
    method: 'get',
    params: query
  })
}

// 查询打样申请单 包含申请单状态详细
export function getFormula(id) {
  return request({
    url: '/web/apvl/formula/' + id,
    method: 'get'
  })
}

// 新增打样申请单 包含申请单状态
export function addFormula(data) {
  return request({
    url: '/web/apvl/formula',
    method: 'post',
    data: data
  })
}

// 新增打样申请单 包含申请单状态
export function printFormula(data) {
  return request({
    url: '/web/apvl/formula/printFormula',
    method: 'post',
    data: data
  })
}

// 修改打样申请单 包含申请单状态
export function updateFormula(data) {
  return request({
    url: '/web/apvl/formula',
    method: 'put',
    data: data
  })
}

// 删除打样申请单 包含申请单状态
export function delFormula(id) {
  return request({
    url: '/web/apvl/formula/' + id,
    method: 'delete'
  })
}

/**
 * 查询全部客户
 */
export function selectCustomerName() {
  return request({
    url: '/web/base/customers/selectCustomerName',
    method: 'get'
  })
}

/**
 * 查询成品物料
 */
export function selectItemName(data) {
  return request({
    url: '/web/base/item/selectItemName',
    method: 'post',
    data: data
  })
}

/**
 * 查询成品物料
 */
export function selectVItemData(data) {
  return request({
    url: '/web/base/item/selectVItemData',
    method: 'post',
    data: data
  })
}

/**
 * 附件上传
 */
export function upload() {
  return request({
    url: '/web/apply/oss/uploadFile',
    method: 'Post'
  })
}
// 二次申请
export function getApvlType(apvlNo) {
  return request({
    url: '/web/apvl/common/secondApplication/' + apvlNo,
    method: 'get'
  })
}
/**
 * 查询客户ID
 * @param name 客户名称
 * @returns {AxiosPromise}
 */
export function selectCustomer(name) {
  return request({
    url: '/web/base/customers/selectCustomer/' + name,
    method: 'get'
  })
}

export function deleteFile(fileUrl) {
  return request({
    url: '/oss/deleteFile',
    data: fileUrl,
    method: 'Post'
  })
}

export function removeOssFile(data) {
  return request({
    url: '/oss/removeOssFile',
    data: data,
    method: 'Post'
  })
}
