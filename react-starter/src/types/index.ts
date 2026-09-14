export type ISODateString = string;

export interface Money {
  amount: number;
  currency: string;
}

export interface Paginated<T> {
  items: T[];
  total: number;
}
