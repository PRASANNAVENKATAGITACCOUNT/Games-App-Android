package com.example.games_app.uis.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.games_app.R
import com.example.games_app.ui.theme.FORGET_PASSWORD_COLOR
import com.example.games_app.ui.theme.LOGINBUTTONCOLOR
import com.example.games_app.ui.theme.SIGNUPCOLOR
import com.example.games_app.ui.theme.TicTacToeAppTheme

@Composable
fun LoginScreen() {
    var usernameOrEmail by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var rememberMe by remember {
        mutableStateOf(false)
    }
    Column(Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Column {
            LoginInputFields(
                usernameOrEmail = usernameOrEmail, onUsernameEmailChange = {usernameOrEmail=it},
                password =password, onPasswordChange = {password=it}
            )
            Row(Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .padding(start = 8.dp, end = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Row (
                    Modifier
                        .fillMaxWidth(0.5f)
                        .fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ){
                    Checkbox(
                        checked = rememberMe,
                        onCheckedChange = { rememberMe=it },
                    )
                    Text(
                        text = "Remember Me",
                        fontSize = 18.sp
                        )
                }
                Row(
                    Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "ForgotPassword ?",
                        Modifier.wrapContentWidth(),
                        style = TextStyle(
                            color= FORGET_PASSWORD_COLOR
                        ),
                        fontSize = 18.sp
                    )
                }



            }
            SignUpAndLoginSection(
                onClickSignUp = { },
                onClickLogin = { }
            )
            
        }
       
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginInputFields(usernameOrEmail:String, onUsernameEmailChange: (String)->Unit,
                     password:String, onPasswordChange:(String)->Unit ) {

    var eyeIcon by remember {
        mutableStateOf(0)
    }

    val eyeResource = when(eyeIcon) {
        0 -> R.drawable.passowrd_eye_open
        else -> R.drawable.password_eye_close
    }

    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.25f)
            .padding(start = 8.dp, end = 8.dp)
    ) {
        Text(
            text = "Login",
            fontSize = 40.sp
        )
        TextField(
            value = usernameOrEmail,
            onValueChange =onUsernameEmailChange,
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(5.dp),
            label = { Text(text = "Username/Email")},
            textStyle = TextStyle(
                color = Color.Black
            ),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent
            )

        )
        TextField(
            value = password,
            onValueChange = onPasswordChange,
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(5.dp),
            label = { Text(text = "Password") },
            textStyle = TextStyle(
                color = Color.Black
            ),
            trailingIcon = {
                IconButton(onClick = { eyeIcon = if(eyeIcon==0) 1 else 0 }) {
                    Icon(
                        painter = painterResource(id = eyeResource),
                        contentDescription = null
                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent
            )
        )
    }
}


@Composable
fun SignUpAndLoginSection(onClickSignUp:()->Unit, onClickLogin:()->Unit) {
    Spacer(modifier = Modifier.height(30.dp))
    Column(
        Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(top = 5.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ElevatedButton(
            onClick = onClickLogin,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(55.dp)
                .padding(2.dp),
            colors = ButtonColors(LOGINBUTTONCOLOR, Color.White, Color.Blue, Color.Blue)
            ) {
            Text(text = "Login")
        }
        ElevatedButton(
            onClick = onClickLogin ,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(55.dp)
                .padding(2.dp),
            colors = ButtonColors(SIGNUPCOLOR, Color.White, Color.Blue, Color.Blue)
            ) {
            Text(text = "Sign Up")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    TicTacToeAppTheme {
        LoginScreen()
    }
}