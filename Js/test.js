// Create Polifill of Promiss All
var msgOne = new Promise((res,reg)=> setTimeout(res,200,"Message One"));
var msgTwo = new Promise((res,reg)=> setTimeout(res,100,"Message Two"));

function myPromiseAll(promissArray){
    var result = [];
    var resolvedCount = 0;
    var error = [];
    return new Promise((res,reg)=>{
        promissArray.forEach((promiss,index)=>{
            promiss
            .then((data)=>{
                result[index] = data;
                resolvedCount++;
            if(resolvedCount  == promissArray.length){
                    res(result);
                }
        }).catch((err)=> reg(err));
        })
    })
}


myPromiseAll([msgOne,msgTwo])
.then((res)=>res.forEach((data)=>{console.log(":",data)}))
.catch((err)=>console.error("Error",err));