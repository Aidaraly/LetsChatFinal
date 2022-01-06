package com.aidaraly.letschat.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aidaraly.letschat.db.daos.ChatUserDao
import com.aidaraly.letschat.db.daos.GroupDao
import com.aidaraly.letschat.db.daos.GroupMessageDao
import com.aidaraly.letschat.db.daos.MessageDao
import com.aidaraly.letschat.db.data.ChatUser
import com.aidaraly.letschat.db.data.Group
import com.aidaraly.letschat.db.data.GroupMessage
import com.aidaraly.letschat.db.data.Message

@Database(entities = [ChatUser::class, Message::class,Group::class,GroupMessage::class],
    version = 1, exportSchema = false)
@TypeConverters(TypeConverter::class)
abstract class ChatUserDatabase : RoomDatabase()  {
    abstract fun getChatUserDao(): ChatUserDao
    abstract fun getMessageDao(): MessageDao
    abstract fun getGroupDao(): GroupDao
    abstract fun getGroupMessageDao(): GroupMessageDao
}