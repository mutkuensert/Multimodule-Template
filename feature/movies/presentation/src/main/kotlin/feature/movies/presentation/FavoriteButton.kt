package feature.movies.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    isFavorite: Boolean,
    onClick: () -> Unit
) {
    AnimatedContent(
        targetState = isFavorite,
        transitionSpec = {
            fadeIn(
                animationSpec = tween(easing = LinearEasing)
            ) + slideIntoContainer(
                animationSpec = tween(easing = EaseIn),
                towards = AnimatedContentTransitionScope.SlideDirection.Down
            ) togetherWith fadeOut(
                animationSpec = tween(easing = LinearEasing)
            ) + slideOutOfContainer(
                animationSpec = tween(easing = EaseOut),
                towards = AnimatedContentTransitionScope.SlideDirection.Down
            )
        },
        modifier = modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            )
            .size(35.dp),
        label = "Animated Content"
    ) { targetState ->
        if (targetState) {
            Icon(
                painter = painterResource(id = core.ui.R.drawable.ic_star_filled),
                contentDescription = null,
                tint = Color.Yellow
            )
        } else {
            Icon(
                painter = painterResource(id = core.ui.R.drawable.ic_star_unfilled),
                contentDescription = null,
                tint = Color.Yellow
            )
        }
    }
}