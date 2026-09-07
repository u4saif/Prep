import React, { useState } from "react";

 

function Counter() {
    const [count, setCount] = useState(0);
    const increment = (operationName: string) => {
        if (operationName === "increment") {
            setCount(count + 1);
        } else if (operationName === "decrement") {
            setCount(count - 1);
        }
    }
    return (
    <div>
       <button onClick={() => increment("increment")}>Increment</button>
       <p>Counter: {count}</p>
       <button onClick={() => increment("decrement")}>Decrement</button>
    </div>
  )
}

export default Counter