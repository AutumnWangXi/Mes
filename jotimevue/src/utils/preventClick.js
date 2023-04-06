// 设置点击间隔
import Vue from 'vue'

Vue.directive('preventClick', {
  inserted (el) {
    el.addEventListener('click', () => {
      if (!el.disabled) {
        el.disabled = true
        setTimeout(() => {
          el.disabled = false
        }, 1000)
      }
    })
  }
})
