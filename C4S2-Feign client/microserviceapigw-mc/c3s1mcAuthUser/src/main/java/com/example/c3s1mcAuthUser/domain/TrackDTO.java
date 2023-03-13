package com.example.c3s1mcAuthUser.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackDTO {
    private String userName,trackId,trackName,trackRating;
}
