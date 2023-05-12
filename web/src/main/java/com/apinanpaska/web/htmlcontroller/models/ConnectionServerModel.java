package com.apinanpaska.web.htmlcontroller.models;

public record ConnectionServerModel(
        Integer status,
        String ClientID,
        String roomID
) {
}
