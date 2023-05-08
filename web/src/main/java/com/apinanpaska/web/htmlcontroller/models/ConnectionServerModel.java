package com.apinanpaska.web.htmlcontroller.models;

public record ConnectionServerModel(
        int status,
        String ClientID,
        String roomID
) {
}
