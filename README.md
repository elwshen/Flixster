# Project 1 - Flixster

Flixster shows the latest movies currently playing in theaters. The app utilizes the Movie Database API to display images and basic information about these movies to the user.

Time spent: ~13 hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **scroll through current movies** from the Movie Database API

The following **optional** features are implemented:

* [x] For each movie displayed, user can see the following details:
  * [x] Title, Poster Image, Overview (Portrait mode)
  * [x] Title, Backdrop Image, Overview (Landscape mode)
* [x] Layout is optimized with the [ViewHolder](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView#improving-performance-with-the-viewholder-pattern) pattern.
* [x] Display a nice default [placeholder graphic](http://guides.codepath.com/android/Displaying-Images-with-the-Picasso-Library#configuring-picasso) for each image during loading.
* [x] Allow user to view details of the movie including ratings and popularity within a separate activity or dialog fragment.
* [x] Improved the user interface by experimenting with styling and coloring.
* [ ] When viewing a popular movie (i.e. a movie voted for more than 5 stars) the video should show the full backdrop image as the layout.  Uses [Heterogenous ListViews](http://guides.codepath.com/android/Implementing-a-Heterogenous-ListView) to show different layouts.
* [x] Apply rounded corners for the poster or background images using [Picasso transformations](https://guides.codepath.com/android/Displaying-Images-with-the-Picasso-Library#other-transformations)
* [ ] Apply the popular [Butterknife annotation library](http://guides.codepath.com/android/Reducing-View-Boilerplate-with-Butterknife) to reduce boilerplate code.
* [ ] Allow video trailers to be played in full-screen using the YouTubePlayerView.
    * [ ] Overlay a play icon for videos that can be played.
    * [ ] More popular movies should start a separate activity that plays the video immediately.
    * [ ] Less popular videos rely on the detail page should show ratings and a YouTube preview.

The following **additional** features are implemented:

* [x] List anything else that you can get done to improve the app functionality!
    * [x] Swipe to refresh
    * [x] Overview text cut off after a certain number of characters in the main page to improve uniformity/appearance.

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='http://i.imgur.com/DhC6SOV.gif?1' title='Video Walkthrough Portrait' width='' alt='Video Walkthrough' />
<img src='http://i.imgur.com/iGDy7G6.gif?1' title='Video Walkthrough Landscape' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

The placeholder for loading images looks a little off because it's a different size from the loaded images.  When I researched solutions, it looked like other developers using Picasso had run into the same issue and it would be complicated to fix, so I opted to leave it alone for now.

## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Picasso](http://square.github.io/picasso/) - Image loading and caching library for Android

## License

    Copyright 2016 Elana Shen

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
