// sort algos

// var arr = [3, 1, 9, 7];

// function mergeSort(arr) {
//   if (arr.length < 2) return arr;
//   let middleIndex = Math.floor(arr.length / 2);
//   let firstHalf = arr.slice(0, middleIndex);
//   let secondHalf = arr.slice(middleIndex);

//   return merge(mergeSort(firstHalf), mergeSort(secondHalf));
// }

// function merge(arr1, arr2) {
//   let result = [];
//   let minValue;
//   while (arr1.length && arr2.length) {
//     if (arr1[0] < arr2[0]) {
//       minValue = arr1.shift();
//     } else {
//       minValue = arr2.shift();
//     }
//     result.push(minValue);
//   }
//   if (arr1.length) {
//     result = result.concat(arr1);
//   } else {
//     result = result.concat(arr2);
//   }
//   return result;
// }

// function mysort(arr) {
//   for (let i = arr.length; i > 0; i--) {
//     for (let j = 0; j < i - 1; j++) {
//       if (arr[j] > arr[j + 1]) {
//         let temp = arr[j + 1];
//         arr[j + 1] = arr[j];
//         arr[j] = temp;
//       }
//     }
//   }

//   return arr;
// }

// console.log(mysort(arr));

// (function abc(){
//     var x=y=2;
// })();
//  var x=y=2;
// console.log(typeof y);
// console.log(typeof x);

//  1 ,1,2,3,5,8,13,21
//n=1 ,2,3,4,5,6,7
//Add cuurent + previous for => next
// function febo(valueOfN, cache = []) {
//   if (cache[valueOfN]) {
//     return cache[valueOfN];
//   } else {
//     if (valueOfN < 3) {
//       return 1;
//     } else {
//       cache[valueOfN] = febo(valueOfN - 1, cache) + febo(valueOfN - 2, cache);
//     }
//   }

//   return cache[valueOfN];
// }

// console.log(febo(100));
