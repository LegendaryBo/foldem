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
package com.foldem.util;

import static com.foldem.eval.FSMHandRankEvaluator.RANKS_TRANSITIONS_RESOURCE_NAME;
import static com.foldem.eval.FSMHandRankEvaluator.SUIT_TRANSITIONS_RESOURCE_NAME;
import static com.foldem.eval.FSMHandRankEvaluator.SUIT_VALUES_RESOURCE_NAME;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * @author Robert Strack
 *
 */
public class ResourceReaderTest {

	/**
	 * Test method for {@link com.foldem.util.ResourceReader#loadResource(java.lang.String)}.
	 */
	@Test
	public void testLoadResource() {
		short[][] resource = null;

		try {
			resource = ResourceReader.loadResource(RANKS_TRANSITIONS_RESOURCE_NAME);
			assertNotNull(resource);
			assertTrue(resource.length > 0);
		} catch (Exception e) {
			fail();
		}

		try {
			resource = ResourceReader.loadResource(SUIT_TRANSITIONS_RESOURCE_NAME);
			assertNotNull(resource);
			assertTrue(resource.length > 0);
		} catch (Exception e) {
			fail();
		}

		try {
			resource = ResourceReader.loadResource(SUIT_VALUES_RESOURCE_NAME);
			assertNotNull(resource);
			assertTrue(resource.length > 0);
		} catch (Exception e) {
			fail();
		}
	}

	/**
	 * Test method for {@link com.foldem.util.ResourceReader#loadResource(java.lang.String)}.
	 */
	@Test
	public void testLoadResourceFailure() {
		try {
			ResourceReader.loadResource("unknown_resource");
			fail();
		} catch (ResourceLoadFailureException e) {
			assertNotNull(e.getMessage());
		} catch (Exception e) {
			fail();
		}
	}

}
