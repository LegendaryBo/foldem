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
package com.foldem;

/**
 * Enumeration of the card suits.
 * 
 * @author Robert Strack
 */
public enum Suit {

	CLUBS("c"),
	DIAMONDS("d"),
	HEARTS("h"),
	SPADES("s");

	/**
	 * Short name of the suit (first letter of the suit).
	 */
	private String name;

	private Suit(String name) {
		this.name = name;
	}

	/**
	 * Returns the name of the suit.
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return name;
	}

}
