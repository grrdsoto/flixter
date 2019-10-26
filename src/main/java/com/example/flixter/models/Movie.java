package com.example.flixter.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {
    int movieId;
    String posterPath;
    String title;
    String overview;
    String backdropPath;
    Double rating;

    public Movie(){}
    public Movie(JSONObject movie) throws JSONException {
        posterPath = movie.getString("poster_path");
        title = movie.getString("title");
        overview = movie.getString("overview");
        backdropPath = movie.getString("backdrop_path");
        rating = movie.getDouble("vote_average");
        movieId = movie.getInt("id");
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

    public double getRating() {
        return rating;
    }
    public String getBackdropPath() {
        return backdropPath;
    }

    public int getMovieId() {
        return movieId;
    }
}
