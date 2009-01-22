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

import static com.foldem.game.Deck.CARD_NUMBER;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.foldem.Card;

public class DeckTest {

	@Test
	public void testDeal() {
		Deck deck = null;
		Card[] cards = null;
		Set<Card> cardSet = null;

		// dealing all cards
		deck = new Deck();
		cards = deck.deal(CARD_NUMBER);
		assertNotNull(cards);
		assertEquals(cards.length, CARD_NUMBER);
		assertEquals(new HashSet<Card>(Arrays.asList(cards)).size(),
				CARD_NUMBER);

		// two deals
		cardSet = EnumSet.noneOf(Card.class);
		deck = new Deck();

		cards = deck.deal(CARD_NUMBER / 2);
		assertNotNull(cards);
		assertEquals(cards.length, CARD_NUMBER / 2);
		cardSet.addAll(Arrays.asList(cards));
		assertEquals(cardSet.size(), CARD_NUMBER / 2);

		cards = deck.deal(CARD_NUMBER / 2);
		assertNotNull(cards);
		assertEquals(cards.length, CARD_NUMBER / 2);
		cardSet.addAll(Arrays.asList(cards));
		assertEquals(cardSet.size(), CARD_NUMBER);

		// dealing 0 cards
		deck = new Deck();
		cards = deck.deal(0);
		assertNotNull(cards);
		assertEquals(cards.length, 0);

		// dealing 1 card
		deck = new Deck();
		cardSet = EnumSet.noneOf(Card.class);
		try {
			for (int i = 0; i < CARD_NUMBER + 1; i++) {
				cards = deck.deal(1);
				assertNotNull(cards);
				assertEquals(cards.length, 1);
				cardSet.addAll(Arrays.asList(cards));
				assertEquals(cardSet.size(), i + 1);
			}
			fail();
		} catch (DealFailedException e) {
			assertEquals(cardSet.size(), CARD_NUMBER);
		}
	}

	@Test
	public void testReset() {
		Deck deck = new Deck();
		Card[] cards = null;

		cards = deck.deal(CARD_NUMBER);
		assertNotNull(cards);
		assertEquals(cards.length, CARD_NUMBER);

		deck.deal(0);

		try {
			deck.deal(1);
			fail();
		} catch (DealFailedException e) {
		}

		deck.reset();

		try {
			deck.deal(CARD_NUMBER);
		} catch (DealFailedException e) {
			fail();
		}
	}

}
