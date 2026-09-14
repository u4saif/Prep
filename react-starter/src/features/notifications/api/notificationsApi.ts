import { AppNotification } from '../types';

const MOCK_NOTIFICATIONS: AppNotification[] = [
  { id: 'n1', message: 'Your statement for August is ready.', read: false },
  { id: 'n2', message: 'New sign-in from a Chrome browser.', read: false },
];

// Mock fetch — swap for apiClient.get<AppNotification[]>('/notifications').
export async function getNotifications(): Promise<AppNotification[]> {
  await new Promise((resolve) => setTimeout(resolve, 150));
  return MOCK_NOTIFICATIONS;
}
