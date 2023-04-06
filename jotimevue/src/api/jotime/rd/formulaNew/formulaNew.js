import request from '@/utils/request'

export function getFormulaNewList(queryParams) {
  return request({
    url: '/web/eeformula/selectNewFormulaList',
    method: 'Post',
    data: queryParams
  })
}

  export function getFormulaNew(id) {
    return request({
      url: '/web/eeformula/' + id,
      method: 'get',
    })
  }

export function updateFormulaNew(data) {
  return request({
    url: '/web/eeformula',
    method: 'Put',
    data: data
  })
}

export function addFormulaNew(data) {
  return request({
    url: '/web/eeformula',
    method: 'Post',
    data: data
  })
}export function deleteFormulaNew(id) {
  return request({
    url: '/web/eeformula/' + id,
    method: 'delete',
  })
}



export function selectNewFormulaInfo(data) {
  return request({
    url: '/web/eeformula/selectNewFormulaInfo',
    method: 'Post',
    data: data
  })
}

export function getFormulaNewCheckList(queryParams) {
  return request({
    url: '/web/eeformula/list',
    method: 'get',
    params: queryParams
  })
}

export function formulaNewCheck(data) {
  return request({
    url: '/web/eeformula/formulaNewCheck',
    method: 'post',
    data: data
  })
}

export function selectDeptFormula(queryParams) {
  return request({
    url: '/web/eeformula/selectDeptFormula',
    method: 'get',
    params: queryParams
  })
}
