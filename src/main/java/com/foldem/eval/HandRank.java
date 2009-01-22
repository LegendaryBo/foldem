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
package com.foldem.eval;

import java.io.Serializable;

public class HandRank implements Comparable<HandRank>, Serializable {

	private static final long serialVersionUID = 6897360347770643227L;

	private static final int[] TYPE_COUNT = { 1277, 2860, 858, 858, 10,
		1277, 156, 156, 10 };

	private final int id;

	public HandRank(int handRankId) {
		super();
		this.id = handRankId;
	}

	@Override
	public int compareTo(HandRank rank) {
		return id < rank.id ? -1 : (id == rank.id ? 0 : 1);
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object object) {
		return (object instanceof HandRank) && (id == ((HandRank) object).id);
	}

	public int getId() {
		return id;
	}

	public HandType getHandType() {
		for (int i = 0, total = 0; i < TYPE_COUNT.length; i++) {
			if ((total += TYPE_COUNT[i]) > id) {
				return HandType.values()[i];
			}
		}
		throw new EvaluationFailedException("unknown hand type");
	}

}
