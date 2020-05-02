/*
 * Copyright 2019 Immutables Authors and Contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.immutables.criteria.matcher;

import java.util.Optional;

/**
 * Intersection type between {@link OptionalValueMatcher} and {@link StringMatcher}
 * @param <R> root criteria type
 */
public interface OptionalStringMatcher<R> extends StringMatcher<R>, OptionalValueMatcher<R, String> {

  interface Self extends Template<Self, Void>, Disjunction<OptionalStringMatcher<Self>> {}

  interface Template<R, P> extends OptionalStringMatcher<R>, WithMatcher<R, Self>, NotMatcher<R, Self>, Projection<P>, Aggregation.ComparableTemplate<Optional<String>> {}

  /**
   * Similar to main {@link OptionalStringMatcher.Template} but with {@code @Nullable} projections and aggregations
   */
  interface NullableTemplate<R> extends OptionalStringMatcher<R>, WithMatcher<R, Self>, NotMatcher<R, Self>, Projection<String>, Aggregation.ComparableTemplate<String> {}

  @SuppressWarnings("unchecked")
  static <R> CriteriaCreator<R> creator() {
    class Local extends AbstractContextHolder implements Self {
      private Local(CriteriaContext context) {
        super(context);
      }
    }

    return ctx -> (R) new Local(ctx);
  }
}
