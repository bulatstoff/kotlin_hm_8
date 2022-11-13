object NoteService {
    var store = mutableListOf<Note>()

    fun addNote(note: Note): MutableList<Note> {
        store.add(note)

        return this.store
    }
    fun deleteNote(noteId: Int) {
        if (!this.store.map { it -> it.id }.contains(noteId)) {
            throw NoteNotFoundException("Пост не найден")
        }
        for (note in store){
            if(note.id == noteId){
                note.isDeleted = true
            }
        }
    }
    fun restoreNote(noteId: Int) {
        if (!this.store.map { it -> it.id }.contains(noteId)) {
            throw NoteNotFoundException("Пост не найден")
        }
        for (note in store){
            if(note.id == noteId){
                note.isDeleted = false
            }
        }
    }
    fun editNote(noteId: Int, editedNote: Note){
        if (!this.store.map { it -> it.id }.contains(noteId)) {
            throw NoteNotFoundException("Пост не найден")
        }
        for(note in store){
            if (note.id == noteId){
                var noteIndex = store.indexOf(note)

                store[noteIndex] = editedNote
            }
        }
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
        if (!this.store.map { it -> it.id }.contains(noteId))  {
            throw NoteNotFoundException("Пост не найден")
        }
            if (this.store.map { it -> it.id }.contains(noteId)) {
            var note = store.find { it.id == noteId }
            if (note != null) {
                var comment = note.comments.find { it -> it.id == commentId }
                if (comment != null) {
                    comment.deleted = true
                    return
                }
                throw CommentNotFoundException("Комментарий не найден")
            }
        }
//        for(note in store){
//            if(note.id == noteId){
//                for(comment in note.comments) {
//                    if (comment.id == commentId) {
//                        comment.deleted= true
//                    }
//                }
//            }
//        }
    }


    fun editComment(noteId: Int,editedComment: Comment) {
        if (!this.store.map { it -> it.id }.contains(noteId)) {
            throw NoteNotFoundException("Пост не найден")
        }
        var commentId = editedComment.id
        if (this.store.map { it -> it.id }.contains(noteId)) {
            var note = store.find { it -> it.id == noteId }
            if (note != null) {
                var comment = note.comments.find { it -> it.id == commentId }
                var commentIndex = note.comments.indexOf(comment)
                if (comment != null && !comment.deleted) {
                    note.comments[commentIndex] = editedComment
                }
                if (comment == null) {
                    throw NoteNotFoundException("Коммент не найден")
                }
                if (comment.deleted) {
                    throw NoteNotFoundException("Вы пытаетесь редактировать удаленный комментарий")
                }
            }
        }
    }

        fun restoreComment(noteId: Int,commentId: Int) {
            if (!this.store.map { it -> it.id }.contains(noteId)) {
                throw NoteNotFoundException("Пост не найден")
            }
            if(this.store.map{it ->it.id}.contains(noteId)){
                var note = store.find { it->it.id == noteId }
                if(note!=null) {
                    var comment = note.comments.find { it -> it.id == commentId }
                    if(comment!=null ) {
                        comment.deleted = false
                    }
                    if (comment == null){
                        throw NoteNotFoundException("Коммент не найден")
                    }
                }
            }

//        for(note in store){
//            if(note.id==noteId){
//                for(comment in note.comments){
//                    if(comment.id==editedComment.id){
//                        var commentIndex = note.comments.indexOf(comment)
//                        note.comments[commentIndex] = editedComment
//                    }
//                }
//            }
//        }
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