import { FormEvent, useState } from 'react';
import { useAccounts } from '../../accounts';
import { useTransfer } from '../hooks/useTransfer';

export function TransferForm() {
  const { accounts } = useAccounts();
  const { transfer, isSubmitting, errors, confirmationId } = useTransfer();
  const [fromAccountId, setFromAccountId] = useState('');
  const [toAccountId, setToAccountId] = useState('');
  const [amount, setAmount] = useState('');

  const handleSubmit = (e: FormEvent) => {
    e.preventDefault();
    transfer({ fromAccountId, toAccountId, amount: Number(amount) });
  };

  if (confirmationId) {
    return <p>Transfer submitted. Confirmation #{confirmationId}</p>;
  }

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label htmlFor="from">From</label>
        <select id="from" value={fromAccountId} onChange={(e) => setFromAccountId(e.target.value)}>
          <option value="">Select account</option>
          {accounts.map((a) => (
            <option key={a.id} value={a.id}>
              {a.name}
            </option>
          ))}
        </select>
      </div>
      <div>
        <label htmlFor="to">To</label>
        <select id="to" value={toAccountId} onChange={(e) => setToAccountId(e.target.value)}>
          <option value="">Select account</option>
          {accounts.map((a) => (
            <option key={a.id} value={a.id}>
              {a.name}
            </option>
          ))}
        </select>
      </div>
      <div>
        <label htmlFor="amount">Amount</label>
        <input
          id="amount"
          type="number"
          min="0"
          step="0.01"
          value={amount}
          onChange={(e) => setAmount(e.target.value)}
        />
      </div>
      {errors.length > 0 && (
        <ul role="alert">
          {errors.map((error) => (
            <li key={error}>{error}</li>
          ))}
        </ul>
      )}
      <button type="submit" disabled={isSubmitting}>
        {isSubmitting ? 'Submitting…' : 'Transfer'}
      </button>
    </form>
  );
}
