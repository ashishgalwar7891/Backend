package com.example.c2.s3.mc1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document

public class Track {
    @Id
    private String trackId;
    private String trackName;
    private int trackRating;
    private TrackArtist trackArtist;
}
