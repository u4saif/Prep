export interface Card {
  id: string;
  network: 'Visa' | 'Mastercard';
  last4: string;
  status: 'active' | 'blocked';
}
