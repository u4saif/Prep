import { useEffect, useState } from 'react';
import { getAccounts } from '../api/accountsApi';
import { Account } from '../types';

export function useAccounts() {
  const [accounts, setAccounts] = useState<Account[]>([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    let isMounted = true;
    getAccounts().then((data) => {
      if (isMounted) {
        setAccounts(data);
        setIsLoading(false);
      }
    });
    return () => {
      isMounted = false;
    };
  }, []);

  return { accounts, isLoading };
}
