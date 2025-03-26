package com.paulograbin.offheap;

import java.lang.foreign.Arena;
import java.lang.foreign.ValueLayout;

//https://docs.oracle.com/en/java/javase/22/core/memory-layouts-and-structured-access.html
public class OffHeapExperiment {

    public static void main(String[] args) {
        try (Arena arena = Arena.ofConfined()) {

            var segment = arena.allocate((long) (2 * 4 * 10), 1);

            for (int i = 0; i < 10; i++) {
                segment.setAtIndex(ValueLayout.JAVA_INT, (i * 2), i); // x
                segment.setAtIndex(ValueLayout.JAVA_INT, (i * 2) + 1, i); // y
            }


            for (int i = 0; i < 10; i++) {
                int xVal = segment.getAtIndex(ValueLayout.JAVA_INT, (i * 2));
                int yVal = segment.getAtIndex(ValueLayout.JAVA_INT, (i * 2) + 1);
                System.out.println("(" + xVal + ", " + yVal + ")");
            }

        } // Off-heap memory is deallocated
    }


//    public static void main(String[] args) {
//        try (Arena arena = Arena.ofConfined()) {
//
//            SequenceLayout ptsLayout = MemoryLayout.sequenceLayout(10,
//                    MemoryLayout.structLayout(ValueLayout.JAVA_INT.withName("x"), ValueLayout.JAVA_INT.withName("y")));
//
//            VarHandle xHandle = ptsLayout.varHandle(MemoryLayout.PathElement.sequenceElement(), MemoryLayout.PathElement.groupElement("x"));
//            VarHandle yHandle = ptsLayout.varHandle(MemoryLayout.PathElement.sequenceElement(), MemoryLayout.PathElement.groupElement("y"));
//
//            MemorySegment segment = arena.allocate(ptsLayout);
//
//            for (int i = 0; i < ptsLayout.elementCount(); i++) {
//                xHandle.set(segment, (long) i, i);
//                yHandle.set(segment, (long) i, i);
//            }
//        }
//    }
}
