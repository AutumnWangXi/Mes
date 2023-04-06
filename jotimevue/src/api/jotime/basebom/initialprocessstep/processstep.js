import request from '@/utils/request'

// 查询打样一期配方工序列表
export function listProcessstep(query) {
  return request({
    url: '/web/processstep/list',
    method: 'get',
    params: query
  })
}

// 查询打样一期配方工序详细
export function getProcessstep(id) {
  return request({
    url: '/web/processstep/' + id,
    method: 'get'
  })
}

// 新增打样一期配方工序
export function addProcessstep(data) {
  return request({
    url: '/web/processstep',
    method: 'post',
    data: data
  })
}

// 修改打样一期配方工序
export function updateProcessstep(data) {
  return request({
    url: '/web/processstep',
    method: 'put',
    data: data
  })
}

// 删除打样一期配方工序
export function delProcessstep(id) {
  return request({
    url: '/web/processstep/' + id,
    method: 'delete'
  })
}

// 查看一期配方的所有数据
export function allDataOfTheCurrentRecipe(formulaNo, version) {
  return request({
    url: '/web/processstep/allDataOfTheCurrentRecipe',
    method: 'get',
    params: {
      'formulaNo': formulaNo,
      'version' : version
    }
  })
}

// 删除一期配方步骤信息
export function deleteProcessstep(data) {
  return request({
    url: '/web/processstep/deleteProcessstep',
    method: 'post',
    data: data
  })
}

// 保存一期配方步骤信息
export function saveProcessstep(data) {
  return request({
    url: '/web/processstep/saveProcessstep',
    method: 'post',
    data: data
  })
}

