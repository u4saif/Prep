import { TransferForm } from '../features/transfers';

export default function TransfersPage() {
  return (
    <div className="page">
      <h2 className="page__title">Transfer Funds</h2>
      <div className="panel">
        <TransferForm />
      </div>
    </div>
  );
}
