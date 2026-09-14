import { TransferRequest } from './types';

export function validateTransfer(request: TransferRequest): string[] {
  const errors: string[] = [];

  if (!request.fromAccountId) errors.push('Select an account to transfer from.');
  if (!request.toAccountId) errors.push('Select an account to transfer to.');
  if (request.fromAccountId && request.fromAccountId === request.toAccountId) {
    errors.push('Source and destination accounts must be different.');
  }
  if (!request.amount || request.amount <= 0) errors.push('Enter an amount greater than zero.');

  return errors;
}
