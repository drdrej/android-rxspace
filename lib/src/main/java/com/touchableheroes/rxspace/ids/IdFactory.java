package com.touchableheroes.rxspace.ids;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by asiebert on 16.04.16.
 */
public class IdFactory {

    private AtomicInteger ID_STORE = new AtomicInteger(1);

    public static IdFactory create() {
        return new IdFactory();
    }

    public int uniqueInt() {
        return ID_STORE.incrementAndGet();
    }
}
