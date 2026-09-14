import { Loan } from '../types';

const MOCK_LOANS: Loan[] = [
  { id: 'l1', type: 'auto', principal: 24000, outstanding: 9120.5, currency: 'USD' },
];

// Mock fetch — swap for apiClient.get<Loan[]>('/loans').
export async function getLoans(): Promise<Loan[]> {
  await new Promise((resolve) => setTimeout(resolve, 200));
  return MOCK_LOANS;
}
