package loginapp.example.fzlbpms.com.br.exampleloginapp

import android.content.ContentValues
import android.content.Context
import java.util.*
import loginapp.example.fzlbpms.com.br.exampleloginapp.Usuario
import org.jetbrains.anko.db.classParser

import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.parseList
import org.jetbrains.anko.db.select


class UsuarioRepository(val context: Context) {

    fun findAll() : ArrayList<Usuario> {
        val usuarios = ArrayList<Usuario>()

        val readableDatabase = context.database.readableDatabase

        val select = readableDatabase.select(
            "Usuarios", "nome"
        )

//        select.exec {
//            //val rowParser = parseList(classParser())
//        }

//        select("Usuario", "id", "nome", "pass", "created")
//            .parseList(object: MapRowParser<List<Usuario>> {
//                override fun parseRow(columns: Map<String, Any?>): List<Usuario> {
//                    val id = columns.getValue("id")
//                    val nome = columns.getValue("nome")
//                    val pass = columns.getValue("pass")
//                    val created = columns.getValue("created")
//                    val u = Usuario(
//                            Integer.parseInt(id.toString()),
//                            nome.toString(),
//                            pass.toString(),
//                            Date(Date.parse(created)))
//
//                    UsuarioRepository.creationDate = dateFormatter.parse(creationDate.toString())
//
//                    notes.add(note)
//
//                    return notes
//                }
//            })
        return usuarios;
    }

    fun create(u: Usuario) {

//        val values = ContentValues()
//        values.put("nome",u.nome)
//        values.put("pass",u.pass)
//        values.put("email", u.email)
//        values.put("email", u.login)
//        values.put("created",Date().toString())
        try {
            val db = context.database.writableDatabase
            db.insert(
                "Usuarios",
                "id" to u.id,
                "nome" to u.nome,
                "email" to u.email,
                "senha" to u.pass
            )
            print("insert ok")
        }catch (e : Exception){
            e.printStackTrace()
            print(e.message)
        }
        //insert("Usuarios",null,values)
          //  )
//        insert("Usuarios",
//            "nome" to u.,
//            "content" to note.content,
//            "creationDate" to dateFormatter.format(note.creationDate))


    }

    fun update(u: Usuario) = context.database.use {

//        val updateResult = update("Usuarios",
//            "nome" to u.no,
//            "id" to u.id)
//            .whereArgs("id = {noteId}", "noteId" to note.id)
//            .exec()
//
//        Timber.d("Update result code is $updateResult")
    }

    fun delete(u: Usuario) = context.database.use {
//        delete(NOTES_TABLE_NAME, whereClause = "id = {noteId}", args = "noteId" to note.id)
    }
}