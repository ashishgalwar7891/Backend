package com.MusicApplication.UserTrackServices.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Track {
    @Id
    private String trackId;
    private String trackName;
    private String genre;
    private List<String> artist;

}
