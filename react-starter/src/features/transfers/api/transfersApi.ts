import { TransferRequest } from '../types';

// Mock submit — swap for apiClient.post('/transfers', request).
export async function submitTransfer(request: TransferRequest): Promise<{ id: string }> {
  await new Promise((resolve) => setTimeout(resolve, 300));
  return { id: `tr_${Date.now()}` };
}
