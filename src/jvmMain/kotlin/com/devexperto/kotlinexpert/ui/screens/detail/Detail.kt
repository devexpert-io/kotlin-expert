package com.devexperto.kotlinexpert.ui.screens.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devexperto.kotlinexpert.data.Note

@Composable
fun Detail(id: Long, onClose: () -> Unit) {

    var note by remember { mutableStateOf(Note("", "", Note.Type.TEXT, 2)) }

    Scaffold(
        topBar = {
            TopBar(
                note = note,
                onClose = onClose,
                onSave = onClose,
                onDelete = onClose
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(32.dp)
        ) {
            OutlinedTextField(
                value = note.title,
                onValueChange = { note = note.copy(title = it) },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Title") },
                maxLines = 1
            )
            TypeDropdown(
                value = note.type,
                onValueChange = { note = note.copy(type = it) },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = note.description,
                onValueChange = { note = note.copy(description = it) },
                label = { Text("Description") },
                modifier = Modifier.fillMaxWidth().weight(1f)
            )
        }
    }
}

@Composable
private fun TypeDropdown(value: Note.Type, onValueChange: (Note.Type) -> Unit, modifier: Modifier = Modifier) {

    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier, propagateMinConstraints = true) {
        OutlinedTextField(
            value = value.toString(),
            onValueChange = {},
            readOnly = true,
            label = { Text("Type") },
            trailingIcon = {
                IconButton(onClick = { expanded = true }) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Show note types")
                }
            }
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            Note.Type.values().forEach {
                DropdownMenuItem(onClick = { onValueChange(it); expanded = false }) {
                    Text(it.name)
                }
            }
        }
    }
}

@Composable
private fun TopBar(note: Note, onClose: () -> Unit, onSave: () -> Unit, onDelete: () -> Unit) {
    TopAppBar(
        title = { Text(note.title) },
        navigationIcon = {
            IconButton(onClick = onClose) {
                Icon(imageVector = Icons.Default.Close, contentDescription = "Close Detail")
            }
        },
        actions = {
            IconButton(onClick = onSave) {
                Icon(imageVector = Icons.Default.Save, contentDescription = "Save Note")
            }

            if (note.id != Note.NEW_NOTE) {
                IconButton(onClick = onDelete) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Note")
                }
            }
        }
    )
}
