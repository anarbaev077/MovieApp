package com.example.movieapp.data.remote

import com.example.movieapp.data.models.kinofy_data.KinofyResponseDataModel
import com.example.movieapp.data.models.kinofy_info_data.base_details.KinofyInfo
import com.example.movieapp.data.models.kinofy_search.search_model.KinofySearchModel
import com.example.movieapp.data.utils.Constants.GET_MOVIE_INFO
import com.example.movieapp.data.utils.Constants.GET_NOW_PLAYING_MOVIE
import com.example.movieapp.data.utils.Constants.GET_POPULAR_MOVIE
import com.example.movieapp.data.utils.Constants.GET_SEARCH
import com.example.movieapp.data.utils.Constants.GET_TOP_RATED_MOVIE
import com.example.movieapp.data.utils.Constants.GET_UPCOMING_MOVIE
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface KinofyService {

    @GET(GET_POPULAR_MOVIE)
    suspend fun getPopularMovie(
        @Query("language") language: String = "en",
    ): Response<KinofyResponseDataModel>

    @GET(GET_NOW_PLAYING_MOVIE)
    suspend fun getNowPlayingMovie(
        @Query("language") language: String = "en",
    ): Response<KinofyResponseDataModel>

    @GET(GET_SEARCH)
    suspend fun getKinofySearch(
        @Query("page") page: String = GET_SEARCH,
        @Query("page") searchQuery: String,
    ): Response<KinofySearchModel>

    @GET(GET_MOVIE_INFO)
    suspend fun getInfoKinofy(
        @Path("movie_id") movieId: Int
    ): Response<KinofyInfo>

    @GET(GET_UPCOMING_MOVIE)
    suspend fun getUpcomingMovie(
        @Query("language") language: String = "en",
    ): Response<KinofyResponseDataModel>

    @GET(GET_TOP_RATED_MOVIE)
    suspend fun getTopRatedMovie(
        @Query("language") language: String = "en",
    ): Response<KinofyResponseDataModel>
}