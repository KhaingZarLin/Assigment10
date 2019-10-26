package com.example.assigment10padc.data.vos

import androidx.room.*

@Entity(tableName = "movie_top_rated",
    indices = [Index(value = ["tr_id"], unique = true)])
data class TopRateVO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pk_id")
    val id:Int,
    @Embedded(prefix = "toprate_")
    val movieVo: MovieVO
)