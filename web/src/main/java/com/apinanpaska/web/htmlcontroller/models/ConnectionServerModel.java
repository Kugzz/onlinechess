package com.apinanpaska.web.htmlcontroller.models;

public record ConnectionServerModel(
        Integer status,
        String clientID,
        String roomID
) {
}
