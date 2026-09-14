import { Permission, Role, ROLE_PERMISSIONS } from '../constants/roles';

export function hasPermission(role: Role | undefined, permission: Permission): boolean {
  if (!role) return false;
  return ROLE_PERMISSIONS[role].includes(permission);
}
