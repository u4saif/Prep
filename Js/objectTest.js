console.log("oBJECTS..");

const myobj = {
  name: "saif",
  age:27,
  address: [
    { flat: "f23", area: "okhla" },
    { flat: "f232", area: "okhla2" },
  ],
  skills:["angular","react","js"]
};

function createClone(obj){
  if (obj === null || typeof obj !== "object") {
    return obj;
  }
  if(Array.isArray(obj)){
    return obj.forEach((item)=> createClone(item));
  }
  const clone = {};
  Object.keys(obj).forEach((key) => {
    clone[key] = createClone(obj[key]);
  });

  return clone;
}

const obj2 = createClone(myobj);
// obj2.age = 2;
// obj2.skills = ["skil2"];

// const myobj2 = {...myobj};
// myobj2.age=13;
// myobj2.address = [];

// console.log(myobj);

// console.log(obj2);

 

const obj3 = createClone(myobj);
obj3.age = "obj3";

// console.log(obj3);

function objectChecker(itemA,itemB){
    if(itemA == itemB) return true;

    if(itemA == null || itemB == null || typeof itemA !== 'object' || typeof itemB !== 'object' ) return false;
    
    let keys1 = Object.keys(itemA);
    let keys2 = Object.keys(itemB);
    if(keys1.length !== keys2.length) return  false;

    for (let key of keys1 ){
        if(!keys2.includes(key) || !objectChecker(itemA[key],itemB[key])) return false;
    }
    return true;
}

// console.log(objectChecker(myobj,obj2));


function isPlainObject(value) {
  return Object.prototype.toString.call(value) === '[object Object]';
}

function deepEqual(valueA, valueB) {
  if (valueA === valueB || (Number.isNaN(valueA) && Number.isNaN(valueB))) {
    return true;
  }

  if (valueA === null || valueB === null || valueA === undefined || valueB === undefined) {
    return valueA === valueB;
  }

  if (typeof valueA !== 'object' || typeof valueB !== 'object') {
    return false;
  }

  if (Array.isArray(valueA) || Array.isArray(valueB)) {
    if (!Array.isArray(valueA) || !Array.isArray(valueB)) {
      return false;
    }

    if (valueA.length !== valueB.length) {
      return false;
    }

    for (let index = 0; index < valueA.length; index++) {
      const hasA = Object.prototype.hasOwnProperty.call(valueA, index);
      const hasB = Object.prototype.hasOwnProperty.call(valueB, index);

      if (hasA !== hasB) {
        return false;
      }

      if (hasA && hasB && !deepEqual(valueA[index], valueB[index])) {
        return false;
      }
    }

    return true;
  }

  if (!isPlainObject(valueA) || !isPlainObject(valueB)) {
    return false;
  }

  const keysA = Object.keys(valueA);
  const keysB = Object.keys(valueB);

  if (keysA.length !== keysB.length) {
    return false;
  }

  for (const key of keysA) {
    if (!Object.prototype.hasOwnProperty.call(valueB, key)) {
      return false;
    }

    if (!deepEqual(valueA[key], valueB[key])) {
      return false;
    }
  }

  return true;
}

console.log('deepEqual("foo", "foo") =>', deepEqual('foo', 'foo'));
console.log('deepEqual({ id: 1 }, { id: 1 }) =>', deepEqual({ id: 1 }, { id: 1 }));
console.log('deepEqual([1, 2, 3], [1, 2, 3]) =>', deepEqual([1, 2, 3], [1, 2, 3]));
console.log('deepEqual([{ id: "1" }], [{ id: "2" }]) =>', deepEqual([{ id: '1' }], [{ id: '2' }]));
console.log('deepEqual([, ,], [undefined, undefined]) =>', deepEqual([, ,], [undefined, undefined]));
console.log('deepEqual({ a: 1, b: [2, , 4] }, { a: 1, b: [2, , 4] }) =>', deepEqual({ a: 1, b: [2, , 4] }, { a: 1, b: [2, , 4] }));