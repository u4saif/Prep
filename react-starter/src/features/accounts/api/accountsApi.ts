import { Account } from '../types';

const MOCK_ACCOUNTS: Account[] = [
  { id: 'a1', name: 'Everyday Checking', type: 'checking', accountNumber: '4041562398', balance: 3240.55, currency: 'USD' },
  { id: 'a2', name: 'High-Yield Savings', type: 'savings', accountNumber: '8827301145', balance: 15230.12, currency: 'USD' },
];

// Mock fetch — swap for apiClient.get<Account[]>('/accounts').
export async function getAccounts(): Promise<Account[]> {
  await new Promise((resolve) => setTimeout(resolve, 200));
  return MOCK_ACCOUNTS;
}
