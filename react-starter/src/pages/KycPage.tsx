import { KycForm } from '../features/kyc';

export default function KycPage() {
  return (
    <div className="page">
      <h2 className="page__title">Identity Verification</h2>
      <div className="panel">
        <KycForm />
      </div>
    </div>
  );
}
