package org.immutables.tests;

import org.immutables.value.Value;

public class RecordTest {

    @Value.Immutable
    public record Record1(String fieldName) {};
}
