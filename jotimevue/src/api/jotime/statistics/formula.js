import request from '@/utils/request'

// 统计配方
export function researchAndDevelopmentOfStatistical(data) {
  return request({
    url: '/admin/bom/researchAndDevelopmentOfStatistical',
    method: 'post',
    data: data
  })
}

// 查询配方统计
export function getFormulastatistics(query) {
  return request({
    url: '/web/formulastatistics/formulastats',
    method: 'post',
    data: query
  })
}

// 查询研发配方
export function getRdFormulastatistics(query) {
  return request({
    url: '/web/formulastatistics/rdformulastats',
    method: 'post',
    data: query
  })
}

// 查询研发人员配方
export function getRdEeFormulastatistics(query) {
  return request({
    url: '/web/formulastatistics/rdEeformulastats',
    method: 'post',
    data: query
  })
}
// 升级配方
export function upgradeappl(query) {
  return request({
    url: '/web/formula/upgradeappl',
    method: 'post',
    data: query
  })
}
// 审核配方
export function upgradecheck(query) {
  return request({
    url: '/web/formula/upgradecheck',
    method: 'post',
    data: query
  })
}
// 全部保存
export function savealldata(query) {
  return request({
    url: '/web/formula/savealldata',
    method: 'post',
    data: query
  })
}
// 修改
export function editFormula(data) {
  return request({
    url: '/web/formula',
    method: 'put',
    data: data
  })
}



