package dev.boysnberries.projectretrospection.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import dev.boysnberries.projectretrospection.data.database.entity.TextAnswer

@Dao
interface TextAnswerDao {
    @Query("select * from text_answers")
    fun getAll(): List<TextAnswer>

    @Query("select * from text_answers where record_id = :recordID")
    fun getByRecordID(recordID: Long): List<TextAnswer>

    @Query("select * from text_answers where question_id = :questionID")
    fun getByQuestionID(questionID: Long): List<TextAnswer>

    @Query("select * from text_answers where record_id = :recordID and question_id = :questionID")
    fun getByRecordIDAndQuestionID(recordID: Long, questionID: Long): List<TextAnswer>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(textAnswer: TextAnswer): Long
}
