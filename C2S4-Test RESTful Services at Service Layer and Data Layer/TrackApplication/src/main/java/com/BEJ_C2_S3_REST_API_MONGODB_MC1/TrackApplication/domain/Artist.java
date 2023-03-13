package com.BEJ_C2_S3_REST_API_MONGODB_MC1.TrackApplication.domain;

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
