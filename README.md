# LinearLayout

## Lesson 2: Layouts
This is the second android project in [Udacity: Developing Android Apps with Kotlin course.](https://classroom.udacity.com/courses/ud9012)
- Basic of how to design app's UI with linear layout
- Use of basic views like TextView, EditText, Button and ImageView
- Introduced the concept of Data Binding 
- Implementing View Binding and Data Binding 

## Highlight from lesson 2:
### Data Binding 
#### View Binding (findViewById)
**_findViewById_** gets a refrence to views. Everytime we search for a view in this way, after it has been created or recreate. Android has to traverse the view hierarchy to find it for us at runtime. For a large view hierarchy this can take enough time that it can slow down the app for the user. 

We can solve this issue by using data binding. Data binding allows us to connect a layout to an activity or fragment at compile time.

The compiler generates a helper class called a binding class when the activity is created, so is an instance of that binding class. Then we can access the view through this generated binding class without any extra overhead. 

### How to enable data binding? 
Add below coe to **_build.gradle_** app level and synce the gradle file:
```
android {
    ...
    buildFeatures {
        dataBinding true
    }
}
```
Then add the **_layout_** tag to the XML file, along with the namespace declaration into the layout tag.
Now go to the .kt file and create a variable for the binding oject like show below:
```
private lateinit var binding: ActivityMainBinding
```

replace **_setContentView()_** with 
```
binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
```
now we can use binding.view_name instead of using **_findViewById_**.
We also need to use **_invalidateAll()_** method inorder to refresh the UI with new data.


### Data Binding Views and Data
We can bind view to a data class so that the data is directly availabe to the view.
We can create a class for out data, then we'll bind that data to our views. we do this by creating a data class. 
To let our layout know about the data, we create a data block in the XML file. 

```
<layout>
  <data>
    <variable
      name="dataClassName"
      type="com.example.android.location.of.dataClass.file"/>	
  </data>
</layout>
```
