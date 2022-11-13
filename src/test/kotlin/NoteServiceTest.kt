import org.junit.Test
import kotlin.test.assertNotNull

class NoteServiceTest {
    @Test
    fun isIdtest(){
        val note1 = Note(
            1,
            3,
            "Title3",
            false,
            "Text3",
            155156165,
            15,
            46,
            "www",
            15,
            "wiki",
            13,
            45,
            "3",
            "2",
            arrayListOf(
                Comment(4, 23, 34, 54, "Привет1", 122433234, "guid", false),
                Comment(5, 23, 34, 54, "Привет2", 122433234, "guid", false),
                Comment(7, 23, 34, 54, "Привет3", 122433234, "guid", false)
            )
        )
        val testId = note1.id
        assertNotNull(testId)
    }

    @Test
    fun addCommentTest (){
        NoteService.addNote(Note(2,
            3,
            "Title3",
            false,
            "Text3",
            155156165,
            15,
            46,
            "www",
            15,
            "wiki",
            13,
            45,
            "3",
            "2"

        )
        )
        val c = NoteService.addComment(2,
            Comment(4, 23, 34, 54, "Привет1", 122433234, "guid", false))
        assertNotNull(c)

    }

    @Test(expected = NoteNotFoundException::class)

    fun deleteCommentNullNote() {

        NoteService.addNote(Note(
            1,
            3,
            "Title3",
            false,
            "Text3",
            155156165,
            15,
            46,
            "www",
            15,
            "wiki",
            13,
            45,
            "3",
            "2",
            arrayListOf(
                Comment(4, 23, 34, 54, "Привет1", 122433234, "guid", false),
                Comment(5, 23, 34, 54, "Привет2", 122433234, "guid", false),
                Comment(7, 23, 34, 54, "Привет3", 122433234, "guid", false)

        )))

        NoteService.deleteComment(88,6)

    }
}