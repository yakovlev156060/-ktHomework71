fun main() {
}
object WallService{
    private var nextId=0
    private var posts = emptyArray<Post>()


    private var comments = emptyArray<Comment>()

    fun createComment(comment: Comment):Boolean {
        try {
            for((index,value) in posts.withIndex()){
                if(value.id==comment.postId){
                    comments+=comment
                    return true
                }
                else{
                    throw PostNotFoundException()
                }
            }
        }catch (e:PostNotFoundException){
            println(e.toString())
            return false
        }
        return true
    }

    internal class PostNotFoundException : Exception() {
        override fun toString(): String {
            return "PostNotFoundException"
        }
    }

    fun add(post: Post): Post {
        val newPost:Post=post.copy(nextId+1)
        posts+=newPost
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, value) in posts.withIndex()) {
            if (value.id == post.id) {
                posts[index] =
                    post.copy(ownerId = posts[index].ownerId, createdBy = posts[index].createdBy)
                return true
            }
        }
        return false
    }
}

interface Attachment{
    val type: String
}

public class AudioAttachment(
    override val type:String = "Audio",
    val audio: Audio=Audio(),
    val id: Int,
    val ownerId: Int,
    val artist:String,
    val title:String,
    val duration: Int,
    val lyricsId:String,
    val albumId: Int,
    val genreId: Int,
    val date: Int,
    val noSearch: Boolean,
    val isHq: Boolean

):Attachment{
}

public class PhotoAttachment(
    override val type:String = "Photo",
    val photo: Photo=Photo(),
    val id: Int,
    val albumId: Int,
    val userId: Int,
    val text:String,
    val date: Int,
    val width: Int,
    val height: Int
):Attachment{
}

public class PostedPhotoAttachment(
    override val type:String = "PostedPhoto",
    val postedPhoto: PostedPhoto=PostedPhoto(),
    val id: Int,
    val ownerId: Int,
    val photo_130:String,
    val photo_604:String
):Attachment{
}

public class WikiPageAttachment(
    override val type:String = "WikiPage",
    val wikiPage: WikiPage=WikiPage(),
    val id: Int,
    val groupId: Int,
    val title:String
):Attachment{
}

public class NoteAttachment(
    override val type:String = "Note",
    val note: Note=Note(),
    val id: Int,
    val ownerId: Int,
    val title:String,
    val text:String,
    val date: Int,
    val comments: Int,
    val readComments: Int,
    val viewUrl:String,
    val privacyView:String,
    val privacyComment:String,
    val canComment: Boolean,
    val textWiki:String,
):Attachment{
}

public class Audio(){

}

public class Photo(){

}

public class PostedPhoto(){

}

public class WikiPage(){

}

public class Note(){

}
public data class Comments(
    val count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canClose: Boolean = true,
    val canOpen: Boolean = true){
}

public data class Copyright(
    val link: String = "",
    val name: String = "",
    val type: String = ""){
}

public data class Likes(
    val count: Int = 0,
    val userLikes: Boolean = true,
    val canLike: Boolean = true,
    val canPublish: Boolean = true){
}

public data class Reposts(
    val count: Int = 0,
    val userReposted: Boolean = false){
}

public data class Views(
    val count: Int = 0){
}

public data class Donut(
    val isDonut: Boolean = true,
    val paidDuration: Int = 0,
    val placeholder: Placeholder = Placeholder(),
    val canPublishFreeCopy: Boolean = true,
    val editMode: String = ""){
}

public final class Placeholder(){

}