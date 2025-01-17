package com.example.hotel.ui.theme.screens.clients

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hotel.data.ClientViewModel
import com.example.hotel.models.Client
import com.example.hotel.navigation.Route_Thanks
import com.example.hotel.navigation.Route_update
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@Composable
fun ViewClient(navController: NavHostController, id: String){
    val context = LocalContext.current
    val clientRepository = ClientViewModel(navController, context)
    val name by remember {
        mutableStateOf("")
    }
    val idnumber by remember {
        mutableStateOf("")
    }
    val tell by remember {
        mutableStateOf("")
    }
    val date by remember {
        mutableStateOf("")
    }
    val room by remember {
        mutableStateOf("")
    }
    var clientName by remember {
        mutableStateOf(TextFieldValue(name))
    }
    var clientId by remember {
        mutableStateOf(TextFieldValue(idnumber))
    }
    var clientTell by remember {
        mutableStateOf(TextFieldValue(tell))
    }
    var daysCount by remember {
        mutableStateOf(TextFieldValue(date))
    }
    var roomType by remember {
        mutableStateOf(TextFieldValue(room))
    }


    val currentDataRef = FirebaseDatabase.getInstance().getReference().child("Client/$id")
    currentDataRef.addValueEventListener(object: ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val client = snapshot.getValue(Client::class.java)
            clientName = TextFieldValue(client!!.name)
            clientId = TextFieldValue(client.idnumber)
            clientTell = TextFieldValue(client.tell)
            daysCount = TextFieldValue(client.date)
            roomType = TextFieldValue(client.room)

        }

        override fun onCancelled(error: DatabaseError) {
            Toast.makeText(context,error.message, Toast.LENGTH_SHORT).show()
        }
    } )


    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Card(modifier = Modifier.size(350.dp,450.dp).padding(10.dp)) {
            OutlinedTextField(
                   value = clientName,
                   onValueChange = {clientName = it},
                   label = {Text(text = "Client Name")}
            )
            OutlinedTextField(
                   value = clientId,
                   onValueChange = {clientId = it},
                   label = {Text(text = "Client Id")}
            )
            OutlinedTextField(
                   value = clientTell,
                   onValueChange = {clientTell = it},
                   label = {Text(text = "Client Tell")}
            )
            OutlinedTextField(
                   value = daysCount,
                   onValueChange = {daysCount = it},
                   label = {Text(text = "Date")}
            )
            OutlinedTextField(
                   value = roomType,
                   onValueChange = {roomType = it},
                   label = {Text(text = "Room Name")}
            )
            Row {
                Button(onClick = {
                    clientRepository.deleteClient(id)
                }) {
                       Text(text = "Cancel", color = Color.Red)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(onClick = {
                    navController.navigate(Route_update +"/$id")
                }) {
                       Text(text = "Update", color = Color.Green)
                }
                   Spacer(modifier = Modifier.width(10.dp))
                   Button(onClick = {
                       navController.navigate(Route_Thanks)
                   }) {
                       Text(text = "Confirm", color = Color.Cyan)
                   }
               }
           }
       }
}