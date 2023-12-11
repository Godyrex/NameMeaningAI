package com.oussemaouakad.surpriseme.Story;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppConfigService {
    private double temperature = 0.9;
    private int topK = 50;
    private double topP=0.95;

}
