package com.example.c2.s3.mc1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TrackArtist {
    private String artistId;
    private String artistName;

}
