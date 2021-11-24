package org.immutables.value.processor.meta;

import static com.google.testing.compile.Compiler.javac;

import com.google.testing.compile.Compilation;
import com.google.testing.compile.Compiler;
import com.google.testing.compile.JavaFileObjects;
import org.immutables.value.processor.Processor;

public final class CompilationHelpers {
    private CompilationHelpers() {}

    /** Create a new non-reusable compiler instance */
    public static Compiler compiler() {
        return javac().withProcessors(new Processor())
            ;
    }

    public static Compilation compileResource(String resource) {
        return compiler().compile(JavaFileObjects.forResource(resource));
    }
}
