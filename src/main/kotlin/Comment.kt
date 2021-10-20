public class Comment(
    val id:Int,
    val postId:Int,
    val date:Int,
    val text:String,
    val donut:Donut,
    val isDon:Boolean,
    val placeholder:String,
    val replyToComment:Int
){

}