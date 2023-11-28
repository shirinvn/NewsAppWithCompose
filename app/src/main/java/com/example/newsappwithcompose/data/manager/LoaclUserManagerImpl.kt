package com.example.newsappwithcompose.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.newsappwithcompose.domain.manager.UserManager
import com.example.newsappwithcompose.util.Constants
import com.example.newsappwithcompose.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.prefs.Preferences

class LoaclUserManagerImpl (
    private val context: Context
):UserManager{
    override suspend fun saveAppEntry() {

        context.dataStore.edit { setting ->
            setting[PreferencesKeys.APP_ENTRY]= true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return  context.dataStore.data.map { prefernces->
            prefernces[PreferencesKeys.APP_ENTRY]?: false
        }
    }
}

private val Context.dataStore: DataStore<androidx.datastore.preferences.core.Preferences>
by preferencesDataStore(name = Constants.USER_SETTINGS)

private object PreferencesKeys{
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)

}