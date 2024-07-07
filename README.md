# Secure Invoice and Customer Management System

## Requirements

### Application User
1. **User new account (Unique email address)**
    - Account verification (verify email address)
    - User profile image
    - User details (name, email, position, bio, **phone**, address, etc)
2. **User reset password (without being logged in)**
    - password reset link should expire within 24 hours
3. **User login (using email and password)**
    - Token based authentication (JWT)
    - Refresh token seamlessly
4. **Brute force mitigation (account lock mechanism)**
    - Lock account on 6th failed trial
5. **Role and Permission based Application Access (ACL)**
    - Protect application resources using roles and permissions
6. Two-Factor Authentication (using phone number or authenticator app)
    - Send verification code to user's phone
7. Keep track of user's activities (login, account change, etc.)
    - Ability to report suspicious activity
    - Tracking Information
        - IP Address
        - Device used
        - Browser
        - Date
        - Type
### Customers
1. **Customer Information**
    - Manage customer information (name, address, etc.)
    - customer can be an individual or an institution
    - Customer should have a **status**
    - Customer will have invoices
    - Print all customers in PDF
2. **Search Customers**
    - Be able to search a customer by name
    - Pagination
    - Sorting
### Invoices
1. **Manage Invoices**
    - create new invoices
    - Add invoices to customers
    - Print invoices for mailing
    - print invoices in excel/csv
    - Download Invoices as PDF
2. **.......**
