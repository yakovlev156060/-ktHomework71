import WallService.add
import WallService.update
import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun testAdd() {
        val testPost= Post(0,0,0,0,0,"",
            0,0,false,Comments(),Copyright(),
            Likes(),Reposts(),Views(),"post",0,emptyArray<Post>(),
            false,false,false,0,false,false,Donut(),0,null)
        val rezult=add(testPost)
        assertTrue(rezult.id!=0)
    }

    @Test
    fun updateExist() {
        val testPost= Post(0,0,0,0,0,"",
            0,0,false,Comments(),Copyright(),
            Likes(),Reposts(),Views(),"post",0,emptyArray<Post>(),
            false,false,false,0,false,false,Donut(),0,null)

        val rezult=update(testPost)
        assertFalse(rezult)

    }


    @Test
    fun updateNotExist() {
        val testPost2= Post(4,0,0,0,0,"",
            0,0,false,Comments(),Copyright(),
            Likes(),Reposts(),Views(),"post",0,emptyArray<Post>(),
            false,false,false,0,false,false,Donut(),0,null)

        val rezult=update(testPost2)
        assertFalse(rezult)
    }

    @Test
    fun trueComment() {
        val testComment=Comment(1,1,1,"true comment",Donut(),true,"",1)
        val rezult=WallService.createComment(testComment)
        assertTrue(rezult)
    }

    @Test(expected = WallService.PostNotFoundException::class)
    fun shouldThrow() {

        val testBadComment=Comment(1,111,1,"true comment",Donut(),true,"",1)

        val rezult=WallService.createComment(testBadComment)
    }
}