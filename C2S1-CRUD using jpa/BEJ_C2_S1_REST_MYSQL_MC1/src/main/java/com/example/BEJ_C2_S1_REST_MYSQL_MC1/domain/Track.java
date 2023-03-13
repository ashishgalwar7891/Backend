package com.example.BEJ_C2_S1_REST_MYSQL_MC1.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Track {
    @Id
    String trackId;
    String trackName;
    String trackComments;
    String trackRating;
    String trackArtist;
}
