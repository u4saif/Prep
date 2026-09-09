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

  const clone = {};
  Object.keys(obj).forEach((key) => {
    clone[key] = obj[key];
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


function myclone( obj){
    if(typeof obj == null || typeof obj != 'object'){
        return obj;
    }

    let clone;
    for(key of obj.keys){
        clone[key] = obj[key];
    }

    return obj
}

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


function checker(itemA, itemB){
    if(typeof itemA == null || typeof itemB == null || typeof itemA !='object' || typeof itemA !='object' ) return false;

    let keysA = Object.keys(itemA)

    let keysB = Object.keys(itemB)
    if(keysA.length != keysB.length) return false

    for(let key of keysA){
        if(!keysB.includes(key) || !checker(itemA[key],itemB[key])) return false;
    };

    return true;
}

console.log(checker(obj2,obj3));