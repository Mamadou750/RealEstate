package com.openclassrooms.realestatemanager.database.dao

import android.database.Cursor
import androidx.room.*
import com.openclassrooms.realestatemanager.models.Agent
import kotlinx.coroutines.flow.Flow

@Dao
interface AgentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAgent(agent: Agent)

    @Update
    suspend fun updateAgent(agent: Agent)

    @Delete
    suspend fun deleteAgent(agent: Agent)

    @Query("SELECT * FROM agent_table")
    fun getListAllAgents(): Flow<List<Agent>>

    @Query("SELECT * FROM agent_table WHERE agent_id= :id")
    fun getUserById(id: String): Flow<Agent?>

    /**
     * Content provider
     */
    @Query("SELECT * FROM agent_table WHERE agent_id= :id")
    fun getUserByIdWithCursor(id: String): Cursor


    /**
     * Only for test purpose
     */
    @Query("DELETE FROM agent_table")
    fun nukeTable()

}