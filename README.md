# JavaFXCloner
This class (Cloner) is intended to provide a clone function for all javafx Node objects, just like the one inside C++ for instance. All you have to do is to use clone function and it will return the same object but with everything copied.

However, it supports most of the classes that delegate from the Node class, but not all of them! In the future more classes might be supported. In general, only the end classes are available to be cloned. Not only classes that inherit from the Node class are provided, there are other classes that are supported too like, TranslateTransition and FadeTransition. A list of all the classes that are supported until now: 

- Pane
- All the shapes classes except the 3D shapes
- Button
- Label
- All the classes that inherit from the Transition, in other words, Animation class also.
