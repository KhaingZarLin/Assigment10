package com.example.assigment10padc.data.vos

import androidx.room.*

@Entity(tableName = "movie_upcoming",
    indices = [Index(value = ["upc_id"], unique = true)])
data class UpComingVO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pk_id")
    val id:Int,
    @Embedded(prefix = "upcome_")
    val movieVo: MovieVO
)