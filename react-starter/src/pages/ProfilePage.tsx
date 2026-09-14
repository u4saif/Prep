import { useAuth } from '../features/auth';

export default function ProfilePage() {
  const { user } = useAuth();

  return (
    <section>
      <h2>Profile</h2>
      <p>Name: {user?.name}</p>
      <p>Role: {user?.role}</p>
    </section>
  );
}
