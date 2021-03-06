/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.cassandra.core.mapping;

import static org.assertj.core.api.Assertions.*;

import java.util.EnumSet;

import org.junit.Test;

import com.datastax.driver.core.DataType.Name;

/**
 * Unit tests for {@link CassandraSimpleTypeHolder}.
 *
 * @author Mark Paluch
 */
public class CassandraSimpleTypeHolderUnitTests {

	@Test // DATACASS-488
	public void shouldResolveTypeNamesForAllPrimaryTypes() {

		EnumSet<Name> excluded = EnumSet.of(Name.CUSTOM, Name.MAP, Name.SET, Name.LIST, Name.UDT, Name.TUPLE);

		for (Name name : Name.values()) {

			if (excluded.contains(name)) {
				continue;
			}

			assertThat(CassandraSimpleTypeHolder.getDataTypeFor(name)).as("SimpleType for %s", name).isNotNull();
		}
	}
}
