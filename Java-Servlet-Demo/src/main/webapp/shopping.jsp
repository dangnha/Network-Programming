<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shopping Cart</title>
</head>
<body>
    <h1>Welcome to the Shopping Cart</h1>
    
    <form action="shopping" method="post">
        Enter your name: <input type="text" name="uname"><br>
        Select items to add to your cart:
        <input type="checkbox" name="item" value="Item 1"> Item 1
        <input type="checkbox" name="item" value="Item 2"> Item 2
        <input type="checkbox" name="item" value="Item 3"> Item 3
        <br>
        <input type="submit" value="Add to Cart">
    </form>

    <!-- You can also display the items in the cart here -->
</body>
</html>
