import request from '@/utils/request'

// 查询合同申请列表
export function listContract(query) {
  return request({
    url: '/web/apvl/contract/list',
    method: 'get',
    params: query
  })
}

// 查询合同申请详细
export function getContract(id) {
  return request({
    url: '/web/apvl/contract/' + id,
    method: 'get'
  })
}

// 新增合同申请
export function addContract(data) {
  return request({
    url: '/web/apvl/contract',
    method: 'post',
    data: data
  })
}

// 修改合同申请
export function updateContract(data) {
  return request({
    url: '/web/apvl/contract',
    method: 'put',
    data: data
  })
}

// 删除合同申请
export function delContract(id) {
  return request({
    url: '/web/apvl/contract/' + id,
    method: 'delete'
  })
}


// 删除合同申请
export function getContactNo() {
  return request({
    url: '/web/apvl/contract/getContactNo',
    method: 'get'
  })
}
// 校验合同信息
export function calibrationContract(value) {
  return request({
    url: '/web/apvl/contract/calibrationContract/' + value,
    method: 'get'
  })
}
// 校验合同信息
export function calibrationContractData(data) {
  return request({
    url: '/web/apvl/contract/calibrationContractData',
    method: 'post',
    data:data
  })
}
