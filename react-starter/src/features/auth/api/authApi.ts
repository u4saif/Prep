import { AuthUser } from '../../../store/AuthContext';
import { ROLES } from '../../../constants/roles';
import { Credentials } from '../types';

// Mock login — swap for a real apiClient.post('/auth/login', credentials) call.
export async function login(credentials: Credentials): Promise<{ user: AuthUser; token: string }> {
  await new Promise((resolve) => setTimeout(resolve, 300));

  return {
    user: { id: 'u1', name: credentials.email.split('@')[0] || 'Customer', role: ROLES.CUSTOMER },
    token: 'mock-session-token',
  };
}
