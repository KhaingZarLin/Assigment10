package com.example.assigment10padc.data.vos

import androidx.room.*

@Entity(tableName = "movie_now_playing",
    indices = [Index(value = ["np_id"], unique = true)]
)
data class NowPlayingVO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pk_id")
    val id:Int,
    @Embedded(prefix = "nowplay_")
    val movieVo: MovieVO
)