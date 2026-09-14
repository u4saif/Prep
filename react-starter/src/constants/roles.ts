export const ROLES = {
  CUSTOMER: 'customer',
  SUPPORT: 'support',
  ADMIN: 'admin',
} as const;

export type Role = (typeof ROLES)[keyof typeof ROLES];

export const PERMISSIONS = {
  VIEW_ACCOUNTS: 'accounts:view',
  CREATE_TRANSFER: 'transfer:create',
  MANAGE_CARDS: 'cards:manage',
  VIEW_ADMIN_TOOLS: 'admin:view',
} as const;

export type Permission = (typeof PERMISSIONS)[keyof typeof PERMISSIONS];

export const ROLE_PERMISSIONS: Record<Role, Permission[]> = {
  [ROLES.CUSTOMER]: [
    PERMISSIONS.VIEW_ACCOUNTS,
    PERMISSIONS.CREATE_TRANSFER,
    PERMISSIONS.MANAGE_CARDS,
  ],
  [ROLES.SUPPORT]: [PERMISSIONS.VIEW_ACCOUNTS],
  [ROLES.ADMIN]: [
    PERMISSIONS.VIEW_ACCOUNTS,
    PERMISSIONS.CREATE_TRANSFER,
    PERMISSIONS.MANAGE_CARDS,
    PERMISSIONS.VIEW_ADMIN_TOOLS,
  ],
};
