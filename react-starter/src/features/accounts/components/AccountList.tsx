import { useAccounts } from '../hooks/useAccounts';
import { formatCurrency } from '../../../utils/formatCurrency';
import { maskAccountNumber } from '../../../utils/maskAccountNumber';

export function AccountList() {
  const { accounts, isLoading } = useAccounts();

  if (isLoading) return <p>Loading accounts…</p>;

  return (
    <ul>
      {accounts.map((account) => (
        <li key={account.id}>
          <strong>{account.name}</strong> ({maskAccountNumber(account.accountNumber)}) —{' '}
          {formatCurrency(account.balance, account.currency)}
        </li>
      ))}
    </ul>
  );
}
