package com.platform.marketplace.Marketplace.Platform.consts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public enum EntranceType {
    FREE("безплатно"),
    PAID("платен");

    private String value;

    public String getValue() {
        return value;
    }
}
