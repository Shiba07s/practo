package com.brandcit.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConsultationType {
    VIDEO("Video Consultation"),
    AUDIO("Audio Consultation"),
    IN_PERSON("In-Person Consultation");

    private final String displayName;
}