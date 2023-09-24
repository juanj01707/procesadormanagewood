package com.uco.managewood.procesadormanagewood.util;

public interface MessageSender<T> {
    void execute(T message, String idMessage);
}
