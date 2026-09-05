// // return count of every element
// // return result sorted via highest freq.
// const arr = [1, 2, 3, 4, 2, 3, 1, 6, 8, 2, 6, 10, 3, 2];

// function findCount(arr){
//     let countObj = {};

//     for(let i=0;i<arr.length;i++){
//         let item = arr[i];
//         if(countObj[item]){
//             countObj[item] = countObj[item]+1;
//         }else {
//             countObj[item]=1;
//         }
//     }
//     return countObj;
// }


// let result = findCount(arr);
// console.log(result);
// let newArr = Object.entries(result);
 
// function mysort(newArr){
//     for(let i=0 ; i<newArr.length;i++){
//         for(let j=0 ; j<newArr.length-1-i; j++){
//             if(newArr[j][1]>newArr[j+1][1]){
//                 let temp = newArr[j];
//                 newArr[j] = newArr[j+1];
//                 newArr[j+1] = temp;
//             }
//         }
//     }

//     return newArr;
// }

// console.log(mysort(newArr));

// console.log(a);
// console.log(b);
// var a = 10;
// let b = 20;

// function test(){
//     console.log(a);
//     console.log(b);
//     var a = 30;
//     let b =40;
// };

// test();


const arr = [1, 2, 3, 4, 2, 3, 1, 6, 8, 2, 6, 10, 3, 2];
function findCount(arr){
    let countObj = {};

    for(let i=0;i<arr.length;i++){
        let item = arr[i];
        if(countObj[item]){
            countObj[item] = countObj[item]+1;
        }else {
            countObj[item]=1;
        }
    }
    return countObj;
}

let result = Object.entries(findCount(arr));

function mergeSort(arr){
    if(arr.length<2) return arr;
    let middle = Math.floor(arr.length/2);
    let firstHalf = arr.slice(0,middle); 
    let secondHalf = arr.slice(middle);
    
    return merge(mergeSort(firstHalf),mergeSort(secondHalf));
}

function merge(arr1,arr2){
    var result = [];
    while(arr1.length && arr2.length){
        if(arr1[0][1] < arr2[0][1]) {
            minvalue = arr1.shift();
        }else { 
         minvalue = arr2.shift();
        } 
       result.push(minvalue);
    }

     if(arr1.length) {
        result = result.concat(arr1);
     }else {
        result = result.concat(arr2);
     }   
     return result;
}

console.log(mergeSort(result));










