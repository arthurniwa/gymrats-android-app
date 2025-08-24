package App.gymrats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material.icons.filled.Person



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TelaInicial()
        }
    }
}

@Composable
fun TelaInicial() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Black
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ){
            CabecalhoDoGrupo()
            Spacer(modifier = Modifier.height(8.dp))
            CartaoAtividade(
                titulo = "Treino teste",
                autor = "Arthur Niwa",
                hora = "11:30",
                imagePerfil = R.drawable.profile_image
            )
            Spacer(modifier = Modifier.height(8.dp))
            CartaoAtividade(
                titulo = "Treino de peito",
                autor = "Eduardo Rech",
                hora = "18:49",
                imagePerfil = R.drawable.profile_image
            )
            Spacer(modifier = Modifier.height(8.dp))
            CartaoAtividade(
                titulo = "Treino de Costas",
                autor = "Arthur Niwa",
                hora = "07:12",
                imagePerfil = R.drawable.profile_image
            )
        }
    }
}

@Composable
fun CartaoAtividade(

    titulo: String,
    autor: String,
    hora: String,
    imagePerfil: Int,
    iconeReacao: Int? = null
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        // MUDANÇA: Nova cor do card, mais escura
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2E2E2E))
    ) {

        Box(modifier = Modifier.padding(12.dp)) {
            Row(

                verticalAlignment = Alignment.Top
            ) {
                Image(
                    painter = painterResource(id = imagePerfil),
                    contentDescription = "Foto de Perfil",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(12.dp))


                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = titulo,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Autor",
                            modifier = Modifier.size(14.dp),
                            tint = Color.LightGray
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = autor,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.LightGray
                        )
                    }
                }


                Text(
                    text = hora,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.LightGray
                )
            }


            if (iconeReacao != null) {
                Image(
                    painter = painterResource(id = iconeReacao),
                    contentDescription = "Reação",
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.BottomEnd),
                    colorFilter = ColorFilter.tint(Color.Yellow)
                )
                }
            }
        }
    }
@Composable
fun CabecalhoDoGrupo(){
    Column(modifier = Modifier.padding(horizontal = 16.dp)){
    Text(
        text = "Grupo de Treino",
        style = MaterialTheme.typography.headlineLarge,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        modifier = Modifier.padding(vertical = 16.dp)
    )
        Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
        )
        {
        Image(
            painter = painterResource(id = R.drawable.pizza),
            contentDescription = "Banner do Grupo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(16.dp))
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
            ){
            InfoParticipante(
                imagem = R.drawable.profile_image,
                numero = "6",
                cargo = "Lider",

            )
            InfoParticipante(
                imagem = R.drawable.profile_image,
                numero = "6",
                cargo = "Lider"
            )
            }
        }
    }
}

@Composable
fun InfoParticipante(imagem: Int, numero: String, cargo: String){
    Row (verticalAlignment = Alignment.CenterVertically){
        Image(
            painter = painterResource( id = imagem),
            contentDescription = "Avatar do Participante",
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .border(BorderStroke(2.dp, Color.Black), CircleShape)
        )
        Spacer(Modifier.width(8.dp))
        Column {
            Text(
                text = numero,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = cargo,
                color = Color.LightGray,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewTelaCompleta(){
    TelaInicial()
}
