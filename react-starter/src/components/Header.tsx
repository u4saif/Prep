import { useAuth } from '../features/auth';
import { NotificationBell } from '../features/notifications';

export default function Header() {
  const { user, isAuthenticated, signOut } = useAuth();

  return (
    <header className="App-header">
      <h1>Acme Bank</h1>
      {isAuthenticated && (
        <div>
          <NotificationBell />
          <span>{user?.name}</span>
          <button onClick={signOut}>Sign out</button>
        </div>
      )}
    </header>
  );
}
