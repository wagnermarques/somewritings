package etec.edu.br.firebasedatabase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener



//https://kotlinlang.org/docs/tutorials/android-plugin.html
import kotlinx.android.synthetic.main.activity_main.postAuthor
import kotlinx.android.synthetic.main.activity_main.postATitle
import kotlinx.android.synthetic.main.activity_main.postBody
//import kotlinx.android.synthetic.main.activity_main.post


//import kotlinx.android.synthetic.main.include_post_text.view.postBody
//import kotlinx.android.synthetic.main.include_post_text.view.postTitle
//import kotlinx.android.synthetic.main.item_post.view.postNumStars
//import kotlinx.android.synthetic.main.item_post.view.star

class MainActivity : AppCompatActivity() {

    private lateFirebaseAuth ;
    private FirebaseUser mFirebaseUser;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    override fun onStart() {
        super.onStart()

        // Add value event listener to the post
        // [START post_value_event_listener]
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                val post = dataSnapshot.getValue(Post::class.java)
                // [START_EXCLUDE]
                post?.let {
                    postAuthor.text = it.author
                    //postTitle.text = it.title
                    postBody.text = it.body
                }
                Toast.makeText(baseContext,post.toString(),Toast.LENGTH_LONG).show()
                // [END_EXCLUDE]
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("info", "loadPost:onCancelled", databaseError.toException())
                // [START_EXCLUDE]
                Toast.makeText(baseContext, "Failed to load post.",
                    Toast.LENGTH_SHORT).show()
                // [END_EXCLUDE]
            }
        }
        //postReference.addValueEventListener(postListener)
        // [END post_value_event_listener]

        // Keep copy of post listener so we can remove it when app stops
        //this.postListener = postListener

        // Listen for comments
        //adapter = CommentAdapter(this, commentsReference)
        //recyclerPostComments.adapter = adapter
    }
}
