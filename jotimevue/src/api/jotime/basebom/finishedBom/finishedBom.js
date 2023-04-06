import request from '@/utils/request'

// 查询描述：bom管理列表
export function finishedBomList(data) {
  return request({
    url: '/web/bom/finishedBomList',
    method: 'POST',
    data: data
  })
}

// 新增
export function addFinishedBom(data) {
  return request({
    url: '/web/bom/addFinishedBom',
    method: 'POST',
    data: data
  })
}

// 修改
export function editFinishedBom(data) {
  return request({
    url: '/web/bom/editFinishedBom',
    method: 'POST',
    data: data
  })
}

//删除
export function deleteBomDtlINfo(id) {
  return request({
    url: '/web/bom/deleteBomDtlINfo/' + id,
    method: 'get'
  })
}


export function moduleChange(data) {
  return request({
    url: '/web/pd/module/moduleInfo',
    method: 'post',
    data: data
  })
}
