package org.immutables.tests;

import org.immutables.value.Value;

/** Record with @Value.Immutable annotation, expect compile error */
@Value.Immutable
public record ValueAnnotationOnRecord(String field) {};
