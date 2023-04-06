import request from '@/utils/request'

// 缺陷审核提交
export function review(data) {
  return request({
    url: '/web/review',
    method: 'post',
    data: data
  })
}
// 处理人查询
export function reviewNo(apvlNo) {
  return request({
    url: '/web/review/getReviewData/' + apvlNo,
    method: 'get'
  })
}
// 处理人提交保存
export function submittedByTheManager(data) {
  return request({
    url: 'web/review/submittedByTheManager',
    method: 'put',
    data: data
  })
}

