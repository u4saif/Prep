console.log("hello");
// find the target pair sum of in the array

let arr = [3,2,6,9,5,7,1,0,4,5];

function findSumTarget(arr,target){
    let result = [];
    let counterMap = [];
    for(let i=0; i<arr.length;i++){
        let diffrence = target - arr[i];
        if(counterMap.indexOf(diffrence) != -1){
            result.push([arr[i],diffrence]);
        } else {
            counterMap.push(arr[i]);
        }
    }

    return result;
}

// console.log(findSumTarget(arr,10));

//[8,2,4,3,6] find the max profit in this trade chart
function findMaxProfit(arr){
    let minPrice = arr[0];
    let maxProfit = 0;

    for(let i=1;i<arr.length;i++){
        minPrice = Math.min(minPrice, arr[i]);
        maxProfit = Math.max(maxProfit, arr[i] - minPrice);
    }

    return maxProfit;
}

console.log(findMaxProfit([3,8,2,4,3,6]));

// (function(){
//     var x=y=2;
// })();
// console.log(typeof y);
// console.log(typeof x);
var x=10;
function y(){
   let x=10;
   // return;
    function bb(){console.log(typeof x);}; 
}

y();
// console.log(typeof x);

//Move all zero toward one side [0,3,5,0,6,0,0,2]
let zeroArr = [0,3,5,0,-6,0,0,2];
function moveZero(arr){
    let result = [];
    let zeroCount = 0;
    for(let i=0;i<arr.length;i++){
        if(arr[i]!=0){
            result.push(arr[i]);
        } else {
            zeroCount++;
        }
    }
    let zeros = Array(zeroCount).fill(0);
    return result.concat(zeros);
}

console.log(moveZero(zeroArr));