fun main() {
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
    val note2 = Note(
        2,
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

    var notesApp = NoteService

    notesApp.addNote(note1)
    //notesApp.deleteNote(1)
    notesApp.addNote(note2)

    notesApp.editNote(1, Note(
        1,
        3,
        "unitle",
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
    ))
  // notesApp.deleteNote(2)
   // notesApp.deleteComment(1,4)
    notesApp.editComment(1,Comment(4, 23, 34, 54, "ээх", 122433234, "nonono", false))

    notesApp.deleteNote(1)
    notesApp.printCollection()
    notesApp.restoreNote(1)
    notesApp.printCollection()


}

//data class Note(
//    var id: Int, //идентификатор заметки
//    val ownerId: Int, //owner_id integer Идентификатор владельца заметки.
//    //val title: String, //title string Заголовок заметки.
//    val text: String, //text string Текст заметки.
//   // val date: Int, //date integer Дата создания заметки в формате Unixtime.
//   // val comment: Int, //comments integer Количество комментариев.
//    //val readComment: Int, //read_comments integer Количество прочитанных комментариев (только при запросе информации о заметке текущего пользователя).
//    //val viewUrl: String, //view_url string URL страницы для отображения заметки.
//    //val canComment: Int, //can_comment integer Есть ли возможность оставлять комментарии
//    //val textWiki: String, //text_wiki string Тэги ссылок на wiki
//    //val privacy: Int, //privacy integer Уровень доступа к заметке
//    //Возможные значения:
//    //0 — все пользователи,
//    //1 — только друзья,
//    //2 — друзья и друзья друзей,
//    //3 — только пользователь.
//    //val commentPrivacy: Int, //comment_privacy integer Уровень доступа к комментированию заметки
//    //Возможные значения:
//    //0 — все пользователи,
//    //1 — только друзья,
//    //2 — друзья и друзья друзей,
//    //3 — только пользователь.
//   // val privacyView: String, //privacy_view string Настройки приватности просмотра заметки в специальном формате.
//    //val privacyComment: String, //privacy_comment string Настройки приватности комментирования заметки в специальном формате.
//    var comments: List<Comment>?//комментарии к заметкам
//)
//data class Comment(
//    var id: Int, //идентификатор комментария
//    var noteId: Int, //note_id positive Идентификатор заметки.
//    val ownerId: Int, //owner_id positive Идентификатор владельца заметки.
//    //val replyTo: Int, //reply_to positive Идентификатор пользователя, ответом на комментарий которого является добавляемый комментарий (не передаётся, если комментарий не является ответом).
//    var message: String, //message string Текст комментария.
//    //val date: Int, //date integer Дата создания комментария в формате Unixtime.
//    //val guid: String, //guid string Уникальный идентификатор, предназначенный для предотвращения повторной отправки одинакового комментария
//    var deleted: Boolean = false //идентификатор удаленного комментария, по умолчанию false
//)
//object NotesService{
//    private var notes = mutableListOf<Note>()
//    private var uniqueId: Int = 0
//    fun getAll(): MutableList<Note> = notes//Возвращает список заметок, созданных пользователем.
//    fun addNote(note: Note): Note //Создает новую заметку у текущего пользователя.
//    {
//        note.id = uniqueId //id присваивается автоматически
//
//        if (!note.comments.isNullOrEmpty()) {
//            var uniqueIdComment: Int = 0 //id комментариям присваивается автоматически
//            note.comments!!.forEach {
//                it.id = uniqueIdComment
//                it.noteId = note.id
//                uniqueIdComment += 1
//            }
//        }
//        notes.add(note)
//        uniqueId += 1
//        return note
//    }
//}
//data class Note(
//    var text:String
//){
//    private var id = 0
//    init{
//        id+=1
//    }
//    fun getId() = id
//}
//fun main (){
//    var storage: MutableMap<Note, String>> = mutableMapOf()
//
//    storage.
//}
//object NotesService(
//    var storage = emptyArray<Note>()
//fun add (notes:Notes) : Notes{
//
//}
//)