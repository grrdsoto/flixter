package com.example.flixter.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    String posterPath;
    String title;
    String overview;
    Long voteAverage;

    public Movie(JSONObject movie) throws JSONException {
        posterPath = movie.getString("poster_path");
        title = movie.getString("title");
        overview = movie.getString("overview");
        voteAverage = movie.getLong("vote_average");
    }
    public static List<Movie> fromJSONarray(JSONArray movieJSONarray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for(int i = 0; i < movieJSONarray.length(); i++) {
            movies.add(new Movie(movieJSONarray.getJSONObject(i)));
        }
        return movies;

    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s" , posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public Long getVoteAverage() {
        return voteAverage;
    }
}
