package com.example.newsappwithcompose.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.newsappwithcompose.domain.model.Source
import dagger.Provides

@ProvidedTypeConverter
class NewsTypeConvertor {
    @TypeConverter
    fun spurceToString(source: Source): String{
        return "${source.id},${source.name}"
    }

    @TypeConverter
    fun stringToSource(source: String) : Source{
        return source.split(",").let {
            souerceArray->
            Source(souerceArray[0], souerceArray[1])
        }
    }
}