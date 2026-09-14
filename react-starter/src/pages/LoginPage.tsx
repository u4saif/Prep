import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { LoginForm, useAuth } from '../features/auth';
import { ROUTES } from '../constants/routes';

export default function LoginPage() {
  const { isAuthenticated } = useAuth();
  const navigate = useNavigate();

  useEffect(() => {
    if (isAuthenticated) navigate(ROUTES.DASHBOARD, { replace: true });
  }, [isAuthenticated, navigate]);

  return (
    <div className="auth-page">
      <div className="auth-card">
        <p className="auth-card__brand">Acme Bank</p>
        <p className="auth-card__subtitle">Sign in to manage your accounts</p>
        <h2 className="sr-only">Sign in</h2>
        <LoginForm />
      </div>
    </div>
  );
}
