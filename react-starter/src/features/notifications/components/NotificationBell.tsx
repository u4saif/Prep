import { useEffect, useState } from 'react';
import { getNotifications } from '../api/notificationsApi';
import { AppNotification } from '../types';

export function NotificationBell() {
  const [notifications, setNotifications] = useState<AppNotification[]>([]);
  const [isOpen, setIsOpen] = useState(false);

  useEffect(() => {
    getNotifications().then(setNotifications);
  }, []);

  const unreadCount = notifications.filter((n) => !n.read).length;

  return (
    <div>
      <button onClick={() => setIsOpen((open) => !open)}>
        Notifications ({unreadCount})
      </button>
      {isOpen && (
        <ul>
          {notifications.map((n) => (
            <li key={n.id}>{n.message}</li>
          ))}
        </ul>
      )}
    </div>
  );
}
