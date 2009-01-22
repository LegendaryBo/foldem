/**
 * Copyright (C) 2009 Robert Strack
 *
 * This file is part of Foldem.
 *
 * Foldem is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * code_swarm is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Foldem.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.foldem.game;

import java.util.EnumSet;
import java.util.Random;

import com.foldem.Card;

public class Deck {

	public static final int CARD_NUMBER = Card.values().length;

	private final EnumSet<Card> cards = EnumSet.noneOf(Card.class);

	{
		reset();
	}

	public Card[] deal(int cardNumber) throws DealFailedException {
		if (cardNumber + cards.size() > CARD_NUMBER) {
			throw new DealFailedException("the deck is too small");
		}

		Card[] deal = new Card[cardNumber];
		Random random = new Random();
		for (int i = 0; i < deal.length; i++) {
			Card card = null;
			do {
				card = Card.values()[random.nextInt(CARD_NUMBER)];
			} while (cards.contains(card));
			cards.add(card);
			deal[i] = card;
		}
		return deal;
	}

	public void reset() {
		cards.clear();
	}

}
