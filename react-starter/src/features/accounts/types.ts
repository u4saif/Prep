export interface Account {
  id: string;
  name: string;
  type: 'checking' | 'savings';
  accountNumber: string;
  balance: number;
  currency: string;
}
