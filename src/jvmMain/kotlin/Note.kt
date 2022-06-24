import Note.Type

data class Note(val title: String, val description: String, val type: Type) {
    enum class Type { TEXT, AUDIO }
}

fun getNotes(): List<Note> = (0..10).map {
    Note(
        "Title $it",
        "Description $it",
        if (it % 3 == 0) Type.AUDIO else Type.TEXT
    )
}