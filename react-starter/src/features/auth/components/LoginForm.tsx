import { FormEvent, useState } from 'react';
import { useAuth } from '../hooks/useAuth';

export function LoginForm() {
  const { signIn, isLoggingIn, error } = useAuth();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (e: FormEvent) => {
    e.preventDefault();
    signIn({ email, password });
  };

  return (
    <form className="form" onSubmit={handleSubmit}>
      <div className="form-field">
        <label htmlFor="email">Email</label>
        <input
          id="email"
          type="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />
      </div>
      <div className="form-field">
        <label htmlFor="password">Password</label>
        <input
          id="password"
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
      </div>
      {error && (
        <ul className="form-errors" role="alert">
          <li>{error}</li>
        </ul>
      )}
      <button className="btn btn-primary" type="submit" disabled={isLoggingIn}>
        {isLoggingIn ? 'Signing in…' : 'Sign in'}
      </button>
    </form>
  );
}
