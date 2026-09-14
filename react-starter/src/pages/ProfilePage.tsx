import { useAuth } from '../features/auth';

export default function ProfilePage() {
  const { user } = useAuth();

  return (
    <div className="page">
      <h2 className="page__title">Profile</h2>
      <div className="panel account-list">
        <div className="account-list__item">
          <span className="account-list__meta">Name</span>
          <span className="account-list__balance">{user?.name}</span>
        </div>
        <div className="account-list__item">
          <span className="account-list__meta">Role</span>
          <span className="account-list__balance">{user?.role}</span>
        </div>
      </div>
    </div>
  );
}
