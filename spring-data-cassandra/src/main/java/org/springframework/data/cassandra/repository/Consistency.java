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
package org.springframework.data.cassandra.repository;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.data.annotation.QueryAnnotation;

import com.datastax.driver.core.ConsistencyLevel;

/**
 * Annotation to declare a {@link ConsistencyLevel} for queries using query methods.
 *
 * @author Mark Paluch
 * @since 2.0
 * @see org.springframework.data.cassandra.core.cql.QueryOptions
 */
@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@QueryAnnotation
public @interface Consistency {

	/**
	 * @return the {@link ConsistencyLevel} applied to the query executed using a query method.
	 */
	ConsistencyLevel value();
}