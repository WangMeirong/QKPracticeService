package com.qk.practice.util;

import java.util.UUID;

public class UUIDGenerator {
    public static String getNewUUID() {
        return UUID.randomUUID().toString();
    }
}
