import { useState } from 'react';
import { useAuthContext } from '../../../store/AuthContext';
import { login as loginRequest } from '../api/authApi';
import { Credentials } from '../types';

export function useAuth() {
  const { user, isAuthenticated, login, logout } = useAuthContext();
  const [isLoggingIn, setIsLoggingIn] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const signIn = async (credentials: Credentials) => {
    setIsLoggingIn(true);
    setError(null);
    try {
      const { user: nextUser, token } = await loginRequest(credentials);
      login(nextUser, token);
    } catch {
      setError('Unable to sign in. Check your credentials and try again.');
    } finally {
      setIsLoggingIn(false);
    }
  };

  return { user, isAuthenticated, isLoggingIn, error, signIn, signOut: logout };
}
