package com.paulograbin.sharedMemory;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class SharedMemoryVisualizer {
    public static void main(String[] args) throws Exception {
        byte byteA = 0;
        byte byteB = 0;
        byte byteC = 0;
        byte byteD = 0;

        try (RandomAccessFile file = new RandomAccessFile("shared_memory.dat", "r")) {
            byte[] buffer = new byte[250];
            file.read(buffer);
            System.out.println("File Content:");

            for (int i = 0; i < buffer.length; i++) {
                byte b = buffer[i];

                if (i == 200) {
                    byteA = b;
                }
                if (i == 201) {
                    byteB = b;
                }
                if (i == 202) {
                    byteC = b;
                }
                if (i == 203) {
                    byteD = b;
                }

                if (b != 0) {
                    System.out.println(i + "- " + b); // Assumes ASCII content
                }
            }

            ByteBuffer bb = ByteBuffer.wrap(new byte[]{byteA, byteB, byteC, byteD}).order(ByteOrder.LITTLE_ENDIAN);
            int value = bb.getInt();

            System.out.println("maX VALUE " + Integer.MAX_VALUE);
            if (value == Integer.MAX_VALUE) {
                System.out.println("Resultado is INT MAX VALUE");
            } else {
                System.out.println("Resultado: " + value);
            }
        }
    }
}
