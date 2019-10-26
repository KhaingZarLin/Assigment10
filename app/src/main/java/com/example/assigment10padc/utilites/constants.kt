package com.example.assigment10padc.utilites

import com.example.assigment10padc.BuildConfig

const val IMAGE_PATH = "https://image.tmdb.org/t/p/w200"
const val DB_NAME = "movieDB"
const val BASE_URL = "https://api.themoviedb.org/3/"
const val Movie_API_KEY = BuildConfig.Movie_API_KEY
const val DUMMY_ACCESS_TOKEN="eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzNTQ5MTJkODQ1MzYwYmU2MzZlOThhMzA0OTY5ZmIxYyIsInN1YiI6IjVkOGYwZTFhNzliM2Q0MDAxNzhiZjZhZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Ca9QVkaJmwFMtzJV-97Ss-402Ryv1AR7cymxXb6UUn8"
const val CODE_RESPONSE_OK= 550
const val EM_NULL_EVENT_RESPONSE= ""
const val PARAM_PAGE = "page"
const val PARAM_QUERY = "query"
const val EM_NULL_RESPONSE = "Check the Internet Connection!"

const val GET_NOW_PLAYING="movie/now_playing?api_key=$Movie_API_KEY&language=en-US&page=1"
const val GET_POPULAR="${BASE_URL}movie/popular?api_key=$Movie_API_KEY&language=en-US&page=1"
const val Get_TOP_RATED="${BASE_URL}movie/top_rated?api_key=$Movie_API_KEY&language=en-US&page=1"
const val GET_UPCOMING="${BASE_URL}movie/upcoming?api_key=$Movie_API_KEY&language=en-US&page=1"
const val GET_MOVIE_DETAIL="${BASE_URL}movie/{{movie_id}}?api_key=$Movie_API_KEY&language=en-US"
const val GET_SIMILAR_MOVIE="${BASE_URL}movie/{{movie_id}}/similar?api_key=$Movie_API_KEY&language=en-US&page=1"
const val SEARCH_MOVIE="${BASE_URL}movie/{{movie_id}}/similar?api_key=$Movie_API_KEY&language=en-US&page=1"
const val Get_Movie_Videos="${BASE_URL}movie/{{movie_id}}/videos?api_key=3495fbca2612a77c31afe40405a6a4c4&language=en-US"






