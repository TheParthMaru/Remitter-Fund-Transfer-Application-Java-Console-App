<h1> Remitter - Fund Transfer Application ( Console App )</h1>

<h2>Main Module</h2>

1. Admin Login
2. Remitter Login
3. New Remitter Sign Up
4. Exit

<h2>
    Admin Login Module
</h2>

- This module is only for admin.
- Admin will be asked to enter admin credentials that is username and password.
- For admin, ***username = admin***, ***password = admin***.
- These values have been added to the database manually while creating the **admin** table.
- When the admin enters his/her credentials, they are crosschecked with the admin credentials that already exists in database.
- After successful verification admin is able to log in.
- If the username and password do no match with the database, a message of invalid credentials is displayed.

<h2>Admin Welcome Screen </h2>

- After successful login, the admin welcome screen is shown which also displays the admin operations that he/she can perform.

- The admin operations are as follows:

  

  1. **<u>Add account number</u>**

     - Here the admin can enter the account number of the remitter in **account_details** table.
     - The entered account number is first validated before inserting into the **account_details** table.
     - If the account number is invalid a message is displayed as ***"Invalid account number. Account number should be of 5 digits."***
     - If the account number already exists in the "**account_details**" table, an exception is thrown displaying that "***Account number already exists. Failed to add account number***".
     - If account number is valid and doesn't exists in **account_details**  table, then that account number is added to the "**account_details**" table with the message "***Account number added successfully***".

     

  2. <u>**View all existing remitters**</u>

     - Here the admin can view all the existing remitters.
     - This data is fetched from the **remitter** table.
     - If no remitter exists in the **remitter** table, then "***No records found***" message is displayed.

     

  3. **<u>Search remitter</u>**

     - Here, the admin can search for remitter by entering is account number.
     - If the remitter with the entered account number exists, all his details will be displayed.
     - If the remitter's data doesn't exists, "***No records found***" will be displayed.

     

  4. <u>**Disable remitter**</u>

     - Functionality yet to be implemented.

       

  5. **<u>Logout</u>**

     - Admin can logout after performing operations.

     

<h2> Remitter Login Module</h2>

- For remitter to login he will be asked to enter his ID that is remitter id and respective password.

- Both of the fields will be checked whether present in DB or not.

- If present remitter welcome screen will be displayed else ***remitter not found*** will be displayed.

- After successful login, welcome remitter screen will be displayed.

  

  <h2>Welcome Remitter</h2>

  - Remitter can perform the following operations after logging in.

    

  1. Beneficiary Registration
     - 
  2. Fund Transfer
  3. Reports
  4. View all beneficiaries
  5. Add personal details
  6. View personal details
  7. Update personal details
  8. Update beneficiary's details
  9. Delete beneficiary
  10. Logout

  

  