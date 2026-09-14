import { useAuth } from '../features/auth';
import { NotificationBell } from '../features/notifications';

export default function Header() {
  const { user, isAuthenticated, signOut } = useAuth();

  return (
    <header className="app-header">
      <h1 className="app-header__brand">Acme Bank</h1>
      {isAuthenticated && (
        <div className="app-header__actions">
          <NotificationBell />
          <span className="app-header__user">{user?.name}</span>
          <button className="btn btn-ghost btn-sm" onClick={signOut}>
            Sign out
          </button>
        </div>
      )}
    </header>
  );
}
