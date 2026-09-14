export function maskAccountNumber(accountNumber: string, visibleDigits: number = 4): string {
  const visible = accountNumber.slice(-visibleDigits);
  return `${'*'.repeat(Math.max(accountNumber.length - visibleDigits, 0))}${visible}`;
}
