package eteczl.edu.br.exampleloginapp2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class DBHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "dbteste", null, 1) {

    companion object {
        private var instance: DBHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): DBHelper {
            if (instance == null) {
                instance = DBHelper(ctx.getApplicationContext())
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables
        db.createTable(
            "Usuarios", true,
            "id" to INTEGER + PRIMARY_KEY,
                       "nome" to TEXT,
                       "email" to TEXT,
                       "pass" to TEXT,
                       "created" to TEXT,
                       "foto" to BLOB)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable("Usuarios", true)
    }
}

// Access property for Context
val Context.database: DBHelper get() = DBHelper.getInstance(getApplicationContext())