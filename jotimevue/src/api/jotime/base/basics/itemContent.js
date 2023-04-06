import request from '@/utils/request'

// 查询描述：物料含量列表
export function listItemContent(query) {
  return request({
    url: '/web/itemContent/list',
    method: 'get',
    params: query
  })
}

// 查询描述：物料含量列表
export function listItemContents(id) {
  return request({
    url: '/web/base/item/getInfos/'+id,
    method: 'get'
  })
}

// 查询描述：物料含量详细
export function getItemContent(id) {
  return request({
    url: '/web/itemContent/' + id,
    method: 'get'
  })
}

// 新增描述：物料含量
export function addItemContent(data) {
  return request({
    url: '/web/itemContent',
    method: 'post',
    data: data
  })
}

// 修改描述：物料含量
export function updateItemContent(data) {
  return request({
    url: '/web/itemContent',
    method: 'put',
    data: data
  })
}

// 删除描述：物料含量
export function delItemContent(id) {
  return request({
    url: '/web/itemContent/' + id,
    method: 'delete'
  })
}
