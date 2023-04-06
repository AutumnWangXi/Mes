import request from '@/utils/request'

// 查询打样一期配方管理列表
export function listFormula(query) {
  return request({
    url: '/web/formula/list',
    method: 'get',
    params: query
  })
}

// 查询打样一期配方管理详细
export function getFormula(id) {
  return request({
    url: '/web/formula/' + id,
    method: 'get'
  })
}

// 新增打样一期配方管理
export function addFormula(data) {
  return request({
    url: '/web/formula',
    method: 'post',
    data: data
  })
}

// 修改打样一期配方管理
export function updateFormula(data) {
  return request({
    url: '/web/formula',
    method: 'put',
    data: data
  })
}

// 删除打样一期配方管理
export function delFormula(id) {
  return request({
    url: '/web/formula/' + id,
    method: 'delete'
  })
}

// 复制打样一期配方管理
export function copyFormula(id) {
  return request({
    url: '/web/formula/copyformula',
    method: 'post',
    data: id
  })
}

// 根据查询当前bom单下面的所有数据
export function selectBomDtlsGroupByItemType(id) {
  return request({
    url: '/web/formuladtl/selectBomDtlsGroupByItemType/' + id,
    method: 'get'
  })
}

// 升级按钮进行申请提交
export function updateUpgradeAppl(data) {
  return request({
    url: '/web/formula/upgradeappl',
    method: 'put',
    data: data
  })
}

// 升级按钮进行审核提交
export function updateUpgradeCheck(data) {
  return request({
    url: '/web/formula/upgradecheck',
    method: 'put',
    data: data
  })
}

// 升级按钮进行申请提交
export function upFileUploadInfo(data) {
  return request({
    url: '/web/formula/upfileupload',
    method: 'post',
    data: data
  })
}

// 查询配方关联的投标、配方组成、步骤信息
export function getAlldataOfFormula(formulaNo,version) {
  return request({
    url: '/web/formula/alldataofformula',
    method: 'get',
    params: {
      'formulaNo': formulaNo,
      'version' : version
    }
  })
}


// 获取打样信息
export function getFormulaInfo(data) {
  return request({
    url: '/web/formula/getInfo',
    method: 'post',
    data: data
  })
}

// 一期审批查询
export function selectFormulaList(query) {
  return request({
    url: '/web/formula/selectFormulaList',
    method: 'get',
    params: query
  })
}
