export interface Loan {
  id: string;
  type: 'auto' | 'mortgage' | 'personal';
  principal: number;
  outstanding: number;
  currency: string;
}
