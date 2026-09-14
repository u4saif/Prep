const SESSION_TOKEN_KEY = 'session_token';

// sessionStorage (not localStorage): token is dropped when the tab closes,
// which is the expected behavior for a banking session.
export function saveSessionToken(token: string) {
  sessionStorage.setItem(SESSION_TOKEN_KEY, token);
}

export function readSessionToken(): string | null {
  return sessionStorage.getItem(SESSION_TOKEN_KEY);
}

export function clearSessionToken() {
  sessionStorage.removeItem(SESSION_TOKEN_KEY);
}
