package br.com.cvj.discovr.ui.util.components.button.solid

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.cvj.discovr.ui.util.components.text.LabelLarge
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.ArrowLeft
import compose.icons.fontawesomeicons.solid.ArrowRight

enum class ButtonSolidType {
    FILLED_TONAL, ELEVATED, FILLED, OUTLINED
}

@Composable
fun ButtonSolid(
    text: String,
    buttonType: ButtonSolidType,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    textColor: Color = ButtonDefaults.buttonColors().contentColor,
    backgroundColor: Color = ButtonDefaults.buttonColors().containerColor,
    contentStart: @Composable (() -> Unit)? = null,
    contentEnd: @Composable (() -> Unit)? = null,
) {
    when (buttonType) {
        ButtonSolidType.FILLED_TONAL -> ButtonSolidFilledTonal(
            text,
            onClick,
            modifier,
            contentPadding,
            textColor,
            backgroundColor,
            contentStart,
            contentEnd,
        )

        ButtonSolidType.ELEVATED -> ButtonSolidElevated(
            text,
            onClick,
            modifier,
            contentPadding,
            textColor,
            backgroundColor,
            contentStart,
            contentEnd,
        )

        ButtonSolidType.FILLED -> ButtonSolidFilled(
            text,
            onClick,
            modifier,
            contentPadding,
            textColor,
            backgroundColor,
            contentStart,
            contentEnd,
        )

        ButtonSolidType.OUTLINED -> ButtonSolidOutlined(
            text,
            onClick,
            modifier,
            contentPadding,
            textColor,
            backgroundColor,
            contentStart,
            contentEnd,
        )
    }
}

@Composable
fun ButtonSolidFilledTonal(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    textColor: Color = ButtonDefaults.buttonColors().contentColor,
    backgroundColor: Color = ButtonDefaults.buttonColors().containerColor,
    contentStart: @Composable (() -> Unit)? = null,
    contentEnd: @Composable (() -> Unit)? = null,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        contentPadding = contentPadding,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor
        ),
    ) {
        contentStart?.let { content ->
            content()
        }

        LabelLarge(text = text, color = textColor)

        contentEnd?.let { content ->
            content()
        }
    }
}

@Composable
fun ButtonSolidElevated(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    textColor: Color = ButtonDefaults.buttonColors().contentColor,
    backgroundColor: Color = ButtonDefaults.buttonColors().containerColor,
    contentStart: @Composable (() -> Unit)? = null,
    contentEnd: @Composable (() -> Unit)? = null,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        contentPadding = contentPadding,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor
        ),
    ) {
        contentStart?.let { content ->
            content()
        }

        LabelLarge(text = text, color = textColor)

        contentEnd?.let { content ->
            content()
        }
    }
}

@Composable
fun ButtonSolidFilled(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    textColor: Color = ButtonDefaults.buttonColors().contentColor,
    backgroundColor: Color = ButtonDefaults.buttonColors().containerColor,
    contentStart: @Composable (() -> Unit)? = null,
    contentEnd: @Composable (() -> Unit)? = null,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        contentPadding = contentPadding,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = backgroundColor,
            contentColor = textColor
        ),
    ) {
        contentStart?.let { content ->
            content()
        }

        LabelLarge(text = text, color = textColor)

        contentEnd?.let { content ->
            content()
        }
    }
}

@Composable
fun ButtonSolidOutlined(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    textColor: Color = ButtonDefaults.buttonColors().contentColor,
    backgroundColor: Color = ButtonDefaults.buttonColors().containerColor,
    contentStart: @Composable (() -> Unit)? = null,
    contentEnd: @Composable (() -> Unit)? = null,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        contentPadding = contentPadding,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = backgroundColor,
            contentColor = textColor
        ),
    ) {
        contentStart?.let { content ->
            content()
        }

        LabelLarge(text = text, color = textColor)

        contentEnd?.let { content ->
            content()
        }
    }
}

@Preview
@Composable
fun ButtonSolidFilledTonalPreview() {
    ButtonSolidFilledTonal(
        text = "Filled Tonal Button",

        textColor = ButtonDefaults.buttonColors().contentColor,
        backgroundColor = ButtonDefaults.buttonColors().containerColor,
        onClick = {}
    )
}

@Preview
@Composable
fun ButtonSolidElevatedPreview() {
    ButtonSolidElevated(
        text = "Elevated Button",

        textColor = ButtonDefaults.buttonColors().contentColor,
        backgroundColor = ButtonDefaults.buttonColors().containerColor,
        onClick = {}
    )
}

@Preview
@Composable
fun ButtonSolidFilledPreview() {
    ButtonSolidFilled(
        text = "Filled Button",

        textColor = ButtonDefaults.buttonColors().contentColor,
        backgroundColor = ButtonDefaults.buttonColors().containerColor,
        onClick = {}
    )
}

@Preview
@Composable
fun ButtonSolidOutlinedPreview() {
    ButtonSolidOutlined(
        text = "Outlined Button",

        textColor = ButtonDefaults.buttonColors().contentColor,
        backgroundColor = ButtonDefaults.buttonColors().containerColor,
        onClick = {}
    )
}

@Preview
@Composable
fun ButtonSolidFilledTonalIconStartPreview() {
    ButtonSolidFilledTonal(
        text = "Filled Tonal Button",

        contentStart = {
            Icon(
                modifier = Modifier.size(12.dp),
                imageVector = FontAwesomeIcons.Solid.ArrowLeft,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.size(4.dp))
        },

        textColor = ButtonDefaults.buttonColors().contentColor,
        backgroundColor = ButtonDefaults.buttonColors().containerColor,
        onClick = {}
    )
}

@Preview
@Composable
fun ButtonSolidElevatedIconStartPreview() {
    ButtonSolidElevated(
        text = "Elevated Button",
        contentStart = {
            Icon(
                modifier = Modifier.size(12.dp),
                imageVector = FontAwesomeIcons.Solid.ArrowLeft,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.size(4.dp))
        },
        textColor = ButtonDefaults.buttonColors().contentColor,
        backgroundColor = ButtonDefaults.buttonColors().containerColor,
        onClick = {}
    )
}

@Preview
@Composable
fun ButtonSolidFilledIconStartPreview() {
    ButtonSolidFilled(
        text = "Filled Button",
        contentStart = {
            Icon(
                modifier = Modifier.size(12.dp),
                imageVector = FontAwesomeIcons.Solid.ArrowLeft,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.size(4.dp))
        },
        textColor = ButtonDefaults.buttonColors().contentColor,
        backgroundColor = ButtonDefaults.buttonColors().containerColor,
        onClick = {}
    )
}

@Preview
@Composable
fun ButtonSolidOutlinedIconStartPreview() {
    ButtonSolidOutlined(
        text = "Outlined Button",
        contentStart = {
            Icon(
                modifier = Modifier.size(12.dp),
                imageVector = FontAwesomeIcons.Solid.ArrowLeft,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.size(4.dp))
        },
        textColor = ButtonDefaults.buttonColors().contentColor,
        backgroundColor = ButtonDefaults.buttonColors().containerColor,
        onClick = {}
    )
}

@Preview
@Composable
fun ButtonSolidFilledTonalIconEndPreview() {
    ButtonSolidFilledTonal(
        text = "Filled Tonal Button",

        contentEnd = {
            Spacer(modifier = Modifier.size(4.dp))
            Icon(
                modifier = Modifier.size(12.dp),
                imageVector = FontAwesomeIcons.Solid.ArrowRight,
                contentDescription = ""
            )
        },

        textColor = ButtonDefaults.buttonColors().contentColor,
        backgroundColor = ButtonDefaults.buttonColors().containerColor,
        onClick = {}
    )
}

@Preview
@Composable
fun ButtonSolidElevatedIconEndPreview() {
    ButtonSolidElevated(
        text = "Elevated Button",
        contentEnd = {
            Spacer(modifier = Modifier.size(4.dp))
            Icon(
                modifier = Modifier.size(12.dp),
                imageVector = FontAwesomeIcons.Solid.ArrowRight,
                contentDescription = ""
            )
        },
        textColor = ButtonDefaults.buttonColors().contentColor,
        backgroundColor = ButtonDefaults.buttonColors().containerColor,
        onClick = {}
    )
}

@Preview
@Composable
fun ButtonSolidFilledIconEndPreview() {
    ButtonSolidFilled(
        text = "Filled Button",
        contentEnd = {
            Spacer(modifier = Modifier.size(4.dp))
            Icon(
                modifier = Modifier.size(12.dp),
                imageVector = FontAwesomeIcons.Solid.ArrowRight,
                contentDescription = ""
            )
        },
        textColor = ButtonDefaults.buttonColors().contentColor,
        backgroundColor = ButtonDefaults.buttonColors().containerColor,
        onClick = {}
    )
}

@Preview
@Composable
fun ButtonSolidOutlinedIconEndPreview() {
    ButtonSolidOutlined(
        text = "Outlined Button",
        contentEnd = {
            Spacer(modifier = Modifier.size(4.dp))
            Icon(
                modifier = Modifier.size(12.dp),
                imageVector = FontAwesomeIcons.Solid.ArrowRight,
                contentDescription = ""
            )
        },
        textColor = ButtonDefaults.buttonColors().contentColor,
        backgroundColor = ButtonDefaults.buttonColors().containerColor,
        onClick = {}
    )
}
