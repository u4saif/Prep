import { LoanList } from '../features/loans';

export default function LoansPage() {
  return (
    <div className="page">
      <h2 className="page__title">Loans</h2>
      <div className="panel">
        <LoanList />
      </div>
    </div>
  );
}
