package loginapp.example.fzlbpms.com.br.exampleloginapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class MyDatabaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "MyDatabase", null, 1) {
    companion object {
        private var instance: MyDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): MyDatabaseOpenHelper {
            if (instance == null) {
                instance = MyDatabaseOpenHelper(ctx.getApplicationContext())
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables
        db.createTable("Usuarios", true,
            "id" to INTEGER + PRIMARY_KEY + UNIQUE,
            "nome" to TEXT,
            "email" to TEXT,
            "login" to TEXT,
            "senha" to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable("Usuario", true)
    }
}

// Access property for Context
val Context.database: MyDatabaseOpenHelper get() = MyDatabaseOpenHelper.getInstance(getApplicationContext())