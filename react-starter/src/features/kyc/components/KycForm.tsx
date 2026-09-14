import { ChangeEvent, useState } from 'react';
import { submitKycDocument } from '../api/kycApi';
import { KycStatus } from '../types';

const STATUS_BADGE: Record<KycStatus, string> = {
  not_started: 'badge-neutral',
  pending_review: 'badge-warning',
  verified: 'badge-success',
  rejected: 'badge-danger',
};

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
    <div className="form">
      <div className="form-field">
        <label>Verification status</label>
        <span className={`badge ${STATUS_BADGE[status]}`}>
          {status.replace('_', ' ')}
        </span>
      </div>
      <div className="form-field">
        <label htmlFor="kyc-document">Upload identity document</label>
        <input id="kyc-document" type="file" onChange={handleFileChange} disabled={isUploading} />
      </div>
    </div>
  );
}
