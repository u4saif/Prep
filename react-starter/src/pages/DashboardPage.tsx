import { AccountList } from '../features/accounts';
import { TransactionList } from '../features/transactions';

export default function DashboardPage() {
  return (
    <div className="page">
      <h2 className="page__title">Accounts</h2>
      <div className="panel">
        <AccountList />
      </div>
      <h2 className="page__title">Recent Transactions</h2>
      <div className="panel">
        <TransactionList />
      </div>
    </div>
  );
}
