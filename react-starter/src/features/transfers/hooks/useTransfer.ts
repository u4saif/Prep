import { useState } from 'react';
import { submitTransfer } from '../api/transfersApi';
import { validateTransfer } from '../schema';
import { TransferRequest } from '../types';

export function useTransfer() {
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [errors, setErrors] = useState<string[]>([]);
  const [confirmationId, setConfirmationId] = useState<string | null>(null);

  const transfer = async (request: TransferRequest) => {
    const validationErrors = validateTransfer(request);
    if (validationErrors.length > 0) {
      setErrors(validationErrors);
      return;
    }

    setErrors([]);
    setIsSubmitting(true);
    try {
      const { id } = await submitTransfer(request);
      setConfirmationId(id);
    } finally {
      setIsSubmitting(false);
    }
  };

  return { transfer, isSubmitting, errors, confirmationId };
}
