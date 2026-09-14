import { AccountList } from '../features/accounts';
import { TransactionList } from '../features/transactions';

export default function DashboardPage() {
  return (
    <section>
      <h2>Accounts</h2>
      <AccountList />
      <h2>Recent Transactions</h2>
      <TransactionList />
    </section>
  );
}
