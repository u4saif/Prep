import { useEffect, useState } from 'react';
import { getLoans } from '../api/loansApi';
import { Loan } from '../types';
import { formatCurrency } from '../../../utils/formatCurrency';

export function LoanList() {
  const [loans, setLoans] = useState<Loan[]>([]);

  useEffect(() => {
    getLoans().then(setLoans);
  }, []);

  if (loans.length === 0) return <p>No open loans.</p>;

  return (
    <ul>
      {loans.map((loan) => (
        <li key={loan.id}>
          {loan.type} loan — outstanding {formatCurrency(loan.outstanding, loan.currency)} of{' '}
          {formatCurrency(loan.principal, loan.currency)}
        </li>
      ))}
    </ul>
  );
}
