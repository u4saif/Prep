import { useTransactions } from '../hooks/useTransactions';
import { formatCurrency } from '../../../utils/formatCurrency';

export function TransactionList({ accountId }: { accountId?: string }) {
  const { transactions, isLoading } = useTransactions(accountId);

  if (isLoading) return <p>Loading transactions…</p>;

  return (
    <table>
      <thead>
        <tr>
          <th>Date</th>
          <th>Description</th>
          <th>Amount</th>
        </tr>
      </thead>
      <tbody>
        {transactions.map((tx) => (
          <tr key={tx.id}>
            <td>{tx.date}</td>
            <td>{tx.description}</td>
            <td>
              {tx.type === 'debit' ? '-' : '+'}
              {formatCurrency(tx.amount, tx.currency)}
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}
