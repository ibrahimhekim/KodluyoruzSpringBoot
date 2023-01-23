package com.hekim.sosyalMedya.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Error {
    String errorDecs;

    public Error(String errorDecs) {
        this.errorDecs = errorDecs;
    }
}
