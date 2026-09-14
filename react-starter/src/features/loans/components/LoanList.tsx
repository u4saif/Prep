import { useEffect, useState } from 'react';
import { getLoans } from '../api/loansApi';
import { Loan } from '../types';
import { formatCurrency } from '../../../utils/formatCurrency';

export function LoanList() {
  const [loans, setLoans] = useState<Loan[]>([]);

  useEffect(() => {
    getLoans().then(setLoans);
  }, []);

  if (loans.length === 0) return <p className="empty-state">No open loans.</p>;

  return (
    <ul className="account-list">
      {loans.map((loan) => (
        <li key={loan.id} className="account-list__item">
          <span className="account-list__meta">
            <strong className="capitalize">{loan.type} loan</strong>{' '}
            <span className="account-list__number">
              of {formatCurrency(loan.principal, loan.currency)}
            </span>
          </span>
          <span className="account-list__balance">
            {formatCurrency(loan.outstanding, loan.currency)} owed
          </span>
        </li>
      ))}
    </ul>
  );
}
