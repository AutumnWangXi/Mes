import request from '@/utils/request'

// 查询库存临期列表
export function listMan(query) {
  return request({
    url: '/web/stockin/manage/handleList',
    method: 'post',
    params: query
  })
}

// 处理完成操作
export function edidMan(id) {
  return request({
    url: '/web/stockin/manage/handleEdit/' + id,
    method: 'get',
  })
}
