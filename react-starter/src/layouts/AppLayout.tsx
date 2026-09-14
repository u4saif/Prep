import { Outlet } from 'react-router-dom';
import Header from '../components/Header';
import NavBar from '../components/NavBar';
import { useAuth } from '../features/auth';
import { useIdleTimeout } from '../hooks/useIdleTimeout';
import { env } from '../config/env';

export function AppLayout() {
  const { signOut } = useAuth();
  useIdleTimeout(signOut, env.idleTimeoutMs);

  return (
    <div className="app-shell">
      <Header />
      <NavBar />
      <main className="app-main">
        <Outlet />
      </main>
    </div>
  );
}
