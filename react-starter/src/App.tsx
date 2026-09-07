import './App.css';
import Counter from './components/Counter';
import Header from './components/Header';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Header />
      </header>
      <Counter />
    </div>
  );
}

export default App;
