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

console.log(findSumTarget(arr,10));
