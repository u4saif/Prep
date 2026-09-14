import { useEffect, useState } from 'react';
import { getCards } from '../api/cardsApi';
import { Card } from '../types';

export function CardList() {
  const [cards, setCards] = useState<Card[]>([]);

  useEffect(() => {
    getCards().then(setCards);
  }, []);

  const toggleStatus = (id: string) => {
    setCards((prev) =>
      prev.map((card) =>
        card.id === id
          ? { ...card, status: card.status === 'active' ? 'blocked' : 'active' }
          : card
      )
    );
  };

  return (
    <div className="tile-grid">
      {cards.map((card) => (
        <div key={card.id} className="tile">
          <div className="tile__row">
            <span className="tile__title">{card.network}</span>
            <span className={`badge ${card.status === 'active' ? 'badge-success' : 'badge-danger'}`}>
              {card.status}
            </span>
          </div>
          <span className="tile__subtitle">•••• •••• •••• {card.last4}</span>
          <button className="btn btn-secondary btn-sm" onClick={() => toggleStatus(card.id)}>
            {card.status === 'active' ? 'Block card' : 'Unblock card'}
          </button>
        </div>
      ))}
    </div>
  );
}
