Welcome 

Steps to run this program:
	1. First add H2 dependency in pom.xml for database and various others.
	2. Start the project by doing Maven build and setting goals as package.
	3. Launch SpringBootApp.
	4. Run the required endpoints(refer endpoint section...)

NOTE: Input data has a desired selected format. Please enter accordingly.

ENDPOINTS:
	POST:localhost:8080/addproducts
		GO TO : BODY -> RAW -> JSON
		PROVIDE THE GIVEN DATA YOU WANT TO ADD ABOUT THE PRODUCT
		CLICK TO 'SEND' AND YOU WILL GET THE RESPONSE ABOUT THE SAVING OF DATA
		
	POST:localhost:8080/addcampaigns
		GO TO : BODY -> RAW -> JSON
		PROVIDE THE GIVEN DATA YOU WANT TO ADD ABOUT THE CAMPAIGN
		CLICK TO 'SEND' AND YOU WILL GET THE RESPONSE ABOUT THE SAVING OF DATA
		
	GET:localhost:8080/allproducts?pageNumber=0
		CLICK TO 'SEND' AND YOU WILL GET THE RESPONSE OF ALL THE PRODUCTS SAVED(CURRENT PRICE WILL BE UPDATED ACCORDING TO SAVED CAMPAIGNS) AND ACCORDING TO THE PAGE NUMBER PROVIDED
		
	GET:localhost:8080/allcampaigns
		CLICK TO 'SEND' AND YOU WILL GET THE RESPONSE OF ALL THE CAMPAIGNS SAVED(SORTED ACCORDING TO 'StartDate')
		
	GET:localhost:8080/{product_id}/price-history
		REPLACE 'product_id' WITH THE REQUIRED PRODUCT ID(Ex. localhost:8080/jeiu8f30/price-history )
		CLICK TO 'SEND' AND YOU WILL GET THE RESPONSE OF ALL THE HISTORY OF THAT PRODUCT
		
FLOW OF PROGRAM:
	1. CREATED THE REQUIRED ENTITIES, DAOS, SERVICES AND CONTROLLERS OF PRODUCT AND CAMPAIGN.
	2. CREATED CAMPAIGN DISCOUNT ENTITY FOR STORING VALUES AND IN ASSOCIATION WITH CAMPAIGN ENTITY.
	3. CREATED PRICECHANGE ENTITY, DAO, SERVICE AND CONTROLLER FOR STORING CHANGE IN PRICES OF PRODUCT WITH DATE.
	
HERE ARE SOME POSTMAN COLLECTIONS
1-
![image](https://github.com/KrishnayMishra/Sale-Management/assets/86675294/a99b2128-8148-4cd6-91a6-8835cac25cc8)

2-
![image](https://github.com/KrishnayMishra/Sale-Management/assets/86675294/106b7057-cd1f-4987-8ec9-578126a39872)

3-
![image](https://github.com/KrishnayMishra/Sale-Management/assets/86675294/fb08917b-e2c8-4dc5-8415-7fcef8c2703a)

4-
![image](https://github.com/KrishnayMishra/Sale-Management/assets/86675294/c50769bb-bed6-4f76-8160-6fddc2998bc5)

5-
![image](https://github.com/KrishnayMishra/Sale-Management/assets/86675294/6b4bffc1-8f24-4ae2-9f1c-f5e4f97671a6)






	
