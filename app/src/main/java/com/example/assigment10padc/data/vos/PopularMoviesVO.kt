package com.example.assigment10padc.data.vos

import androidx.room.*

@Entity(tableName = "movie_popular",
    indices = [Index(value = ["pop_id"], unique = true)])
data class PopularMoviesVO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pk_id")
    val id:Int,
    @Embedded(prefix = "popular_")
    val movieVo: MovieVO
)