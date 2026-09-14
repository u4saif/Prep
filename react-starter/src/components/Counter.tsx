import { useState } from 'react';

function Counter() {
  const [count, setCount] = useState(0);
  const increment = (operationName: string) => {
    if (operationName === 'increment') {
      setCount(count + 1);
    } else if (operationName === 'decrement') {
      setCount(count - 1);
    }
  };
  return (
    <div className="counter">
      <button className="btn btn-secondary" onClick={() => increment('decrement')}>
        Decrement
      </button>
      <p className="counter__value">{count}</p>
      <button className="btn btn-primary" onClick={() => increment('increment')}>
        Increment
      </button>
    </div>
  );
}

export default Counter;
