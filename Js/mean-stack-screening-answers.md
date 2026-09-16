# MEAN Stack Technical Screening — Answer Key
**Senior Full Stack Developer | JavaScript, Angular, Node.js**

---

**Q1.** What is the output?
```js
console.log("1");
setTimeout(() => console.log("2"), 0);
queueMicrotask(() => {
  console.log("3");
  Promise.resolve().then(() => console.log("4"));
});
Promise.resolve().then(() => {
  console.log("5");
  queueMicrotask(() => console.log("6"));
});
console.log("7");
```
**Answer:** `1 7 3 5 4 6 2`

---

**Q2.** What is the output?
```js
var x = 1;
function outer() {
  console.log(x);
  var x = 2;
  function inner() { console.log(x); }
  inner();
}
outer();
```
**Answer:** `undefined 2`

---

**Q3.** What is the output?
```js
const obj = {
  value: 10,
  regular() { return this.value; },
  arrow: () => this.value
};
console.log(obj.regular());
console.log(obj.arrow());
```
**Answer:** `10 undefined`

---

**Q4.** What is the output?
```js
function A() {}
A.prototype.value = 10;
const a = new A();
A.prototype.value = 20;
console.log(a.value);
```
**Answer:** `20`

---

**Q5.** What is the output?
```js
const obj = { a: 1 };
Object.defineProperty(obj, "b", { value: 2 });
console.log(obj.b);
console.log(Object.keys(obj));
```
**Answer:** `2 and ["a"]`

---

**Q6.** What is the output?
```js
let a = 10;
const obj = {
  a: 20,
  method() { return (() => this.a)(); }
};
console.log(obj.method());
```
**Answer:** `20`

---

**Q7.** What is the output?
```js
const obj = {
  name: "John",
  getName() { return this.name; }
};
const fn = obj.getName.bind({ name: "Mike" });
console.log(fn.call({ name: "David" }));
```
**Answer:** `Mike`

---

**Q8.** What is the output?
```js
const a = {};
const b = { __proto__: a };
a.value = 10;
console.log(b.value);
b.value = 20;
console.log(a.value);
```
**Answer:** `10 10`

---

**Q9.** What happens?
```js
const user = { name: "John" };
const proxy = new Proxy(user, {
  get(target, property) {
    console.log("Accessing " + property);
    return target[property];
  },
  set(target, property, value) {
    if (typeof value !== "string") {
      throw new TypeError("Only strings allowed");
    }
    target[property] = value;
    return true;
  }
});
console.log(proxy.name);
proxy.age = 30;
```
**Answer:** Prints "Accessing name", then throws TypeError

---

**Q10.** 100 API calls via `Promise.all()`, each ~500ms, backend allows max 10 concurrent requests. Best approach?
**Answer:** Limit concurrency to 10 requests at a time

---

**Q11.** Angular `OnPush` component — parent mutates `this.user.name = "Mike"` without replacing the object reference. Likely behavior in child?
**Answer:** The child may not be checked because the input reference has not changed

---

**Q12.** Search box triggers HTTP request on every value change; a new search should cancel the previous request. Best RxJS operator?
**Answer:** `switchMap()`

---

**Q13.** Repeated Submit clicks — first click starts a request, subsequent clicks ignored until it completes. Best RxJS operator?
**Answer:** `exhaustMap()`

---

**Q14.** Primary benefit of `trackBy` (or `track`) when rendering a large list in Angular?
**Answer:** It prevents Angular from unnecessarily recreating DOM elements when item identity has not changed

---

**Q15.** Several components subscribe to the same HTTP Observable; avoid duplicate requests and replay the latest result to new subscribers. Best approach?
**Answer:** Use `shareReplay(1)`

---

**Q16.** Most likely cause of a memory leak in a long-running Angular application?
**Answer:** Long-lived subscriptions that are not properly cleaned up

---

**Q17.** A Node.js API's CPU-intensive operation slows down unrelated API requests. Best solution?
**Answer:** Use Worker Threads or move the CPU-intensive work to another process/service

---

**Q18.** Best approach to process a 5 GB file in a Node.js application?
**Answer:** Use Node.js streams

---

**Q19.** Express middleware logs `req.method` but the request never reaches the next route handler. Why?
```js
app.use((req, res, next) => {
  console.log(req.method);
});
```
**Answer:** `next()` is not called and no response is sent

---

**Q20.** Two simultaneous updates read the old value before updating, causing a lost update. Most relevant concept?
**Answer:** Optimistic/pessimistic concurrency control
