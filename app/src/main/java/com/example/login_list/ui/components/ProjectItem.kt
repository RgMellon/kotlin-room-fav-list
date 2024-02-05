package com.example.login_list.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login_list.data.Project
import com.example.login_list.ui.theme.BLACK
import com.example.login_list.ui.theme.GRAY_50

@Composable
fun ProjectItem(project: Project, onFavProject: (project: Project) -> Unit = {}) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = GRAY_50
        ),
    ) {
        Row(
            Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                project.image?.let {
                    AsyncProjectImage(
                        it,
                        Modifier
                            .width(40.dp)
                            .height(40.dp)
                            .clip(RoundedCornerShape(100))
                    )
                }

                Column(modifier = Modifier.padding(start = 20.dp)) {
                    Text(

                        text = project.title,
                        fontSize = 14.sp,
                        color = BLACK,
                        fontWeight = FontWeight.Bold,
                    )

                    Text(
                        text = project.description,
                        fontSize = 14.sp,

                        )
                }

            }

            if (onFavProject != null) {
                Button(
                    onClick = { onFavProject(project) },
                    contentPadding = ButtonDefaults.ButtonWithIconContentPadding
                ) {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = "Localized description",
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                }
            }

        }
    }
}
