import { Card } from '../types';

const MOCK_CARDS: Card[] = [
  { id: 'c1', network: 'Visa', last4: '4821', status: 'active' },
  { id: 'c2', network: 'Mastercard', last4: '7734', status: 'active' },
];

// Mock fetch — swap for apiClient.get<Card[]>('/cards').
export async function getCards(): Promise<Card[]> {
  await new Promise((resolve) => setTimeout(resolve, 200));
  return MOCK_CARDS;
}
