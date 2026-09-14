import { Transaction } from '../types';

const MOCK_TRANSACTIONS: Transaction[] = [
  { id: 't1', accountId: 'a1', date: '2026-09-10', description: 'Grocery Store', amount: 84.32, currency: 'USD', type: 'debit' },
  { id: 't2', accountId: 'a1', date: '2026-09-08', description: 'Payroll Deposit', amount: 2450.0, currency: 'USD', type: 'credit' },
  { id: 't3', accountId: 'a2', date: '2026-09-05', description: 'Interest Payment', amount: 12.44, currency: 'USD', type: 'credit' },
];

// Mock fetch — swap for apiClient.get<Transaction[]>(`/accounts/${accountId}/transactions`).
export async function getTransactions(accountId?: string): Promise<Transaction[]> {
  await new Promise((resolve) => setTimeout(resolve, 200));
  return accountId ? MOCK_TRANSACTIONS.filter((t) => t.accountId === accountId) : MOCK_TRANSACTIONS;
}
