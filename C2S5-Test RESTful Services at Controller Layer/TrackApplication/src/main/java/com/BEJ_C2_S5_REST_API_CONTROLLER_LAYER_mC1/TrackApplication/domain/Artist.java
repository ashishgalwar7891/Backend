package com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Artist {
    private String artistId;
    private String artistName;
}
