import Counter from '../components/Counter';

export default function PlaygroundPage() {
  return (
    <div className="page">
      <h2 className="page__title">Playground</h2>
      <div className="panel">
        <Counter />
      </div>
    </div>
  );
}
