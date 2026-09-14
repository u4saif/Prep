import { ChangeEvent, useState } from 'react';
import { submitKycDocument } from '../api/kycApi';
import { KycStatus } from '../types';

export function KycForm() {
  const [status, setStatus] = useState<KycStatus>('not_started');
  const [isUploading, setIsUploading] = useState(false);

  const handleFileChange = async (e: ChangeEvent<HTMLInputElement>) => {
    const file = e.target.files?.[0];
    if (!file) return;

    setIsUploading(true);
    const result = await submitKycDocument(file);
    setStatus(result.status);
    setIsUploading(false);
  };

  return (
    <div>
      <p>Verification status: {status.replace('_', ' ')}</p>
      <label htmlFor="kyc-document">Upload identity document</label>
      <input id="kyc-document" type="file" onChange={handleFileChange} disabled={isUploading} />
    </div>
  );
}
