## BookStore Application:
### Summary:
BookStore Application displays the list of 50 books. All the books are fetched from a json file created by me. We can click on any of the book to get its information.
### Implementation:
### User Sign Up/ Sign In:
There is a sign in/up function in the very beginning of the application. The users are allowed to make an account. All the information of the user is stored in Firebase Database.

![Sign In Sing Up](https://user-images.githubusercontent.com/40909157/57182839-3c0adb80-6e59-11e9-81d2-e4b06b492b6f.png)

### BookListPage:
After the user is able to sign in/up we come across the list of all the books fetched from json file. The image of the book is displayed on left side with the help of Piccasso. The list view is obtained with the help of Recycler view. The name of the book is displayed next to the picture of the book.

![BookList](https://user-images.githubusercontent.com/40909157/57182838-37462780-6e59-11e9-846b-7faedc6c9816.png)

### Book Info Page:
Whenever you click on any of the book displayed in the Book List page, you will come across the Book info page where all the information of that book is displayed. There are 2 buttons at the end which are meant for asking whether to rent the book or to buy it.

![BookInfo](https://user-images.githubusercontent.com/40909157/57182834-30b7b000-6e59-11e9-95e9-b6e501007894.png)

### Third Party Libraries:
#### Picasso –
   Picasso is used to fetch image URL from the web and paste the pic to the desired location inside the application.
#### Groupie-
   Groupie makes the access of Recycler View easier because of easy implementation of adapter class using Groupie adapter.
#### Gson-
   Gson makes the fetching of Json files very easy and you can use the json file data effectively.
#### OkHttp-
   OkHttp allows you to access the web URL comprising of http's.
