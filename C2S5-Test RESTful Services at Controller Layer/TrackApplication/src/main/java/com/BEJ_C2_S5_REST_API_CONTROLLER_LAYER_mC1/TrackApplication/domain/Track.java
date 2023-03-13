package com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_mC1.TrackApplication.domain;

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
    private Artist trackArtist;
}
