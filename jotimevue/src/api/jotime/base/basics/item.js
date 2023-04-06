import request from '@/utils/request'
import log from "@/views/monitor/job/log";

// 查询物料列表
export function listItem(query) {
  return request({
    url: '/web/base/item/list',
    method: 'get',
    params: query
  })
}

// 查询物料详细
export function getItem(id) {
  return request({
    url: '/web/base/item/' + id,
    method: 'get'
  })
}

// 新增物料
export function addItem(data) {
  return request({
    url: '/web/base/item',
    method: 'post',
    data: data
  })
}

// 修改物料
export function updateItem(data) {
  return request({
    url: '/web/base/item',
    method: 'put',
    data: data
  })
}

// 删除物料
export function delItem(id) {
  return request({
    url: '/web/base/item/' + id,
    method: 'delete'
  })
}
// 查询客户下拉信息
export function ListCusOption() {
  return request({
    url: '/web/base/customers/optionsList',
    method: 'get'
  })
}

// 查询制造商信息
export function selectMfrsName() {
  return request({
    url: '/web/base/mfrs/selectMfrsName',
    method: 'get'
  })
}

// 查询供应商下拉信息
export function ListSuppliers() {
  return request({
    url: '/web/base/supplier/selectSupplierName',
    method: 'get'
  })
}
// 查询所有物料信息
export function selectAllItem() {
  return request({
    url: '/web/base/item/selectAllItem',
    method: 'get'
  })
}
// 查询所有物料信息
export function selectItemNameList() {
  return request({
    url: '/web/base/item/selectItemNameList',
    method: 'get'
  })
}
// 查询所有有效物料信息
export function selectAllEffectiveItem() {
  return request({
    url: '/web/base/item/selectAllEffectiveItem',
    method: 'get'
  })
}
// 查询物料含量
export function getItemContent(query) {
  return request({
    url: '/web/itemContent/list',
    method: 'get',
    params: query
  })
}
// 修改描述：物料含量
export function updateItemContent(data,itemId) {
  return request({
    url: '/web/itemContent/update/'+itemId,
    method: 'put',
    data: data
  })
}
// 查询原料管理修改信息
export function material(id) {
  return request({
    url: '/web/base/item/material/' + id,
    method: 'get'
  })
}
// 修改原料管理修改信息
export function setmaterial(data) {
  return request({
    url: '/web/base/item/materials',
    method: 'put',
    data: data
  })
}

// 修改原料管理修改信息
export function editOther(data) {
  return request({
    url: '/web/base/item/editOther',
    method: 'put',
    data: data
  })
}

// 原料管理修改供应商下拉框数据
export function materiallist() {
  return request({
    url: '/web/base/supplier/list',
    method: 'get'
  })
}
// 原料管理修改供应商供应商code
export function materialcode(query) {
  return request({
    url: '/web/base/supplier/code',
    method: 'get',
    params: query
  })
}

// INCI名称
export function cosmeticMateria(inciNameCn) {
  return request({
    url: '/web/cosmeticMaterial/getInfo/' + inciNameCn,
    method: 'get'
  })
}

// 单位
export function getDistinctlist() {
  return request({
    url: '/web/base/unit/distinctlist',
    method: 'get'
  })
}

