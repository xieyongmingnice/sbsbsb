	package com.xunyu.xunyu_smgp.util;

import com.google.common.base.Preconditions;

    public final class CommonUtil {

        public static byte[] ensureLength(byte array[], int minLength, int padding) {
            Preconditions.checkArgument(minLength >= 0, "Invalid minLength: %s", new Object[] { Integer.valueOf(minLength) });
            Preconditions.checkArgument(padding >= 0, "Invalid padding: %s", new Object[] { Integer.valueOf(padding) });
            if(array.length == minLength) {
                return array;
            }
            return array.length > minLength ? copyOf(array, minLength) : copyOf(array, minLength + padding);
        }

        private static byte[] copyOf(byte original[], int length) {
            byte copy[] = new byte[length];
            System.arraycopy(original, 0, copy, 0, Math.min(original.length, length));
            return copy;
        }

    }
