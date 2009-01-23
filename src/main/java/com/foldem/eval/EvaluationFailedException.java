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

import com.foldem.FoldemException;

/**
 * Exception thrown when hand rank evaluation is not possible.
 * 
 * @author Robert Strack
 */
public class EvaluationFailedException extends FoldemException {

	private static final long serialVersionUID = 1857708768352743195L;

	public EvaluationFailedException() {
		super();
	}

	public EvaluationFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public EvaluationFailedException(String message) {
		super(message);
	}

	public EvaluationFailedException(Throwable cause) {
		super(cause);
	}

}
