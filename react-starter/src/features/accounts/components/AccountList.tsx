import { useAccounts } from '../hooks/useAccounts';
import { formatCurrency } from '../../../utils/formatCurrency';
import { maskAccountNumber } from '../../../utils/maskAccountNumber';

export function AccountList() {
  const { accounts, isLoading } = useAccounts();

  if (isLoading) return <p className="empty-state">Loading accounts…</p>;

  return (
    <ul className="account-list">
      {accounts.map((account) => (
        <li key={account.id} className="account-list__item">
          <span className="account-list__meta">
            <strong>{account.name}</strong>{' '}
            <span className="account-list__number">
              ({maskAccountNumber(account.accountNumber)})
            </span>
          </span>
          <span className="account-list__balance">
            {formatCurrency(account.balance, account.currency)}
          </span>
        </li>
      ))}
    </ul>
  );
}
