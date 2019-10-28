package eteczl.edu.br.exampleloginapp2

import android.content.ContentValues
import android.content.Context
import eteczl.edu.br.exampleloginapp2.database
import org.jetbrains.anko.db.*
import java.util.*

class UsuarioRepository(val context: Context) {

    fun findAll() : ArrayList<Usuario> = context.database.use {
        val usuarios = ArrayList<Usuario>()

//        select("Usuarios").exec {
//            parseList(MapRowParser<List<Usuario>>{
//
//            })
//        }

        select("Usuarios", "id", "nome", "pass", "created")
            .parseList(object: MapRowParser<List<Usuario>> {
                override fun parseRow(columns: Map<String, Any?>): List<Usuario> {

                    var id = columns.getValue("id")
                    var nome = columns.getValue("nome")
                    var pass = columns.getValue("pass")
                    var created = columns.getValue("created")

                    var u = Usuario(
                        nome.toString(),
                        "teste@teste",
                        pass.toString())

                    usuarios.add(u)
                    return usuarios
                }
            })
        usuarios
    }

    fun create(u: Usuario) = context.database.use {

        val values = ContentValues()
        values.put("nome",u.nome)
        values.put("pass",u.pass)
        values.put("email", u.email)
        values.put("created",Date().toString())

        insert("Usuarios",null,values)
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