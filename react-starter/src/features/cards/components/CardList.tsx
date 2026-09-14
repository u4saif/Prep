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
    <ul>
      {cards.map((card) => (
        <li key={card.id}>
          {card.network} •••• {card.last4} — {card.status}{' '}
          <button onClick={() => toggleStatus(card.id)}>
            {card.status === 'active' ? 'Block' : 'Unblock'}
          </button>
        </li>
      ))}
    </ul>
  );
}
