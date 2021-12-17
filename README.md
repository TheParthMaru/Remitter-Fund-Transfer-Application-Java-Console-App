<h1> Remitter - Fund Transfer Application ( Console App )</h1>

<h2>Main Module</h2>

1. Admin Login
2. Remitter Login
3. Sign Up as new remitter
4. Exit

<h2>
    Admin Login Module
</h2>

- This module is only for admin.
- Admin will be asked to enter admin credentials that is username and password.
- For admin, ***username = admin***, ***password = admin***. (Easy to remember. It can be anything)
- These values have been added to the database manually while creating the **admin** table. You can add your own.
- When the admin enters his/her credentials, they are crosschecked with the admin credentials that already exists in database.
- After successful verification admin is able to log in.
- If the username and password do no match with the database, a message of ***Invalid credentials*** is displayed.

<h2>Admin Welcome Screen </h2>

- After successful login, the admin welcome screen is shown which also displays the admin operations that admin can perform.
- List of operations that admin can perform are as follows:
  1. Add account number
  2. Display all account numbers
  3. Display all existing remitters
  4. Search remitter
  5. Logout
- The admin operations are as follows:

1. **<u>Add account number</u>**

   - Here the admin can enter the account number of the remitter in **account_details** table.

   - The entered account number is first validated before inserting into the **account_details** table.

   - The account number must be of **5 digits only** i.e., from **10001 to 99999**.

   - If the account number is invalid a message is displayed as ***"Invalid account number. Account number should be of 5 digits."*** 

   - If the account number already exists in the "**account_details**" table, an exception is thrown displaying that "***Account number already exists. Failed to add account number***".

   - If account number is valid and doesn't already exists in **account_details**  table, then that account number is added to the "**account_details**" table with the message "***Account number added successfully***".

     

2. **<u>Display all existing account numbers</u>**

   - Here all the account numbers present in the **account_details** table will be displayed.

   - If no account numbers exists, then "***No records found***" message is displayed.

     

3. **<u>Display all existing remitters</u>**

   - Here the admin can view all the existing remitters.

   - This data is fetched from the **remitter** table.

   - If no remitter exists in the **remitter** table, then "***No records found***" message is displayed.

     

4. **<u>Search remitter</u>**

   - Here, the admin can search for remitter by entering is account number.

   - Make sure that account number is of 5 digits.

   - If not then message will be displayed ***"Invalid account number. Account number should be of 5 digits"***.

   - If the remitter with the entered account number exists, all his details will be displayed.

     

5. **<u>Logout</u>**

   - Admin can logout once he/she finishes performing the respective operations.

   - The main module welcome screen will be displayed after admin logout.

     

<h2> Remitter Login Module</h2>

- For remitter to login he will be asked to enter his ID that is remitter id and respective password.

- Both of the fields will be checked whether present in DB or not.

- If present remitter welcome screen will be displayed else ***remitter not found*** will be displayed.

- After successful login, welcome remitter screen will be displayed.

- Note that remitter id should be of 3 digits only i.e. from 101 to 999 which is a sequence generated in database when remitter has successfully registered.

- This id will be provided to the remitter after successful registration and will be displayed on screen for him to note down and login.

- After successful login the remitter can perform following list of operations:

  1. Beneficiary registration

  2. Fund transfer

  3. My transactions

  4. View all beneficiaries

  5. Add personal details

     1. Email (Validation provided)
     2. Mobile number (Validation provided should be 10 digits long)
     3. Address (Validations provided that it cannot have special characters other than , and whitespace)

  6. View personal details

  7. Update personal details

     1. Update email
     2. Update password
     3. Update mobile number
     4. Update address

  8. Update beneficiary's details

     1. Update name
     2. Update beneficiary's account status

  9. Delete beneficiary

  10. Logout

      

<h2>Sign Up As New Remitter Module</h2>

- The following fields are required while registration:

  1. Name (First name or full name with space in between first name and last name)
  2. Create Password
     - Password must consists of at least one lowercase alphabet [a-z]
     - Password must consists of at least one uppercase alphabet [A-Z]
     - Password must consists of at least one numeric [0-9]
     - Password must consists of at least one special character [@!#$%^&*]
     - Password should be minimum of 8 characters and maximum 16 characters long
  3. Account number
     - Must be 5 digits long and should exist in account_details table.
  4. Account type (savings/ salary/ current)
     - If account number are is any one of above it shows not valid.
  5. Account balance
     - For salary account you can have 0 balance account.
     - For savings account you need to have minimum balance of Rs 1000.
     - For current account you need to have minimum balance of Rs 3000.
     - If balance is not entered according to above requirements then shows invalid balance.

  - If all of the above fields are successfully validated, new remitter is successfully registered and his login id is also displayed for login process.
  - If account number is valid but it does not exists in account_details table or is already in use by another remitter then ***"Account number does not exists or already in use"*** message is displayed.

