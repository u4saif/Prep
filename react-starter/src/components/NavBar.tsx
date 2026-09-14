import { NavLink } from 'react-router-dom';
import { ROUTES } from '../constants/routes';
import { useAuth } from '../features/auth';

const NAV_ITEMS = [
  { label: 'Dashboard', to: ROUTES.DASHBOARD },
  { label: 'Transfers', to: ROUTES.TRANSFERS },
  { label: 'Cards', to: ROUTES.CARDS },
  { label: 'Loans', to: ROUTES.LOANS },
  { label: 'KYC', to: ROUTES.KYC },
  { label: 'Profile', to: ROUTES.PROFILE },
  { label: 'Playground', to: ROUTES.PLAYGROUND },
];

export default function NavBar() {
  const { isAuthenticated } = useAuth();

  if (!isAuthenticated) return null;

  return (
    <nav>
      {NAV_ITEMS.map((item) => (
        <NavLink key={item.to} to={item.to}>
          {item.label}
        </NavLink>
      ))}
    </nav>
  );
}
