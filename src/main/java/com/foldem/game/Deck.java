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
 * Foldem is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Foldem.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.foldem.game;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import com.foldem.Card;

/**
 * The card deck contains base "card operations" (ie. card dealing).
 * 
 * @author Robert Strack
 */
public class Deck implements Set<Card> {

	public static final int CARD_NUMBER = Card.values().length;

	private final EnumSet<Card> cards = EnumSet.allOf(Card.class);

	{
		reset();
	}

	/**
	 * Deals cards.
	 * 
	 * @param cardNumber
	 *            number cards to deal
	 * @return cards (array of length <code>cardNumber</code>
	 * @throws DealFailedException
	 *             if dealing is impossible (ie. deck is empty)
	 */
	public Card[] deal(int cardNumber) throws DealFailedException {
		if (cardNumber > cards.size()) {
			throw new DealFailedException("the deck is too small");
		}

		Card[] deal = new Card[cardNumber];
		Random random = new Random();
		for (int i = 0; i < deal.length; i++) {
			Card card = null;
			do {
				card = Card.values()[random.nextInt(CARD_NUMBER)];
			} while (!cards.contains(card));
			cards.remove(card);
			deal[i] = card;
		}
		return deal;
	}

	/**
	 * Resets card deck (restores initial state).
	 */
	public final void reset() {
		cards.addAll(EnumSet.allOf(Card.class));
	}

	@Override
	public final boolean add(Card e) {
		return cards.add(e);
	}

	@Override
	public final boolean addAll(Collection<? extends Card> c) {
		return cards.addAll(c);
	}

	@Override
	public final void clear() {
		cards.clear();
	}

	@Override
	public final boolean contains(Object o) {
		return cards.contains(o);
	}

	@Override
	public final boolean containsAll(Collection<?> c) {
		return cards.containsAll(c);
	}

	@Override
	public final boolean isEmpty() {
		return cards.isEmpty();
	}

	@Override
	public final Iterator<Card> iterator() {
		return cards.iterator();
	}

	@Override
	public final boolean remove(Object o) {
		return cards.remove(o);
	}

	@Override
	public final boolean removeAll(Collection<?> c) {
		return cards.removeAll(c);
	}

	@Override
	public final boolean retainAll(Collection<?> c) {
		return cards.removeAll(c);
	}

	@Override
	public final int size() {
		return cards.size();
	}

	@Override
	public final Object[] toArray() {
		return cards.toArray();
	}

	@Override
	public final <T> T[] toArray(T[] a) {
		return cards.toArray(a);
	}

}
