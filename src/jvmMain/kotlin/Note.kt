import Note.Type

data class Note(val title: String, val description: String, val type: Type) {
    enum class Type { TEXT, AUDIO }
}

val list = listOf(
    Note("Title 1", "Description 1", Type.TEXT),
    Note("Title 2", "Description 2", Type.TEXT),
    Note("Title 3", "Description 3", Type.TEXT),
    Note("Title 4", "Description 4", Type.AUDIO),
    Note("Title 5", "Description 5", Type.TEXT),
    Note("Title 6", "Description 6", Type.TEXT),
    Note("Title 7", "Description 7", Type.TEXT),
    Note("Title 8", "Description 8", Type.AUDIO),
    Note("Title 9", "Description 9", Type.TEXT),
    Note("Title 10", "Description 10", Type.TEXT)
)