import { KycStatus } from '../types';

// Mock submit — swap for a real multipart upload to apiClient.
export async function submitKycDocument(file: File): Promise<{ status: KycStatus }> {
  await new Promise((resolve) => setTimeout(resolve, 300));
  return { status: 'pending_review' };
}
