export function highPrecisionAdd(data1,data2) {// 加法
       let r1,r2,m;
       // 获取每个参数的小数的位数
       try{r1=data1.toString().split(".")[1].length}catch(e){r1=0}
       try{r2=data2.toString().split(".")[1].length}catch(e){r2=0}
       // 计算底数为10以最大小数位数为次幂的值
       m=Math.pow(10,Math.max(r1,r2));
       // 把所有参数转为整数后相加再除以次幂的值
       return (data1*m + data2*m)/m;
     };

export function highPrecisionReduce(data1,data2) {// 减法
       let r1,r2,m,n;
       // 获取每个参数的小数的位数
       try{r1=data1.toString().split(".")[1].length}catch(e){r1=0}
       try{r2=data2.toString().split(".")[1].length}catch(e){r2=0}
       // 计算底数为10以最大小数位数为次幂的值
       m=Math.pow(10,Math.max(r1,r2));
       //精度长度以最大小数位数为长度
       n=(r1>=r2)?r1:r2;
       return ((data1*m-data2*m)/m).toFixed(n);
     };
export function highPrecisionMul(data1,data2) {// 乘法
       let m=0,s1=data1.toString(),s2=data2.toString();
       // 获取所有参数小数位长度之和
       try{m+=s1.split(".")[1].length}catch(e){}
       try{m+=s2.split(".")[1].length}catch(e){}
       // 替换掉小数点转为数字相乘再除以10的次幂值
       return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m);
     };
export function highPrecisionDiv(data1,data2) {// 除法
       let t1=0,t2=0,r1,r2;
       // 获取每个参数的小数的位数
       try{t1=data1.toString().split(".")[1].length}catch(e){}
       try{t2=data2.toString().split(".")[1].length}catch(e){}
       // 把所有参数的小数点去掉转为整数
       r1=Number(data1.toString().replace(".",""));
       r2=Number(data2.toString().replace(".",""));
       return (r1/r2)*Math.pow(10,t2-t1);
     };


    //正整数校验
    export function validatorPositiveInteger(value) {
      if (Number.isInteger(Number(value)) && Number(value) > 0) {
        return true;
      } else {
        return false;
      }
    };

    //正数校验
    export function validatorInteger(value) {
      if (Number(value) > 0) {
        return true;
      } else {
        return false;
      }
    };

    //正数校验
    export function validatePositiveNumver(value) {
      if (value == "" || value == undefined || value == null) {
        return false;
      } else {
        let reg = /([+]\d+[.]\d+|[-]\d+[.]\d+|\d+[.]\d+|[+]\d+|[-]\d+|\d+)/gi;
        if (!(reg.test(value) && value >0)) {
          return false;
        }
      }

      return true;
    };

