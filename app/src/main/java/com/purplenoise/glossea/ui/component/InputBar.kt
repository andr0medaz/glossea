package com.purplenoise.glossea.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.purplenoise.glossea.ui.component.atom.PrimaryButton
import com.purplenoise.glossea.ui.theme.CustomTheme

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = CustomTheme.colorScheme.primary,
    contentColor: Color = CustomTheme.colorScheme.primary,
    placeholder: String = "Enter text..."
) {
    Box(
        modifier = modifier
            .background(containerColor, RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .fillMaxWidth()
    ) {
        if (value.isEmpty()) {
            Text(
                text = placeholder,
                color = contentColor
            )
        }

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(
                fontSize = 16.sp,

            ),
            modifier = Modifier.fillMaxWidth(),
            cursorBrush = SolidColor(contentColor)

        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomTextFieldPreview() {
    CustomTheme{
        var text by remember { mutableStateOf("") }

        CustomTextField(
            value = text,
            onValueChange = { text = it },
            containerColor = CustomTheme.colorScheme.onPrimary,
            placeholder = "Masukkan nama"
        )
    }
}
