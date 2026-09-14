export const env = {
  apiBaseUrl: process.env.REACT_APP_API_BASE_URL ?? 'http://localhost:4000/api',
  idleTimeoutMs: Number(process.env.REACT_APP_IDLE_TIMEOUT_MS ?? 5 * 60 * 1000),
};
