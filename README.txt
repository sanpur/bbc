1) This application is developed in TDD way, providing unit test for each unit of class

2) Integration test is provided that loads the real addressbook file, as well as the main application.

3) Please test the application by running all the tests under the project, they should all pass.
My github is having problems with Intellij, if any imports from maven are missing, please refresh the project with enable imports.

4) Run the main application from class com.gumtree.addressbook.main.AddressBookExplorerMain that shows the results.
I have not calculated the number of days between Bill and Paul but I trust the unit test provided so I presume it is correct 2862.

5) SimpleDataLoader- This is kind of Strategy that I wanted to implement as, hence the simple implementation for the IDataLoader interface. This can be any other
implementation depending on how we load & read the file, for eg, there could be other data in the address book like address itself in future so it can vary.
If using spring, this implementation can be injected from the XML file. Also it can be tested separately.






