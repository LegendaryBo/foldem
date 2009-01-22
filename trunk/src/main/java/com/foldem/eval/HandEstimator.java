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
package com.foldem.eval;

import com.foldem.Card;

/**
 * Estimates the strength of the hand.
 * 
 * @param <E> estimation result class
 *
 * @author Robert Strack
 */
public interface HandEstimator<E> {

	/**
	 * Estimates hand strength.
	 * 
	 * @param cards
	 *            exactly 2, 5, 6 or 7 unique cards (first 2 cards must be
	 *            player's hand)
	 * @return estimation result
	 * @throws EstimationFailedException
	 *             if hand strength estimation was impossible for some reason
	 */
	E estimate(Card... cards) throws EstimationFailedException;

}
