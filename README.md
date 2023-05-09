# CalcuTaylor
Android calculator project

This project was a semester project of mine for Android development. It's a calculator written in Java. The project uses two activity views, one for the main activity that functions as the base calculator and another that passes data through an intent to show the history of calculations performed using a recycler view anf adapter. There are mutiple classes and layouts used to accomplish this.

The calculations are performed in the Calculations class which also stores the results of each calculation. This class holds most of the logic for the main activity as it’s performing the important functionality of the calculator. Additionally, it holds the results of the calculation performed. The History activity and recycler view adapter work together to show the history of the app to the user via card views that the user can scroll through. This is something that I feel basic calculators lack and I felt like it was a nice addition to the project.

The res folder holds the layouts for both activities, card views, buttons, etc. needed to display the UI for the user. The app uses constraint layouts so that it has a similar feel from device to device. Additionally, the app uses animations where appropriate.
