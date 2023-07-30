PROJECT NAME :-
---------------
Product Search Web Application with Spring MVC and Hibernate
-------------------------------------------------------------

The Product Search Web Application is an advanced Java web application built using Spring MVC and Hibernate technologies, designed to assist customers in finding and purchasing T-shirts from popular brands like Nike, Puma, and Adidas. The application allows users to input their search criteria through a user-friendly web interface, and the search operations are performed on the database using Hibernate.

Key Features:

1.Web Application Interface: The web application provides a login page for user authentication. Upon successful login, users are directed to the Product Search Screen, where they can input their search parameters.

2.User Authentication: The application ensures secure access by requiring users to log in with their credentials. Only authenticated users can access the product search functionality.

3.Product Search Screen: The Product Search Screen allows users to input various search parameters, including color, size, gender, and output preference (sorting order by Price, Rating, or both). Users can customize their search to find the desired T-shirts easily.

4.CSV Data Source and Hibernate Integration: The application reads and parses T-shirt data from three CSV files, one for each brand (Nike, Puma, and Adidas). The data from these files is persisted in a relational database using Hibernate, ensuring efficient data storage and retrieval.

5.Dynamic CSV File Loading: The application is designed to handle additional CSV files for more brands or T-shirt data. A separate thread periodically checks for new files at a configurable location and loads the provided file into the database, allowing the system to adapt to new data sources without manual intervention.

6.Product Search and Display: Upon entering the search parameters, the application queries the database using Hibernate to find matching T-shirts based on color, size, gender, and output preference. The search results are displayed on the web interface, presenting relevant product details to the users.

7.Spring MVC and Spring-Hibernate Integration: The application leverages the Spring MVC framework for building the web application and integrating Spring with Hibernate for database connectivity and management. The tight integration ensures seamless data interaction and application flow.

8.User-Friendly Output: If no matching T-shirt is found for the given input, the application displays a user-friendly message on the screen, indicating that no products meet the specified criteria.

9.Exception Handling: The application includes comprehensive exception handling to gracefully handle unexpected scenarios and provide meaningful error messages to users when needed.

10.Spring Version: The project uses Spring version 3 or 4 for developing the web application, taking advantage of its powerful features and ease of use.

Overall, the Product Search Web Application with Spring and Hibernate offers an intuitive and secure platform for customers to search and purchase T-shirts from popular brands. Its seamless integration with Spring and Hibernate ensures efficient data management, while the dynamic CSV file loading and user-friendly interface enhance the overall user experience.

# Product-Search-Web-Application-spring-MVC
the Product Search Web Application with Spring and Hibernate offers an intuitive and secure platform for customers to search and purchase T-shirts from popular brands.  The dynamic CSV file loading and user-friendly interface enhance the overall user experience.

TECHNOLOGY USED :-
------------------
JAVA, HIBERNATE, SPRING MVC, MYSQL(DATABASE)

PROJECT SCREENSHOT :-
---------------------
LOGIN PAGE:-
<img width="898" alt="web app tshirt login page" src="https://github.com/satyam131/Product-Search-Web-Application-spring-MVC/assets/73646662/b9b8e592-0859-49d3-8056-e78252c614f2">


HOME PAGE :-
<img width="916" alt="web app tshirt home page" src="https://github.com/satyam131/Product-Search-Web-Application-spring-MVC/assets/73646662/202ce74c-649d-4546-97c2-12a2e8e0a5bb">
