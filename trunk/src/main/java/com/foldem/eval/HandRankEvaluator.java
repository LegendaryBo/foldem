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
 * Evaluator of the Texas Hold'em poker hands. Evalutators need not to be thread
 * safe.
 * 
 * @author Robert Strack
 */
public interface HandRankEvaluator {

	/**
	 * Evaluates hand rank. Caller must pass exactly 7 unique cards.
	 * 
	 * @param cards
	 *            exactly 7 unique cards
	 * @return hand rank for particular hand
	 * @throws EvaluationFailedException
	 *             if hand evaluation was impossible for some reason
	 */
	HandRank evaluate(Card... cards) throws EvaluationFailedException;

}
