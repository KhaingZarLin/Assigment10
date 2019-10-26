package com.example.assigment10padc.persistences

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.assigment10padc.data.vos.MovieVO
import com.example.assigment10padc.persistences.Daos.MovieDao
import com.example.assigment10padc.persistences.TypeConventers.GenreListTypeConverter
import com.example.assigment10padc.utilites.DB_NAME

@Database(
    entities = [MovieVO::class],
    version = 4,
    exportSchema = false
)
@TypeConverters(GenreListTypeConverter::class)
abstract class MovieDataBase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        private var instances: MovieDataBase? = null
        fun getInstance(context: Context): MovieDataBase {
            if (instances == null) {
                instances = Room.databaseBuilder(context, MovieDataBase::class.java, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration().build()
            }
            return instances!!
        }
    }

}