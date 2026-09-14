import { Navigate, Route, Routes } from 'react-router-dom';
import { AppLayout } from '../layouts/AppLayout';
import { RequireAuth } from './RequireAuth';
import { ROUTES } from '../constants/routes';
import LoginPage from '../pages/LoginPage';
import DashboardPage from '../pages/DashboardPage';
import TransfersPage from '../pages/TransfersPage';
import CardsPage from '../pages/CardsPage';
import LoansPage from '../pages/LoansPage';
import KycPage from '../pages/KycPage';
import ProfilePage from '../pages/ProfilePage';
import PlaygroundPage from '../pages/PlaygroundPage';

export function AppRoutes() {
  return (
    <Routes>
      <Route path={ROUTES.LOGIN} element={<LoginPage />} />
      <Route
        element={
          <RequireAuth>
            <AppLayout />
          </RequireAuth>
        }
      >
        <Route path={ROUTES.DASHBOARD} element={<DashboardPage />} />
        <Route path={ROUTES.TRANSFERS} element={<TransfersPage />} />
        <Route path={ROUTES.CARDS} element={<CardsPage />} />
        <Route path={ROUTES.LOANS} element={<LoansPage />} />
        <Route path={ROUTES.KYC} element={<KycPage />} />
        <Route path={ROUTES.PROFILE} element={<ProfilePage />} />
        <Route path={ROUTES.PLAYGROUND} element={<PlaygroundPage />} />
      </Route>
      <Route path="*" element={<Navigate to={ROUTES.DASHBOARD} replace />} />
    </Routes>
  );
}
