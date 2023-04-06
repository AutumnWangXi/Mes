import request from '@/utils/request'

// 扫物料箱后返回物料箱中原有数据
export function getBoxOldItem(data) {
  return request({
    url: '/web/barcode/getBoxOldItem',
    method: 'post',
    data: data
  })
}

// 任务订单详情
export function getOrderTask(data) {
  return request({
    url: '/web/barcode/getOrderTask',
    method: 'post',
    data: data
  })
}

// 添加装箱数据
export function addPacking(data) {
  return request({
    url: '/web/barcode/addPacking',
    method: 'post',
    data: data
  })
}

// 小物料箱数据
export function getPackingBox(data) {
  return request({
    url: '/web/barcode/getPackingBox',
    method: 'post',
    data: data
  })
}

// 添加小物料箱
export function addPackingBox(data) {
  return request({
    url: '/web/barcode/addPackingBox',
    method: 'post',
    data: data
  })
}


//删除箱子中数据
export function deleteBox(id) {
  return request({
    url: '/web/barcode/deleteBoxInfo/' + id,
    method: 'get'
  })
}
