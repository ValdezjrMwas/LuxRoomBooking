package com.example.hotel.navigation

//import com.example.hotel.ui.theme.screens.clients.UpdateClientScreen
//import com.example.hotel.ui.theme.screens.clients.UpdateClientScreen
//import com.example.hotel.ui.theme.screens.clients.BookScreen
//import com.example.hotel.ui.theme.screens.book.UpdateClientScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hotel.ui.theme.screens.clients.AddClientScreen
import com.example.hotel.ui.theme.screens.clients.ThankYouScreen
import com.example.hotel.ui.theme.screens.clients.ViewClient
import com.example.hotel.ui.theme.screens.clients.ViewClientScreen
import com.example.hotel.ui.theme.screens.home.EntryScreen
import com.example.hotel.ui.theme.screens.home.HomeScreen
import com.example.hotel.ui.theme.screens.login.LoginScreen
import com.example.hotel.ui.theme.screens.register.RegisterScreen
import com.example.hotel.ui.theme.screens.rooms.AddRoomsScreen
import com.example.hotel.ui.theme.screens.rooms.UpdateRoomScreen
import com.example.hotel.ui.theme.screens.rooms.ViewRoomsScreen
import com.example.hotel.ui.theme.screens.rooms.ViewRoomsUser

@Composable
fun AppNavHost(modifier: Modifier= Modifier,
               navController: NavHostController= rememberNavController(),
               startDestination: String= Route_Entry) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Route_register) {
            RegisterScreen(navController)
        }
        composable(Route_login) {
            LoginScreen(navController)
        }
        composable(Route_home) {
            HomeScreen(navController)
        }
        composable(Route_book) {
            AddClientScreen(navController)
        }
        composable(Route_update) {
            UpdateClientScreen(navController)
        }
        composable(Route_view){
            ViewClientScreen(navController)
        }
        composable("$Route_view_client/{id}"){passedData ->
            ViewClient(navController, passedData.arguments?.getString("id")!!)
        }
        composable(Route_Entry){
            EntryScreen(navController)
        }
        composable(Route_add_rooms) {
            AddRoomsScreen(navController)
        }
        composable(Route_view_rooms) {
            ViewRoomsScreen(navController)
        }
        composable("$Route_update_rooms/{roomId}") {passedData->
            UpdateRoomScreen(navController, passedData.arguments?.getString("roomId")!!)
        }
        composable(Route_View_Rooms_User){
            ViewRoomsUser(navController)
        }
        composable(Route_Thanks){
            ThankYouScreen(navController)
        }

    }

}

@Composable
fun UpdateRoomScreen(navController: NavHostController, string: String) {
    TODO("Not yet implemented")
}

private fun <AnimatedContentScope> AnimatedContentScope.UpdateClientScreen(navController: NavHostController) {

}
