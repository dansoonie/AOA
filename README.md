# AOA
AOA stands for Annotation(s) for Organizing Activities. It's an Android library that lets you organize Activities in lists in a simple, easy, and decentralized fashion

##Introduction
The Android SDK documentation does relatively a nice job in documenting the API. However, some parts can be unclear by time to time to each individual. Moreover, it is often the case that you will have to use various parts of the SDK to carry out a desired task and it is hard to predict if something would work the way you expect it to just by reading the documentation.

The best way to clarify things is to experiment. I tend to create a project to experiment various situations and take incremental steps to implement a desired feature. When doing so, I organize my experimental Activities in a list(something like how the Android API Demo used to be organized).

I have been doing this for a while and tried to adopt a scheme that would make the task efficient.

## Characteristics and Features
- Decentralized organization: When seeing many Android projects that use some kind of list structure to organize Activities, you have to add something here and there when adding another Activity. AOA makes it possible to label where the Activity should be listed in the Activity class itself using annotation(s).
- Performance is not an issue: AOA was initially designed for testing so performance was not put into consideration. My first objective was to make the job of organizing list of activities easy and simple.
- Multiple depths: A list can have lists and your list structure can be organized into several depths.
- Minimal UI: Not much effort was put into UI but you can still distinguish list items and Activity items. Also, list items appear first in the list if any. 

## How to Use
### Understanding the entities
First take note of the following concept
- AoaItem: Basically any Activity you wish to put in a list is an AoaItem.
- AoaListActivity: The list that holds other Activities as items is an AoaListActivity.

### Creating a List
Create an Activity and make it inherit AoaListActivity.
For example, if you want to create a list to start with.
```
package com.dansoonie.example;

// import statements

public class RootListActivity extends AoaListActivity {
  // Nothing really reqruied but if there is something(such as overridden onCreate method) you can leave it
}
```

### Adding Acitivites to a List
#### If it's just an Activity
Create an Activity and add @AoaItem annotation in front of(or above) the class declaration. Add three parameters(parent, title, and description) to the annotation.
* parent: The Class name of the AoaListActivity the Activity is part of
* title: The title of your Activity which will appear in the list(parent)
* description: A simple description of your activity which will appear below the title of your activity in the list(parent)
For example, if you want to create an Activity named ActivityOne and make it appear in RootListActivity as an item represented with a title and a short description...
```
package com.dansoonie.example;

// import statements

@AoaItem (
  parent = "com.dansoonie.example.RootListActivity",
  title = "ActivityOne",
  description = "First item in Root List"
)
public class ActivityOne extends Activity { // Extend and implement whatever class and interfaces you need to
  // Whatever your activity does
}
```

#### If you want to add another list to a list
Create an Activity and annotate @AoaItem and provide the information for parent, title, and description. Also, the class should extend AoaListActivity.
For example, if you want to create a sub list in the root list with the name "Sub List"...
```
package com.dansoonie.example;

// import statements

@AoaItem (
  parent = "com.dansoonie.example.RootListActivity",
  title = "Sub List",
  description = "Another list of other Activities"
)
public class SubList extends AoaListActivity { // Extend and implement whatever class and interfaces you need to
  // Nothing really reqruied but if there is something(such as overridden onCreate method) you can leave it
}
```
For more detailed use example, refer to the sample project in the repository
