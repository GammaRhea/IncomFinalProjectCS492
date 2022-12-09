# IncomFinalProjectCS492

Final Project for Conner Rhea for the incomplete grade in class CS 492.
A Simple Prototype for a quest tracker for the hit MMO by Square ENix Final Fantasy XIV.

New implementations:
Music: Implemented sound when booting the application as well as when selecting Jobs.
Nested Recyclerviews: Implemented a nested Recyclerview with another Recyclerview, and discovered that this is generally a mistake.
Mutliple API Calls: Implemented, but I feel as though I could have implemented it in a more sophisticated way.

Ultimately, I feel as though I probably could have done more, but I am pleased with the results I have accomplished this far being
one person with limited time. To That end, I have compiled some lessons learned thaat I can apply for future works.

Future Changes and Take-Aways:

Nesting a Recyclerview inside another Recyclerview is generally not a good idea, especially if they both scroll the same direction.
Due to the way Recyclerview's are handled, it makes interacting with the Child RecyclerView much more difficult. While I was trying
to implement this I read about using NestedScrollViews instead which allows a much cleaner interface with an internal RV. While I
was stubborn and decided not to change my implementation this late stage, I would in a future project.

Multiple API calls was doable, though I think I could have probably handled it more ellegantly within the repository by having
specific functions for it, for example on that takes a list of qID's and runs all those calls from the Service/Repo/ViewwModel
imstead of having to catch multiple calls with the fragment, which lead to some weirdness. Trying to catch multiple quests with
multiple observers caused duplications of quests and some other odd behavior with how it inserted into the RV. Additionally I should
have broken quests into their own fragments, it would have made my entire implementation much easier. A revision would definitely
go that route to simplify things for myself.

Playing Music in android is actually extremely easy and fun to mess with. It also can add a lot of character to even small interactions.
It was fun to just try different music files and hook them up, and with setting up the Job Icons it definitely made the application
feel more like something I was making. I think I might take a fresh crack at this project in my off time and try to implement some
of these changes, because I want to make this application for my friend to free him from spreadsheet hell when he's trying to complete
a multi-thousand hour MMO Game like a psychopath.

Regardless, while I feel like I failed on some fronts, I do also feel like I learned some important lessons to take with me for a new
project. I want to mess with mobile development some more and make some custom applcations, so I might jump back in (for fun this time)
and see if I can make some cool stuff.

Thank you for the second change Professor Hess, I apologize I pushed the timer to its limit, but I feel like I actually walked away with
some good lessons.
