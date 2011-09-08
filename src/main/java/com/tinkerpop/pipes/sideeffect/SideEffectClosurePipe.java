package com.tinkerpop.pipes.sideeffect;

import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.PipeFunction;

/**
 * SideEffectClosurePipe will emit the incoming object, but compute the PipeFunction on S.
 * The result of the PipeFunction is not account for.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SideEffectClosurePipe<S> extends AbstractPipe<S, S> {

    private final PipeFunction<S, ?> function;

    public SideEffectClosurePipe(final PipeFunction<S, ?> function) {
        this.function = function;
    }

    public S processNextStart() {
        final S s = this.starts.next();
        this.function.compute(s);
        return s;
    }
}

