import Vue from 'vue';
Vue.directive('el-select-loadmore',(el,binding)=>{
    const SELECTWRAP_DOM = el.querySelector('.el-select-dropdown .el-select-dropdown__wrap');
    if(SELECTWRAP_DOM){
        SELECTWRAP_DOM.addEventListener('scroll',function(){
            const condition = this.scrollHeight - this.scrollTop - 1 <=this.clientHeight;
            if(condition) binding.value();
        })
    }
    }
)