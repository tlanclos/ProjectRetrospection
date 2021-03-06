/**
 * Created by Taylor Lanclos on 6/18/18
 */
package dev.boysnberries.projectretrospection.data.database.entity

import android.arch.persistence.room.*


@Entity(tableName = "category_buckets", foreignKeys = [
    ForeignKey(
            entity = Question::class,
            parentColumns = ["id"],
            childColumns = ["question_id"],
            onDelete = ForeignKey.NO_ACTION
    )
], indices = [
    Index(value = ["question_id"])
])
data class CategoryBucket(
        @PrimaryKey(autoGenerate = true) var id: Long?,
        @ColumnInfo(name = "question_id") var questionID: Long,
        @ColumnInfo(name = "allowed_value") var allowedValue: String,
        @ColumnInfo(name = "rank") var rank: Int?
) {
    companion object {
        fun default() = CategoryBucket(null, Long.MAX_VALUE, "", null)
    }
}
