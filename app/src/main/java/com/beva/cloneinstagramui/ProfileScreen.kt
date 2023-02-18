package com.beva.cloneinstagramui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            name = "Beva is Me ^_<",
            modifier = Modifier
                .padding(12.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))

        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))

        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))

        HighlightSection(
            highlight = listOf(
                StoryHighlight(
                    image = painterResource(id = R.drawable.baseline_slow_motion_video_24),
                    text = "Youtube"
                ),
                StoryHighlight(
                    image = painterResource(id = R.drawable.baseline_slow_motion_video_24),
                    text = "Youtube"
                ),
                StoryHighlight(
                    image = painterResource(id = R.drawable.baseline_slow_motion_video_24),
                    text = "Youtube"
                ),
                StoryHighlight(
                    image = painterResource(id = R.drawable.baseline_slow_motion_video_24),
                    text = "Youtube"
                ),
                StoryHighlight(
                    image = painterResource(id = R.drawable.baseline_slow_motion_video_24),
                    text = "Youtube"
                ),
                StoryHighlight(
                    image = painterResource(id = R.drawable.baseline_slow_motion_video_24),
                    text = "Youtube"
                )
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        PostTabView(
            imageWithTexts = listOf(
                StoryHighlight(
                    image = painterResource(id = R.drawable.baseline_grid_on_24),
                    text = "Posts"
                ),
                StoryHighlight(
                    image = painterResource(id = R.drawable.baseline_whatshot_24),
                    text = "Reels"
                ),
                StoryHighlight(
                    image = painterResource(id = R.drawable.baseline_ondemand_video_24),
                    text = "IGTV"
                ),
                StoryHighlight(
                    image = painterResource(id = R.drawable.outline_folder_24),
                    text = "Profile"
                ),
            )
        ) {
            selectedTabIndex = it
        }
        when (selectedTabIndex) {
            0 -> PostSection(
                posts = listOf(
                    painterResource(id = R.drawable.outline_10k_24),
                    painterResource(id = R.drawable.baseline_2mp_24),
                    painterResource(id = R.drawable.baseline_14mp_24),
                    painterResource(id = R.drawable.outline_1k_plus_24),
                    painterResource(id = R.drawable.baseline_9mp_24),
                    painterResource(id = R.drawable.outline_8k_plus_24),
                    painterResource(id = R.drawable.outline_10k_24),
                    painterResource(id = R.drawable.baseline_2mp_24),
                    painterResource(id = R.drawable.baseline_14mp_24),
                    painterResource(id = R.drawable.outline_1k_plus_24),
                    painterResource(id = R.drawable.baseline_9mp_24),
                    painterResource(id = R.drawable.outline_8k_plus_24)
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }

    }
}

@Composable
fun TopBar(name: String, modifier: Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notification",
                tint = Color.Black,
                modifier = Modifier
                    .size(24.dp)
                    .offset((-24).dp, 0.dp)
            )
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }

    }
}

@Composable
fun ProfileSection(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundedImage(
                image = painterResource(id = R.drawable.icon__fbbf2f_______24x24),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StateSection(modifier = Modifier.weight(7f))
        }
        ProfileDescription(
            displayName = "Programming Beginner",
            description = "Justed Joined and Justed 30",
            url = "https://github.com/whatsurstory",
            followedBy = listOf("444", "R", "11111", "G"),
            otherCount = 34
        )
    }
}


@Composable
fun RoundedImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = "Profile Image",
        modifier = modifier
            .aspectRatio(
                1f, true
            )
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(2.dp)
            .clip(CircleShape)
            .background(Color.Black),
        colorFilter = ColorFilter.lighting(Color.Cyan, Color.Yellow)
    )
}

@Composable
fun StateSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileState("823", "Posts")
        ProfileState("567K", "Followers")
        ProfileState("149", "Following")
    }
}

@Composable
fun ProfileState(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = modifier.height(4.dp))
        Text(text = text)
    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp

    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed By ")
                    followedBy.forEachIndexed { index: Int, name: String ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) append(", ")
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}


@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {
    val minWidth = 95.dp
    val height = 30.dp

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .size(height)
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(6.dp)
    ) {
        if (text != null) {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.DarkGray
            )
        }
    }
}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlight: List<StoryHighlight>
) {
    LazyRow(modifier = modifier) {
        items(highlight.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                RoundedImage(
                    image = highlight[it].image,
                    modifier
                        .size(70.dp)
                        .padding(end = 2.dp)
                )
                Text(
                    text = highlight[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTexts: List<StoryHighlight>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    val inActiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.DarkGray,
        modifier = modifier
    ) {

        imageWithTexts.forEachIndexed { index, storyHighlight ->
            Tab(
                selected = selectedIndex == index,
                selectedContentColor = Color.DarkGray,
                unselectedContentColor = inActiveColor,
                onClick = {
                    selectedIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    painter = storyHighlight.image,
                    contentDescription = storyHighlight.text,
                    tint = if (selectedIndex == index) Color.DarkGray else inActiveColor,
                    modifier = modifier
                        .padding(10.dp)
                        .size(24.dp)
                )
            }
        }
    }
}

@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
            .scale(1.01f)
    ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
                    .background(Color.Yellow)
            )
        }
    }
}