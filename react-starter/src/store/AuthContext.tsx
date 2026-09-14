import { createContext, ReactNode, useContext, useMemo, useState } from 'react';
import { Role } from '../constants/roles';
import { clearSessionToken, saveSessionToken } from '../lib/security';
import { setAuthToken } from '../lib/api-client';

export interface AuthUser {
  id: string;
  name: string;
  role: Role;
}

interface AuthContextValue {
  user: AuthUser | null;
  isAuthenticated: boolean;
  login: (user: AuthUser, token: string) => void;
  logout: () => void;
}

const AuthContext = createContext<AuthContextValue | undefined>(undefined);

export function AuthProvider({ children }: { children: ReactNode }) {
  const [user, setUser] = useState<AuthUser | null>(null);

  const value = useMemo<AuthContextValue>(
    () => ({
      user,
      isAuthenticated: user !== null,
      login: (nextUser, token) => {
        setAuthToken(token);
        saveSessionToken(token);
        setUser(nextUser);
      },
      logout: () => {
        setAuthToken(null);
        clearSessionToken();
        setUser(null);
      },
    }),
    [user]
  );

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
}

export function useAuthContext(): AuthContextValue {
  const ctx = useContext(AuthContext);
  if (!ctx) throw new Error('useAuthContext must be used within an AuthProvider');
  return ctx;
}
