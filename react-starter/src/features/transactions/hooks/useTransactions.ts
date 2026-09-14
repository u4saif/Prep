import { useEffect, useState } from 'react';
import { getTransactions } from '../api/transactionsApi';
import { Transaction } from '../types';

export function useTransactions(accountId?: string) {
  const [transactions, setTransactions] = useState<Transaction[]>([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    let isMounted = true;
    setIsLoading(true);
    getTransactions(accountId).then((data) => {
      if (isMounted) {
        setTransactions(data);
        setIsLoading(false);
      }
    });
    return () => {
      isMounted = false;
    };
  }, [accountId]);

  return { transactions, isLoading };
}
