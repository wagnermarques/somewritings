package etec.edu.br.firebasedatabase

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
import java.util.HashMap

// https://firebase.google.com/docs/reference/android/com/google/firebase/database/IgnoreExtraProperties
@IgnoreExtraProperties
data class Post(
    var uid: String? = "",
    var author: String? = "",
    var title: String? = "",
    var body: String? = "",
    var starCount: Int = 0,
    var stars: MutableMap<String, Boolean> = HashMap()
) {

    // https://stackoverflow.com/questions/51774621/when-why-should-i-use-firebase-exclude-annotation-on-methods
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "uid" to uid,
            "author" to author,
            "title" to title,
            "body" to body,
            "starCount" to starCount,
            "stars" to stars
        )
    }
    // [END post_to_map]
}