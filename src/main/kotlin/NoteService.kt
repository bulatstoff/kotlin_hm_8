object NoteService {
    var store = mutableListOf<Note>()

    fun addNote(note: Note): MutableList<Note> {
        store.add(note)

        return this.store
    }
    fun deleteNote(noteId: Int): MutableList<Note> {
        for (note in store){
            if(note.id == noteId){
                note.isDeleted = true
            }
        }

        return this.store
    }
    fun editNote(noteId: Int, editedNote: Note): MutableList<Note> {
        for(note in store){
            if (note.id == noteId){
                var noteIndex = store.indexOf(note)

                store[noteIndex] = editedNote
            }
        }

        return this.store
    }
    fun getAllNotes() :List<Note> {
        return this.store
    }
    fun getById(noteId: Int) : Note? {
        return store.find { it.id == noteId }
    }

    fun addComment(noteId: Int,comment: Comment) {
        for (note in store){
            if (noteId==note.id){
                note.comments?.add(comment)
            }
        }
    }

    fun deleteComment(noteId: Int,commentId:Int) {
        for(note in store){
            if(note.id == noteId){
                for(comment in note.comments) {
                    if (comment.id == commentId) {
                        var commentIndex = note.comments.indexOf(comment)
                        note.comments.removeAt(commentIndex)
                    }
                }
            }
        }
    }


    fun editComment(noteId: Int,editedComment: Comment) {
        for(note in store){
            if(note.id==noteId){
                for(comment in note.comments){
                    if(comment.id==editedComment.id){
                        var commentIndex = note.comments.indexOf(comment)
                        note.comments[commentIndex] = editedComment
                    }
                }
            }
        }
    }
    fun getComments(noteId: Int) : List<Comment>? {
        return store.find{ it.id === noteId}?.comments
    }
    fun printCollection() {
        println(store)
    }

    // реализовать стор из заметок
    // добавить все методы для работы с заметками
    // добавить все методы для работы с комментариями

}