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
    <div className="notif-bell">
      <button className="btn btn-ghost btn-sm notif-bell__trigger" onClick={() => setIsOpen((open) => !open)}>
        Notifications
        {unreadCount > 0 && <span className="notif-bell__count">{unreadCount}</span>}
      </button>
      {isOpen && (
        <ul className="notif-bell__panel">
          {notifications.length === 0 ? (
            <li className="notif-bell__empty">No notifications</li>
          ) : (
            notifications.map((n) => <li key={n.id}>{n.message}</li>)
          )}
        </ul>
      )}
    </div>
  );
}
